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
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Daniel", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Corbett", LocalDate.now().minusYears(23)));
	}
	
	public List<User> findAll() {
		return users;
		
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

}
