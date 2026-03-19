package com.alliance.ssp.ad.r;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.p;
import com.alliance.ssp.ad.r.c;
import com.alliance.ssp.ad.service.YTSDKDownloadService;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: DownLoadTask.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ c.a c;
    public final /* synthetic */ c.b d;

    public b(String str, Context context, c.a aVar, c.b bVar) {
        this.a = str;
        this.b = context;
        this.c = aVar;
        this.d = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws ProtocolException {
        super.run();
        try {
            Thread.currentThread().setUncaughtExceptionHandler(p.d);
            ((HttpURLConnection) new URL(this.a).openConnection()).setRequestMethod("GET");
            final Context context = this.b;
            final String str = this.a;
            final c.a aVar = this.c;
            final c.b bVar = this.d;
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alliance.ssp.ad.r.b$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(str, context, aVar, bVar);
                }
            });
        } catch (Exception e) {
            c.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(e);
            }
            e.getMessage();
            int i = l.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, Context context, final c.a aVar, c.b bVar) {
        final String strSubstring;
        Thread.currentThread().setUncaughtExceptionHandler(p.d);
        if (str == null || TextUtils.isEmpty(str) || !str.contains(".apk")) {
            strSubstring = "";
        } else {
            int iLastIndexOf = str.lastIndexOf(".apk");
            strSubstring = str.substring(str.lastIndexOf(47, iLastIndexOf) + 1, iLastIndexOf + 4);
        }
        if (c.b.contains(strSubstring)) {
            int i = l.a;
            return;
        }
        String str2 = context.getExternalCacheDir() + "/nmssp_download/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.alliance.ssp.ad.m0.a aVar2 = c.g;
        if (aVar2 != null) {
            aVar2.a();
            c.g = null;
        }
        com.alliance.ssp.ad.m0.a aVar3 = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.r.b$$ExternalSyntheticLambda2
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                b.a(str, strSubstring, aVar, (Intent) obj);
            }
        }, context);
        c.g = aVar3;
        aVar3.b("SA_TARGET_YT_NOTIFICATION_CANCEL", "SA_TARGET_YT_NOTIFICATION_CLICK");
        com.alliance.ssp.ad.m0.b bVar2 = c.f;
        if (bVar2 != null) {
            bVar2.a();
            c.f = null;
        }
        com.alliance.ssp.ad.m0.b bVar3 = new com.alliance.ssp.ad.m0.b(context, c.b.indexOf(strSubstring));
        c.f = bVar3;
        String str3 = "下载中 " + strSubstring;
        if (bVar3.e && bVar3.f != null) {
            Intent intent = new Intent(bVar3.f, (Class<?>) YTSDKDownloadService.class);
            intent.setAction("SA_TARGET_YT_NOTIFICATION_CLICK");
            PendingIntent service = PendingIntent.getService(bVar3.f, 0, intent, 201326592);
            Intent intent2 = new Intent(bVar3.f, (Class<?>) YTSDKDownloadService.class);
            intent2.setAction("SA_TARGET_YT_NOTIFICATION_CANCEL");
            try {
                bVar3.c = new NotificationCompat.Builder(bVar3.f.getApplicationContext(), "download_channel_id").setSmallIcon(bVar3.f.getResources().getIdentifier("nmadssp_icon_shuffle_on", "drawable", bVar3.f.getPackageName())).setContentTitle(str3).setContentText("").setPriority(2).setContentIntent(service).setDeleteIntent(PendingIntent.getService(bVar3.f, 0, intent2, 201326592)).setOnlyAlertOnce(true).setSound(null).setVibrate(null).setAutoCancel(false).setOngoing(false);
            } catch (Exception e) {
                e.getMessage();
                int i2 = l.a;
            }
            NotificationManager notificationManager = bVar3.b;
            if (notificationManager != null) {
                notificationManager.notify(bVar3.a, bVar3.c.build());
            }
        }
        com.alliance.ssp.ad.r.a aVar4 = new com.alliance.ssp.ad.r.a(context);
        File file2 = new File(str2, strSubstring);
        c.b.add(strSubstring);
        Toast.makeText(context, "正在下载" + strSubstring, 1).show();
        aVar.c();
        c.j = false;
        boolean unused = c.h = false;
        boolean unused2 = c.i = false;
        a aVar5 = new a(this, strSubstring, bVar, file2, aVar, str2, context);
        f fVar = f.i;
        if (fVar == null && fVar == null) {
            f.i = new f(aVar4, aVar5);
        }
        f fVar2 = f.i;
        fVar2.e = null;
        fVar2.c = aVar5;
        g gVar = new g(strSubstring, str);
        fVar2.a(gVar);
        f.h = str2;
        fVar2.a(str, str2);
        ((HashMap) c.c).put(str, strSubstring);
        ((HashMap) c.d).put(str, fVar2);
        ((HashMap) c.e).put(str, gVar);
    }

    /* compiled from: DownLoadTask.java */
    public class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ c.b b;
        public final /* synthetic */ File c;
        public final /* synthetic */ c.a d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Context f;

        public a(b bVar, String str, c.b bVar2, File file, c.a aVar, String str2, Context context) {
            this.a = str;
            this.b = bVar2;
            this.c = file;
            this.d = aVar;
            this.e = str2;
            this.f = context;
        }

        @Override // com.alliance.ssp.ad.r.j
        public void a(com.alliance.ssp.ad.t.a aVar) {
            NotificationManager notificationManager;
            if (c.h || c.j) {
                c.j = false;
                return;
            }
            boolean unused = c.i = true;
            if (com.alliance.ssp.ad.t.a.B0) {
                com.alliance.ssp.ad.t.a.B0 = false;
                return;
            }
            if (c.b.contains(this.a)) {
                c.b.remove(this.a);
            }
            c.b bVar = this.b;
            if (bVar != null && c.a == 100) {
                bVar.a(100);
            }
            com.alliance.ssp.ad.m0.b bVar2 = c.f;
            File file = this.c;
            String str = this.a;
            if (bVar2.e && bVar2.c != null && (notificationManager = bVar2.b) != null) {
                notificationManager.cancel(bVar2.a);
                bVar2.c.setContentTitle("下载完成，点击安装").setContentText(str).setProgress(0, 0, false);
                if (file != null && str != null) {
                    NotificationCompat.Builder builder = bVar2.c;
                    Context context = bVar2.f;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.addFlags(1);
                    intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".NMSSPFileProvider", file), "application/vnd.android.package-archive");
                    builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 201326592));
                }
                Notification notificationBuild = bVar2.c.build();
                notificationBuild.flags &= -3;
                bVar2.b.notify(bVar2.a, notificationBuild);
            }
            c.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(this.e);
            }
            com.alliance.ssp.ad.o0.i.a(this.f, this.e, this.a);
        }

        @Override // com.alliance.ssp.ad.r.j
        public void a(int i, int i2, com.alliance.ssp.ad.t.a aVar) {
            int i3 = (int) ((i2 * 100.0f) / i);
            if (c.a == i3) {
                return;
            }
            c.a = i3;
            if (c.b.contains(this.a)) {
                if (i2 >= i) {
                    c.a = 100;
                    i3 = 100;
                }
                c.b bVar = this.b;
                if (bVar != null) {
                    bVar.a(i3);
                }
                c.f.a(c.a, 100, null, c.a + "%");
            }
        }
    }

    public static /* synthetic */ void a(String str, final String str2, c.a aVar, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        if (!action.equals("SA_TARGET_YT_NOTIFICATION_CLICK")) {
            if (action.equals("SA_TARGET_YT_NOTIFICATION_CANCEL")) {
                c.j = true;
                c.a(str, true);
                c.a(str);
                c.f.a();
                c.g.a();
                return;
            }
            return;
        }
        if (c.i) {
            return;
        }
        if (c.h) {
            boolean unused = c.h = false;
            c.a(str, false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alliance.ssp.ad.r.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.f.a(-1, -1, "下载中 " + str2, null);
                }
            }, 50L);
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        boolean unused2 = c.h = true;
        c.a(str, true);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alliance.ssp.ad.r.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                c.f.a(-1, -1, "下载暂停 " + str2, null);
            }
        }, 200L);
        if (aVar != null) {
            aVar.a();
        }
    }
}
