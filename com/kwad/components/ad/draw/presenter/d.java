package com.kwad.components.ad.draw.presenter;

import android.widget.TextView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.draw.b.a {
    private TextView fL;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.d.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            d.this.fL.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            d.this.fL.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            d.this.fL.setVisibility(0);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fL = (TextView) findViewById(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (!ao.isNetworkConnected(getContext())) {
            this.fL.setVisibility(0);
        } else {
            this.fL.setVisibility(8);
        }
        this.fm.fo.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fm.fo.a(this.mVideoPlayStateListener);
    }
}
