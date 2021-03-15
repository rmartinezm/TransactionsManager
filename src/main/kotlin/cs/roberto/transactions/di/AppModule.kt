package cs.roberto.transactions.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module

/** */
fun initKoin() {
    val applicationModules: List<Module> = listOf(
        transactionsModule,
        getTransactionsModule,
        transactionManagerModule,
    )
    startKoin {
        printLogger()
        modules(applicationModules)
    }
}