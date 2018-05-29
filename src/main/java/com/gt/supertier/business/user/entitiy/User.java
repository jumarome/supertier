package com.gt.supertier.business.user.entitiy;

import com.gt.supertier.Person;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "person_id" )
public class User extends Person {

    @Column(length = 20)
    private String username;

    @Column(length = 60,name = "password_hash")
    private String passwordHash;

    @ManyToMany
    private Set<Group> groups;

    public User() {}

    public User(String name, String lastName, String username) {
        super(name,lastName);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
