package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private final e.b bgp;
    private final List<a> bgr = new ArrayList();

    g(int i, e.b bVar) {
        this.bgp = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.bgr.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.bgr) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.bgr.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.bgs.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    Iterator<a> it2 = this.bgr.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.bgs.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (size == 0 || next2.bgs.size() < size) {
                            size = next2.bgs.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.dD(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }

    public class a {
        private final List<Integer> bgs = new ArrayList();
        private final Executor mExecutor;

        public a(int i) {
            this.mExecutor = com.kwad.framework.filedownloader.f.b.G(1, "Flow-" + i);
        }

        public final void dD(int i) {
            this.bgs.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.mExecutor.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.bgp.r(messageSnapshot);
                    try {
                        a.this.bgs.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
