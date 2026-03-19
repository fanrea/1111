package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface w<T extends CSJDownloadService> {
    void b();

    void b(com.ss.android.socialbase.downloader.h.c cVar);

    void c();

    IBinder d(Intent intent);

    void d(int i);

    void d(int i, Notification notification);

    void d(Intent intent, int i, int i2);

    void d(cb cbVar);

    void d(WeakReference<T> weakReference);

    void d(boolean z);

    boolean d();

    void hc(com.ss.android.socialbase.downloader.h.c cVar);

    boolean hc();

    void startService();
}
