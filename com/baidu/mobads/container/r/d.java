package com.baidu.mobads.container.r;

import com.baidu.mobads.container.annotation.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends RouteInfo {
    private b a;

    public d(String str) {
        setPath(str);
        b();
    }

    public Object a() {
        return this.a;
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.annotation.remote." + getPath());
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("getRoutesMap", new Class[0]);
                declaredMethod.setAccessible(true);
                HashMap map = (HashMap) declaredMethod.invoke(null, new Object[0]);
                if (map != null && map.size() > 0 && (routeInfo = (RouteInfo) map.get(getPath())) != null) {
                    this.a = (b) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                }
            }
        } catch (Throwable th) {
        }
    }
}
