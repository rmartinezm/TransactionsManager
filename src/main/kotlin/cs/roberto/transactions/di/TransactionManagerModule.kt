package cs.roberto.transactions.di

import cs.roberto.transactions.presentation.TransactionsManagerController
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val transactionManagerModule: Module = module {

    single {
        TransactionsManagerController(
            getTransactionsUseCase = get(),
        )
    }

}