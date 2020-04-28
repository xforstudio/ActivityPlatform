package com.xfor.passport.controller.api;

import com.xfor.passport.service.IPassportAuthManageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportAuthManageApiController {

    private IPassportAuthManageService passportAuthManageService;

    public PassportAuthManageApiController(IPassportAuthManageService passportAuthManageService) {
        this.passportAuthManageService = passportAuthManageService;
    }

    @RequestMapping(value = "/getLoginTokenByPassportAuthCode/{passportAuthCode}/{categoryID}",method = RequestMethod.POST)
    public String getLoginTokenByPassportAuthCode(
            @PathVariable String passportAuthCode,
            @PathVariable String categoryID) {
        var result = this.passportAuthManageService.getLoginTokenByPassportAuthCode(passportAuthCode, categoryID);
        return result;
    }

    @RequestMapping(value = "/getPassportAuthCodeByLoginToken/{loginToken}/{categoryID}",method = RequestMethod.POST)
    public String getPassportAuthCodeByLoginToken(
            @PathVariable String loginToken,
            @PathVariable String categoryID) {
        var result = this.passportAuthManageService.getPassportAuthCodeByLoginToken(loginToken, categoryID);
        return result;
    }
}
