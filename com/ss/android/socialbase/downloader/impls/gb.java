package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb extends com.ss.android.socialbase.downloader.downloader.d {
    private static final String u = "gb";

    @Override // com.ss.android.socialbase.downloader.downloader.d
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.hc = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void b() {
        if (com.ss.android.socialbase.downloader.e.d.d(262144)) {
            this.hc = true;
            this.c = false;
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc(u, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void d(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.an.d.d()) {
            com.ss.android.socialbase.downloader.an.d.hc(u, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.e.d.d(262144)) {
            this.hc = true;
        }
        u();
    }
}
