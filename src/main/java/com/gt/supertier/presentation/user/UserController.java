package com.gt.supertier.presentation.user;

import com.gt.supertier.business.user.boundary.UserManager;
import com.gt.supertier.business.user.entitiy.User;

import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserController implements Serializable {


    private final UserManager userManager;

    private User selectedUser;

    @Inject
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    public List<User> findAll(){
        return userManager.findAll();
    }


    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
