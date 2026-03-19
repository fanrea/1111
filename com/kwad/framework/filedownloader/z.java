package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0551a> bef = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.e
    public final void MH() {
        w wVarNh = r.Ne().Nh();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.bef) {
            List<a.InterfaceC0551a> list = (List) this.bef.clone();
            this.bef.clear();
            ArrayList arrayList = new ArrayList(wVarNh.Nl());
            for (a.InterfaceC0551a interfaceC0551a : list) {
                int iMq = interfaceC0551a.Mq();
                if (wVarNh.dj(iMq)) {
                    interfaceC0551a.Mo().LX().Mw();
                    if (!arrayList.contains(Integer.valueOf(iMq))) {
                        arrayList.add(Integer.valueOf(iMq));
                    }
                } else {
                    interfaceC0551a.Mu();
                }
            }
            wVarNh.X(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void MI() {
        if (MJ() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w wVarNh = r.Ne().Nh();
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.MM().size()));
            }
            if (h.MM().size() > 0) {
                synchronized (this.bef) {
                    h.MM().W(this.bef);
                    Iterator<a.InterfaceC0551a> it = this.bef.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    wVarNh.Nk();
                }
                r.Ne().Nf();
                return;
            }
            return;
        }
        if (h.MM().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.MM().size()));
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0551a interfaceC0551a) {
        return !this.bef.isEmpty() && this.bef.contains(interfaceC0551a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0551a interfaceC0551a) {
        if (this.bef.isEmpty()) {
            return;
        }
        synchronized (this.bef) {
            this.bef.remove(interfaceC0551a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0551a interfaceC0551a) {
        r.Ne();
        if (!r.Ng()) {
            synchronized (this.bef) {
                r.Ne();
                if (!r.Ng()) {
                    if (com.kwad.framework.filedownloader.f.d.bhj) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0551a.Mo().getId()));
                    }
                    n.MW().aR(com.kwad.framework.filedownloader.f.c.OV());
                    if (!this.bef.contains(interfaceC0551a)) {
                        interfaceC0551a.free();
                        this.bef.add(interfaceC0551a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0551a);
        return false;
    }
}
