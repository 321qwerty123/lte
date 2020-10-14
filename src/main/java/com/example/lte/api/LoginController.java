package com.example.lte.api;

import cn.dev33.satoken.stp.StpUtil;
import com.example.lte.po.LoginPO;
import com.example.lte.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzh
 */
@RestController
public class LoginController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/t")
    String  test1(){
        return "this is a test";
    }


    @GetMapping("/login")
    LoginPO login(String account,String pwd){
       return iUserService.doLogin(account, pwd);
    }

    @GetMapping("/isLogin")
    String isLogin(){
        if (StpUtil.isLogin()){
            return "已登录";
        }else {
            return "未登录";
        }
    }



}
