package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/user")
public class UserController {
    @Autowired
   private  UserService userService;
    @GetMapping("Feteching")
    public ResponseEntity<List<User>> getalldetailsofDogs(){
        return ResponseEntity.ok(userService.getalldetailsofdog());
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
