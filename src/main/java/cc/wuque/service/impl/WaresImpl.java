package cc.wuque.service.impl;

import cc.wuque.domain.Wares;
import cc.wuque.mapper.WaresMapper;
import cc.wuque.service.WaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 无缺
 * @Date 2021/3/22 17:30
 */
@Service
public class WaresImpl implements WaresService {

    @Autowired
    private WaresMapper waresMapper;

    @Override
    public void addWares(Wares wares) {

    }
}
