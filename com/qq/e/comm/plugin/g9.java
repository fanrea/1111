package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g9 extends e0 {
    public static void a(Activity activity, h4 h4Var, rs rsVar) {
        try {
            new g9(activity, h4Var, rsVar).show();
        } catch (Throwable unused) {
            rsVar.a(false);
        }
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void b() {
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void c() {
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void d() {
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void e() {
    }

    public g9(Context context, h4 h4Var, rs rsVar) {
        super(context, h4Var, rsVar);
        f9 f9VarC = q8.a().c(this.a, this.b);
        this.e = f9VarC;
        if (f9VarC != null) {
            this.f = f9VarC.l();
            this.g = f5.a(h4Var, this.e.h());
        }
    }
}
