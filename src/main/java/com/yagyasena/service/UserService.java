package com.yagyasena.service;

import java.util.List;
import java.util.Optional;

import com.yagyasena.entity.User;

public interface UserService {

       User saveUser(User user);
        public Optional<User> getUser( Long id);
      void deleteUserById( Long id);
      User updateUser(User user, Long id);
      List<User> getAllUser();

}