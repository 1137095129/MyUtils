package com.myopttest.opttest.untils;

public class PageUtils {

    /**
     * 计算分页偏移量
     * @param pageNo 当前页码
     * @param pageCount 每页数量
     * @return
     */
    public static int getOffSetCount(int pageNo,int pageCount){
        return (pageNo - 1) * pageCount;
    }

}
