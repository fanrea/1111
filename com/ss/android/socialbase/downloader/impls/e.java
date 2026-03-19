package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.dc;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.mk;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e implements com.ss.android.socialbase.downloader.downloader.cb, com.ss.android.socialbase.downloader.downloader.e {
    private static final String d = "e";
    private com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> b;
    private com.ss.android.socialbase.downloader.downloader.e c = new cb();
    private volatile com.ss.android.socialbase.downloader.downloader.mk hc;

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
    }

    public e() {
        com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> wVarHe = com.ss.android.socialbase.downloader.downloader.b.he();
        this.b = wVarHe;
        wVarHe.d(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, boolean z) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean hc(int i) {
        if (this.hc == null) {
            return false;
        }
        try {
            return this.hc.hc(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void b(int i) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.b(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void c(int i) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.c(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d() {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public long u(int i) {
        if (this.hc == null) {
            return 0L;
        }
        try {
            return this.hc.u(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int an(int i) {
        if (this.hc == null) {
            return 0;
        }
        try {
            return this.hc.an(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean h(int i) {
        if (this.hc == null) {
            return false;
        }
        try {
            return this.hc.h(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        if (this.hc == null) {
            return this.c.gb(i);
        }
        try {
            return this.hc.gb(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        if (this.hc == null) {
            return this.c.d(str);
        }
        try {
            return this.hc.d(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.hc> tt(int i) {
        if (this.hc == null) {
            return this.c.tt(i);
        }
        try {
            return this.hc.tt(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int d(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.b.d(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public com.ss.android.socialbase.downloader.h.b hc(String str, String str2) {
        return gb(d(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        if (this.hc == null) {
            return this.c.hc(str);
        }
        try {
            return this.hc.hc(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        if (this.hc == null) {
            return this.c.b(str);
        }
        try {
            return this.hc.b(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> c() {
        if (this.hc == null) {
            return this.c.c();
        }
        try {
            return this.hc.hc();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(List<String> list) {
        if (this.hc == null) {
            this.c.d(list);
            return;
        }
        try {
            this.hc.d(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(List<String> list) {
        if (this.hc == null) {
            this.c.hc(list);
            return;
        }
        try {
            this.hc.hc(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, boolean z) {
        if (this.hc == null) {
            this.c.hc(i, z);
            return;
        }
        try {
            this.hc.hc(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void tc(int i) {
        if (this.hc == null) {
            this.c.tc(i);
            return;
        }
        try {
            this.hc.tc(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.hc(i, i2, com.ss.android.socialbase.downloader.e.h.d(vvVar, gbVar != com.ss.android.socialbase.downloader.hc.gb.SUB), gbVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z, boolean z2) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d(i, i2, com.ss.android.socialbase.downloader.e.h.d(vvVar, gbVar != com.ss.android.socialbase.downloader.hc.gb.SUB), gbVar.ordinal(), z, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d(i, i2, com.ss.android.socialbase.downloader.e.h.d(vvVar, gbVar != com.ss.android.socialbase.downloader.hc.gb.SUB), gbVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (this.hc == null) {
            return this.c.d(bVar);
        }
        try {
            this.hc.d(bVar);
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, Notification notification) {
        if (this.hc == null) {
            com.ss.android.socialbase.downloader.an.d.c(d, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.an.d.b(d, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.hc.d(i, notification);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(boolean z, boolean z2) {
        if (this.hc == null) {
            com.ss.android.socialbase.downloader.an.d.c(d, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.an.d.b(d, "aidlService.stopForeground");
        try {
            this.hc.d(z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean hc() {
        if (this.hc == null) {
            com.ss.android.socialbase.downloader.an.d.c(d, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.an.d.b(d, "aidlService.isServiceForeground");
        try {
            return this.hc.an();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean b() {
        return com.ss.android.socialbase.downloader.downloader.b.nv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        if (this.hc == null) {
            return this.c.c(str);
        }
        try {
            return this.hc.u(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> u(String str) {
        if (this.hc == null) {
            return null;
        }
        try {
            return this.hc.c(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> wVar;
        if (cVar == null || (wVar = this.b) == null) {
            return;
        }
        wVar.hc(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> wVar;
        if (cVar == null || (wVar = this.b) == null) {
            return;
        }
        wVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean mq(int i) {
        if (this.hc == null) {
            return false;
        }
        try {
            return this.hc.mk(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void mk(int i) {
        com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> wVar = this.b;
        if (wVar != null) {
            wVar.d(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.w<CSJIndependentProcessDownloadService> wVar = this.b;
        if (wVar != null) {
            wVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean u() {
        if (this.hc == null) {
            return this.c.u();
        }
        try {
            return this.hc.c();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.hc(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void b(int i, boolean z) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.c(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int uo(int i) {
        if (this.hc == null) {
            return com.ss.android.socialbase.downloader.downloader.c.d().hc(i);
        }
        try {
            return this.hc.uo(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        if (this.hc == null) {
            this.c.d(hcVar);
            return;
        }
        try {
            this.hc.d(hcVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean b(com.ss.android.socialbase.downloader.h.b bVar) {
        if (this.hc == null) {
            return this.c.b(bVar);
        }
        try {
            return this.hc.hc(bVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean k(int i) {
        if (this.hc == null) {
            return this.c.k(i);
        }
        try {
            return this.hc.k(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void e(int i) {
        if (this.hc == null) {
            this.c.e(i);
            return;
        }
        try {
            this.hc.e(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, long j) {
        if (this.hc == null) {
            this.c.d(i, i2, j);
            return;
        }
        try {
            this.hc.d(i, i2, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, int i3, long j) {
        if (this.hc == null) {
            this.c.d(i, i2, i3, j);
            return;
        }
        try {
            this.hc.d(i, i2, i3, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, int i3, int i4) {
        if (this.hc == null) {
            this.c.d(i, i2, i3, i4);
            return;
        }
        try {
            this.hc.d(i, i2, i3, i4);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean cb(int i) {
        if (this.hc == null) {
            return this.c.cb(i);
        }
        try {
            return this.hc.cb(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void an() {
        if (this.hc == null) {
            this.c.an();
            return;
        }
        try {
            this.hc.u();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        if (this.hc == null) {
            this.c.hc(i, list);
            return;
        }
        try {
            this.hc.d(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean h() {
        return this.hc != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(dc dcVar) {
        if (this.hc != null) {
            try {
                this.hc.d(com.ss.android.socialbase.downloader.e.h.d(dcVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2) {
        if (this.hc != null) {
            try {
                this.hc.d(i, i2);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public s w(int i) {
        if (this.hc == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.e.h.d(this.hc.w(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public ba yo(int i) {
        if (this.hc == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.e.h.d(this.hc.yo(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, s sVar) {
        if (this.hc != null) {
            try {
                this.hc.d(i, com.ss.android.socialbase.downloader.e.h.d(sVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public sy rf(int i) {
        if (this.hc == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.e.h.d(this.hc.rf(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.cb
    public void d(IBinder iBinder) {
        this.hc = mk.d.d(iBinder);
        if (com.ss.android.socialbase.downloader.e.an.d()) {
            d(new dc() { // from class: com.ss.android.socialbase.downloader.impls.e.1
                @Override // com.ss.android.socialbase.downloader.c.dc
                public void d(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc(i);
                        }
                    } else {
                        com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).d(i);
                        List<com.ss.android.socialbase.downloader.h.hc> listTt = mq.d(false).tt(i);
                        if (listTt != null) {
                            mq.d(true).d(i, com.ss.android.socialbase.downloader.e.an.d(listTt));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.cb
    public void gb() {
        this.hc = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, long j) {
        if (this.hc == null) {
            return;
        }
        try {
            this.hc.d(i, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
