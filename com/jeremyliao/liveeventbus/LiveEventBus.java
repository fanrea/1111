package com.jeremyliao.liveeventbus;

import com.jeremyliao.liveeventbus.core.Config;
import com.jeremyliao.liveeventbus.core.LiveEvent;
import com.jeremyliao.liveeventbus.core.LiveEventBusCore;
import com.jeremyliao.liveeventbus.core.Observable;
import com.jeremyliao.liveeventbus.core.ObservableConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LiveEventBus {
    public static <T> Observable<T> get(String str, Class<T> cls) {
        return LiveEventBusCore.get().with(str, cls);
    }

    public static <T> Observable<T> get(String str) {
        return get(str, Object.class);
    }

    public static <T extends LiveEvent> Observable<T> get(Class<T> cls) {
        return get(cls.getName(), cls);
    }

    public static Config config() {
        return LiveEventBusCore.get().config();
    }

    public static ObservableConfig config(String str) {
        return LiveEventBusCore.get().config(str);
    }
}
