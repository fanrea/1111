package com.kwad.components.ct.tube.panel.c;

import android.widget.TextView;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.panel.b.a {
    private TextView aXU;
    private TextView aXV;
    private TextView aXW;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aXU = (TextView) findViewById(R.id.ksad_tube_pannel_title_name);
        this.aXV = (TextView) findViewById(R.id.ksad_tube_pannel_title_dot);
        this.aXW = (TextView) findViewById(R.id.ksad_tube_pannel_title_episode_num);
    }

    @Override // com.kwad.components.ct.tube.panel.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        TubeEpisode tubeEpisode = this.aXj.aXQ.mTubeEpisode;
        this.aXU.setText(tubeEpisode.tubeInfo.name);
        this.aXW.setText(com.kwad.components.ct.tube.d.b.d(tubeEpisode.tubeInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
