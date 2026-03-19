package com.component.a.b;

import com.component.a.b.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements a.b {
    private final j a;
    private final o b;
    private final a.b c;
    private final Map<String, String> d = new HashMap();
    private e e;

    i(j jVar, o oVar, a.b bVar) {
        this.a = jVar;
        this.b = oVar;
        this.c = bVar;
    }

    public j b() {
        return this.a;
    }

    public String c() {
        return this.a.a();
    }

    public String d() {
        return this.a.b();
    }

    i a(String str, String str2) {
        this.d.put(str, str2);
        return this;
    }

    i a(e eVar) {
        this.e = eVar;
        return this;
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        if (this.d.containsKey(str)) {
            str = this.d.get(str);
        }
        if (this.b != null && this.b.a(str)) {
            return true;
        }
        if (this.e == null || !this.e.a(str)) {
            return this.c.a(str);
        }
        return true;
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if (this.d.containsKey(str)) {
            str = this.d.get(str);
        }
        if (this.b != null && this.b.a(str)) {
            return this.b.b(str);
        }
        if (this.e != null && this.e.a(str)) {
            return this.e.b(str);
        }
        if (this.c.a(str)) {
            return this.c.b(str);
        }
        return null;
    }

    @Override // com.component.a.b.a.b
    public com.component.a.f a() {
        return this.c.a();
    }

    @Override // com.component.a.b.a.b
    public void a(j jVar) {
        this.c.a(jVar);
    }

    @Override // com.component.a.b.a.b
    public void a(j jVar, String str) {
        this.c.a(jVar, str);
    }
}
