package com.ss.android.socialbase.appdownloader.u;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.Pair;
import android.widget.RemoteViews;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends com.ss.android.socialbase.downloader.notification.d {
    private String an;
    private final Resources b;
    private String c;
    private final Context hc;
    private String u;

    public d(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.u = str2;
        this.c = str3;
        this.an = str4;
        Context applicationContext = context.getApplicationContext();
        this.hc = applicationContext;
        this.b = applicationContext.getResources();
    }

    @Override // com.ss.android.socialbase.downloader.notification.d
    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        super.d(bVar);
        this.u = bVar.mk();
        this.c = bVar.gb();
        this.an = bVar.s();
    }

    @Override // com.ss.android.socialbase.downloader.notification.d
    public void d(com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        if (this.hc == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.b.b bVarD = com.ss.android.socialbase.appdownloader.c.mk().d();
            if (bVarD != null) {
                this.d = d(bVarD, dVar, z);
            } else {
                this.d = hc(dVar, z);
            }
            d(this.d);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0219 A[PHI: r6 r19 r20
  0x0219: PHI (r6v17 com.ss.android.socialbase.downloader.u.d) = 
  (r6v10 com.ss.android.socialbase.downloader.u.d)
  (r6v10 com.ss.android.socialbase.downloader.u.d)
  (r6v10 com.ss.android.socialbase.downloader.u.d)
  (r6v27 com.ss.android.socialbase.downloader.u.d)
 binds: [B:97:0x02aa, B:99:0x02ad, B:100:0x02af, B:70:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x0219: PHI (r19v8 com.ss.android.socialbase.downloader.uo.d) = 
  (r19v6 com.ss.android.socialbase.downloader.uo.d)
  (r19v6 com.ss.android.socialbase.downloader.uo.d)
  (r19v6 com.ss.android.socialbase.downloader.uo.d)
  (r19v12 com.ss.android.socialbase.downloader.uo.d)
 binds: [B:97:0x02aa, B:99:0x02ad, B:100:0x02af, B:70:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x0219: PHI (r20v5 java.lang.Object) = (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v7 java.lang.Object) binds: [B:97:0x02aa, B:99:0x02ad, B:100:0x02af, B:70:0x020c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification d(com.ss.android.socialbase.appdownloader.b.b r23, com.ss.android.socialbase.downloader.u.d r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.d.d(com.ss.android.socialbase.appdownloader.b.b, com.ss.android.socialbase.downloader.u.d, boolean):android.app.Notification");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0244  */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification hc(com.ss.android.socialbase.downloader.u.d r24, boolean r25) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.d.hc(com.ss.android.socialbase.downloader.u.d, boolean):android.app.Notification");
    }

    private boolean d(com.ss.android.socialbase.downloader.u.d dVar, com.ss.android.socialbase.downloader.uo.d dVar2, com.ss.android.socialbase.downloader.h.b bVar) {
        return dVar != null && (dVar.d() == 1013 || dVar.d() == 1049) && bVar != null && "application/vnd.android.package-archive".contains(bVar.hg()) && dVar2.d("notification_text_opt", 0) == 1;
    }

    private RemoteViews tt() {
        RemoteViews remoteViews = new RemoteViews(this.hc.getPackageName(), u.d());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.b.d(this.hc)) {
                    remoteViews.setInt(u.an(), "setBackgroundColor", this.hc.getResources().getColor(u.yo()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    private int d(int i, int i2) {
        if (com.ss.android.socialbase.downloader.uo.d.d(i2).hc("notification_opt_2") == 1) {
            return u.de();
        }
        if (i == 1 || i == 4) {
            return u.jh();
        }
        if (i == 2) {
            return u.sy();
        }
        if (i == 3) {
            return u.de();
        }
        return 0;
    }

    private PendingIntent d(String str, int i, int i2) {
        Pair<Intent, Boolean> pairHc = com.ss.android.socialbase.appdownloader.c.hc(this.hc, i2);
        Intent intent = (Intent) pairHc.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return com.ss.android.socialbase.appdownloader.c.d(this.hc, pairHc, i2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder tc() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.c r0 = com.ss.android.socialbase.appdownloader.c.mk()
            java.lang.String r0 = r0.tc()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.hc
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.hc
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.b.hc(r0)
        L22:
            com.ss.android.socialbase.appdownloader.c r1 = com.ss.android.socialbase.appdownloader.c.mk()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.b.k r1 = r1.k()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.c r1 = com.ss.android.socialbase.appdownloader.c.mk()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.b.k r1 = r1.k()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.hc     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.d(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.hc     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.hc
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.d.tc():androidx.core.app.NotificationCompat$Builder");
    }

    private int d(int i) {
        if (com.ss.android.socialbase.downloader.uo.d.d(i).hc("enable_notification_ui") > 0) {
            return u.gb();
        }
        return u.h();
    }
}
