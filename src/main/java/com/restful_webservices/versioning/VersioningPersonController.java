package com.restful_webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	 
	@GetMapping("/v1/person") 
	public PersonV1 getFirstVersionOfPerson(){
		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person") 
	public PersonV2 getSecondVersionOfPerson(){
		
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/person", params = "version=1") 
	public PersonV1 getFirstVersionOfPersonRequestParam(){
		
		return new PersonV1("Bob Charlie v1");
	}

	@GetMapping(path = "/person", params = "version=2") 
	public PersonV2 getSecondVersionOfPersonRequestParam(){
		
		return new PersonV2(new Name("Bob v2", "Charlie v2"));
	}
	
}
