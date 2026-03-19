package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.downloader.rf;
import com.ss.android.socialbase.downloader.k.gb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d implements gb.d {
    private final SparseArray<com.ss.android.socialbase.downloader.h.c> hc = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.h.c> b = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.h.c> c = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.h.c> u = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.h.c> an = new SparseArray<>();
    private final SparseArray<SparseArray<com.ss.android.socialbase.downloader.h.c>> h = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.e.gb<Integer, com.ss.android.socialbase.downloader.h.c> gb = new com.ss.android.socialbase.downloader.e.gb<>();
    private final SparseArray<Long> tt = new SparseArray<>();
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.h.c> tc = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.k.gb d = new com.ss.android.socialbase.downloader.k.gb(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.mq mk = com.ss.android.socialbase.downloader.downloader.b.np();

    protected abstract com.ss.android.socialbase.downloader.k.b b(int i);

    protected abstract List<Integer> d();

    public abstract void d(int i, long j);

    protected abstract void d(int i, com.ss.android.socialbase.downloader.h.c cVar);

    public abstract void d(com.ss.android.socialbase.downloader.k.b bVar);

    public abstract boolean d(int i);

    protected abstract void hc(int i);

    protected d() {
    }

    private void hc(com.ss.android.socialbase.downloader.h.c cVar) {
        int iMq = cVar.mq();
        if (iMq == 0 && cVar.uo()) {
            iMq = cVar.rf();
        }
        if (iMq == 0) {
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.h.c> sparseArray = this.h.get(cVar.w());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.h.put(cVar.w(), sparseArray);
        }
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + cVar.w() + " listener hasCode:" + iMq);
        sparseArray.put(iMq, cVar);
    }

    private void d(com.ss.android.socialbase.downloader.h.c cVar, boolean z) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        int iW;
        com.ss.android.socialbase.downloader.h.b bVarD2;
        com.ss.android.socialbase.downloader.h.c cVar2;
        if (cVar == null || (bVarD = cVar.d()) == null) {
            return;
        }
        if (bVarD.vo()) {
            com.ss.android.socialbase.downloader.gb.d.d(cVar.u(), bVarD, new com.ss.android.socialbase.downloader.u.d(1003, "downloadInfo is Invalid, url is " + bVarD.tc() + " name is " + bVarD.gb() + " savePath is " + bVarD.mk()), bVarD.w());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.uo.d.d(bVarD.h()).d("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.e.an.b(com.ss.android.socialbase.downloader.downloader.b.tr()) && !bVarD.is()) {
            new com.ss.android.socialbase.downloader.downloader.an(cVar, this.d).d(new com.ss.android.socialbase.downloader.u.d(1049, "network_not_available"));
            return;
        }
        int iH = bVarD.h();
        if (z) {
            d(bVarD);
        }
        if (this.c.get(iH) != null) {
            this.c.remove(iH);
        }
        if (this.b.get(iH) != null) {
            this.b.remove(iH);
        }
        if (this.u.get(iH) != null) {
            this.u.remove(iH);
        }
        if (this.an.get(iH) != null) {
            this.an.remove(iH);
        }
        if (d(iH) && !bVarD.mg()) {
            com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            cVar.yo();
            com.ss.android.socialbase.downloader.gb.d.d(cVar.u(), bVarD, new com.ss.android.socialbase.downloader.u.d(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), bVarD.w());
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(iH)));
        if (bVarD.mg()) {
            bVarD.d(com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.e.d.d(32768) && (cVar2 = (com.ss.android.socialbase.downloader.h.c) this.gb.remove(Integer.valueOf(iH))) != null) {
            cVar.d(cVar2);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        com.ss.android.socialbase.downloader.h.c cVar3 = this.hc.get(iH);
        if (cVar3 == null || (bVarD2 = cVar3.d()) == null) {
            iW = 0;
        } else {
            iW = bVarD2.w();
            if (com.ss.android.socialbase.downloader.hc.an.hc(iW)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + iW);
        if (z2) {
            cVar.yo();
            return;
        }
        hc(cVar);
        this.hc.put(iH, cVar);
        this.tt.put(iH, Long.valueOf(jUptimeMillis));
        d(iH, cVar);
    }

    public synchronized void d(com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
        if (bVarD == null) {
            return;
        }
        bVarD.u(false);
        if (bVarD.yo() != com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE) {
            b(cVar);
        } else {
            d(cVar, true);
        }
    }

    private void b(com.ss.android.socialbase.downloader.h.c cVar) throws InterruptedException {
        com.ss.android.socialbase.downloader.h.b bVarD;
        if (cVar == null || (bVarD = cVar.d()) == null) {
            return;
        }
        try {
            if (this.tc.isEmpty()) {
                d(cVar, true);
                this.tc.put(cVar);
                return;
            }
            if (bVarD.yo() == com.ss.android.socialbase.downloader.hc.h.ENQUEUE_TAIL) {
                if (this.tc.getFirst().w() == cVar.w() && d(cVar.w())) {
                    return;
                }
                Iterator<com.ss.android.socialbase.downloader.h.c> it = this.tc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.ss.android.socialbase.downloader.h.c next = it.next();
                    if (next != null && next.w() == cVar.w()) {
                        it.remove();
                        break;
                    }
                }
                this.tc.put(cVar);
                new com.ss.android.socialbase.downloader.downloader.an(cVar, this.d).d();
                return;
            }
            com.ss.android.socialbase.downloader.h.c first = this.tc.getFirst();
            if (first.w() == cVar.w() && d(cVar.w())) {
                return;
            }
            u(first.w());
            d(cVar, true);
            if (first.w() != cVar.w()) {
                this.tc.putFirst(cVar);
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized com.ss.android.socialbase.downloader.h.b c(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        com.ss.android.socialbase.downloader.h.c cVar;
        bVarHc = this.mk.hc(i);
        if (bVarHc == null && (cVar = this.hc.get(i)) != null) {
            bVarHc = cVar.d();
        }
        return bVarHc;
    }

    public synchronized List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.h.b> listD = this.mk.d(str);
        if (listD != null && !listD.isEmpty()) {
            return listD;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hc.size();
        for (int i = 0; i < size; i++) {
            com.ss.android.socialbase.downloader.h.c cVarValueAt = this.hc.valueAt(i);
            if (cVarValueAt != null && cVarValueAt.d() != null && str.equals(cVarValueAt.d().tc())) {
                arrayList.add(cVarValueAt.d());
            }
        }
        return arrayList;
    }

    public synchronized boolean u(int i) {
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (bVarHc != null && bVarHc.w() == 11) {
            return false;
        }
        synchronized (this.hc) {
            hc(i);
        }
        if (bVarHc == null) {
            com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
            if (cVar != null) {
                new com.ss.android.socialbase.downloader.downloader.an(cVar, this.d).c();
                return true;
            }
        } else {
            d(bVarHc);
            if (bVarHc.w() == 1) {
                com.ss.android.socialbase.downloader.h.c cVar2 = this.hc.get(i);
                if (cVar2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.an(cVar2, this.d).c();
                    return true;
                }
            } else if (com.ss.android.socialbase.downloader.hc.an.hc(bVarHc.w())) {
                bVarHc.c(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean d(int i, boolean z) {
        com.ss.android.socialbase.downloader.h.c cVarE = this.hc.get(i);
        if (cVarE == null && com.ss.android.socialbase.downloader.e.d.d(65536)) {
            cVarE = e(i);
        }
        if (cVarE != null) {
            if (!com.ss.android.socialbase.downloader.uo.d.d(i).hc("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.an(cVarE, this.d).b();
            }
            final com.ss.android.socialbase.downloader.h.b bVarD = cVarE.d();
            final SparseArray<vv> sparseArrayD = cVarE.d(com.ss.android.socialbase.downloader.hc.gb.MAIN);
            final SparseArray<vv> sparseArrayD2 = cVarE.d(com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION);
            this.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = sparseArrayD;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < sparseArrayD.size(); i2++) {
                                vv vvVar = (vv) sparseArrayD.get(sparseArrayD.keyAt(i2));
                                if (vvVar != null) {
                                    vvVar.an(bVarD);
                                }
                            }
                        }
                    }
                    com.ss.android.socialbase.downloader.h.b bVar = bVarD;
                    if (bVar == null || !bVar.tj() || (sparseArray = sparseArrayD2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < sparseArrayD2.size(); i3++) {
                            vv vvVar2 = (vv) sparseArrayD2.get(sparseArrayD2.keyAt(i3));
                            if (vvVar2 != null) {
                                vvVar2.an(bVarD);
                            }
                        }
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (com.ss.android.socialbase.downloader.e.d.d(65536)) {
            if (bVarHc != null) {
                bVarHc.c(-4);
            }
        } else if (bVarHc != null && com.ss.android.socialbase.downloader.hc.an.hc(bVarHc.w())) {
            bVarHc.c(-4);
        }
        hc(i, z);
        return true;
    }

    public synchronized boolean an(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
            if (bVarD != null) {
                bVarD.u(false);
            }
            d(cVar);
        } else {
            h(i);
        }
        return true;
    }

    public synchronized boolean h(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.c.get(i);
        if (cVar == null) {
            cVar = this.u.get(i);
        }
        if (cVar == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
        if (bVarD != null) {
            bVarD.u(false);
        }
        d(cVar);
        return true;
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar != null) {
            try {
                if (bVar.w() == 7 || bVar.eu() != com.ss.android.socialbase.downloader.hc.tt.DELAY_RETRY_NONE) {
                    bVar.c(5);
                    bVar.d(com.ss.android.socialbase.downloader.hc.tt.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
    }

    public synchronized void d(int i, s sVar) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            cVar.hc(sVar);
        }
    }

    public synchronized ba gb(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            return cVar.mk();
        }
        com.ss.android.socialbase.downloader.h.c cVar2 = this.b.get(i);
        if (cVar2 != null) {
            return cVar2.mk();
        }
        com.ss.android.socialbase.downloader.h.c cVar3 = this.c.get(i);
        if (cVar3 != null) {
            return cVar3.mk();
        }
        com.ss.android.socialbase.downloader.h.c cVar4 = this.u.get(i);
        if (cVar4 != null) {
            return cVar4.mk();
        }
        com.ss.android.socialbase.downloader.h.c cVar5 = this.an.get(i);
        if (cVar5 == null) {
            return null;
        }
        return cVar5.mk();
    }

    public synchronized s tt(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            return cVar.tc();
        }
        com.ss.android.socialbase.downloader.h.c cVar2 = this.b.get(i);
        if (cVar2 != null) {
            return cVar2.tc();
        }
        com.ss.android.socialbase.downloader.h.c cVar3 = this.c.get(i);
        if (cVar3 != null) {
            return cVar3.tc();
        }
        com.ss.android.socialbase.downloader.h.c cVar4 = this.u.get(i);
        if (cVar4 != null) {
            return cVar4.tc();
        }
        com.ss.android.socialbase.downloader.h.c cVar5 = this.an.get(i);
        if (cVar5 == null) {
            return null;
        }
        return cVar5.tc();
    }

    public synchronized sy tc(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            return cVar.k();
        }
        com.ss.android.socialbase.downloader.h.c cVar2 = this.b.get(i);
        if (cVar2 != null) {
            return cVar2.k();
        }
        com.ss.android.socialbase.downloader.h.c cVar3 = this.c.get(i);
        if (cVar3 != null) {
            return cVar3.k();
        }
        com.ss.android.socialbase.downloader.h.c cVar4 = this.u.get(i);
        if (cVar4 != null) {
            return cVar4.k();
        }
        com.ss.android.socialbase.downloader.h.c cVar5 = this.an.get(i);
        if (cVar5 == null) {
            return null;
        }
        return cVar5.k();
    }

    public synchronized boolean mk(int i) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        com.ss.android.socialbase.downloader.h.c cVar = this.u.get(i);
        if (cVar != null && (bVarD = cVar.d()) != null) {
            if (bVarD.ai()) {
                d(cVar, false);
            }
            return true;
        }
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (bVarHc != null && bVarHc.ai()) {
            d(new com.ss.android.socialbase.downloader.h.c(bVarHc), false);
        }
        return false;
    }

    public synchronized boolean mq(int i) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        com.ss.android.socialbase.downloader.h.c cVar = this.an.get(i);
        if (cVar == null || (bVarD = cVar.d()) == null) {
            return false;
        }
        if (bVarD.mg()) {
            d(cVar);
        }
        return true;
    }

    public synchronized void d(List<String> list) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        try {
            boolean zHc = com.ss.android.socialbase.downloader.e.d.d(1048576) ? com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.socialbase.downloader.downloader.b.tr()) : true;
            for (int i = 0; i < this.c.size(); i++) {
                com.ss.android.socialbase.downloader.h.c cVar = this.c.get(this.c.keyAt(i));
                if (cVar != null && (bVarD = cVar.d()) != null && bVarD.hg() != null && list.contains(bVarD.hg()) && (!bVarD.np() || zHc)) {
                    bVarD.hc(true);
                    bVarD.b(true);
                    d(cVar);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    public synchronized void hc(List<String> list) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        try {
            if (com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.socialbase.downloader.downloader.b.tr())) {
                for (int i = 0; i < this.hc.size(); i++) {
                    com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(this.hc.keyAt(i));
                    if (cVar != null && (bVarD = cVar.d()) != null && bVarD.hg() != null && list.contains(bVarD.hg()) && hc(bVarD)) {
                        bVarD.hc(true);
                        bVarD.b(true);
                        d(cVar);
                        bVarD.u(true);
                        rf rfVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc();
                        if (rfVarHc != null) {
                            rfVarHc.d(bVarD, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    private boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar != null && bVar.ra()) {
            return bVar.xp();
        }
        return false;
    }

    public void hc() {
        List<Integer> listD = d();
        if (listD == null) {
            return;
        }
        Iterator<Integer> it = listD.iterator();
        while (it.hasNext()) {
            u(it.next().intValue());
        }
    }

    public void hc(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (bVarHc != null) {
            d(bVarHc);
        }
        this.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.hc.d().an(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.h.c cVarE;
                if (d.this.b(i) == null && (cVarE = d.this.e(i)) != null) {
                    com.ss.android.socialbase.downloader.h.b bVarD = cVarE.d();
                    SparseArray<vv> sparseArrayD = cVarE.d(com.ss.android.socialbase.downloader.hc.gb.SUB);
                    if (sparseArrayD != null) {
                        synchronized (sparseArrayD) {
                            for (int i2 = 0; i2 < sparseArrayD.size(); i2++) {
                                vv vvVar = sparseArrayD.get(sparseArrayD.keyAt(i2));
                                if (vvVar != null) {
                                    vvVar.an(bVarD);
                                }
                            }
                        }
                    }
                }
                d.this.c(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
            if (bVarHc != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.e.an.d(bVarHc);
                } else {
                    com.ss.android.socialbase.downloader.e.an.b(bVarHc.mq(), bVarHc.uo());
                }
                bVarHc.ua();
            }
            try {
                this.mk.an(i);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            d(i, 0, -4);
            if (this.c.get(i) != null) {
                this.c.remove(i);
            }
            if (this.b.get(i) != null) {
                this.b.remove(i);
            }
            this.gb.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.uo.d.hc(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public void b(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (bVarHc != null) {
            d(bVarHc);
        }
        this.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.hc.d().an(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(i);
                d.this.u(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, boolean z) {
        try {
            com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
            if (bVarHc != null) {
                com.ss.android.socialbase.downloader.e.an.d(bVarHc, z);
                bVarHc.ua();
            }
            try {
                this.mk.c(i);
                this.mk.d(bVarHc);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            if (this.c.get(i) != null) {
                this.c.remove(i);
            }
            if (this.b.get(i) != null) {
                this.b.remove(i);
            }
            this.gb.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.uo.d.hc(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public synchronized void uo(int i) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null && (bVarD = cVar.d()) != null) {
            bVarD.mq(true);
            d(cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean k(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L19
            android.util.SparseArray<com.ss.android.socialbase.downloader.h.c> r0 = r1.hc     // Catch: java.lang.Throwable -> L16
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.h.c> r0 = r1.c     // Catch: java.lang.Throwable -> L16
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L19
        L13:
            r2 = 1
        L14:
            monitor-exit(r1)
            return r2
        L16:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L19:
            r2 = 0
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.d.k(int):boolean");
    }

    public synchronized void d(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        com.ss.android.socialbase.downloader.h.c cVarE = e(i);
        if (cVarE == null) {
            cVarE = this.gb.get(Integer.valueOf(i));
        }
        if (cVarE != null) {
            cVarE.d(i2, vvVar, gbVar, z);
        }
    }

    public synchronized void hc(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        d(i, i2, vvVar, gbVar, z, true);
    }

    public synchronized void d(int i, int i2, final vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        com.ss.android.socialbase.downloader.h.c cVarE = e(i);
        if (cVarE != null) {
            cVarE.hc(i2, vvVar, gbVar, z);
            final com.ss.android.socialbase.downloader.h.b bVarD = cVarE.d();
            if (z2 && bVarD != null && !d(i) && (gbVar == com.ss.android.socialbase.downloader.hc.gb.MAIN || gbVar == com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION)) {
                boolean z3 = true;
                if (gbVar == com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION && !bVarD.tj()) {
                    z3 = false;
                }
                if (z3) {
                    this.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (vvVar != null) {
                                if (bVarD.w() == -3) {
                                    vvVar.u(bVarD);
                                } else if (bVarD.w() == -1) {
                                    vvVar.d(bVarD, new com.ss.android.socialbase.downloader.u.d(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
            return;
        }
        if (com.ss.android.socialbase.downloader.e.d.d(32768) && (bVarHc = this.mk.hc(i)) != null && bVarHc.w() != -3) {
            com.ss.android.socialbase.downloader.h.c cVar = this.gb.get(Integer.valueOf(i));
            if (cVar == null) {
                cVar = new com.ss.android.socialbase.downloader.h.c(bVarHc);
                this.gb.put(Integer.valueOf(i), cVar);
            }
            cVar.hc(i2, vvVar, gbVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.h.c e(int i) {
        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
        if (cVar != null) {
            return cVar;
        }
        com.ss.android.socialbase.downloader.h.c cVar2 = this.c.get(i);
        if (cVar2 != null) {
            return cVar2;
        }
        com.ss.android.socialbase.downloader.h.c cVar3 = this.b.get(i);
        if (cVar3 != null) {
            return cVar3;
        }
        com.ss.android.socialbase.downloader.h.c cVar4 = this.u.get(i);
        return cVar4 == null ? this.an.get(i) : cVar4;
    }

    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = d().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.h.b bVarC = c(it.next().intValue());
            if (bVarC != null && str.equals(bVarC.hg())) {
                arrayList.add(bVarC);
            }
        }
        return arrayList;
    }

    private void d(int i, com.ss.android.socialbase.downloader.u.d dVar, com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar != null) {
            com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
            SparseArray<vv> sparseArrayD = cVar.d(com.ss.android.socialbase.downloader.hc.gb.MAIN);
            SparseArray<vv> sparseArrayD2 = cVar.d(com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION);
            boolean z = cVar.e() || bVarD.p();
            com.ss.android.socialbase.downloader.e.b.d(i, sparseArrayD, true, bVarD, dVar);
            com.ss.android.socialbase.downloader.e.b.d(i, sparseArrayD2, z, bVarD, dVar);
        }
    }

    private void cb(int i) {
        com.ss.android.socialbase.downloader.h.c first;
        if (this.tc.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.h.c first2 = this.tc.getFirst();
        if (first2 != null && first2.w() == i) {
            this.tc.poll();
        }
        if (this.tc.isEmpty() || (first = this.tc.getFirst()) == null) {
            return;
        }
        d(first, true);
    }

    private void d(int i, int i2) {
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.hc.remove(i);
            this.h.remove(i);
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.h.c> sparseArray = this.h.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.hc.remove(i);
                this.h.remove(i);
                return;
            }
            return;
        }
        this.hc.remove(i);
    }

    public synchronized void d(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                this.b.put(i, this.hc.get(i));
                d(i, i2);
                return;
            }
            if (i3 == -4) {
                d(i, i2);
            } else if (i3 == -3) {
                this.b.put(i, this.hc.get(i));
                d(i, i2);
            } else if (i3 != -1) {
                if (i3 != 7) {
                    if (i3 == 8) {
                        com.ss.android.socialbase.downloader.h.c cVar = this.hc.get(i);
                        if (cVar != null && this.an.get(i) == null) {
                            this.an.put(i, cVar);
                        }
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.h.c cVar2 = this.hc.get(i);
                if (cVar2 != null) {
                    if (this.u.get(i) == null) {
                        this.u.put(i, cVar2);
                    }
                    d(i, i2);
                }
                cb(i);
                return;
            }
            cb(i);
            return;
        }
        com.ss.android.socialbase.downloader.h.c cVar3 = this.hc.get(i);
        if (cVar3 != null) {
            if (this.c.get(i) == null) {
                this.c.put(i, cVar3);
            }
            d(i, i2);
        }
        cb(i);
    }

    @Override // com.ss.android.socialbase.downloader.k.gb.d
    public void d(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.an.d.hc("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        com.ss.android.socialbase.downloader.h.c cVar = null;
        com.ss.android.socialbase.downloader.u.d dVar = message.obj instanceof Exception ? (com.ss.android.socialbase.downloader.u.d) message.obj : null;
        synchronized (this) {
            if (i2 == 0) {
                cVar = this.hc.get(i);
            } else {
                SparseArray<com.ss.android.socialbase.downloader.h.c> sparseArray = this.h.get(i);
                if (sparseArray != null) {
                    cVar = sparseArray.get(i2);
                }
            }
            if (cVar == null) {
                return;
            }
            d(message.what, dVar, cVar);
            d(i, i2, message.what);
        }
    }

    public void hc(int i, long j) {
        com.ss.android.socialbase.downloader.h.b bVarHc = this.mk.hc(i);
        if (bVarHc != null) {
            bVarHc.mk(j);
        }
        d(i, j);
    }
}
