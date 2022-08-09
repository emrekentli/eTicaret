package com.example.eticaret.repository;

import com.example.eticaret.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
    public User findUserByUserMail(String userMail);
    public User getUserByUserId(Integer userId);
}
