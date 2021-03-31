package cc.wuque.util;

import java.io.File;

public class UploadUtils {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认） 
    public final static String IMG_PATH_PREFIX = "upload/images";
    private static String FILE_PATH_PREFIX = "/upload/file";

    /**
     * 静态获取上传图片文件所存在的路径
     * @return
     */
    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/webapp/" + IMG_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    /**
     * 静态生成上传文件的路径
     * @Author 无缺
     * @Date 2021/3/31 18:05
     * @param
     * @return fileDir
     */
    public static  File getDirFile(){
        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/webapp/" + FILE_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}