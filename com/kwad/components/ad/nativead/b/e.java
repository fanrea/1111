package com.kwad.components.ad.nativead.b;

import com.kwad.components.core.video.o;
import com.kwad.sdk.api.KsNativeAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ad.nativead.a.a {
    private boolean mIsPaused = false;
    private KsNativeAd.VideoPlayListener qH;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.qH = this.rg.qH;
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.e.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.qH != null) {
                    try {
                        e.this.qH.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (e.this.mIsPaused) {
                    e.this.mIsPaused = false;
                    if (e.this.qH != null) {
                        try {
                            e.this.qH.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.qH != null) {
                    try {
                        e.this.qH.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
                e.this.mIsPaused = true;
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
