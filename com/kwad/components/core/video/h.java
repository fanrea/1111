package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.core.video.a implements cb.a {
    private boolean JQ;
    private boolean acG;
    private boolean acH;
    private View dB;
    private final cb dC;
    private final AtomicBoolean dD;

    public interface a extends a.c {
        void onVideoPlayError(int i, int i2);
    }

    public h(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.dC = new cb(this);
        this.dD = new AtomicBoolean(true);
        this.JQ = false;
        this.acG = false;
        this.acH = false;
        this.dB = this;
    }

    public final h aY(boolean z) {
        this.acG = true;
        return this;
    }

    public final void setShowLandingPage(boolean z) {
        this.acH = z;
    }

    @Override // com.kwad.components.core.video.a
    protected final void tK() {
        super.tK();
        if (this.rp != null) {
            this.rp.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        if (this.rq != null) {
            this.rq.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.kwad.components.core.video.a
    protected final void fF() {
        if (this.acG) {
            super.fF();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        uu();
        ae();
    }

    private void uu() {
        this.JQ = false;
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    private void ae() {
        if (this.dD.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.dC.sendEmptyMessage(1);
        }
    }

    private void af() {
        if (this.dD.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.dC.removeCallbacksAndMessages(null);
        release();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.JQ = true;
    }

    @Override // com.kwad.components.core.video.a
    public final void ag() {
        super.ag();
    }

    @Override // com.kwad.components.core.video.a
    public final void tQ() {
        super.tQ();
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (!this.JQ && message.what == 1) {
            if (this.acH) {
                this.dC.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (ca.v(this.dB, 70)) {
                ag();
            } else {
                tQ();
            }
            this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
