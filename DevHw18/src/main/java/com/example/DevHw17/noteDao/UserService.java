package com.example.DevHw17.noteDao;

import com.example.DevHw17.entities.User;
import com.example.DevHw17.reposetory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User saveUser(User user){
        user.setEnabled(true);
        user.setRole("ROLE_USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
