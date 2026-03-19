package com.qq.e.comm.plugin;

import android.content.Context;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.qq.e.comm.plugin.q6;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xd extends sd {
    private final q6.b b;

    @Override // com.qq.e.comm.plugin.sd
    public void a(Context context) {
    }

    @Override // com.qq.e.comm.plugin.sd
    public String d() {
        return ExploreConstants.SCENE_INTERSTITIAL;
    }

    @Override // com.qq.e.comm.plugin.sd
    public long f() {
        return r1.d().f().a("ifsvmpt", this.a.y0(), 5000);
    }

    @Override // com.qq.e.comm.plugin.sd
    public int h() {
        return 4;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean k() {
        return ke.a() == 0 && xc.a("fsicids", this.a.y0(), 0, this.a.x0()) != 0;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean p() {
        return true;
    }

    public xd(h4 h4Var) {
        super(h4Var);
        this.b = q6.a(q6.c.FULL_SCREEN_INTERSTITIAL, h4Var);
    }

    @Override // com.qq.e.comm.plugin.sd
    public void q() {
        if (this.a.k() == e2.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            b10.a(9120025, f5.a(this.a), Integer.valueOf(this.b.b));
        }
    }

    @Override // com.qq.e.comm.plugin.sd
    public void r() {
        if (this.a.k() == e2.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            b10.a(9120024, f5.a(this.a), Integer.valueOf(this.b.b));
        }
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean j() {
        return this.a.w1();
    }

    @Override // com.qq.e.comm.plugin.sd
    public int b() {
        return fn.a(this.a);
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean m() {
        return xc.a("te_ifsrnsdbr", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean o() {
        return xc.a("te_ifsrnsdaecar", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean a() {
        return xc.a("te_ifsrnsecwvf", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean n() {
        return xc.a("te_ifsnrnsec", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public int c() {
        return xc.a("instpl", this.a.y0(), 0, this.a.x0());
    }

    @Override // com.qq.e.comm.plugin.sd
    public int e() {
        int iO;
        int iA = xc.a("fsimidt", this.a.y0(), -1, this.a.x0());
        if (iA != -1) {
            return iA;
        }
        if (this.a.p0() == null || (iO = this.a.p0().o()) < 0) {
            return 5;
        }
        return iO;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean s() {
        return this.a.C1();
    }
}
