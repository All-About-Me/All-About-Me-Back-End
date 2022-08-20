package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Integer id) throws Exception{
		User user = userService.findById(id).orElseThrow(()->new Exception());
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/update")
    public ResponseEntity<User> updateProfile(@RequestBody User user, HttpSession session){
    	User u = (User) session.getAttribute("user");
    	u.setEmail(user.getEmail());
    	u.setFirstName(user.getFirstName());
    	u.setLastName(user.getLastName());
    	u.setAddress(user.getAddress());
    	u.setPhoneNumber(user.getPhoneNumber());
    	u.setGender(user.getGender());
    	u.setAboutMe(user.getAboutMe());
    	u.setCity(user.getCity());
    	u.setState(user.getState());
    	u.setPostalCode(user.getPostalCode());
    	User updatedUser = userService.save(u);
    	return ResponseEntity.ok().body(updatedUser);
    	
    }
}
