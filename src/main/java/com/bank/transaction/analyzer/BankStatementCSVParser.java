package com.bank.transaction.analyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parserFrom(final String line) {
        final String[] colums = line.split(",");

        final LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);
        final double amount = Double.parseDouble(colums[1]);
        final String description = colums[2];

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parserFrom(line));
        }

        return bankTransactions;
    }
}