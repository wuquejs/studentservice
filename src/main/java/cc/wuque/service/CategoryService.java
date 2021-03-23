package cc.wuque.service;

import cc.wuque.domain.Category;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/21 17:12
 */
public interface CategoryService {

    /**
     * 查询所有分类
     *
     * @return
     */
    List<Category> findAllByCategory();

    /**
     * 查询判断分类是否存在
     *
     * @param cname
     * @return
     */
    boolean isCategory(String cname);

    /**
     * 添加分类
     *
     * @param category
     * @return
     */
    boolean addCategory(Category category);

    /**
     * 根据cid查询分类
     *
     * @param cid
     * @return
     */
    Category findOneByCid(String cid);

    /**
     * 根据cid更新分类
     *
     * @param c
     */
    void updateCategory(Category c);

    /**
     * 根据cid查询分类
     *
     * @param cid
     */
    void deleteCategory(String cid);
}
