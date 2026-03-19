package com.component.a.b;

import com.component.a.b.a;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements a.b {
    final /* synthetic */ e a;
    final /* synthetic */ f b;

    g(f fVar, e eVar) {
        this.b = fVar;
        this.a = eVar;
    }

    @Override // com.component.a.b.a.b
    public com.component.a.f a() {
        return this.b.c.a();
    }

    @Override // com.component.a.b.a.b
    public void a(j jVar) {
        this.b.a(jVar);
    }

    @Override // com.component.a.b.a.b
    public void a(j jVar, String str) {
        this.b.a(jVar, str);
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        if (!this.b.b.isEmpty()) {
            Iterator it = this.b.b.values().iterator();
            while (it.hasNext()) {
                if (((e) it.next()).a(str)) {
                    return true;
                }
            }
        }
        return this.a != null && this.a.a(str);
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if (!this.b.b.isEmpty()) {
            for (e eVar : this.b.b.values()) {
                if (eVar.a(str)) {
                    return eVar.b(str);
                }
            }
        }
        if (this.a != null && this.a.a(str)) {
            return this.a.b(str);
        }
        return null;
    }
}
