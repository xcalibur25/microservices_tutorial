package com.yash.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	//here we are retreiving user and set of links back
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		//-------------HATEOAS------------------------
		//all users //serverpath+ "/users"
		//we need to add the link to the method retrieveAllUsers
		EntityModel<User> resource = EntityModel.of(user);
		//it enable us to create link from methods.For this call we are getting the link for retrieveAllUsers()
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		//adding link to resource.
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	//CREATED STATUS CODE 
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
		User savedUser=userDaoService.save(user);
		//sending user status and created url to client
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri(); 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
	}
	
	

}
