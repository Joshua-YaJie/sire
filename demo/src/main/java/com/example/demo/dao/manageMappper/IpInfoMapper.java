package com.example.demo.dao.manageMappper;

import java.util.List;
import java.util.Map;

/**
 * Created by jiyajie on 16/10/10.
 */
public interface IpInfoMapper {
    List<Map<String,Object>> selectIpByCondition(Map<String, Object> map);

    Long selectIpCountsByCondition(Map<String, Object> map);

    Integer addIpInfo(Map<String, Object> map);

    Integer deleteIpInfo(Map<String, Object> map);

    Integer updateIpInfo(Map<String, Object> map);
}
