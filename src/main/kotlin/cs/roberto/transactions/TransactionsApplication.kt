package cs.roberto.transactions

import cs.roberto.transactions.di.initKoin
import cs.roberto.transactions.presentation.TransactionsManager

/** */
fun main() {
    initKoin()
    val transactionsManager = TransactionsManager()
    transactionsManager.execute()
}
