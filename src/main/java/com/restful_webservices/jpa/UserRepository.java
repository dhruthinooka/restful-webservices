package com.restful_webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful_webservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
