package com.ss.android.downloadlib.b;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.downloader.c.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements k {
    @Override // com.ss.android.socialbase.downloader.c.k
    public void d(com.ss.android.socialbase.downloader.h.b bVar) throws com.ss.android.socialbase.downloader.u.d {
        PackageInfo packageInfoD = com.ss.android.socialbase.appdownloader.b.d(mq.getContext(), bVar, bVar.mk(), bVar.gb());
        if (packageInfoD != null) {
            bVar.gb(packageInfoD.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.k
    public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
        return bVar != null && com.ss.android.downloadlib.h.u.hc() && bVar.ji() == null;
    }
}
