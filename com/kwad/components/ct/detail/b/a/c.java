package com.kwad.components.ct.detail.b.a;

import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.photo.newui.MarqueeView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bq;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private MarqueeView ayJ;
    private a ayK;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f11if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.a.c.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            c.this.Ct();
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.a.c.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            c.this.Cs();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            c.this.Ct();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            c.this.Cs();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) findViewById(R.id.ksad_bottom_marquee_tip);
        this.ayJ = marqueeView;
        marqueeView.setSelected(true);
        this.ayJ.setTextColor(-65538);
        this.ayJ.setTextSpeed(3.0f);
        this.ayJ.setTextSize(14.0f);
        this.ayJ.setRepetType(2);
        this.ayJ.setStartLocationDistance(0.0f);
        this.ayK = new a(this.ayJ, (byte) 0);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aop.mAdTemplate;
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        String strAR = com.kwad.components.ct.response.a.a.aR(this.mAdTemplate);
        if (bq.isNullString(strAR) && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            strAR = getContext().getString(R.string.ksad_ad_default_author);
        }
        if (bq.isNullString(strAR) || com.kwad.components.ct.response.a.c.o(com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))) {
            this.ayJ.setVisibility(8);
        } else {
            this.ayJ.setContent(strAR);
            this.ayJ.setVisibility(0);
            this.ayJ.setSelected(true);
            this.ayJ.setOnClickListener(this);
        }
        this.aop.aoz.c(this.mVideoPlayStateListener);
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ayJ.removeCallbacks(this.ayK);
        this.aop.aoz.d(this.mVideoPlayStateListener);
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        a aVar = this.ayK;
        if (aVar != null) {
            this.ayJ.removeCallbacks(aVar);
            this.ayJ.postDelayed(this.ayK, 200L);
        }
    }

    static class a implements Runnable {
        private WeakReference<MarqueeView> abc;

        /* synthetic */ a(MarqueeView marqueeView, byte b) {
            this(marqueeView);
        }

        private a(MarqueeView marqueeView) {
            this.abc = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public final void run() {
            MarqueeView marqueeView = this.abc.get();
            if (marqueeView != null) {
                marqueeView.Ao();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ct() {
        this.ayJ.Ap();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            handleAdClick();
        }
    }

    private void handleAdClick() {
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            com.kwad.components.ct.e.b.JK().b(this.aop.mAdTemplate, 1);
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).aq(false).aF(25).d(this.f11if.getTouchCoords()).as(true));
    }
}
