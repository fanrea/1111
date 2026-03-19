package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DowngradeImplManager {
    private Map<String, ServiceProvider> downgradeImplMap = new ConcurrentHashMap();
    private Map<String, Object> staticDowngradeImplCache = new ConcurrentHashMap();
    final Map<String, String> componentsMap = new ConcurrentHashMap();
    final Set<String> downgradeComponents = Collections.synchronizedSet(new HashSet());
    final Set<String> staticDowngradeNotExistSet = Collections.synchronizedSet(new HashSet());

    private void addServiceComponent(String str, String str2) {
        this.componentsMap.put(str, str2);
    }

    private static class SingleInstanceHolder {
        private static final DowngradeImplManager INSTANCE = new DowngradeImplManager();

        private SingleInstanceHolder() {
        }
    }

    public static DowngradeImplManager getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public <T> T getDowngradeImpl(Class<T> cls) {
        String name = cls.getName();
        ServiceProvider serviceProvider = this.downgradeImplMap.get(name);
        if (serviceProvider != null) {
            return (T) serviceProvider.get();
        }
        T t = (T) this.staticDowngradeImplCache.get(name);
        return (t != null || this.staticDowngradeNotExistSet.contains(name)) ? t : (T) getStaticDowngradeImpl(cls);
    }

    private <T> T getStaticDowngradeImpl(Class<T> cls) {
        this.staticDowngradeNotExistSet.add(cls.getName());
        return null;
    }

    private void putStaticDowngradeImplCache(String str, Object obj) {
        this.staticDowngradeImplCache.put(str, obj);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider) {
        this.downgradeImplMap.put(cls.getName(), serviceProvider);
    }

    public void downgradeComponent(String str) {
        if (TextUtils.isEmpty(str) || this.downgradeComponents.contains(str)) {
            return;
        }
        this.downgradeComponents.add(str);
    }

    public boolean isServiceForceDowngrade(Class cls) {
        String str = this.componentsMap.get(cls.getName());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.downgradeComponents.contains(str);
    }
}
