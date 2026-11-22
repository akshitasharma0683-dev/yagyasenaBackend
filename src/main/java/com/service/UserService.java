package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.User;

public interface UserService {

       User saveUser(User user);
        public Optional<User> getUser(User user, Long id);
      void deleteUserById(User user, Long id);
      User updateUser(User user, Long id);
      List<User> getAllUser();

}