package cs.roberto.transactions.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import cs.roberto.transactions.data.dto.TransactionDto
import cs.roberto.transactions.domain.TransactionsRepository
import cs.roberto.transactions.domain.entity.Transaction
import java.io.*
import java.util.stream.Collectors

/* */
class TransactionsRepositoryImpl : TransactionsRepository {

    /** */
    override suspend fun getTransactions(): List<Transaction> {
        val jsonTransactions = getJsonTransactions()
        val gson = Gson()
        val transactionsDtoListType = object : TypeToken<List<TransactionDto>>() {}.type
        val transactionsDto: List<TransactionDto> = gson.fromJson(jsonTransactions, transactionsDtoListType)
        return transactionsDto.map(TransactionDto::toTransaction)
    }

    /** */
    private fun getJsonTransactions(): String? {
        val inputStream: InputStream = ClassLoader.getSystemClassLoader()
            .getResourceAsStream("raw/transactions.json") ?: return null
        val buffer = BufferedReader(InputStreamReader(inputStream))
        return buffer.lines().collect(Collectors.joining("\n"))
    }

}