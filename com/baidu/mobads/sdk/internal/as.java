package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class as extends RouteInfo {
    private y a;

    public as(String str) {
        setPath(str);
        b();
    }

    public Object a() {
        return this.a;
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Class<?> cls = Class.forName(z.ar + getPath());
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("getRoutesMap", new Class[0]);
                declaredMethod.setAccessible(true);
                HashMap map = (HashMap) declaredMethod.invoke(null, new Object[0]);
                if (map == null || map.size() <= 0 || (routeInfo = (RouteInfo) map.get(getPath())) == null) {
                    return;
                }
                this.a = (y) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
