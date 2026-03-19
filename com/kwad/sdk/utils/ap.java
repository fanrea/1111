package com.kwad.sdk.utils;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ap {
    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }

    public static boolean aM(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean aF(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj != null && obj.equals(obj2);
    }
}
