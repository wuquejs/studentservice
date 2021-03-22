package cc.wuque.controller;

import cc.wuque.util.SmsUtil;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author 无缺
 * @Date 2021/3/21 13:58
 */
@Controller
public class TestController {
    @Autowired
   private SmsUtil sendSms;

    @RequestMapping("/test")
    @ResponseBody
    public String Test(){
        //SmsUtil s = new SmsUtil();
       /* SendSmsResponse s = sendSms.sendSms("17630993210");
        System.out.println(sendSms.toString());*/

        return "s.toString()";
    }




}
