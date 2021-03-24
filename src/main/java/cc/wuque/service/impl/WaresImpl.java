package cc.wuque.service.impl;

import cc.wuque.controller.WaresController;
import cc.wuque.domain.Wares;
import cc.wuque.mapper.WaresMapper;
import cc.wuque.service.WaresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Wares> findAllWares() {
        return waresMapper.findAllWares();
    }

    @Override
    public Wares findWaresByPid(String pid) {
        return waresMapper.findWaresByPid(pid);
    }

    @Override
    public List<Wares> findWaresByUid(String uid) {
        return waresMapper.findWaresByUid(uid);
    }

    @Override
    public List<Wares> findWaresByCid(String cid) {
        return waresMapper.findWaresByCid(cid);
    }

    @Override
    public Wares findWaresByFlag(String pflag) {
        return waresMapper.findWaresByFlag(pflag);
    }

    @Override
    public void updateWares(Wares wares) {
        waresMapper.updateWares(wares);
    }

    @Override
    public void deleteWares(Wares wares) {
        waresMapper.deleteWares(wares);
    }


}
