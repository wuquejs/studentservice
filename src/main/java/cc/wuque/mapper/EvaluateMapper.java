package cc.wuque.mapper;

import cc.wuque.domain.Evaluate;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * 交易评价持久层
 * @Author 无缺
 * @Date 2021/4/2 22:23
 */
@Mapper
public interface EvaluateMapper {

    /**
     * 添加评价
     * @Author 无缺
     * @Date 2021/4/2 22:59
     * @param  evaluate
     * @return
     */
    void addEvaluate(Evaluate evaluate);
}
