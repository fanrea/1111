package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {
    public final List<MODEL> ccz = new ArrayList();
    protected final e ccA = new e();

    @Override // com.kwad.sdk.lib.b.d
    public final void a(f fVar) {
        this.ccA.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.d
    public final void b(f fVar) {
        this.ccA.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean isEmpty() {
        return this.ccz.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> KE() {
        return this.ccz;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> getItems() {
        ArrayList arrayList = new ArrayList(this.ccz.size());
        arrayList.addAll(this.ccz);
        return arrayList;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean remove(MODEL model) {
        boolean zRemove = this.ccz.remove(model);
        if (zRemove) {
            this.ccA.de(false);
        }
        return zRemove;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void aB(List<MODEL> list) {
        this.ccz.clear();
        this.ccz.addAll(list);
        this.ccA.de(true);
    }

    public int getCount() {
        return this.ccz.size();
    }
}
