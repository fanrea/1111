package com.component.lottie.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g extends j<Float> {
    public g() {
    }

    public g(Float f) {
        super(f);
    }

    @Override // com.component.lottie.h.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(b<Float> bVar) {
        return Float.valueOf(com.component.lottie.g.f.a(bVar.c().floatValue(), bVar.d().floatValue(), bVar.f()) + c(bVar).floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float c(b<Float> bVar) {
        if (this.e == 0) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        return (Float) this.e;
    }
}
