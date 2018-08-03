package com.example.demo.service;

import com.example.demo.dao.MaintainDao;
import com.example.demo.domain.DeviceInfo;
import com.example.demo.domain.IpInfo;
import com.example.demo.domain.ZombieInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiyajie on 16/10/8.
 */
@Service
public class MaintainService {
    private static final Logger log = LoggerFactory.getLogger(MaintainService.class);

    @Autowired
    MaintainDao maintainDao;
    /**
     * zombie info
     */


    /**
     * bean to map
     * @param zombieInfo
     * @return
     */
    private Map beanToMap(ZombieInfo zombieInfo){
        Map<String,Object> map = new HashedMap();
        map.put("id",zombieInfo.getId());
        map.put("os",zombieInfo.getOs());
        map.put("ip",zombieInfo.getIp());
        map.put("port",zombieInfo.getPort());
        map.put("address",zombieInfo.getAddress());
        map.put("zombieType",zombieInfo.getZombieType());
        map.put("innerIp",zombieInfo.getInnerIp());
        map.put("computer",zombieInfo.getComputer());
        map.put("location",zombieInfo.getLocation());
        map.put("expireDate",zombieInfo.getExpireDate());
        map.put("userStr",zombieInfo.getUserStr());
        map.put("taobaoUrl",zombieInfo.getTaobaoUrl());
        map.put("shopName",zombieInfo.getShopName());
        map.put("price",zombieInfo.getPrice());
        map.put("descrption",zombieInfo.getDescrption());
      return map;
    }

    /**
     * ip info
     */
    /**
     * 查询
     * @return
     */
    public Map<String,Object> queryIpByCondition(String ip, Integer pageIndex, Integer pageSize){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Map<String,Object> paraMap = new HashMap<>();
            paraMap.put("ip",ip);
            if(pageIndex != null) {
                paraMap.put("skip", (pageIndex - 1) * pageSize);
            }
            if(pageSize != null) {
                paraMap.put("max", pageSize);
            }
            resultMap.put("rows",maintainDao.queryIpByCondition(paraMap));
            resultMap.put("total",maintainDao.queryIpCountsByCondition(paraMap));
            resultMap.put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code", -1);
            resultMap.put("msg", "MaintainService:queryIpByCondition 获取数据错误:"+e.getMessage());
        }
        return resultMap;
    }

    /**
     * 新增
     * @param
     * @return
     */
    public Map<String,Object> addIpInfo(IpInfo ipInfo){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("ip",ipInfo.getIp());
        Map<String,Object> resultMap = new HashMap<>();
        List<Map<String,Object>> ipInfos =  maintainDao.queryIpByCondition(paramMap);
        if(CollectionUtils.isNotEmpty(ipInfos)){
            resultMap.put("code",-1);
            resultMap.put("msg","该记录已经存在,您无法再进行添加!");
            return resultMap;
        }
        try {
            resultMap.put("code", maintainDao.addIpInfo(ipInfoBeanToMap(ipInfo)));
            resultMap.put("msg", "恭喜你,添加记录成功!");
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", -1);
            resultMap.put("msg", "对不起,添加记录失败:"+e.getMessage());
        }
        return resultMap;
    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    public Map<String,Object> deleteIpInfo(Integer id){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        Map<String,Object> resultMap = new HashMap<>();
        try{
            resultMap.put("code", maintainDao.deleteIpInfo(paramMap));
            resultMap.put("msg", "恭喜你,添加记录成功!");
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", -1);
            resultMap.put("msg", "对不起,删除记录失败:"+e.getMessage());
        }
        return resultMap;
    }
    /**
     * 更新记录
     * @param
     * @return
     */
    public Map<String,Object> updateIpInfo(IpInfo ipInfo){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            resultMap.put("code", maintainDao.updateIpInfo(ipInfoBeanToMap(ipInfo)));
            resultMap.put("msg", "恭喜你,添加记录成功!");
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", -1);
            resultMap.put("msg", "对不起,删除记录失败:"+e.getMessage());
        }
        return resultMap;
    }

    /**
     *
     * @param
     * @return
     */
    public Map<String,Object> batchInsertIps(List<Map<String,Object>> resutList){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code", 1);
        try {
            if(CollectionUtils.isNotEmpty(resutList)){
                for(Map<String,Object> map:resutList){
                    Map<String,Object> paramMap = new HashedMap();
                    paramMap.put("ip",map.get("ip"));
                    List<Map<String,Object>> zombieInfos =  maintainDao.queryIpByCondition(paramMap);
                    if(!CollectionUtils.isNotEmpty(zombieInfos)){
                        maintainDao.addIpInfo(map);
                    }
                }
            }
            resultMap.put("code", 1);
            resultMap.put("msg", "恭喜你,添加记录成功!");
        }catch (Exception e){
            resultMap.put("code", -1);
            resultMap.put("msg", "对不起,添加记录失败:"+e.getMessage());
        }
        return resultMap;
    }

    /**
     * bean to map
     * @param ipInfo
     * @return
     */
    private Map ipInfoBeanToMap(IpInfo ipInfo){
        Map<String,Object> map = new HashedMap();
        map.put("id",ipInfo.getId());
        map.put("os",ipInfo.getOs());
        map.put("ip",ipInfo.getIp());
        map.put("businessName",ipInfo.getBusinessName());
        map.put("ipBusClassfy",ipInfo.getIpBusClassfy());
        map.put("description",ipInfo.getDescription());
        return map;
    }




    /**
     * bean to map
     * @param deviceInfo
     * @return
     */
    private Map deviceInfoBeanToMap(DeviceInfo deviceInfo){
        Map<String,Object> map = new HashedMap();
        map.put("id",deviceInfo.getId());
        map.put("deviceInfo",deviceInfo.getDeviceInfo());
        map.put("brand",deviceInfo.getBrand());
        map.put("deviceType",deviceInfo.getDeviceType());
        map.put("serialNum",deviceInfo.getSerialNum());
        map.put("cabinetNum",deviceInfo.getCabinetNum());
        map.put("laboratoryNum",deviceInfo.getLaboratoryNum());
        map.put("manageIp",deviceInfo.getManageIp());
        map.put("deviceIp",deviceInfo.getDeviceIp());
        map.put("businessClassfy",deviceInfo.getBusinessClassfy());
        map.put("businessDetail",deviceInfo.getBusinessDetail());
        map.put("maintain",deviceInfo.getMaintain());
        map.put("deviceLocation",deviceInfo.getDeviceLocation());
        return map;
    }


}
