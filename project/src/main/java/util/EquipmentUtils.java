package util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import domain.Equipment;

import java.util.HashMap;
import java.util.Map;

public class EquipmentUtils {

    /**
     * 该方法用于管理员账号根据appKey和secret获取accessToken
     * @param appKey
     * @param appSecret
     * @return
     */
    public Map<String,Object> getAccessToken(String appKey, String appSecret){

        Map<String,Object> map = new HashMap<>();
        map.put("appKey",appKey);
        map.put("appSecret",appSecret);

        String post = HttpUtil.post("https://open.ys7.com/api/lapp/token/get", map);

        JSONObject value = new JSONObject(post);

        Map<String,Object> result = new HashMap<>();

        if("200".equals(value.getStr("code"))){
            result.put("msg",value.get("msg"));
            result.put("result",value.get("data"));
        }else {
            result.put("msg",value.get("msg"));
            result.put("result",null);
        }
        return result;
    }

    /**
     *获取账号下的视频地址或者摄像头列表
     * @param token 授权过程获取的access_token
     * @param flag 1获取视频地址列表；0获取摄像头列表
     * @return
     */
    public Map<String,Object> getAllLiveList(String token, int flag){
        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",token);
        String post = null;
        if(flag==1){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/list", map);
        }
        if(flag==0){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/camera/list", map);
        }
        JSONObject value = new JSONObject(post);

        Map<String,Object> result = new HashMap<>();

        if("200".equals(value.get("code"))){
            JSONArray list = (JSONArray) value.get("data");
            result.put("msg",value.get("msg"));
            result.put("video",list);
        }else {
            result.put("msg",value.get("msg"));
            result.put("video",null);
        }

        return result;
    }

    /**
     *根据产品序列号获取产品信息
     * @param token 授权过程获取的access_token
     * @param deviceSerial 产品序列号
     * @return
     */
    public Map<String,Object> getEquipmentByDeviceSerial(String token, String deviceSerial){

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",token);
        map.put("deviceSerial",deviceSerial);

        String post = HttpUtil.post("https://open.ys7.com/api/lapp/device/status/get", map);

        JSONObject jb = new JSONObject(post);

        Map<String,Object> result = new HashMap<>();

        if("200".equals(jb.getStr("code"))){
            result.put("msg",jb.get("msg"));
            result.put("deviceInfo",jb.get("data"));
        }else {
            result.put("msg",jb.get("msg"));
            result.put("deviceInfo",null);
        }

        return result;
    }

    /**
     *获取直播地址
     * @param token 授权过程获取的access_token
     * @param deviceSerial 设备序列号
     * @param channelNo 通道号
     * @return
     */
    public Map<String,Object> getLiveAddressBySource(String token, String deviceSerial,int channelNo){
        String source = deviceSerial + channelNo;

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",token);
        map.put("source",source);

        String post = HttpUtil.post("https://open.ys7.com/api/lapp/live/address/get", map);

        JSONObject value = new JSONObject(post);

        Map<String,Object> result = new HashMap<>();

        if("200".equals(value.get("code"))){
            result.put("msg",value.get("msg"));
            result.put("address",value.get("data"));
        }else {
            result.put("msg",value.get("msg"));
            result.put("address",null);
        }
        return result;
    }

    /**
     * 云台控制
     * @param token 授权过程获取的access_token
     * @param equipment 封装的操作类
     * @param isStop isStop标记开始和结束，1为结束操作，0为开始操作
     * @return
     */
    public Map<String,Object> couldController(String token, Equipment equipment, int isStop){
        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",token);
        map.put("deviceSerial",equipment.getDeviceSerial());
        map.put("channelNo",equipment.getChannelNo());
        map.put("direction",equipment.getDirection());

        String post = "";

        if(isStop == 1){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/device/ptz/stop", map);
        }else if (isStop == 0){
            map.put("speed",equipment.getSpeed());
            post = HttpUtil.post("https://open.ys7.com/api/lapp/device/ptz/start", map);
        }

        JSONObject result = new JSONObject(post);

        return result;
    }



    /**
     *打开、关闭直播
     * @param token 授权过程获取的access_token
     * @param deviceSerial 设备序列号
     * @param channelNo 通道号
     * @param oORc 用于分辨打开直播和关闭直播,0为关，1为开
     * @return
     */
    public Map<String,Object> openORcloseLiveBySource(String token, String deviceSerial,int channelNo, Integer oORc){
        String source = deviceSerial + channelNo;

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",token);
        map.put("source",source);
        String post = "";

        if(1 == oORc){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/open", map);
        }
        if(0 == oORc){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/close", map);
        }

        JSONObject value = new JSONObject(post);
        return value;
    }


}
