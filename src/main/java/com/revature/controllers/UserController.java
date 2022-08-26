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
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:3600"}, allowCredentials = "true")
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
    	if (!user.getEmail().isEmpty()) u.setEmail(user.getEmail());
    	if (!user.getFirstName().isEmpty()) u.setFirstName(user.getFirstName());
    	if (!user.getLastName().isEmpty()) u.setLastName(user.getLastName());
    	if (!user.getAddress().isEmpty()) u.setAddress(user.getAddress());
    	if (!user.getPhoneNumber().isEmpty()) u.setPhoneNumber(user.getPhoneNumber());
    	if (user.getGender()!=null) u.setGender(user.getGender());
    	if (!user.getAboutMe().isEmpty()) u.setAboutMe(user.getAboutMe());
    	if (!user.getCity().isEmpty()) u.setCity(user.getCity());
    	if (!user.getState().isEmpty()) u.setState(user.getState());
    	if (user.getPostalCode()!=null) u.setPostalCode(user.getPostalCode());
    	User updatedUser = userService.save(u);
    	return ResponseEntity.ok().body(updatedUser);
    	
    }
}
