package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentDao;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao dao = new StudentDao();
    @Override
    public Student findStudentById(String id) {
        return dao.findOneById(id);
    }
}
