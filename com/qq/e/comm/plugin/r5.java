package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.kuaishou.android.live.network.ApiStatus;
import com.qq.e.comm.plugin.s3;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r5 implements sj {
    private static final ConcurrentHashMap<Integer, WeakReference<View>> g = new ConcurrentHashMap<>();
    private static final AtomicBoolean h = new AtomicBoolean(false);
    private static final boolean i;
    private static final long j;
    private static final pl k;
    private final h4 a;
    private final w2 b = new w2();
    private final w2 c = new w2();
    private final s40 d;
    private final qu e;
    private hj f;

    static {
        i = r1.d().f().a("asdcvcr", 1) == 1;
        j = r1.d().f().a("asdcvt", 10) * 100;
        k = new ny(r1.d().a());
        s3.b().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        if (s3.b().c() && h.compareAndSet(false, true)) {
            xo.a((Runnable) new b());
        }
    }

    /* compiled from: A */
    class a implements s3.g {
        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            if (r5.g.isEmpty()) {
                return false;
            }
            r5.j();
            return false;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            return false;
        }

        a() {
        }
    }

    public r5(int i2, View view, h4 h4Var) {
        this.a = h4Var;
        g.put(Integer.valueOf(i2), new WeakReference<>(view));
        j();
        this.d = new s40(view, h4Var, this, 0);
        this.e = new qu(view.getContext(), this);
        f();
    }

    /* compiled from: A */
    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            r5.e();
        }

        b() {
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            r5.e();
        }

        c() {
        }
    }

    private static boolean i() {
        for (Map.Entry<Integer, WeakReference<View>> entry : g.entrySet()) {
            Integer key = entry.getKey();
            View view = entry.getValue().get();
            if (view != null) {
                if (d50.a(view.getContext(), view, 1, true) && (!i || !((Boolean) d50.a(view, 100).first).booleanValue())) {
                    return true;
                }
            } else {
                g.remove(key);
            }
        }
        return false;
    }

    private void c(int i2) {
        this.c.e0 = String.valueOf(i2);
    }

    public void d(int i2) {
        this.c.a0 = String.valueOf(i2);
    }

    public void e(int i2) {
        this.c.b0 = String.valueOf(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        if (i()) {
            pl plVar = k;
            if (!plVar.b()) {
                plVar.start();
            }
        } else {
            pl plVar2 = k;
            if (plVar2.b()) {
                plVar2.stop();
            }
        }
        if (s3.b().c() && !g.isEmpty()) {
            xo.a(new c(), j);
        } else {
            h.set(false);
        }
    }

    public void b(int i2) {
        this.c.N0 = i2 == 0 ? "" : String.valueOf(i2);
    }

    public h4 g() {
        return this.a;
    }

    private void f() {
        yq yqVarP0 = this.a.p0();
        if (yqVarP0 != null) {
            this.c.M0 = yqVarP0.t();
        }
    }

    public void f(int i2) {
        g.remove(Integer.valueOf(i2));
    }

    public w2 h() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.sj
    public w2 a() {
        int[] iArrA;
        String strO0 = this.a.O0();
        if (!TextUtils.isEmpty(strO0)) {
            w2 w2Var = this.b;
            w2Var.W = strO0;
            w2Var.X = String.valueOf(this.a.P0());
            Set<String> setC = c7.c(this.a);
            this.b.Z = setC.isEmpty() ? "0" : "1";
        }
        this.b.b0 = String.valueOf(TextUtils.isEmpty(this.a.V0()) ? 2 : 1);
        this.b.k0 = String.valueOf(this.a.s1() ? 1 : 0);
        e2 e2VarK = this.a.k();
        if (!e2VarK.k() && (!e2VarK.h() || !this.a.w1())) {
            this.b.l0 = "0";
        } else {
            this.b.l0 = "1";
        }
        int iA = yw.a(this.a);
        if (iA != 0) {
            this.b.O0 = String.valueOf(iA);
            this.b.N0 = "1";
        }
        if (!yh.e()) {
            iArrA = new int[]{-888, -888};
        } else {
            iArrA = k.a();
        }
        if (iArrA != null) {
            this.b.N = String.valueOf(iArrA[0]);
            this.b.O = String.valueOf(iArrA[1]);
        }
        if (e2VarK != e2.SPLASH) {
            this.c.d0 = "1";
        }
        this.b.v = String.valueOf(this.a.D0());
        return this.b;
    }

    public void c(boolean z) {
        this.c.d0 = z ? "2" : "1";
    }

    private void b(boolean z) {
        this.c.J0 = z ? "1" : "-1";
    }

    public void a(float[] fArr) {
        if (fArr != null && fArr.length >= 3) {
            this.c.f0 = ((int) (fArr[0] * 100.0f)) + "," + ((int) (fArr[1] * 100.0f)) + "," + ((int) (fArr[2] * 100.0f));
            return;
        }
        this.c.f0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
    }

    public void b(String str) {
        try {
            this.f = (hj) x2.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        hj hjVar = this.f;
        if (hjVar != null) {
            hjVar.a(str, this.b, v2.a);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.c.H0 = jSONArray.toString();
        }
    }

    private void a(y1 y1Var) {
        if (y1Var != null) {
            this.c.P0 = String.valueOf(y1Var.a());
        } else {
            this.c.P0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
        }
    }

    public void a(boolean z) {
        this.c.k0 = z ? "1" : "0";
    }

    public void a(i6 i6Var) {
        int i2 = i6Var.h;
        if (2 == i2) {
            a(i6Var.i);
        } else if (5 == i2) {
            a(i6Var.j, i6Var.k);
        } else if (!yh.e()) {
            a(new int[]{-888, -888, -888}, -888L);
        }
        a(i6Var.c);
        c(i6Var.h);
        a(i6Var.b());
        a(i6Var.o);
        a(i6Var.p);
        b(i6Var.q);
        a(i6Var.s);
    }

    private void a(int i2) {
        if (i2 > 0) {
            this.c.Y = String.valueOf(i2);
        } else {
            this.c.Y = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
        }
    }

    public void a(String str) {
        w2 w2Var = this.c;
        if (str == null) {
            str = "";
        }
        w2Var.G0 = str;
    }

    public void a(long j2) {
        if (j2 <= 0) {
            this.c.I0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
        } else {
            this.c.I0 = String.valueOf(j2);
        }
    }

    public void a(MotionEvent motionEvent, boolean z) {
        a(motionEvent, z, 0, 0);
    }

    public void a(MotionEvent motionEvent, boolean z, int i2, int i3) {
        this.d.a(motionEvent, z, this.b, i2, i3);
        this.e.a(motionEvent, z, this.b, i2, i3);
    }

    private void a(int[] iArr, long j2) {
        if (iArr != null && iArr.length == 3) {
            this.c.g0 = String.valueOf(iArr[0]);
            this.c.h0 = String.valueOf(iArr[1]);
            this.c.i0 = String.valueOf(iArr[2]);
        }
        this.c.j0 = String.valueOf(j2);
    }
}
