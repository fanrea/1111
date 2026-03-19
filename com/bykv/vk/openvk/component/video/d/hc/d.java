package com.bykv.vk.openvk.component.video.d.hc;

import com.bykv.vk.openvk.component.video.d.hc.mq;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class d implements mk {
    private static final AtomicLong uo = new AtomicLong();
    protected volatile List<tt.hc> an;
    protected volatile com.bykv.vk.openvk.component.video.d.hc.d.d d;
    protected volatile String gb;
    protected volatile String h;
    protected final com.bykv.vk.openvk.component.video.d.hc.hc.b hc;
    protected volatile mq tc;
    protected volatile tt tt;
    protected com.bykv.vk.openvk.component.video.d.hc.c.d u;
    protected final AtomicInteger b = new AtomicInteger();
    protected final AtomicLong c = new AtomicLong();
    protected volatile boolean mk = false;
    public final long mq = uo.incrementAndGet();
    private final AtomicInteger k = new AtomicInteger(0);
    private int e = -1;

    public d(com.bykv.vk.openvk.component.video.d.hc.d.d dVar, com.bykv.vk.openvk.component.video.d.hc.hc.b bVar) {
        this.d = dVar;
        this.hc = bVar;
    }

    public void d() {
        this.k.compareAndSet(0, 1);
    }

    public boolean hc() {
        return this.k.get() == 1;
    }

    protected void b() {
        this.k.compareAndSet(0, 2);
    }

    public boolean c() {
        return this.k.get() == 2;
    }

    protected void u() throws com.bykv.vk.openvk.component.video.d.hc.b.d {
        if (hc()) {
            throw new com.bykv.vk.openvk.component.video.d.hc.b.d();
        }
    }

    protected com.bykv.vk.openvk.component.video.d.hc.u.d d(mq.d dVar, int i, int i2, String str) throws IOException {
        com.bykv.vk.openvk.component.video.d.hc.u.hc hcVarHc = com.bykv.vk.openvk.component.video.d.hc.u.b.d().hc();
        com.bykv.vk.openvk.component.video.d.hc.u.u uVar = new com.bykv.vk.openvk.component.video.d.hc.u.u();
        HashMap map = new HashMap();
        uVar.hc = dVar.d;
        uVar.d = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            uVar.d = 4;
        }
        List<tt.hc> list = this.an;
        if (list != null && !list.isEmpty()) {
            for (tt.hc hcVar : list) {
                if (!"Range".equalsIgnoreCase(hcVar.d) && !"Connection".equalsIgnoreCase(hcVar.d) && !"Proxy-Connection".equalsIgnoreCase(hcVar.d) && !"Host".equalsIgnoreCase(hcVar.d)) {
                    map.put(hcVar.d, hcVar.hc);
                }
            }
        }
        String strD = com.bykv.vk.openvk.component.video.d.b.d.d(i, i2);
        if (strD != null) {
            map.put("Range", strD);
        }
        if (u.an) {
            map.put("Cache-Control", "no-cache");
        }
        c cVarB = c.b();
        an anVarD = an.d();
        boolean z = this.tt == null;
        b bVarD = z ? cVarB.d() : anVarD.hc();
        b bVarHc = z ? cVarB.hc() : anVarD.b();
        if (bVarD != null || bVarHc != null) {
            if (bVarD != null) {
                uVar.b = bVarD.d(dVar.hc);
            }
            if (bVarHc != null) {
                uVar.c = bVarHc.d(dVar.hc);
            }
        }
        uVar.u = map;
        if (this.mk) {
            this.mk = false;
            return null;
        }
        return hcVarHc.d(uVar);
    }

    protected int an() {
        if (this.tt != null) {
            return this.tt.b.d;
        }
        return this.d instanceof com.bykv.vk.openvk.component.video.d.hc.d.hc ? 1 : 0;
    }

    protected boolean h() {
        return an() == 1;
    }

    protected void d(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = u.h;
        int iAn = an();
        if (i3 == 1 || (i3 == 2 && iAn == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.e) {
                    return;
                }
                this.e = i4;
                com.bykv.vk.openvk.component.video.d.b.d.d(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.u != null) {
                            mq mqVar = d.this.tc;
                            int unused = d.this.e;
                        }
                    }
                });
            }
        }
    }
}
