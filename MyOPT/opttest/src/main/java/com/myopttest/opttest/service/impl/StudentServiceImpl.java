package com.myopttest.opttest.service.impl;

import com.myopttest.opttest.dao.StudentDao;
import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.domain.PageObject;
import com.myopttest.opttest.domain.Student;
import com.myopttest.opttest.service.StudentService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int getTotalCount() {
        return studentDao.getTotalCount();
    }

    @Override
    public Student findById(int uid) {
        return studentDao.findById(uid);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public PageObject findByPage(PageObject page) {
        page.setResult(studentDao.findByPage(page));
        return page;
    }

    @Override
    public List<Student> findByUserName(String userName) {
        return studentDao.findByUserName(userName);
    }

    @Override
    public List<Student> findByUserCard(String userCard) {
        return studentDao.findByUserCard(userCard);
    }

    @Override
    @Transactional
    public void addNewStudent(List<Student> students, OptUser user) {
        studentDao.addNewStudent(students);
    }

    @Override
    @Transactional
    public void updateStudentInfo(List<Student> students, OptUser user) {
        studentDao.updateStudentInfo(students);
    }

    @Override
    @Transactional
    public void deleteStudentInfo(List<Student> students, OptUser user) {
        studentDao.deleteStudentInfo(students);
    }
}
