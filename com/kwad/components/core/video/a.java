package com.kwad.components.core.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.core.video.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.widget.KSRelativeLayout;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected ImageView EZ;
    protected TextView Fa;
    protected com.kwad.components.core.video.a.a abA;
    protected View abB;
    protected final com.kwad.sdk.core.download.a.a abC;
    protected boolean abj;
    private boolean abk;
    protected boolean abl;
    private int abm;
    private int abn;
    private boolean abo;
    private KSRelativeLayout abp;
    private RelativeLayout abq;
    private boolean abr;
    private boolean abs;
    private LinearLayout abt;
    private LinearLayout abu;
    private ImageView abv;
    public ViewGroup abw;
    protected TextView abx;
    private c aby;
    private InterfaceC0488a abz;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    private ProgressBar rK;
    private boolean rN;
    protected ImageView rp;
    protected TextView rq;

    /* renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC0488a {
        void a(int i, aj.a aVar);
    }

    public interface b extends c {
        void onVideoPlayError(int i, int i2);
    }

    public interface c {
        void au();

        void av();

        void d(long j);

        void onVideoPlayStart();
    }

    protected void tK() {
    }

    public void setCanControlPlay(boolean z) {
        this.abl = z;
    }

    public a(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.abk = true;
        this.abl = false;
        this.abs = false;
        this.abC = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aT(com.kwad.sdk.core.response.b.a.aH(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.abJ());
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.ft(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.ft(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.abx.setText(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        init();
    }

    private void init() {
        this.abB = com.kwad.sdk.p.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.abp = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.abq = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.rq = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.rp = imageView;
        imageView.setOnClickListener(this);
        this.abt = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.abu = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.rK = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.abv = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.abv.setImageDrawable(null);
            KSImageLoader.loadImage(this.abv, url, this.mAdTemplate);
            this.abv.setVisibility(0);
        } else {
            this.abv.setVisibility(8);
        }
        this.rq.setText(bv.aP(com.kwad.sdk.core.response.b.a.M(this.mAdInfo) * 1000));
        this.abA = com.kwad.components.core.video.a.d.a(this.mAdTemplate, this.bIR.getMediaPlayerType(), false);
        tK();
    }

    public void setHideEnd(boolean z) {
        this.abo = z;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void p(int i, int i2) {
        this.abn = i2;
        this.abm = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.d.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            tY();
            setTopBottomVisible(false);
            this.abt.setVisibility(8);
            this.abu.setVisibility(0);
            c cVar = this.aby;
            if (cVar instanceof h.a) {
                ((h.a) cVar).onVideoPlayError(this.abm, this.abn);
            }
            c cVar2 = this.aby;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.abm, this.abn);
            }
            com.kwad.components.core.q.a.ss().g(this.mAdTemplate, this.abm, this.abn);
            com.kwad.components.core.video.a.a aVar2 = this.abA;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.abm, this.abn);
                return;
            }
            return;
        }
        if (i == 9) {
            tY();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            if (!this.abo) {
                KSImageLoader.loadImage(this.abv, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
                this.abv.setVisibility(0);
                fF();
            }
            c cVar3 = this.aby;
            if (cVar3 != null) {
                cVar3.av();
            }
            com.kwad.components.core.video.a.a aVar3 = this.abA;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i == 1) {
            tO();
            this.abt.setVisibility(8);
            this.abu.setVisibility(8);
            this.rK.setVisibility(8);
            fG();
            return;
        }
        if (i == 2) {
            c cVar4 = this.aby;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.abA;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            tX();
            return;
        }
        if (i == 4) {
            c cVar5 = this.aby;
            if (cVar5 != null) {
                cVar5.au();
            }
            this.abv.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.abA;
            if (aVar5 != null) {
                aVar5.qv();
                this.abA.onMediaPlaying();
                return;
            }
            return;
        }
        if (i == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.abA;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i != 6) {
            if (i == 7 && (aVar = this.abA) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.abA;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private void fG() {
        ViewGroup viewGroup = this.abw;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void aT(String str) {
        TextView textView = (TextView) findViewById(R.id.ksad_app_download);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    protected void fF() {
        try {
            if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.EZ = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.Fa = (TextView) findViewById(R.id.ksad_app_name);
                this.abx = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.EZ, com.kwad.sdk.core.response.b.e.bf(this.mAdTemplate), this.mAdTemplate, 12);
                this.Fa.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
                this.abx.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
                this.abw = linearLayout;
                this.EZ.setOnClickListener(this);
                this.Fa.setOnClickListener(this);
                this.abx.setOnClickListener(this);
                com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
                this.mApkDownloadHelper = cVar;
                cVar.b(this.abC);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.abx = textView;
                textView.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
                this.abx.setOnClickListener(this);
                this.abw = linearLayout2;
            }
            this.abw.setOnClickListener(this);
            this.abw.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    protected final void tL() {
        this.abt.setVisibility(0);
    }

    protected final void tM() {
        this.abt.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        tY();
        this.rK.setProgress(0);
        this.rK.setSecondaryProgress(0);
        tO();
        this.abt.setVisibility(8);
        this.abu.setVisibility(8);
        this.rK.setVisibility(8);
        this.abv.setVisibility(8);
        this.abq.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        fG();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.rp) {
            this.abj = true;
            this.abk = true;
            ag();
        } else {
            if (view == this.EZ) {
                bg(1);
                return;
            }
            if (view == this.Fa) {
                bg(2);
            } else if (view == this.abx) {
                bg(3);
            } else {
                bg(4);
            }
        }
    }

    protected final void tN() {
        this.abq.setVisibility(0);
        this.abv.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void tO() {
        this.abq.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        if (this.abs) {
            return;
        }
        this.rK.setVisibility(z ? 0 : 8);
        this.abr = z;
    }

    public final void aU(boolean z) {
        if (this.abs) {
            return;
        }
        if (z) {
            if (this.abr) {
                this.rK.setVisibility(0);
                return;
            }
            return;
        }
        this.rK.setVisibility(8);
    }

    protected void ag() {
        if (this.bIR.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.abA;
            if (aVar != null) {
                aVar.onStart();
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
            if (this.abk && ao.isWifiConnected(this.mContext)) {
                tP();
                this.bIR.start();
                return;
            } else if (this.abk && (this.rN || this.abj)) {
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

    protected final void tP() {
        this.bIR.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
    }

    protected void tQ() {
        this.bIR.pause();
    }

    public void release() {
        this.bIR.release();
        com.kwad.components.core.video.a.a aVar = this.abA;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void tR() {
        long currentPosition = this.bIR.getCurrentPosition();
        long duration = this.bIR.getDuration();
        this.rK.setSecondaryProgress(this.bIR.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.rK.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.aby;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public void setVideoPlayCallback(c cVar) {
        this.aby = cVar;
    }

    public void setAdClickListener(InterfaceC0488a interfaceC0488a) {
        this.abz = interfaceC0488a;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.rN = z;
    }

    public void setDataAutoStart(boolean z) {
        this.abk = z;
    }

    public final void tS() {
        this.abs = true;
        this.rK.setVisibility(8);
    }

    private void bg(int i) {
        try {
            InterfaceC0488a interfaceC0488a = this.abz;
            if (interfaceC0488a != null) {
                interfaceC0488a.a(i, this.abp.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
