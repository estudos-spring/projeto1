package com.yan.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yan.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByNome(String nome);

}
