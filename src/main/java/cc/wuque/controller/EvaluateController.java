package cc.wuque.controller;

import cc.wuque.domain.Evaluate;
import cc.wuque.domain.Order;
import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.service.EvaluateService;
import cc.wuque.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 商品评价控制层
 * @Author 无缺
 * @Date 2021/4/2 22:22
 */
@RestController
@RequestMapping("/Evaluate")
public class EvaluateController {

    public Logger log = LoggerFactory.getLogger(WaresController.class);

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private OrderService orderService;


    /**
     * 添加评价信息
     * @Author 无缺
     * @Date 2021/4/2 22:26
     * @param  evaluate
     * @return ResultInfo
     */
    @RequestMapping("/addEvaluate")
    public ResultInfo addEvaluate(Evaluate evaluate, HttpServletRequest request, @RequestParam("oid") int oid){

        //聪session中获取当前登录用户的信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断当前操作用户是否在session中
        if (user == null){
            return new ResultInfo(false,null,"操作失败请先登录");
        }

        //判断前台传过来的评价内容是否为空
        if (evaluate.getContent() == null || evaluate.getContent() == ""){
            return new ResultInfo(false,null,"评价失败，评价内容不能为空");
        }

        log.info("getStater： " + evaluate.getStater());

        //判断前台传过来的是否好评
        if (evaluate.getStater() != 1 && evaluate.getStater() != 2){
            return new ResultInfo(false,null,"评价失败，评价状态只允许好评或差评");
        }

        //根据前台传过来的oid查询订单信息
        Order order = orderService.findOrderByOid(oid);


        //获取session中的uid
        String uid = user.getUid();
        //根据session中的uid判断确定操作对象
        if (uid.equals(order.getS_uid())){
            evaluate.setTarget(order.getS_uid());
        }else if (uid.equals(order.getB_uid())){
            evaluate.setTarget(order.getB_uid());
        }else {
            return new ResultInfo(false,null,"操作失败，您当前登录用户权限不足无法操作");
        }

        evaluate.setPid(order.getPid());
        evaluate.setOid(order.getOid());
        evaluate.setB_uid(order.getB_uid());
        evaluate.setS_uid(order.getS_uid());

        evaluateService.addEvaluate(evaluate);

        return new ResultInfo(true,null,"评价成功");

    }


}
