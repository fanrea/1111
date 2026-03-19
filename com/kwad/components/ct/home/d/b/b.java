package com.kwad.components.ct.home.d.b;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.home.d.a.a {
    private KSFrameLayout awm;
    private final m awn = new m() { // from class: com.kwad.components.ct.home.d.b.b.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            b.this.Bz();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awm = (KSFrameLayout) findViewById(R.id.ksad_slide_profile_container);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.awm.setViewVisibleListener(this.awn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awm.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Bz() {
        com.kwad.components.ct.e.b.JK().K((CtAdTemplate) ((com.kwad.components.ct.home.d.a.b) this.cdN).cdM);
    }
}
