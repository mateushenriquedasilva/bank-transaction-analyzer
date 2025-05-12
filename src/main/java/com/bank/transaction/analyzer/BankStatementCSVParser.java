package com.bank.transaction.analyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
    private static final DateTimeFormatter DATE_PATTERN = 
        DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parserFromCSV(final String line) {
        final String[] colums = line.split(",");

        final LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);
        final double amount = Double.parseDouble(colums[1]);
        final String description = colums[2];

        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parserLinesFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines) {
            bankTransactions.add(parserFromCSV(line));
        }

        return bankTransactions;
    }
}