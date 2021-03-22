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

    Category isCategory(String cname);

    void addCategory(Category category);
}
