package cc.wuque.mapper;

import cc.wuque.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:26
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUserList();

    /**
     * 查询用户名是否重复
     * @param username
     * @return
     */
    String findByUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    void register(User user);

    /**
     * 使用账号密码登录
     * @param user
     * @return
     */
    User loginByUsernameAndPassword(User user);


    /**
     * 使用手机号登录
     * @param phoneNumber
     * @return
     */
    User findByPhoneNumber(String phonenumber);
}
