package cs.roberto.transactions.domain

import cs.roberto.transactions.domain.entity.Transaction

/** */
interface TransactionsRepository {

    /** */
    suspend fun getTransactions(): List<Transaction>

}