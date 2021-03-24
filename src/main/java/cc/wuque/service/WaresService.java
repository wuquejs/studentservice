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

    /**
     * 添加商品
     *
     * @param wares
     */
    void addWares(Wares wares);

    /**
     * 查询全部商品
     *
     * @return
     */
    List<Wares> findAllWares();

    /**
     * 根据pid查询商品
     *
     * @param pid
     * @return
     */
    Wares findWaresByPid(String pid);

    /**
     * 根据uid查询商品
     *
     * @param uid
     * @return
     */
    List<Wares> findWaresByUid(String uid);

    /**
     * 根据cid查询商品
     *
     * @param cid
     * @return
     */
    List<Wares> findWaresByCid(String cid);

    /**
     * 根据pflag商品编号查询商品
     *
     * @param pflag
     * @return
     */
    Wares findWaresByFlag(String pflag);

    /**
     * 更新商品
     *
     * @param wares
     */
    void updateWares(Wares wares);

    /**
     * 根据商品pid或者pflag删除所对应的商品
     * @param wares
     */
    void deleteWares(Wares wares);
}


