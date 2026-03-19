package com.qq.e.comm.plugin;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ea implements gs {
    private final ApkDownloadTask a;
    private final Context b;
    private final Intent c;
    private Intent d;
    private Intent e;

    @Override // com.qq.e.comm.plugin.gs
    public PendingIntent c() {
        return PendingIntent.getActivity(this.b, this.a.t(), this.c, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0);
    }

    public ea(Intent intent, ApkDownloadTask apkDownloadTask, Context context) {
        this.c = intent;
        this.a = apkDownloadTask;
        this.b = context;
    }

    @Override // com.qq.e.comm.plugin.gs
    public PendingIntent e() {
        return a(true);
    }

    @Override // com.qq.e.comm.plugin.gs
    public PendingIntent b() {
        return a(false);
    }

    @Override // com.qq.e.comm.plugin.gs
    public PendingIntent a() {
        return a(false);
    }

    private PendingIntent a(boolean z) {
        int i = (Build.VERSION.SDK_INT > 30 || ExifInterface.LATITUDE_SOUTH.equals(Build.VERSION.CODENAME)) ? 67108864 : 134217728;
        if (z) {
            if (this.d == null) {
                Intent intent = new Intent();
                this.d = intent;
                intent.setClassName(this.b, wx.a());
                this.d.putExtra(ACTD.DELEGATE_NAME_KEY, wm.DOWNLOAD_MANAGE);
                this.d.putExtra("appid", r1.d().b().a());
            }
            return PendingIntent.getActivity(this.b, 0, this.d, i);
        }
        if (this.e == null) {
            Intent intent2 = new Intent(this.c);
            this.e = intent2;
            com.qq.e.comm.plugin.apkmanager.i.a(intent2, true);
        }
        return PendingIntent.getService(this.b, this.a.t(), this.e, i);
    }

    @Override // com.qq.e.comm.plugin.gs
    public PendingIntent d() {
        return a(true);
    }
}
