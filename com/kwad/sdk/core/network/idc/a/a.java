package com.kwad.sdk.core.network.idc.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private final long bDK;
    private volatile boolean bDL = false;

    public a(long j, boolean z) {
        this.bDK = j;
    }

    public final boolean aaA() {
        return this.bDL;
    }

    public final a cw(boolean z) {
        this.bDL = true;
        return this;
    }

    public final long aaB() {
        return this.bDK;
    }
}
