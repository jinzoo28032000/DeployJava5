package com.example.ass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ass.entities.Account;
import com.example.ass.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public void delete(Account account) {
		accountRepository.delete(account);
	}
}
