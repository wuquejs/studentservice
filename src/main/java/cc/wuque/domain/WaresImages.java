package cc.wuque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品图片实体类
 * @Author 无缺
 * @Date 2021/3/23 18:07
 */
public class WaresImages implements Serializable {
    private String pgid;
    private String pid;
    private List<String> bigimg = new ArrayList<>();
    private List<String> smallimg = new ArrayList<>();

    @Override
    public String toString() {
        return "WaresImages{" +
                "pgid='" + pgid + '\'' +
                ", pid='" + pid + '\'' +
                ", bigimg='" + bigimg + '\'' +
                ", smallimg='" + smallimg + '\'' +
                '}';
    }

    public String getPgid() {
        return pgid;
    }

    public void setPgid(String pgid) {
        this.pgid = pgid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<String> getBigimg() {
        return bigimg;
    }

    public void setBigimg(List<String> bigimg) {
        this.bigimg = bigimg;
    }
    public void setBigimg(String bigimg) {
        this.bigimg.add(bigimg);
    }

    public List<String> getSmallimg() {
        return smallimg;
    }

    public void setSmallimg(List<String> smallimg) {
        this.smallimg = smallimg;
    }
    public void setSmallimg(String smallimg) {
        this.smallimg.add(smallimg);
    }
}
