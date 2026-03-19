package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class StaticServiceImplManager {
    private Map<String, Object> serviceImplCache = new ConcurrentHashMap();
    final Set<String> serviceImplNotExistSet = Collections.synchronizedSet(new HashSet());
    private Map<String, Set<Object>> serviceImplSetCache = new ConcurrentHashMap();
    final Set<String> serviceImplSetNotExistSet = Collections.synchronizedSet(new HashSet());

    private static class SingleInstanceHolder {
        private static final StaticServiceImplManager INSTANCE = new StaticServiceImplManager();

        private SingleInstanceHolder() {
        }
    }

    public static StaticServiceImplManager getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public <T> T getStaticServiceImpl(Class<T> cls) {
        String name = cls.getName();
        T t = (T) this.serviceImplCache.get(name);
        return (t != null || this.serviceImplNotExistSet.contains(name)) ? t : (T) getStaticServiceImplReal(cls);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> cls) {
        String name = cls.getName();
        Set<T> set = (Set) this.serviceImplSetCache.get(name);
        return (set != null || this.serviceImplSetNotExistSet.contains(name)) ? set : getStaticServiceImplSetReal(cls);
    }

    private <T> T getStaticServiceImplReal(Class<T> cls) {
        this.serviceImplNotExistSet.add(cls.getName());
        return null;
    }

    private void putStaticServiceImplCache(String str, Object obj) {
        this.serviceImplCache.put(str, obj);
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> cls) {
        this.serviceImplSetNotExistSet.add(cls.getName());
        return null;
    }

    private void putStaticServiceImplSetCache(String str, Set<Object> set) {
        this.serviceImplSetCache.put(str, set);
    }
}
