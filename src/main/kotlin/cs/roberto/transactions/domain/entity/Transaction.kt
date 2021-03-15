package cs.roberto.transactions.domain.entity

import java.util.*

/** */
data class Transaction(
    val uuid: String,
    val description: String,
    val creationDate: Date,
    val amount: Float,
    val category: TransactionCategory,
    val operation: TransactionOperation,
    val status: TransactionStatus
)