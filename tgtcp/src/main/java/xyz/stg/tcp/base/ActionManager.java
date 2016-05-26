package xyz.stg.tcp.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiangao on 2016/5/24.
 */
public enum  ActionManager {
    ins;

    private Map<String, Class<BaseAction>> actionMap = new HashMap<String, Class<BaseAction>>();

    public void register(String moudle, Class clazz) {
        actionMap.put(moudle, clazz);
    }

    public Class getActionClass(String name) {
        return actionMap.get(name);
    }
}