package cs.roberto.transactions.data.dto

import cs.roberto.transactions.domain.entity.Transaction
import cs.roberto.transactions.domain.entity.TransactionCategory
import cs.roberto.transactions.domain.entity.TransactionOperation
import cs.roberto.transactions.domain.entity.TransactionStatus
import java.text.SimpleDateFormat
import java.util.*

/** */
data class TransactionDto(
    val uuid: String,
    val description: String,
    val category: String,
    val operation: String,
    val amount: Float,
    val status: String,
    val creation_date: String
) {

    /** */
    fun toTransaction(): Transaction =
        Transaction(
            uuid = uuid,
            description = description,
            creationDate = dateFromStringFormat(creation_date),
            amount = amount,
            category = TransactionCategory.fromStringValue(category),
            operation = TransactionOperation.fromStringValue(operation),
            status = TransactionStatus.fromStringValue(status)
        )

    /** */
    private fun dateFromStringFormat(value: String): Date =
        SimpleDateFormat("MM/dd/yyyy").parse(value)

}