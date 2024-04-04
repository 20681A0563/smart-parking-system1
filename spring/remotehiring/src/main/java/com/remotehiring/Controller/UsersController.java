package com.remotehiring.Controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;

import com.remotehiring.entities.Users;
import com.remotehiring.Services.UsersService;
import com.remotehiring.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.remotehiring.Services.MailService;

import freemarker.template.TemplateException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
	
	@Autowired
	private UsersService service;

	@Autowired
	private MailService mailservice;
	
	@GetMapping("/users")
	public List<Users> list(){
		return service.listAll();
	}

	@GetMapping("/users/{email}")
	public ResponseEntity<Users> get(@PathVariable String email) {
		try {
			Users users =  service.get(email);
			return new ResponseEntity<Users>(users,HttpStatus.OK);
		} catch(UserNotFoundException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleUserNotFoundException(UserNotFoundException ex) {
		return ex.getMessage();
	}
	
	@PostMapping("/users/signup")
	public ResponseEntity<Boolean> add(@RequestBody Users users) throws MessagingException, IOException, TemplateException {
		if(service.checkuser(users.getEmail()) == true) {
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
		else {
			service.save(users);
			mailservice.signupMail(users);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}	
	}
	
	@GetMapping("users/getname/{email}")
	public String getUser(@PathVariable String email) {
		String mail = service.get(email).getFullname();
		return mail;
	}
	
	@DeleteMapping("/users/{email}")
	public void delete(@PathVariable String email) {
		service.delete(email);
	}
	
	@PutMapping("users/{email}")
	public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable String email) {
		try {
			Users existUser = service.get(email); 
			System.out.print(existUser);
			service.save(users);
			return new ResponseEntity<Users>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND); 
		}
	}

	
	@PostMapping("users/login")
	public boolean check(@RequestBody Users users) {
		return service.checklogin(users.getEmail(), users.getPassword());
		
	}
	
	
}








