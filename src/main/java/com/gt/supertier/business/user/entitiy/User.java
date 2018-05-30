package com.gt.supertier.business.user.entitiy;

import com.gt.supertier.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "person_id" )
@DiscriminatorValue("U")
public class User extends Person {

    @Column(length = 20)
    private String username;

    @Column(length = 60,name = "password_hash")
    private String passwordHash;

    @ManyToMany
    private Set<Group> groups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
