package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Phoenix {
    public static Map<String, Cdo> a;
    public static Pyxis b;
    public static String c;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Phoenix$do, reason: invalid class name */
    public static class Cdo {
        public Aquila a;
        public int b = 0;

        public Cdo(Aquila aquila) {
            this.a = aquila;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new Cdo(new Taurus()));
        a.put("43780D5", new Cdo(new Taurus()));
        a.put("7CD3AF2", new Cdo(new Taurus()));
        a.put("22792AF", new Cdo(new Sculptor()));
        c = "";
        try {
            c = Octans.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
