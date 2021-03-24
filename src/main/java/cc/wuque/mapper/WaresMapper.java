package cc.wuque.mapper;

import cc.wuque.domain.Wares;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/22 20:55
 */
@Mapper
public interface WaresMapper {

    /**
     * 添加商品
     * @param wares
     */
    void addWares(Wares wares);

    /**
     * 添加商品图片
     * @param pid
     * @param bigimg
     */
    void addWaresImg(String pid, String bigimg);

    /**
     * 根据商品编号获取商品id
     * @param pflag
     * @return
     */
    String getPid(String pflag);

    /**
     * 查询所有商品
     * @return
     */
    List<Wares> findAllWares();

    /**
     * 根据pid查询商品
     * @param pid
     * @return
     */
    Wares findWaresByPid(String pid);

    /**
     * 根据商品编号查询商品
     * @param pflag
     * @return
     */
    Wares findWaresByFlag(String pflag);

    /**
     * 根据cid查询商品
     * @param cid
     * @return
     */
    List<Wares> findWaresByCid(String cid);

    /**
     * 根据uid查询商品
     * @param uid
     * @return
     */
    List<Wares> findWaresByUid(String uid);

    /**
     * 更新商品信息
     * @param wares
     */
    void updateWares(Wares wares);


    /**
     * 根据商品pid或者pflag删除所对应的商品
     * @param wares
     */
    void deleteWares(Wares wares);
}
