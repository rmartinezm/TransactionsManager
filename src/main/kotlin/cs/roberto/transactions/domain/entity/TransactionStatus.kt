package cs.roberto.transactions.domain.entity

/** */
enum class TransactionStatus {

    REJECTED,

    PENDING,

    DONE;

    /** */
    companion object {

        fun fromStringValue(value: String): TransactionStatus =
            when (value) {
                "rejected",
                "pending",
                "done" -> valueOf(value.toUpperCase())
                else -> error("Invalid transaction status")
            }

    }

}