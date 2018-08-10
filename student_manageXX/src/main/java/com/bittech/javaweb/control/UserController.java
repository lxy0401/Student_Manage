package com.bittech.javaweb.control;

import com.bittech.javaweb.entity.User;
import com.bittech.javaweb.service.UserService;
import com.bittech.javaweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/8/6 16:14
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    protected static final String CURRENT_USER = "currentUser";

    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    protected void login(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password,
            HttpSession session
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("password", password);
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            modelAndView.addObject("error", "用户名或密码为空！");
            modelAndView.setViewName("index");
            return;
        }
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        boolean loginResult = userService.login(userName, password);
        if (loginResult) {
            session.setAttribute(CURRENT_USER, user);
            // 客户端跳转
            modelAndView.setViewName("main");
        } else {
            modelAndView.addObject("error", "用户名或密码错误！");
            // 服务器跳转
            modelAndView.setViewName("index");

        }
    }
}
