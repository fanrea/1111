package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mk implements com.ss.android.socialbase.downloader.downloader.mq {
    private final SparseArray<com.ss.android.socialbase.downloader.h.b> d = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> hc = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.mk.tt>> b = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.hc hcVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean u() {
        return false;
    }

    public SparseArray<com.ss.android.socialbase.downloader.h.b> d() {
        return this.d;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> an() {
        return this.hc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b h(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.c(2);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized com.ss.android.socialbase.downloader.h.b hc(int i) {
        com.ss.android.socialbase.downloader.h.b bVar;
        try {
            bVar = this.d.get(i);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            bVar = null;
        }
        return bVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                com.ss.android.socialbase.downloader.h.b bVarValueAt = this.d.valueAt(i);
                if (str != null && str.equals(bVarValueAt.tc())) {
                    arrayList.add(bVarValueAt);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.d.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.d.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVar = this.d.get(this.d.keyAt(i));
            if (bVar != null && !TextUtils.isEmpty(bVar.hg()) && bVar.hg().equals(str) && com.ss.android.socialbase.downloader.hc.an.h(bVar.w())) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.d.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.d.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVar = this.d.get(this.d.keyAt(i));
            if (bVar != null && !TextUtils.isEmpty(bVar.hg()) && bVar.hg().equals(str) && bVar.w() == -3) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.d.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.d.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVar = this.d.get(this.d.keyAt(i));
            if (bVar != null && !TextUtils.isEmpty(bVar.hg()) && bVar.hg().equals(str) && com.ss.android.socialbase.downloader.hc.an.an(bVar.w())) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.b> hc() {
        if (this.d.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.d.size());
        for (int i = 0; i < this.d.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVarValueAt = this.d.valueAt(i);
            if (bVarValueAt != null) {
                arrayList.add(bVarValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.h.hc> b(int i) {
        return this.hc.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized void c(int i) {
        this.hc.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        int iMk = hcVar.mk();
        List<com.ss.android.socialbase.downloader.h.hc> arrayList = this.hc.get(iMk);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.hc.put(iMk, arrayList);
        }
        arrayList.add(hcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized void d(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.h.hc> listB = b(i);
        if (listB == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.h.hc hcVar : listB) {
            if (hcVar != null && hcVar.rf() == i2) {
                hcVar.hc(j);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0.h() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r3 = r0.h().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r5.rf() != r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        r5.hc(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.mq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void d(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.b(r3)     // Catch: java.lang.Throwable -> L52
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L50
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.h.hc r0 = (com.ss.android.socialbase.downloader.h.hc) r0     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto Ld
            int r1 = r0.rf()     // Catch: java.lang.Throwable -> L52
            if (r1 != r5) goto Ld
            boolean r1 = r0.an()     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L50
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L52
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        L35:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.h.hc r5 = (com.ss.android.socialbase.downloader.h.hc) r5     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L35
            int r0 = r5.rf()     // Catch: java.lang.Throwable -> L52
            if (r0 != r4) goto L35
            r5.hc(r6)     // Catch: java.lang.Throwable -> L52
            monitor-exit(r2)
            return
        L4e:
            monitor-exit(r2)
            return
        L50:
            monitor-exit(r2)
            return
        L52:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.mk.d(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized com.ss.android.socialbase.downloader.h.b d(int i, int i2) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.u(i2);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        boolean z = true;
        if (bVar == null) {
            return true;
        }
        if (this.d.get(bVar.h()) == null) {
            z = false;
        }
        this.d.put(bVar.h(), bVar);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized boolean u(int i) {
        this.d.remove(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean an(int i) {
        u(i);
        c(i);
        uo(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized void b() {
        this.d.clear();
        this.hc.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.h(j);
            bVarHc.u(str);
            if (TextUtils.isEmpty(bVarHc.gb()) && !TextUtils.isEmpty(str2)) {
                bVarHc.an(str2);
            }
            bVarHc.c(3);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.d(j, false);
            if (bVarHc.w() != -3 && bVarHc.w() != -2 && !com.ss.android.socialbase.downloader.hc.an.h(bVarHc.w()) && bVarHc.w() != -4) {
                bVarHc.c(4);
            }
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b hc(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.d(j, false);
            bVarHc.c(-1);
            bVarHc.tt(false);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.c(5);
            bVarHc.tt(false);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b b(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.d(j, false);
            bVarHc.c(-3);
            bVarHc.tt(false);
            bVarHc.tc(false);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b c(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.d(j, false);
            bVarHc.c(-2);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tt(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.c(1);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tc(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc = hc(i);
        if (bVarHc != null) {
            bVarHc.c(-7);
        }
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        if (list == null) {
            return;
        }
        c(i);
        for (com.ss.android.socialbase.downloader.h.hc hcVar : list) {
            if (hcVar != null) {
                d(hcVar);
                if (hcVar.an()) {
                    Iterator<com.ss.android.socialbase.downloader.h.hc> it = hcVar.h().iterator();
                    while (it.hasNext()) {
                        d(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized List<com.ss.android.socialbase.downloader.mk.tt> k(int i) {
        Map<Long, com.ss.android.socialbase.downloader.mk.tt> map = this.b.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized Map<Long, com.ss.android.socialbase.downloader.mk.tt> mq(int i) {
        return this.b.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized boolean d(int i, Map<Long, com.ss.android.socialbase.downloader.mk.tt> map) {
        this.b.put(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public synchronized void uo(int i) {
        this.b.remove(i);
    }
}
