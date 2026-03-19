package com.component.a.g.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bn implements com.baidu.mobads.container.util.g.b {
    final /* synthetic */ com.component.a.f.e a;
    final /* synthetic */ bm b;

    bn(bm bmVar, com.component.a.f.e eVar) {
        this.b = bmVar;
        this.a = eVar;
    }

    @Override // com.baidu.mobads.container.util.g.b
    public void a(float f, float f2) {
        if (this.b.i != null && this.b.mFlyweight != null) {
            com.component.a.f.d dVar = new com.component.a.f.d(this.b.i, bm.h, this.a);
            dVar.a(this.b.i, f, f2);
            this.b.mFlyweight.b(dVar);
        }
    }

    @Override // com.baidu.mobads.container.util.g.b
    public void a(float f) {
    }
}
