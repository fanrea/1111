package com.kwad.components.ct.tube.channel.home.a.a.b;

import android.widget.TextView;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.channel.home.a.a.a.b {
    private TextView aVZ;
    private TextView aWa;
    private RoundAngleImageView aWb;
    private TextView aWs;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_history_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_history_desc);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_tube_history_cover);
        this.aWb = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 6.0f));
        this.aWs = (TextView) findViewById(R.id.ksad_tube_history_play_history);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        TubeInfo tubeInfo = (TubeInfo) ((com.kwad.components.ct.tube.channel.home.a.a.a.a) this.cdN).cdM;
        KSImageLoader.loadImage(this.aWb, tubeInfo.coverUrl, com.kwad.components.ct.tube.channel.detail.a.b.b.aWd);
        this.aVZ.setText(tubeInfo.name);
        this.aWa.setText(com.kwad.components.ct.tube.d.b.c(tubeInfo));
        this.aWs.setText(com.kwad.components.ct.tube.d.b.a(tubeInfo, false));
        g.a(this.aVZ, Kj().aZq);
        g.a(this.aWa, Kj().aZs);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
