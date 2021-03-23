package cc.wuque.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 * @Author 无缺
 * @Date 2021/3/23 16:14
 */
public class DateUtil {


    /**
     * 传入时间格式获取当前时间
     * @param pattern
     * @return
     */
    public static String getNowDate(String pattern){
        //创建时间对象
        Date date = new Date();
        //定义时间格式
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

}
