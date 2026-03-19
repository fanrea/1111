package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.hv;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.c.zw;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private static final String d = "an";
    private com.ss.android.socialbase.downloader.h.c an;
    private com.ss.android.socialbase.downloader.h.b b;
    private final mq c;
    private com.ss.android.socialbase.downloader.c.e cb;
    private long e;
    private SparseArray<vv> gb;
    private SparseArray<vv> h;
    private final boolean hc;
    private int k;
    private SparseArray<vv> tt;
    private final Handler u;
    private zw w;
    private boolean tc = false;
    private volatile long mk = 0;
    private final AtomicLong mq = new AtomicLong();
    private boolean uo = false;

    public an(com.ss.android.socialbase.downloader.h.c cVar, Handler handler) {
        this.an = cVar;
        tc();
        this.u = handler;
        this.c = b.np();
        com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
        if (bVarD != null) {
            this.hc = com.ss.android.socialbase.downloader.uo.d.d(bVarD.h()).d("fix_start_with_file_exist_update_error");
        } else {
            this.hc = false;
        }
    }

    private void tc() {
        com.ss.android.socialbase.downloader.h.c cVar = this.an;
        if (cVar != null) {
            this.b = cVar.d();
            this.h = this.an.d(com.ss.android.socialbase.downloader.hc.gb.MAIN);
            this.tt = this.an.d(com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION);
            this.gb = this.an.d(com.ss.android.socialbase.downloader.hc.gb.SUB);
            this.cb = this.an.c();
            this.w = this.an.u();
        }
    }

    public void d() {
        if (this.b.xi()) {
            return;
        }
        this.b.c(1);
        mk();
    }

    private void mk() {
        ExecutorService executorServiceMk = b.mk();
        if (executorServiceMk != null) {
            executorServiceMk.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.an.1
                @Override // java.lang.Runnable
                public void run() {
                    an.this.c.tt(an.this.b.h());
                    an.this.d(1, (com.ss.android.socialbase.downloader.u.d) null);
                }
            });
        }
    }

    public void hc() {
        if (this.b.xi()) {
            this.b.yb();
            return;
        }
        this.c.h(this.b.h());
        if (this.b.is()) {
            d(6, (com.ss.android.socialbase.downloader.u.d) null);
        }
        d(2, (com.ss.android.socialbase.downloader.u.d) null);
    }

    public void d(long j, String str, String str2) {
        this.b.h(j);
        this.b.u(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.b.gb())) {
            this.b.an(str2);
        }
        try {
            this.c.d(this.b.h(), j, str, str2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        d(3, (com.ss.android.socialbase.downloader.u.d) null);
        this.e = this.b.gb(j);
        this.k = this.b.vs();
        this.tc = true;
        com.ss.android.socialbase.downloader.impls.yo.d().u();
    }

    public boolean d(long j) {
        this.mq.addAndGet(j);
        this.b.an(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return d(jUptimeMillis, hc(jUptimeMillis));
    }

    public void b() {
        d(-4, (com.ss.android.socialbase.downloader.u.d) null);
    }

    public void c() {
        this.b.c(-2);
        try {
            this.c.c(this.b.h(), this.b.js());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        d(-2, (com.ss.android.socialbase.downloader.u.d) null);
    }

    public void u() {
        this.b.c(-7);
        try {
            this.c.tc(this.b.h());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        d(-7, (com.ss.android.socialbase.downloader.u.d) null);
    }

    public void d(com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        this.b.tt(false);
        this.mq.set(0L);
        hc(dVar, z);
    }

    public void d(com.ss.android.socialbase.downloader.h.hc hcVar, com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        this.b.tt(false);
        this.mq.set(0L);
        this.c.gb(this.b.h());
        d(z ? 10 : 9, dVar, true);
    }

    public void d(com.ss.android.socialbase.downloader.u.d dVar) {
        this.b.tt(false);
        hc(dVar);
    }

    private void hc(com.ss.android.socialbase.downloader.u.d dVar) {
        Log.getStackTraceString(new Throwable());
        if (dVar != null && dVar.getCause() != null && (dVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.c.an(this.b.h());
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        } else {
            try {
                try {
                    this.c.hc(this.b.h(), this.b.js());
                } catch (SQLiteException unused) {
                    this.c.an(this.b.h());
                }
            } catch (SQLiteException e2) {
                com.bytedance.sdk.component.utils.mq.d(e2);
            }
        }
        com.ss.android.socialbase.downloader.u.d dVarB = b(dVar);
        this.b.d(dVarB);
        d(dVarB instanceof com.ss.android.socialbase.downloader.u.an ? -2 : -1, dVarB);
        if (com.ss.android.socialbase.downloader.uo.d.d(this.b.h()).d("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.yo.d().d(this.b);
        }
    }

    private com.ss.android.socialbase.downloader.u.d b(com.ss.android.socialbase.downloader.u.d dVar) {
        Context contextTr;
        if (com.ss.android.socialbase.downloader.uo.d.d(this.b.h()).d("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.e.an.tt(dVar) || (contextTr = b.tr()) == null || com.ss.android.socialbase.downloader.e.an.b(contextTr)) {
            return dVar;
        }
        return new com.ss.android.socialbase.downloader.u.d(this.b.np() ? 1013 : 1049, dVar.hc());
    }

    public void an() {
        this.b.tt(false);
        if (!this.b.zv() && this.b.js() != this.b.mb()) {
            com.ss.android.socialbase.downloader.an.d.hc(d, this.b.c());
            d(new com.ss.android.socialbase.downloader.u.h(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.b.wb()));
            return;
        }
        if (this.b.js() <= 0) {
            com.ss.android.socialbase.downloader.an.d.hc(d, this.b.c());
            d(new com.ss.android.socialbase.downloader.u.h(1026, "curBytes is 0, bytes changed with process : " + this.b.wb()));
            return;
        }
        if (!this.b.zv() && this.b.mb() <= 0) {
            com.ss.android.socialbase.downloader.an.d.hc(d, this.b.c());
            d(new com.ss.android.socialbase.downloader.u.h(1044, "TotalBytes is 0, bytes changed with process : " + this.b.wb()));
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, this.b.gb() + " onCompleted start save file as target name");
        zw zwVarU = this.w;
        com.ss.android.socialbase.downloader.h.c cVar = this.an;
        if (cVar != null) {
            zwVarU = cVar.u();
        }
        com.ss.android.socialbase.downloader.e.an.d(this.b, zwVarU, new hv() { // from class: com.ss.android.socialbase.downloader.downloader.an.2
            @Override // com.ss.android.socialbase.downloader.c.hv
            public void d() {
                an.this.mq();
            }

            @Override // com.ss.android.socialbase.downloader.c.hv
            public void d(com.ss.android.socialbase.downloader.u.d dVar) {
                com.ss.android.socialbase.downloader.an.d.hc(an.d, "saveFileAsTargetName onFailed : " + (dVar != null ? dVar.hc() : ""));
                an.this.d(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq() {
        try {
            com.ss.android.socialbase.downloader.an.d.hc(d, "saveFileAsTargetName onSuccess");
            try {
                uo();
                this.b.tc(false);
                this.b.gb(false);
                d(-3, (com.ss.android.socialbase.downloader.u.d) null);
                this.c.b(this.b.h(), this.b.mb());
                this.c.c(this.b.h());
                this.c.uo(this.b.h());
            } catch (com.ss.android.socialbase.downloader.u.d e) {
                d(e);
            }
        } catch (Throwable th) {
            d(new com.ss.android.socialbase.downloader.u.d(1008, com.ss.android.socialbase.downloader.e.an.hc(th, "onCompleted")));
        }
    }

    public void h() throws com.ss.android.socialbase.downloader.u.d {
        if (this.hc) {
            uo();
            com.ss.android.socialbase.downloader.an.d.hc(d, "onCompleteForFileExist");
            this.b.gb(true);
            d(-3, (com.ss.android.socialbase.downloader.u.d) null);
            this.c.b(this.b.h(), this.b.mb());
            this.c.c(this.b.h());
            this.c.d(this.b);
            this.c.uo(this.b.h());
            return;
        }
        uo();
        com.ss.android.socialbase.downloader.an.d.hc(d, "onCompleteForFileExist");
        this.b.gb(true);
        d(-3, (com.ss.android.socialbase.downloader.u.d) null);
        this.c.b(this.b.h(), this.b.mb());
        this.c.c(this.b.h());
        this.c.uo(this.b.h());
    }

    public void d(String str) throws com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.an.d.hc(d, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.b.gb());
        if (this.hc) {
            com.ss.android.socialbase.downloader.e.an.d(this.b, str);
            uo();
            this.b.gb(true);
            d(-3, (com.ss.android.socialbase.downloader.u.d) null);
            this.c.d(this.b);
            return;
        }
        this.c.d(this.b);
        com.ss.android.socialbase.downloader.e.an.d(this.b, str);
        this.b.gb(true);
        uo();
        d(-3, (com.ss.android.socialbase.downloader.u.d) null);
    }

    private void uo() throws com.ss.android.socialbase.downloader.u.d {
        List<com.ss.android.socialbase.downloader.c.k> listSy = this.an.sy();
        if (listSy.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.h.b bVar = this.b;
        d(11, (com.ss.android.socialbase.downloader.u.d) null);
        this.c.d(bVar);
        for (com.ss.android.socialbase.downloader.c.k kVar : listSy) {
            try {
                if (kVar.hc(bVar)) {
                    kVar.d(bVar);
                    this.c.d(bVar);
                }
            } catch (com.ss.android.socialbase.downloader.u.d e) {
                throw e;
            } catch (Throwable th) {
                throw new com.ss.android.socialbase.downloader.u.d(1071, th);
            }
        }
    }

    private boolean d(long j, boolean z) {
        boolean z2 = false;
        if (this.b.js() == this.b.mb()) {
            try {
                this.c.d(this.b.h(), this.b.js());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            return false;
        }
        if (this.tc) {
            this.tc = false;
            this.b.c(4);
        }
        if (this.b.m() && z) {
            z2 = true;
        }
        d(4, (com.ss.android.socialbase.downloader.u.d) null, z2);
        return z;
    }

    private boolean hc(long j) {
        boolean z = true;
        if (!this.uo) {
            this.uo = true;
            return true;
        }
        long j2 = j - this.mk;
        if (this.mq.get() < this.e && j2 < this.k) {
            z = false;
        }
        if (z) {
            this.mk = j;
            this.mq.set(0L);
        }
        return z;
    }

    private void hc(com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        this.c.gb(this.b.h());
        d(z ? 7 : 5, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, com.ss.android.socialbase.downloader.u.d dVar) {
        d(i, dVar, true);
    }

    public void gb() {
        this.b.c(8);
        this.b.d(com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.d dVarJ = b.j();
        if (dVarJ != null) {
            dVarJ.d(this.b.h(), this.an.mq(), 8);
        }
    }

    private void d(int i, com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        SparseArray<vv> sparseArray;
        SparseArray<vv> sparseArray2;
        int iW = this.b.w();
        if (iW == -3 && i == 4) {
            return;
        }
        tc();
        if (i != 4 && com.ss.android.socialbase.downloader.hc.an.u(i)) {
            this.b.h(false);
            if (com.ss.android.socialbase.downloader.hc.an.c(i)) {
                this.b.t();
            }
        }
        if (!this.b.um()) {
            com.ss.android.socialbase.downloader.gb.d.d(this.an, dVar, i);
        }
        if (i == 6) {
            this.b.c(2);
        } else if (i == -6) {
            this.b.c(-3);
        } else {
            this.b.c(i);
        }
        if (iW == -3 || iW == -1) {
            if (this.b.eu() == com.ss.android.socialbase.downloader.hc.tt.DELAY_RETRY_DOWNLOADING) {
                this.b.d(com.ss.android.socialbase.downloader.hc.tt.DELAY_RETRY_DOWNLOADED);
            }
            if (this.b.qv() == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_DOWNLOADING) {
                this.b.d(com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.b.wb() == com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.b.d(com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.e.b.d(i, this.gb, true, this.b, dVar);
        if (i == -4) {
            return;
        }
        if (z && this.u != null && (((sparseArray = this.h) != null && sparseArray.size() > 0) || ((sparseArray2 = this.tt) != null && sparseArray2.size() > 0 && (this.b.tj() || this.b.p())))) {
            this.u.obtainMessage(i, this.b.h(), this.an.mq(), dVar).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.d dVarJ = b.j();
        if (dVarJ != null) {
            dVarJ.d(this.b.h(), this.an.mq(), i);
        }
    }
}
