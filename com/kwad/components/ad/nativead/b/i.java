package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private DetailVideoView mDetailVideoView;
    private MotionEvent rz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.i.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(this);
            this.mDetailVideoView.setOnTouchListener(this);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(null);
            this.mDetailVideoView.setOnTouchListener(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.rg.rn && view == this.mDetailVideoView) {
            fK();
            notifyAdClick();
        }
    }

    private void fK() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.rg.mAdTemplate).b(this.rg.mApkDownloadHelper).A(this.rg.rh.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.rg.mAdTemplate, 2, i.this.rg.rb.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.rg.qN.m(this.mDetailVideoView);
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
        if (view == this.mDetailVideoView) {
            fH();
            notifyAdClick();
        }
    }

    private void fH() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.rg.mAdTemplate).b(this.rg.mApkDownloadHelper).A(this.rg.rh.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.rg.mAdTemplate, 153, i.this.rg.rb.getTouchCoords());
            }
        }));
    }
}
