package cs.roberto.transactions.presentation

import cs.roberto.transactions.domain.entity.TransactionReport
import org.koin.java.KoinJavaComponent.inject

/** */
class TransactionsManager {

    /* */
    private val transactionsManagerController by inject(TransactionsManagerController::class.java)

    /** */
    fun execute() {
        val transactionReports = transactionsManagerController.getTransactionReports()
        transactionReports.forEach(::printTransactionReport)
    }

    /** */
    private fun printTransactionReport(transactionReport: TransactionReport) {
        transactionReport.apply {
            val monthName = monthsEs[month]
            val pendingTransactionsCount = pendingTransactions.size
            val rejectedTransactionsCount = rejectedTransactions.size

            val categoriesWithPercent = transactionsManagerController
                .getHighestSpendingCategories(transactionReport)
                .asString()

            transactionReportStringFormat.format(
                monthName,
                pendingTransactionsCount,
                rejectedTransactionsCount,
                totalIncome,
                totalOutcome
            ).let { println(it + categoriesWithPercent) }
        }
    }

    /** */
    private val transactionReportStringFormat: String = """
        %s:
            %d transacciones pendientes
            %d bloqueadas
            
            $%.2f ingresos
            $%.2f gastos
    """.trimIndent()

    /** */
    private fun List<TransactionCategoryWithPercent>.asString(): String {
        var response: String = "\n\n"
        forEach { response += it.asString() }
        return response
    }

    /** */
    private fun TransactionCategoryWithPercent.asString(): String =
        "\t\t${transactionCategoryName[first]}    %${"%.1f".format(second)}\n"

}