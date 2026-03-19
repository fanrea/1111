package com.bytedance.d.b.d.hc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile ThreadPoolExecutor b;
    private static volatile ScheduledExecutorService c;
    private static volatile d d;
    private static volatile ThreadPoolExecutor hc;
    private static final ConcurrentHashMap<String, b> u = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> an = new ConcurrentHashMap<>();

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private d() {
        hc = u.d();
        b = u.hc();
        c = u.b();
    }

    public void d(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (hc != null) {
            hc.execute(bVar);
        }
    }
}
