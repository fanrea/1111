package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CSJDownloadService extends Service {
    private static final String hc = "CSJDownloadService";
    protected w d;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.d(this);
        w wVarYi = b.yi();
        this.d = wVarYi;
        wVarYi.d(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.an.d.hc(hc, "onBind downloadServiceHandler != null:" + (this.d != null));
        w wVar = this.d;
        if (wVar != null) {
            return wVar.d(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.an.d.d()) {
            com.ss.android.socialbase.downloader.an.d.hc(hc, "DownloadService onStartCommand");
        }
        this.d.b();
        ExecutorService executorServiceMk = b.mk();
        if (executorServiceMk != null) {
            executorServiceMk.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CSJDownloadService.this.d != null) {
                        CSJDownloadService.this.d.d(intent, i, i2);
                    }
                }
            });
        }
        return b.tt() ? 2 : 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.an.d.d()) {
            com.ss.android.socialbase.downloader.an.d.hc(hc, "Service onDestroy");
        }
        w wVar = this.d;
        if (wVar != null) {
            wVar.c();
            this.d = null;
        }
        super.onDestroy();
    }
}
