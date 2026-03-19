package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class jf {
    private Context a = r1.d().a();

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ IGDTApkListener a;
        final /* synthetic */ c3 b;

        a(IGDTApkListener iGDTApkListener, c3 c3Var) {
            this.a = iGDTApkListener;
            this.b = c3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            IGDTApkListener iGDTApkListener = this.a;
            if (iGDTApkListener != null) {
                iGDTApkListener.onApkLoad(this.b);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ IGDTApkListener a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        b(IGDTApkListener iGDTApkListener, int i, String str) {
            this.a = iGDTApkListener;
            this.b = i;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onError(new AdError(this.b, this.c));
        }
    }

    private void a(IGDTApkListener iGDTApkListener, int i, String str) {
        if (iGDTApkListener != null) {
            xo.a((Runnable) new b(iGDTApkListener, i, str));
        }
    }

    public void a(Context context, GDTApk gDTApk, IGDTApkListener iGDTApkListener) {
        if (context != null && gDTApk != null && iGDTApkListener != null) {
            ApkDownloadTask apkDownloadTaskA = gDTApk instanceof c3 ? ((c3) gDTApk).a() : null;
            if (apkDownloadTaskA == null) {
                GDTLogger.e("传入的 GDTApk 为 null");
                return;
            }
            b10.a(100422, new f5().a(apkDownloadTaskA.a()), 1);
            if (!q.d(apkDownloadTaskA)) {
                a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NULL, "调用安装器时，Apk 文件不存在");
                return;
            } else if (lf.a(yy.a("downloaded_not_installed_apk", System.currentTimeMillis()), System.currentTimeMillis(), apkDownloadTaskA)) {
                a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_INTER_TIME, "接口调用时间间隔过长!");
                return;
            } else {
                j3.a(apkDownloadTaskA.r()).d = 5;
                lf.b(apkDownloadTaskA);
                return;
            }
        }
        GDTLogger.e("传入参数为 null");
    }

    public void a(IGDTApkListener iGDTApkListener) {
        if (r1.d().f().a("apk_downloaded_task", 0) == 0) {
            a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK, "接口功能未开启");
            return;
        }
        if (lf.d()) {
            a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_THROTTLING, "调用接口短时间内过于频繁，请稍后再试!");
            return;
        }
        List<ApkDownloadTask> listC = com.qq.e.comm.plugin.apkmanager.l.e().c();
        if (lf.a(listC)) {
            a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS, "不存在有效的 Apk 文件");
            return;
        }
        if (listC.size() == 1) {
            ApkDownloadTask apkDownloadTask = listC.get(0);
            if (!lf.c(apkDownloadTask) && !q.b(r1.d().a(), apkDownloadTask.r())) {
                apkDownloadTask.a(true);
                com.qq.e.comm.plugin.apkmanager.l.e().d(apkDownloadTask);
                apkDownloadTask.toString();
                System.currentTimeMillis();
                apkDownloadTask.e();
                yy.b("downloaded_not_installed_apk", System.currentTimeMillis());
                b10.a(100412, new f5().a(apkDownloadTask.a()), 1);
                if (q.d(apkDownloadTask) && q.a(lf.a(apkDownloadTask), apkDownloadTask.r(), this.a)) {
                    a(iGDTApkListener, lf.d(apkDownloadTask));
                    return;
                }
            }
            a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS, "不存在有效的 Apk 文件");
            return;
        }
        Iterator<ApkDownloadTask> it = listC.iterator();
        while (it.hasNext()) {
            ApkDownloadTask next = it.next();
            if (lf.c(next) || q.b(r1.d().a(), next.r()) || !q.d(next) || !q.a(lf.a(next), next.r(), this.a)) {
                it.remove();
            }
        }
        if (lf.a(listC)) {
            a(iGDTApkListener, ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS, "不存在有效的 Apk 文件");
            return;
        }
        lf.b(listC);
        ApkDownloadTask apkDownloadTask2 = listC.get(0);
        for (int i = 1; i < listC.size(); i++) {
            ApkDownloadTask apkDownloadTask3 = listC.get(i);
            if ((!apkDownloadTask3.y() && apkDownloadTask2.e() > apkDownloadTask3.e()) || apkDownloadTask2.y()) {
                apkDownloadTask2 = apkDownloadTask3;
            }
        }
        apkDownloadTask2.a(true);
        com.qq.e.comm.plugin.apkmanager.l.e().d(apkDownloadTask2);
        yy.b("downloaded_not_installed_apk", System.currentTimeMillis());
        b10.a(100412, new f5().a(apkDownloadTask2.a()), 1);
        a(iGDTApkListener, lf.d(apkDownloadTask2));
    }

    private void a(IGDTApkListener iGDTApkListener, c3 c3Var) {
        xo.a((Runnable) new a(iGDTApkListener, c3Var));
    }
}
