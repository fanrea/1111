package com.kwad.components.ct.tube.channel.home.a.a.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.TubeChannelParam;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.widget.KSLinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.channel.home.a.a.a.b {
    TextView aVZ;
    TextView aWa;
    RoundAngleImageView aWb;
    KSLinearLayout aWr;
    TextView aWs;
    private TubeChannelParam aWt;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aWr = (KSLinearLayout) findViewById(R.id.ksad_tube_history_item_root);
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_history_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_history_desc);
        this.aWb = (RoundAngleImageView) findViewById(R.id.ksad_tube_history_cover);
        this.aWs = (TextView) findViewById(R.id.ksad_tube_history_play_history);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aWt = ((com.kwad.components.ct.tube.channel.home.a.a.a.a) this.cdN).aWo;
        this.aWr.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.channel.home.a.a.b.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.ct.tube.d.b.a(a.this.getActivity(), a.this.aWt.mEntryScene, a.this.aWt.mTubeParam, (TubeInfo) ((com.kwad.components.ct.tube.channel.home.a.a.a.a) a.this.cdN).cdM);
                com.kwad.components.ct.e.b.JK().b(((com.kwad.components.ct.tube.channel.home.a.a.a.a) a.this.cdN).mSceneImpl, (TubeInfo) ((com.kwad.components.ct.tube.channel.home.a.a.a.a) a.this.cdN).cdM);
            }
        });
    }
}
