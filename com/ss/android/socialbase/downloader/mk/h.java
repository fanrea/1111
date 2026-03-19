package com.ss.android.socialbase.downloader.mk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class h {
    private final com.ss.android.socialbase.downloader.k.an an;
    private final com.ss.android.socialbase.downloader.h.b b;
    private final boolean cb;
    private final long e;
    private com.ss.android.socialbase.downloader.u.d gb;
    private final b h;
    private final long k;
    private final com.ss.android.socialbase.downloader.uo.d u;
    private final boolean uo;
    private long w;
    private final List<mq> d = new LinkedList();
    private final List<mq> hc = new ArrayList();
    private volatile boolean tt = false;
    private volatile boolean tc = false;
    private volatile boolean mk = false;
    private volatile long yo = 0;
    private volatile long rf = 0;
    private final com.ss.android.socialbase.downloader.downloader.mq c = com.ss.android.socialbase.downloader.downloader.b.np();
    private final com.ss.android.socialbase.downloader.d.d mq = com.ss.android.socialbase.downloader.d.d.d();

    private boolean d(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    h(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.k.an anVar, b bVar2) {
        this.b = bVar;
        this.an = anVar;
        this.h = bVar2;
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
        this.u = dVarD;
        boolean z = dVarD.d("sync_strategy", 0) == 1;
        this.uo = z;
        if (z) {
            long jD = dVarD.d("sync_interval_ms_fg", 5000);
            long jD2 = dVarD.d("sync_interval_ms_bg", 1000);
            this.k = Math.max(jD, 500L);
            this.e = Math.max(jD2, 500L);
        } else {
            this.k = 0L;
            this.e = 0L;
        }
        this.cb = dVarD.hc("monitor_rw") == 1;
    }

    void d(mq mqVar) {
        synchronized (this) {
            this.d.add(mqVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bc, code lost:
    
        if (r13 <= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bf, code lost:
    
        r3.hc(r13);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f2 A[Catch: all -> 0x03ac, TryCatch #7 {all -> 0x03ac, blocks: (B:156:0x01ee, B:158:0x01f2, B:161:0x01f8, B:163:0x01fe, B:164:0x0201, B:165:0x0210, B:200:0x028b, B:201:0x028d, B:237:0x030a, B:239:0x0314, B:241:0x0318, B:276:0x0391, B:278:0x0397, B:279:0x039a, B:280:0x03ab), top: B:334:0x0027, inners: #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fe A[Catch: all -> 0x03ac, TryCatch #7 {all -> 0x03ac, blocks: (B:156:0x01ee, B:158:0x01f2, B:161:0x01f8, B:163:0x01fe, B:164:0x0201, B:165:0x0210, B:200:0x028b, B:201:0x028d, B:237:0x030a, B:239:0x0314, B:241:0x0318, B:276:0x0391, B:278:0x0397, B:279:0x039a, B:280:0x03ab), top: B:334:0x0027, inners: #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0314 A[Catch: all -> 0x03ac, TryCatch #7 {all -> 0x03ac, blocks: (B:156:0x01ee, B:158:0x01f2, B:161:0x01f8, B:163:0x01fe, B:164:0x0201, B:165:0x0210, B:200:0x028b, B:201:0x028d, B:237:0x030a, B:239:0x0314, B:241:0x0318, B:276:0x0391, B:278:0x0397, B:279:0x039a, B:280:0x03ab), top: B:334:0x0027, inners: #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0397 A[Catch: all -> 0x03ac, TryCatch #7 {all -> 0x03ac, blocks: (B:156:0x01ee, B:158:0x01f2, B:161:0x01f8, B:163:0x01fe, B:164:0x0201, B:165:0x0210, B:200:0x028b, B:201:0x028d, B:237:0x030a, B:239:0x0314, B:241:0x0318, B:276:0x0391, B:278:0x0397, B:279:0x039a, B:280:0x03ab), top: B:334:0x0027, inners: #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x03e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x03c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x02b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x033e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d(com.ss.android.socialbase.downloader.mk.c r31) throws com.ss.android.socialbase.downloader.u.d {
        /*
            Method dump skipped, instructions count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.mk.h.d(com.ss.android.socialbase.downloader.mk.c):void");
    }

    private void d(long j, boolean z) throws IOException {
        long j2 = j - this.rf;
        if (this.uo) {
            if (j2 <= (this.mq.hc() ? this.k : this.e)) {
                return;
            }
        } else {
            long jJs = this.b.js() - this.yo;
            if (!z && !d(jJs, j2)) {
                return;
            }
        }
        b();
        this.rf = j;
    }

    private void d(u uVar) {
        synchronized (this) {
            this.hc.add((mq) uVar);
        }
    }

    private void b() throws IOException {
        boolean z = this.cb;
        long jNanoTime = z ? System.nanoTime() : 0L;
        com.ss.android.socialbase.downloader.h.b bVar = this.b;
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.c;
        List<mq> list = this.d;
        List<mq> list2 = this.hc;
        Map<Long, tt> mapMq = mqVar.mq(bVar.h());
        if (mapMq == null) {
            mapMq = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            d(list);
            try {
                hc(list);
                z2 = true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
            d(list, mapMq);
            if (list2.size() > 0) {
                b(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            bVar.h(true);
            mqVar.d(bVar.h(), mapMq);
            mqVar.d(bVar);
            this.yo = bVar.js();
        }
        if (z) {
            this.w += System.nanoTime() - jNanoTime;
        }
    }

    private void d(List<mq> list) throws IOException {
        Iterator<mq> it = list.iterator();
        while (it.hasNext()) {
            it.next().hc();
        }
    }

    private void hc(List<mq> list) throws IOException {
        Iterator<mq> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void b(List<mq> list) {
        Iterator<mq> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    private void d(List<mq> list, Map<Long, tt> map) {
        Iterator<mq> it = list.iterator();
        while (it.hasNext()) {
            tt ttVarU = it.next().u();
            tt ttVar = map.get(Long.valueOf(ttVarU.b()));
            if (ttVar == null) {
                map.put(Long.valueOf(ttVarU.b()), new tt(ttVarU));
            } else {
                ttVar.d(ttVarU.c());
                ttVar.b(ttVarU.an());
            }
        }
    }

    public void d() {
        this.mk = true;
        this.tt = true;
    }

    public void hc() {
        this.tc = true;
        this.tt = true;
    }
}
