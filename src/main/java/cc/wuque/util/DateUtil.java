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

    /**
     * @Description: 获取当前时间,单位ms
     * @Param: []
     * @returns: 当前时间
     * @Author: 无缺
     * @Date: 2021/3/24 21:28
     */
    public static Long getNowTime(){
        return System.currentTimeMillis();
    }

    /**
     * @Description: 传入一个方法运行的开始时间和结束时间，在控制台输出这个方法的运行时间 单位ms
     * @Param: [endTime, startTime]
     * @returns:
     * @Author: 无缺
     * @Date: 2021/3/24 21:28
     */
    public static void getCountTime(Long endTime, Long startTime){
        int time=(int) (endTime - startTime);
        System.err.println("运行时间:" + time + "ms");
    }


}
