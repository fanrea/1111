package com.alliance.ssp.ad.m0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: SDKNotificationManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public final int a;
    public NotificationManager b;
    public NotificationCompat.Builder c;
    public NotificationChannel d;
    public boolean e = false;
    public Context f;

    public b(Context context, int i) {
        this.a = i;
        this.f = context;
        this.b = (NotificationManager) context.getSystemService("notification");
        b();
    }

    public synchronized void a(int i, int i2, String str, String str2) {
        NotificationCompat.Builder builder;
        if (this.e && (builder = this.c) != null && this.b != null && !com.alliance.ssp.ad.r.c.j) {
            if (i >= 0 && i2 >= 0) {
                builder.setProgress(i2, i, false);
            }
            if (str != null && !str.isEmpty()) {
                this.c.setContentTitle(str);
            }
            if (str2 != null && !str2.isEmpty()) {
                this.c.setContentText(str2);
            }
            this.c.setPriority(2);
            this.b.notify(this.a, this.c.build());
        }
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("download_channel_id", "Download Channel", 2);
            this.d = notificationChannel;
            notificationChannel.enableLights(false);
            this.d.enableVibration(false);
            this.d.setSound(null, null);
            NotificationManager notificationManager = this.b;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(this.d);
                this.e = true;
            }
        }
    }

    public void a() {
        NotificationManager notificationManager;
        if (!this.e || (notificationManager = this.b) == null) {
            return;
        }
        notificationManager.cancel(this.a);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
    }
}
