package cc.wuque.util;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * 生成uuid工具类
 *
 * @Author 无缺
 * @Date 2021/3/21 14:55
 */
@Component
public class UuidUtil {

    /**
     * 随机生成uuid 
     * @Author 无缺
     * @Date 2021/3/26 20:42
     * @param 
     * @return 
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    
    /**
     * 
     * @Author 无缺
     * @Date 2021/3/26 20:42
     * @param bound 
     * @return 
     */
    public static String getRandom(int bound){
        Random random = new Random();
        return String.valueOf(random.nextInt(bound));
    }



}
