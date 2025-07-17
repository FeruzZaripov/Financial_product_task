package com.example.financial_product_task.initializer;

import com.example.financial_product_task.model.Transaction;
import com.example.financial_product_task.model.User;
import com.example.financial_product_task.repository.TransactionRepository;
import com.example.financial_product_task.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class MockDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public MockDataLoader(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) {
            return;
        }

        User alice = new User("Alice", "alice@example.com", new BigDecimal("1000"));
        User bob = new User("Bob", "bob@example.com", new BigDecimal("2000"));
        User charlie = new User("Charlie", "charlie@example.com", new BigDecimal("3000"));
        userRepository.saveAll(List.of(alice, bob, charlie));

        Transaction t1 = new Transaction(alice, new BigDecimal("100"), "money sent");
        Transaction t2 = new Transaction(bob, new BigDecimal("150"), "money sent");
        Transaction t3 = new Transaction(charlie, new BigDecimal("300"), "money sent");

        transactionRepository.saveAll(List.of(t1, t2, t3));
    }
}
