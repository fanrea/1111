package com.sigmob.sdk.archives.tar;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements e {
    private boolean b;

    public c(byte[] headerBuf) {
        this.b = f.a(headerBuf, 504);
    }

    public boolean a() {
        return this.b;
    }
}
