package com.kwad.components.ct.tube.history.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.tube.history.a.a.a {
    private KSLinearLayout aWe;
    private final m awn = new m() { // from class: com.kwad.components.ct.tube.history.a.b.c.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            com.kwad.sdk.core.d.c.d("ChannelDetailItemVisiblePresenter", "onFirstVisible position =" + ((com.kwad.components.ct.tube.history.a.a.b) c.this.cdN).mCurrentPosition);
            com.kwad.components.ct.e.b.JK().a(((com.kwad.components.ct.tube.history.a.a.b) c.this.cdN).mSceneImpl, (TubeInfo) ((com.kwad.components.ct.tube.history.a.a.b) c.this.cdN).cdM);
        }
    };

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.ksad_tube_history_item_base);
        this.aWe = kSLinearLayout;
        kSLinearLayout.setViewVisibleListener(this.awn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aWe.setViewVisibleListener(null);
    }
}
