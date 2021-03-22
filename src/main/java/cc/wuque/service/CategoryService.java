package cc.wuque.service;

import cc.wuque.domain.Category;
import cc.wuque.domain.ResultInfo;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/21 17:12
 */
public interface CategoryService {

    /**
     * 查询所有分类
     * @return
     */
    List<Category> findAllByCategory();

    boolean isCategory(String cname);

    boolean addCategory(Category category);

}
