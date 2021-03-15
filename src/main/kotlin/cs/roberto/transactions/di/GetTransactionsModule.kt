package cs.roberto.transactions.di

import cs.roberto.transactions.domain.use_case.GetTransactionsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val getTransactionsModule: Module = module {

    single {
        GetTransactionsUseCase(
            transactionsRepository = get(),
        )
    }

}