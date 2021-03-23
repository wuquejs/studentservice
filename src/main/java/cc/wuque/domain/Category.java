package cc.wuque.domain;

import java.io.Serializable;

/**
 * 分类实体类
 *
 * @Author 无缺
 * @Date 2021/3/21 17:17
 */
public class Category implements Serializable {


    //分类id
    private String cid;
    //分类名
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "rid=" + cid +
                ", rname='" + cname + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setcid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String rname) {
        this.cname = rname;
    }
}
