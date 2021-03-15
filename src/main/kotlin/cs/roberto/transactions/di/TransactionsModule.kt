package cs.roberto.transactions.di

import cs.roberto.transactions.data.TransactionsRepositoryImpl
import cs.roberto.transactions.domain.TransactionsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val transactionsModule: Module = module {

    /* */
    single<TransactionsRepository> {
        TransactionsRepositoryImpl()
    }

}