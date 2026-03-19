package com.component.lottie.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h extends j<Integer> {
    @Override // com.component.lottie.h.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(b<Integer> bVar) {
        return Integer.valueOf(com.component.lottie.g.f.a(bVar.c().intValue(), bVar.d().intValue(), bVar.f()) + c(bVar).intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Integer c(b<Integer> bVar) {
        if (this.e == 0) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        return (Integer) this.e;
    }
}
