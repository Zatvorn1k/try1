package com.demoex.try2.Controller;

import com.demoex.try2.Entity.UserDto;
import com.demoex.try2.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    public final UserService userService;

    @GetMapping("signup")
    public String signUpShowPage(){
        return "signup";
    }
    @PostMapping("signup")
    public String signUp(UserDto userDto){
        userService.addUser(userDto);
        return "redirect:/login";
    }
}
