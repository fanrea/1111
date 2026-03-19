package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zg implements yg {
    private final mk a;
    private final yg b;
    private final f5 c;
    private final h4 d;
    private int e;

    public zg(mk mkVar, yg ygVar, h4 h4Var) {
        this.a = mkVar;
        this.b = ygVar;
        this.c = f5.a(h4Var);
        this.d = h4Var;
    }

    @Override // com.qq.e.comm.plugin.yg
    public void onVideoReady() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.onVideoReady();
        }
    }

    @Override // com.qq.e.comm.plugin.yg
    public void onVideoStart() throws JSONException {
        this.e++;
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.onVideoStart();
        }
        if (this.e > 1) {
            o40.a(this.c, this.a.getDuration(), this.e, true);
        } else {
            o40.a(this.c, this.a, false, this.d);
        }
    }

    @Override // com.qq.e.comm.plugin.yg
    public void a() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.a();
        }
        o40.a(this.c, this.a.getDuration());
    }

    @Override // com.qq.e.comm.plugin.yg
    public void onVideoStop() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.onVideoStop();
        }
    }

    @Override // com.qq.e.comm.plugin.yg
    public void onVideoPause() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.onVideoPause();
        }
        o40.a(this.c, this.a.getDuration(), this.a.i(), false);
    }

    @Override // com.qq.e.comm.plugin.yg
    public void onVideoResume() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.onVideoResume();
        }
        o40.b(this.c, this.a.getDuration(), this.a.i(), false);
    }

    @Override // com.qq.e.comm.plugin.yg
    public void d() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.d();
        }
    }

    @Override // com.qq.e.comm.plugin.yg
    public void b() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.yg
    public void c() {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.c();
        }
        if (this.e > 0) {
            o40.b(this.c, this.a.getDuration(), this.a.getCurrentPosition());
        }
        o40.a(this.c, this.a.getDuration(), this.e);
    }

    @Override // com.qq.e.comm.plugin.yg
    public void a(int i, Exception exc) throws JSONException {
        yg ygVar = this.b;
        if (ygVar != null) {
            ygVar.a(i, exc);
        }
        o40.a(this.c, this.a.getDuration(), i, exc.getMessage(), this.d, p40.a(this.a.g()), this.a.getPlayerVersion());
    }
}
