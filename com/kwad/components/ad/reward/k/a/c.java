package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.sdk.components.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.d.c implements e {
    private a CH;

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    public final i jc() {
        this.CH = (a) this.ajp;
        return new d(this.CH.kw(), this.CH.CF, getContext());
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.CH;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.CH;
        if (aVar2 == null || aVar2.kw() == null) {
            return;
        }
        this.CH.kw().tt.db();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.ic());
                c.this.a(bVar2);
            }
        }));
        tVar.c(new j(new p() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.hZ().ia());
                    com.kwad.components.ad.reward.c.a.hZ().a(jVar);
                }
            }
        }));
    }
}
