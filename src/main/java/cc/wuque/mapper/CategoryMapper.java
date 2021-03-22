package cc.wuque.mapper;

import cc.wuque.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/21 17:19
 */
@Mapper
public interface CategoryMapper {

    /**
     * 查询所有分类
     * @return
     */
    List<Category> findAllCategory();

    /**
     * 查询分类是否存在
     * @param cname
     * @return
     */
    Category isCategory(String cname);

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);

    /**
     * 根据cid查询分类
     * @param cid
     * @return
     */
    Category findOneByCid(String cid);

    /**
     * 根据cid更新分类
     * @param c
     */
    void updateCategory(Category c);
}
