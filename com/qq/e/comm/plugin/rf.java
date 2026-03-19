package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.ra;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rf {

    /* compiled from: A */
    private static class c {
        private static final rf a = new rf(null);
    }

    private int c() {
        return r1.d().f().a("iooao", 2);
    }

    private rf() {
    }

    /* synthetic */ rf(a aVar) {
        this();
    }

    /* compiled from: A */
    class a implements Comparator<ApkDownloadTask> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2) {
            long jE = apkDownloadTask.e();
            long jE2 = apkDownloadTask2.e();
            if (jE > jE2) {
                return -1;
            }
            return jE < jE2 ? 1 : 0;
        }
    }

    private static boolean b(ApkDownloadTask apkDownloadTask, int i) {
        int iO = apkDownloadTask.o();
        return (i & 2) != 0 && (iO == 1 || iO == 8) && q.b(r1.d().a(), apkDownloadTask.r()) && !ct.a(apkDownloadTask.r());
    }

    public static rf b() {
        return c.a;
    }

    private void a(ApkDownloadTask apkDownloadTask, int i, GDTAppDialogClickListener gDTAppDialogClickListener) {
        String str;
        String str2;
        String strP = apkDownloadTask.p();
        if (i == 1) {
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(strP)) {
                strP = "应用";
            }
            objArr[0] = strP;
            str = String.format("您已下载\"%s\"现在要安装吗？", objArr);
            str2 = "安装";
        } else if (i == 2) {
            Object[] objArr2 = new Object[1];
            if (TextUtils.isEmpty(strP)) {
                strP = "应用";
            }
            objArr2[0] = strP;
            str = String.format("您已安装\"%s\"现在要打开吗？", objArr2);
            str2 = "打开";
        } else {
            str = "";
            str2 = "确定";
        }
        b10.a(1130029, new f5().a(apkDownloadTask.a()), Integer.valueOf(i));
        ra.a(str, str2, "取消", new b(i, apkDownloadTask, gDTAppDialogClickListener));
    }

    /* compiled from: A */
    class b implements ra.b {
        final /* synthetic */ int a;
        final /* synthetic */ ApkDownloadTask b;
        final /* synthetic */ GDTAppDialogClickListener c;

        b(int i, ApkDownloadTask apkDownloadTask, GDTAppDialogClickListener gDTAppDialogClickListener) {
            this.a = i;
            this.b = apkDownloadTask;
            this.c = gDTAppDialogClickListener;
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void a() throws JSONException {
            if (this.a == 2) {
                j3.a(this.b.r()).i = 4;
                ct.b(this.b);
            } else {
                j3.a(this.b.r()).d = 4;
                lf.b(this.b);
            }
            this.c.onButtonClick(1);
            b10.a(1130030, new f5().a(this.b.a()), Integer.valueOf(this.a));
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void b() {
            this.c.onButtonClick(2);
            b10.a(1130031, new f5().a(this.b.a()), Integer.valueOf(this.a));
        }
    }

    private static boolean a(ApkDownloadTask apkDownloadTask, int i) {
        return (i & 1) != 0 && apkDownloadTask.o() == 8 && q.d(apkDownloadTask) && !q.b(r1.d().a(), apkDownloadTask.r()) && q.a(lf.a(apkDownloadTask), apkDownloadTask.r(), r1.d().a());
    }

    private void a(List<ApkDownloadTask> list, int i) {
        boolean z = true;
        for (ApkDownloadTask apkDownloadTask : list) {
            if (b(apkDownloadTask, i) || a(apkDownloadTask, i)) {
                if (!apkDownloadTask.y() && !lf.c(apkDownloadTask)) {
                    z = false;
                }
            }
        }
        if (z) {
            for (ApkDownloadTask apkDownloadTask2 : list) {
                apkDownloadTask2.a(false);
                com.qq.e.comm.plugin.apkmanager.l.e().d(apkDownloadTask2);
            }
        }
    }

    public int a(GDTAppDialogClickListener gDTAppDialogClickListener) {
        ApkDownloadTask next;
        int i;
        b10.a(1130028, new f5());
        if (gDTAppDialogClickListener == null) {
            GDTLogger.e("showOpenOrInstallAppDialog传入的listener参数为null");
            return 0;
        }
        int iA = a();
        if (iA <= 0) {
            return 0;
        }
        List<ApkDownloadTask> listB = com.qq.e.comm.plugin.apkmanager.l.e().b();
        if (lf.a(listB)) {
            return 0;
        }
        a(listB, iA);
        Collections.sort(listB, new a());
        Iterator<ApkDownloadTask> it = listB.iterator();
        while (it.hasNext()) {
            next = it.next();
            next.toString();
            if (!lf.c(next) && !next.y()) {
                if (c() == 1) {
                    if (a(next, iA)) {
                        i = 1;
                        break;
                    }
                    if (b(next, iA)) {
                        i = 2;
                        break;
                    }
                } else {
                    if (b(next, iA)) {
                        i = 2;
                        break;
                    }
                    if (a(next, iA)) {
                        i = 1;
                        break;
                    }
                }
            }
        }
        next = null;
        i = 0;
        if (next == null) {
            return 0;
        }
        next.a(true);
        com.qq.e.comm.plugin.apkmanager.l.e().d(next);
        a(next, i, gDTAppDialogClickListener);
        return i;
    }

    private int a() {
        return r1.d().f().a("cnic", 3);
    }
}
