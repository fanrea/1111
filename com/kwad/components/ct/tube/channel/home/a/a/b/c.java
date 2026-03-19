package com.kwad.components.ct.tube.channel.home.a.a.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.tube.channel.home.a.a.a.b {
    TextView aVZ;
    TextView aWa;
    RoundAngleImageView aWb;
    TextView aWc;
    KSLinearLayout aWr;
    private final m awn = new m() { // from class: com.kwad.components.ct.tube.channel.home.a.a.b.c.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            c.this.Kp();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aWr = (KSLinearLayout) findViewById(R.id.ksad_tube_history_item_root);
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_history_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_history_desc);
        this.aWb = (RoundAngleImageView) findViewById(R.id.ksad_tube_history_cover);
        this.aWc = (TextView) findViewById(R.id.ksad_tube_history_play_history);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aWr.setViewVisibleListener(this.awn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aWr.setViewVisibleListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Kp() {
        com.kwad.sdk.core.d.c.d("TubeItemShowPresenter", "TubeInfo visible position =" + ((com.kwad.components.ct.tube.channel.home.a.a.a.a) this.cdN).mCurrentPosition);
        com.kwad.components.ct.e.b.JK().a(((com.kwad.components.ct.tube.channel.home.a.a.a.a) this.cdN).mSceneImpl, (TubeInfo) ((com.kwad.components.ct.tube.channel.home.a.a.a.a) this.cdN).cdM);
    }
}
