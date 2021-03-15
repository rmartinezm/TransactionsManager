package cs.roberto.transactions.domain.entity

/** */
enum class TransactionOperation {

    IN,

    OUT;

    /** */
    companion object {

        /** */
        fun fromStringValue(value: String): TransactionOperation =
            when (value) {
                "in",
                "out" -> valueOf(value.toUpperCase())
                else -> error("Invalid transaction operation")
            }

    }

}