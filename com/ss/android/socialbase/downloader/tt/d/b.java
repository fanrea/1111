package com.ss.android.socialbase.downloader.tt.d;

import com.ss.android.socialbase.downloader.h.u;
import com.ss.android.socialbase.downloader.tt.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements h {
    private static final ArrayList<String> u;
    protected List<u> b;
    protected final String d;
    private long gb;
    private int h;
    protected final long hc;
    private h mk;
    private boolean tc;
    private boolean tt;
    private Map<String, String> an = null;
    protected final Object c = new Object();

    public boolean d(int i) {
        return i >= 200 && i < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        u = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public b(String str, List<u> list, long j) {
        this.d = str;
        this.b = list;
        this.hc = j;
    }

    public void d() throws Exception {
        if (this.an != null) {
            return;
        }
        try {
            this.tc = true;
            this.mk = com.ss.android.socialbase.downloader.downloader.b.d(this.d, this.b);
            synchronized (this.c) {
                if (this.mk != null) {
                    HashMap map = new HashMap();
                    this.an = map;
                    d(this.mk, map);
                    this.h = this.mk.hc();
                    this.gb = System.currentTimeMillis();
                    this.tt = d(this.h);
                }
                this.tc = false;
                this.c.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.c) {
                if (this.mk != null) {
                    HashMap map2 = new HashMap();
                    this.an = map2;
                    d(this.mk, map2);
                    this.h = this.mk.hc();
                    this.gb = System.currentTimeMillis();
                    this.tt = d(this.h);
                }
                this.tc = false;
                this.c.notifyAll();
                throw th;
            }
        }
    }

    private void d(h hVar, Map<String, String> map) {
        if (hVar == null || map == null) {
            return;
        }
        Iterator<String> it = u.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, hVar.d(next));
        }
    }

    public void c() throws InterruptedException {
        synchronized (this.c) {
            if (this.tc && this.an == null) {
                this.c.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public String d(String str) {
        Map<String, String> map = this.an;
        if (map != null) {
            return map.get(str);
        }
        h hVar = this.mk;
        if (hVar != null) {
            return hVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public int hc() throws IOException {
        return this.h;
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public void b() {
        h hVar = this.mk;
        if (hVar != null) {
            hVar.b();
        }
    }

    public boolean u() {
        return this.tt;
    }

    public boolean an() {
        return System.currentTimeMillis() - this.gb < hc.hc;
    }

    public boolean h() {
        return this.tc;
    }

    public List<u> gb() {
        return this.b;
    }

    public Map<String, String> tt() {
        return this.an;
    }
}
