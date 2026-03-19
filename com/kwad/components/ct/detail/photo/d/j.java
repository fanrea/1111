package com.kwad.components.ct.detail.photo.d;

import android.view.View;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends a<LinearLayout> {
    private com.kwad.components.ct.detail.photo.e.c asO;

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.asO = this.asK.asO;
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.asO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: Ae, reason: merged with bridge method [inline-methods] */
    public LinearLayout Ag() {
        return Af();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ct.detail.photo.e.c cVar = this.asO;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    private com.kwad.components.ct.detail.photo.newui.b.a Af() {
        com.kwad.components.ct.detail.photo.newui.b.a aVar = new com.kwad.components.ct.detail.photo.newui.b.a(getContext());
        aVar.setButtonImageResource(((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj().aqB);
        aVar.setButtonText("举报");
        return aVar;
    }
}
