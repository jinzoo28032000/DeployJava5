package com.example.ass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ass.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
