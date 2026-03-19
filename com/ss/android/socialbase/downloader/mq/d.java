package com.ss.android.socialbase.downloader.mq;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.h.b;
import com.ss.android.socialbase.downloader.hc.u;
import com.ss.android.socialbase.downloader.k.h;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static volatile d h;
    private volatile h c;
    private volatile long d;
    private volatile long hc;
    private long b = 1000;
    private final SparseArray<Notification> u = new SparseArray<>(2);
    private AtomicBoolean an = new AtomicBoolean(false);

    public static d d() {
        if (h == null) {
            synchronized (d.class) {
                if (h == null) {
                    h = new d();
                }
            }
        }
        return h;
    }

    public void hc() {
        if (this.an.compareAndSet(false, true)) {
            this.c = new h("DownloaderNotifyThread");
            this.c.d();
            long jD = com.ss.android.socialbase.downloader.uo.d.b().d("notification_time_window", 1000L);
            this.b = jD;
            if (jD < 0 || jD > 1200) {
                this.b = 1000L;
            }
        }
    }

    public void d(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        hc();
        if (this.c == null) {
            return;
        }
        this.c.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.mq.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.hc(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        b bVarGb;
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        if (contextTr == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextTr.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 == -2 || intExtra2 == -3) {
                    d(notificationManager, intExtra, notification);
                    return;
                } else {
                    d(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).h(intExtra) && (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).gb(intExtra)) != null && bVarGb.d() && System.currentTimeMillis() - this.hc > this.b) {
                hc(notificationManager, intExtra, notification);
                bVarGb.hc();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                hc(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (an.d(contextTr, g.b) && (connectivityManager = (ConnectivityManager) contextTr.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(u.d)) {
                        arrayList.add(u.d);
                    }
                    arrayList.add("mime_type_plg");
                    com.ss.android.socialbase.downloader.downloader.h.hc(contextTr).d(arrayList);
                    com.ss.android.socialbase.downloader.downloader.h.hc(contextTr).hc(arrayList);
                    return;
                }
                return;
            } catch (Exception e) {
                mq.d(e);
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).d();
            } catch (Exception e2) {
                mq.d(e2);
            }
        }
    }

    private void d(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.u) {
            int iIndexOfKey = this.u.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.u.size()) {
                this.u.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.b - (System.currentTimeMillis() - this.d);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.hc = jCurrentTimeMillis2;
            this.d = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                hc(notificationManager, i, notification);
            } else if (this.c != null) {
                synchronized (this.u) {
                    this.u.put(i, notification);
                }
                this.c.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.mq.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.u) {
            notification = this.u.get(i);
            this.u.remove(i);
        }
        if (notification != null) {
            hc(notificationManager, i, notification);
        }
    }

    private void hc(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.d < jCurrentTimeMillis) {
                this.d = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void hc(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
