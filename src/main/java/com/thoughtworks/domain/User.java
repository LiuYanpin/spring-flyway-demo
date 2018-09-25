package com.thoughtworks.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String telephoneNumber;
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

