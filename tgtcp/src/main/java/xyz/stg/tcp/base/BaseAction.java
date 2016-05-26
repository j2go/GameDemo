package xyz.stg.tcp.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * Created by tiangao on 2016/5/24.
 */
public abstract class BaseAction {

    public String getPara(String name) {
        return paras.getString(name);
    }
    public int getParaToInt(String name) {
        return paras.getIntValue(name);
    }
    public long getParaToLong(String name) {
        return paras.getLongValue(name);
    }

    private JSONObject paras;

    public void setParas(JSONObject object) {
        paras = object;
    }

    /**
     * 转发接口操作
     * @param cmd
     * @return
     */
    public abstract String excute(String cmd);

    public static void main(String[] args) {
        JSONObject json = JSON.parseObject("{\"cmd\":\"user@login\",\"username\":\"aaa\",\"password\":\"123456\"}");
        System.out.println(json.get("cmd"));
        System.out.println(json.get("username"));
        System.out.println(json.get("password"));
    }
}
