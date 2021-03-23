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

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getRandom(int bound){
        Random random = new Random();
        return String.valueOf(random.nextInt(bound));
    }



}
