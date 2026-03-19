package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.c.s;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String d = "DownloadReceiver";
    private Handler hc = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.d(d, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            d(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.b.u uVarB = c.mk().b();
                    if (uVarB != null) {
                        uVarB.d(context, schemeSpecificPart);
                    }
                    List<com.ss.android.socialbase.downloader.h.b> listHc = com.ss.android.socialbase.downloader.downloader.h.hc(context).hc("application/vnd.android.package-archive");
                    if (listHc != null) {
                        for (final com.ss.android.socialbase.downloader.h.b bVar : listHc) {
                            if (bVar != null && b.d(bVar, schemeSpecificPart)) {
                                s sVarTt = com.ss.android.socialbase.downloader.downloader.h.hc(context).tt(bVar.h());
                                if (sVarTt != null && com.ss.android.socialbase.downloader.e.an.an(sVarTt.d())) {
                                    sVarTt.d(9, bVar, schemeSpecificPart, "");
                                }
                                com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
                                if (dVarU != null) {
                                    dVarU.d((com.ss.android.socialbase.downloader.u.d) null, false);
                                }
                                if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("install_queue_enable", 0) == 1) {
                                    gb.d().d(bVar, schemeSpecificPart);
                                }
                                DownloadReceiver.this.hc.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (bVar.nu()) {
                                                        com.ss.android.socialbase.downloader.e.an.hc(bVar);
                                                    }
                                                } catch (Throwable th) {
                                                    mq.d(th);
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void d(final Context context, final String str) {
        if (com.ss.android.socialbase.downloader.downloader.b.fs()) {
            com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        mq.d(th);
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }
}
