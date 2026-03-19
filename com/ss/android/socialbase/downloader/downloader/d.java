package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d implements w {
    private static final String u = "d";
    private WeakReference<Service> an;
    protected volatile boolean b;
    protected final SparseArray<List<com.ss.android.socialbase.downloader.h.c>> d = new SparseArray<>();
    protected volatile boolean hc = false;
    protected volatile boolean c = false;
    private Handler h = new Handler(Looper.getMainLooper());
    private Runnable gb = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc(d.u, "tryDownload: 2 try");
            }
            if (d.this.hc) {
                return;
            }
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc(d.u, "tryDownload: 2 error");
            }
            d.this.startService(b.tr(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void b() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void b(com.ss.android.socialbase.downloader.h.c cVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(cb cbVar) {
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(WeakReference weakReference) {
        this.an = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public boolean d() {
        return this.hc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public boolean hc() {
        com.ss.android.socialbase.downloader.an.d.b(u, "isServiceForeground = " + this.b);
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public IBinder d(Intent intent) {
        com.ss.android.socialbase.downloader.an.d.hc(u, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(int i, Notification notification) {
        WeakReference<Service> weakReference = this.an;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.an.d.b(u, "startForeground  id = " + i + ", service = " + this.an.get() + ",  isServiceAlive = " + this.hc);
            try {
                this.an.get().startForeground(i, notification);
                this.b = true;
                return;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                return;
            }
        }
        com.ss.android.socialbase.downloader.an.d.c(u, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(boolean z) {
        WeakReference<Service> weakReference = this.an;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.b(u, "stopForeground  service = " + this.an.get() + ",  isServiceAlive = " + this.hc);
        try {
            this.b = false;
            this.an.get().stopForeground(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void c() {
        this.hc = false;
    }

    public void d(com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        int iW = cVar.w();
        synchronized (this.d) {
            String str = u;
            com.ss.android.socialbase.downloader.an.d.hc(str, "pendDownloadTask pendingTasks.size:" + this.d.size() + " downloadId:" + iW);
            List<com.ss.android.socialbase.downloader.h.c> arrayList = this.d.get(iW);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.d.put(iW, arrayList);
            }
            com.ss.android.socialbase.downloader.an.d.hc(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(cVar);
            com.ss.android.socialbase.downloader.an.d.hc(str, "after pendDownloadTask pendingTasks.size:" + this.d.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void hc(com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.hc) {
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc(u, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.e.d.d(262144)) {
                d(cVar);
                if (!this.c) {
                    if (com.ss.android.socialbase.downloader.an.d.d()) {
                        com.ss.android.socialbase.downloader.an.d.hc(u, "tryDownload: 1");
                    }
                    startService(b.tr(), null);
                    this.c = true;
                    return;
                }
                this.h.removeCallbacks(this.gb);
                this.h.postDelayed(this.gb, 10L);
                return;
            }
            d(cVar);
            startService(b.tr(), null);
            return;
        }
        String str = u;
        com.ss.android.socialbase.downloader.an.d.hc(str, "tryDownload when isServiceAlive");
        u();
        com.ss.android.socialbase.downloader.impls.d dVarJ = b.j();
        if (dVarJ != null) {
            com.ss.android.socialbase.downloader.an.d.hc(str, "tryDownload current task: " + cVar.w());
            dVarJ.d(cVar);
        }
    }

    protected void u() {
        SparseArray<List<com.ss.android.socialbase.downloader.h.c>> sparseArrayClone;
        synchronized (this.d) {
            com.ss.android.socialbase.downloader.an.d.hc(u, "resumePendingTask pendingTasks.size:" + this.d.size());
            sparseArrayClone = this.d.clone();
            this.d.clear();
        }
        com.ss.android.socialbase.downloader.impls.d dVarJ = b.j();
        if (dVarJ != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<com.ss.android.socialbase.downloader.h.c> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.h.c cVar : list) {
                        com.ss.android.socialbase.downloader.an.d.hc(u, "resumePendingTask key:" + cVar.w());
                        dVarJ.d(cVar);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void d(int i) {
        com.ss.android.socialbase.downloader.an.d.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.w
    public void startService() {
        if (this.hc) {
            return;
        }
        if (com.ss.android.socialbase.downloader.an.d.d()) {
            com.ss.android.socialbase.downloader.an.d.hc(u, "startService");
        }
        startService(b.tr(), null);
    }
}
