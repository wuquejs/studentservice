package cc.wuque.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 验证码生成工具类
 * @Author 无缺
 * @Date 2021/3/22 0:49
 */
@Component
public class CheckCodeUtil {

    /**
     * 产生6位随机字符串
     */
    public static String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        return getString(base);
    }

    /**
     * 随机生成验证码
     * @param base
     * @return
     */
    public static String getString(String base) {
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 6; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 生成数字验证码
     * @return
     */
    public static String getCheckCodeNum(){
        String base = "0123456789";
        return getString(base);
    }
}
