package com.example.web;

import com.example.entity.User;
import com.example.service.UserService;
import org.apache.tomcat.jni.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author sunwu
 * @since 2021-09-23-18:36
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    // 用户登录
    @RequestMapping(value = {"","/"})
    public String loginUser(){
        return "admin/login";
    }
    // 登录检查
    @PostMapping("/login")
    public String checkUser(String username, String password,
                            HttpSession session,
                            RedirectAttributes attributes){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userMsg  = userService.checkUser(user);
        if (userMsg != null){
            userMsg.setPassword("null"); //防止前端拿到密码
            session.setAttribute("user",userMsg);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误！");
            return  "redirect:/admin";
        }
    }

    // 用户注销
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
