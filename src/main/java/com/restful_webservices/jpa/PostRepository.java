package com.restful_webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful_webservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
