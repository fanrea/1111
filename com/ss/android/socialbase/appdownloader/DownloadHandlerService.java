package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.s;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadHandlerService extends Service {
    private static final String d = "DownloadHandlerService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.d(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) throws JSONException {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.an.d.d()) {
            com.ss.android.socialbase.downloader.an.d.hc(d, "onStartCommand");
        }
        d(com.ss.android.socialbase.downloader.downloader.b.tr(), intent);
        stopSelf();
        return 2;
    }

    private boolean d(Context context, Intent intent) throws JSONException {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.b.u uVarB = c.mk().b();
        s sVarTt = com.ss.android.socialbase.downloader.downloader.h.hc(this).tt(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.uo.d.d(intExtra).hc("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.hc.d().an(intExtra);
        }
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(intExtra);
        if (bVarGb == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            hc(context, bVarGb, uVarB, sVarTt);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            d(context, bVarGb, uVarB, sVarTt);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (bVarGb.w() == 0) {
                return false;
            }
            d(context, bVarGb, uVarB, sVarTt);
            if (bVarGb.bd() && com.ss.android.socialbase.downloader.uo.d.d(intExtra).d("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.uo.d.d(intExtra).hc("enable_notification_ui") >= 2 && bVarGb.w() == -1)) {
                    com.ss.android.socialbase.downloader.notification.hc.d().d(intExtra);
                    com.ss.android.socialbase.downloader.notification.hc.d().an(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(context, bVarGb, uVarB, sVarTt);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.hc.d().d(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).d(arrayList);
                    } catch (Exception e) {
                        mq.d(e);
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void d(Context context, com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
        if (com.ss.android.socialbase.downloader.e.an.hc(context.getApplicationContext()) && bVar.xp()) {
            bVar.ia();
        }
    }

    private static void d(Context context, final com.ss.android.socialbase.appdownloader.b.u uVar, final com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return;
        }
        final s sVarTt = com.ss.android.socialbase.downloader.downloader.h.hc(context).tt(bVar.h());
        if (uVar == null && sVarTt == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfoD;
                try {
                    File file = new File(bVar.mk(), bVar.gb());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.b.tr() == null || (packageInfoD = b.d(bVar, file)) == null) ? "" : packageInfoD.packageName;
                            com.ss.android.socialbase.appdownloader.b.u uVar2 = uVar;
                            if (uVar2 != null) {
                                uVar2.d(bVar.h(), 3, str, -3, bVar.pa());
                            }
                            s sVar = sVarTt;
                            if (sVar != null) {
                                sVar.d(3, bVar, str, "");
                            }
                        } catch (Exception e) {
                            mq.d(e);
                        }
                    }
                } catch (Exception e2) {
                    mq.d(e2);
                }
            }
        });
    }

    private void hc(Context context, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.b.u uVar, s sVar) {
        boolean zD;
        int iH = bVar.h();
        ba baVarMq = com.ss.android.socialbase.downloader.downloader.c.d().mq(iH);
        if (baVarMq != null) {
            try {
                zD = baVarMq.d(bVar);
            } catch (Throwable th) {
                mq.d(th);
            }
        } else {
            zD = false;
        }
        if (zD) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", iH);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.hc.d().d(iH);
        bVar.t();
        if (uVar != null) {
            uVar.d(iH, 7, "", bVar.w(), bVar.pa());
        }
        if (sVar != null) {
            sVar.d(7, bVar, "", "");
        }
    }

    private void b(Context context, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.b.u uVar, s sVar) {
        int iH = bVar.h();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", iH);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.hc.d().d(iH);
        bVar.t();
        if (uVar != null) {
            uVar.d(iH, 7, "", bVar.w(), bVar.pa());
        }
        if (sVar != null) {
            sVar.d(7, bVar, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.content.Context r2, int r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.c r4 = com.ss.android.socialbase.downloader.downloader.c.d()
            com.ss.android.socialbase.downloader.c.ba r4 = r4.mq(r3)
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.h r1 = com.ss.android.socialbase.downloader.downloader.h.hc(r2)     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.downloader.h.b r1 = r1.gb(r3)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L20
            boolean r4 = r4.hc(r1)     // Catch: java.lang.Throwable -> L1c
            goto L21
        L1c:
            r4 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r4)
        L20:
            r4 = r0
        L21:
            if (r4 == 0) goto L24
            return
        L24:
            r4 = 1
            int r3 = com.ss.android.socialbase.appdownloader.b.d(r2, r3, r4)
            if (r3 != 0) goto L34
            java.lang.String r3 = "Open Fail!"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.d(android.content.Context, int, boolean):void");
    }

    public static void d(Context context, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.b.u uVar, s sVar) throws JSONException {
        com.ss.android.socialbase.downloader.notification.d dVarU;
        int iH = bVar.h();
        ba baVarMq = com.ss.android.socialbase.downloader.downloader.c.d().mq(iH);
        if ("application/vnd.android.package-archive".equals(bVar.hg()) && baVarMq != null && b.d(context, bVar) && baVarMq.b(bVar)) {
        }
        boolean z = false;
        switch (bVar.w()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.uo.d.d(iH).hc("enable_notification_ui") >= 2 && bVar.np()) {
                    bVar.c(false);
                }
                com.ss.android.socialbase.downloader.downloader.h.hc(context).u(iH);
                break;
            case -3:
                d(com.ss.android.socialbase.downloader.downloader.b.tr(), iH, true);
                d(context, uVar, bVar);
                if (com.ss.android.socialbase.downloader.uo.d.d(iH).d("notification_click_install_auto_cancel", 1) != 0 || (dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(iH)) == null) {
                    z = true;
                } else {
                    dVarU.h();
                    dVarU.d(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.hc.d().d(iH);
                    break;
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.c.d().u(iH)) {
                    com.ss.android.socialbase.downloader.downloader.h.hc(context).b(iH);
                } else {
                    b.d(bVar, true, false);
                }
                if (uVar != null) {
                    uVar.d(iH, 6, "", bVar.w(), bVar.pa());
                }
                if (sVar != null) {
                    sVar.d(6, bVar, "", "");
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.ss.android.socialbase.downloader.downloader.h.hc(context).d(iH);
                d(context, bVar);
                if (uVar != null) {
                    uVar.d(iH, 5, "", bVar.w(), bVar.pa());
                }
                if (sVar != null) {
                    sVar.d(5, bVar, "", "");
                    break;
                }
                break;
        }
    }
}
