package com.example.demo.controller;


import com.example.demo.dto.JsonResultDto;
import com.example.demo.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiyajie on 16/8/22.
 */
@Controller
public class LoginController {


    /**
     * 登录入口
     * @return
     */
    @RequestMapping(value={"login.htm","login"},method = RequestMethod.GET)
    public String login(){
        return "privilege/login";
    }

    /**
     * 登录到首页
     * @param loginDto
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login.do", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultDto loginAction(@RequestBody LoginDto loginDto,
                                     HttpServletResponse response, HttpServletRequest request) throws Exception{
        String refer =request.getContextPath()+"/index";
        Boolean isLogin = false;
        if(isLogin){
            return new JsonResultDto(true,refer);
        }else {
            return new JsonResultDto(false);
        }
    }

    @RequestMapping(value={"/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletResponse response, HttpServletRequest request){
        ModelAndView view=new ModelAndView("privilege/index");
        view.addObject("catalogList",null);
        return view;
    }

    /**
     * 注销登录
     */
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public void logout(HttpServletResponse response, HttpServletRequest request) {
    }

}
