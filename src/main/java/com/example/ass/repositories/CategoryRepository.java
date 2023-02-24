package com.example.ass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ass.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
