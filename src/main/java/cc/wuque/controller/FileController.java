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


/**
 * 文件处理
 * @Author 无缺
 * @Date 2021/3/22 21:32
 */
@RestController
@RequestMapping("/file")
public class FileController {
    public Logger log = LoggerFactory.getLogger(FileController.class);


    /**
     * 单图片上传
     * @param file
     * @return
     */
    @RequestMapping("/uploadImg")
    public ResultInfo file(@RequestParam("file") MultipartFile file){
        ResultInfo resultInfo = new ResultInfo(false,null,"上传失败，请重新上传");
        if (file.isEmpty()){
            return resultInfo;
        }

        //获取文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        fileName = UuidUtil.getUuid() + suffixName;

        //设置文件存储路径
        File filePath = UploadUtils.getImgDirFile();
        try {
            //构建真实的文件路径
            File newFile = new File(filePath.getAbsolutePath() + File.separator + fileName);
            //检测目录是否存在
            file.transferTo(newFile);

            resultInfo.setFlag(true);
            resultInfo.setMsg("upload/images/" + fileName);
            return resultInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultInfo.setMsg("上传失败！");
        return resultInfo;
    }


}
