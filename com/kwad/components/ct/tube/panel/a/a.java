package com.kwad.components.ct.tube.panel.a;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final List<com.kwad.components.ct.api.tube.a> aXI;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.aXI = new ArrayList();
    }

    /* renamed from: com.kwad.components.ct.tube.panel.a.a$a, reason: collision with other inner class name */
    static class C0539a {
        private static final a aXM = new a(0);
    }

    public static a KH() {
        return C0539a.aXM;
    }

    public final void a(com.kwad.components.ct.api.tube.a aVar) {
        if (aVar != null) {
            this.aXI.add(aVar);
        }
    }

    public final void b(com.kwad.components.ct.api.tube.a aVar) {
        this.aXI.remove(aVar);
    }

    public final void c(final List<CtAdTemplate> list, final TubeEpisode tubeEpisode) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.tube.panel.a.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                Iterator it = a.this.aXI.iterator();
                while (it.hasNext()) {
                    ((com.kwad.components.ct.api.tube.a) it.next()).a(list, tubeEpisode);
                }
            }
        });
    }
}
