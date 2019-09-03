package com.myopttest.opttest.service;

import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.domain.PageObject;
import com.myopttest.opttest.domain.Student;

import java.util.List;

public interface StudentService {
    int getTotalCount();
    Student findById(int uid);
    List<Student> findAll();
    PageObject findByPage(PageObject page);
    List<Student> findByUserName(String userName);
    List<Student> findByUserCard(String userCard);
    void addNewStudent(List<Student> students, OptUser user);
    void updateStudentInfo(List<Student> students, OptUser user);
    void deleteStudentInfo(List<Student> students, OptUser user);
}
