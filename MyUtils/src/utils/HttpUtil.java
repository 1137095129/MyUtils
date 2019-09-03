package utils;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {

    public static String doGet(String httpUrl) throws IOException {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        String result = null;



        URL url = new URL(httpUrl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setReadTimeout(3000);
        connection.setConnectTimeout(6000);

        connection.connect();

        System.out.println(connection.getResponseCode());

        if(connection.getResponseCode()==200){
            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            StringBuffer sbf = new StringBuffer();
            String temp;
            while ((temp=reader.readLine())!=null){
                sbf.append(temp);
                sbf.append("\n");
            }
            result = sbf.toString();
        }
        if(inputStream!=null)
            inputStream.close();
        if(reader!=null)
            reader.close();
        connection.disconnect();
        return result;
    }

    public static String doPost(String httpUrl, Map<String,Object> value) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        String result = null;

        URL url = new URL(httpUrl);
        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(6000);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");

        out = connection.getOutputStream();
        try {
            out.write((new JSONUtil<Map>()).getJson(value).getBytes());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.flush();

        System.out.println("bytes--->" + value.toString());

        in = connection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in,"utf-8"));

        if(connection.getResponseCode()==200){
            StringBuffer sbf = new StringBuffer();
            String temp;

            while ((temp=reader.readLine())!=null){
                sbf.append(temp);
                sbf.append("\n");
            }
            result = sbf.toString();
        }
        if(in!=null)
            in.close();
        if(out!=null)
            out.close();
        if(reader!=null)
            reader.close();

        connection.disconnect();

        return result;
    }

}
