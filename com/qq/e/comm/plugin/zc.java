package com.qq.e.comm.plugin;

import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zc extends h0 {
    private final r5 b;
    private final View c;

    public zc(r5 r5Var, View view) {
        this.b = r5Var;
        this.c = view;
    }

    @Override // com.qq.e.comm.plugin.h0, com.qq.e.comm.plugin.ij
    public String a(int i) {
        return (this.b == null || this.c == null) ? "" : super.a(i);
    }

    @Override // com.qq.e.comm.plugin.h0
    protected w2 b(int i) {
        h4 h4VarG = this.b.g();
        return new wc(h4VarG.y0(), new qu(this.c.getContext(), new oa(this.c.getContext(), new s40(this.c, h4VarG, this.b, i)))).a();
    }

    @Override // com.qq.e.comm.plugin.h0
    protected w2 a() {
        r5 r5Var = this.b;
        if (r5Var != null) {
            return r5Var.h();
        }
        return null;
    }
}
