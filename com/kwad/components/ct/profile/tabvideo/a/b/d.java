package com.kwad.components.ct.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.profile.tabvideo.a.a.a {
    private View aRW;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRW = findViewById(R.id.ksad_profile_watched_tip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (com.kwad.components.ct.response.a.a.bg((CtAdTemplate) ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).cdM) == ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).aRU.mCurrentPhotoId) {
            this.aRW.setVisibility(0);
        } else {
            this.aRW.setVisibility(8);
        }
    }
}
