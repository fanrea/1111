package com.qq.e.comm.plugin.apkmanager;

import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.yh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class b {
    private static final long c = r1.d().f().a("cimt", 64) * 1000;
    private static final boolean d;
    private final InterfaceC0697b a;
    private final Map<String, Long> b = new ConcurrentHashMap();

    /* compiled from: A */
    private class a implements Runnable {
        private final String a;
        private final long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        private long a() {
            Long l = (Long) b.this.b.get(this.a);
            long jLongValue = l == null ? this.b : l.longValue();
            if (jLongValue > b.c) {
                return -1L;
            }
            return jLongValue * 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApkDownloadTask apkDownloadTask = new ApkDownloadTask(this.a);
            if (b.this.a == null || !b.this.a.c(this.a)) {
                t3.b(1100918, apkDownloadTask, 1);
                b.this.b.remove(this.a);
                return;
            }
            if (yh.a("hieib") && !b.d && !s3.b().c()) {
                t3.b(1100918, apkDownloadTask, 4);
                b.this.b.remove(this.a);
                return;
            }
            if (h10.f(com.qq.e.comm.plugin.n.a().d(r1.d().a(), this.a))) {
                b.this.a.a(this.a);
                t3.b(1100918, apkDownloadTask, 2);
                b.this.b.remove(this.a);
            } else {
                long jA = a();
                if (jA > 0) {
                    b.this.a(this.a, jA);
                } else {
                    t3.b(1100918, apkDownloadTask, 3);
                    b.this.b.remove(this.a);
                }
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.b$b, reason: collision with other inner class name */
    interface InterfaceC0697b {
        void a(String str);

        boolean c(String str);
    }

    static {
        d = r1.d().f().a("aicwibg", 1) == 1;
    }

    b(InterfaceC0697b interfaceC0697b) {
        this.a = interfaceC0697b;
    }

    synchronized void a(String str) {
        if (this.b.get(str) == null) {
            a(str, 2000L);
        }
        this.b.put(str, 2000L);
        t3.b(1100919, new ApkDownloadTask(str), 0);
    }

    synchronized void a(String str, long j) {
        qg.f.schedule(new a(str, j), j, TimeUnit.MILLISECONDS);
    }
}
