package com.myopttest.opttest.controller;

import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.service.OptUserService;
import com.myopttest.opttest.untils.PowerException;
import com.myopttest.opttest.untils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/optUser")
public class OptUserController {

    @Autowired
    private OptUserService optUserService;

    @GetMapping("/findById/{id}")
    public OptUser findById(@PathVariable("id") int id) {
        return optUserService.findById(id);
    }

    @PostMapping("/login")
    public OptUser login(String account, String password) {
        return optUserService.login(account,password);
    }

    /**
     * 修改管理员权限
     * @param optUser 被修改的管理员
     * @param user 操作的管理员
     * @return
     */
    @RequestMapping("/updateRole")
    public Map<String,Object> updateRole(OptUser optUser, OptUser user,@RequestBody Map<String,String> param) {
        Map<String,Object> result = new HashMap<>();
        try{
            if("superAdmin".equals(user.getRole())){
                if("admin".equals(optUser.getRole())){
                    optUserService.updateRole(optUser, user);
                    result.put("code","200");
                    result.put("msg","操作成功");
                } else {
                    throw new PowerException("不能修改超级管理员的权限！");
                }
            } else {
                throw new PowerException("操作权限不足！");
            }
        } catch (PowerException e){
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","操作失败，权限不够，或者被修改的账户身份为superAdmin");
        } catch (Exception e){
            e.printStackTrace();
            result.put("code","500");
            result.put("msg","操作失败");
        } finally {
            return result;
        }
    }

    /**
     * 添加新的管理员
     * @param optUser 被添加的管理员
     * @param user 操作的管理员
     * @return
     */
    @PutMapping("/addNewAdmin")
    public Map<String,Object> addNewAdmin(OptUser optUser, OptUser user){
        Map<String,Object> result = new HashMap<>();
        try {
            if("superAdmin".equals(user.getRole())){
                if("admin".equals(optUser.getRole())){
                    optUserService.addNewAdmin(optUser,user);
                    result.put("code","200");
                    result.put("msg","操作成功");
                } else {
                    throw new PowerException("不能直接新建超级管理员身份账户！");
                }
            } else {
                throw new PowerException("该账户权限不足！");
            }
        } catch (PowerException e){
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","账户权限不足，或试图建立superAdmin身份账户！");
        } catch (Exception e){
            e.printStackTrace();
            result.put("code","500");
            result.put("msg","操作失败");
        } finally {
            return result;
        }
    }

    /**
     * 删除已有的管理员
     * @param optUser 被删除的管理员
     * @param user 操作的管理员
     * @return
     */
    @DeleteMapping("/deleteAdminById")
    public Map<String,Object> deleteAdminById(OptUser optUser, OptUser user){
        Map<String,Object> result = new HashMap<>();
        try{
            OptUser userById = optUserService.findById(optUser.getId());
            if(userById == null){
                throw new UserNotFoundException("查无此人！");
            }
            if("superAdmin".equals(user.getRole())){
                if("admin".equals(optUser.getRole())){
                    optUserService.deleteAdminById(optUser.getId(),user);
                    result.put("code","200");
                    result.put("msg","操作成功");
                } else {
                    throw new PowerException("不能删除superAdmin身份账户！");
                }
            } else {
                throw new PowerException("该账户权限不足！");
            }
        } catch (UserNotFoundException e){
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","未找到id为"+optUser.getId()+"的管理员账户！");
        } catch (PowerException e){
            e.printStackTrace();
            result.put("code","400");
            result.put("msg","操作错误！账户权限不足或试图删除superAdmin身份账户！");
        } catch (Exception e){
            e.printStackTrace();
            result.put("code","500");
            result.put("msg","操作失败");
        } finally {
            return result;
        }
    }
}
