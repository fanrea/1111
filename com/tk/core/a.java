package com.tk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import com.tk.core.a.b;
import com.tk.core.a.e;
import com.tk.core.a.g;
import com.tk.core.a.h;
import com.tk.core.a.i;
import com.tk.core.a.l;
import com.tk.core.a.p;
import com.tk.core.a.q;
import com.tk.core.a.r;
import com.tk.core.a.s;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.manager.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static Application Yb;
    private static final a Yc = new a();
    private d Yd;
    private volatile boolean Ye = false;
    private i Yf;
    private e Yg;
    private h Yh;
    private p Yi;
    private s Yj;
    private r Yk;
    private l Yl;
    private q Ym;
    private b Yn;
    private g Yo;

    private a() {
    }

    public static a oP() {
        return Yc;
    }

    public final void a(i iVar) {
        this.Yf = iVar;
    }

    public final void a(l lVar) {
        this.Yl = lVar;
    }

    public final l oQ() {
        return this.Yl;
    }

    public final void a(e eVar) {
        this.Yg = eVar;
    }

    public final void a(h hVar) {
        this.Yh = hVar;
    }

    public final h oR() {
        return this.Yh;
    }

    public final i oS() {
        return this.Yf;
    }

    public final e oT() {
        return this.Yg;
    }

    public final p oU() {
        return this.Yi;
    }

    public final void setITKNetworkProvider(p pVar) {
        this.Yi = pVar;
    }

    public final void init(Application application, s sVar, boolean z) {
        Yb = application;
        this.Yj = sVar;
        com.tk.core.o.s.d(application);
        this.Yd = d.rZ();
        this.Yd.aE(z);
    }

    public final void setInitResult(boolean z) {
        if (this.Ye == z) {
            return;
        }
        this.Ye = z;
        if (this.Ye) {
            oW();
        }
    }

    public final boolean isInitSuccess() {
        return this.Ye;
    }

    @Deprecated
    public final com.tk.core.bridge.b a(boolean z, IsolatePool.b bVar, String str) {
        return a(Yb, z, bVar, str);
    }

    public final com.tk.core.bridge.b a(Context context, boolean z, IsolatePool.b bVar, String str) {
        com.tk.core.bridge.b bVar2 = new com.tk.core.bridge.b(context, z, bVar, this.Yd, str);
        bVar2.onCreate();
        return bVar2;
    }

    public final com.tk.core.bridge.b a(Context context, boolean z, IsolatePool.b bVar, ViewGroup viewGroup, String str) {
        if (context == null) {
            context = viewGroup.getContext();
        }
        com.tk.core.bridge.b bVar2 = new com.tk.core.bridge.b(context, z, bVar, viewGroup, this.Yd, str);
        bVar2.onCreate();
        return bVar2;
    }

    public final d oV() {
        return this.Yd;
    }

    public final s getTKInitParams() {
        s sVar = this.Yj;
        if (sVar != null) {
            return sVar;
        }
        throw new RuntimeException("TKInitParams cannot be null! Please invoke TachikomaApi.getInstance().init() first!");
    }

    public final r getCommonParams() {
        if (this.Yk == null) {
            this.Yk = getTKInitParams().getCommonParams();
        }
        r rVar = this.Yk;
        if (rVar != null) {
            return rVar;
        }
        throw new RuntimeException("TKInitCommonParams cannot be null! Please return non null for method TKInitParams.getCommonParams()");
    }

    public final boolean isReleaseMode() {
        getCommonParams();
        return true;
    }

    public final boolean isDebugMode() {
        getCommonParams();
        return false;
    }

    private void oW() {
        if (this.Ye) {
            isReleaseMode();
        }
    }

    public final void a(g gVar) {
        this.Yo = gVar;
    }

    public final void setTKSwitch(q qVar) {
        this.Ym = qVar;
    }

    public final q getTKSwitch() {
        return this.Ym;
    }

    public final g getExtraExceptionProvider() {
        return this.Yo;
    }

    public final void setDownloadDelegate(b bVar) {
        this.Yn = bVar;
    }
}
