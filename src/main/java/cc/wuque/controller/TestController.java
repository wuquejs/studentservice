package cc.wuque.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Author 无缺
 * @Date 2021/3/21 13:58
 */
@Controller
@ResponseBody
public class TestController {

    public Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public void Test(HttpServletRequest request) {
        log.info("test被执行");
        //获取session
        HttpSession session = request.getSession();
        // 获取session中所有的键值
        Enumeration<String> attrs = session.getAttributeNames();
        // 遍历attrs中的
        while (attrs.hasMoreElements()) {
            // 获取session键值
            String name = attrs.nextElement();
            // 根据键值取session中的值
            Object vakue = session.getAttribute(name);
            log.info("------" + name + ":" + vakue + "--------\n");
            // 打印结果
            System.out.println("------" + name + ":" + vakue + "--------\n");
        }
    }
}