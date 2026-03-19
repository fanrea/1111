package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String d = "DownloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.d(d, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            d(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            hc(context, action);
        }
    }

    private void d(final Context context, final String str) {
        if (b.fs()) {
            b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                            com.ss.android.socialbase.downloader.mq.d.d().d(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    private void hc(final Context context, final String str) {
        b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.ss.android.socialbase.downloader.uo.d.b().hc("enable_target_34") > 0) {
                        com.ss.android.socialbase.downloader.mq.d.d().d(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
        });
    }
}
