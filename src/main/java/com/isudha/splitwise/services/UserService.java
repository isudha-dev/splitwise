package com.isudha.splitwise.services;

import com.isudha.splitwise.models.User;
import com.isudha.splitwise.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        User updatedUser = user.toBuilder().password(hashedPassword).build();
        return userRepository.save(updatedUser);
    }

    public User findUser(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public List<User> findAllUsers(List<Long> userIds){
        return userRepository.findAllById(userIds);
    }
}
