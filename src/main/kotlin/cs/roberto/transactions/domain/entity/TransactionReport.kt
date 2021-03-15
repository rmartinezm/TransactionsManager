package cs.roberto.transactions.domain.entity

/** */
data class TransactionReport(
    val month: Int,
    val transactions: List<Transaction>,
) {

    /* */
    val doneTransactions: List<Transaction>
        get() = transactions.filter { it.status == TransactionStatus.DONE }

    /* */
    val pendingTransactions: List<Transaction>
        get() = transactions.filter { it.status == TransactionStatus.PENDING }

    /* */
    val rejectedTransactions: List<Transaction>
        get() = transactions.filter { it.status == TransactionStatus.REJECTED }

    /* */
    val totalIncome: Float
        get() = doneTransactions
            .filter { it.operation == TransactionOperation.IN }
            .reduceAmount()

    /* */
    val totalOutcome: Float
        get() = doneTransactions
            .filter { it.operation == TransactionOperation.OUT }
            .reduceAmount()

    /** */
    private fun List<Transaction>.reduceAmount(): Float {
        var response: Float = 0f
        forEach { response += it.amount }
        return response
    }

}