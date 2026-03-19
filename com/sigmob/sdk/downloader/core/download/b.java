package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    com.sigmob.sdk.downloader.core.cause.b a;
    private boolean b;
    private boolean c;
    private long d;
    private final com.sigmob.sdk.downloader.f e;
    private final com.sigmob.sdk.downloader.core.breakpoint.c f;

    public b(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
        this.e = task;
        this.f = info;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.a;
    }

    boolean a(int responseCode, long instanceLength, boolean isResumable) {
        return responseCode == 416 && instanceLength >= 0 && isResumable;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        com.sigmob.sdk.downloader.core.cause.b bVar = this.a;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.c);
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.b;
    }

    public long e() {
        return this.d;
    }

    public void f() throws IOException {
        g gVarG = com.sigmob.sdk.downloader.g.j().g();
        c cVarG = g();
        cVarG.a();
        boolean zC = cVarG.c();
        boolean zD = cVarG.d();
        long jB = cVarG.b();
        String strE = cVarG.e();
        String strF = cVarG.f();
        int iG = cVarG.g();
        gVarG.a(strF, this.e, this.f);
        this.f.a(zD);
        this.f.a(strE);
        if (com.sigmob.sdk.downloader.g.j().a().g(this.e)) {
            throw com.sigmob.sdk.downloader.core.exception.b.a;
        }
        com.sigmob.sdk.downloader.core.cause.b bVarA = gVarG.a(iG, this.f.i() != 0, this.f, strE);
        boolean z = bVarA == null;
        this.c = z;
        this.a = bVarA;
        this.d = jB;
        this.b = zC;
        if (a(iG, jB, z)) {
            return;
        }
        if (gVarG.a(iG, this.f.i() != 0)) {
            throw new i(iG, this.f.i());
        }
    }

    c g() {
        return new c(this.e, this.f);
    }

    public String toString() {
        return "acceptRange[" + this.b + "] resumable[" + this.c + "] failedCause[" + this.a + "] instanceLength[" + this.d + "] " + super.toString();
    }
}
