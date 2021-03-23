package cc.wuque.service.impl;

import cc.wuque.controller.WaresController;
import cc.wuque.domain.Wares;
import cc.wuque.mapper.WaresMapper;
import cc.wuque.service.WaresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 无缺
 * @Date 2021/3/22 17:30
 */
@Service
public class WaresImpl implements WaresService {

    public Logger log = LoggerFactory.getLogger(WaresController.class);

    @Autowired
    private WaresMapper waresMapper;

    @Override
    public void addWares(Wares wares) {
        log.info(wares.toString());
        waresMapper.addWares(wares);

        for (String bigimg : wares.getPimage()){
            log.info("pid:" + wares.getPid());
            waresMapper.addWaresImg(waresMapper.getPid(wares.getPflag()),bigimg);
        }


    }
}
