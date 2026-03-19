package com.qq.e.comm.plugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i20 {
    private static volatile i20 b;
    private final Map<Integer, h20> a = new ConcurrentHashMap();

    private i20() {
    }

    public h20 c(int i) {
        a(i);
        return b(i);
    }

    public h20 b(int i) {
        h20 h20Var = this.a.get(Integer.valueOf(i));
        if (h20Var != null) {
            return h20Var;
        }
        h20 h20Var2 = new h20(i);
        this.a.put(Integer.valueOf(i), h20Var2);
        return h20Var2;
    }

    public void a(int i) {
        this.a.remove(Integer.valueOf(i));
    }

    public static i20 a() {
        if (b == null) {
            synchronized (i20.class) {
                if (b == null) {
                    b = new i20();
                }
            }
        }
        return b;
    }
}
