package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private ViewGroup rE;
    private TextView rF;
    private MotionEvent rz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.rE = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.rF = (TextView) findViewById(R.id.ksad_h5_open);
        a(this.rE, "NativePlayEndH5Presenter: R.id.ksad_video_complete_h5_container is null");
        a(this.rF, "NativePlayEndH5Presenter: R.id.ksad_h5_open is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.h.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                h.this.fF();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                h.this.fG();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
        ViewGroup viewGroup = this.rE;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF() {
        try {
            this.rF.setText(com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(this.rg.mAdTemplate)));
            this.rE.setOnClickListener(this);
            this.rE.setOnTouchListener(this);
            this.rE.setVisibility(0);
            this.rF.setVisibility(0);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        try {
            this.rE.setVisibility(8);
            this.rF.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.rg.rn) {
            fK();
            notifyAdClick();
        }
    }

    private void fK() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.rg.mAdTemplate).aG(2).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.rg.mAdTemplate, 2, h.this.rg.rb.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        if (this.rE != null) {
            this.rg.qN.m(this.rE);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.rz = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            if (com.kwad.sdk.utils.b.a(this.rz, motionEvent)) {
                if (this.rg.rm && (motionEvent2 = this.rz) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, this.rg.mAdTemplate)) {
                    n(view);
                }
                z = true;
            }
            this.rz = null;
        }
        return z;
    }

    private void n(View view) {
        if (view == this.rE) {
            fH();
            notifyAdClick();
        }
    }

    private void fH() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.rg.mAdTemplate).b(this.rg.mApkDownloadHelper).A(this.rg.rh.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.rg.mAdTemplate, 153, h.this.rg.rb.getTouchCoords());
            }
        }));
    }
}
