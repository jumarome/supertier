package com.gt.supertier.presentation.user;

import com.gt.supertier.business.user.boundary.UserManager;
import com.gt.supertier.business.user.entitiy.User;
import com.gt.supertier.business.user.entitiy.UserDto;

import javax.annotation.PostConstruct;
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

    private boolean editMode;

    private List<User> users;

    private UserDto userDto;

    @Inject
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostConstruct
    public void init(){
        this.users = userManager.findAll();
        this.userDto = new UserDto();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void toggleEditMode(){
        this.editMode = !this.editMode;
    }

    public void updateSelectedUser(){
       this.selectedUser=saveUser(selectedUser);
       User userToUpdate = users.stream().filter(u->u.getId().equals(selectedUser.getId())).findFirst().get();
       userToUpdate.setFirstName(selectedUser.getFirstName());
       userToUpdate.setLastName(selectedUser.getLastName());
       userToUpdate.setEmail(selectedUser.getEmail());
       toggleEditMode();
    }

    /************************
        Private methods
     ***********************/


    private User saveUser(User u){
        return userManager.save(u);
    }



}
