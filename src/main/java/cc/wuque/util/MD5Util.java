package cc.wuque.util;

import java.security.MessageDigest;

/**
 * MD5加密类
 * @Author 无缺
 * @Date 2021/3/25 12:06
 * 加密结构
 * 123456 ----> e10adc3949ba59abbe56e057f20f883e
 */
public final class MD5Util {
    private MD5Util(){}
    /**
     * 将明文密码转成MD5密码
     */
    public static String encodeByMd5(String password) throws Exception{
        //Java中MessageDigest类封装了MD5和SHA算法，今天我们只要MD5算法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //调用MD5算法，即返回16个byte类型的值
        byte[] byteArray = md5.digest(password.getBytes());
        //注意：MessageDigest只能将String转成byte[]，接下来的事情，由我们程序员来完成
        return byteArrayToHexString(byteArray);
    }
    /**
     * 将byte[]转在16进制字符串
     */
    private static String byteArrayToHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        //遍历
        for(byte b : byteArray){//16次
            //取出每一个byte类型，进行转换
            String hex = byteToHexString(b);
            //将转换后的值放入StringBuffer中
            sb.append(hex);
        }
        return sb.toString();
    }
    /**
     * 将byte转在16进制字符串
     */
    private static String byteToHexString(byte b) {//-31转成e1，10转成0a，。。。
        //将byte类型赋给int类型
        int n = b;
        //如果n是负数
        if(n < 0){
            //转正数
            //-31的16进制数，等价于求225的16进制数
            n = 256 + n;
        }
        //商(14)，数组的下标
        int d1 = n / 16;
        //余(1)，数组的下标
        int d2 = n % 16;
        //通过下标取值
        return hex[d1] + hex[d2];
    }
    private static String[] hex = {"a","1","2","3","8","f","4","7","6","9","1","b","c","d","e","5"};

    public static void main(String[] args)  {
        String password = "123456";


    }






}
