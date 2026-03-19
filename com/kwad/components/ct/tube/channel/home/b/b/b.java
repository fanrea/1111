package com.kwad.components.ct.tube.channel.home.b.b;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.widget.KSRelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.channel.home.b.a.b {
    private TextView aVZ;
    private TextView aWa;
    private TextView aWc;
    private ImageView aWx;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_tube_cover_container);
        kSRelativeLayout.setRatio(1.33f);
        kSRelativeLayout.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 6.0f));
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_desc);
        this.aWx = (ImageView) findViewById(R.id.ksad_tube_cover);
        this.aWc = (TextView) findViewById(R.id.ksad_tube_play_count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        TubeInfo tubeInfo = (TubeInfo) ((com.kwad.components.ct.tube.channel.home.b.a.a) this.cdN).cdM;
        KSImageLoader.loadImage(this.aWx, tubeInfo.coverUrl, com.kwad.components.ct.tube.channel.detail.a.b.b.aWd);
        this.aVZ.setText(tubeInfo.name);
        this.aWa.setText(com.kwad.components.ct.tube.d.b.c(tubeInfo));
        String strAq = com.kwad.components.ct.tube.d.b.aq(tubeInfo.viewCount);
        if (tubeInfo.viewCountHide || TextUtils.isEmpty(strAq)) {
            this.aWc.setVisibility(8);
        } else {
            this.aWc.setText(strAq);
            this.aWc.setVisibility(0);
        }
        g.a(this.aVZ, Kj().aZq);
        g.a(this.aWa, Kj().aZr);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
