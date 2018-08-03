package com.example.demo.controller;


import com.example.demo.dao.MaintainDao;
import com.example.demo.domain.DeviceInfo;
import com.example.demo.domain.IpInfo;
import com.example.demo.domain.ZombieInfo;
import com.example.demo.service.MaintainService;
import com.example.demo.util.ExcelUtil;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * Created by jiyajie on 16/10/8.
 */
@Controller
public class MaintainController {
    @Autowired
    MaintainService maintainService;
    @Autowired
    MaintainDao maintainDao;
    /************肉鸡信息**************/

    /**
     * 列表入口
     * @return
     */
    @RequestMapping(value={"catalog/serverManage"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("catalog/zombieInfo");
        return mv;
    }


    /************肉鸡信息**************/

    /**
     * IP信息入口
     * @return
     */
    @RequestMapping(value={"catalog/ipManage"}, method = RequestMethod.GET)
    public ModelAndView ipInfo(){
        ModelAndView mv = new ModelAndView("catalog/ipInfo");
        return mv;
    }

    /**
     * 查询
     * @param ip
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value="catalog/queryIpList.do", method = RequestMethod.GET)
    @ResponseBody
    public Object getIpList(String ip,Integer pageIndex,Integer pageSize){
        Map<String,Object> resultMap = maintainService.queryIpByCondition(ip,pageIndex,pageSize);
        return resultMap;
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="catalog/delIpInfo.do")
    @ResponseBody
    public Object delIpInfo(Integer id){
        Map<String,Object> resultMap = maintainService.deleteIpInfo(id);
        return resultMap;
    }

    /**
     * 编辑
     * @param ipInfo
     * @return
     */
    @RequestMapping(value="catalog/editIpInfo.do")
    @ResponseBody
    public Object editZombieInfo(IpInfo ipInfo){
        Map<String,Object> resultMap = new HashMap<>();
        if(ipInfo.getId() == null){
            resultMap = maintainService.addIpInfo(ipInfo);
        }else{
            resultMap = maintainService.updateIpInfo(ipInfo);
        }
        return resultMap;
    }



    /**
     * 导出
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value="catalog/ipExport",method = RequestMethod.GET)
    @ResponseBody
    public String ipExport(HttpServletResponse response, HttpServletRequest request){
        List<Map<String,Object>> resultList = new ArrayList<>();
        String filename = "ipInfo.xls";
        ExcelUtil.setResponse(response, filename);
        String [] titleArr = new String [] {"业务名称","IP","系统","备注","IP段业务分类"};
        String [] fieldArr = new String [] {"ipBusClassfy","ip","os","description","ipBusClassfy"};
        Map<String,Object> map = new HashedMap();
        resultList.add(map);
        List<String> titleList= Arrays.asList(titleArr);
        List<String> fieldList= Arrays.asList(fieldArr);
        Map<String,Object> paramMap = new HashedMap();
        resultList = maintainDao.queryIpByCondition(paramMap);
        ExcelUtil.writeExcel(response, titleList,fieldList,resultList,filename);
        return "";
    }

    /**
     * 导入
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="catalog/ipUpload",method = RequestMethod.POST)
    public ModelAndView ipUpload(HttpServletResponse response, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("catalog/ipInfo");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream in =null;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        MultipartFile file = multipartRequest.getFile("fileName");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        resultMap =ExcelUtil.readIpExcel(in,file.getOriginalFilename());
        maintainService.batchInsertIps(resultMap);
        in.close();
        return mv;
    }



    /************设备信息**************/

    /**
     * Device信息入口
     * @return
     */
    @RequestMapping(value={"catalog/deviceManage"}, method = RequestMethod.GET)
    public ModelAndView deviceInfo(){
        ModelAndView mv = new ModelAndView("catalog/deviceInfo");
        return mv;
    }


}
