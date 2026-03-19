package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class h {
    private ThreadPoolExecutor bgX;
    private int bgZ;
    private SparseArray<DownloadLaunchRunnable> bgW = new SparseArray<>();
    private final String bgY = "Network";
    private int bha = 0;

    h(int i) {
        this.bgX = com.kwad.framework.filedownloader.f.b.G(i, "Network");
        this.bgZ = i;
    }

    public final synchronized boolean dz(int i) {
        if (OQ() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int iDN = com.kwad.framework.filedownloader.f.e.dN(i);
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.bgZ), Integer.valueOf(iDN));
        }
        List<Runnable> listShutdownNow = this.bgX.shutdownNow();
        this.bgX = com.kwad.framework.filedownloader.f.b.G(iDN, "Network");
        if (listShutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(listShutdownNow.size()));
        }
        this.bgZ = iDN;
        return true;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.NI();
        synchronized (this) {
            this.bgW.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.bgX.execute(downloadLaunchRunnable);
        int i = this.bha;
        if (i >= 600) {
            OP();
            this.bha = 0;
        } else {
            this.bha = i + 1;
        }
    }

    public final void cancel(int i) {
        OP();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.bgW.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean zRemove = this.bgX.remove(downloadLaunchRunnable);
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(zRemove));
                }
            }
            this.bgW.remove(i);
        }
    }

    private synchronized void OP() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.bgW.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = this.bgW.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.bgW.get(iKeyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(iKeyAt, downloadLaunchRunnable);
            }
        }
        this.bgW = sparseArray;
    }

    public final boolean dM(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.bgW.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int p(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.bgW.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable downloadLaunchRunnableValueAt = this.bgW.valueAt(i2);
            if (downloadLaunchRunnableValueAt != null && downloadLaunchRunnableValueAt.isAlive() && downloadLaunchRunnableValueAt.getId() != i && str.equals(downloadLaunchRunnableValueAt.NN())) {
                return downloadLaunchRunnableValueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int OQ() {
        OP();
        return this.bgW.size();
    }

    public final synchronized List<Integer> OR() {
        ArrayList arrayList;
        OP();
        arrayList = new ArrayList();
        for (int i = 0; i < this.bgW.size(); i++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.bgW;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }
}
