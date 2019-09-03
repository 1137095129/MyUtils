package com.myopttest.opttest.controller;

import cn.hutool.core.collection.CollUtil;
import com.myopttest.opttest.domain.OptLog;
import com.myopttest.opttest.service.OptLogService;
import com.myopttest.opttest.untils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class OptLogController {

    @Autowired
    private OptLogService optLogService;

    @Autowired
    private ExcelUtil excelUtil;

    @GetMapping("/findById/{id}")
    public OptLog findById(@PathVariable("id") int id) {
        return optLogService.findById(id);
    }

    @GetMapping("/findAll")
    public void findAll(HttpServletResponse response) {
        List<OptLog> logs = optLogService.findAll();
        List<OptLog> rows = CollUtil.newArrayList(logs);
        excelUtil.write(rows,response);
    }

    /**
     *
     * @param value 需要afterTime、beforeTime、Kind参数；
     *              afterTime：之后的时间；
     *              beforeTime：之前的时间；
     *              Kind：操作种类
     * @return
     */
    @RequestMapping("/findByKindAndTime")
    public Map<String,Object> findByKindAndTime(@RequestBody Map<String,Object> value){

        Map<String,Object> result = new HashMap<>();
        List<OptLog> list = null;

        if(value.get("beforeTime") == null || value.get("afterTime") == null){
            list = optLogService.findByKind(value);
        }else if(value.get("kind") == null){
            list = optLogService.findByTime(value);
        }else {
            list = optLogService.findByKindAndTime(value);
        }

        result.put("code","200");
        result.put("msg","请求成功！");
        result.put("sym","ok!");
        result.put("data",list);

        return result;
    }

}
