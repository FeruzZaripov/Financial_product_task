package com.example.financial_product_task.repository;

import com.example.financial_product_task.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByUserId(Long userId, Pageable pageable);

    Page<Transaction> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

}