package com.myopttest.opttest.dao;

import com.myopttest.opttest.domain.PageObject;
import com.myopttest.opttest.domain.Student;

import java.util.List;

public interface StudentDao {

    int getTotalCount();
    Student findById(int uid);
    List<Student> findAll();
    List<Student> findByPage(PageObject page);
    List<Student> findByUserName(String userName);
    List<Student> findByUserCard(String userCard);
    void addNewStudent(List<Student> students);
    void updateStudentInfo(List<Student> students);
    void deleteStudentInfo(List<Student> students);
}
