package com.example.lte.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzh
 */
@RestController
public class LoginController {

    @GetMapping("/t")
    String  test1(){
        return "this is a test";
    }

}
