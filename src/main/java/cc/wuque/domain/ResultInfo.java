package cc.wuque.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * 用于返回请求的状态信息和序列化后的对象
 * @Author 无缺
 * @Date 2021/3/21 16:29
 */
public class ResultInfo implements Serializable {
    private boolean flag;
    private Object data;
    private String msg;

    public ResultInfo() {
    }



    public ResultInfo(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
