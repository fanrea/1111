package com.qq.e.comm.plugin;

import android.content.Context;
import androidx.core.location.LocationRequestCompat;
import com.kwad.components.offline.api.explore.model.ExploreConstants;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class he extends sd {
    @Override // com.qq.e.comm.plugin.sd
    public String d() {
        return ExploreConstants.SCENE_REWARD;
    }

    @Override // com.qq.e.comm.plugin.sd
    public long f() {
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean j() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean k() {
        return ke.a() <= 0;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean n() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean p() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.sd
    public void q() {
    }

    @Override // com.qq.e.comm.plugin.sd
    public void r() {
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean s() {
        return true;
    }

    public he(h4 h4Var) {
        super(h4Var);
    }

    @Override // com.qq.e.comm.plugin.sd
    public int b() {
        h4 h4Var = this.a;
        if (h4Var instanceof pw) {
            return ((pw) h4Var).K1();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean m() {
        return xc.a("te_rvnsdbr", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean o() {
        return xc.a("te_rvnsdaecar", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public boolean a() {
        return xc.a("te_rvnsecwvf", this.a.y0(), 0, this.a.x0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.sd
    public int c() {
        return xc.a("restpl", this.a.y0(), 0, this.a.x0());
    }

    @Override // com.qq.e.comm.plugin.sd
    public int e() {
        int iO;
        int iA = xc.a("fsrmidt", this.a.y0(), -1, this.a.x0());
        if (iA != -1) {
            return iA;
        }
        if (this.a.p0() == null || (iO = this.a.p0().o()) < 0) {
            return 4;
        }
        return iO;
    }

    @Override // com.qq.e.comm.plugin.sd
    public int h() {
        return this.a.C1() ? 1 : 2;
    }

    @Override // com.qq.e.comm.plugin.sd
    public void a(Context context) {
        h4 h4Var = this.a;
        if (h4Var instanceof pw) {
            dx.a(context, (pw) h4Var);
        }
    }
}
