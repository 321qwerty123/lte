package com.example.lte.api;

import cn.dev33.satoken.stp.StpUtil;
import com.example.lte.po.LoginPO;
import com.example.lte.po.PermPO;
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


    /**
     * {
     *     "userId": 5,
     *     "roleIds": [   //1个用户可对应多角色
     *         1,
     *         4
     *     ],
     *     "menuEntitySet": [    //合并多角色的菜单
     *         {
     *             "menuId": 2,
     *             "note": "用户管理",
     *             "routerName": "AccountManage",
     *             "routerPath": "/accountManage",
     *             "routerComponent": "AccountManage"
     *         },
     *         {
     *             "menuId": 1,
     *             "note": "个人中心",
     *             "routerName": "Personal",
     *             "routerPath": "/personal",
     *             "routerComponent": "Personal"
     *         }
     *     ],
     *     "buttonEntitySet": [   //合并多角色的按钮
     *         {
     *             "buttonId": 3,
     *             "buttonName": "addAccount",
     *             "note": "新增"
     *         },
     *         {
     *             "buttonId": 4,
     *             "buttonName": "delAccount",
     *             "note": "删除"
     *         },
     *         {
     *             "buttonId": 2,
     *             "buttonName": "editAccount",
     *             "note": "编辑"
     *         },
     *         {
     *             "buttonId": 1,
     *             "buttonName": "editPersonal",
     *             "note": "编辑"
     *         }
     *     ]
     * }
     * @param userId
     * @return
     */
    @GetMapping("/getPremByUserId")
    PermPO getPremByUserId(Long userId){
       return iUserService.getPremByUserId(userId);
    }



}
