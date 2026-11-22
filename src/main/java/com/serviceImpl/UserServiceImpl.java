package com.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepo;
import com.service.*;
@Service 
public class UserServiceImpl implements UserService{

    private UserRepo userrepo;

    public UserServiceImpl (UserRepo userrepo){
        this.userrepo= userrepo;
    }

    @Override
    public User saveUser(User user){
        return userrepo.save(user);

    }

    public Optional<User> getUser(User user, Long id){
        return  userrepo.findById(id);

    }

    public void deleteUserById(User user, Long id){
         userrepo.deleteById(id);
    }

    public List<User> getAllUser(){
       return (List<User>) userrepo.findAll();

    }

    public User updateUser(User user, Long id){
        Optional<User> existingUser  = getUser(user, id);

       User dbUser= existingUser.orElseThrow(
            () -> new RuntimeException("user not found")
        );

        if (user.getUserName()!= null ) {        
        
        dbUser.setUserName(user.getUserName());
        }
        if(user.getPassword()!=null){

        dbUser.setPassword(user.getPassword());
        }
        if(user.getEmail()!=null){
        dbUser.setEmail(user.getEmail());
        }
        
        return userrepo.save(dbUser);
      
    }
    
}
