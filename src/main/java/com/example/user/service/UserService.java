package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.model.User;
import com.example.user.repository.UserRepositroy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepositroy userRepositroy;
	
	// 회원 등록
    public User registerUser(User user) {
        return userRepositroy.save(user);
    }

    // 회원 목록 조회
    public List<User> getAllUsers() {
        return userRepositroy.findAll();
    }

    // 회원 삭제
    public void deleteUser(Long id) {
        userRepositroy.deleteById(id);
    }
	
}
