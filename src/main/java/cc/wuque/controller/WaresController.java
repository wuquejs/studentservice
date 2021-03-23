package cc.wuque.controller;

import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.domain.Wares;
import cc.wuque.service.WaresService;
import cc.wuque.util.DateUtil;
import cc.wuque.util.UuidUtil;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public Logger log = LoggerFactory.getLogger(WaresController.class);


    @Autowired
    private WaresService waresService;
    @PostMapping("/addwares")
    public ResultInfo addWares(Wares wares, HttpServletRequest request){

        if (wares.getPname() == null || wares.getPrice() == null || wares.getWaresIntroduce() ==null || wares.getCid() == null){
            return new ResultInfo(false,wares,"添加失败，数据不能为空");
        }
        if (wares.getImg() == null || wares.getPimage() ==null){
            wares.setImg("static/img/default.jpg");
            wares.setPimage("static/img/default.jpg");

        }
       /* User user = (User) request.getSession().getAttribute("user");
        if (user.getUid() == null){
            return new ResultInfo(false,wares,"添加失败，请先登录！");
        }*/
        wares.setUid("1");
        wares.setCount(0);
        wares.setPdate(DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
        wares.setPflag(DateUtil.getNowDate("yyyyMMddHHmmss") + UuidUtil.getRandom(1000));
        waresService.addWares(wares);
        return new ResultInfo(true,null,"OK");
    }

}
