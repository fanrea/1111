package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.location.LocationRequestCompat;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.dj;
import com.qq.e.comm.plugin.hg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xq implements dj {
    protected final kq a;
    protected final Context b;
    protected final ed c;
    protected final VideoOption d;
    protected final f5 e;
    protected yq f;
    private final dj.a g;
    protected br h;
    protected boolean i;
    private e20 j;
    private Activity k;
    private final m8 l = new m8();

    private rg f() {
        rg rgVar = new rg(this.b, this.c.c0(), true, true);
        rgVar.a(this.e);
        rgVar.a(true);
        rgVar.b(true);
        return rgVar;
    }

    public xq(Context context, ed edVar, VideoOption videoOption, dj.a aVar, f5 f5Var) {
        kq kqVar = new kq(context, edVar.y0());
        this.a = kqVar;
        this.c = edVar;
        this.b = context;
        this.d = videoOption;
        this.e = f5Var;
        this.g = aVar;
        this.f = edVar.p0();
        this.i = true;
        this.h = new br(context, kqVar, edVar, videoOption, f5Var);
    }

    @Override // com.qq.e.comm.plugin.dj
    public void destroy() {
        br brVar = this.h;
        if (brVar != null) {
            brVar.h();
        }
        e20 e20Var = this.j;
        if (e20Var != null) {
            e20Var.a();
        }
    }

    @Override // com.qq.e.comm.plugin.dj
    public ik b() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.dj
    public void a(boolean z) {
        id.a(this.e, 0);
        if (b(z)) {
            h();
        } else {
            g();
        }
    }

    /* compiled from: A */
    class a implements xl {
        final /* synthetic */ Cif a;

        @Override // com.qq.e.comm.plugin.xl
        public void b(long j) {
        }

        @Override // com.qq.e.comm.plugin.xl
        public long c() {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }

        a(Cif cif) {
            this.a = cif;
        }

        @Override // com.qq.e.comm.plugin.xl
        public void a(long j) throws JSONException {
            this.a.a(j);
            this.a.a(xq.this.l.a(j).f());
        }
    }

    /* compiled from: A */
    class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (xq.this.k.equals(activity)) {
                ((LifecycleCallback) x5.b(xq.this.c.s0(), LifecycleCallback.class)).I().b(LifecycleCallback.a.RESUMED);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (xq.this.k.equals(activity)) {
                ((LifecycleCallback) x5.b(xq.this.c.s0(), LifecycleCallback.class)).I().b(LifecycleCallback.a.PAUSED);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.dj
    public View a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void j() {
        /*
            r4 = this;
            com.qq.e.comm.plugin.ed r0 = r4.c
            int r0 = r0.L1()
            com.qq.e.comm.plugin.ed r1 = r4.c
            int r1 = r1.J1()
            if (r0 <= 0) goto L21
            android.content.Context r2 = r4.b
            int r3 = com.qq.e.comm.plugin.yu.c(r2)
            int r2 = com.qq.e.comm.plugin.yu.b(r2, r3)
            if (r0 >= r2) goto L21
            android.content.Context r2 = r4.b
            int r0 = com.qq.e.comm.plugin.yu.a(r2, r0)
            goto L22
        L21:
            r0 = -1
        L22:
            if (r1 <= 0) goto L2b
            android.content.Context r2 = r4.b
            int r1 = com.qq.e.comm.plugin.yu.a(r2, r1)
            goto L2c
        L2b:
            r1 = -2
        L2c:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r0, r1)
            r0 = 17
            r2.gravity = r0
            com.qq.e.comm.plugin.kq r0 = r4.a
            r0.setLayoutParams(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.xq.j():void");
    }

    private al e() {
        if (this.c.k() == e2.NATIVEEXPRESSAD && this.c.C1() && !TextUtils.isEmpty(this.c.a())) {
            return new fq(this.b, this.c);
        }
        return null;
    }

    private JSONObject i() throws JSONException {
        m8 m8Var = new m8();
        if (this.d != null) {
            m8Var.g(!r1.getAutoPlayMuted());
        } else {
            m8Var.g(false);
        }
        return m8Var.f();
    }

    protected void g() {
        c();
    }

    protected void h() {
        d();
    }

    protected void c() {
        this.g.a(103);
    }

    protected void d() {
        this.g.a(this.h);
    }

    private void b(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.getApplication().registerActivityLifecycleCallbacks(new b());
    }

    protected boolean b(boolean z) throws JSONException {
        Cif cifA = q8.a().a(this.b, this.c, this.i);
        if (cifA == null) {
            g();
            return false;
        }
        a(cifA, z);
        return true;
    }

    private f6 a(FrameLayout frameLayout) {
        int iA = yu.a(this.b, 46);
        f6 f6Var = new f6(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        f6Var.setLayoutParams(layoutParams);
        f6Var.setVisibility(4);
        frameLayout.addView(f6Var);
        return f6Var;
    }

    private void a(Cif cif) {
        this.j = new e20(this.c);
        a aVar = new a(cif);
        if (!hg.I && this.c.C1()) {
            this.j.a(aVar, false);
        } else {
            this.j.a(aVar, true);
        }
        b(this.k);
    }

    protected void a(Cif cif, boolean z) throws JSONException {
        hg.b bVar;
        al alVar;
        mh mhVarJ;
        f6 f6Var;
        this.h.b(cif);
        if (cif.o()) {
            a(cif);
        }
        View viewL = cif.l();
        this.a.removeAllViews();
        rg rgVar = null;
        f6VarA = null;
        f6 f6VarA = null;
        if (this.c.C1()) {
            cif.a((hg.c) null);
            al alVarE = e();
            rg rgVarF = f();
            hg.b bVarF = cif.f();
            mhVarJ = cif.j();
            if (bVarF != null && mhVarJ != null) {
                bVarF.addView(rgVarF);
                mhVarJ.a(rgVarF);
                if (alVarE != null) {
                    bVarF.addView(alVarE.a(), -1, -1);
                }
                f6VarA = a(bVarF);
            }
            f6Var = f6VarA;
            rgVar = rgVarF;
            bVar = bVarF;
            alVar = alVarE;
        } else {
            bVar = null;
            alVar = null;
            mhVarJ = null;
            f6Var = null;
        }
        if (this.c.N1()) {
            this.a.addView(viewL);
        } else {
            this.a.addView(viewL, -1, -1);
        }
        this.h.a(cif, mhVarJ, rgVar, bVar, alVar, f6Var, z);
        cif.a(i());
        j();
    }

    @Override // com.qq.e.comm.plugin.dj
    public void a(Activity activity) {
        this.k = activity;
    }
}
