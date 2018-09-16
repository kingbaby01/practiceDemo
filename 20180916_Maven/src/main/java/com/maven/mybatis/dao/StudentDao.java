package com.maven.mybatis.dao;

import com.maven.mybatis.domain.Student;

public interface StudentDao {
    Student findById(String id);
    void addOne(Student student);
    void update(Student student);
    void deleteById(String id);
}
