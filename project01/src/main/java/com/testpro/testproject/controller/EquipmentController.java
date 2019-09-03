package com.testpro.testproject.controller;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testpro.testproject.domain.Camera;
import com.testpro.testproject.domain.Equipment;
import com.testpro.testproject.service.TokenService;
import com.testpro.testproject.util.EquipentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/equipment")
@CrossOrigin("*")
public class EquipmentController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EquipentUtil equipentUtil;

    //获取摄像机列表
    @GetMapping("/getAllCamera")
    public List<Camera> getAllCamera(){
        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
        String post = HttpUtil.post("https://open.ys7.com/api/lapp/camera/list", map);
        Map<String, Object> objectMap = equipentUtil.util(post);

        ArrayList<Camera> list = (ArrayList<Camera>) objectMap.get("data");
        Map<String,Object> msg = new HashMap<>();
        msg.put("data",list);

        return list;

    }

    /**
     * 根据产品序列号获取产品信息
     * @param deviceSerial
     * @return
     */
    @GetMapping("/getEquipmentByDeviceSerial/{deviceSerial}")
    public Map<String,Object> getEquipmentByDeviceSerial(@PathVariable("deviceSerial") String deviceSerial){

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
        map.put("deviceSerial",deviceSerial);

        String post = HttpUtil.post("https://open.ys7.com/api/lapp/device/status/get", map);

        Map<String, Object> objectMap = equipentUtil.util(post);

        return (Map<String, Object>) objectMap.get("data");
    }

    /**
     * 用于云台控制的restful风格接口
     * @param equipment 具体的操作信息
     * @param isStop isStop标记开始和结束，1为结束操作，0为开始操作
     * @return
     */
    @PostMapping("/couldController/{isStop}")
    public Map<String,Object> couldController(@RequestBody Equipment equipment, @PathVariable("isStop") int isStop){

        System.out.println(equipment.getDeviceSerial()+"---"+equipment.getChannelNo()+"---"+equipment.getDirection()+"---"+equipment.getSpeed()+"---"+isStop);

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
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

        Map value = null;
        try {
            value = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * 获取账号下的视频地址列表
     * @return
     */
    @GetMapping("/getAllLiveList")
    public Map<String,Object> getAllLiveList(){
        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
        System.out.println("accessToken--------------->"+tokenService.selectById(1));
        String post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/list", map);
        Map value = null;
        try {
            value = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);

        ArrayList list = (ArrayList) value.get("data");

        Map<String,Object> result = new HashMap<>();

        result.put("data",list);

        return result;
    }

    /**
     *打开和关闭直播
     * @param source 直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，
     *               例如427734222:1,423344555:3，均采用英文符号
     * @param oORc 用于分辨打开直播和关闭直播,0为关，1为开
     * @return
     */
    @PostMapping("/openORcloseLiveBySource/{source}/{oORc}")
    public Map<String,Object> openORcloseLiveBySource(@PathVariable("source") String source, @PathVariable("oORc") Integer oORc){
        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
        map.put("source",source);
        String post = "";

        if(1 == oORc){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/open", map);
        }
        if(0 == oORc){
            post = HttpUtil.post("https://open.ys7.com/api/lapp/live/video/close", map);
        }

        System.out.println(post);

        Map value = null;
        try {
            value = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     *获取直播地址
     * @param source 直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，
     *               例如427734222:1,423344555:3，均采用英文符号
     * @return
     */
    @GetMapping("/getLiveAddressBySource/{source}")
    public Map<String,Object> getLiveAddressBySource(@PathVariable("source") String source){

        Map<String,Object> map = new HashMap<>();
        map.put("accessToken",tokenService.selectById(1).getToken());
        map.put("source",source);

        String post = HttpUtil.post("https://open.ys7.com/api/lapp/live/address/get", map);

        Map value = null;
        try {
            value = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(value);

        return value;

    }



}
