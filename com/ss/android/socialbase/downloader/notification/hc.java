package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.mq;
import com.ss.android.socialbase.downloader.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private static volatile hc b;
    private static final Object u = new Object();
    private final long d = 1000;
    private final Map<Integer, Long> hc = new HashMap();
    private final Set<String> c = new HashSet();
    private final SparseArray<d> an = new SparseArray<>();

    static boolean hc(int i) {
        return i == 1 || i == 3;
    }

    private hc() {
    }

    public static hc d() {
        if (b == null) {
            synchronized (hc.class) {
                if (b == null) {
                    b = new hc();
                }
            }
        }
        return b;
    }

    public void d(int i) {
        b bVarGb = h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).gb(i);
        if (bVarGb == null) {
            return;
        }
        d(bVarGb);
        hc(bVarGb);
    }

    void d(b bVar) {
        mq mqVarNp = com.ss.android.socialbase.downloader.downloader.b.np();
        if (mqVarNp != null && bVar.bd()) {
            bVar.an(3);
            try {
                mqVarNp.d(bVar);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    void hc(b bVar) {
        if (b(bVar)) {
            an(bVar.h());
        }
    }

    static boolean b(b bVar) {
        return bVar.bd() && hc(bVar.oc());
    }

    public void d(int i, int i2, Notification notification) {
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        if (contextTr == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.hc) {
                Long l = this.hc.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.hc.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextTr, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.mq.d.d().d(intent);
            } else {
                contextTr.startService(intent);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.mq.d.d().d(intent);
            }
        }
    }

    public void b(int i) {
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        if (contextTr == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextTr, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.mq.d.d().d(intent);
            } else {
                contextTr.startService(intent);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.mq.d.d().d(intent);
            }
        }
    }

    public void d(d dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.an) {
            this.an.put(dVar.d(), dVar);
        }
    }

    public d c(int i) {
        d dVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.an) {
            dVar = this.an.get(i);
            if (dVar != null) {
                this.an.remove(i);
                com.ss.android.socialbase.downloader.an.d.d("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return dVar;
    }

    public d u(int i) {
        d dVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.an) {
            dVar = this.an.get(i);
        }
        return dVar;
    }

    SparseArray<d> hc() {
        SparseArray<d> sparseArray;
        synchronized (this.an) {
            sparseArray = this.an;
        }
        return sparseArray;
    }

    public void an(int i) {
        c(i);
        if (i != 0) {
            d().b(i);
        }
    }
}
