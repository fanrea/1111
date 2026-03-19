package com.kwad.sdk.core.download.b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements d {
    private static c bBI;
    private boolean bBK = false;
    private boolean bBL = false;
    private int bBM = 0;
    private static HashMap<String, WeakReference<Bitmap>> bBH = new HashMap<>();
    private static final Handler bBJ = new HandlerC0584a();

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        registerReceiver();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.anu().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static void registerReceiver() {
        if (bBI != null) {
            return;
        }
        bBI = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.anu().registerReceiver(bBI, intentFilter, 2);
        } else {
            ServiceProvider.anu().registerReceiver(bBI, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aW(long j) {
        return String.format("%.2fMB", Float.valueOf((j / 1000.0f) / 1000.0f));
    }

    public final void h(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File fileDw = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).dw(str);
            if (fileDw == null || !fileDw.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c cVarA;
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu == null || downloadTask.isNotificationRemoved() || (cVarA = com.kwad.sdk.core.download.b.c.a(contextAnu, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.bBK) {
            this.bBK = true;
            this.bBL = ((h) ServiceProvider.get(h.class)).UD();
            this.bBM = ((h) ServiceProvider.get(h.class)).UE();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(contextAnu, cVarA, b.a(downloadTask, "正在下载", null, this.bBL, this.bBM));
        a(contextAnu, cVarA.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    public final void i(DownloadTask downloadTask) {
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        String str = downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载";
        if (!this.bBK) {
            this.bBK = true;
            this.bBL = ((h) ServiceProvider.get(h.class)).UD();
            this.bBM = ((h) ServiceProvider.get(h.class)).UE();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
        b bVarA = b.a(downloadTask, str, null, this.bBL, this.bBM);
        com.kwad.sdk.core.download.b.c cVarA = com.kwad.sdk.core.download.b.c.a(contextAnu, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (cVarA == null) {
            return;
        }
        a(contextAnu, cVarA, bVarA);
        a(contextAnu, cVarA.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    public final void j(DownloadTask downloadTask) {
        DownloadParams downloadParamsL;
        com.kwad.sdk.core.download.b.b bVarBM;
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu == null || (downloadParamsL = l(downloadTask)) == null || (bVarBM = com.kwad.sdk.core.download.b.b.bM(contextAnu)) == null) {
            return;
        }
        if (!this.bBK) {
            this.bBK = true;
            this.bBL = ((h) ServiceProvider.get(h.class)).UD();
            this.bBM = ((h) ServiceProvider.get(h.class)).UE();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(contextAnu, bVarBM, b.a(downloadTask, "下载完成", "立即安装", this.bBL, this.bBM));
        com.kwad.sdk.core.a.WS().a(downloadTask.getTargetFilePath(), downloadParamsL);
        com.kwad.sdk.core.a.WS().a(downloadParamsL.mPkgname, downloadParamsL);
        a(contextAnu, bVarBM.build(), false, false, at.a(contextAnu, new File(downloadTask.getTargetFilePath()), downloadParamsL.mTaskId, downloadParamsL.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    public final void g(File file) {
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu == null) {
            return;
        }
        DownloadParams downloadParamsEy = com.kwad.sdk.core.a.WS().ey(file.getAbsolutePath());
        com.kwad.sdk.core.a.WS().ez(file.getAbsolutePath());
        if (downloadParamsEy == null) {
            return;
        }
        AdTemplate adTemplateEA = com.kwad.sdk.core.a.WS().eA(downloadParamsEy.mDownloadid);
        if (adTemplateEA != null) {
            adTemplateEA.installFrom = "recall";
        }
        b bVarA = b.a(downloadParamsEy, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b bVarBM = com.kwad.sdk.core.download.b.b.bM(contextAnu);
        if (bVarBM == null) {
            return;
        }
        a(contextAnu, bVarBM, bVarA);
        a(contextAnu, bVarBM.build(), false, false, at.a(contextAnu, file, downloadParamsEy.mTaskId, downloadParamsEy.requestInstallPermission), downloadParamsEy.mTaskId, 1, 2);
    }

    public final void du(String str) {
        Context contextAnu = ServiceProvider.anu();
        DownloadParams downloadParamsEy = com.kwad.sdk.core.a.WS().ey(str);
        com.kwad.sdk.core.a.WS().ez(str);
        if (contextAnu == null || downloadParamsEy == null) {
            return;
        }
        com.kwad.sdk.core.a.WS().ez(downloadParamsEy.filePath);
        b bVarA = b.a(downloadParamsEy, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b bVarBM = com.kwad.sdk.core.download.b.b.bM(contextAnu);
        if (bVarBM == null) {
            return;
        }
        a(contextAnu, bVarBM, bVarA);
        a(contextAnu, bVarBM.build(), false, false, at.e(contextAnu, downloadParamsEy.mPkgname, downloadParamsEy.mTaskId), downloadParamsEy.mTaskId, 1, 2);
    }

    private static DownloadParams l(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(R(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(R(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = bBH.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(absolutePath);
        bBH.put(absolutePath, new WeakReference<>(bitmapDecodeFile));
        return bitmapDecodeFile;
    }

    private static Bitmap R(Context context, String str) {
        WeakReference<Bitmap> weakReference = bBH.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(bb.ef(context), bb.aL(context, str));
        bBH.put(str, new WeakReference<>(bitmapDecodeResource));
        return bitmapDecodeResource;
    }

    public final void ea(int i) {
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu == null) {
            return;
        }
        ((NotificationManager) contextAnu.getSystemService("notification")).cancel(i);
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(bb.getAppIconId(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(at.a(context, i, intent));
        }
        Handler handler = bBJ;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    static class HandlerC0584a extends Handler {
        private final SparseArray<Long> bBN;

        HandlerC0584a() {
            super(Looper.getMainLooper());
            this.bBN = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            boolean z2 = message.arg2 == 1;
            boolean z3 = message.arg2 == 2;
            Long l = this.bBN.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.SL().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.SL().dX(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (z || l == null || System.currentTimeMillis() - l.longValue() >= 110) {
                    if (z2) {
                        notificationManager.cancel(message.what);
                    }
                    a.a(message.what, (Notification) message.obj);
                    this.bBN.put(message.what, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            }
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File fileZS = bVar.ZS();
        if (!((fileZS == null || !fileZS.exists()) ? false : a(cVar, fileZS))) {
            a(context, cVar, b.ZO());
        }
        cVar.setStatus(bVar.ZR());
        cVar.setSize(bVar.ZP());
        cVar.setPercentNum(bVar.ZT());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File fileZS = bVar2.ZS();
        if (!((fileZS == null || !fileZS.exists()) ? false : a(bVar, fileZS))) {
            a(context, bVar, b.ZO());
        }
        bVar.setStatus(bVar2.ZR());
        bVar.setSize(bVar2.ZQ());
        bVar.setInstallText(bVar2.ZU());
    }

    static class b {
        private static String bBO = "ksad_notification_default_icon";
        private String ajn;
        private String bBP;
        private String bBQ;
        private String bBS;
        private String name;
        private int progress;
        private File bBR = null;
        private boolean bBT = false;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2, boolean z, int i) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File fileDw = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).dw(downloadParams.mAppIcon);
                if (fileDw != null && fileDw.exists()) {
                    bVar.bBR = fileDw;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.bBT = downloadTask.isPaused();
            bVar.ajn = str;
            bVar.bBS = str2;
            bVar.bBQ = a.aW(downloadTask.getSmallFileTotalBytes());
            int iA = t.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z, i);
            bVar.progress = iA;
            bVar.bBP = a.aW((long) (downloadTask.getSmallFileTotalBytes() * ((iA * 1.0d) / 100.0d))) + " / " + a.aW(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File fileDw;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (fileDw = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).dw(downloadParams.mAppIcon)) != null && fileDw.exists()) {
                bVar.bBR = fileDw;
            }
            bVar.ajn = str;
            bVar.bBQ = a.aW(downloadParams.mAppSize);
            bVar.bBS = str2;
            return bVar;
        }

        public static String ZO() {
            return bBO;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final String ZP() {
            return this.bBP;
        }

        public final String ZQ() {
            return this.bBQ;
        }

        public final String ZR() {
            return this.ajn;
        }

        public final File ZS() {
            return this.bBR;
        }

        public final String ZT() {
            return "正在下载 " + this.progress + "%";
        }

        public final int getProgress() {
            return this.progress;
        }

        public final String ZU() {
            return this.bBS;
        }

        public final boolean isPaused() {
            return this.bBT;
        }
    }

    static class c extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }

        private static void e(Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            com.kwad.sdk.c.SL().dZ(downloadTaskG.getId());
        }

        private static void f(Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            downloadTaskG.setNotificationRemoved(true);
        }

        private static DownloadTask g(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.SL().dX(i);
        }
    }
}
