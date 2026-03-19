package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.sy;
import com.ss.android.socialbase.downloader.k.gb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements com.ss.android.socialbase.downloader.downloader.mq {
    private com.ss.android.socialbase.downloader.k.gb an;
    private volatile boolean b;
    private volatile boolean c;
    private sy hc;
    private gb.d u = new gb.d() { // from class: com.ss.android.socialbase.downloader.impls.c.1
        @Override // com.ss.android.socialbase.downloader.k.gb.d
        public void d(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.this.tt();
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                        }
                    }
                });
            }
        }
    };
    private final mk d = new mk();

    public c() {
        this.an = null;
        if (!com.ss.android.socialbase.downloader.uo.d.b().d("fix_sigbus_downloader_db") || com.ss.android.socialbase.downloader.e.an.d() || !com.ss.android.socialbase.downloader.downloader.b.ru()) {
            this.hc = new com.ss.android.socialbase.downloader.b.u();
        } else {
            this.hc = com.ss.android.socialbase.downloader.downloader.b.yn().d(new b.d.InterfaceC0786d() { // from class: com.ss.android.socialbase.downloader.impls.c.2
                @Override // com.ss.android.socialbase.downloader.downloader.b.d.InterfaceC0786d
                public void d() {
                    c.this.hc = new com.ss.android.socialbase.downloader.b.u();
                    com.bytedance.sdk.component.utils.mq.c("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.b = false;
        this.an = new com.ss.android.socialbase.downloader.k.gb(Looper.getMainLooper(), this.u);
        h();
    }

    public mk d() {
        return this.d;
    }

    public sy an() {
        return this.hc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b h(int i) {
        com.ss.android.socialbase.downloader.h.b bVarH = this.d.h(i);
        b(bVarH);
        return bVarH;
    }

    public void h() {
        List<com.ss.android.socialbase.downloader.h.hc> list;
        com.ss.android.socialbase.downloader.h.b bVar;
        com.ss.android.socialbase.downloader.downloader.b.d(com.ss.android.socialbase.downloader.hc.c.SYNC_START);
        final SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArray2 = new SparseArray<>();
        synchronized (this.d) {
            SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArrayD = this.d.d();
            for (int i = 0; i < sparseArrayD.size(); i++) {
                int iKeyAt = sparseArrayD.keyAt(i);
                if (iKeyAt != 0 && (bVar = sparseArrayD.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, bVar);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArrayAn = this.d.an();
            for (int i2 = 0; i2 < sparseArrayAn.size(); i2++) {
                int iKeyAt2 = sparseArrayAn.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayAn.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.hc.d(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.b.c() { // from class: com.ss.android.socialbase.downloader.impls.c.3
            @Override // com.ss.android.socialbase.downloader.b.c
            public void d() {
                synchronized (c.this.d) {
                    SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArrayD2 = c.this.d.d();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayD2.put(iKeyAt3, (com.ss.android.socialbase.downloader.h.b) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArrayAn2 = c.this.d.an();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayAn2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                c.this.tc();
                c.this.gb();
                com.ss.android.socialbase.downloader.downloader.b.d(com.ss.android.socialbase.downloader.hc.c.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc() {
        synchronized (this) {
            this.b = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean u() {
        if (this.b) {
            return true;
        }
        synchronized (this) {
            if (!this.b) {
                com.ss.android.socialbase.downloader.an.d.c("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
                com.ss.android.socialbase.downloader.an.d.c("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean c() {
        return this.b;
    }

    public void gb() {
        long j;
        if (com.ss.android.socialbase.downloader.uo.d.b().d("task_resume_delay")) {
            j = 4000;
        } else {
            j = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.an.sendMessageDelayed(this.an.obtainMessage(1), j);
    }

    public void tt() {
        List<String> listD;
        ArrayList arrayList;
        com.ss.android.socialbase.downloader.h.b bVar;
        com.ss.android.socialbase.downloader.h.b bVar2;
        if (this.b) {
            if (this.c) {
                com.ss.android.socialbase.downloader.an.d.hc("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.c = true;
            if (com.ss.android.socialbase.downloader.e.an.d()) {
                com.ss.android.socialbase.downloader.downloader.k kVarV = com.ss.android.socialbase.downloader.downloader.b.v();
                if (kVarV != null) {
                    listD = kVarV.d();
                    arrayList = (listD == null || listD.isEmpty()) ? null : new ArrayList();
                } else {
                    listD = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArrayD = this.d.d();
                    for (int i = 0; i < sparseArrayD.size(); i++) {
                        int iKeyAt = sparseArrayD.keyAt(i);
                        if (iKeyAt != 0 && (bVar2 = sparseArrayD.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, bVar2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    if (iKeyAt2 != 0 && (bVar = (com.ss.android.socialbase.downloader.h.b) sparseArray.get(iKeyAt2)) != null) {
                        int iV = bVar.v();
                        int iQi = bVar.qi();
                        if (iQi > 0 && iQi <= 11) {
                            com.ss.android.socialbase.downloader.gb.d.d(com.ss.android.socialbase.downloader.downloader.b.an(), bVar, (com.ss.android.socialbase.downloader.u.d) null, -5);
                        }
                        if (listD != null && arrayList != null && bVar.hg() != null && listD.contains(bVar.hg()) && (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).hc("enable_notification_ui") >= 2 || iV != -2 || bVar.xp())) {
                            bVar.u(false);
                            arrayList.add(bVar);
                        }
                    }
                }
                if (kVarV == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                kVarV.d(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b hc(int i) {
        return this.d.hc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        return this.d.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        return this.d.hc(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        return this.d.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        return this.d.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> hc() {
        return this.d.hc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.hc> b(int i) {
        return this.d.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void c(int i) {
        this.d.c(i);
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.e(i);
                return;
            } else {
                this.hc.c(i);
                return;
            }
        }
        this.hc.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        synchronized (this.d) {
            this.d.d(hcVar);
        }
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.d(hcVar);
                return;
            } else {
                this.hc.d(hcVar);
                return;
            }
        }
        this.hc.d(hcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.hc hcVar) {
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.d(hcVar);
                return;
            } else {
                this.hc.d(hcVar);
                return;
            }
        }
        this.hc.d(hcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, long j) {
        this.d.d(i, i2, j);
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.d(i, i2, j);
                return;
            } else {
                this.hc.d(i, i2, j);
                return;
            }
        }
        this.hc.d(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.d(i, i2, i3, j);
                return;
            } else {
                this.hc.d(i, i2, i3, j);
                return;
            }
        }
        this.hc.d(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.d(i, i2, i3, i4);
                return;
            } else {
                this.hc.d(i, i2, i3, i4);
                return;
            }
        }
        this.hc.d(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, int i2) {
        com.ss.android.socialbase.downloader.h.b bVarD = this.d.d(i, i2);
        b(bVarD);
        return bVarD;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean zD = this.d.d(bVar);
        b(bVar);
        return zD;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean u(int i) {
        com.ss.android.socialbase.downloader.downloader.e eVarD;
        try {
            if (com.ss.android.socialbase.downloader.e.an.hc() && (eVarD = mq.d(true)) != null) {
                eVarD.k(i);
            } else {
                this.hc.u(i);
            }
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return this.d.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean an(int i) {
        com.ss.android.socialbase.downloader.downloader.e eVarD;
        if (com.ss.android.socialbase.downloader.e.an.hc() && (eVarD = mq.d(true)) != null) {
            eVarD.cb(i);
        } else {
            this.hc.an(i);
        }
        return this.d.an(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void b() {
        try {
            this.d.b();
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (com.ss.android.socialbase.downloader.e.an.hc()) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.an();
                return;
            } else {
                this.hc.b();
                return;
            }
        }
        this.hc.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.h.b bVarD = this.d.d(i, j, str, str2);
        b(bVarD);
        return bVarD;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarD = this.d.d(i, j);
        d(bVarD, false);
        return bVarD;
    }

    private void b(com.ss.android.socialbase.downloader.h.b bVar) {
        d(bVar, true);
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.e.an.hc()) {
            this.hc.d(bVar);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
            if (eVarD != null) {
                eVarD.b(bVar);
            } else {
                this.hc.d(bVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b hc(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = this.d.hc(i, j);
        hc(i, (List<com.ss.android.socialbase.downloader.h.hc>) null);
        return bVarHc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        com.ss.android.socialbase.downloader.h.b bVarGb = this.d.gb(i);
        b(bVarGb);
        return bVarGb;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b b(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarB = this.d.b(i, j);
        hc(i, (List<com.ss.android.socialbase.downloader.h.hc>) null);
        return bVarB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b c(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarC = this.d.c(i, j);
        hc(i, (List<com.ss.android.socialbase.downloader.h.hc>) null);
        return bVarC;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tt(int i) {
        com.ss.android.socialbase.downloader.h.b bVarTt = this.d.tt(i);
        b(bVarTt);
        return bVarTt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tc(int i) {
        com.ss.android.socialbase.downloader.h.b bVarTc = this.d.tc(i);
        b(bVarTc);
        return bVarTc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return;
        }
        this.d.d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.d.d(i, list);
        if (com.ss.android.socialbase.downloader.e.an.b()) {
            this.hc.hc(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        try {
            d(this.d.hc(i));
            if (list == null) {
                list = this.d.b(i);
            }
            if (com.ss.android.socialbase.downloader.e.an.hc()) {
                com.ss.android.socialbase.downloader.downloader.e eVarD = mq.d(true);
                if (eVarD != null) {
                    eVarD.hc(i, list);
                    return;
                } else {
                    this.hc.hc(i, list);
                    return;
                }
            }
            this.hc.hc(i, list);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.mk.tt> k(int i) {
        List<com.ss.android.socialbase.downloader.mk.tt> listK = this.d.k(i);
        return (listK == null || listK.size() == 0) ? this.hc.k(i) : listK;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public Map<Long, com.ss.android.socialbase.downloader.mk.tt> mq(int i) {
        Map<Long, com.ss.android.socialbase.downloader.mk.tt> mapMq = this.d.mq(i);
        if (mapMq != null && !mapMq.isEmpty()) {
            return mapMq;
        }
        Map<Long, com.ss.android.socialbase.downloader.mk.tt> mapMq2 = this.hc.mq(i);
        this.d.d(i, mapMq2);
        return mapMq2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean d(int i, Map<Long, com.ss.android.socialbase.downloader.mk.tt> map) {
        this.d.d(i, map);
        this.hc.d(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void uo(int i) {
        this.d.uo(i);
        this.hc.uo(i);
    }
}
