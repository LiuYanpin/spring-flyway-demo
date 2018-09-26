package com.thoughtworks.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private int height;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Student(String name, int age, int height, Classroom classroom) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.classroom = classroom;
    }
}

