package com.ats.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.entity.UserDetailsEntity;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsEntity, Serializable> {

	@Query("SELECT ude FROM UserDetailsEntity ude WHERE ude.email = :email AND ude.password = :password")
	UserDetailsEntity exists(@Param("email")String email,@Param("password")String password);
	
	@Query("SELECT ude FROM UserDetailsEntity ude WHERE ude.email = :email")
	UserDetailsEntity checkEmail(@Param("email")String email);

}
