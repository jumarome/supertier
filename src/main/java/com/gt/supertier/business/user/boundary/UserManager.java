package com.gt.supertier.business.user.boundary;

import com.gt.supertier.business.user.entitiy.User;
import com.gt.supertier.business.user.entitiy.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserManager implements Serializable {

    @Inject
    private UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findOptionalByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
