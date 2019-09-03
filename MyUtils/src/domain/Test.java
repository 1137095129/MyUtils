package domain;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static Double getPI() {
        return PI;
    }

    private static final Double PI = 3.14;

    private Integer id;

    private String msg;

    private Boolean flag;

    private Map<String,Object> map = new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
