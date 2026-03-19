package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private com.kwad.sdk.crash.b.b bNr;
    private c bNs;
    private long bNt;

    /* synthetic */ e(byte b) {
        this();
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f fVarAeb = this.bNs.aeb();
        if (fVarAeb != null) {
            fVarAeb.a(i, exceptionMessage);
        }
    }

    static class a {
        private static final e bNu = new e(0);
    }

    private e() {
        this.bNr = new com.kwad.sdk.crash.b.b();
        this.bNs = new c.a().aee();
    }

    public static e aef() {
        return a.bNu;
    }

    public final String[] aeg() {
        return this.bNr.aes();
    }

    public final String[] aeh() {
        return this.bNr.aeh();
    }

    public final String getAppId() {
        return this.bNs.bMQ.mAppId;
    }

    public final String aei() {
        return this.bNs.bMP.bNU;
    }

    public final String getSdkVersion() {
        return this.bNs.bMP.mSdkVersion;
    }

    public final int aej() {
        return this.bNs.bMP.bNY;
    }

    public final void a(c cVar) {
        this.bNs = cVar;
        this.bNt = SystemClock.elapsedRealtime();
        this.bNr.a(cVar.bMS, cVar.bMT);
    }

    public final Context getContext() {
        return this.bNs.dR;
    }

    public final c aek() {
        return this.bNs;
    }

    public final h ael() {
        return this.bNs.bMR;
    }

    public final long aem() {
        return SystemClock.elapsedRealtime() - this.bNt;
    }

    public final boolean isDebug() {
        return this.bNs.aec();
    }
}
