package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SqlDownloadCacheService extends Service {
    private static final String d = "SqlDownloadCacheService";

    public static void d(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.hc(d, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.d(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        sy syVarAn;
        mq mqVarNp = b.np();
        if (mqVarNp instanceof com.ss.android.socialbase.downloader.impls.c) {
            syVarAn = ((com.ss.android.socialbase.downloader.impls.c) mqVarNp).an();
        } else {
            syVarAn = mqVarNp instanceof sy ? (sy) mqVarNp : null;
        }
        if (syVarAn instanceof IBinder) {
            return (IBinder) syVarAn;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (b.tt()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
