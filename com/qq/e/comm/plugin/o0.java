package com.qq.e.comm.plugin;

import android.content.pm.ResolveInfo;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class o0 implements tj, rs {
    protected l6 a;
    protected qs b;
    private boolean c = false;

    protected String a(ResolveInfo resolveInfo) {
        return (String) pro.getobjresult(50, 0, this, resolveInfo);
    }

    @Override // com.qq.e.comm.plugin.rs
    public final void a(boolean z) {
        pro.getVresult(51, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.tj
    public final boolean a() {
        return pro.getZresult(52, 0, this);
    }

    @Override // com.qq.e.comm.plugin.oj
    public final boolean a(l6 l6Var) {
        return pro.getZresult(53, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public final boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(54, 0, this, l6Var, qsVar);
    }

    protected boolean a(String str, rs rsVar) {
        return pro.getZresult(55, 0, this, str, rsVar);
    }

    @Override // com.qq.e.comm.plugin.rs
    public final boolean a(JSONObject jSONObject) {
        return pro.getZresult(56, 0, this, jSONObject);
    }

    public void b(boolean z) {
        pro.getVresult(57, 0, this, Boolean.valueOf(z));
    }

    protected abstract boolean b();

    protected abstract boolean c();

    protected abstract boolean d();

    protected boolean e() {
        return pro.getZresult(58, 0, this);
    }

    public void onCancel() {
        pro.getVresult(59, 0, this);
    }

    o0() {
    }
}
