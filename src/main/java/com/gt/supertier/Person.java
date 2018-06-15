package com.gt.supertier;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorValue("P")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name",length = 30)
    protected String firstName;

    @Column(name = "last_name",length = 30)
    protected String lastName;

    @Column(length = 50)
    protected String email;

    @Transient
    protected String fullName;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return firstName +" "+lastName;
    }
}
