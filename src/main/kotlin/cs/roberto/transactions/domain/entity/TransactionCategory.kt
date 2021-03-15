package cs.roberto.transactions.domain.entity

/** */
enum class TransactionCategory {

    FOOD,

    HOME,

    ENTERTAINMENT,

    SERVICES,

    TRANSFERS,

    ATM_WITHDRAWALS,

    TRANSPORT,

    OTHERS;

    /** */
    companion object {

        /** */
        fun fromStringValue(value: String): TransactionCategory =
            when (value) {
                "Alimentacion" -> FOOD
                "Hogar" -> HOME
                "Entretenimiento" -> ENTERTAINMENT
                "Servicios" -> SERVICES
                "Transferencias" -> TRANSFERS
                "Retiros en cajero" -> ATM_WITHDRAWALS
                "Transporte" -> TRANSPORT
                "Otros" -> OTHERS
                else -> error("Invalid transaction category")
            }

    }

}