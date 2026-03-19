package com.component.a.b;

import android.text.TextUtils;
import com.component.a.a.b;
import com.component.a.b.a;
import com.component.a.b.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    private final e a;
    private final Map<String, e> b = new ConcurrentHashMap();
    private final b c = new b();
    private final a.b d;

    public f(e eVar) {
        this.a = eVar;
        this.d = new g(this, eVar);
    }

    public void a(com.component.a.f fVar) {
        this.c.a(fVar);
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.b.put(eVar.a(), eVar);
    }

    public void a(String str, e.a aVar) {
        if (this.a != null) {
            this.a.a(str, aVar);
        }
        Iterator<e> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, aVar);
        }
    }

    public void a(j jVar) {
        if (jVar == null || this.a == null) {
            return;
        }
        this.a.a(jVar);
    }

    public void a(j jVar, e eVar) {
        if (jVar == null || eVar == null) {
            return;
        }
        eVar.a(jVar);
    }

    public void a(j jVar, String str) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        a(jVar, this.b.get(str));
    }

    public void a(String str, List<a> list) {
        a(this.a, str, list);
    }

    public void a(e eVar, String str, List<a> list) {
        if (eVar == null || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        if (m.a.contains(str)) {
            for (a aVar : list) {
                if (!aVar.d.a("timer")) {
                    aVar.d.b("timer", Integer.valueOf(aVar.d.a(b.e.c, 0)));
                }
            }
        }
        eVar.a(str, new h(this, list));
    }

    public void a(String str, String str2, List<a> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || list == null || list.isEmpty()) {
            return;
        }
        a(this.b.get(str), str2, list);
    }
}
