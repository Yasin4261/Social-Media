package com.api.socialMaker.services;

import com.api.socialMaker.models.User;
import com.api.socialMaker.models.UserSearch;
import com.api.socialMaker.repositories.UserSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    private UserSearchRepository userSearchRepository;

    public UserSearchService(UserSearchRepository userSearchRepository) {
        this.userSearchRepository = userSearchRepository;
    }

    public List<UserSearch> searchUsersByUsername(String userName) {
        return userSearchRepository.findByUserNameContainingOrFullNameContaining(userName);
    }

}
