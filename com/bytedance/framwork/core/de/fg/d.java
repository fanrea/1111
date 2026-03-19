package com.bytedance.framwork.core.de.fg;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MonitorLogSender.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> b = new ConcurrentHashMap<>();

    public static void a(String str, c cVar) {
        a.put(str, cVar);
    }

    public static c a(String str) {
        return a.get(str);
    }

    public static void a(String str, b bVar) {
        b.put(str, bVar);
    }

    public static b b(String str) {
        return b.get(str);
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return b.get(str).a(str2);
    }
}
