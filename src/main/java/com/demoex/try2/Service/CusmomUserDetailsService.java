package com.demoex.try2.Service;

import com.demoex.try2.Entity.User;
import com.demoex.try2.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CusmomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Пользователь не найден" + username);
        }

        List<SimpleGrantedAuthority> authorityList = user.getRole().stream().map(
            role -> new SimpleGrantedAuthority("ROLE" + role.name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);
    }
}
