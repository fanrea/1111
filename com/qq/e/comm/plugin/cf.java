package com.qq.e.comm.plugin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cf {
    private static final String l = "kg";
    private static volatile cf m;
    private volatile List<String> b;
    private volatile List<String> c;
    private volatile String d;
    private volatile n9 e;
    private volatile int f;
    private volatile n9 g;
    private volatile Random h;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private volatile long j = -1;
    private final Runnable k = new a();
    private final int i = r1.d().f().a("fhdsprct", 1000);

    private void a(String str, long j, int i) {
        pro.getVresult(341, 0, this, str, Long.valueOf(j), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        pro.getVresult(342, 0, this);
    }

    public void a(List<String> list, boolean z) {
        pro.getVresult(343, 0, this, list, Boolean.valueOf(z));
    }

    private cf() {
    }

    public static cf a() {
        if (m == null) {
            synchronized (cf.class) {
                if (m == null) {
                    m = new cf();
                }
            }
        }
        return m;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cf.this.b();
        }
    }
}
