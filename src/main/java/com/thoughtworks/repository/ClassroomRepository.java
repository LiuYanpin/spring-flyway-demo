package com.thoughtworks.repository;

import com.thoughtworks.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    Classroom findByName(String name);
}
