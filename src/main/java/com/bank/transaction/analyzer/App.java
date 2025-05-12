package com.bank.transaction.analyzer;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzer.analyzer(args[0], bankStatementParser);
    }
}
