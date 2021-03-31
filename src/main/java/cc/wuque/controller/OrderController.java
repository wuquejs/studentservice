package cc.wuque.controller;

import cc.wuque.domain.Order;
import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.domain.Wares;
import cc.wuque.service.OrderService;
import cc.wuque.service.WaresService;
import cc.wuque.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 订单处理类
 * @Author 无缺
 * @Date 2021/3/30 15:01
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public Logger log = LoggerFactory.getLogger(WaresController.class);

    @Autowired
    private WaresService waresService;
    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     * @Author 无缺
     * @Date 2021/3/30 15:03
     * @param request, Wares,Order
     * @return ResultInfo
     */
    @RequestMapping("/addOrder")
    public ResultInfo addOrder(HttpServletRequest request, Wares wares,Order order){
        //判断商品id是否为空，如果为空则判断pflag是否为空如果全部为空则返回错误
        if (wares.getPid() == null){
            if (wares.getPflag() != null){
                //根据piflag查询商品信息
                wares = waresService.findWaresByFlag(wares.getPflag());
            }else {
                return new ResultInfo(false,null,"商品id和商品编号不能全部为空");
            }
        }else {
            wares = waresService.findWaresByPid(wares.getPid());
        }
        //log.info("Wares:" + wares.toString());
        order.setPid(wares.getPid());
        //set商品的分类id和商品id
        order.setPid(wares.getPid());
        order.setCid(wares.getCid());
        //set添加商品的当前时间
        order.setAddtime(DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
        //set商品的价格和卖家id
        order.setPrice(wares.getPrice());
        order.setS_uid(wares.getUid());

        //定义订单状态为待付款
        order.setStater(1);
        //通过session获取当前登录用户的uid为买家id
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        order.setB_uid("1");

        //log.info("Order:" + order.toString());
        //调用service层
        orderService.addOrder(order);
        return new ResultInfo(true,order,"成功");
    }
    
    /**
     * 更新订单状态
     * @Author 无缺
     * @Date 2021/3/30 16:32
     * @param  order, HttpServletRequest request
     * @return ResultInfo
     */
    @RequestMapping(value = "/updateOrder", params = "oid")
    public ResultInfo updateOrder(Order order, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            return new ResultInfo(false,null,"当前未登录，请先登录");
        }
        String s_uid = orderService.findS_uidByOid(order.getOid());
        String b_uid = orderService.findB_uidByOid(order.getOid());
        String uid = user.getUid();
//        log.info("s_uid = " + s_uid);
//        log.info("b_uid = " + b_uid);
//        log.info("uid = " + uid);
//        System.out.println(s_uid == uid);
//        System.out.println(b_uid == uid);
        //判断当前操作是否正确

        /**
         * 订单状态
         *      1 ：待付款
         *      2 ：待发货
         *      3 : 已发货
         *      4 ：确认收获
         */
        //如果传过来的Stater == 3 则更新状态为已发货
        if (order.getStater() == 3){
            //log.info("Stater = " + order.getStater());
            //判断当前操作所登录的用户是否有权限
            if (!s_uid.equals(uid)){
                return new ResultInfo(false,null,"您无权进行此操作");
            }else {
                orderService.updateOrder(order.getStater(),order.getOid());
                return new ResultInfo(true,null,"更新成功");
            }
            //如果传过来的Stater == 4 则更新状态为确认收货
        }else if (order.getStater() == 4){
            //判断买家uid是否和当前登录用户id相等，如果不相等，则返回无权操作
            if (!b_uid.equals(uid)){
                return new ResultInfo(false,null,"您无权进行此操作");
            }else {
                orderService.updateOrder(order.getStater(),order.getOid());

                return new ResultInfo(true,null,"更新成功");
            }
        }else {
            return new ResultInfo(false,null,"您提交的状态有误，请重新提交！");
        }
    }





}
