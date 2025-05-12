package com.bank.transaction.analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class App {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
    public static void main(String[] args)  throws IOException  {
       final String fileName = args[0];
       final Path path = Paths.get(RESOURCES + fileName);
       final List<String> lines = Files.readAllLines(path);

       List<BankTransaction> bankTransactions = bankStatementCSVParser.parserLinesFromCSV(lines);

       final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
       collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + 
            bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for transactions in January is " +
            bankStatementProcessor.selectInMonth(Month.JANUARY));

        System.out.println("The total salary received is " + 
            bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
