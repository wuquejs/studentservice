package cc.wuque.service.impl;

import cc.wuque.domain.Category;
import cc.wuque.domain.ResultInfo;
import cc.wuque.mapper.CategoryMapper;
import cc.wuque.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/21 17:19
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllByCategory() {
        return categoryMapper.findAllCategory();
    }

    @Override
    public boolean isCategory(String cname) {
        Category category = categoryMapper.isCategory(cname);
        if (category == null ){
            return true;
        }
        return false;
    }

    @Override
    public boolean addCategory(Category category) {
        if (isCategory(category.getCname())){
            categoryMapper.addCategory(category);
           return true;
        }else {
            return false;
        }
    }

    @Override
    public Category findOneByCid(String cid) {
        return categoryMapper.findOneByCid(cid);
    }

    @Override
    public void updateCategory(Category c) {
        categoryMapper.updateCategory(c);
    }
}
