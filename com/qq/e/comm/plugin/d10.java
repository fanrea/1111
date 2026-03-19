package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.w40;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d10 {
    private final w40 a;
    private final w40.f b;
    private ul c;

    public d10(w40 w40Var, w40.f fVar) {
        this.a = w40Var;
        this.b = fVar;
    }

    public void a(List<z8> list) {
        for (z8 z8Var : list) {
            int i = z8Var.a;
            if (i == 1 || i == 2 || i == 3) {
                if (this.c == null) {
                    this.c = new c50(this.a, this.b);
                }
                this.c.a(z8Var);
            }
        }
    }
}
