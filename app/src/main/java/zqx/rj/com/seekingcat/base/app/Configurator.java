package zqx.rj.com.seekingcat.base.app;

import java.util.HashMap;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.app
 * 文件名：  Configurator
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:52
 * 描述：    TODO
 */

class Configurator {

    private static final HashMap<Object, Object> CAT_CONFIGS = new HashMap<>();

    Configurator() {
        CAT_CONFIGS.put(ConfigType.CONFIG_READY, false);
    }

    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public <T> T getConfiguration(Object key) {

        checkConfiguration();
        Object value = CAT_CONFIGS.get(key);
        if (value == null){
            throw new NullPointerException(key.toString() + " IS NULL");
        }

        return (T) CAT_CONFIGS.get(key);
    }

    private void checkConfiguration() {
        boolean isReady = (boolean) CAT_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady){
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }


    public HashMap<Object, Object> getCatConfigs() {
        return CAT_CONFIGS;
    }


    public final void configure(){
        CAT_CONFIGS.put(ConfigType.CONFIG_READY, true);
    }
}
