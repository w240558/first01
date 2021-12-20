package com.ssm.service;

import com.ssm.dao.StudentMapper;
import com.ssm.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSM_zuoye
 * @description:
 * @author: wen
 * @create: 2021-12-20 08:38
 * @version:1.0
 **/
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student loginUser(String name,String password){
        Student student = studentMapper.loginUser(name, password);
        return student;
    }

    public int insertStudent(Student student){
        int i = studentMapper.insertStudent(student);
        return i;
    }
}