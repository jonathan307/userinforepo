package com.files.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "USERINFO")
public class UserInfo {

    @Column(name = "id")
    @Id
    private int userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "profession")
    private String profession;

    @Column(name = "datecreated")
    private String datecreated;

    @Column(name = "country" )
    private String country;

    @Column(name = "city")
    private String city;
}
