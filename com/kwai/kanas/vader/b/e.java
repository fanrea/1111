package com.kwai.kanas.vader.b;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class e {
    private final long a;
    private long b;

    e(long j) {
        this.a = j;
        this.b = j;
    }

    void a() {
        this.b = this.a;
    }

    void b() {
        this.b *= 2;
        this.b = Math.min(this.b, TimeUnit.SECONDS.toMillis(10L));
    }

    long c() {
        return this.b;
    }
}
