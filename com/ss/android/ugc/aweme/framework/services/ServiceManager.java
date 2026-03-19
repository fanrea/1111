package com.ss.android.ugc.aweme.framework.services;

import android.support.v4.d.b;
import android.text.TextUtils;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ServiceManager {
    final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap;
    public volatile boolean enableDynamicProxyDefault;
    final Map<Class<?>, Map<String, ServiceProvider<?>>> groupServiceProviderConcurrentHashMap;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

    public void setDynamicProxyEnableDefault(boolean z) {
        this.enableDynamicProxyDefault = z;
    }

    public void addLegacyService(Set<String> set) {
        this.legacyServiceSet.addAll(set);
    }

    public void addLegacyService(String str) {
        this.legacyServiceSet.add(str);
    }

    public <T> T getService(Class<T> cls, boolean z) {
        return (T) getService(cls, z, this.enableDynamicProxyDefault);
    }

    public <T> T getService(Class<T> cls) {
        return (T) getService(cls, false);
    }

    public <T> T getService(Class<T> cls, boolean z, boolean z2) {
        return (T) getService(cls, z, z2, false);
    }

    public <T> T getServiceForReal(Class<T> cls) {
        return (T) getService(cls, false, this.enableDynamicProxyDefault, true);
    }

    public <T> T getService(Class<T> cls, boolean z, boolean z2, boolean z3) {
        boolean z4;
        T t;
        if (z3 || !DowngradeImplManager.getInstance().isServiceForceDowngrade(cls)) {
            z4 = false;
            t = null;
        } else {
            t = (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
            if (t != null) {
                return t;
            }
            z4 = true;
        }
        Set<ServiceProvider<?>> set = this.classServiceProviderConcurrentHashMap.get(cls);
        if (set != null && !set.isEmpty() && !z) {
            Object[] array = set.toArray();
            if (array.length > 0) {
                t = (T) ((ServiceProvider) array[0]).get();
            }
        }
        if (t != null) {
            markResolved(cls);
            return t;
        }
        T t2 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(cls);
        if (t2 != null) {
            markResolved(cls);
            return t2;
        }
        if (z3) {
            return null;
        }
        T t3 = (T) getLegacyService(cls);
        if (t3 != null) {
            markResolved(cls);
            return t3;
        }
        if (!z4) {
            t3 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
        }
        if (t3 != null || !z2) {
            return t3;
        }
        new DynamicProxy();
        return (T) DynamicProxy.get(cls);
    }

    private void markResolved(Class cls) {
        this.resolvedClasses.add(cls);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider) {
        bindDowngradeImpl(cls, serviceProvider, true);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider, boolean z) {
        if (z) {
            serviceProvider = new SingletonProvider(serviceProvider);
        }
        DowngradeImplManager.getInstance().bindDowngradeImpl(cls, serviceProvider);
    }

    public boolean downgradeComponent(String str) {
        return downgradeComponent(str, false);
    }

    public boolean downgradeComponent(String str, boolean z) {
        if (!z) {
            Map<String, String> map = DowngradeImplManager.getInstance().componentsMap;
            for (String str2 : map.keySet()) {
                if (this.resolvedClasses.contains(str2) && TextUtils.equals(map.get(str2), str)) {
                    return false;
                }
            }
        }
        DowngradeImplManager.getInstance().downgradeComponent(str);
        return true;
    }

    private <T> T getLegacyService(Class<T> cls) {
        if (!this.legacyServiceSet.contains(cls.getName())) {
            return null;
        }
        Iterator it = ConfigLoader.iterator(cls);
        if (it.hasNext()) {
            return (T) it.next();
        }
        return null;
    }

    public ConcurrentHashMap getServiceProviderMap() {
        return this.classServiceProviderConcurrentHashMap;
    }

    public Map<Class<?>, Map<String, ServiceProvider<?>>> getGroupServiceProviderMap() {
        return this.groupServiceProviderConcurrentHashMap;
    }

    public <T> Set<T> getServices(Class<T> cls) {
        return getServices(cls, false);
    }

    public <T> Set<T> getServices(Class<T> cls, boolean z) {
        Set<T> staticServiceImplSet;
        Set<ServiceProvider<?>> set = this.classServiceProviderConcurrentHashMap.get(cls);
        if (set == null || set.isEmpty()) {
            Set<T> staticServiceImplSet2 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls);
            return (staticServiceImplSet2 == null || staticServiceImplSet2.isEmpty()) ? getLegacyServices(cls) : staticServiceImplSet2;
        }
        b bVar = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        for (Object obj : set.toArray()) {
            bVar.add(((ServiceProvider) obj).get());
        }
        if (z && (staticServiceImplSet = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls)) != null && !staticServiceImplSet.isEmpty()) {
            bVar.addAll(staticServiceImplSet);
        }
        return bVar;
    }

    public <T> Set<T> getLegacyServices(Class<T> cls) {
        b bVar = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (!this.legacyServiceSet.contains(cls.getName())) {
            return bVar;
        }
        Iterator it = ConfigLoader.iterator(cls);
        while (it.hasNext()) {
            bVar.add(it.next());
        }
        return bVar;
    }

    public boolean onPluginInstall(String str) {
        return PluginInstaller.INSTANCE.onPluginInstall(str);
    }

    public <T> Binding bind(Class<T> cls, ServiceProvider<T> serviceProvider) {
        return new Binding(this, cls, serviceProvider);
    }

    public <T> GroupBinding bind(Class<T> cls, String str, ServiceProvider<T> serviceProvider) {
        return new GroupBinding(this.groupServiceProviderConcurrentHashMap, cls, str, serviceProvider);
    }

    public <T> T getServiceByGroup(Class<T> cls, String str) {
        Map<String, ServiceProvider<?>> map = this.groupServiceProviderConcurrentHashMap.get(cls);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (T) map.get(str).get();
    }

    public static ServiceManager get() {
        return Holder.INSTANCE;
    }

    private ServiceManager() {
        this.classServiceProviderConcurrentHashMap = new ConcurrentHashMap<>();
        this.groupServiceProviderConcurrentHashMap = Collections.synchronizedMap(new HashMap());
        this.legacyServiceSet = Collections.synchronizedSet(new HashSet());
        this.enableDynamicProxyDefault = true;
        this.resolvedClasses = Collections.synchronizedSet(new HashSet());
    }

    private static final class Holder {
        private static final ServiceManager INSTANCE = new ServiceManager();

        private Holder() {
        }
    }
}
