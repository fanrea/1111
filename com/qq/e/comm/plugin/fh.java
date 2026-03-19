package com.qq.e.comm.plugin;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class fh {
    public abstract Notification a();

    public abstract fh a(int i, int i2, boolean z);

    public abstract fh a(PendingIntent pendingIntent);

    public abstract fh a(Bitmap bitmap);

    public abstract fh a(String str);

    public abstract fh a(boolean z);

    public abstract fh b(String str);

    fh() {
    }

    public static fh a(Context context) {
        try {
            return new b(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: A */
    private static class b extends fh {
        private Notification.Builder a;

        private b(Context context) {
            Notification.Builder builder = new Notification.Builder(context);
            this.a = builder;
            fs.a(context, builder);
            this.a.setSmallIcon(R.drawable.stat_sys_download_done);
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh b(String str) {
            this.a.setContentTitle(str);
            return this;
        }

        @Override // com.qq.e.comm.plugin.fh
        public Notification a() {
            try {
                try {
                    return this.a.build();
                } catch (Throwable unused) {
                    return null;
                }
            } catch (Throwable unused2) {
                return this.a.getNotification();
            }
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh a(boolean z) {
            this.a.setAutoCancel(z);
            return this;
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh a(PendingIntent pendingIntent) {
            this.a.setContentIntent(pendingIntent);
            return this;
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh a(String str) {
            this.a.setContentText(str);
            return this;
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh a(Bitmap bitmap) {
            this.a.setLargeIcon(bitmap);
            return this;
        }

        @Override // com.qq.e.comm.plugin.fh
        public fh a(int i, int i2, boolean z) {
            this.a.setProgress(i, i2, z);
            return this;
        }
    }
}
