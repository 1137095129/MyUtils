package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class JSONUtil<T> {
    private List<T> list = new ArrayList<>();

    private T Object;

    private Class objectClass;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }

    private String getJson(List<T> jsonList) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException {
        setList(jsonList);

        StringBuffer jsonStr = new StringBuffer("[");

        for (int i = 0; i < jsonList.size(); i++) {
            jsonStr.append(getJson(jsonList.get(i)));
        }

        jsonStr.append("]");
        return jsonStr.toString();
    }

    public String getJson(T jsonObject) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        if(jsonObject instanceof List){
            return getJson((List)jsonObject);
        }
        setObject(jsonObject);
        objectClass = jsonObject.getClass();
        StringBuffer jsonStr = new StringBuffer("{");
        if(jsonObject instanceof Map) {
            Map<String,Object> map = (Map<String, java.lang.Object>) jsonObject;
            Set<String> keySet = map.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                String key = next;
                java.lang.Object value = map.get(next);
                if(value instanceof String){
                    if(iterator.hasNext()){
                        jsonStr.append("\""+key+"\"" + ":\""+value+"\",");
                    }else {
                        jsonStr.append("\""+key+"\"" + ":\""+value+"\"");
                    }
                }else if (value instanceof Integer||value instanceof Byte||value instanceof Short||value instanceof Long||value instanceof Character||value instanceof Float||
                        value instanceof Double||value instanceof Boolean) {
                    if(iterator.hasNext()){
                        jsonStr.append("\""+key+"\"" + ":" +value +",");
                    }else {
                        jsonStr.append("\""+key+"\"" + ":" +value) ;
                    }
                }else {
                    if(iterator.hasNext()){
                        JSONUtil<Object> jsonUtil = new JSONUtil<>();
                        jsonStr.append("\""+key+"\":" + jsonUtil.getJson(value) + ",");
                    }else {
                        JSONUtil<Object> jsonUtil = new JSONUtil<>();
                        jsonStr.append("\""+key+"\":" + jsonUtil.getJson(value));
                    }
                }
            }
        }else {
            Field[] declaredFields = objectClass.getDeclaredFields();

            for (int i = 0; i < declaredFields.length; i++) {
                Type genericType = declaredFields[i].getGenericType();

                if ("java.lang.String".equals(genericType.getTypeName())) {
                    if (i < declaredFields.length - 1) {
                        jsonStr.append("\"" + declaredFields[i].getName() + "\":" + "\"" + getValue(declaredFields[i]).toString() + "\",");
                    } else {
                        jsonStr.append("\"" + declaredFields[i].getName() + "\":" + "\"" + getValue(declaredFields[i]).toString() + "\"");
                    }
                } else if("java.lang.Integer".equals(genericType.getTypeName())||"java.lang.Byte".equals(genericType.getTypeName())||"java.lang.Short".equals(genericType.getTypeName())
                    ||"java.lang.Long".equals(genericType.getTypeName())||"java.lang.Char".equals(genericType.getTypeName())||"java.lang.Boolean".equals(genericType.getTypeName())||
                    "java.lang.Float".equals(genericType.getTypeName())||"java.lang.Double".equals(genericType.getTypeName())||"int".equals(genericType.getTypeName())||"byte".equals(genericType.getTypeName())
                    ||"java.lang.short".equals(genericType.getTypeName())||"long".equals(genericType.getTypeName())||"char".equals(genericType.getTypeName())||"boolean".equals(genericType.getTypeName())
                    ||"float".equals(genericType.getTypeName())||"double".equals(genericType.getTypeName())) {
                    if (i < declaredFields.length - 1) {
                        jsonStr.append("\"" + declaredFields[i].getName() + "\":" + getValue(declaredFields[i]) + ",");
                    } else {
                        jsonStr.append("\"" + declaredFields[i].getName() + "\":" + getValue(declaredFields[i]) + "");
                    }
                } else {
                    if(i < declaredFields.length -1){
                        JSONUtil<Object> jsonUtil = new JSONUtil<>();
                        jsonStr.append("\""+declaredFields[i].getName()+"\":" + jsonUtil.getJson(getValue(declaredFields[i]))+",");
                    }else {
                        JSONUtil<Object> jsonUtil = new JSONUtil<>();
                        jsonStr.append("\""+declaredFields[i].getName()+"\":" + jsonUtil.getJson(getValue(declaredFields[i])));
                    }
                }
            }
        }
        jsonStr.append("}");
        return jsonStr.toString();
    }

    //通过getter方法获取字段的值
    private Object getValue(Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        char temp = field.getName().charAt(0);
        StringBuffer sb = new StringBuffer(field.getName());
        if(temp >= 97 && temp <= 122){
            sb.setCharAt(0,(char) (temp-32));
        }
        Method method = objectClass.getMethod("get" + sb.toString());
        return method.invoke(getObject());
    }

}
