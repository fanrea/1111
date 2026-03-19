package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static volatile c d;
    private volatile SparseArray<Boolean> hc = new SparseArray<>();
    private Handler b = new Handler(Looper.getMainLooper());
    private volatile List<Object> c = new ArrayList();

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                d = new c();
            }
        }
        return d;
    }

    public void hc() {
        synchronized (this.c) {
            Iterator<Object> it = this.c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void d(int i, boolean z) {
        hc(i, z);
        if (b.ru() && !com.ss.android.socialbase.downloader.e.an.b() && com.ss.android.socialbase.downloader.impls.mq.d(true).h()) {
            com.ss.android.socialbase.downloader.impls.mq.d(true).b(i, z);
        }
        if (b.hc() || com.ss.android.socialbase.downloader.e.an.b() || com.ss.android.socialbase.downloader.e.an.d()) {
            return;
        }
        try {
            Intent intent = new Intent(b.tr(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            b.tr().startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public synchronized void hc(int i, boolean z) {
        this.hc.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int d(int i) {
        if (!b.ru()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.e.an.b() && com.ss.android.socialbase.downloader.impls.mq.d(true).h()) {
            return com.ss.android.socialbase.downloader.impls.mq.d(true).uo(i);
        }
        return hc(i);
    }

    public synchronized int hc(int i) {
        if (this.hc.get(i) == null) {
            return -1;
        }
        return this.hc.get(i).booleanValue() ? 1 : 0;
    }

    public e b(int i) {
        return com.ss.android.socialbase.downloader.impls.mq.d(d(i) == 1 && !com.ss.android.socialbase.downloader.e.an.b());
    }

    private e hc(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.b bVarD;
        List<com.ss.android.socialbase.downloader.h.hc> listTt;
        if (cVar == null || (bVarD = cVar.d()) == null) {
            return null;
        }
        boolean zNf = bVarD.nf();
        if (com.ss.android.socialbase.downloader.e.an.b() || !com.ss.android.socialbase.downloader.e.an.d()) {
            zNf = true;
        }
        int iD = d(bVarD.h());
        if (iD >= 0 && iD != zNf) {
            try {
                if (iD == 1) {
                    if (com.ss.android.socialbase.downloader.e.an.d()) {
                        com.ss.android.socialbase.downloader.impls.mq.d(true).d(bVarD.h());
                        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.impls.mq.d(true).gb(bVarD.h());
                        if (bVarGb != null) {
                            com.ss.android.socialbase.downloader.impls.mq.d(false).hc(bVarGb);
                        }
                        if (bVarGb.fj() > 1 && (listTt = com.ss.android.socialbase.downloader.impls.mq.d(true).tt(bVarD.h())) != null) {
                            com.ss.android.socialbase.downloader.impls.mq.d(false).d(bVarD.h(), com.ss.android.socialbase.downloader.e.an.d(listTt));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.e.an.d()) {
                    com.ss.android.socialbase.downloader.impls.mq.d(false).d(bVarD.h());
                    List<com.ss.android.socialbase.downloader.h.hc> listTt2 = com.ss.android.socialbase.downloader.impls.mq.d(false).tt(bVarD.h());
                    if (listTt2 != null) {
                        com.ss.android.socialbase.downloader.impls.mq.d(true).d(bVarD.h(), com.ss.android.socialbase.downloader.e.an.d(listTt2));
                    }
                } else {
                    cVar.d(true);
                    com.ss.android.socialbase.downloader.impls.mq.d(true).d(1, bVarD.h());
                }
            } catch (Throwable unused) {
            }
        }
        d(bVarD.h(), zNf);
        return com.ss.android.socialbase.downloader.impls.mq.d(zNf);
    }

    public void c(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.d(i);
    }

    public void b(int i, boolean z) {
        if (com.ss.android.socialbase.downloader.e.an.d()) {
            if (com.ss.android.socialbase.downloader.e.d.d(8388608)) {
                e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(true);
                if (eVarD != null) {
                    eVarD.d(i, z);
                }
                e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(false);
                if (eVarD2 != null) {
                    eVarD2.d(i, z);
                    return;
                }
                return;
            }
            e eVarD3 = com.ss.android.socialbase.downloader.impls.mq.d(false);
            if (eVarD3 != null) {
                eVarD3.d(i, z);
            }
            e eVarD4 = com.ss.android.socialbase.downloader.impls.mq.d(true);
            if (eVarD4 != null) {
                eVarD4.d(i, z);
                return;
            }
            return;
        }
        e eVarB = b(i);
        if (eVarB != null) {
            eVarB.d(i, z);
        }
        com.ss.android.socialbase.downloader.impls.mq.d(true).d(2, i);
    }

    public boolean u(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return false;
        }
        return eVarB.hc(i);
    }

    public void an(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.b(i);
    }

    public void h(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.c(i);
    }

    public void b() {
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        if (eVarD != null) {
            eVarD.d();
        }
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        if (eVarD2 != null) {
            eVarD2.d();
        }
    }

    public int gb(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return 0;
        }
        return eVarB.an(i);
    }

    public boolean tt(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return false;
        }
        return eVarB.h(i);
    }

    public com.ss.android.socialbase.downloader.h.b tc(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return null;
        }
        return eVarB.gb(i);
    }

    public int d(String str, String str2) {
        return b.d(str, str2);
    }

    public com.ss.android.socialbase.downloader.h.b hc(String str, String str2) {
        int iD = d(str, str2);
        e eVarB = b(iD);
        if (eVarB == null) {
            return null;
        }
        return eVarB.gb(iD);
    }

    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        List<com.ss.android.socialbase.downloader.h.b> listD = com.ss.android.socialbase.downloader.impls.mq.d(false).d(str);
        List<com.ss.android.socialbase.downloader.h.b> listD2 = com.ss.android.socialbase.downloader.impls.mq.d(true).d(str);
        if (listD == null && listD2 == null) {
            return null;
        }
        if (listD == null || listD2 == null) {
            return listD != null ? listD : listD2;
        }
        ArrayList arrayList = new ArrayList(listD);
        arrayList.addAll(listD2);
        return arrayList;
    }

    public s mk(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return null;
        }
        return eVarB.w(i);
    }

    public ba mq(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return null;
        }
        return eVarB.yo(i);
    }

    private List<com.ss.android.socialbase.downloader.h.b> d(List<com.ss.android.socialbase.downloader.h.b> list, List<com.ss.android.socialbase.downloader.h.b> list2, SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.ss.android.socialbase.downloader.h.b bVar : list) {
                if (bVar != null && sparseArray.get(bVar.h()) == null) {
                    sparseArray.put(bVar.h(), bVar);
                }
            }
        }
        if (list2 != null) {
            for (com.ss.android.socialbase.downloader.h.b bVar2 : list2) {
                if (bVar2 != null && sparseArray.get(bVar2.h()) == null) {
                    sparseArray.put(bVar2.h(), bVar2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray = new SparseArray<>();
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        List<com.ss.android.socialbase.downloader.h.b> listB = eVarD != null ? eVarD.b(str) : null;
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        return d(listB, eVarD2 != null ? eVarD2.b(str) : null, sparseArray);
    }

    public void d(List<String> list) {
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        if (eVarD != null) {
            eVarD.d(list);
        }
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        if (eVarD2 != null) {
            eVarD2.d(list);
        }
    }

    public void hc(List<String> list) {
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        if (eVarD != null) {
            eVarD.hc(list);
        }
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        if (eVarD2 != null) {
            eVarD2.hc(list);
        }
    }

    public void c(int i, boolean z) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.hc(i, z);
    }

    public void d(int i, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.hc(i, vvVar == null ? 0 : vvVar.hashCode(), vvVar, gbVar, z);
    }

    public void hc(int i, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.d(i, vvVar.hashCode(), vvVar, gbVar, z);
    }

    public void d(int i, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z, boolean z2) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.d(i, vvVar.hashCode(), vvVar, gbVar, z, z2);
    }

    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        e eVarB;
        if (bVar == null || (eVarB = b(bVar.h())) == null) {
            return false;
        }
        return eVarB.d(bVar);
    }

    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray = new SparseArray<>();
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        List<com.ss.android.socialbase.downloader.h.b> listC = eVarD != null ? eVarD.c(str) : null;
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        return d(listC, eVarD2 != null ? eVarD2.c(str) : null, sparseArray);
    }

    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray = new SparseArray<>();
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(false);
        List<com.ss.android.socialbase.downloader.h.b> listU = eVarD != null ? eVarD.u(str) : null;
        e eVarD2 = com.ss.android.socialbase.downloader.impls.mq.d(true);
        return d(listU, eVarD2 != null ? eVarD2.u(str) : null, sparseArray);
    }

    public void d(final com.ss.android.socialbase.downloader.h.c cVar) {
        final e eVarHc = hc(cVar);
        if (eVarHc == null) {
            if (cVar != null) {
                com.ss.android.socialbase.downloader.gb.d.d(cVar.u(), cVar.d(), new com.ss.android.socialbase.downloader.u.d(1003, "tryDownload but getDownloadHandler failed"), cVar.d() != null ? cVar.d().w() : 0);
            }
        } else if (cVar.hc()) {
            this.b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                @Override // java.lang.Runnable
                public void run() {
                    eVarHc.d(cVar);
                }
            }, 500L);
        } else {
            eVarHc.d(cVar);
        }
    }

    public boolean uo(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return false;
        }
        return eVarB.mq(i);
    }

    public void k(int i) {
        if (i == 0) {
            return;
        }
        hc(i, true);
        e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(true);
        if (eVarD == null) {
            return;
        }
        eVarD.startService();
    }

    public void d(com.ss.android.socialbase.downloader.c.mq mqVar) {
        b.d(mqVar);
    }

    public com.ss.android.socialbase.downloader.c.sy e(int i) {
        e eVarB = b(i);
        if (eVarB == null) {
            return null;
        }
        return eVarB.rf(i);
    }
}
