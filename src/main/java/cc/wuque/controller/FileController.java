package cc.wuque.controller;

import cc.wuque.domain.ResultInfo;
import cc.wuque.util.UploadUtils;
import cc.wuque.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;


/**
 * 文件处理
 *
 * @Author 无缺
 * @Date 2021/3/22 21:32
 */
@RestController
@RequestMapping("/file")
public class FileController {
    public Logger log = LoggerFactory.getLogger(FileController.class);

    /**
     * 单图片上传
     *
     * @param imgFile
     * @return
     */
    @RequestMapping("/uploadImg")
    public ResultInfo uploadImg(@RequestParam("imgFile") MultipartFile imgFile) {
        ResultInfo resultInfo = new ResultInfo(false, null, "上传失败，请重新上传");
        //判断文件是否存在
        if (imgFile.isEmpty()) {
            return resultInfo;
        }
        //获取文件名
        String fileName = imgFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        log.info("文件后缀名: " + suffixName);

        //定义上传的图片格式
        String[] suffix = {".PSD", ".PDD", ".GIF", ".JPEG", ".JPG", "PNG", "PDF"};

        //循环判断上传的图片格式是否和上传的格式相同，如果不同则直接返回
        for (int i = 0; i < suffix.length; i++) {
            if (suffixName.equalsIgnoreCase(suffix[i])) {
                resultInfo = upload(imgFile, suffixName);
                return resultInfo;
            }
        }
        resultInfo.setMsg("您上传的图片格式暂不支持，请选择受支持的文件格式！");

        return resultInfo;
    }

    @RequestMapping("/uploadFile")
    public ResultInfo uploadFile(@RequestParam("File") MultipartFile File) {
        ResultInfo resultInfo = new ResultInfo(false, null, "上传失败，请重新上传");
        //判断文件是否存在
        if (File.isEmpty()) {
            return resultInfo;
        }
        //获取文件名
        String fileName = File.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));


        resultInfo = upload(File,suffixName);


        return resultInfo;
    }

    /**
     * 上传文件方法,必备的参数文件、文件后缀
     * @Author 无缺
     * @Date 2021/3/31 18:17
     * @param file  suffixName
     * @return
     */
    private ResultInfo upload(MultipartFile file, String suffixName) {
        ResultInfo resultInfo = new ResultInfo(false,null,"上传失败!");
        String fileName;
        //使用UUID重命名文件
        fileName = UuidUtil.getUuid() + suffixName;

        //设置文件存储路径
        File filePath = UploadUtils.getImgDirFile();

        Calendar calendar = Calendar.getInstance();
        //获取当前年
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month > 12) {
            month = 12;
        }
        //获取当前月
        int yaer = calendar.get(Calendar.YEAR);
        log.info("年:" + yaer);
        try {
            //构建真实的文件路径
            File newFile = new File(filePath.getAbsolutePath() + File.separator + yaer + File.separator + month + File.separator + fileName);

            //检测目录是否存在
            if (!newFile.getParentFile().exists()) {
                //创建目录
                newFile.getParentFile().mkdirs();
            }

            file.transferTo(newFile);

            resultInfo.setFlag(true);
            resultInfo.setMsg("upload/images/" + yaer + "/" + month + "/" + fileName);
            return resultInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultInfo;
    }





}
