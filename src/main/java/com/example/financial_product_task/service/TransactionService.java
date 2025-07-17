package com.example.financial_product_task.service;

import com.example.financial_product_task.dto.TransactionRequestDto;
import com.example.financial_product_task.dto.TransactionResponseDto;
import com.example.financial_product_task.mapper.TransactionMapper;
import com.example.financial_product_task.model.Transaction;
import com.example.financial_product_task.model.User;
import com.example.financial_product_task.repository.TransactionRepository;
import com.example.financial_product_task.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public TransactionResponseDto createTransaction(TransactionRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Transaction transaction = transactionMapper.toEntity(dto);
        transaction.setUser(user);

        user.setBalance(user.getBalance().add(dto.amount()));
        userRepository.save(user);

        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    public Page<TransactionResponseDto> getByUser(Long userId, LocalDateTime from, LocalDateTime to, int page, int size) {
        Page<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        if (userId != null) {
            transactions = transactionRepository.findByUserId(userId, pageable);
        } else if (from != null && to != null) {
            transactions = transactionRepository.findByCreatedAtBetween(from, to, pageable);
        } else {
            transactions = transactionRepository.findAll(pageable);
        }

        return transactions.map(transactionMapper::toDto);
    }

}
