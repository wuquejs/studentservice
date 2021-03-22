package cc.wuque.controller;

import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.service.UserService;

import cc.wuque.util.CheckCodeUtil;
import cc.wuque.util.SmsUtil;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20190711.models.SendStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


/**
 *
 * @Author 无缺
 * @Date 2021/3/19 21:27
 */
@Controller
@ResponseBody
@RequestMapping(value = "/user", produces="application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SmsUtil smsUtil;
    /**
     * 注册用户
     * @param user
     * @param checkCode
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public ResultInfo register(User user, @RequestParam("checkCode") String checkCode, HttpServletRequest request){
        //获取存放在session中的验证码，并强转为String类型，用于比较
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //删除保存在session中的验证码，保证验证码只能被使用一次
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        ResultInfo resultInfo = new ResultInfo();
        if (checkcode_server == null || !checkcode_server.equals(checkCode)){
            resultInfo.setFlag(false);
            resultInfo.setMsg("验证码错误");
            return resultInfo;

        }
        userService.register(user);
        resultInfo.setFlag(true);
        resultInfo.setMsg("验证码错误");
        return resultInfo;
    }

    /**
     * 查询username是否重复，保证username的唯一性
     * @param username
     * @return
     */
    @RequestMapping("/findbyusername")
    @ResponseBody
    public ResultInfo findByUsername(@RequestParam("username") String username){
        ResultInfo resultInfo = new ResultInfo(true,null,"用户名不存在");
        if (!userService.findByUsername(username)){
            resultInfo.setFlag(false);
            resultInfo.setMsg("用户名已存在");
        }
        return resultInfo;
    }

    /**
     * 使用username、password登录
     * @param request
     * @param user
     * @param checkCode
     * @return
     */
    @RequestMapping("/login")
    public ResultInfo loginByUsernameAndPassword(HttpServletRequest request, User user, @RequestParam("checkCode") String checkCode){
        //获取session
        HttpSession session = request.getSession();
        //获取session中的验证码，并强转为String类型
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //删除session中的验证码，保证验证码只能被使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        ResultInfo resultInfo = new ResultInfo();
        if (checkcode_server == null || !checkcode_server.equals(checkCode)){
            resultInfo.setFlag(false);
            resultInfo.setMsg("验证码错误");
            return resultInfo;
        }
        //调用service中的登录方法
        User u = userService.loginByUsernameAndPassword(user);
        //判断u是否为空
        if (u != null){
            session.setAttribute("user",u);
            resultInfo.setFlag(true);
            resultInfo.setMsg("登录成功");
            resultInfo.setData(u);
            return resultInfo;
        }else {
            resultInfo.setFlag(false);
            resultInfo.setMsg("账号或密码错误");
            return resultInfo;
        }

    }

    /**
     * 退出当前账户
     * @param request
     * @param response
     */
    @RequestMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        try {
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/querylist")
    public ResultInfo queryListUser(){
        List<User> userList = userService.queryListUser();
        ResultInfo resultInfo = new ResultInfo(true, userList, "查询成功");
        return resultInfo;
    }
    /**
     * 获取一个随机的6位验证码
     * 图片大小：100 x 30
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0,0, width,height);

        //产生6个随机验证码，
        String checkCode = CheckCodeUtil.getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体",Font.BOLD,24));
        //向图片上写入验证码
        g.drawString(checkCode,15,25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image,"PNG",response.getOutputStream());
    }

    /**
     * 发送一个六位数的手机验证码
     * @param phoneNumber
     * @param request
     * @return
     */
    @RequestMapping("/getCheckNum")
    public ResultInfo getCheckCodeNum(@RequestParam("phoneNumber") String phoneNumber,HttpServletRequest request){
        String codeNum = CheckCodeUtil.getCheckCodeNum();

        SendSmsResponse sendSmsResponse = smsUtil.sendSms(phoneNumber, codeNum);
        System.out.println(sendSmsResponse.getSendStatusSet());
        System.out.println(sendSmsResponse.getRequestId());
        SendStatus[] s = sendSmsResponse.getSendStatusSet();
        ResultInfo resultInfo = new ResultInfo(false,null,s[0].getMessage());
        if (s[0].getCode() == "OK" && s[0].getCode().equals("OK")){
            request.getSession().setAttribute("PHONE_NUMBER_CHECKCODE",codeNum);
            resultInfo.setFlag(true);
            return resultInfo;
        }
        return resultInfo;
    }

}
