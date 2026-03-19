package com.ss.android.socialbase.appdownloader.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.b.gb;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.rf;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.impls.yo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements k {
    private List<Integer> d;
    private BroadcastReceiver hc;

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<String> d() {
        return b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(final List<com.ss.android.socialbase.downloader.h.b> list, final int i) throws JSONException {
        if (an.c()) {
            com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.hc.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hc.this.hc(list, i);
                    } catch (Exception e) {
                        mq.d(e);
                    }
                }
            });
        } else {
            hc(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(List<com.ss.android.socialbase.downloader.h.b> list, int i) throws JSONException {
        if (list == null || list.isEmpty()) {
            return;
        }
        c.mk();
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        if (contextTr == null) {
            return;
        }
        boolean zHc = an.hc(contextTr);
        Iterator<com.ss.android.socialbase.downloader.h.b> it = list.iterator();
        while (it.hasNext()) {
            d(contextTr, it.next(), zHc, i);
        }
        List<Integer> list2 = this.d;
        if (list2 == null || list2.isEmpty() || this.hc != null) {
            return;
        }
        this.hc = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.c.hc.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (an.hc(applicationContext)) {
                    com.ss.android.socialbase.downloader.an.d.hc("LaunchResume", "onReceive : wifi connected !!!");
                    com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.hc.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (hc.this.d != null && !hc.this.d.isEmpty()) {
                                    int size = hc.this.d.size();
                                    Integer[] numArr = new Integer[size];
                                    hc.this.d.toArray(numArr);
                                    hc.this.d.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        com.ss.android.socialbase.downloader.h.b bVarGb = h.hc(applicationContext).gb(numArr[i2].intValue());
                                        if (bVarGb != null && (bVarGb.v() == -5 || (bVarGb.v() == -2 && bVarGb.xp()))) {
                                            hc.this.d(applicationContext, bVarGb, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                mq.d(e);
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(hc.this.hc);
                    } catch (Throwable th) {
                        mq.d(th);
                    }
                    hc.this.hc = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextTr.registerReceiver(this.hc, intentFilter);
        } catch (Throwable th) {
            mq.d(th);
            this.hc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, com.ss.android.socialbase.downloader.h.b bVar, boolean z, int i) throws JSONException {
        boolean z2;
        if (bVar == null || !bVar.ox()) {
            return;
        }
        int iV = bVar.v();
        if (iV == -5 && ("application/ttpatch".equalsIgnoreCase(bVar.hg()) || !bVar.g())) {
            com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
            int iD = dVarD.d("failed_resume_max_count", 0);
            double d = dVarD.d("failed_resume_max_hours", 72.0d);
            double d2 = dVarD.d("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (bVar.xp() && z) ? true : bVar.hu() < iD && ((double) (jCurrentTimeMillis - bVar.ka())) < d * 3600000.0d && ((double) (jCurrentTimeMillis - bVar.jg())) > d2 * 3600000.0d;
            if (z3) {
                boolean z4 = dVarD.d("failed_resume_need_wifi", 1) == 1;
                boolean z5 = dVarD.d("failed_resume_need_wait_wifi", 0) == 1;
                if (z || !z4 || !z5) {
                    b.d(bVar, true, z4);
                    bVar.tt(jCurrentTimeMillis);
                    bVar.mk(bVar.hu() + 1);
                    bVar.ri();
                    if (bVar.xp() && z) {
                        bVar.u(true);
                        rf rfVarCb = c.mk().cb();
                        if (rfVarCb != null) {
                            rfVarCb.d(bVar, 5, i);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    int iH = bVar.h();
                    if (!this.d.contains(Integer.valueOf(iH))) {
                        this.d.add(Integer.valueOf(iH));
                    }
                    bVar.c(true);
                    yo.d().d(bVar);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            com.ss.android.socialbase.downloader.an.d.b("LaunchResume", "launchResume, name = " + bVar.tt() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            gb gbVarE = c.mk().e();
            if (gbVarE != null) {
                gbVarE.d(bVar, z2);
                return;
            }
            return;
        }
        if (iV == -3 && d(bVar)) {
            com.ss.android.socialbase.downloader.uo.d dVarD2 = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
            if (b.d(context, bVar)) {
                return;
            }
            int iD2 = dVarD2.d("uninstall_resume_max_count", 0);
            double d3 = dVarD2.d("uninstall_resume_max_hours", 72.0d);
            double d4 = dVarD2.d("uninstall_resume_min_hours", 12.0d);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            boolean z6 = bVar.tb() < iD2 && ((double) (jCurrentTimeMillis2 - bVar.ka())) < d3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - bVar.x())) > d4 * 3600000.0d;
            com.ss.android.socialbase.downloader.an.d.b("LaunchResume", "uninstallResume, name = " + bVar.tt() + ", canShowNotification = " + z6);
            if (z6) {
                com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
                if (dVarU == null) {
                    dVarU = new com.ss.android.socialbase.appdownloader.u.d(context, bVar.h(), bVar.tt(), bVar.mk(), bVar.gb(), bVar.s());
                    com.ss.android.socialbase.downloader.notification.hc.d().d(dVarU);
                } else {
                    dVarU.d(bVar);
                }
                dVarU.hc(bVar.mb());
                dVarU.d(bVar.mb());
                dVarU.d(bVar.w(), null, false, false);
                bVar.tc(jCurrentTimeMillis2);
                bVar.mq(bVar.tb() + 1);
                bVar.ri();
                return;
            }
            return;
        }
        if (iV == -2) {
            if (bVar.xp()) {
                if (z) {
                    b.d(bVar, true, true);
                    bVar.ri();
                    bVar.u(true);
                    gb gbVarE2 = c.mk().e();
                    if (gbVarE2 != null) {
                        gbVarE2.d(bVar, true);
                    }
                    rf rfVarCb2 = c.mk().cb();
                    if (rfVarCb2 != null) {
                        rfVarCb2.d(bVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                int iH2 = bVar.h();
                if (!this.d.contains(Integer.valueOf(iH2))) {
                    this.d.add(Integer.valueOf(iH2));
                }
                yo.d().d(bVar);
            }
            d(bVar, context);
        }
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar, Context context) throws JSONException {
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
        int iD = dVarD.d("paused_resume_max_count", 0);
        double d = dVarD.d("paused_resume_max_hours", 72.0d);
        int iQa = bVar.qa();
        if (iQa < iD && ((double) (System.currentTimeMillis() - bVar.ka())) < d * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
            if (dVarU == null) {
                dVarU = new com.ss.android.socialbase.appdownloader.u.d(context, bVar.h(), bVar.tt(), bVar.mk(), bVar.gb(), bVar.s());
                com.ss.android.socialbase.downloader.notification.hc.d().d(dVarU);
            } else {
                dVarU.d(bVar);
            }
            dVarU.hc(bVar.mb());
            dVarU.d(bVar.js());
            dVarU.d(bVar.w(), null, false, false);
            bVar.w(iQa + 1);
            bVar.ri();
        }
    }

    private boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).hc("uninstall_can_not_resume_for_force_task", false)) {
            return an.d(bVar, false, bVar.fs());
        }
        return bVar.g();
    }
}
