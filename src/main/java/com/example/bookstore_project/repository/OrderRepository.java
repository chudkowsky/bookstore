package com.example.bookstore_project.repository;

import com.example.bookstore_project.model.Order;
import com.example.bookstore_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
