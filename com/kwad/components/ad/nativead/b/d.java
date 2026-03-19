package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.nativead.a.a {
    private View ru;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ru = findViewById(R.id.ksad_video_network_unavailable);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (ao.isNetworkConnected(this.ru.getContext())) {
            this.ru.setVisibility(8);
            return;
        }
        this.ru.setVisibility(0);
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.d.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.fE();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.fE();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE() {
        if (this.ru.getVisibility() != 0) {
            return;
        }
        this.ru.setVisibility(8);
    }
}
