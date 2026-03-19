package com.bytedance.d.hc.d;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements Runnable {
    private volatile boolean b = false;
    private Runnable c = new Runnable() { // from class: com.bytedance.d.hc.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.b = false;
        }
    };
    private long d = d();
    private final b hc;

    c(b bVar) {
        this.hc = bVar;
        com.bytedance.d.hc.u.an.d(2L);
        com.bytedance.d.hc.u.u.d().d(4500L, this.c);
        com.bytedance.d.hc.u.u.d().d(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (this.b) {
            return;
        }
        if (hc()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.hc.d(i, str, 25)) {
            this.b = true;
        }
    }

    private long d() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean hc() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
