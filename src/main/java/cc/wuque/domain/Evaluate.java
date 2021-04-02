package cc.wuque.domain;

import java.io.Serializable;

/**
 * 交易评价实体类
 * @Author 无缺
 * @Date 2021/4/1 23:21
 */
public class Evaluate implements Serializable {

    //评价主键id
    private int eid;

    //商品id
    private String pid;

    //订单id
    private int oid;

    //买家id
    private String b_uid;
    //卖家id
    private String s_uid;

    //评价内容
    private String content;

    //是否好评
    private int stater;

    //评论对象
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "eid=" + eid +
                ", pid='" + pid + '\'' +
                ", oid=" + oid +
                ", b_uid='" + b_uid + '\'' +
                ", s_uid='" + s_uid + '\'' +
                ", content='" + content + '\'' +
                ", stater=" + stater +
                ", target=" + target +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getB_uid() {
        return b_uid;
    }

    public void setB_uid(String b_uid) {
        this.b_uid = b_uid;
    }

    public String getS_uid() {
        return s_uid;
    }

    public void setS_uid(String s_uid) {
        this.s_uid = s_uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStater() {
        return stater;
    }

    public void setStater(int stater) {
        this.stater = stater;
    }
}
