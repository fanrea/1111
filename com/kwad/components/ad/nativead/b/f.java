package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private TextView fR;
    private ImageView ik;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsAppDownloadListener rA = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.nativead.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.ry.setText(com.kwad.sdk.core.response.b.a.aH(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.ry.setText(com.kwad.sdk.core.response.b.a.cB(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.ry.setText(com.kwad.sdk.core.response.b.a.aH(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.ry.setText(com.kwad.sdk.core.response.b.a.ae(f.this.mAdInfo));
        }
    };
    private ViewGroup rx;
    private TextView ry;
    private MotionEvent rz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.rx = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.fR = (TextView) findViewById(R.id.ksad_app_name);
        this.ry = (TextView) findViewById(R.id.ksad_app_download);
        a(this.rx, "NativePlayEndAppPresenter: R.id.ksad_video_complete_app_container is null");
        a(this.ik, "NativePlayEndAppPresenter: R.id.ksad_app_icon is null");
        a(this.fR, "NativePlayEndAppPresenter: R.id.ksad_app_name is null");
        a(this.ry, "NativePlayEndAppPresenter: R.id.ksad_app_download is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.rg.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mApkDownloadHelper = this.rg.mApkDownloadHelper;
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.f.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                try {
                    f.this.fF();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                f.this.fG();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
        ViewGroup viewGroup = this.rx;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.rA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF() {
        KSImageLoader.loadAppIcon(this.ik, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.mAdTemplate, 12);
        this.fR.setText(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        this.ry.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.rA);
        }
        this.rx.setOnClickListener(this);
        this.rx.setOnTouchListener(this);
        this.rx.setVisibility(0);
        this.fR.setVisibility(0);
        this.ry.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        try {
            this.fR.setVisibility(8);
            this.ry.setVisibility(8);
            this.rx.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.rg.rn) {
            if (view == this.rx) {
                T(2);
                notifyAdClick();
            } else if (view == this.ry) {
                T(1);
                notifyAdClick();
            }
        }
    }

    private void T(int i) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).aG(i).b(this.mApkDownloadHelper).A((this.rg == null || this.rg.rh == null) ? 0L : this.rg.rh.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.f.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.rg.rb.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        if (this.rx != null) {
            this.rg.qN.m(this.rx);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.rz = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            if (com.kwad.sdk.utils.b.a(this.rz, motionEvent)) {
                if (this.rg.rm && com.kwad.sdk.utils.b.a(this.rz, motionEvent, this.mAdTemplate)) {
                    n(view);
                }
                z = true;
            }
            this.rz = null;
        }
        return z;
    }

    private void n(View view) {
        if (view == this.rx) {
            fH();
            notifyAdClick();
        }
    }

    private void fH() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.rg.mAdTemplate).b(this.rg.mApkDownloadHelper).A(this.rg.rh.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.f.4
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.rg.mAdTemplate, 153, f.this.rg.rb.getTouchCoords());
            }
        }));
    }
}
