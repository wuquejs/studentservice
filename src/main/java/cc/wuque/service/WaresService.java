package cc.wuque.service;

import cc.wuque.domain.Wares;

import java.util.List;

/**
 * 商品信息接口
 *
 * @Author 无缺
 * @Date 2021/3/22 17:29
 */
public interface WaresService {
    void addWares(Wares wares);

    List<Wares> findAllWares();

    Wares findWaresByPid(String pid);

    //Wares findWares(String uid);

    List<Wares> findWaresByUid(String uid);

    List<Wares> findWaresByCid(String cid);

    Wares findWaresByFlag(String pflag);
}
