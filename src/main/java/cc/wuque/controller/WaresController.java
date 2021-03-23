package cc.wuque.controller;

import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.domain.Wares;
import cc.wuque.service.WaresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品信息
 *
 * @Author 无缺
 * @Date 2021/3/22 17:23
 */
@Controller
@ResponseBody
@RequestMapping("wares")
public class WaresController {

    private Logger log = LoggerFactory.getLogger(WaresController.class);


    @Autowired
    private WaresService waresService;

    @PostMapping("/addwares")
    public ResultInfo addWares(Wares wares, HttpServletRequest request){
        //创建时间对象
        Date date = new Date();
        //定义时间格式
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:");
        log.info("wares:" + wares.toString());
        if (wares.getPname() == null && wares.getPrice() == null && wares.getWaresIntroduce() ==null && wares.getPimage() == null){
            return new ResultInfo(false,wares,"添加失败，数据不能为空");
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUid() == null){
            return new ResultInfo(false,wares,"添加失败，请先登录！");
        }
        wares.setUid(user.getUid());
        wares.setCount(0);
        wares.setPdate(sd.format(date));
        waresService.addWares(wares);
        return new ResultInfo(true,null,"OK");
    }

}
