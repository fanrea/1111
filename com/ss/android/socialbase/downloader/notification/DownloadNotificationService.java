package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.hc.u;
import com.ss.android.socialbase.downloader.k.h;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadNotificationService extends Service {
    private static volatile long an = 0;
    private static int b = -1;
    private static boolean c = true;
    private static final String d = "DownloadNotificationService";
    private static boolean gb = false;
    private static volatile long h = 0;
    private static int hc = -1;
    private static long tt = 900;
    private static boolean u = false;
    private final SparseArray<Notification> mk = new SparseArray<>(2);
    private h tc;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c();
        b.d(this);
        com.ss.android.socialbase.downloader.uo.d dVarB = com.ss.android.socialbase.downloader.uo.d.b();
        int iD = dVarB.d("download_service_foreground", 0);
        if ((iD == 1 || iD == 3) && hc == -1) {
            hc = 0;
        }
        if ((iD == 2 || iD == 3) && b == -1) {
            b = 0;
        }
        u = dVarB.hc("non_going_notification_foreground", false);
        gb = dVarB.hc("notify_too_fast", false);
        long jD = dVarB.d("notification_time_window", 900L);
        tt = jD;
        if (jD < 0 || jD > 1200) {
            tt = 900L;
        }
    }

    private void c() {
        if (this.tc == null) {
            h hVar = new h("DownloaderNotifyThread");
            this.tc = hVar;
            hVar.d();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.tc;
        if (hVar != null) {
            try {
                hVar.hc();
            } catch (Throwable unused) {
            }
            this.tc = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        d(intent);
        return 2;
    }

    private void d(final Intent intent) {
        h hVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (hVar = this.tc) == null) {
            return;
        }
        hVar.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra == 0 || notification == null || notificationManager == null) {
                        return;
                    }
                    if (intExtra2 != 4) {
                        if (intExtra2 == -2 || intExtra2 == -3) {
                            if (DownloadNotificationService.gb) {
                                DownloadNotificationService.this.d(notificationManager, intExtra, notification);
                                return;
                            } else {
                                if (DownloadNotificationService.this.tc != null) {
                                    DownloadNotificationService.this.tc.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.hc(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                        }
                        if (DownloadNotificationService.gb) {
                            DownloadNotificationService.this.d(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.hc(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (com.ss.android.socialbase.downloader.downloader.h.hc(b.tr()).h(intExtra)) {
                        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(b.tr()).gb(intExtra);
                        if (DownloadNotificationService.gb) {
                            if (bVarGb == null || !bVarGb.d() || System.currentTimeMillis() - DownloadNotificationService.h <= DownloadNotificationService.tt) {
                                return;
                            }
                            DownloadNotificationService.this.hc(notificationManager, intExtra, notification);
                            bVarGb.hc();
                            return;
                        }
                        if (bVarGb == null || !bVarGb.d()) {
                            return;
                        }
                        DownloadNotificationService.this.hc(notificationManager, intExtra, notification);
                        bVarGb.hc();
                        return;
                    }
                    return;
                }
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.hc(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (an.d((Context) DownloadNotificationService.this, g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(u.d)) {
                                arrayList.add(u.d);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                com.ss.android.socialbase.downloader.downloader.h.hc(applicationContext).d(arrayList);
                                com.ss.android.socialbase.downloader.downloader.h.hc(applicationContext).hc(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        mq.d(e);
                        return;
                    }
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        com.ss.android.socialbase.downloader.downloader.h.hc(DownloadNotificationService.this).d();
                    } catch (Exception e2) {
                        mq.d(e2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.mk) {
            int iIndexOfKey = this.mk.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.mk.size()) {
                this.mk.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = tt - (System.currentTimeMillis() - an);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            h = jCurrentTimeMillis2;
            an = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                hc(notificationManager, i, notification);
            } else if (this.tc != null) {
                synchronized (this.mk) {
                    this.mk.put(i, notification);
                }
                this.tc.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.d(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.mk) {
            notification = this.mk.get(i);
            this.mk.remove(i);
        }
        if (notification != null) {
            hc(notificationManager, i, notification);
        }
    }

    private boolean d(int i, Notification notification) {
        int i2;
        int i3;
        if (!c || (i2 = hc) == i || (i3 = b) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (u && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(NotificationManager notificationManager, int i, Notification notification) {
        if (d(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = c.d().d(i) == 1 && !an.b();
                if ((!z2 && hc == 0) || (z2 && b == 0)) {
                    z = true;
                }
                if (z) {
                    e eVarB = c.d().b(i);
                    if (eVarB.h() && !eVarB.hc()) {
                        com.ss.android.socialbase.downloader.an.d.b(d, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            b = i;
                        } else {
                            hc = i;
                        }
                        eVarB.d(i, notification);
                    } else {
                        com.ss.android.socialbase.downloader.an.d.b(d, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        } else if ((hc == i || b == i) && u && (notification.flags & 2) == 0) {
            hc(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (an < jCurrentTimeMillis) {
                an = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(NotificationManager notificationManager, int i) {
        boolean z;
        d dVarValueAt;
        int iD;
        int i2 = hc;
        if (i2 == i || b == i) {
            boolean z2 = true;
            if (i2 == i) {
                hc = 0;
                z = false;
            } else {
                b = 0;
                z = true;
            }
            try {
                e eVarB = c.d().b(i);
                if (!eVarB.hc()) {
                    c = false;
                    com.ss.android.socialbase.downloader.an.d.c(d, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
                }
                com.ss.android.socialbase.downloader.an.d.b(d, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
                eVarB.d(false, true);
            } catch (Throwable th) {
                mq.d(th);
            }
            try {
                notificationManager.cancel(i);
            } catch (Throwable unused) {
            }
            if (c) {
                try {
                    SparseArray<d> sparseArrayHc = hc.d().hc();
                    if (sparseArrayHc != null) {
                        for (int size = sparseArrayHc.size() - 1; size >= 0; size--) {
                            dVarValueAt = sparseArrayHc.valueAt(size);
                            if (dVarValueAt != null && (iD = dVarValueAt.d()) != i && iD != hc && iD != b && dVarValueAt.gb()) {
                                if ((c.d().d(dVarValueAt.d()) == 1 && !an.b()) == z) {
                                    break;
                                }
                            }
                        }
                        dVarValueAt = null;
                    } else {
                        dVarValueAt = null;
                    }
                    if (dVarValueAt != null) {
                        int iD2 = dVarValueAt.d();
                        try {
                            notificationManager.cancel(iD2);
                        } catch (Throwable th2) {
                            mq.d(th2);
                        }
                        if (com.ss.android.socialbase.downloader.downloader.h.hc(this).an(iD2) != 1) {
                            z2 = false;
                        }
                        com.ss.android.socialbase.downloader.an.d.b(d, "doCancel, updateNotification id = ".concat(String.valueOf(iD2)));
                        dVarValueAt.d((com.ss.android.socialbase.downloader.u.d) null, z2);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    mq.d(th3);
                    return;
                }
            }
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused2) {
        }
    }
}
