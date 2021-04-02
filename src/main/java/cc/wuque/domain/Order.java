package cc.wuque.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * 订单实体类
 * @Author 无缺
 * @Date 2021/3/30 15:04
 */
public class Order implements Serializable {

    //订单id
    private int oid;
    //订单状态
    private int stater;
    //用户信息
    private String input1;
    //用户信息
    private String input2;
    //用户信息
    private String input3;
    //买家id
    private String b_uid;
    //卖家id
    private String s_uid;
    //付款金额
    private Double price;
    //订单创建时间
    private String addtime;
    //订单发货时间
    private String endtime;
    //订单结束时间
    private String overtime;
    //商品id
    private String pid;
    //分类id
    private String cid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", state='" + stater + '\'' +
                ", input1='" + input1 + '\'' +
                ", input2='" + input2 + '\'' +
                ", input3='" + input3 + '\'' +
                ", b_uid='" + b_uid + '\'' +
                ", s_uid='" + s_uid + '\'' +
                ", price='" + price + '\'' +
                ", addtime='" + addtime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", overtime='" + overtime + '\'' +
                ", pid='" + pid + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getStater() {
        return stater;
    }

    public void setStater(int stater) {
        this.stater = stater;
    }

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }

    public String getInput3() {
        return input3;
    }

    public void setInput3(String input3) {
        this.input3 = input3;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }
}
