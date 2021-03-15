package cs.roberto.transactions.presentation

import cs.roberto.transactions.domain.entity.Transaction
import cs.roberto.transactions.domain.entity.TransactionCategory
import cs.roberto.transactions.domain.entity.TransactionOperation
import cs.roberto.transactions.domain.entity.TransactionReport
import cs.roberto.transactions.domain.use_case.GetTransactionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.*

/** */
typealias TransactionCategoryWithPercent = Pair<TransactionCategory, Float>

/** */
class TransactionsManagerController(
    private val getTransactionsUseCase: GetTransactionsUseCase
) {

    /* */
    private val transactions: List<Transaction> by lazy {
        runBlocking(Dispatchers.IO) {
            getTransactionsUseCase.run()
        }
    }

    /** */
    fun getTransactionReports(): List<TransactionReport> {
        val transactionsByMonth: Map<Int, List<Transaction>> = getTransactionsByMonth()
        val response: ArrayList<TransactionReport> = arrayListOf()

        transactionsByMonth.entries.forEach {
            val month = it.key
            val transactions = it.value
            val transactionReport = TransactionReport(month, transactions)
            response.add(transactionReport)
        }

        return response
    }

    /** */
    private fun getTransactionsByMonth(): Map<Int, List<Transaction>> {
        val response: HashMap<Int, List<Transaction>> = hashMapOf()
        transactions.forEach {
            val month = it.creationDate.getCalendarMonth()
            if (response.containsKey(month)) {
                val updatedList = response[month]!! + it
                response[month] = updatedList
            } else response[month] = mutableListOf(it)
        }
        return response
    }

    /** */
    fun getHighestSpendingCategories(transactionReport: TransactionReport): List<TransactionCategoryWithPercent> {
        val groupedCategories: EnumMap<TransactionCategory, Float> = EnumMap(TransactionCategory::class.java)
        val doneOutcomeTransactions = transactionReport.doneTransactions
                .filter { it.operation == TransactionOperation.OUT }

        doneOutcomeTransactions.forEach {
            val currentValue: Float = groupedCategories[it.category] ?: 0f
            groupedCategories[it.category] = currentValue + it.amount
        }

        return groupedCategories.entries
            .filter { it.value > 0f }
            .sortedByDescending { it.value }
            .map { Pair(it.key, it.value * 100f / (transactionReport.totalOutcome) ) }
    }

    /** */
    private fun Date.getCalendarMonth(): Int =
        Calendar.getInstance().let {
            it.time = this
            it.get(Calendar.MONTH)
        }

}