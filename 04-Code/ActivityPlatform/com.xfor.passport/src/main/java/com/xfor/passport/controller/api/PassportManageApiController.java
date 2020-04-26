package com.xfor.passport.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportManageApiController {

    @RequestMapping("/login")
    public String login() {
        return "login ok";
    }
}
