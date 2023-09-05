package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User,Integer> {
//Use : inherited method : List<User> findAll() 
//user inherited method : 	<s extends T> S save(S entity)
}
