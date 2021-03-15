package cs.roberto.transactions.presentation

import cs.roberto.transactions.domain.entity.TransactionCategory

/* */
val monthsEs = listOf(
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre"
)

/* */
val transactionCategoryName = mapOf(
    TransactionCategory.FOOD to "Alimentacion",
    TransactionCategory.HOME to "Hogar",
    TransactionCategory.ENTERTAINMENT to "Entretenimiento",
    TransactionCategory.SERVICES to "Servicios",
    TransactionCategory.TRANSFERS to "Transferencias",
    TransactionCategory.ATM_WITHDRAWALS to "Retiros en cajero",
    TransactionCategory.TRANSPORT to "Transporte",
    TransactionCategory.OTHERS to "Otros"
)