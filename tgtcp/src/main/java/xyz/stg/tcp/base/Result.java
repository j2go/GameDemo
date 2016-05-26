package xyz.stg.tcp.base;

/**
 * Created by tiangao on 2016/5/24.
 */
public class Result {
    public static String buildError(String errorMsg) {
        return "{\"state\":-1,\"errorMsg\":\"" + errorMsg + "\"}";
    }

    public static String buildNoActionError() {
        return "{\"state\":-1,\"errorMsg\":\"invinal action\"}";
    }
    public static String buildData(String data) {
        return "{\"state\":0,\"data\":" + data + "}";
    }
}
