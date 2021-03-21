package cc.wuque.controller;

import cc.wuque.domain.ResultInfo;
import cc.wuque.domain.User;
import cc.wuque.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @Author 无缺
 * @Date 2021/3/19 21:27
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
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

    @RequestMapping("/querylist")
    public ResultInfo queryListUser(){
        List<User> userList = userService.queryListUser();
        ResultInfo resultInfo = new ResultInfo(true, userList, "查询成功");
        return resultInfo;
    }


}
