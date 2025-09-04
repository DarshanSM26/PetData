package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

  /*  public List<User> getalldetailsofdog() {
        return userRepository.findAll();
    }*/

    public User Insertalldetailsifdog(User user) {
        return userRepository.save(user);
    }

    public User updatealldetails(Integer id, User user) {
        User user1 = userRepository.findById(id).orElse(null);

        user1.setUsername(user.getUsername());
        user1.setEmail((user.getEmail()));
        user1.setPassword(user.getPassword());
        user1.setUserphone(user.getUserphone());
        user1.setUseraddress(user.getUseraddress());
        user1.setRole(User.Role.user);
        return userRepository.save(user1);

    }

    public User deletealldetails(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }


    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String usernameOrEmail, String password) {
        // return userRepository.findByEmailAndPassword(email, password);
        // Try to find by username first
        Optional<User> user = userRepository.findByUsername(usernameOrEmail);

        // If not found, try email
        if (user.isEmpty()) {
            user = userRepository.findByEmail(usernameOrEmail);
        }

        // If found and password matches
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }

        return Optional.empty();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}