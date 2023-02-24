package com.example.ass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ass.entities.Category;
import com.example.ass.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findByCategory(Category category);
}
