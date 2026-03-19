package com.ss.android.socialbase.appdownloader.an.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    public static final void d(c cVar, int i) throws IOException {
        int iHc = cVar.hc();
        if (iHc != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iHc) + ".");
        }
    }
}
