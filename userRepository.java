package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface userRepository extends JpaRepository<User,Integer>{
 
	//Jpa ko query ho
	@Query("select u from User u where u.email=:email")
	public User getUserByUserName(@Param("email") String email);
}
