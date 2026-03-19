package com.qq.e.comm.plugin;

import android.content.Context;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qh {
    private final Context a;
    private h4 b;
    private h4 c;
    private String d;
    private boolean e;
    private f f;
    private boolean g;
    private boolean h;
    private boolean i;
    private zk j;
    private boolean k;
    private boolean l;
    private String m;

    public qh(Context context) {
        this(context, null);
    }

    public qh(Context context, h4 h4Var) {
        this.g = true;
        this.h = true;
        this.i = true;
        this.a = context;
        this.c = h4Var;
        this.d = h4Var == null ? null : h4Var.y0();
    }

    public jm a() {
        bm psVar;
        jm jmVarA = new p50(this.a, this.m, this.l).a(this.c).a();
        if (!this.k) {
            psVar = new d30(jmVarA);
            mf mfVar = new mf(this.c);
            psVar.a("download", mfVar).a("package", mfVar).a(PointCategory.NETWORK, mfVar);
            h50 h50Var = new h50(this.c);
            psVar.a(h50Var.a(), h50Var);
        } else {
            psVar = new ps(jmVarA, this.j);
            psVar.a(io.b()).a(d.b()).a(yt.b()).a(n5.b());
            f fVar = this.f;
            if (fVar != null) {
                jmVarA.a(fVar);
            }
            jmVarA.a(new a(psVar));
        }
        y6 y6Var = new y6(this.d);
        psVar.a(y6Var.a(), y6Var);
        jmVarA.f(!this.k);
        jmVarA.a(psVar);
        jmVarA.e(this.e);
        jmVarA.setFocusable(this.g);
        jmVarA.setFocusableInTouchMode(this.h);
        jmVarA.a(this.i);
        return jmVarA;
    }

    /* compiled from: A */
    class a implements m {
        final /* synthetic */ bm a;

        a(bm bmVar) {
            this.a = bmVar;
        }

        @Override // com.qq.e.comm.plugin.m
        public void a(String str, int i, int i2, long j) {
            HashMap map = new HashMap();
            map.put("pkgName", str);
            map.put("status", Integer.valueOf(i));
            map.put("progress", Integer.valueOf(i2));
            map.put("totalSize", Long.valueOf(j));
            this.a.a(new sg("apkStatusChange", new JSONObject(map)));
        }
    }

    @Deprecated
    public qh(Context context, h4 h4Var, zk zkVar) {
        this.g = true;
        this.h = true;
        this.i = true;
        this.a = context;
        this.b = h4Var;
        this.c = h4Var;
        this.d = h4Var == null ? null : h4Var.y0();
        this.j = zkVar;
    }

    @Deprecated
    public qh a(f fVar) {
        this.f = fVar;
        return this;
    }

    public qh(Context context, h4 h4Var, boolean z) {
        this(context, h4Var);
        this.e = z;
    }

    @Deprecated
    public qh a(boolean z) {
        this.k = z;
        return this;
    }
}
