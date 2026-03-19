package com.kwad.components.ad.draw.presenter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private ImageView fw;
    private com.kwad.sdk.core.response.model.b fx;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.this.fw.getVisibility() == 0) {
                b.this.fw.setVisibility(8);
            }
        }
    };
    private Runnable fy = new Runnable() { // from class: com.kwad.components.ad.draw.presenter.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.fw.getLayoutParams();
            int width2 = b.this.fx.getWidth();
            int height = b.this.fx.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.fw.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.fw.setLayoutParams(layoutParams);
                b.this.fw.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.fw.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.fw, b.this.fx.getUrl(), b.this.fm.mAdTemplate);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fw = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.b.a.bA(e.eP(this.fm.mAdTemplate));
        this.fx = bVarBA;
        if (TextUtils.isEmpty(bVarBA.getUrl())) {
            return;
        }
        getRootView().post(this.fy);
        this.fw.setVisibility(0);
        if (this.fm.fo != null) {
            this.fm.fo.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.fy);
        if (this.fm.fo != null) {
            this.fm.fo.a(this.mVideoPlayStateListener);
        }
    }
}
