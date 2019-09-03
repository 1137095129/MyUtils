import domain.Test;
import utils.HttpUtil;
import utils.JSONUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Test test = new Test();
        test.setFlag(true);
        test.setId(20);
        test.setMsg("测试");

        Map<String,Object> map = new HashMap<>();
        map.put("msg","你好");
        map.put("code",200);
        //map.put("test",test);

        List<Object> list = new ArrayList<>();
        list.add(test);
        list.add(map);

        JSONUtil<List> jsonListUtil = new JSONUtil<>();

        try {
            System.out.println("list---------->"+jsonListUtil.getJson(list));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        test.setMap(map);

        JSONUtil<Map> jsonUtil = new JSONUtil<>();
        try {
            System.out.println(jsonUtil.getJson(map));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JSONUtil<Test> jsonUtil1 = new JSONUtil<>();
        String json = null;
        try {
            json = jsonUtil1.getJson(test);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(json);

        String get = null;
        try {
            get = HttpUtil.doGet("http://127.0.0.1:8081/controller/getTest", map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(get);

        String post = null;
        try {
            post = HttpUtil.doPost("http://127.0.0.1:8081/controller/postTest",map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(post);
    }
}
