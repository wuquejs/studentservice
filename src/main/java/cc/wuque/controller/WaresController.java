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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品信息
 *
 * @Author 无缺
 * @Date 2021/3/22 17:23
 */
@Controller
@ResponseBody
@RequestMapping("/wares")
public class WaresController {

    public Logger log = LoggerFactory.getLogger(WaresController.class);

    @Autowired
    private WaresService waresService;


    /**
     * 添加商品
     *
     * @param wares
     * @param request
     * @return
     */
    @PostMapping("/addwares")
    public ResultInfo addWares(Wares wares, HttpServletRequest request) {

        if (wares.getPname() == null || wares.getPrice() == null || wares.getWaresIntroduce() == null || wares.getCid() == null) {
            return new ResultInfo(false, wares, "添加失败，数据不能为空");
        }
        if (wares.getImg() == null || wares.getPimage() == null) {
            wares.setImg("static/img/default.jpg");
            wares.setPimage("static/img/default.jpg");

        }
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUid() == null) {
            return new ResultInfo(false, wares, "添加失败，请先登录！");
        }
        wares.setUid("1");
        wares.setCount(0);
        wares.setPdate(DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
        wares.setPflag(DateUtil.getNowDate("yyyyMMddHHmmss") + UuidUtil.getRandom(1000));
        waresService.addWares(wares);
        return new ResultInfo(true, null, "OK");
    }

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @RequestMapping("/findallwares")
    public ResultInfo findAllWares() {
        List<Wares> waresList = waresService.findAllWares();

        return new ResultInfo(true, waresList, "查询成功");
    }

    /**
     * 根据pid查找商品
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "/findwares", params = "pid")
    public ResultInfo findWaresByPid(@RequestParam("pid") String pid) {
        Wares wares = waresService.findWaresByPid(pid);
        return new ResultInfo(true, wares, "查找成功");
    }

    /**
     * 根据pflag查找商品
     *
     * @param pflag
     * @return
     */
    @RequestMapping(value = "/findwares", params = "pflag")
    public ResultInfo findWaresByPflag(@RequestParam("pflag") String pflag) {
        Wares wares = waresService.findWaresByFlag(pflag);
        return new ResultInfo(true, wares, "查找成功");
    }

    /**
     * 根据cid查找商品
     *
     * @param cid
     * @return
     */
    @RequestMapping(value = "/findwares", params = "cid")
    public ResultInfo findWaresByCid(@RequestParam("cid") String cid) {
        List<Wares> wares = waresService.findWaresByCid(cid);
        return new ResultInfo(true, wares, "查找成功");
    }

    /**
     * 根据uid查找商品
     *
     * @param uid
     * @return
     */

    @RequestMapping(value = "/findwares", params = "uid")
    public ResultInfo findWaresByUid(@RequestParam("uid") String uid) {
        List<Wares> wares = waresService.findWaresByUid(uid);
        return new ResultInfo(true, wares, "查找成功");
    }

    /**
     * @Description: 根据pid或pflag更改商品数据，pid、pflag二者不能全部为空
     * @Param: [wares]
     * @returns: ResultInfo
     * @Author: 无缺
     * @Date: 2021/3/24 20:40
     */

    @RequestMapping("/updatewares")
    public ResultInfo updateWares(Wares wares) {

        if (wares.getPid() == null && wares.getPflag() == null) {
            return new ResultInfo(false, null, "更新失败，请确保商品id或商品编号不为空！！");
        }
        waresService.updateWares(wares);

        return new ResultInfo(true, waresService.findWaresByPid(wares.getPid()), "更新成功");
    }

    /**
     * 根据商品pid或者pflag删除所对应的商品
     * @Author 无缺
     * @Date 2021/3/24 22:05
     * @param Wares
     * @return ResultInfo
     */
    @RequestMapping("/deletewares")
    public ResultInfo deleteWares(Wares wares){
        if (wares.getPid() == null && wares.getPflag() == null) {
            return new ResultInfo(false, null, "删除失败，请确保商品id或商品编号不为空！！");
        }
        waresService.deleteWares(wares);

        return new ResultInfo(true, waresService.findWaresByPid(wares.getPid()), "删除成功");
    }



}
