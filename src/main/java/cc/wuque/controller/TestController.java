package cc.wuque.controller;

import cc.wuque.util.SmsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 无缺
 * @Date 2021/3/21 13:58
 */
@Controller
public class TestController {

    public Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public String Test() {
        log.info("页面被访问");
        return "uploda.html";
    }




}
