package com.example.demo.dao;

import com.example.demo.dao.manageMappper.IpInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jiyajie on 16/10/8.
 */
@Repository
public class MaintainDao {

    @Autowired
    IpInfoMapper ipInfoMapper;


    /**
     *IpInfo
     */
    public List<Map<String,Object>> queryIpByCondition(Map<String,Object> map){
        return ipInfoMapper.selectIpByCondition(map);
    }

    public Long queryIpCountsByCondition(Map<String,Object> map){
        return ipInfoMapper.selectIpCountsByCondition(map);
    }


    public Integer addIpInfo(Map<String,Object> map){
        return ipInfoMapper.addIpInfo(map);
    }

    public Integer deleteIpInfo(Map<String,Object> map){
        return ipInfoMapper.deleteIpInfo(map);
    }

    public Integer updateIpInfo(Map<String,Object> map){
        return ipInfoMapper.updateIpInfo(map);
    }

}
