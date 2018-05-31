package com.gt.supertier.presentation.user;

import com.gt.supertier.business.user.boundary.UserManager;
import com.gt.supertier.business.user.entitiy.User;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class UserController {

    @Inject
    private UserManager userManager;

    public List<User> findAll(){
        return userManager.findAll();
    }
}
