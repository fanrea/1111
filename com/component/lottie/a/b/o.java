package com.component.lottie.a.b;

import android.graphics.Path;
import com.component.lottie.a.a.w;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o extends a<com.component.lottie.d.b.n, Path> {
    private final com.component.lottie.d.b.n d;
    private final Path e;
    private List<w> f;

    public o(List<com.component.lottie.h.a<com.component.lottie.d.b.n>> list) {
        super(list);
        this.d = new com.component.lottie.d.b.n();
        this.e = new Path();
    }

    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Path a(com.component.lottie.h.a<com.component.lottie.d.b.n> aVar, float f) {
        this.d.a(aVar.a, aVar.b, f);
        com.component.lottie.d.b.n nVarA = this.d;
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                nVarA = this.f.get(size).a(nVarA);
            }
        }
        com.component.lottie.g.f.a(nVarA, this.e);
        return this.e;
    }

    public void a(List<w> list) {
        this.f = list;
    }
}
