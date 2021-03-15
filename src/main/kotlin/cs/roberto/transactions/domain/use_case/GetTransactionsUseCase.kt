package cs.roberto.transactions.domain.use_case

import cs.roberto.transactions.domain.TransactionsRepository
import cs.roberto.transactions.domain.entity.Transaction

/** */
class GetTransactionsUseCase(
    private val transactionsRepository: TransactionsRepository
) {

    /** */
    suspend fun run(): List<Transaction> =
        transactionsRepository.getTransactions()

}