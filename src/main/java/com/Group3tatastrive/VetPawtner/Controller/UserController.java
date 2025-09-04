package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
   private  UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ Login User
    /*@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedInUser.isPresent()) {
            return ResponseEntity.ok(loggedInUser.get());
        } else {
            return ResponseEntity.status(401).body("Invalid email or password ❌");
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());

        // If frontend sends email in username field, it will still work because we check both
        if (loggedInUser.isPresent()) {
            return ResponseEntity.ok(loggedInUser.get());
        } else {
            return ResponseEntity.status(401).body("Invalid username/email or password ❌");
        }
    }



    /*@GetMapping("all")
    public ResponseEntity<List<User>> getalldetailsofDogs(){
        return ResponseEntity.ok(userService.getalldetailsofdog());
    }*/

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> insertalldetailsofdog(@RequestBody User user){
        return ResponseEntity.ok((userService.Insertalldetailsifdog(user)));
    }
    @PutMapping("{id}")
    public ResponseEntity<User> Updatealldetails(@PathVariable Integer id, @RequestBody User user){
        return ResponseEntity.ok(userService.updatealldetails(id, user));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<User> deletealldetails(@PathVariable Integer id){
        return ResponseEntity.ok(userService.deletealldetails(id));
    }



}
