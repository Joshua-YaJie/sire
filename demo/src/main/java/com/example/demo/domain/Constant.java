package com.example.demo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyajie on 16/9/29.
 */
public class Constant {

    public static Map<String,Object>  hashMap = new HashMap();


    static {
        hashMap.put("string",0);
        hashMap.put("set",1);
        hashMap.put("list",2);
        hashMap.put("hash",3);
        hashMap.put("sorted set",4);
    }


}
