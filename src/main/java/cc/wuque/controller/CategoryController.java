package cc.wuque.controller;

import cc.wuque.domain.Category;
import cc.wuque.domain.ResultInfo;
import cc.wuque.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类信息
 * @Author 无缺
 * @Date 2021/3/21 17:10
 */
@Controller
@RequestMapping(value = "/category", produces="application/json;charset=UTF-8")
@ResponseBody
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;


    /**
     * 查询所有分类
     * @return
     */
    @RequestMapping("/findAll")
    public ResultInfo findAllCategory(){
        List<Category> category = CategoryService.findAllByCategory();

        ResultInfo resultInfo = new ResultInfo(true, category, "查询成功");
        return resultInfo;
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @RequestMapping("/addCategory")
    public ResultInfo addCategory(Category category){
        boolean b = CategoryService.addCategory(category);
        List<Category> categorys = CategoryService.findAllByCategory();

        if (b){
            return new ResultInfo(b,categorys,"添加成功");
        }else {
            return new ResultInfo(b,categorys,"添加失败");
        }
    }

}
