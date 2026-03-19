package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements com.ss.android.socialbase.downloader.downloader.tt {
    @Override // com.ss.android.socialbase.downloader.downloader.tt
    public int d(int i, com.ss.android.socialbase.downloader.tt.uo uoVar) {
        if (uoVar.ordinal() <= com.ss.android.socialbase.downloader.tt.uo.MODERATE.ordinal()) {
            return 1;
        }
        return uoVar == com.ss.android.socialbase.downloader.tt.uo.GOOD ? i - 1 : i;
    }
}
