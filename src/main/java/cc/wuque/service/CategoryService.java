package cc.wuque.service;

import cc.wuque.domain.Category;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/21 17:12
 */
public interface CategoryService {

    List<Category> findAllByCategory();

}
