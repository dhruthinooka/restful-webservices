package com.restful_webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	// static user list
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Daniel", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Jim", LocalDate.now().minusYears(25)));
		users.add(new User(3, "Corbett", LocalDate.now().minusYears(23)));
	}
	
	public List<User> findAll() {
		return users;
		
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
		
	}

}
