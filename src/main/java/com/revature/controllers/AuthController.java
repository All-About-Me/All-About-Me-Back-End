package com.revature.controllers;

import com.revature.dtos.LoginRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.dtos.SearchRequest;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        Optional<User> optional = authService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword());

        if(!optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("user", optional.get());

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.removeAttribute("user");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User created = new User(0,
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName());

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(created));
    }
    

    @GetMapping("/users/{firstName}") //mapping for search function
    public Optional<User> search(@PathVariable String firstName){
    	System.out.println(authService.findByfirstName(firstName)); //cookie tracing
    return authService.findByfirstName(firstName);
    }
    
    @GetMapping("/users/name/{lastName}") //mapping for search function
    public Optional<User> searchLastName(@PathVariable String lastName){
    	System.out.println(authService.findByfirstName(lastName)); //cookie tracing
    return authService.findBylastName(lastName);
    }
    
    @PutMapping("/resetPwd")
    public  ResponseEntity<User> resetPassword(@RequestBody User user, HttpSession session){
    	User u = (User) session.getAttribute("user");
    	u.setPassword(user.getPassword());
    	User updatedUser = userService.save(u);
    	return ResponseEntity.ok().body(updatedUser);
    	
    }
 }


    


