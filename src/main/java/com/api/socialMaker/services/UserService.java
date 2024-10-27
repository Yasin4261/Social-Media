package com.api.socialMaker.services;

import com.api.socialMaker.dto.LoginRequest;
import com.api.socialMaker.dto.PostDTO;
import com.api.socialMaker.dto.UserDTO;
import com.api.socialMaker.dto.UserProfileUpdateRequest;
import com.api.socialMaker.models.User;
import com.api.socialMaker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO save(User user) {
        User savedUser = userRepository.save(user);
        return convertToUserDTO(savedUser);
    }

    public Optional<UserDTO> loginUser(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginRequest.getPassword())) {
            return userOpt.map(this::convertToUserDTO);
        }

        return Optional.empty();
    }

    public void updateUserProfile(Long userId, UserProfileUpdateRequest userProfileUpdateRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        user.setFullName(userProfileUpdateRequest.getFullName());
        user.setBio(userProfileUpdateRequest.getBio());
        user.setProfilePictureUrl(userProfileUpdateRequest.getProfilePictureUrl());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    private UserDTO convertToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .posts(user.getPosts().stream()
                        .map(post -> new PostDTO(post.getId(), post.getContent(), post.getImageUrl(), post.getCreatedAt(), post.getUpdatedAt()))
                        .collect(Collectors.toList()))
                .build();
    }
}
