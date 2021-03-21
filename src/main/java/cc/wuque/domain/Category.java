package cc.wuque.domain;

import java.io.Serializable;

/**
 * 分类实体类
 * @Author 无缺
 * @Date 2021/3/21 17:17
 */
public class Category implements Serializable {


    //分类id
    private int rid;
    //分类名
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "rid=" + rid +
                ", rname='" + cname + '\'' +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String rname) {
        this.cname = rname;
    }
}
