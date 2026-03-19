package com.sigmob.sdk.base.services;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.services.f;
import com.sigmob.sdk.base.utils.p;
import java.util.Date;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements f.a {
    private static final String c = "BuriedPointConfig";
    a a;
    g b = g.STOP;

    public b() {
        if (this.a == null) {
            this.a = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static /* synthetic */ void a(o oVar, Context context) {
        ?? r2;
        boolean zB;
        List<String> listV = oVar.V();
        if (com.sigmob.sdk.base.utils.e.a(listV)) {
            return;
        }
        for (String str : listV) {
            boolean z = false;
            if (oVar.L()) {
                zB = t.a(context, str);
            } else if (oVar.M()) {
                z = true;
                zB = t.b(context, str);
            } else {
                r2 = 0;
                ac.a(str, z, (int) r2);
            }
            boolean z2 = z;
            z = zB;
            r2 = z2;
            ac.a(str, z, (int) r2);
        }
        c();
    }

    public static boolean a() {
        return p.a(com.sigmob.sdk.b.e(), c, n.c, "").equals(Constants.sdf.format(new Date()));
    }

    public static void b() {
        try {
            j();
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        p.b(com.sigmob.sdk.b.e(), c, n.c, Constants.sdf.format(new Date()));
    }

    private static boolean c(Context context) {
        return p.a(context, c, n.b, "").equals(Constants.sdf.format(new Date()));
    }

    private static List<PackageInfo> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return AppPackageUtil.getPackageManager(context).getInstalledPackages(0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d() {
        final Context contextE = com.sigmob.sdk.b.e();
        boolean zI = i.a().i();
        if (contextE == null || !zI) {
            return;
        }
        final o oVarA = o.a();
        if (a() || !oVarA.N().booleanValue()) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                b.a(oVarA, contextE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context) {
        try {
            List<PackageInfo> listD = d(context);
            if (com.sigmob.sdk.base.utils.e.a(listD)) {
                return;
            }
            for (int i = 0; i < listD.size(); i++) {
                PackageInfo packageInfo = listD.get(i);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    ac.a(packageInfo, 0);
                }
            }
            p.b(context, c, n.b, Constants.sdf.format(new Date()));
        } catch (Throwable th) {
            SigmobLog.e("update app info", th);
        }
    }

    private static void i() {
        final Context contextE = com.sigmob.sdk.b.e();
        if (c(contextE)) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.e(contextE);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j() {
        /*
            com.sigmob.sdk.base.i r0 = com.sigmob.sdk.base.i.a()     // Catch: java.lang.Throwable -> L45
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L4b
            com.sigmob.windad.WindAds r0 = com.sigmob.windad.WindAds.sharedAds()     // Catch: java.lang.Throwable -> L45
            com.sigmob.windad.WindAdOptions r0 = r0.getOptions()     // Catch: java.lang.Throwable -> L45
            com.sigmob.sdk.base.o r1 = com.sigmob.sdk.base.o.a()     // Catch: java.lang.Throwable -> L45
            int r2 = r1.ae()     // Catch: java.lang.Throwable -> L45
            boolean r3 = r1.j()     // Catch: java.lang.Throwable -> L45
            boolean r1 = r1.T()     // Catch: java.lang.Throwable -> L45
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L27
            goto L3f
        L27:
            if (r2 == r5) goto L3e
            r3 = 2
            if (r2 == r3) goto L3f
            if (r0 == 0) goto L39
            com.sigmob.windad.WindCustomController r0 = r0.getCustomController()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L39
            boolean r0 = r0.isCanUseAppList()     // Catch: java.lang.Throwable -> L45
            goto L3a
        L39:
            r0 = r5
        L3a:
            if (r0 == 0) goto L3f
            if (r1 != 0) goto L3f
        L3e:
            r4 = r5
        L3f:
            if (r4 == 0) goto L4b
            i()     // Catch: java.lang.Throwable -> L45
            goto L4b
        L45:
            r0 = move-exception
            java.lang.String r1 = "BuriedPointManager getInstance"
            com.czhj.sdk.logger.SigmobLog.e(r1, r0)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.b.j():void");
    }

    public void a(Context context) {
        if (o.a().ad()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.f792K));
        if (Build.VERSION.SDK_INT >= 27) {
            intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.L));
        }
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.I));
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.H));
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.J));
        intentFilter.addDataScheme("package");
        t.a(context, this.a, intentFilter);
    }

    public void b(Context context) {
        context.unregisterReceiver(this.a);
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public boolean e() {
        if (this.b == g.RUNNING) {
            return false;
        }
        a(com.sigmob.sdk.b.e());
        this.b = g.RUNNING;
        return true;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public g f() {
        return this.b;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public void g() {
        if (this.b == g.RUNNING) {
            b(com.sigmob.sdk.b.e());
            this.b = g.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public Error h() {
        return null;
    }
}
