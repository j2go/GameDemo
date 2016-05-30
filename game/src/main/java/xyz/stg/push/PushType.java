package xyz.stg.push;

/**
 * Created by tiangao on 2016/5/25.
 */
public enum PushType {
    update(0), battle(1), chat(2);

    private int value;

    PushType(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
