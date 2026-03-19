package com.kwad.components.core.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends a implements cb.a {
    private View dB;
    private final cb dC;
    private final AtomicBoolean dD;
    private boolean dE;
    private boolean dF;
    private final KsAdVideoPlayConfig dG;

    public f(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
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
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ae();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    private void ae() {
        if (this.dD.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewAttached");
            this.dC.sendEmptyMessage(1);
        }
    }

    public final void af() {
        if (this.dD.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewDetached");
        this.dC.removeCallbacksAndMessages(null);
        if (this.dF) {
            release();
        } else {
            this.bIR.pause();
        }
    }

    public final void uo() {
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
    protected final void ag() {
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
            } else if (ah()) {
                tP();
                this.bIR.start();
                return;
            } else if (this.abj) {
                tP();
                this.bIR.start();
                return;
            } else {
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
        if (com.kwad.sdk.core.response.b.a.cl(this.mAdInfo)) {
            return ao.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.cm(this.mAdInfo)) {
            return ao.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.components.core.video.a
    protected final void fF() {
        try {
            this.abB = com.kwad.sdk.p.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, null);
            LinearLayout linearLayout = (LinearLayout) this.abB.findViewById(R.id.ksad_video_complete_app_container);
            this.EZ = (ImageView) this.abB.findViewById(R.id.ksad_video_complete_app_icon);
            this.Fa = (TextView) this.abB.findViewById(R.id.ksad_app_name);
            this.abx = (TextView) this.abB.findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.EZ, com.kwad.sdk.core.response.b.e.bf(this.mAdTemplate), this.mAdTemplate, 12);
            this.Fa.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
            this.abx.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
            this.abw = linearLayout;
            this.EZ.setOnClickListener(this);
            this.Fa.setOnClickListener(this);
            this.abx.setOnClickListener(this);
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper.b(this.abC);
            if (up()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.EZ.getLayoutParams();
                layoutParams.width = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                this.EZ.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Fa.getLayoutParams();
                layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
                this.Fa.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.abx.getLayoutParams();
                layoutParams3.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 26.0f);
                layoutParams3.height = com.kwad.sdk.c.a.a.a(this.mContext, 32.0f);
                layoutParams3.width = com.kwad.sdk.c.a.a.a(this.mContext, 72.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#FE3666"));
                gradientDrawable.setCornerRadius(com.kwad.sdk.c.a.a.a(this.mContext, 8.0f));
                gradientDrawable.setShape(0);
                this.abx.setTextSize(2, 12.0f);
                this.abx.setLayoutParams(layoutParams3);
                this.abx.setBackground(gradientDrawable);
            }
            this.abw.setOnClickListener(this);
            this.abw.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private boolean up() {
        if (this.mAdTemplate.type == 21) {
            return this.mAdTemplate.defaultType == 1 || this.mAdTemplate.defaultType == 2;
        }
        return false;
    }

    public final void uq() {
        this.bIR.pause();
        this.dE = true;
    }

    public final void ur() {
        ag();
        this.dE = false;
    }

    public final void us() {
        this.dE = false;
    }

    public final void setAutoRelease(boolean z) {
        this.dF = z;
    }
}
