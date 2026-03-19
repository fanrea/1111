package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.pe;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class ti {
    private final AtomicInteger a = new AtomicInteger(0);
    private final String b;
    private final int c;
    private volatile si d;

    ti(String str, int i) throws vu {
        this.b = (String) lu.a(str);
        this.c = i;
    }

    private synchronized void c() throws vu {
        this.d = this.d == null ? b() : this.d;
    }

    synchronized void a(String str) {
        if (this.d != null) {
            this.d.a(str);
        }
    }

    private si b() throws vu {
        si siVar;
        pe peVar = new pe(this.b);
        if (this.c > 0) {
            siVar = new vi(peVar, this.b);
        } else {
            siVar = new si(peVar, this.b);
        }
        peVar.a(new a(siVar));
        siVar.a(peVar.g());
        return siVar;
    }

    /* compiled from: A */
    class a implements pe.a {
        final /* synthetic */ si a;

        a(si siVar) {
            this.a = siVar;
        }

        @Override // com.qq.e.comm.plugin.pe.a
        public void a(boolean z) {
            this.a.a(z);
        }
    }

    private synchronized void a() {
        if (this.a.decrementAndGet() <= 0) {
            this.d.b();
            this.d = null;
        }
    }

    void a(vh vhVar, Socket socket) throws IOException, vu {
        c();
        try {
            this.a.incrementAndGet();
            this.d.a(vhVar, socket);
        } finally {
            a();
        }
    }
}
