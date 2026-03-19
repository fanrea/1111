package com.ss.android.socialbase.downloader.k;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static ExecutorService d = new com.bytedance.sdk.component.tc.c.c(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d("Download_OP_Thread"));
    private int b = 0;
    private volatile SparseArray<b> hc = new SparseArray<>();

    public void d(b bVar) {
        bVar.an();
        synchronized (c.class) {
            int i = this.b;
            if (i >= 500) {
                hc();
                this.b = 0;
            } else {
                this.b = i + 1;
            }
            this.hc.put(bVar.u(), bVar);
        }
        com.ss.android.socialbase.downloader.h.c cVarB = bVar.b();
        try {
            ExecutorService executorServiceE = com.ss.android.socialbase.downloader.downloader.b.e();
            if (cVarB != null && cVarB.d() != null) {
                if ("mime_type_plg".equals(cVarB.d().hg()) && com.ss.android.socialbase.downloader.uo.d.b().d("divide_plugin", 1) == 1) {
                    cVarB.d().d("executor_group", (Object) 3);
                }
                int iZg = cVarB.d().zg();
                if (iZg == 3) {
                    executorServiceE = com.ss.android.socialbase.downloader.downloader.b.uo();
                } else if (iZg == 4) {
                    executorServiceE = com.ss.android.socialbase.downloader.downloader.b.k();
                }
            }
            if (executorServiceE != null) {
                if (com.ss.android.socialbase.downloader.uo.d.d(bVar.u()).hc("pause_with_interrupt", false)) {
                    bVar.d(executorServiceE.submit(bVar));
                    return;
                } else {
                    executorServiceE.execute(bVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.gb.d.d(cVarB.u(), cVarB.d(), new com.ss.android.socialbase.downloader.u.d(1003, "execute failed cpu thread executor service is null"), cVarB.d() != null ? cVarB.d().w() : 0);
        } catch (Exception e) {
            if (cVarB != null) {
                com.ss.android.socialbase.downloader.gb.d.d(cVarB.u(), cVarB.d(), new com.ss.android.socialbase.downloader.u.d(1003, com.ss.android.socialbase.downloader.e.an.hc(e, "DownloadThreadPoolExecute")), cVarB.d() != null ? cVarB.d().w() : 0);
            }
            mq.d(e);
        } catch (OutOfMemoryError e2) {
            if (cVarB != null) {
                com.ss.android.socialbase.downloader.gb.d.d(cVarB.u(), cVarB.d(), new com.ss.android.socialbase.downloader.u.d(1003, "execute OOM"), cVarB.d() != null ? cVarB.d().w() : 0);
            }
            mq.d(e2);
        }
    }

    private void hc() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.hc.size(); i++) {
                int iKeyAt = this.hc.keyAt(i);
                if (!this.hc.get(iKeyAt).c()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.hc.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }

    public void hc(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (c.class) {
            try {
                if (com.ss.android.socialbase.downloader.e.d.d(524288)) {
                    int iIndexOfValue = this.hc.indexOfValue(bVar);
                    if (iIndexOfValue >= 0) {
                        this.hc.removeAt(iIndexOfValue);
                    }
                } else {
                    this.hc.remove(bVar.u());
                }
            } finally {
            }
        }
    }

    public boolean d(int i) {
        synchronized (c.class) {
            boolean z = false;
            if (this.hc != null && this.hc.size() > 0) {
                b bVar = this.hc.get(i);
                if (bVar != null && bVar.c()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public b hc(int i) {
        synchronized (c.class) {
            hc();
            b bVar = this.hc.get(i);
            if (bVar == null) {
                return null;
            }
            bVar.hc();
            b(bVar);
            this.hc.remove(i);
            return bVar;
        }
    }

    public void b(int i) {
        synchronized (c.class) {
            hc();
            b bVar = this.hc.get(i);
            if (bVar != null) {
                bVar.d();
                b(bVar);
                this.hc.remove(i);
            }
        }
    }

    private void b(b bVar) {
        Future futureH;
        if (bVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceE = com.ss.android.socialbase.downloader.downloader.b.e();
            com.ss.android.socialbase.downloader.h.c cVarB = bVar.b();
            if (cVarB != null && cVarB.d() != null) {
                int iZg = cVarB.d().zg();
                if (iZg == 3) {
                    executorServiceE = com.ss.android.socialbase.downloader.downloader.b.uo();
                } else if (iZg == 4) {
                    executorServiceE = com.ss.android.socialbase.downloader.downloader.b.k();
                }
            }
            if (executorServiceE == null || !(executorServiceE instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceE).remove(bVar);
            if (!com.ss.android.socialbase.downloader.uo.d.d(bVar.u()).hc("pause_with_interrupt", false) || (futureH = bVar.h()) == null) {
                return;
            }
            futureH.cancel(true);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public List<Integer> d() {
        ArrayList arrayList;
        synchronized (c.class) {
            hc();
            arrayList = new ArrayList();
            for (int i = 0; i < this.hc.size(); i++) {
                b bVar = this.hc.get(this.hc.keyAt(i));
                if (bVar != null) {
                    arrayList.add(Integer.valueOf(bVar.u()));
                }
            }
        }
        return arrayList;
    }

    public void d(int i, long j) {
        this.hc.get(i);
    }
}
