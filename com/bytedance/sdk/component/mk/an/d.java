package com.bytedance.sdk.component.mk.an;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends hc {
    private d() {
    }

    public static d d() {
        if (d != null) {
            return d;
        }
        synchronized (d.class) {
            if (d != null) {
                return d;
            }
            d dVar = new d();
            d = dVar;
            return dVar;
        }
    }

    public com.bytedance.sdk.component.mk.d.d.d d(com.bytedance.sdk.component.mk.d.d.d dVar) {
        try {
            Class<?> cls = dVar.getClass();
            return (cls.isAnnotationPresent(com.bytedance.sdk.component.mk.hc.hc.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.mk.hc.hc) cls.getAnnotation(com.bytedance.sdk.component.mk.hc.hc.class)).d())) ? (com.bytedance.sdk.component.mk.d.d.d) cls.newInstance() : dVar;
        } catch (Throwable unused) {
            return dVar;
        }
    }

    public void d(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.mk.hc.hc.class)) {
            d(obj, map, cls);
        }
    }

    private static void d(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.mk.hc.d dVar;
        for (Field field : d(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.mk.hc.d.class) && (dVar = (com.bytedance.sdk.component.mk.hc.d) field.getAnnotation(com.bytedance.sdk.component.mk.hc.d.class)) != null) {
                field.setAccessible(true);
                String strD = dVar.d();
                if (TextUtils.isEmpty(strD)) {
                    strD = com.bytedance.sdk.component.mk.gb.d.d(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strD)) {
                    com.bytedance.sdk.component.mk.u.d.hc.d(obj, map, field, strD);
                }
            }
        }
    }

    public static Field[] d(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
