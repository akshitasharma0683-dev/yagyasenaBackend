package com.yagyasena.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yagyasena.entity.User;
import com.yagyasena.repository.UserRepo;
import com.yagyasena.service.*;
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

    public Optional<User> getUser( Long id){
        return  userrepo.findById(id);

    }

    public void deleteUserById( Long id){
         Optional<User> existingUser  = getUser( id);
         User dbUser = existingUser.orElseThrow(
            () -> new RuntimeException("user does not exist")
         );
         userrepo.deleteById(dbUser.getUserID());
    }

    public List<User> getAllUser(){
       return (List<User>) userrepo.findAll();

    }

    public User updateUser(User user, Long id){
        Optional<User> existingUser  = getUser( id);

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
