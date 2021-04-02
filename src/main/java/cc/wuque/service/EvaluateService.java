package cc.wuque.service;

import cc.wuque.domain.Evaluate;

/**
 * Evaluate的service层接口
 * @Author 无缺
 * @Date 2021/4/2 22:23
 */
public interface EvaluateService {

    /**
     * 添加评价
     * @Author 无缺
     * @Date 2021/4/2 22:59
     * @param evaluate
     * @return
     */
    void addEvaluate(Evaluate evaluate);
}
