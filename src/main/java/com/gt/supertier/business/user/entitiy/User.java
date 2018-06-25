package com.gt.supertier.business.user.entitiy;

import com.gt.supertier.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "person_id" )
@DiscriminatorValue("U")
public class User extends Person {

    @Column(length = 20)
    private String username;

    @Column(length = 60,name = "password_hash")
    protected String passwordHash;

    @ManyToMany
    private Set<Group> groups;

    public User() {
    }

    public User(String firstName, String lastName, String username) {
        super(firstName, lastName);
        this.username = username;
        this.groups = new HashSet<>();
    }

    public void addToGroup(Group group){
        groups.add(group);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<Group> getGroups() {
        return groups;
    }

}
