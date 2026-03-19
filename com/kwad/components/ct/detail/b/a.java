package com.kwad.components.ct.detail.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private ImageView fw;
    private CtAdTemplate mAdTemplate;
    private Runnable fy = new Runnable() { // from class: com.kwad.components.ct.detail.b.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.aop.aoy == null || !a.this.aop.aoy.isAdded() || a.this.aop.aoy.getActivity() == null) {
                return;
            }
            int width = a.this.getRootView().getWidth();
            int height = a.this.getRootView().getHeight();
            com.kwad.sdk.core.response.model.b bVarF = com.kwad.components.ct.response.a.a.f(a.this.mAdTemplate, com.kwad.components.ct.a.b.xj());
            ViewGroup.LayoutParams layoutParams = a.this.fw.getLayoutParams();
            int width2 = bVarF.getWidth();
            int height2 = bVarF.getHeight();
            if (width2 == 0 || height2 == 0) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.fw.setLayoutParams(layoutParams);
                a.this.fw.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if (com.kwad.components.ct.response.a.c.a(null, width, height, a.this.mAdTemplate.photoInfo.videoInfo)) {
                ViewGroup.LayoutParams layoutParams2 = a.this.fw.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.fw.setLayoutParams(layoutParams2);
                a.this.fw.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height2 / (width2 * 1.0f)) * width);
                a.this.fw.setLayoutParams(layoutParams);
                a.this.fw.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            final String url = bVarF.getUrl();
            try {
                com.kwad.sdk.glide.c.h(a.this.aop.aoy).hh(url).a(new com.kwad.components.ct.b.a(url, a.this.mAdTemplate)).b(new h<Drawable>() { // from class: com.kwad.components.ct.detail.b.a.1.1
                    @Override // com.kwad.sdk.glide.request.h
                    public final /* bridge */ /* synthetic */ boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                        return false;
                    }

                    @Override // com.kwad.sdk.glide.request.h
                    public final boolean a(GlideException glideException) {
                        com.kwad.components.ct.e.b.JK().a(a.this.aop.mAdTemplate, url);
                        return false;
                    }
                }).b(a.this.fw);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.a.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            a.this.fw.setVisibility(0);
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.a.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.fw.getVisibility() == 0) {
                a.this.fw.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fw = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aop.mAdTemplate;
        getRootView().post(this.fy);
        this.aop.aoq.add(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.c(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        View rootView = getRootView();
        if (rootView != null) {
            rootView.removeCallbacks(this.fy);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.fy);
        this.aop.aoq.remove(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
        }
        if (this.aop.aoy == null || this.fw == null) {
            return;
        }
        com.kwad.sdk.glide.c.h(this.aop.aoy).ac(this.fw);
        com.kwad.sdk.core.d.c.d("DetailFirstFramePresenter", "[WEBP]Glide clear(mFirstFrameView);");
    }
}
