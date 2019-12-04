package com.neobis.eshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neobis.eshop.entity.Role;
import com.neobis.eshop.entity.User;
import com.neobis.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findOne(String email) {
        return userRepository.getOne(email);
    }

    public boolean isUserPresent(String email) {
        // TODO Auto-generated method stub
        Optional<User> optUser = userRepository.findById(email); // returns java8 optional
        if (optUser.isPresent()) {
            return true;
        }
        return false;
    }

    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        // TODO Auto-generated method stub
        return  userRepository.findByNameLike("%"+name+"%");
    }

}
