package com.example.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.user.model.User;
import com.example.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	private final UserService userService;
	
	 // 회원 목록 조회 (index.html로 이동)
    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";  // 뷰 이름을 'index'로 반환
    }

    // 회원 등록
    @PostMapping("/users")
    public String registerUser(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        userService.registerUser(user);
        return "redirect:/";  // 회원 등록 후 루트 페이지로 리다이렉트
    }

    // 회원 삭제
    @PostMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";  // 회원 삭제 후 루트 페이지로 리다이렉트
    }
}
