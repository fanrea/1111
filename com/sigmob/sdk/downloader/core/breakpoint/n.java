package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.breakpoint.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class n {
    long a;
    private final m b;

    n(final m.a agent) {
        this(new m(agent));
    }

    n(final m executor) {
        this.b = executor;
        this.a = 1500L;
    }

    void a() {
        this.b.a();
    }

    boolean a(int id) {
        return !this.b.a(id);
    }

    void b(int id) {
        this.b.e(id);
        this.b.a(id, this.a);
    }

    void c(int id) {
        this.b.e(id);
        try {
            if (this.b.a(id)) {
                return;
            }
            this.b.b(id);
        } finally {
            this.b.d(id);
        }
    }

    void d(int id) {
        this.b.e(id);
        this.b.c(id);
    }
}
