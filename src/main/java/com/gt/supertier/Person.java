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

    @Column(length = 30)
    protected String name;

    @Column(name = "last_name",length = 30)
    protected String lastName;

    @Column(length = 50)
    protected String email;

    @Transient
    protected String fullName;

    public Person() {}

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFullName() {
        return name+" "+lastName;
    }
}
