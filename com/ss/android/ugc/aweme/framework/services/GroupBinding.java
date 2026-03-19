package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class GroupBinding<T> {
    Map<Class<?>, Map<String, ServiceProvider<?>>> classProviderMaps;
    String groupName;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    /* JADX WARN: Multi-variable type inference failed */
    GroupBinding(Map<Class<?>, Map<String, ServiceProvider<?>>> map, Class<T> cls, String str, ServiceProvider<T> serviceProvider) {
        this.classProviderMaps = map;
        this.groupName = str;
        this.klass = cls;
        this.serviceProvider = serviceProvider;
        Map<String, ServiceProvider<?>> mapSynchronizedMap = map.get(cls);
        if (mapSynchronizedMap == null) {
            mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
            this.classProviderMaps.put(cls, mapSynchronizedMap);
        }
        mapSynchronizedMap.put(str, serviceProvider);
    }

    public GroupBinding<T> asSingleton() {
        if (!(this.serviceProvider instanceof SingletonProvider)) {
            Map map = this.classProviderMaps.get(this.klass);
            map.remove(this.serviceProvider);
            SingletonProvider singletonProvider = new SingletonProvider(this.serviceProvider);
            this.serviceProvider = singletonProvider;
            map.put(this.groupName, singletonProvider);
        }
        return this;
    }
}
