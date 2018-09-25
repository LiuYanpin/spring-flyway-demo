package com.thoughtworks.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "t_role_privilege",
            joinColumns = @JoinColumn(name = "role_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "privilege_code", referencedColumnName = "code")
    )
    private List<Privilege> privileges;
}
