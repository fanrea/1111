package com.kwad.components.ad.nativead.b;

import android.widget.ImageView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ad.nativead.a.a {
    private ImageView rC;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_cover_image);
        this.rC = imageView;
        a(imageView, "NativePlayEndCoverPresenter R.id.ksad_video_cover_image is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.g.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                g.this.fI();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                g.this.fJ();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
        this.rC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI() {
        KSImageLoader.loadImage(this.rC, com.kwad.sdk.core.response.b.a.Y(com.kwad.sdk.core.response.b.e.eP(this.rg.mAdTemplate)), this.rg.mAdTemplate);
        this.rC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ() {
        if (this.rC.getVisibility() == 0) {
            this.rC.setVisibility(8);
        }
    }
}
