package org.idev.mybank.service;

import org.idev.mybank.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    private final UserService userService;

    public TransactionService(UserService userService) {
        this.userService = userService;
    }

    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public Transaction createTransaction(Double amount, String reference,String userId) {
        if (!userService.containsUser(userId) ) return new Transaction(0.0, "User not Found");
        Transaction transaction = new Transaction(amount, reference);
        transaction.setId(UUID.randomUUID().toString());
        transaction.setTimestamp(LocalDateTime.now());
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction findById(String id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        return new Transaction(0.0, "Transaction Not Found");
    }
}

