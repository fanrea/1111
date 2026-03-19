package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.d.d.hc.w;
import com.ss.android.d.d.hc.yi;
import com.ss.android.downloadlib.addownload.mq;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {
    private static volatile gb d;
    private long an;
    private final List<com.ss.android.downloadlib.addownload.h> b = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.h> c = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> u = new CopyOnWriteArrayList<>();
    private final Handler hc = new Handler(Looper.getMainLooper());

    private gb() {
    }

    public static gb d() {
        if (d == null) {
            synchronized (gb.class) {
                if (d == null) {
                    d = new gb();
                }
            }
        }
        return d;
    }

    public void d(Context context, int i, com.ss.android.d.d.b.c cVar, com.ss.android.d.d.b.b bVar) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (bVar == null || TextUtils.isEmpty(bVar.d())) {
            return;
        }
        boolean z = mq.tt().optInt("filter_download_url_key", 0) == 1;
        String strD = com.ss.android.downloadlib.addownload.an.d().d(bVar.d());
        if (z && !TextUtils.isEmpty(strD)) {
            hVar = this.c.get(strD);
            if (bVar instanceof com.ss.android.hc.d.d.b) {
                com.ss.android.hc.d.d.b bVar2 = (com.ss.android.hc.d.d.b) bVar;
                if (TextUtils.isEmpty(bVar2.wl())) {
                    bVar2.an(strD);
                }
            }
        } else {
            hVar = this.c.get(bVar.d());
        }
        if (hVar != null) {
            hVar.hc(context).hc(i, cVar).hc(bVar).d();
            return;
        }
        if (this.b.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strD)) {
                    hc(context, i, cVar, bVar, strD);
                    return;
                }
                String strD2 = com.ss.android.downloadlib.addownload.an.d().d(bVar);
                if (!TextUtils.isEmpty(strD2)) {
                    hc(context, i, cVar, bVar, strD2);
                    if (bVar instanceof com.ss.android.hc.d.d.b) {
                        com.ss.android.hc.d.d.b bVar3 = (com.ss.android.hc.d.d.b) bVar;
                        if (TextUtils.isEmpty(bVar3.wl())) {
                            bVar3.an(strD2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            b(context, i, cVar, bVar);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strD)) {
                d(context, i, cVar, bVar, strD);
                return;
            }
            String strD3 = com.ss.android.downloadlib.addownload.an.d().d(bVar);
            if (TextUtils.isEmpty(strD3)) {
                hc(context, i, cVar, bVar);
                return;
            }
            d(context, i, cVar, bVar, strD3);
            if (bVar instanceof com.ss.android.hc.d.d.b) {
                com.ss.android.hc.d.d.b bVar4 = (com.ss.android.hc.d.d.b) bVar;
                if (TextUtils.isEmpty(bVar4.wl())) {
                    bVar4.an(strD3);
                    return;
                }
                return;
            }
            return;
        }
        hc(context, i, cVar, bVar);
    }

    public com.ss.android.downloadlib.addownload.u d(String str) {
        com.ss.android.downloadlib.addownload.h hVar;
        Map<String, com.ss.android.downloadlib.addownload.h> map = this.c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (mq.tt().optInt("filter_download_url_key", 0) == 1) {
                hVar = this.c.get(com.ss.android.downloadlib.addownload.an.d().d(str));
            } else {
                hVar = this.c.get(str);
            }
            if (hVar instanceof com.ss.android.downloadlib.addownload.u) {
                return (com.ss.android.downloadlib.addownload.u) hVar;
            }
        }
        return null;
    }

    private synchronized void hc(Context context, int i, com.ss.android.d.d.b.c cVar, com.ss.android.d.d.b.b bVar) {
        if (this.b.size() <= 0) {
            b(context, i, cVar, bVar);
            return;
        }
        com.ss.android.downloadlib.addownload.h hVarRemove = this.b.remove(0);
        hVarRemove.hc(context).hc(i, cVar).hc(bVar).d();
        this.c.put(bVar.d(), hVarRemove);
    }

    private synchronized void d(Context context, int i, com.ss.android.d.d.b.c cVar, com.ss.android.d.d.b.b bVar, String str) {
        if (this.b.size() <= 0) {
            hc(context, i, cVar, bVar, str);
            return;
        }
        com.ss.android.downloadlib.addownload.h hVarRemove = this.b.remove(0);
        hVarRemove.hc(context).hc(i, cVar).hc(bVar).d(str).d();
        this.c.put(str, hVarRemove);
        com.ss.android.downloadlib.addownload.an.d().d(str, bVar.d());
    }

    private void b(Context context, int i, com.ss.android.d.d.b.c cVar, com.ss.android.d.d.b.b bVar) {
        if (bVar == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.u uVar = new com.ss.android.downloadlib.addownload.u();
        uVar.hc(context).hc(i, cVar).hc(bVar).d();
        this.c.put(bVar.d(), uVar);
    }

    private void hc(Context context, int i, com.ss.android.d.d.b.c cVar, com.ss.android.d.d.b.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.u uVar = new com.ss.android.downloadlib.addownload.u();
        uVar.hc(context).hc(i, cVar).hc(bVar).d(str).d();
        this.c.put(str, uVar);
        com.ss.android.downloadlib.addownload.an.d().d(str, bVar.d());
    }

    public void d(String str, int i) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = mq.tt().optInt("filter_download_url_key", 0) == 1;
        String strD = com.ss.android.downloadlib.addownload.an.d().d(str);
        if (z && !TextUtils.isEmpty(strD)) {
            hVar = this.c.get(strD);
        } else {
            hVar = this.c.get(str);
        }
        if (hVar != null) {
            if (hVar.d(i)) {
                this.b.add(hVar);
                if (z && !TextUtils.isEmpty(strD)) {
                    this.c.remove(strD);
                    com.ss.android.downloadlib.addownload.an.d().hc(strD);
                } else {
                    this.c.remove(str);
                }
            }
            b();
        }
    }

    public void d(String str, boolean z) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = mq.tt().optInt("filter_download_url_key", 0) == 1;
        String strD = com.ss.android.downloadlib.addownload.an.d().d(str);
        if (z2 && !TextUtils.isEmpty(strD)) {
            hVar = this.c.get(strD);
        } else {
            hVar = this.c.get(str);
        }
        if (hVar != null) {
            hVar.d(z);
        }
    }

    public void d(String str, long j, int i, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        d(str, j, i, hcVar, dVar, null, null);
    }

    public void d(String str, long j, int i, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, w wVar) {
        d(str, j, i, hcVar, dVar, null, wVar);
    }

    public void d(String str, long j, int i, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, yi yiVar, w wVar) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = mq.tt().optInt("filter_download_url_key", 0) == 1;
        String strD = com.ss.android.downloadlib.addownload.an.d().d(str);
        if (z && !TextUtils.isEmpty(strD)) {
            hVar = this.c.get(strD);
        } else {
            hVar = this.c.get(str);
        }
        if (hVar != null) {
            hVar.d(j).hc(hcVar).hc(dVar).d(yiVar).d(wVar).hc(i);
        }
    }

    public void d(com.ss.android.d.d.b.d.d dVar) {
        if (dVar != null) {
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("fix_listener_oom", false)) {
                this.u.add(new SoftReference(dVar));
            } else {
                this.u.add(dVar);
            }
        }
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.an < 300000) {
            return;
        }
        this.an = jCurrentTimeMillis;
        if (this.b.isEmpty()) {
            return;
        }
        c();
    }

    private void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.h hVar : this.b) {
            if (!hVar.hc() && jCurrentTimeMillis - hVar.c() > 300000) {
                hVar.gb();
                arrayList.add(hVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.b.removeAll(arrayList);
    }

    public void d(final com.ss.android.d.d.b.b bVar, final com.ss.android.d.d.b.d dVar, final com.ss.android.d.d.b.hc hcVar) {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.gb.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = gb.this.u.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.d.d.b.d.d) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.d.d.b.d.d) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void d(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.socialbase.downloader.u.d dVar, final String str) {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.gb.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = gb.this.u.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.d.d.b.d.d) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.d.d.b.d.d) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void d(final com.ss.android.socialbase.downloader.h.b bVar, final String str) {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.gb.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = gb.this.u.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.d.d.b.d.d) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.d.d.b.d.d) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void hc(final com.ss.android.socialbase.downloader.h.b bVar, final String str) {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.gb.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = gb.this.u.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.d.d.b.d.d) {
                        ((com.ss.android.d.d.b.d.d) next).d(bVar, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.d.d.b.d.d) {
                            ((com.ss.android.d.d.b.d.d) softReference.get()).d(bVar, str);
                        }
                    }
                }
            }
        });
    }

    public void d(final com.ss.android.socialbase.downloader.h.b bVar) {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.gb.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = gb.this.u.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.d.d.b.d.d) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.d.d.b.d.d) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public Handler hc() {
        return this.hc;
    }
}
