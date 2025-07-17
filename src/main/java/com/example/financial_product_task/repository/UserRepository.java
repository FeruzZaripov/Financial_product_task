package com.example.financial_product_task.repository;

import com.example.financial_product_task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}