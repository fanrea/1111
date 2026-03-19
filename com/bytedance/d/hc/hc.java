package com.bytedance.d.hc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private Map<b, List<d>> d = new HashMap();
    private Map<String, String> hc = new HashMap();
    private final List<Object> b = new CopyOnWriteArrayList();
    private final List<Object> c = new CopyOnWriteArrayList();
    private final List<Object> u = new CopyOnWriteArrayList();
    private final List<Object> an = new CopyOnWriteArrayList();
    private an h = null;

    public List<d> d(b bVar) {
        return this.d.get(bVar);
    }

    void d(Map<? extends String, ? extends String> map) {
        this.hc.putAll(map);
    }

    public Map<String, String> d() {
        return this.hc;
    }

    public List<Object> hc() {
        return this.c;
    }

    public List<Object> b() {
        return this.an;
    }

    void d(an anVar) {
        this.h = anVar;
    }

    public an c() {
        return this.h;
    }
}
