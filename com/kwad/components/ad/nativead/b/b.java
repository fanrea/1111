package com.kwad.components.ad.nativead.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.nativead.a.a {
    private ImageView fw;
    private com.kwad.sdk.core.response.model.b fx;
    private Runnable fy = new Runnable() { // from class: com.kwad.components.ad.nativead.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.a.a.f(b.this.fw, b.this.fx.getWidth(), b.this.fx.getHeight());
            b.this.fw.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.fw, b.this.fx.getUrl(), b.this.rg.mAdTemplate);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fw = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.b.a.bA(com.kwad.sdk.core.response.b.e.eP(this.rg.mAdTemplate));
        this.fx = bVarBA;
        if (TextUtils.isEmpty(bVarBA.getUrl())) {
            return;
        }
        getRootView().post(this.fy);
        this.fw.setVisibility(0);
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.b.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (b.this.fw.getVisibility() == 0) {
                    b.this.fw.setVisibility(8);
                }
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.fy);
    }
}
