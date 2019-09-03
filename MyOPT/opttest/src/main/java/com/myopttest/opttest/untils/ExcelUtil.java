package com.myopttest.opttest.untils;

import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    /**
     * 导出excel文件
     * @param rows
     * @param response
     */
    public void write(List rows, HttpServletResponse response){
        ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter();
        writer.write(rows);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=test.xls");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.flush(out);
        writer.close();
    }

}
