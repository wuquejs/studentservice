package cc.wuque.service.impl;

import cc.wuque.domain.Category;
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
}
