package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        b.d(this);
        if (b.yn() == null) {
            b.d(new v());
        }
        this.d = b.he();
        this.d.d(new WeakReference(this));
    }
}
