package com.kwad.components.ad.splashscreen.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.presenter.playcard.SplashPlayDefaultInfoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends e {
    private ImageView HZ;
    private ImageView Ia;
    private int Id;
    private long If;
    private View Ig;
    private ViewGroup Ih;
    private SplashPlayDefaultInfoView Ii;
    private AdInfo mAdInfo;
    private boolean Ib = false;
    private boolean Ic = false;
    private int Ie = 1;
    Runnable Ij = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.5
        @Override // java.lang.Runnable
        public final void run() {
            h.this.mp();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Ig = findViewById(R.id.ksad_splash_root_container);
        this.Ia = (ImageView) findViewById(R.id.ksad_splash_background);
        this.HZ = (ImageView) findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        this.Ih = (ViewGroup) findViewById(R.id.ksad_splash_default_image_view_container);
        this.Ii = (SplashPlayDefaultInfoView) findViewById(R.id.ksad_splash_default_image_view);
        this.Id = com.kwad.components.ad.splashscreen.h.ad(this.HX.mAdTemplate) ? 2 : 1;
        String string = com.kwad.sdk.core.response.b.a.aY(this.mAdInfo).materialUrl;
        this.Ia.setVisibility(0);
        int i = com.kwad.sdk.core.response.b.a.aY(this.mAdInfo).source;
        mo();
        if (getContext() != null) {
            SplashPreloadManager.lH();
            File fileAc = SplashPreloadManager.ac(this.mAdInfo.adPreloadInfo.preloadId);
            if (fileAc != null && fileAc.exists() && fileAc.length() > 0) {
                this.Ie = 2;
                string = Uri.fromFile(fileAc).toString();
            }
            l(string, i);
        }
    }

    private void l(String str, int i) {
        if (i == 0) {
            this.HZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.HZ.setVisibility(0);
            KSImageLoader.loadImage(this.HZ, str, this.HX.mAdTemplate, new AnonymousClass1());
        } else {
            this.Ia.setVisibility(0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HH)) {
                a(this.Ia, this.mAdInfo);
            } else {
                a(this.Ia);
            }
            KSImageLoader.loadImage(this.Ia, str, this.HX.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    h.this.mp();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI)) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.md();
                        com.kwad.components.ad.splashscreen.monitor.b.a(h.this.HX.mAdTemplate, 2, h.this.Id, h.this.Ie, jElapsedRealtime - h.this.If, jElapsedRealtime - h.this.HX.mAdTemplate.showTime);
                    }
                    h.this.mq();
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1, reason: invalid class name */
    final class AnonymousClass1 implements ImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.mp();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI)) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.a(h.this.HX.mAdTemplate, 2, h.this.Id, h.this.Ie, jElapsedRealtime - h.this.If, jElapsedRealtime - h.this.HX.mAdTemplate.showTime);
            }
            h.this.mq();
            h.this.Ia.setVisibility(0);
            GlobalThreadPools.ace().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap bitmapStackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Ia.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            h.this.Ia.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), bitmapStackBlur));
                        }
                    });
                }
            });
        }
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.HX.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo cutRuleInfoCH = com.kwad.sdk.core.response.b.a.cH(adInfo);
        imageView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.h.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = com.kwad.sdk.core.response.b.a.aY(adInfo).width;
                double d2 = cutRuleInfoCH.picHeight;
                double d3 = cutRuleInfoCH.viewTopMargin;
                double d4 = cutRuleInfoCH.safeAreaHeight;
                if (d2 <= 0.0d || d4 <= 0.0d) {
                    return;
                }
                double d5 = width / d;
                double d6 = d3 / (d2 - d4);
                double d7 = d3 * d5;
                double d8 = (d2 * d5) - height;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d8 / 2.0d) - (d7 - (d7 - (d6 * d8)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.HX.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.h.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f2 = width * 2340.0f;
                float height = imageView.getHeight();
                float f3 = (f2 - height) / 2.0f;
                float f4 = f2 - f;
                float f5 = (0.44107744f * f4) - f3;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f4 * 0.5589225f) - f3) - f5) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void mo() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI)) {
            this.If = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.e(this.HX.mAdTemplate, 2, this.Id);
            bx.runOnUiThreadDelay(this.Ij, com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp() {
        if (this.Ib) {
            return;
        }
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.b(this.HX.mAdTemplate, 2, this.Id, this.Ie, jElapsedRealtime - this.If, jElapsedRealtime - this.HX.mAdTemplate.showTime);
        }
        this.Ib = true;
        this.Ig.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.6
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Ih.setVisibility(0);
                h.this.Ii.a(h.this.HX.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Ig.getHeight()) / 414.0f);
            }
        });
        this.HZ.setVisibility(8);
        this.Ia.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        mq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq() {
        if (this.Ic) {
            return;
        }
        this.Ic = true;
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI)) {
            bx.d(this.Ij);
        }
    }
}
