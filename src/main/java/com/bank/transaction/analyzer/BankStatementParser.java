package com.bank.transaction.analyzer;

import java.util.List;

public interface BankStatementParser {
  BankTransaction parserFrom(String line);

  List<BankTransaction> parseLinesFrom(List<String> lines);
}
