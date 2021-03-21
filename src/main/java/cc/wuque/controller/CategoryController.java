package cc.wuque.controller;

import cc.wuque.domain.Category;
import cc.wuque.domain.ResultInfo;
import cc.wuque.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类信息
 * @Author 无缺
 * @Date 2021/3/21 17:10
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @RequestMapping("/findAll")
    public ResultInfo findAllCategory(){
        List<Category> category = service.findAllByCategory();

        ResultInfo resultInfo = new ResultInfo(true, category, "查询成功");
        return resultInfo;
    }

}
