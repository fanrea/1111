package com.kwad.components.ct.horizontal.video;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public d aOH = new d() { // from class: com.kwad.components.ct.horizontal.video.e.1
        @Override // com.kwad.components.ct.horizontal.video.d
        public final void update() {
            Iterator it = e.this.aOI.iterator();
            while (it.hasNext()) {
                ((d) it.next()).update();
            }
        }
    };
    private List<d> aOI = new ArrayList();
    public c aOJ = new c() { // from class: com.kwad.components.ct.horizontal.video.e.2
        @Override // com.kwad.components.ct.horizontal.video.c
        public final void A(CtAdTemplate ctAdTemplate) {
            if (ctAdTemplate == null) {
                return;
            }
            Iterator it = e.this.aOK.iterator();
            while (it.hasNext()) {
                ((c) it.next()).A(ctAdTemplate);
            }
        }
    };
    private List<c> aOK = new ArrayList();

    public final void a(d dVar) {
        this.aOI.add(dVar);
    }

    public final void b(d dVar) {
        this.aOI.remove(dVar);
    }

    public final void a(c cVar) {
        this.aOK.add(cVar);
    }

    public final void b(c cVar) {
        this.aOK.remove(cVar);
    }

    public final void release() {
        this.aOK.clear();
    }
}
