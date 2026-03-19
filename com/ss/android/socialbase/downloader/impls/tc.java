package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tc implements jh {
    @Override // com.ss.android.socialbase.downloader.downloader.jh
    public long d(int i, int i2) {
        if (i == 1) {
            return com.alipay.sdk.m.u.b.a;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
