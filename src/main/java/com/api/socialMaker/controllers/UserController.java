package com.api.socialMaker.controllers;

import com.api.socialMaker.dto.LoginRequest;
import com.api.socialMaker.dto.UserProfileUpdateRequest;
import com.api.socialMaker.models.User;
import com.api.socialMaker.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.loginUser(loginRequest);

        return user.map(value -> ResponseEntity.ok("Giriş başarılı : Hoşgeldiniz " + value.getUserName())).orElseGet(() -> ResponseEntity.status(401).body("Giriş başarısız: Hatalı email veya şifre"));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserProfile(
            @PathVariable Long userId,
            @RequestBody UserProfileUpdateRequest userProfileUpdateRequest
            ) {
        userService.updateUserProfile(userId, userProfileUpdateRequest);
        return ResponseEntity.ok("Profil başarıyla güncellendi.");
    }
}
