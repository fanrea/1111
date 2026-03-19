package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xz {
    public f20 A;
    public long B;
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final e2 e;
    public final j f;
    public String g;
    public LoadAdParams h;
    public mb i;
    public ADListener j;
    private boolean k;
    public int l;
    public byte[] m;
    public int o;
    public boolean p;
    public boolean q;
    public ViewGroup r;
    public int s;
    private mu t;
    private f5 u;
    public View w;
    public long x;
    public long y;
    public ServerSideVerificationOptions z;
    public int n = 10;
    public final AtomicReference<Boolean> v = new AtomicReference<>(null);
    public boolean C = false;

    public boolean g() {
        if (r1.d().c().A()) {
            return false;
        }
        return this.k;
    }

    xz(Context context, String str, String str2, String str3) {
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        e2 e2Var = e2.SPLASH;
        this.e = e2Var;
        this.f = new j(e2Var, str2);
    }

    void e() {
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = zz.d(this.c);
        this.t = null;
        this.u = new f5().a(e2.SPLASH).c(this.c);
        this.x = 0L;
    }

    void a() {
        this.w = null;
        this.v.set(null);
        this.r = null;
    }

    public mu b() {
        return this.t;
    }

    public f5 c() {
        return this.u;
    }

    public int d() {
        int iA;
        yq yqVarP0 = this.t.p0();
        if (yqVarP0 == null || (iA = yqVarP0.h()) <= 0) {
            iA = zz.a((h4) this.t);
        }
        return (this.n != 3 || yqVarP0 == null || !g8.d(this.t) || yqVarP0.f() <= 0) ? iA : iA + yqVarP0.f();
    }

    public boolean f() {
        return this.s > 0 && TextUtils.isEmpty(this.d) && xb.d(e2.SPLASH);
    }

    void a(mu muVar) {
        this.t = muVar;
        this.u = f5.a(muVar);
    }

    public void a(boolean z) {
        this.k = z && zz.d();
    }
}
