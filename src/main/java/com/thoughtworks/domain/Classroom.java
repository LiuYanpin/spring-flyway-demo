package com.thoughtworks.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "classroom_id")
    private List<Student> students;
}
