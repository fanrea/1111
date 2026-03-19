package com.kwad.components.ct.horizontal.video.b.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.video.b.a.a.a implements View.OnClickListener {
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        getRootView().setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.cdN == 0 || ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb == null || ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.aLD == null) {
            return;
        }
        ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.aLD.aOJ.A((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM);
        By();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().c((CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM, ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).aPb.mAdTemplate);
    }
}
