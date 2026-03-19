package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.c.bc;
import com.ss.android.socialbase.downloader.c.fs;
import com.ss.android.socialbase.downloader.c.j;
import com.ss.android.socialbase.downloader.downloader.mk;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class uo extends mk.d {
    private static final String d = "uo";
    private final com.ss.android.socialbase.downloader.downloader.e hc = new cb(true);

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(com.ss.android.socialbase.downloader.h.d dVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.hc(com.ss.android.socialbase.downloader.e.h.d(dVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean hc(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.hc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void b(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void c(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public long u(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return 0L;
        }
        return eVar.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public int an(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return 0;
        }
        return eVar.an(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean h(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.h(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public com.ss.android.socialbase.downloader.h.b gb(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.gb(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.hc> tt(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.tt(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public int d(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return 0;
        }
        return eVar.d(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public com.ss.android.socialbase.downloader.h.b hc(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.hc(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.hc(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.u(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> hc() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void hc(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar != null) {
            eVar.hc(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void hc(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.hc(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void b(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.hc(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void tc(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.tc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2, com.ss.android.socialbase.downloader.c.tc tcVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.hc(i, i2, com.ss.android.socialbase.downloader.e.h.d(tcVar), com.ss.android.socialbase.downloader.e.an.u(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void hc(int i, int i2, com.ss.android.socialbase.downloader.c.tc tcVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2, com.ss.android.socialbase.downloader.e.h.d(tcVar), com.ss.android.socialbase.downloader.e.an.u(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2, com.ss.android.socialbase.downloader.c.tc tcVar, int i3, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2, com.ss.android.socialbase.downloader.e.h.d(tcVar), com.ss.android.socialbase.downloader.e.an.u(i3), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean an() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.hc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean b() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public List<com.ss.android.socialbase.downloader.h.b> u(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return eVar.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean mk(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.mq(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void mq(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.mk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean c() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void c(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.c.d().hc(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public int uo(int i) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.c.d().hc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(hcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.b(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean k(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.k(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void e(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2, int i3, int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public boolean cb(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return false;
        }
        return eVar.cb(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void u() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.an();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.hc(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(bc bcVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(com.ss.android.socialbase.downloader.e.h.d(bcVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public j w(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.e.h.d(eVar.w(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public fs yo(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.e.h.d(eVar.yo(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public void d(int i, j jVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return;
        }
        eVar.d(i, com.ss.android.socialbase.downloader.e.h.d(jVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mk
    public com.ss.android.socialbase.downloader.c.gb rf(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.hc;
        if (eVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.e.h.d(eVar.rf(i));
    }
}
