package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.e implements com.kwad.sdk.core.j.c {
    private ViewGroup Kk;
    private ImageView Kl;
    private SplashEndLandView Km;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        initView();
        this.HX.Hk.a(this);
        com.kwad.sdk.core.adlog.c.d(this.HX.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(87).eY(6));
        mK();
        mL();
    }

    private void mK() {
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HX.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.1
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void j(int i, String str) {
                    d.this.ad(str);
                }
            };
            if (this.HX.mApkDownloadHelper != null) {
                this.HX.mApkDownloadHelper.b(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(String str) {
        SplashEndLandView splashEndLandView = this.Km;
        if (splashEndLandView == null || str == null) {
            return;
        }
        splashEndLandView.ad(str);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SplashEndLandView splashEndLandView = this.Km;
        if (splashEndLandView != null) {
            splashEndLandView.mM();
        }
        this.HX.Hk.b(this);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.Kk = (ViewGroup) viewStub.inflate();
        } else {
            this.Kk = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        boolean zDB = com.kwad.sdk.core.response.b.a.dB(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate));
        if (zDB) {
            this.Kk.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.Kk.getWidth();
                    d.this.Km.a(d.this.HX.mAdTemplate, d.this.HX.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.Kk.getHeight()) / 414.0f);
                }
            });
        }
        this.Kl = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
        this.Km = splashEndLandView;
        splashEndLandView.t(zDB);
        this.Km.a(this.HX.mAdTemplate, this.HX.mApkDownloadHelper, 1.0f);
    }

    private void mL() {
        this.Kk.setVisibility(0);
        a(this.Kl, com.kwad.sdk.core.response.b.a.aY(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate)).materialUrl, this.HX.mAdTemplate);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        SplashEndLandView splashEndLandView = this.Km;
        if (splashEndLandView != null) {
            splashEndLandView.by();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        SplashEndLandView splashEndLandView = this.Km;
        if (splashEndLandView != null) {
            splashEndLandView.bz();
        }
    }
}
