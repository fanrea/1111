package com.ss.android.socialbase.downloader.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends d {
    private static com.ss.android.socialbase.downloader.k.c hc;

    public static void b(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceCb = com.ss.android.socialbase.downloader.downloader.b.cb();
        if (executorServiceCb != null) {
            executorServiceCb.invokeAll(list);
        }
    }

    public static List<Future> c(List<Runnable> list) {
        ExecutorService executorServiceCb = com.ss.android.socialbase.downloader.downloader.b.cb();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceCb.submit(it.next()));
        }
        return arrayList;
    }

    public u() {
        hc = new com.ss.android.socialbase.downloader.k.c();
    }

    public static Runnable u(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceCb = com.ss.android.socialbase.downloader.downloader.b.cb();
                if ((executorServiceCb instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceCb).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.an.d.c("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public boolean d(int i) {
        com.ss.android.socialbase.downloader.h.b bVarC;
        com.ss.android.socialbase.downloader.k.c cVar = hc;
        if (cVar == null || !cVar.d(i) || (bVarC = c(i)) == null) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.hc.an.hc(bVarC.w())) {
            return true;
        }
        hc(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public void d(com.ss.android.socialbase.downloader.k.b bVar) {
        com.ss.android.socialbase.downloader.k.c cVar = hc;
        if (cVar == null) {
            return;
        }
        cVar.hc(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public void d(int i, com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        hc.d(new com.ss.android.socialbase.downloader.k.b(cVar, this.d));
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public void hc(int i) {
        com.ss.android.socialbase.downloader.k.c cVar = hc;
        if (cVar == null) {
            return;
        }
        cVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    protected com.ss.android.socialbase.downloader.k.b b(int i) {
        com.ss.android.socialbase.downloader.k.c cVar = hc;
        if (cVar == null) {
            return null;
        }
        return cVar.hc(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public List<Integer> d() {
        return hc.d();
    }

    @Override // com.ss.android.socialbase.downloader.impls.d
    public void d(int i, long j) {
        com.ss.android.socialbase.downloader.k.c cVar = hc;
        if (cVar == null) {
            return;
        }
        cVar.d(i, j);
    }
}
