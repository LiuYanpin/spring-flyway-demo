package com.thoughtworks.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_privilege")
@Getter
@Setter
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;

    @JoinTable(
            name = "t_role_privilege",
            joinColumns = @JoinColumn(name = "privilege_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "role_code", referencedColumnName = "code")
    )
    @ManyToMany
    private List<Role> roles;
}
