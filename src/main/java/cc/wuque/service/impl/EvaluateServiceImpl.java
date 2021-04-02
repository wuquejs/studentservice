package cc.wuque.service.impl;


import cc.wuque.domain.Evaluate;
import cc.wuque.mapper.EvaluateMapper;
import cc.wuque.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EvaluateService的实现类
 * @Author 无缺
 * @Date 2021/4/2 22:24
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;


    @Override
    public void addEvaluate(Evaluate evaluate) {
        evaluateMapper.addEvaluate(evaluate);
    }
}
