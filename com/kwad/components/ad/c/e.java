package com.kwad.components.ad.c;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.core.video.a implements cb.a {
    private View dB;
    private final cb dC;
    private final AtomicBoolean dD;
    private boolean dE;
    private boolean dF;
    private final KsAdVideoPlayConfig dG;

    public e(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.dC = new cb(this);
        this.dD = new AtomicBoolean(true);
        this.dF = true;
        this.dB = this;
        this.dG = ksAdVideoPlayConfig;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onAttachedToWindow");
        ae();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    private void ae() {
        if (this.dD.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewAttached");
            this.dC.sendEmptyMessage(1);
        }
    }

    private void af() {
        if (this.dD.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewDetached");
        this.dC.removeCallbacksAndMessages(null);
        if (this.dF) {
            release();
        } else {
            this.bIR.pause();
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (!this.abl && message.what == 1) {
            if (ca.v(this.dB, 30)) {
                if (!this.dE) {
                    ag();
                }
            } else {
                tQ();
            }
            this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ag() {
        if (this.bIR.isIdle()) {
            if (this.abA != null) {
                this.abA.onStart();
            }
            if (!ao.isNetworkConnected(this.mContext)) {
                tL();
                return;
            }
            tM();
            if (this.abl) {
                tP();
                this.bIR.start();
                return;
            }
            if (ah()) {
                tP();
                this.bIR.start();
                return;
            } else {
                if (this.abj) {
                    tP();
                    this.bIR.start();
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(60, 60);
                layoutParams.addRule(13, -1);
                this.rq.setVisibility(8);
                this.rp.setLayoutParams(layoutParams);
                tN();
                return;
            }
        }
        if (this.bIR.isPaused() || this.bIR.acO()) {
            tP();
            this.bIR.restart();
        }
    }

    private boolean ah() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dG;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ao.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return ao.isNetworkConnected(this.mContext);
                }
                return ao.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.ch(this.mAdInfo)) {
            return ao.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.ci(this.mAdInfo)) {
            return ao.isWifiConnected(this.mContext);
        }
        return false;
    }
}
