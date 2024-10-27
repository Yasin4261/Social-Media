package com.api.socialMaker.controllers;

import com.api.socialMaker.models.User;
import com.api.socialMaker.models.UserSearch;
import com.api.socialMaker.services.UserSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class UserSearchController {
    private final UserSearchService userSearchService;

    public UserSearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSearch>> searchUsers(@RequestParam("userName") String userName) {
        List<UserSearch> users = userSearchService.searchUsersByUsername(userName);

        return ResponseEntity.ok(users);
    }
}
