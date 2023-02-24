package com.example.ass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ass.entities.Order;
import com.example.ass.entities.OrderDetail;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
	public List<OrderDetail> findByOrder(Order order);
}
