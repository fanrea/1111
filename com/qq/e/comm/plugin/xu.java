package com.qq.e.comm.plugin;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xu {
    private static final String h = "kg";
    private static volatile xu i;
    private volatile List<String> b;
    private volatile List<String> c;
    private volatile String d;
    private volatile n9 e;
    private volatile int f;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final Runnable g = new a();

    private void a(String str, long j, int i2) {
        pro.getVresult(111, 0, this, str, Long.valueOf(j), Integer.valueOf(i2));
    }

    public void a(List<String> list, boolean z) {
        pro.getVresult(112, 0, this, list, Boolean.valueOf(z));
    }

    public void b() {
        pro.getVresult(113, 0, this);
    }

    private xu() {
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xu.this.b();
        }
    }

    public static xu a() {
        if (i == null) {
            synchronized (xu.class) {
                if (i == null) {
                    i = new xu();
                }
            }
        }
        return i;
    }
}
