package org.idev.mybank.service;

import org.idev.mybank.model.Transaction;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionService {

    public Transaction createTransaction(Integer amount, String reference) {
        Transaction transaction = new Transaction(amount, reference);
        transaction.setId(UUID.randomUUID().toString());
        transaction.setTimestamp(LocalDateTime.now());
        return transaction;
    }
}
