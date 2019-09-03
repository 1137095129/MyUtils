package com.myopttest.opttest.aop;

import com.myopttest.opttest.dao.OptLogDao;
import com.myopttest.opttest.domain.OptLog;
import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.domain.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OptLogAop {

    @Autowired
    private OptLogDao optLogDao;

    @After("execution(* com.myopttest.opttest.service.impl.OptUserServiceImpl.login(..))")
    public void addLoginLog(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        String account = (String) args[0];

        OptLog optLog = new OptLog();
        optLog.setContent("账号为"+account+"的管理员登录了");
        optLog.setKind("登录");
        optLog.setUser(account);

        optLogDao.addLog(optLog);
    }

    @After("execution(* com.myopttest.opttest.service.impl.OptUserServiceImpl.updateRole(..))")
    public void addUpdateLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        OptUser user1 = (OptUser) args[0];
        OptUser user2 = (OptUser) args[1];

        OptLog optLog = new OptLog();
        optLog.setContent("管理员"+user2.getName()+"修改了管理员"+user1.getName()+"的权限为"+user1.getRole());
        optLog.setKind("权限修改");
        optLog.setUser(user2.getAccount());

        optLogDao.addLog(optLog);
    }

    @After("execution(* com.myopttest.opttest.service.impl.StudentServiceImpl.addNewStudent(..))")
    public void addAddStudentLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        List<Student> students = (List<Student>) args[0];
        OptUser user = (OptUser) args[1];

        System.out.println(user.getAccount());

        for (int i = 0; i < students.size(); i++) {
            String content = "管理员"+user.getName()+"添加了学生："+students.get(i).getUserName();

            OptLog optLog = new OptLog();
            optLog.setContent(content);
            optLog.setKind("添加学生");
            optLog.setUser(user.getAccount());

            optLogDao.addLog(optLog);
        }
    }

    @After("execution(* com.myopttest.opttest.service.impl.StudentServiceImpl.updateStudentInfo(..))")
    public void updateStudentLog(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        List<Student> students = (List<Student>) args[0];
        OptUser user = (OptUser) args[1];

        for (int i = 0; i < students.size(); i++) {
            String content = "管理员"+user.getName()+"修改了学生："+students.get(i).getUserName()+"的信息";

            OptLog optLog = new OptLog();
            optLog.setContent(content);
            optLog.setKind("修改信息");
            optLog.setUser(user.getAccount());

            optLogDao.addLog(optLog);
        }

    }

    @After("execution(* com.myopttest.opttest.service.impl.StudentServiceImpl.deleteStudentInfo(..))")
    public void deleteStudentLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        List<Student> students= (List<Student>) args[0];
        OptUser user = (OptUser) args[1];

        for (int i = 0; i < students.size(); i++) {
            String content = "管理员"+user.getName()+"删除了编号为"+students.get(i).getUid()+"的学生";

            OptLog optLog = new OptLog();
            optLog.setContent(content);
            optLog.setKind("删除学生");
            optLog.setUser(user.getAccount());

            optLogDao.addLog(optLog);
        }
    }

    @After("execution(* com.myopttest.opttest.service.impl.OptUserServiceImpl.addNewAdmin(..))")
    public void addNewAdminLog(JoinPoint joinPoint){

    }

    @After("execution(* com.myopttest.opttest.service.impl.OptUserServiceImpl.deleteAdminById(..))")
    public void deleteAdminByIdLog(JoinPoint joinPoint){

    }
}
