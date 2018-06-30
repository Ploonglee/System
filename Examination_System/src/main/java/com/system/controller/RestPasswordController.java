package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.Userlogin;
import com.system.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author 李鹏龙
 *
 */
@Controller
public class RestPasswordController {

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    // 本账户密码重置
    @RequestMapping(value = "/passwordRest", method = {RequestMethod.POST})
    public String passwordRest(String oldPassword, String password1) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        /*Md5Hash md5=new Md5Hash(oldPassword.getPassword());
        oldPassword.setPassword(md5.toString());*/
        Userlogin userlogin1 = new Userlogin();
        Md5Hash md5 = new Md5Hash(oldPassword);
        userlogin1.setPassword(md5.toString());
        
        Userlogin userlogin = userloginService.findByName(username);

        
        if (!userlogin1.getPassword().equals(userlogin.getPassword())) {
            throw new CustomException("旧密码不正确");
        } else {
        	Md5Hash md5_1 = new Md5Hash(password1);
            userlogin.setPassword(md5_1.toString());
            userloginService.updateByName(username, userlogin);
        }

        return "redirect:/logout";
    }

}
