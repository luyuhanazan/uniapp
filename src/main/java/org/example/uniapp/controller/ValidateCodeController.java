package org.example.uniapp.controller;

import org.example.uniapp.util.Result;
import org.example.uniapp.util.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class ValidateCodeController {

    @RequestMapping("/captchaImage")
    @ResponseBody
    public Result getCaptcha(HttpSession session, HttpServletResponse response) {

        try {

            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");

            ValidateCode validateCode = new ValidateCode();

            String sessionId = session.getId();
            // 直接返回图片
            return Result.success(200, sessionId, validateCode.getRandomCodeImage(session));

        } catch (Exception e) {
            System.out.println(e);
        }
        return Result.fail();
    }

}
