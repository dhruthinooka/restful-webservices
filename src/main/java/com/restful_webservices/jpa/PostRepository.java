package com.restful_webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restful_webservices.user.Post;
import com.restful_webservices.user.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	@Query("SELECT p FROM Post p WHERE p.user = ?1 and p.id = ?2")
	Post getSpecificPostOfUser(User user, Integer post_id);

}
