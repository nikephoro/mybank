package org.idev.mybank.service;

import org.idev.mybank.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.E;

public class TransactionService {

    private final List<Transaction>  transactions = new CopyOnWriteArrayList<>();

    public Transaction createTransaction(Integer amount, String reference) {
        Transaction transaction = new Transaction(amount, reference);
        transaction.setId(parseInt(UUID.randomUUID().toString()));
        transaction.setTimestamp(LocalDateTime.now());
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAll() { return transactions; }

    public Transaction findById(Integer id) {
        for(Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        return new Transaction(0, "Transaction Not Found");
    }

//    public Optional<Transaction> findTransaction(Integer id) {
//        if (id == null) return Optional.empty();
//        return transactions.stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst();
//    }
}
