package com.example.demo.domain;

public class StudentDao {
    public Student findOneById(String id) {
        return new Student(id, "Jack", 21);
    }
}
