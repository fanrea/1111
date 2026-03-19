package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.socialbase.downloader.d.d;
import com.ss.android.socialbase.downloader.downloader.rf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class yo implements Handler.Callback, d.InterfaceC0785d {
    private static volatile yo d;
    private static hc tt;
    private long an;
    private ConnectivityManager gb;
    private final boolean u;
    private final Handler b = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<d> c = new SparseArray<>();
    private int h = 0;
    private final Context hc = com.ss.android.socialbase.downloader.downloader.b.tr();

    public interface hc {
        void d(com.ss.android.socialbase.downloader.h.b bVar, long j, boolean z, int i);
    }

    private yo() {
        an();
        this.u = com.ss.android.socialbase.downloader.e.an.b();
        com.ss.android.socialbase.downloader.d.d.d().d(this);
    }

    public static yo d() {
        if (d == null) {
            synchronized (yo.class) {
                if (d == null) {
                    d = new yo();
                }
            }
        }
        return d;
    }

    public static void d(hc hcVar) {
        tt = hcVar;
    }

    private void an() {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (yo.this.hc == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    yo yoVar = yo.this;
                    yoVar.gb = (ConnectivityManager) yoVar.hc.getApplicationContext().getSystemService("connectivity");
                    yo.this.gb.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.yo.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            com.ss.android.socialbase.downloader.an.d.hc("RetryScheduler", "network onAvailable: ");
                            yo.this.d(1, true);
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        });
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.hc.u.d) || !com.ss.android.socialbase.downloader.hc.u.d.equals(bVar.hg())) {
            return;
        }
        d(bVar, bVar.np() || bVar.xp(), h());
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z, int i) {
        com.ss.android.socialbase.downloader.u.d dVarLt = bVar.lt();
        if (dVarLt == null) {
            return;
        }
        d dVarHc = hc(bVar.h());
        if (dVarHc.tt > dVarHc.b) {
            com.ss.android.socialbase.downloader.an.d.c("RetryScheduler", "tryStartScheduleRetry, id = " + dVarHc.d + ", mRetryCount = " + dVarHc.tt + ", maxCount = " + dVarHc.b);
            return;
        }
        int iD = dVarLt.d();
        if (!com.ss.android.socialbase.downloader.e.an.gb(dVarLt) && !com.ss.android.socialbase.downloader.e.an.tt(dVarLt) && (!bVar.ra() || !bVar.xp())) {
            if (!d(dVarHc, iD)) {
                return;
            } else {
                com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "allow error code, id = " + dVarHc.d + ", error code = " + iD);
            }
        }
        dVarHc.tc = z;
        synchronized (this.c) {
            if (!dVarHc.mq) {
                dVarHc.mq = true;
                this.h++;
            }
        }
        int iC = dVarHc.c();
        com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "tryStartScheduleRetry: id = " + dVarHc.d + ", delayTimeMills = " + iC + ", mWaitingRetryTasks = " + this.h);
        if (!dVarHc.an) {
            if (z) {
                return;
            }
            this.b.removeMessages(bVar.h());
            this.b.sendEmptyMessageDelayed(bVar.h(), iC);
            return;
        }
        if (i == 0) {
            dVarHc.b();
        }
        hc hcVar = tt;
        if (hcVar != null) {
            hcVar.d(bVar, iC, z, i);
        }
        if (this.u) {
            dVarHc.d(System.currentTimeMillis());
            dVarHc.hc();
            dVarHc.d();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            hc(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            d(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z) {
        if (this.h <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.an < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return;
                }
            }
            this.an = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.b.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z ? 1 : 0;
            this.b.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    private void hc(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.2
            @Override // java.lang.Runnable
            public void run() {
                int iH;
                try {
                    if (yo.this.h > 0 && (iH = yo.this.h()) != 0) {
                        com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + yo.this.h);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (yo.this.c) {
                            for (int i2 = 0; i2 < yo.this.c.size(); i2++) {
                                d dVar = (d) yo.this.c.valueAt(i2);
                                if (dVar != null && dVar.d(jCurrentTimeMillis, i, iH, z)) {
                                    if (z) {
                                        dVar.b();
                                    }
                                    arrayList.add(dVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                yo.this.d(((d) it.next()).d, iH, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void d(final int i) {
        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    yo yoVar = yo.this;
                    yoVar.d(i, yoVar.h(), true);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, boolean z) {
        rf rfVarHc;
        boolean zD;
        Context context = this.hc;
        if (context == null) {
            return;
        }
        synchronized (this.c) {
            d dVar = this.c.get(i);
            if (dVar == null) {
                return;
            }
            boolean z2 = true;
            if (dVar.mq) {
                dVar.mq = false;
                int i3 = this.h - 1;
                this.h = i3;
                if (i3 < 0) {
                    this.h = 0;
                }
            }
            com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + dVar.tt + ", mWaitingRetryTasksCount = " + this.h);
            com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(i);
            if (bVarGb == null) {
                b(i);
                return;
            }
            com.ss.android.socialbase.downloader.an.d.u("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int iV = bVarGb.v();
            if (iV == -3 || iV == -4) {
                b(i);
                return;
            }
            if (iV == -5 || (iV == -2 && bVarGb.xp())) {
                if (iV == -2 && (rfVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc()) != null) {
                    rfVarHc.d(bVarGb, 4, 3);
                }
                com.ss.android.socialbase.downloader.downloader.k kVarV = com.ss.android.socialbase.downloader.downloader.b.v();
                if (kVarV != null) {
                    kVarV.d(Collections.singletonList(bVarGb), 3);
                }
                b(i);
                return;
            }
            if (iV != -1) {
                return;
            }
            if (i2 != 0) {
                zD = true;
            } else if (!dVar.an) {
                return;
            } else {
                zD = false;
            }
            com.ss.android.socialbase.downloader.u.d dVarLt = bVarGb.lt();
            if (zD && com.ss.android.socialbase.downloader.e.an.gb(dVarLt)) {
                zD = d(bVarGb, dVarLt);
            }
            dVar.hc();
            if (zD) {
                com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + dVar.d);
                dVar.d(System.currentTimeMillis());
                if (z) {
                    dVar.d();
                }
                bVarGb.hc(dVar.tt);
                if (bVarGb.w() == -1) {
                    com.ss.android.socialbase.downloader.downloader.h.hc(context).u(bVarGb.h());
                    return;
                }
                return;
            }
            if (z) {
                dVar.d();
            }
            if (!bVarGb.np() && !bVarGb.xp()) {
                z2 = false;
            }
            d(bVarGb, z2, i2);
        }
    }

    private boolean d(d dVar, int i) {
        int[] iArr = dVar.h;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private d hc(int i) {
        d dVarC = this.c.get(i);
        if (dVarC == null) {
            synchronized (this.c) {
                dVarC = this.c.get(i);
                if (dVarC == null) {
                    dVarC = c(i);
                }
                this.c.put(i, dVarC);
            }
        }
        return dVarC;
    }

    private void b(int i) {
        synchronized (this.c) {
            this.c.remove(i);
        }
    }

    private d c(int i) {
        int[] iArrD;
        int i2;
        int i3;
        boolean z;
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(i);
        boolean z2 = false;
        int iD = dVarD.d("retry_schedule", 0);
        JSONObject jSONObjectC = dVarD.c("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectC != null) {
            int iOptInt = jSONObjectC.optInt("max_count", 60);
            int iOptInt2 = jSONObjectC.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectC.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && tt != null && jSONObjectC.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrD = d(jSONObjectC.optString("allow_error_code"));
            i2 = iOptInt3;
            z = z2;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrD = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new d(i, iD, i3, i4 * 1000, i2 * 1000, z, iArrD);
    }

    private int[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void hc() {
        d(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void b() {
        d(3, false);
    }

    public void c() {
        d(2, true);
    }

    public void u() {
        d(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        try {
            if (this.gb == null) {
                this.gb = (ConnectivityManager) this.hc.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.gb.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        long jC;
        long jMb;
        try {
            jC = com.ss.android.socialbase.downloader.e.an.c(bVar.mq());
        } catch (com.ss.android.socialbase.downloader.u.d e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            jC = 0;
        }
        if (dVar instanceof com.ss.android.socialbase.downloader.u.u) {
            jMb = ((com.ss.android.socialbase.downloader.u.u) dVar).u();
        } else {
            jMb = bVar.mb() - bVar.js();
        }
        if (jC < jMb) {
            com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
            if (dVarD.d("space_fill_part_download", 0) == 1) {
                if (jC > 0) {
                    int iD = dVarD.d("space_fill_min_keep_mb", 100);
                    if (iD > 0) {
                        long j = jC - (iD * 1048576);
                        com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.e.an.d(jC) + "MB, minKeep = " + iD + "MB, canDownload = " + com.ss.android.socialbase.downloader.e.an.d(j) + "MB");
                        if (j <= 0) {
                            com.ss.android.socialbase.downloader.an.d.c("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (dVarD.d("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private static class d {
        final boolean an;
        final int b;
        final int c;
        final int d;
        private int gb;
        final int[] h;
        final int hc;
        private long mk;
        private boolean mq;
        private boolean tc;
        private int tt;
        final int u;

        d(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.d = i;
            this.hc = i2;
            this.b = i3;
            this.c = i4;
            this.u = i5;
            this.an = z;
            this.h = iArr;
            this.gb = i4;
        }

        boolean d(long j, int i, int i2, boolean z) {
            if (!this.mq) {
                com.ss.android.socialbase.downloader.an.d.b("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.hc < i || this.tt >= this.b) {
                return false;
            }
            if (!this.tc || i2 == 2) {
                return z || j - this.mk >= ((long) this.c);
            }
            return false;
        }

        synchronized void d() {
            this.gb += this.u;
        }

        synchronized void d(long j) {
            this.mk = j;
        }

        synchronized void hc() {
            this.tt++;
        }

        void b() {
            this.gb = this.c;
        }

        int c() {
            return this.gb;
        }
    }
}
