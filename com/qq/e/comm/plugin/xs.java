package com.qq.e.comm.plugin;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import com.qq.e.comm.plugin.on;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xs extends o0 {
    private static final r10 i = new r10();
    private Intent d;
    private ca e;
    private long f;
    private int g = -1;
    private boolean h = false;

    static /* synthetic */ long a(xs xsVar) {
        return pro.getJresult(60, 1, xsVar);
    }

    private void a(int i2, l6 l6Var) {
        pro.getVresult(61, 0, this, Integer.valueOf(i2), l6Var);
    }

    private void a(ResolveInfo resolveInfo, boolean z) {
        pro.getVresult(62, 0, this, resolveInfo, Boolean.valueOf(z));
    }

    private void a(Boolean bool, int i2) {
        pro.getVresult(63, 0, this, bool, Integer.valueOf(i2));
    }

    static /* synthetic */ ca b(xs xsVar) {
        return (ca) pro.getobjresult(64, 1, xsVar);
    }

    static /* synthetic */ void c(xs xsVar) {
        pro.getVresult(65, 1, xsVar);
    }

    private void c(boolean z) {
        pro.getVresult(66, 0, this, Boolean.valueOf(z));
    }

    static /* synthetic */ String d(xs xsVar) {
        return (String) pro.getobjresult(67, 1, xsVar);
    }

    private String f() {
        return (String) pro.getobjresult(68, 0, this);
    }

    private void g() {
        pro.getVresult(69, 0, this);
    }

    private boolean h() {
        return pro.getZresult(70, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0, com.qq.e.comm.plugin.rs
    public void b(boolean z) {
        pro.getVresult(71, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean b() {
        return pro.getZresult(72, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean c() {
        return pro.getZresult(73, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean d() {
        return pro.getZresult(74, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean e() {
        return pro.getZresult(75, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0, com.qq.e.comm.plugin.rs
    public void onCancel() {
        pro.getVresult(76, 0, this);
    }

    xs() {
    }

    /* compiled from: A */
    class a extends on.b {
        a(int i, f5 f5Var) {
            super(i, f5Var);
        }

        @Override // com.qq.e.comm.plugin.on.b, com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean h() throws JSONException {
            if (xs.a(xs.this) > 0) {
                xs.b(xs.this).a(SystemClock.elapsedRealtime() - xs.a(xs.this));
            }
            b10.a(4002013, xs.b(xs.this));
            return super.h();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xs.c(xs.this);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = xs.this.a.a().b;
            int iA = yw.a(xs.this.a.B);
            h.b(str, iA);
            xs xsVar = xs.this;
            if (xsVar.a.h) {
                h.a(xs.d(xsVar), str, iA);
            }
            if (this.a) {
                h.a(str, iA);
            }
        }
    }
}
