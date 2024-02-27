package com.demoex.try2.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @GetMapping("main")
    public String getMainPage(){
        return "main";
    }
}
