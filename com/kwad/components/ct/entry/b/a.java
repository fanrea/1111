package com.kwad.components.ct.entry.b;

import android.view.View;
import com.kwad.components.ct.entry.view.d;
import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.mvp.a {
    public com.kwad.components.ct.response.model.a.a aCR;
    public List<d.a> aDp = new ArrayList();
    public CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void p(View view, int i) {
        if (this.aDp.isEmpty()) {
            return;
        }
        for (d.a aVar : this.aDp) {
            if (aVar != null) {
                aVar.q(view, 1);
            }
        }
    }
}
