package com.example.ass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ass.entities.Category;
import com.example.ass.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired 
	CategoryRepository categoryRepository;
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public void delete(Category category) {
		categoryRepository.delete(category);
	}
}
