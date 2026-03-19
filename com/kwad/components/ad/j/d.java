package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d implements h.a {
    private static volatile d NM;

    public static d nK() {
        if (NM == null) {
            synchronized (d.class) {
                if (NM == null) {
                    NM = new d();
                }
            }
        }
        return NM;
    }

    private d() {
    }

    public final void init() {
        h.aap().a(this);
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        if ((fVar instanceof com.kwad.components.core.request.a) && i != e.bCy.errorCode) {
            int i2 = 21004;
            SceneImpl scene = fVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i == e.bCt.errorCode) {
                    i2 = 21001;
                } else if (i == e.bCx.errorCode) {
                    i2 = 21003;
                } else if (i > 0 && i < 1000) {
                    i2 = 21002;
                }
                com.kwad.components.core.q.a.ss().c(posId, i2);
            }
        }
    }
}
