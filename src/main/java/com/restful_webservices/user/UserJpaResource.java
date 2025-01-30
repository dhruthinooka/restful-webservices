package com.restful_webservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful_webservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
		
	private UserRepository repository;
	
	// Constructor Injection
	public UserJpaResource(UserRepository repository) {
		this.repository = repository;
	}
	
	// GET /jpa/users 
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	// GET /jpa/users/{id}
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		
		if (user.isEmpty()) 
			throw new UserNotFoundException("id:"+id);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		// To retrieve the path or url of a specific method 
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		//  To add the retrieved path as a link
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	

	// POST /jpa/users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	// DELETE /jpa/users/{id}
		@DeleteMapping("/jpa/users/{id}")
		public void deleteUser(@PathVariable int id) {
			repository.deleteById(id);

		}

}
