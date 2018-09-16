package com.example.demo.domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao {
    Student findStudentById(String id);
    void insertStudent(Student student);
    void deleteStudentById(String id);
    void updateStudent(Student student);
}
