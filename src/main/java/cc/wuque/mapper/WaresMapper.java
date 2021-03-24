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


    void addWares(Wares wares);


    void addWaresImg(String pid, String bigimg);

    String getPid(String pflag);

    List<Wares> findAllWares();

    Wares findWaresByPid(String pid);

    Wares findWaresByFlag(String pflag);

    List<Wares> findWaresByCid(String cid);

    List<Wares> findWaresByUid(String uid);

    void updateWares(Wares wares);
}
