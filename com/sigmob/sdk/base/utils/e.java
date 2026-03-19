package com.sigmob.sdk.base.utils;

import java.util.Collection;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    public static boolean a(int position, int size) {
        return position >= 0 && position < size;
    }

    public static boolean a(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean a(Map<?, ?> hashMap) {
        return hashMap == null || hashMap.isEmpty();
    }

    public static boolean a(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean b(Collection<?> list) {
        return !a(list);
    }

    public static boolean b(Map<?, ?> hashMap) {
        return !a(hashMap);
    }

    public static boolean b(Object[] array) {
        return !a(array);
    }
}
