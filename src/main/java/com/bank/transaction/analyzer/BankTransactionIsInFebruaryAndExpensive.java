package com.bank.transaction.analyzer;
import java.time.Month;

class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
           && bankTransaction.getAmount() >= 1_000;
    }
}
