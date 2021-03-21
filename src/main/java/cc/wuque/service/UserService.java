package cc.wuque.service;

import cc.wuque.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:33
 */


public interface UserService {

    /**
     * 查询用户名是否唯一
     * @param username
     * @return
     */
    boolean findByUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    void register(User user);

    /**
     * 使用用户名和密码登录
     * @param user
     * @return
     */
    User loginByUsernameAndPassword(User user);

    List<User> queryListUser();
}
