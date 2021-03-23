package cc.wuque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 *
 * @Author 无缺
 * @Date 2021/3/22 17:24
 */
public class Wares implements Serializable {

    //商品id
    private String pid;
    //商品名称、标题
    private String pname;
    //价格
    private Double price;
    //商品简介
    private String waresIntroduce;
    private String pflag;
    //商品上传时间
    private String pdate;
    //商品浏览次数
    private int count;
    //分类id
    private String cid;



    //商品主图
    private String img;
    //商品图片
    private List<String> pimage = new ArrayList<>();
    //卖家id
    private String uid;


    public Wares() {
    }

    @Override
    public String toString() {
        return "Wares{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", waresIntroduce='" + waresIntroduce + '\'' +
                ", pflag='" + pflag + '\'' +
                ", pdate=" + pdate +
                ", count='" + count + '\'' +
                ", cid='" + cid + '\'' +
                ", pimage='" + pimage + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getWaresIntroduce() {
        return waresIntroduce;
    }

    public void setWaresIntroduce(String waresIntroduce) {
        this.waresIntroduce = waresIntroduce;
    }

    public String getPflag() {
        return pflag;
    }

    public void setPflag(String pflag) {
        this.pflag = pflag;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<String> getPimage() {
        return pimage;
    }

    public void setPimage(List<String> pimage) {

        this.pimage = pimage;
    }
    public void setPimage(String pimg){
        pimage.add(pimg);
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
