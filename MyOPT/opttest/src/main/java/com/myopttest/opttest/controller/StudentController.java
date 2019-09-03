package com.myopttest.opttest.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.domain.PageObject;
import com.myopttest.opttest.domain.Student;
import com.myopttest.opttest.service.StudentService;
import com.myopttest.opttest.untils.PowerException;
import com.myopttest.opttest.untils.UserExistsException;
import com.myopttest.opttest.untils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@CrossOrigin("*")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private com.myopttest.opttest.untils.ExcelUtil excelUtil;

    /**
     * 查询学生
     * @param uid 学生编号
     * @return
     */
    @GetMapping("/findById/{uid}")
    public Student findById(@PathVariable("uid") int uid) {
        return studentService.findById(uid);
    }

    /**
     * 查询所有学生
     * @return
     */
    @GetMapping("/findAll")
    public void findAll(HttpServletResponse response) {
        List<Student> students = studentService.findAll();
        List<Student> rows = CollUtil.newArrayList(students);
        excelUtil.write(rows,response);
    }

    /**
     * 分页查询学生信息
     * @param pageInfo 需要Integer类型的pageNo和pageCount参数
     *                 pageNo 当前页码；
     *                 pageCount 每页数据量
     * @return
     */
    @RequestMapping("/findByPage")
    public Map<String,Object> findByPage(@RequestBody Map<String,Object> pageInfo){

        Map<String,Object> result = new HashMap<>();

        Integer pageNo = (Integer) pageInfo.get("pageNo");
        Integer pageCount = (Integer) pageInfo.get("pageCount");

        PageObject pageObject = new PageObject(pageNo,pageCount);

        pageObject = studentService.findByPage(pageObject);

        int countTotal = studentService.getTotalCount();
        int pageTotal = countTotal/pageCount;
        if(countTotal%pageCount!=0){
            pageTotal++;
        }
        pageObject.setPageTotal(pageTotal);

        if(pageNo<=pageTotal){
            result.put("code","200");
            result.put("msg","请求成功！");
            result.put("data",pageObject);
            result.put("sym","ok");
        }else {
            result.put("code","400");
            result.put("msg","请求失败！分页总页数为"+pageObject.getPageTotal()+"，但请求了第"+pageObject.getPageNo()+"页");
            result.put("data",null);
            result.put("sym","fail");
        }

        return result;
    }

    @RequestMapping("/findByUserName")
    public List<Student> findByUserName(@RequestBody String userName){
        return studentService.findByUserName(userName);
    }

    @RequestMapping("/findByUserCard")
    public List<Student> findByUserCard(@RequestBody String userCard){
        return studentService.findByUserCard(userCard);
    }


    @PostMapping("/addNewStudent")
    public Map<String,String> addNewStudent(@RequestParam("file") MultipartFile file, OptUser user) {

        Map<String,String> map = new HashMap<>();
        List<Student> studentList = new ArrayList<>();

        try {
            if("admin".equals(user.getRole())){
                ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
                List<Student> students = reader.readAll(Student.class);
                Student studentById = null;

                for (int i = 0; i < students.size(); i++){
                    studentById = studentService.findById(students.get(i).getUid());
                    if(studentById!=null){
                        studentList.add(studentById);
                    }
                }
                if(studentList.size()!=0){
                    throw new UserExistsException("有一名或多名学生已存在！");
                }
                studentService.addNewStudent(students, user);

                map.put("code","200");
                map.put("msg","添加成功");
            }else {
                throw new PowerException("权限过高或过低！");
            }
        } catch (PowerException e){
            e.printStackTrace();
            map.put("code","400");
            map.put("msg","此操作需要admin身份，你的身份是"+user.getRole());
        } catch (UserExistsException e){
            e.printStackTrace();
            map.put("code","400");
            String information = "编号为";
            for (int i = 0; i < studentList.size(); i++){
                information += studentList.get(1).getUid();
                information += "、";
            }
            information += "的学生已存在！";
            map.put("msg",information);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","500");
            map.put("msg","添加失败");
        } finally {
            return map;
        }

    }

    //批量更新或删除学生，flag为1更新，0为删除
    @PostMapping("/updateStudentInfo/{flag}")
    public Map<String,Object> updateStudentInfo(@RequestParam("file") MultipartFile file, OptUser user,@PathVariable("flag") int flag) {

        Map<String,Object> result = new HashMap<>();
        Student stu = new Student();

        try {
            if("admin".equals(user.getRole())) {
                ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
                List<Student> students = reader.readAll(Student.class);

                for (int i = 0; i < students.size(); i++) {
                    Student student = studentService.findById(students.get(i).getUid());
                    if (student == null) {
                        stu.setUid(students.get(i).getUid());
                        throw new UserNotFoundException("查无此人");
                    }
                }

                if (flag == 1) {
                    studentService.updateStudentInfo(students, user);
                }
                if (flag == 0) {
                    studentService.deleteStudentInfo(students, user);
                }

                result.put("code", "200");
                result.put("msg", "操作完成!");
            }else {
                throw new PowerException("此操作需要admin身份，你的身份是"+user.getRole());
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","学生" + stu.getUid() + "找不到！");
        } catch (PowerException e){
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","此操作需要admin身份，你的身份是"+user.getRole());
        } catch (Exception e){
            e.printStackTrace();
            result.put("code","500");
            result.put("msg","操作失败!");
        } finally {
            return result;
        }

    }
}
