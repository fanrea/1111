package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends KSFrameLayout {
    private KsDrawAd.AdInteractionListener eU;
    private com.kwad.sdk.core.j.b fa;
    private com.kwad.components.ad.draw.b.b fm;
    private boolean fn;
    private com.kwad.components.ad.draw.c.a fo;
    private com.kwad.components.core.widget.a.c gR;
    private ImageView hw;
    private long hx;
    private View.OnClickListener hy;
    private n hz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean mIsPaused;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;

    public b(Context context) {
        super(context);
        this.fn = false;
        this.hy = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.b.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.core.e.d.a.a(new a.C0469a(b.this.fm.mRootContainer.getContext()).aC(b.this.fm.mAdTemplate).b(b.this.fm.mApkDownloadHelper).aq(false).aG(3).a(new a.b() { // from class: com.kwad.components.ad.draw.view.b.2.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        b.this.notifyAdClick();
                    }
                }));
                b.this.bL();
            }
        };
        this.hz = new o() { // from class: com.kwad.components.ad.draw.view.b.3
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                b.this.hw.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                b.this.hw.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                b.this.hw.setVisibility(8);
                com.kwad.components.ad.draw.a.b.a(b.this.mAdTemplate, SystemClock.elapsedRealtime() - b.this.hx);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.ad.draw.a.b.a(b.this.mAdTemplate, SystemClock.elapsedRealtime() - b.this.hx, "what : " + i + " extra : " + i2);
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.hw = (ImageView) adBaseFrameLayout.findViewById(R.id.ksad_video_control_button);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, e.YP());
        this.mDetailVideoView.setOnClickListener(this.hy);
        this.hw.setOnClickListener(this.hy);
        final WeakReference weakReference = new WeakReference(m.fb(this.mContext));
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.components.ad.draw.view.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                b.this.bO();
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL() {
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            if (3 == com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.eP(this.fm.mAdTemplate))) {
                bM();
            }
        } else if (1 == com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.eP(this.fm.mAdTemplate))) {
            bM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.fm.mRootContainer.getTouchCoords()).eP(85), (JSONObject) null);
        if (this.fm.eU != null) {
            this.fm.eU.onAdClicked();
        }
        if (this.fn) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.draw.a.c.b(adTemplate, 1, com.kwad.sdk.core.response.b.b.dB(adTemplate) ? 2 : 1);
        this.fn = true;
    }

    private void bM() {
        this.fo.g(!this.mIsPaused);
        if (!this.mIsPaused) {
            this.fo.pause();
        } else {
            this.fo.resume();
        }
        this.mIsPaused = !this.mIsPaused;
    }

    public final void setVideoSound(boolean z) {
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar != null) {
            aVar.setVideoSound(z);
        }
    }

    public final void play() {
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar == null || aVar.bw()) {
            return;
        }
        this.fo.gX = 1;
        this.fo.g(false);
        this.fo.resume();
    }

    public final void pause() {
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar == null || aVar.bw()) {
            return;
        }
        this.fo.gX = 2;
        this.fo.g(true);
        this.fo.pause();
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.fa = bVar;
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.eU = adInteractionListener;
    }

    public final void l(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.gR = new com.kwad.components.ad.draw.b(this);
        com.kwad.components.ad.draw.a.b.h(this.mAdTemplate);
        this.hx = SystemClock.elapsedRealtime();
        this.fo = new com.kwad.components.ad.draw.c.a(this.mAdTemplate, this.gR, this.mDetailVideoView);
        bN();
    }

    private void bN() {
        this.fm = bH();
        Presenter presenterBI = bI();
        this.mPresenter = presenterBI;
        presenterBI.ak(this.mRootContainer);
        this.mPresenter.K(this.fm);
        this.gR.a(this.fa);
        this.gR.wK();
        this.fo.bt();
        this.fo.b(this.hz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO() {
        com.kwad.components.core.widget.a.c cVar = this.gR;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar != null) {
            aVar.bv();
            this.fo.a(this.hz);
        }
        com.kwad.components.ad.draw.b.b bVar = this.fm;
        if (bVar != null) {
            bVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    private com.kwad.components.ad.draw.b.b bH() {
        com.kwad.components.ad.draw.b.b bVar = new com.kwad.components.ad.draw.b.b();
        bVar.eU = this.eU;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        bVar.fo = this.fo;
        bVar.fr = new com.kwad.components.ad.draw.presenter.b.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.b.di(this.mAdTemplate)) {
            bVar.fs = new com.kwad.components.ad.l.b();
        }
        return bVar;
    }

    private Presenter bI() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ad.draw.presenter.a.a());
        presenter.d(new com.kwad.components.ad.draw.presenter.b());
        presenter.d(new com.kwad.components.ad.draw.presenter.d());
        presenter.d(new com.kwad.components.ad.draw.presenter.c());
        presenter.d(new com.kwad.components.ad.draw.presenter.b.b());
        if (com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate)) {
            presenter.d(new com.kwad.components.ad.draw.presenter.b.c());
        }
        presenter.d(new com.kwad.components.ad.draw.presenter.c.a());
        if (com.kwad.sdk.core.response.b.b.di(this.mAdTemplate)) {
            presenter.d(new com.kwad.components.ad.draw.presenter.c.b());
        }
        if (com.kwad.sdk.core.response.b.a.aT(this.mAdInfo)) {
            presenter.d(new com.kwad.components.ad.draw.presenter.a());
        }
        return presenter;
    }

    public final void bP() {
        com.kwad.components.ad.draw.c.a aVar = this.fo;
        if (aVar != null) {
            aVar.gW = false;
        }
    }
}
