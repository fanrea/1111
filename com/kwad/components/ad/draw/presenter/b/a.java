package com.kwad.components.ad.draw.presenter.b;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private InterfaceC0407a gt;
    private b gu;
    private boolean gv = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0407a {
        void ba();
    }

    public interface b {
        boolean bb();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void aZ() {
        InterfaceC0407a interfaceC0407a;
        if (this.gv) {
            return;
        }
        this.gv = true;
        if (e.eP(this.mAdTemplate).status == 1 || e.eP(this.mAdTemplate).status == 2 || e.eP(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.gu;
        if ((bVar == null || !bVar.bb()) && (interfaceC0407a = this.gt) != null) {
            interfaceC0407a.ba();
        }
    }

    public final void a(InterfaceC0407a interfaceC0407a) {
        this.gt = interfaceC0407a;
    }

    public final void a(b bVar) {
        this.gu = bVar;
    }
}
