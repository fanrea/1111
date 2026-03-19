package com.bytedance.sdk.component.mk.u.d;

import com.bytedance.sdk.component.mk.u.d.d.an;
import com.bytedance.sdk.component.mk.u.d.d.b;
import com.bytedance.sdk.component.mk.u.d.d.c;
import com.bytedance.sdk.component.mk.u.d.d.gb;
import com.bytedance.sdk.component.mk.u.d.d.h;
import com.bytedance.sdk.component.mk.u.d.d.u;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static final Map<Class, d> d;

    static {
        HashMap map = new HashMap();
        d = map;
        an anVar = new an();
        gb gbVar = new gb();
        h hVar = new h();
        com.bytedance.sdk.component.mk.u.d.d.hc hcVar = new com.bytedance.sdk.component.mk.u.d.d.hc();
        c cVar = new c();
        u uVar = new u();
        com.bytedance.sdk.component.mk.u.d.d.d dVar = new com.bytedance.sdk.component.mk.u.d.d.d();
        b bVar = new b();
        map.put(Integer.class, anVar);
        map.put(Integer.TYPE, anVar);
        map.put(Short.class, gbVar);
        map.put(Short.TYPE, gbVar);
        map.put(Long.class, hVar);
        map.put(Long.TYPE, hVar);
        map.put(Byte.class, hcVar);
        map.put(Byte.TYPE, hcVar);
        map.put(Double.class, cVar);
        map.put(Double.TYPE, cVar);
        map.put(Float.class, uVar);
        map.put(Float.TYPE, uVar);
        map.put(Boolean.class, dVar);
        map.put(Boolean.TYPE, dVar);
        map.put(Character.class, bVar);
        map.put(Character.TYPE, bVar);
    }

    public static void d(Object obj, Field field, Object obj2) {
        Object objD;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objD = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objD = d(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objD);
        } catch (Throwable unused2) {
        }
    }

    public static void d(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            d(obj, field, obj2);
        }
    }

    public static Object d(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        d dVar = d.get(cls);
        return dVar == null ? obj : dVar.d(cls, strValueOf);
    }
}
