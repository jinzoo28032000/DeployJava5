package com.example.ass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ass.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account findByUsername(String username);

	public Account findByEmail(String email);

}
