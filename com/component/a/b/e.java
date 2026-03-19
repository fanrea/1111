package com.component.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class e implements n {
    private final String a;
    private final Map<String, List<a>> b = new ConcurrentHashMap();

    public interface a {
        void a(e eVar, j jVar, o oVar);
    }

    public e(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public boolean c(String str) {
        return this.b.containsKey(str);
    }

    public void a(j jVar) {
        a(jVar, (o) null);
    }

    public void a(j jVar, o oVar) {
        List<a> list;
        if (!this.b.containsKey(jVar.a()) || (list = this.b.get(jVar.a())) == null || list.isEmpty()) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(this, jVar, oVar);
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.e(th);
            }
        }
    }

    public void a(String str, a aVar) {
        if (!this.b.containsKey(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            this.b.put(str, arrayList);
        } else {
            List<a> list = this.b.get(str);
            if (list != null) {
                list.add(aVar);
            }
        }
    }

    public void b(String str, a aVar) {
        List<a> list;
        if (!this.b.containsKey(str) || (list = this.b.get(str)) == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }
}
