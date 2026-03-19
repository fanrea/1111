package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.dj;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class li extends xq {
    private boolean m;
    private boolean n;

    private void a(String str) {
    }

    private void c(boolean z) throws JSONException {
        Cif cifA = q8.a().a(this.b, this.c, z);
        if (cifA != null) {
            a(cifA, this.n);
        } else {
            c();
            this.e.d(this.c.O0());
        }
    }

    private boolean k() {
        return r1.d().c().A();
    }

    public li(Context context, ed edVar, VideoOption videoOption, dj.a aVar, f5 f5Var) {
        super(context, edVar, videoOption, aVar, f5Var);
    }

    @Override // com.qq.e.comm.plugin.xq, com.qq.e.comm.plugin.dj
    public void a(boolean z) {
        d();
        this.m = k();
        this.n = z;
    }

    private boolean m() throws JSONException {
        boolean zL = l();
        if (zL != this.m) {
            c(false);
            a("渲染方向改变，使用兜底渲染");
            return true;
        }
        if (this.c.p0() == null) {
            c(true);
            a("Native DSL无效，使用兜底渲染");
            return true;
        }
        if (this.c.p0().p() == 0) {
            return false;
        }
        boolean z = zL != this.c.p0().B();
        if (z) {
            c(false);
            a("渲染方向与模板方向不一致，使用兜底渲染");
        }
        return z;
    }

    protected boolean l() {
        return this.c.L1() > this.c.J1();
    }

    @Override // com.qq.e.comm.plugin.xq, com.qq.e.comm.plugin.dj
    public void a(Activity activity) throws JSONException {
        super.a(activity);
        if (m()) {
            return;
        }
        b(this.n);
    }
}
