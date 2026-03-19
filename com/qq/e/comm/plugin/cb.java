package com.qq.e.comm.plugin;

import java.util.concurrent.ExecutorService;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class cb {
    private int a;
    private int b;
    private boolean c;
    private ExecutorService d;

    private cb() {
        this.a = 30000;
        this.b = 30000;
        this.c = true;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public ExecutorService b() {
        return this.d;
    }

    public int a() {
        return this.a;
    }

    /* compiled from: A */
    public static class b {
        private final cb a = new cb();

        public b b(int i) {
            this.a.b = i;
            return this;
        }

        public cb a() {
            return this.a;
        }

        public b a(boolean z) {
            this.a.c = z;
            return this;
        }

        public b a(int i) {
            this.a.a = i;
            return this;
        }

        public b a(ExecutorService executorService) {
            this.a.d = executorService;
            return this;
        }
    }
}
