package com.demoex.try2.Service;

import com.demoex.try2.Entity.Role;
import com.demoex.try2.Entity.User;
import com.demoex.try2.Entity.UserDto;
import com.demoex.try2.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.demoex.try2.Config.SecurityConfig.passwordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void addUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setSurname(userDto.getSurname());
        user.setPhoneNum(userDto.getPhoneNum());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
        user.setRole(Collections.singleton(Role.USER));
        userRepo.save(user);
    }
}
