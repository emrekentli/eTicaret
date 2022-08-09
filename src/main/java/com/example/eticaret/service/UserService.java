package com.example.eticaret.service;

import com.example.eticaret.entity.User;
import com.example.eticaret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BasketService basketService;
    public User register(String mail,String userName, String password) {
        User user = new User();
        user.setUserMail(mail);
        user.setUserName(userName);
        user.setPassword(password);
       user.setUserBasket(basketService.createBasket(user));
        return userRepository.save(user);
    }

    public User getUserByUserId(String userId) {

        return userRepository.getUserByUserId(Integer.valueOf(userId));
    }

    public void deleteUser(String userId) {

        userRepository.deleteById(Integer.valueOf(userId));

    }

    public User loginUser(String mail, String password) {
        User user = userRepository.findUserByUserMail(mail);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
