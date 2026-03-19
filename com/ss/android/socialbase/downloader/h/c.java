package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.he;
import com.ss.android.socialbase.downloader.c.k;
import com.ss.android.socialbase.downloader.c.rf;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.c.yi;
import com.ss.android.socialbase.downloader.c.zw;
import com.ss.android.socialbase.downloader.downloader.jh;
import com.ss.android.socialbase.downloader.downloader.tc;
import com.ss.android.socialbase.downloader.downloader.tt;
import com.ss.android.socialbase.downloader.h.b;
import com.ss.android.socialbase.downloader.hc.gb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private final SparseArray<vv> an;
    private tc b;
    private final Map<gb, vv> c;
    private jh cb;
    private b d;
    private boolean de;
    private rf e;
    private final SparseArray<vv> gb;
    private final SparseArray<vv> h;
    private tt hc;
    private final List<k> jh;
    private yi k;
    private e mk;
    private zw mq;
    private sy rf;
    private int sy;
    private he tc;
    private s tt;
    private final SparseArray<gb> u;
    private b.d uo;
    private ba w;
    private boolean yo;

    public b d() {
        return this.d;
    }

    public c() {
        this.c = new ConcurrentHashMap();
        this.u = new SparseArray<>();
        this.yo = false;
        this.jh = new ArrayList();
        this.de = true;
        this.uo = new b.d();
        this.an = new SparseArray<>();
        this.h = new SparseArray<>();
        this.gb = new SparseArray<>();
    }

    public c(b bVar) {
        this();
        this.d = bVar;
    }

    public boolean hc() {
        return this.yo;
    }

    public void d(boolean z) {
        this.yo = z;
    }

    public he b() {
        return this.tc;
    }

    public e c() {
        return this.mk;
    }

    public zw u() {
        return this.mq;
    }

    public tc an() {
        return this.b;
    }

    public jh h() {
        return this.cb;
    }

    public yi gb() {
        return this.k;
    }

    public rf tt() {
        return this.e;
    }

    public s tc() {
        return this.tt;
    }

    public ba mk() {
        return this.w;
    }

    public int mq() {
        return this.sy;
    }

    public boolean uo() {
        return this.de;
    }

    public sy k() {
        return this.rf;
    }

    public boolean e() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.tj();
        }
        return false;
    }

    public c d(tc tcVar) {
        this.b = tcVar;
        return this;
    }

    public c d(tt ttVar) {
        this.hc = ttVar;
        return this;
    }

    public c d(jh jhVar) {
        this.cb = jhVar;
        return this;
    }

    public c d(vv vvVar) {
        return vvVar == null ? this : d(vvVar.hashCode(), vvVar);
    }

    public c d(int i, vv vvVar) {
        if (vvVar != null) {
            synchronized (this.an) {
                this.an.put(i, vvVar);
            }
            this.c.put(gb.MAIN, vvVar);
            synchronized (this.u) {
                this.u.put(i, gb.MAIN);
            }
        }
        return this;
    }

    public c hc(int i, vv vvVar) {
        if (vvVar != null) {
            synchronized (this.h) {
                this.h.put(i, vvVar);
            }
            this.c.put(gb.SUB, vvVar);
            synchronized (this.u) {
                this.u.put(i, gb.SUB);
            }
        }
        return this;
    }

    public c hc(vv vvVar) {
        return vvVar == null ? this : b(vvVar.hashCode(), vvVar);
    }

    public c b(int i, vv vvVar) {
        if (vvVar != null) {
            synchronized (this.gb) {
                this.gb.put(i, vvVar);
            }
            this.c.put(gb.NOTIFICATION, vvVar);
            synchronized (this.u) {
                this.u.put(i, gb.NOTIFICATION);
            }
        }
        return this;
    }

    public c d(s sVar) {
        this.tt = sVar;
        return this;
    }

    public c d(he heVar) {
        this.tc = heVar;
        return this;
    }

    public c d(e eVar) {
        this.mk = eVar;
        return this;
    }

    public c d(zw zwVar) {
        this.mq = zwVar;
        return this;
    }

    public c d(ba baVar) {
        this.w = baVar;
        return this;
    }

    public c d(yi yiVar) {
        this.k = yiVar;
        return this;
    }

    public c d(rf rfVar) {
        this.e = rfVar;
        return this;
    }

    public c d(String str) {
        this.uo.d(str);
        return this;
    }

    public c hc(String str) {
        this.uo.hc(str);
        return this;
    }

    public c b(String str) {
        this.uo.b(str);
        return this;
    }

    public c c(String str) {
        this.uo.u(str);
        return this;
    }

    public c u(String str) {
        this.uo.an(str);
        return this;
    }

    public c hc(boolean z) {
        this.uo.d(z);
        return this;
    }

    public c d(List<u> list) {
        this.uo.d(list);
        return this;
    }

    public c d(int i) {
        this.uo.d(i);
        return this;
    }

    public c hc(int i) {
        this.uo.hc(i);
        return this;
    }

    public c b(boolean z) {
        this.uo.hc(z);
        return this;
    }

    public c b(int i) {
        this.uo.b(i);
        return this;
    }

    public c c(int i) {
        this.uo.c(i);
        return this;
    }

    public c hc(List<String> list) {
        this.uo.hc(list);
        return this;
    }

    public c an(String str) {
        this.uo.h(str);
        return this;
    }

    public c c(boolean z) {
        this.uo.c(z);
        return this;
    }

    public c u(boolean z) {
        this.uo.b(z);
        return this;
    }

    public c an(boolean z) {
        this.uo.u(z);
        return this;
    }

    public c h(boolean z) {
        this.uo.an(z);
        return this;
    }

    public c h(String str) {
        this.uo.gb(str);
        return this;
    }

    public c gb(String str) {
        this.uo.tt(str);
        return this;
    }

    public c d(long j) {
        this.uo.d(j);
        return this;
    }

    public c gb(boolean z) {
        this.uo.tt(z);
        return this;
    }

    public c tt(String str) {
        this.uo.tc(str);
        return this;
    }

    public c tt(boolean z) {
        this.uo.h(z);
        return this;
    }

    public c tc(boolean z) {
        this.uo.tc(z);
        return this;
    }

    public c mk(boolean z) {
        this.uo.uo(z);
        return this;
    }

    public c mq(boolean z) {
        this.uo.gb(z);
        return this;
    }

    public c uo(boolean z) {
        this.uo.mk(z);
        return this;
    }

    public c d(com.ss.android.socialbase.downloader.hc.h hVar) {
        this.uo.d(hVar);
        return this;
    }

    public c k(boolean z) {
        this.uo.mq(z);
        return this;
    }

    public c d(sy syVar) {
        this.rf = syVar;
        return this;
    }

    public c d(JSONObject jSONObject) {
        this.uo.d(jSONObject);
        return this;
    }

    public c tc(String str) {
        this.uo.mq(str);
        return this;
    }

    public c mk(String str) {
        this.uo.c(str);
        return this;
    }

    public c u(int i) {
        this.uo.u(i);
        return this;
    }

    public c hc(long j) {
        this.uo.hc(j);
        return this;
    }

    public c e(boolean z) {
        this.uo.k(z);
        return this;
    }

    public c mq(String str) {
        this.uo.mk(str);
        return this;
    }

    public c d(int[] iArr) {
        this.uo.d(iArr);
        return this;
    }

    public c cb(boolean z) {
        this.uo.e(z);
        return this;
    }

    public c w(boolean z) {
        this.uo.cb(z);
        return this;
    }

    public int cb() {
        this.d = this.uo.d();
        b bVarHc = com.ss.android.socialbase.downloader.downloader.b.np().hc(this.d.h());
        if (bVarHc == null) {
            this.d.el();
            com.ss.android.socialbase.downloader.gb.d.d(this, (com.ss.android.socialbase.downloader.u.d) null, 0);
        } else {
            this.d.d(bVarHc);
        }
        de();
        com.ss.android.socialbase.downloader.downloader.c.d().d(this);
        b bVar = this.d;
        if (bVar == null) {
            return 0;
        }
        return bVar.h();
    }

    public int w() {
        b bVar = this.d;
        if (bVar == null) {
            return 0;
        }
        return bVar.h();
    }

    public void yo() {
        com.ss.android.socialbase.downloader.an.d.hc("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        b bVar = this.d;
        if (bVar != null && !bVar.um()) {
            this.d.d(true);
        }
        c(gb.MAIN);
        c(gb.SUB);
        com.ss.android.socialbase.downloader.gb.d.d(this.mq, this.d, new com.ss.android.socialbase.downloader.u.d(1003, "has another same task, add Listener to old task"), 0);
    }

    private void c(gb gbVar) {
        SparseArray<vv> sparseArrayD = d(gbVar);
        synchronized (sparseArrayD) {
            for (int i = 0; i < sparseArrayD.size(); i++) {
                vv vvVar = sparseArrayD.get(sparseArrayD.keyAt(i));
                if (vvVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.d().hc(w(), vvVar, gbVar, false);
                }
            }
        }
    }

    public SparseArray<vv> d(gb gbVar) {
        if (gbVar == gb.MAIN) {
            return this.an;
        }
        if (gbVar == gb.SUB) {
            return this.h;
        }
        if (gbVar == gb.NOTIFICATION) {
            return this.gb;
        }
        return null;
    }

    public int hc(gb gbVar) {
        int size;
        SparseArray<vv> sparseArrayD = d(gbVar);
        if (sparseArrayD == null) {
            return 0;
        }
        synchronized (sparseArrayD) {
            size = sparseArrayD.size();
        }
        return size;
    }

    public vv d(gb gbVar, int i) {
        SparseArray<vv> sparseArrayD = d(gbVar);
        if (sparseArrayD == null || i < 0) {
            return null;
        }
        synchronized (sparseArrayD) {
            if (i >= sparseArrayD.size()) {
                return null;
            }
            return sparseArrayD.get(sparseArrayD.keyAt(i));
        }
    }

    public synchronized int rf() {
        vv vvVarB = b(gb.MAIN);
        if (vvVarB == null) {
            vvVarB = b(gb.SUB);
        }
        if (vvVarB != null) {
            this.sy = vvVarB.hashCode();
        }
        return this.sy;
    }

    public vv b(gb gbVar) {
        return this.c.get(gbVar);
    }

    public void d(int i, vv vvVar, gb gbVar, boolean z) {
        int iIndexOfValue;
        SparseArray<vv> sparseArrayD = d(gbVar);
        if (sparseArrayD == null) {
            if (z && this.c.containsKey(gbVar)) {
                this.c.remove(gbVar);
                return;
            }
            return;
        }
        synchronized (sparseArrayD) {
            if (z) {
                if (this.c.containsKey(gbVar)) {
                    vvVar = this.c.get(gbVar);
                    this.c.remove(gbVar);
                }
                if (vvVar != null && (iIndexOfValue = sparseArrayD.indexOfValue(vvVar)) >= 0 && iIndexOfValue < sparseArrayD.size()) {
                    sparseArrayD.removeAt(iIndexOfValue);
                }
            } else {
                sparseArrayD.remove(i);
                synchronized (this.u) {
                    gb gbVar2 = this.u.get(i);
                    if (gbVar2 != null && this.c.containsKey(gbVar2)) {
                        this.c.remove(gbVar2);
                        this.u.remove(i);
                    }
                }
            }
        }
    }

    public void hc(int i, vv vvVar, gb gbVar, boolean z) {
        Map<gb, vv> map;
        if (vvVar == null) {
            return;
        }
        if (z && (map = this.c) != null) {
            map.put(gbVar, vvVar);
            synchronized (this.u) {
                this.u.put(i, gbVar);
            }
        }
        SparseArray<vv> sparseArrayD = d(gbVar);
        if (sparseArrayD == null) {
            return;
        }
        synchronized (sparseArrayD) {
            sparseArrayD.put(i, vvVar);
        }
    }

    private void d(SparseArray<vv> sparseArray, SparseArray<vv> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int iKeyAt = sparseArray2.keyAt(i);
            vv vvVar = sparseArray2.get(iKeyAt);
            if (vvVar != null) {
                sparseArray.put(iKeyAt, vvVar);
            }
        }
    }

    public void d(SparseArray<vv> sparseArray, gb gbVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (gbVar == gb.MAIN) {
                synchronized (this.an) {
                    d(this.an, sparseArray);
                }
                return;
            } else if (gbVar == gb.SUB) {
                synchronized (this.h) {
                    d(this.h, sparseArray);
                }
                return;
            } else {
                if (gbVar == gb.NOTIFICATION) {
                    synchronized (this.gb) {
                        d(this.gb, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        mq.d(th);
    }

    public void hc(s sVar) {
        this.tt = sVar;
    }

    public tt jh() {
        return this.hc;
    }

    public void d(c cVar) {
        for (Map.Entry<gb, vv> entry : cVar.c.entrySet()) {
            if (entry != null && !this.c.containsKey(entry.getKey())) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (cVar.an.size() != 0) {
                synchronized (this.an) {
                    b(this.an, cVar.an);
                    hc(cVar.an, this.an);
                }
            }
            if (cVar.h.size() != 0) {
                synchronized (this.h) {
                    b(this.h, cVar.h);
                    hc(cVar.h, this.h);
                }
            }
            if (cVar.gb.size() != 0) {
                synchronized (this.gb) {
                    b(this.gb, cVar.gb);
                    hc(cVar.gb, this.gb);
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void hc(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            sparseArray2.put(iKeyAt, sparseArray.get(iKeyAt));
        }
    }

    private void b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    public List<k> sy() {
        return this.jh;
    }

    public k an(int i) {
        synchronized (this.jh) {
            if (i >= this.jh.size()) {
                return null;
            }
            return this.jh.get(i);
        }
    }

    public c d(k kVar) {
        synchronized (this.jh) {
            if (kVar != null) {
                if (!this.jh.contains(kVar)) {
                    this.jh.add(kVar);
                    return this;
                }
            }
            return this;
        }
    }

    public c b(List<k> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
        return this;
    }

    private void de() {
        if (this.d.ii() > 0) {
            d(new tc() { // from class: com.ss.android.socialbase.downloader.h.c.1
                @Override // com.ss.android.socialbase.downloader.downloader.tc
                public int d(long j) {
                    return 1;
                }
            });
        }
    }
}
