package com.ss.android.socialbase.downloader.mk;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.ss.android.socialbase.downloader.k.u;
import com.ss.android.socialbase.downloader.tt.b;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mk implements an, b.d {
    private final hc b;
    private final com.ss.android.socialbase.downloader.k.an c;
    private int cb;
    private final com.ss.android.socialbase.downloader.h.b d;
    private final k hc;
    private float he;
    private final com.ss.android.socialbase.downloader.e.u jh;
    private com.ss.android.socialbase.downloader.h.an mk;
    private long np;
    private final com.ss.android.socialbase.downloader.k.u sy;
    private com.ss.android.socialbase.downloader.h.an tc;
    private final h u;
    private long uo;
    private long v;
    private int vv;
    private com.ss.android.socialbase.downloader.u.d w;
    private long yi;
    private volatile boolean yo;
    private final boolean zw;
    private volatile boolean an = false;
    private volatile boolean h = false;
    private final List<uo> gb = new ArrayList();
    private final List<w> tt = new ArrayList();
    private volatile boolean mq = true;
    private final LinkedList<tt> k = new LinkedList<>();
    private final List<tt> e = new ArrayList();
    private final Object rf = new Object();
    private volatile boolean de = false;
    private final u.hc j = new u.hc() { // from class: com.ss.android.socialbase.downloader.mk.mk.1
        private int hc;

        @Override // com.ss.android.socialbase.downloader.k.u.hc
        public long d() {
            if (mk.this.an || mk.this.h) {
                return -1L;
            }
            synchronized (mk.this) {
                if (mk.this.tc == null && mk.this.mk == null) {
                    long j = mk.this.v;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.hc++;
                    uo uoVarD = mk.this.d(false, System.currentTimeMillis(), j);
                    if (uoVarD == null) {
                        return j;
                    }
                    com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    mk.this.b(uoVarD);
                    uoVarD.an();
                    return ((this.hc / mk.this.tt.size()) + 1) * j;
                }
                return -1L;
            }
        }
    };
    private final u.hc s = new u.hc() { // from class: com.ss.android.socialbase.downloader.mk.mk.2
        @Override // com.ss.android.socialbase.downloader.k.u.hc
        public long d() {
            return mk.this.yo();
        }
    };

    public mk(com.ss.android.socialbase.downloader.h.b bVar, k kVar, com.ss.android.socialbase.downloader.k.an anVar) {
        this.d = bVar;
        this.hc = kVar;
        hc hcVar = new hc(kVar.c(), kVar.u());
        this.b = hcVar;
        this.c = anVar;
        this.u = new h(bVar, anVar, hcVar);
        this.sy = new com.ss.android.socialbase.downloader.k.u();
        this.jh = new com.ss.android.socialbase.downloader.e.u();
        this.zw = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).hc("debug") == 1;
    }

    public boolean d(List<tt> list) throws com.ss.android.socialbase.downloader.u.d, InterruptedException {
        try {
            an();
            hc(list);
            u();
            h();
            tt();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                b();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.d.hc(jCurrentTimeMillis2);
                this.d.d(jCurrentTimeMillis2);
                if (!this.h && !this.an) {
                    this.c.d(this.uo);
                    gb();
                    c();
                    return true;
                }
                if (!this.h && !this.an) {
                    com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "finally pause");
                    hc();
                }
                this.sy.hc();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.d.hc(jCurrentTimeMillis3);
                this.d.d(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.h && !this.an) {
                com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "finally pause");
                hc();
            }
            this.sy.hc();
        }
    }

    private void hc(List<tt> list) {
        long jMb = this.d.mb();
        this.uo = jMb;
        if (jMb <= 0) {
            this.uo = this.d.ba();
            com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.uo);
        }
        synchronized (this) {
            this.k.clear();
            if (list == null || list.isEmpty()) {
                d((List<tt>) this.k, new tt(0L, -1L), false);
            } else {
                Iterator<tt> it = list.iterator();
                while (it.hasNext()) {
                    d((List<tt>) this.k, new tt(it.next()), false);
                }
                c(this.k);
                b(this.k);
            }
            com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "initSegments: totalLength = " + this.uo);
        }
    }

    private void b() throws com.ss.android.socialbase.downloader.u.d, InterruptedException {
        com.ss.android.socialbase.downloader.u.d dVar;
        synchronized (this.rf) {
            if (this.tc == null && this.mk == null) {
                this.rf.wait();
            }
        }
        if (this.tc == null && this.mk == null && (dVar = this.w) != null) {
            throw dVar;
        }
    }

    private void c() throws com.ss.android.socialbase.downloader.u.d {
        try {
            this.u.d((c) this.b);
        } catch (cb unused) {
        } catch (com.ss.android.socialbase.downloader.u.d e) {
            com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            d(e);
            throw e;
        }
        if (this.h || this.an) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.k.isEmpty()) {
                    tt ttVarPoll = this.k.poll();
                    if (ttVarPoll != null) {
                        d(this.e, ttVarPoll, true);
                    }
                }
                b(this.e);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        if (this.de && this.w != null) {
            com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.w);
            throw this.w;
        }
        if (this.d.js() != this.d.mb()) {
            com.ss.android.socialbase.downloader.gb.d.d(this.d, this.e);
        }
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void b(List<tt> list) {
        long jHc = e.hc(list);
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.d.js() + ", totalBytes = " + this.d.mb() + ", downloadedBytes = " + jHc);
        if (jHc > this.d.mb() && this.d.mb() > 0) {
            jHc = this.d.mb();
        }
        if (this.d.js() == this.d.mb() || this.d.js() == jHc) {
            return;
        }
        this.d.u(jHc);
    }

    private void u() {
        int iD;
        if (this.uo <= 0 || this.mq) {
            iD = 1;
        } else {
            iD = this.hc.d();
            int iGb = (int) (this.uo / this.hc.gb());
            if (iD > iGb) {
                iD = iGb;
            }
        }
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.uo + ", threadCount = " + iD);
        int i = iD > 0 ? iD : 1;
        synchronized (this) {
            while (this.gb.size() < i) {
                if (!this.h && !this.an) {
                    d(tc());
                    if (this.hc.an()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void an() {
        this.tt.add(new w(this.d.tc(), true));
        List<String> listUq = this.d.uq();
        if (listUq != null) {
            for (String str : listUq) {
                if (!TextUtils.isEmpty(str)) {
                    this.tt.add(new w(str, false));
                }
            }
        }
        this.hc.d(this.tt.size());
    }

    private void h() {
        k kVar = this.hc;
        this.v = kVar.tc();
        this.np = kVar.mk();
        this.he = kVar.e();
        int i = this.vv;
        if (i > 0) {
            this.sy.d(this.j, i);
        }
    }

    private void gb() {
        if (this.np > 0) {
            this.yi = System.currentTimeMillis();
            this.sy.d(this.s, 0L);
        }
    }

    private void tt() {
        List<String> listUq;
        int iMq = this.hc.mq();
        if (iMq <= 0) {
            this.mq = false;
            u();
            return;
        }
        com.ss.android.socialbase.downloader.tt.b bVarD = com.ss.android.socialbase.downloader.tt.b.d();
        bVarD.d(this.d.tc(), this, 2000L);
        if (iMq <= 2 || (listUq = this.d.uq()) == null) {
            return;
        }
        for (String str : listUq) {
            if (!TextUtils.isEmpty(str)) {
                bVarD.d(str, this, 2000L);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.tt.b.d
    public void d(String str, List<InetAddress> list) {
        if (this.h || this.an) {
            return;
        }
        List<w> listB = null;
        try {
            listB = b(str, list);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        synchronized (this) {
            if (listB != null) {
                hc(str, listB);
                this.mq = false;
                this.hc.d(this.tt.size());
                com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                u();
            } else {
                this.mq = false;
                this.hc.d(this.tt.size());
                com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                u();
            }
        }
    }

    private void hc(String str, List<w> list) {
        int iD;
        if (this.zw) {
            Iterator<w> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int iMq = this.hc.mq();
        if ((iMq == 1 || iMq == 3) && (iD = d(str)) >= 0 && iD < this.tt.size()) {
            this.tt.addAll(iD + 1, list);
        } else {
            this.tt.addAll(list);
        }
    }

    private int d(String str) {
        int size = this.tt.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.tt.get(i).d, str)) {
                return i;
            }
        }
        return -1;
    }

    private List<w> b(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.zw) {
                            com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        w wVar = new w(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(wVar.b);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(wVar.b, linkedList);
                        }
                        linkedList.add(wVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((w) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private w tc() {
        w wVar;
        synchronized (this) {
            int size = this.cb % this.tt.size();
            if (this.hc.hc()) {
                this.cb++;
            }
            wVar = this.tt.get(size);
        }
        return wVar;
    }

    private void d(List<tt> list, tt ttVar, boolean z) {
        long jB = ttVar.b();
        int size = list.size();
        int i = 0;
        while (i < size && jB >= list.get(i).b()) {
            i++;
        }
        list.add(i, ttVar);
        if (z) {
            ttVar.d(size);
        }
    }

    private void c(List<tt> list) {
        tt ttVar = list.get(0);
        long jB = ttVar.b();
        if (jB > 0) {
            tt ttVar2 = new tt(0L, jB - 1);
            com.bytedance.sdk.component.utils.mq.hc("SegmentDispatcher", "fixSegmentsLocked: first = " + ttVar + ", add new first = " + ttVar2);
            d(list, ttVar2, true);
        }
        Iterator<tt> it = list.iterator();
        if (it.hasNext()) {
            tt next = it.next();
            while (it.hasNext()) {
                tt next2 = it.next();
                if (next.an() < next2.b() - 1) {
                    com.ss.android.socialbase.downloader.an.d.c("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.b() - 1));
                    next.b(next2.b() - 1);
                }
                next = next2;
            }
        }
        tt ttVar3 = list.get(list.size() - 1);
        long jMb = this.d.mb();
        if (jMb <= 0 || (ttVar3.an() != -1 && ttVar3.an() < jMb - 1)) {
            com.ss.android.socialbase.downloader.an.d.c("SegmentDispatcher", "fixSegment: last segment = " + ttVar3 + ", new end=-1");
            ttVar3.b(-1L);
        }
    }

    private void d(w wVar) {
        uo uoVar = new uo(this.d, this, this.b, wVar, this.gb.size());
        this.gb.add(uoVar);
        uoVar.d(com.ss.android.socialbase.downloader.downloader.b.cb().submit(uoVar));
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void d(uo uoVar) {
        if (this.zw) {
            com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "onReaderRun, threadIndex = " + uoVar.b);
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public tt d(uo uoVar, w wVar) {
        if (this.an || this.h) {
            return null;
        }
        synchronized (this) {
            tt ttVarHc = hc(uoVar, wVar);
            if (ttVarHc != null) {
                ttVarHc.gb();
                if (ttVarHc.tc() > 1) {
                    return new tt(ttVarHc);
                }
            }
            return ttVarHc;
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void d(uo uoVar, tt ttVar) {
        synchronized (this) {
            ttVar.tt();
        }
    }

    private tt hc(uo uoVar, w wVar) {
        while (!this.k.isEmpty()) {
            tt ttVarPoll = this.k.poll();
            if (ttVarPoll != null) {
                d(this.e, ttVarPoll, true);
                if (d(ttVarPoll) > 0 || this.uo <= 0) {
                    return ttVarPoll;
                }
            }
        }
        uo();
        tt ttVarB = b(uoVar, wVar);
        if (ttVarB != null && d(ttVarB) > 0) {
            d(this.e, ttVarB, true);
            return ttVarB;
        }
        tt ttVarCb = cb();
        if (ttVarCb != null) {
            return ttVarCb;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void d(uo uoVar, tt ttVar, w wVar, com.ss.android.socialbase.downloader.h.an anVar) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        synchronized (this) {
            if (this.an || this.h) {
                throw new cb("connected");
            }
            hc(uoVar, ttVar, wVar, anVar);
            uoVar.hc(false);
            if (this.uo <= 0) {
                long jMb = this.d.mb();
                this.uo = jMb;
                if (jMb <= 0) {
                    this.uo = anVar.tc();
                }
                u();
            } else if (this.hc.an()) {
                u();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void hc(uo uoVar, tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        synchronized (this) {
            u(uoVar, ttVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void b(uo uoVar, tt ttVar) {
        synchronized (this) {
            if (ttVar.d == uoVar) {
                com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(ttVar)));
                ttVar.c(uoVar.c());
                ttVar.d = null;
                uoVar.d();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public u c(uo uoVar, tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        u uVarD;
        synchronized (this) {
            mq mqVar = new mq(this.d, this.b, ttVar);
            this.u.d(mqVar);
            uVarD = mqVar.d();
        }
        return uVarD;
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void d(uo uoVar, w wVar, tt ttVar, com.ss.android.socialbase.downloader.u.d dVar, int i, int i2) {
        boolean zHc = com.ss.android.socialbase.downloader.e.an.hc(dVar);
        int iD = dVar.d();
        if (iD == 1047 || iD == 1074 || iD == 1055) {
            zHc = true;
        }
        if (zHc || i >= i2) {
            b(uoVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void d(uo uoVar, w wVar, tt ttVar, com.ss.android.socialbase.downloader.u.d dVar) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", "onSegmentFailed: segment = " + ttVar + ", e = " + dVar);
            uoVar.hc(true);
            if (uoVar.b == 0) {
                this.w = dVar;
            }
            if (mq()) {
                if (this.w == null) {
                    this.w = dVar;
                }
                this.de = true;
                d(this.w);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.an
    public void hc(uo uoVar) {
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "onReaderExit: threadIndex = " + uoVar.b);
        synchronized (this) {
            uoVar.b(true);
            this.gb.remove(uoVar);
            uo();
            if (!this.gb.isEmpty()) {
                if (k()) {
                    com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    Iterator<uo> it = this.gb.iterator();
                    while (it.hasNext()) {
                        it.next().u();
                    }
                    mk();
                }
            } else {
                mk();
            }
        }
    }

    private void d(com.ss.android.socialbase.downloader.u.d dVar) {
        com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", "onError, e = ".concat(String.valueOf(dVar)));
        this.w = dVar;
        this.b.b();
        synchronized (this) {
            Iterator<uo> it = this.gb.iterator();
            while (it.hasNext()) {
                it.next().u();
            }
        }
    }

    private void mk() {
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "onComplete");
        this.b.b();
        synchronized (this.rf) {
            this.rf.notify();
        }
    }

    private boolean mq() {
        Iterator<uo> it = this.gb.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(uo uoVar) {
        synchronized (this) {
            w wVarC = c(uoVar);
            if (wVarC == null) {
                return false;
            }
            return uoVar.d(wVarC);
        }
    }

    private w c(uo uoVar) {
        w next;
        Iterator<w> it = this.tt.iterator();
        w wVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != uoVar.hc && !next.c()) {
                if (wVar == null) {
                    wVar = next;
                }
                if (next.d() <= 0) {
                    break;
                }
            }
        }
        if (this.hc.hc()) {
            if (next != null) {
                return next;
            }
            if (this.hc.b()) {
                return null;
            }
        }
        return wVar;
    }

    private void hc(uo uoVar, tt ttVar, w wVar, com.ss.android.socialbase.downloader.h.an anVar) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        uo uoVar2 = ttVar.d;
        if (uoVar2 != null && uoVar2 != uoVar) {
            throw new tc(1, "segment already has an owner");
        }
        if (uoVar.gb() != ttVar.u()) {
            throw new tc(5, "applySegment");
        }
        if (!anVar.hc()) {
            if (ttVar.u() > 0) {
                throw new com.ss.android.socialbase.downloader.u.b(1004, anVar.b, "1: response code error : " + anVar.b + " segment=" + ttVar);
            }
            com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + ttVar.u());
            if (!anVar.d()) {
                throw new com.ss.android.socialbase.downloader.u.b(1004, anVar.b, "2: response code error : " + anVar.b + " segment=" + ttVar);
            }
        }
        if (wVar.c) {
            if (this.tc == null) {
                this.tc = anVar;
                synchronized (this.rf) {
                    this.rf.notify();
                }
                com.ss.android.socialbase.downloader.k.an anVar2 = this.c;
                if (anVar2 != null) {
                    anVar2.d(wVar.d, anVar.hc, ttVar.u());
                }
                long jTc = anVar.tc();
                if (jTc > 0) {
                    for (tt ttVar2 : this.e) {
                        if (ttVar2.an() <= 0 || ttVar2.an() > jTc - 1) {
                            ttVar2.b(jTc - 1);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        d(anVar);
        if (this.mk == null) {
            this.mk = anVar;
            if (this.d.mb() <= 0) {
                long jTc2 = anVar.tc();
                com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jTc2 + ",url=" + wVar.d);
                this.d.h(jTc2);
            }
            synchronized (this.rf) {
                this.rf.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if ((r10.u() - r23.u()) < (r14 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u(com.ss.android.socialbase.downloader.mk.uo r22, com.ss.android.socialbase.downloader.mk.tt r23) throws com.ss.android.socialbase.downloader.mk.tc {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.mk.mk.u(com.ss.android.socialbase.downloader.mk.uo, com.ss.android.socialbase.downloader.mk.tt):void");
    }

    private void d(com.ss.android.socialbase.downloader.h.an anVar) throws com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.h.an anVar2 = this.tc;
        if (anVar2 == null && (anVar2 = this.mk) == null) {
            return;
        }
        long jTc = anVar.tc();
        long jTc2 = anVar2.tc();
        if (jTc != jTc2) {
            String str = "total len not equals,len=" + jTc + ",sLen=" + jTc2 + ",code=" + anVar.b + ",sCode=" + anVar2.b + ",range=" + anVar.u() + ",sRange = " + anVar2.u() + ",url = " + anVar.d + ",sUrl=" + anVar2.d;
            com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", str);
            if (jTc > 0 && jTc2 > 0) {
                throw new com.ss.android.socialbase.downloader.u.d(1074, str);
            }
        }
        String strB = anVar.b();
        String strB2 = anVar2.b();
        if (TextUtils.equals(strB, strB2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strB + ", mainEtag = " + strB2;
        com.ss.android.socialbase.downloader.an.d.u("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strB) && !TextUtils.isEmpty(strB2) && !strB.equalsIgnoreCase(strB2)) {
            throw new com.ss.android.socialbase.downloader.u.d(1074, str2);
        }
    }

    public void d() {
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "cancel");
        this.an = true;
        synchronized (this) {
            Iterator<uo> it = this.gb.iterator();
            while (it.hasNext()) {
                it.next().u();
            }
        }
        this.u.d();
        this.b.b();
    }

    public void hc() {
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "pause1");
        this.h = true;
        synchronized (this) {
            Iterator<uo> it = this.gb.iterator();
            while (it.hasNext()) {
                it.next().u();
            }
        }
        this.u.hc();
        this.b.b();
    }

    private int d(long j) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            tt ttVar = this.e.get(i);
            if (ttVar.b() == j) {
                return i;
            }
            if (ttVar.b() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void uo() {
        int size;
        if (this.uo > 0 && (size = this.e.size()) > 1) {
            ArrayList<tt> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                tt ttVar = this.e.get(i);
                tt ttVar2 = this.e.get(i2);
                if (ttVar.u() > ttVar2.b() && ttVar2.d() <= 0 && ttVar2.d == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(ttVar2);
                    if (this.zw) {
                        com.bytedance.sdk.component.utils.mq.hc("SegmentDispatcher", "clearCovered, covered = " + ttVar2 + ", prev = " + ttVar);
                    }
                } else if (ttVar2.u() > ttVar.u()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (tt ttVar3 : arrayList) {
                    this.e.remove(ttVar3);
                    for (uo uoVar : this.gb) {
                        if (uoVar.d == ttVar3) {
                            if (this.zw) {
                                com.bytedance.sdk.component.utils.mq.hc("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + ttVar3 + ", threadIndex = " + uoVar.b);
                            }
                            uoVar.d(true);
                        }
                    }
                }
            }
        }
    }

    private boolean k() {
        long j = this.uo;
        if (j <= 0) {
            this.yo = false;
            return false;
        }
        synchronized (this) {
            long jD = e.d(this.e);
            com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jD)));
            if (jD >= j) {
                this.yo = true;
                return true;
            }
            this.yo = false;
            return false;
        }
    }

    private tt b(uo uoVar, w wVar) {
        String str;
        int size = this.e.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jD = d(i2, size);
            if (jD > j) {
                i = i2;
                j = jD;
            }
        }
        long jH = this.hc.h();
        long jTt = this.hc.tt();
        if (i < 0 || j <= jH) {
            return null;
        }
        tt ttVar = this.e.get(i);
        int iK = this.e.size() < this.gb.size() ? 2 : this.hc.k();
        if (iK == 1) {
            uo uoVar2 = ttVar.d;
            if (uoVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - 4000;
                long jD2 = uoVar2.d(j2, jCurrentTimeMillis);
                long jD3 = uoVar.d(j2, jCurrentTimeMillis);
                float f = (jD2 <= 0 || jD3 <= 0) ? -1.0f : jD3 / (jD2 + jD3);
                if (f == -1.0f) {
                    long jHc = uoVar2.hc();
                    long jHc2 = uoVar.hc();
                    if (jHc > 0 && jHc2 > 0) {
                        f = jHc2 / (jHc + jHc2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < jH) {
                        j3 = jH;
                    }
                    if (jTt <= 0 || j3 <= jTt) {
                        jTt = j3;
                    }
                    long j4 = jH / 2;
                    long j5 = j - j4;
                    if (jTt > j5) {
                        jTt = j5;
                    } else if (jTt < j4) {
                        jTt = j4;
                    }
                    tt ttVar2 = new tt(ttVar.u() + (j - jTt), ttVar.an());
                    com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "obtainSegment: parent = " + ttVar + ", child = " + ttVar2 + ", maxRemainBytes = " + j + ", childLength = " + jTt + ", ratio = " + f2 + ", threadIndex = " + uoVar.b);
                    return ttVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iK == 2) {
                long jJs = this.uo - this.d.js();
                float fC = c(uoVar, wVar);
                long j6 = (long) (jJs * fC);
                if (j6 < jH) {
                    j6 = jH;
                }
                if (jTt <= 0 || j6 <= jTt) {
                    jTt = j6;
                }
                long j7 = jH / 2;
                long j8 = j - j7;
                if (jTt > j8) {
                    jTt = j8;
                } else if (jTt < j7) {
                    jTt = j7;
                }
                tt ttVar3 = new tt(ttVar.u() + (j - jTt), ttVar.an());
                com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "obtainSegment: parent = " + ttVar + ", child = " + ttVar3 + ", maxRemainBytes = " + j + ", childLength = " + jTt + ", ratio = " + fC + ", threadIndex = " + uoVar.b);
                return ttVar3;
            }
            str = "SegmentDispatcher";
        }
        tt ttVar4 = new tt(ttVar.u() + (j / 2), ttVar.an());
        com.ss.android.socialbase.downloader.an.d.b(str, "obtainSegment: parent = " + ttVar + ",child = " + ttVar4);
        return ttVar4;
    }

    private float c(uo uoVar, w wVar) {
        long jHc = uoVar.hc();
        int size = this.gb.size();
        if (size <= 1) {
            size = this.hc.d();
        }
        float f = 1.0f;
        if (jHc <= 0) {
            float fUo = this.hc.uo();
            if (fUo <= 0.0f || fUo >= 1.0f) {
                fUo = 1.0f / size;
            }
            if (uoVar.b == 0) {
                return fUo;
            }
            if (size > 1) {
                f = 1.0f - fUo;
                size--;
            }
        } else {
            long jE = e();
            if (jE > jHc) {
                return jHc / jE;
            }
        }
        return f / size;
    }

    private long e() {
        Iterator<uo> it = this.gb.iterator();
        long jHc = 0;
        while (it.hasNext()) {
            jHc += it.next().hc();
        }
        return jHc;
    }

    private tt cb() {
        int i = 0;
        while (true) {
            tt ttVarW = w();
            if (ttVarW == null) {
                return null;
            }
            uo uoVar = ttVarW.d;
            if (uoVar == null) {
                return ttVarW;
            }
            if (ttVarW.tc() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            hc(jCurrentTimeMillis);
            if (jCurrentTimeMillis - uoVar.an > 2000 && d(uoVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.zw) {
                    com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + ttVarW + ", owner.threadIndex = " + uoVar.b);
                }
                return ttVarW;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.zw) {
                    com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(ttVarW)));
                }
                return ttVarW;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private tt w() {
        int iTc;
        tt ttVar = null;
        int i = Integer.MAX_VALUE;
        for (tt ttVar2 : this.e) {
            if (d(ttVar2) > 0 && (iTc = ttVar2.tc()) < i) {
                ttVar = ttVar2;
                i = iTc;
            }
        }
        return ttVar;
    }

    private long d(int i, int i2) {
        tt ttVar = this.e.get(i);
        long jD = d(ttVar);
        int i3 = i + 1;
        tt ttVar2 = i3 < i2 ? this.e.get(i3) : null;
        if (ttVar2 == null) {
            return jD;
        }
        long jB = ttVar2.b() - ttVar.u();
        return jD == -1 ? jB : Math.min(jD, jB);
    }

    private long d(tt ttVar) {
        long jHc = ttVar.hc();
        if (jHc != -1) {
            return jHc;
        }
        long j = this.uo;
        return j > 0 ? j - ttVar.u() : jHc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uo d(boolean z, long j, long j2) {
        uo uoVar = null;
        for (uo uoVar2 : this.gb) {
            if (uoVar2.b != 0 || z) {
                if (uoVar2.c > 0 && uoVar2.u <= 0 && j - uoVar2.c > j2 && (uoVar == null || uoVar2.c < uoVar.c)) {
                    uoVar = uoVar2;
                }
            }
        }
        return uoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long yo() {
        if (this.an || this.h) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            hc(jCurrentTimeMillis);
            long jMk = this.hc.mk();
            if (jMk > 0) {
                long j = this.yi;
                if (j > 0 && jCurrentTimeMillis - j > jMk && d(jCurrentTimeMillis, jMk)) {
                    this.yi = jCurrentTimeMillis;
                    this.vv++;
                }
            }
        }
        return 2000L;
    }

    private void hc(long j) {
        this.jh.d(this.d.js(), j);
        Iterator<uo> it = this.gb.iterator();
        while (it.hasNext()) {
            it.next().hc(j);
        }
    }

    private boolean d(uo uoVar, long j, long j2, long j3, double d) {
        if (uoVar.an <= 0) {
            return false;
        }
        long jHc = this.jh.hc(j, j2);
        int size = this.gb.size();
        long j4 = size > 0 ? jHc / size : jHc;
        long jD = uoVar.d(j, j2);
        if (jD >= j3 && jD >= j4 * d) {
            return false;
        }
        com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + jHc + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + jD + ",threadIndex = " + uoVar.b);
        return true;
    }

    private boolean d(long j, long j2) {
        long j3 = j - j2;
        long jHc = this.jh.hc(j3, j);
        int size = this.gb.size();
        if (size > 0) {
            jHc /= size;
        }
        uo uoVarD = d(j3, j, (long) Math.max(10.0f, jHc * this.he), size / 2);
        if (uoVarD != null) {
            b(uoVarD);
            com.ss.android.socialbase.downloader.an.d.c("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + uoVarD.b);
            uoVarD.an();
            return true;
        }
        uo uoVarD2 = d(true, j, j2);
        if (uoVarD2 == null) {
            return false;
        }
        b(uoVarD2);
        com.ss.android.socialbase.downloader.an.d.c("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + uoVarD2.b);
        uoVarD2.an();
        return true;
    }

    private uo d(long j, long j2, long j3, int i) {
        long j4;
        long j5;
        long j6 = LocationRequestCompat.PASSIVE_INTERVAL;
        int i2 = 0;
        uo uoVar = null;
        for (uo uoVar2 : this.gb) {
            if (uoVar2.an > 0) {
                i2++;
                if (uoVar2.an < j) {
                    j4 = j6;
                    long jD = uoVar2.d(j, j2);
                    if (this.zw) {
                        com.bytedance.sdk.component.utils.mq.d("SegmentDispatcher", "findPoorReadThread: speed = " + jD + ", threadIndex = " + uoVar2.b);
                        j5 = 0;
                    } else {
                        j5 = 0;
                    }
                    if (jD >= j5 && jD < j4) {
                        j6 = jD;
                        uoVar = uoVar2;
                    }
                } else {
                    j4 = j6;
                }
                j6 = j4;
            }
        }
        long j7 = j6;
        if (uoVar == null || i2 < i || j7 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.an.d.b("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + uoVar.b);
        return uoVar;
    }
}
