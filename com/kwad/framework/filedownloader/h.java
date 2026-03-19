package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    private final ArrayList<a.InterfaceC0551a> bdz;

    /* synthetic */ h(byte b) {
        this();
    }

    static final class a {
        private static final h bdA = new h(0);
    }

    public static h MM() {
        return a.bdA;
    }

    private h() {
        this.bdz = new ArrayList<>();
    }

    final int size() {
        return this.bdz.size();
    }

    final int db(int i) {
        int i2;
        synchronized (this.bdz) {
            Iterator<a.InterfaceC0551a> it = this.bdz.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().da(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    final List<a.InterfaceC0551a> dc(int i) {
        byte bMg;
        ArrayList arrayList = new ArrayList();
        synchronized (this.bdz) {
            Iterator<a.InterfaceC0551a> it = this.bdz.iterator();
            while (it.hasNext()) {
                a.InterfaceC0551a next = it.next();
                if (next.da(i) && !next.isOver() && (bMg = next.Mo().Mg()) != 0 && bMg != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    final List<a.InterfaceC0551a> dd(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.bdz) {
            Iterator<a.InterfaceC0551a> it = this.bdz.iterator();
            while (it.hasNext()) {
                a.InterfaceC0551a next = it.next();
                if (next.da(i) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    final boolean a(a.InterfaceC0551a interfaceC0551a) {
        return this.bdz.isEmpty() || !this.bdz.contains(interfaceC0551a);
    }

    final void W(List<a.InterfaceC0551a> list) {
        synchronized (this.bdz) {
            Iterator<a.InterfaceC0551a> it = this.bdz.iterator();
            while (it.hasNext()) {
                a.InterfaceC0551a next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.bdz.clear();
        }
    }

    public final boolean a(a.InterfaceC0551a interfaceC0551a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bMg = messageSnapshot.Mg();
        synchronized (this.bdz) {
            zRemove = this.bdz.remove(interfaceC0551a);
        }
        if (com.kwad.framework.filedownloader.f.d.bhj && this.bdz.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0551a, Byte.valueOf(bMg), Integer.valueOf(this.bdz.size()));
        }
        if (zRemove) {
            t tVarME = interfaceC0551a.Mp().ME();
            if (bMg == -4) {
                tVarME.l(messageSnapshot);
            } else if (bMg == -3) {
                tVarME.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bMg == -2) {
                tVarME.n(messageSnapshot);
            } else if (bMg == -1) {
                tVarME.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0551a, Byte.valueOf(bMg));
        }
        return zRemove;
    }

    final void b(a.InterfaceC0551a interfaceC0551a) {
        if (!interfaceC0551a.Mo().LZ()) {
            interfaceC0551a.Mr();
        }
        if (interfaceC0551a.Mp().ME().MR()) {
            c(interfaceC0551a);
        }
    }

    final void c(a.InterfaceC0551a interfaceC0551a) {
        if (interfaceC0551a.Ms()) {
            return;
        }
        synchronized (this.bdz) {
            if (this.bdz.contains(interfaceC0551a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0551a);
            } else {
                interfaceC0551a.Mt();
                this.bdz.add(interfaceC0551a);
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0551a, Byte.valueOf(interfaceC0551a.Mo().Mg()), Integer.valueOf(this.bdz.size()));
                }
            }
        }
    }
}
