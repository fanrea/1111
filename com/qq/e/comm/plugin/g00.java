package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g00 {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static final Object c = new Object();
    private static volatile int d = -1;
    private static volatile int e = -1;
    private static volatile boolean f;
    private static volatile long g;

    /* compiled from: A */
    interface b {
        void a(boolean z, int i);
    }

    public static void c(String str) {
        synchronized (c) {
            yy.b("preloadOfflineIndex" + str, 0);
        }
    }

    public static boolean d() {
        if (r1.d().f().a("SplashAvoidMultiClick", 1) != 1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (g == 0 || jCurrentTimeMillis - g >= 100) {
            g = jCurrentTimeMillis;
            return false;
        }
        g = jCurrentTimeMillis;
        return true;
    }

    public static int b(String str) {
        int iA;
        synchronized (c) {
            String str2 = "preloadOfflineIndex" + str;
            iA = yy.a(str2, 0);
            yy.b(str2, iA + 1);
        }
        return iA;
    }

    public static int c() {
        return yy.a("usePreloadTime", 20);
    }

    public static synchronized void e() {
        g = 0L;
    }

    static void a(ViewGroup viewGroup, boolean z, b bVar, f5 f5Var, xz xzVar) {
        if (viewGroup == null) {
            return;
        }
        mu muVarB = xzVar.b();
        ku kuVarX0 = muVarB != null ? muVarB.x0() : null;
        if (d == -1) {
            d = xc.a("shrfssd", xzVar.c, 0, kuVarX0);
        }
        if (e == -1) {
            e = xc.a("slhrsb", xzVar.c, 0, kuVarX0);
        }
        if (e == 1 && r1.d().c().A()) {
            f = ua.a(xzVar.a);
        }
        viewGroup.post(new a(viewGroup, f5Var, z, bVar));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ f5 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ b d;

        a(ViewGroup viewGroup, f5 f5Var, boolean z, b bVar) {
            this.a = viewGroup;
            this.b = f5Var;
            this.c = z;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            int iMax;
            int height = this.a.getHeight();
            Context contextA = r1.d().a();
            int iB = yu.b(contextA, height);
            Rect rect = new Rect();
            boolean globalVisibleRect = this.a.getGlobalVisibleRect(rect);
            int iB2 = yu.b(contextA, rect.height());
            qa qaVarC = r1.d().c();
            qaVarC.y();
            boolean zA = qaVarC.A();
            int i = qaVarC.i();
            int iK = qaVarC.k();
            if (g00.d == 1) {
                DisplayMetrics displayMetricsL = qaVarC.l();
                if (displayMetricsL.heightPixels == i && displayMetricsL.widthPixels == iK && displayMetricsL.density > 1.0f) {
                    b10.a(9200023, this.b, Integer.valueOf(zA ? 1 : 2), Integer.valueOf(this.c ? 1 : 2), new ja().a("msg", Float.valueOf(displayMetricsL.density)).a("data", Integer.valueOf(iK)).a("data2", Integer.valueOf(i)));
                }
                i = yu.b(contextA, displayMetricsL.heightPixels);
                iK = yu.b(contextA, displayMetricsL.widthPixels);
            }
            if (zA) {
                iMax = Math.min(iK, i);
                if (g00.f) {
                    iMax -= yu.b(contextA, ua.f());
                }
            } else {
                iMax = Math.max(iK, i);
            }
            if (iMax > 0) {
                f00.a(this.b, (iB2 * 100) / iMax);
            } else {
                b10.a(9130091, this.b, Integer.valueOf(zA ? 1 : 2));
            }
            double dA = zz.a(this.c, zA);
            double d = iMax;
            Double.isNaN(d);
            int i2 = (int) (d * dA);
            int i3 = 0;
            if (globalVisibleRect && iB >= i2 && iB2 >= i2) {
                this.d.a(true, 0);
                return;
            }
            GDTLogger.e("广告容器的高度必须 >= 手机的高度 * " + dA + "，否则将不进行曝光上报和计费，当前的高度为：" + iB2 + com.kuaishou.weapon.p0.t.q);
            this.d.a(false, 4005);
            ja jaVarA = new ja().a("msg", Boolean.valueOf(globalVisibleRect)).a("data", Integer.valueOf(iB)).a("data2", Integer.valueOf(iB2)).a("data3", Integer.valueOf(i2)).a("height", Integer.valueOf(iMax));
            if (qaVarC.B() && qaVarC.l().density != 1.0f) {
                i3 = 1;
            }
            b10.a(9130072, this.b, Integer.valueOf(zA ? 1 : 2), Integer.valueOf(this.c ? 1 : 2), jaVarA.a("ot", Integer.valueOf(i3)));
        }
    }

    public static boolean a(String str) {
        synchronized (b) {
            String str2 = "preloadTime" + str;
            long jA = yy.a(str2, 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jB = (zz.b(str) * 1000) + jA;
            if (jA != 0 && jCurrentTimeMillis <= jB) {
                return false;
            }
            yy.b(str2, jCurrentTimeMillis);
            return true;
        }
    }

    public static void a(int i) {
        yy.b("usePreloadTime", i);
    }
}
