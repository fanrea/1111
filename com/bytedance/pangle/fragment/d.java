package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.an;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class d {
    public static void d(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) d(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldD = d(Fragment.class, "sClassMap");
            if (fieldD != null) {
                ((SimpleArrayMap) fieldD.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsD = d("androidx.fragment.app.FragmentFactory");
            if (clsD == null) {
                return;
            }
            Field fieldD2 = d(clsD, "sClassMap");
            if (fieldD2 != null) {
                ((SimpleArrayMap) fieldD2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldD3 = d(clsD, "sClassCacheMap");
            if (fieldD3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldD3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            an.d(e);
        }
    }

    private static Field d(Class cls, String str) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
