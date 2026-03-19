package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView;
import com.kwad.components.core.l.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.f;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends KSFrameLayout implements View.OnClickListener {
    private List<Integer> dX;
    private KsDrawAd.AdInteractionListener eU;
    private final AdLivePlayStateListener fU;
    private com.kwad.sdk.core.j.b fa;
    private com.kwad.components.ad.draw.b.b fm;
    private IAdLivePlayModule fp;
    private com.kwad.components.core.widget.a.c gR;
    private boolean gU;
    private final com.kwad.sdk.core.j.c gZ;
    private IAdLiveOfflineView hb;
    private com.kwad.components.core.p.a.b.a hc;
    private boolean hd;
    private KsLiveAuthorView he;
    private TextView hf;
    private TextView hg;
    private TextView hh;
    private KsLogoView hi;
    private View hj;
    private ViewGroup hk;
    private String hl;
    private KsLogoView hm;
    private KSFrameLayout hn;
    private a.b ho;
    private int hp;
    private View hq;
    private long hr;
    private boolean hs;
    private Runnable ht;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bw mTimerHelper;

    public a(Context context, AdTemplate adTemplate) {
        super(context);
        this.hp = -1;
        this.gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.view.a.2
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                try {
                    a.this.hs = true;
                    if (a.this.fp == null) {
                        a aVar = a.this;
                        aVar.fp = aVar.bF();
                    }
                    com.kwad.components.core.l.a.qD().a(a.this.getCurrentVoiceItem());
                    a.this.fp.onResume();
                    a.this.getTimerHelper().startTiming();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                if (a.this.hs) {
                    if (a.this.fp != null) {
                        a.this.fp.onPause();
                    }
                    com.kwad.components.core.l.a.qD().c(a.this.ho);
                    a.this.hs = false;
                }
            }
        };
        this.ht = new Runnable() { // from class: com.kwad.components.ad.draw.view.a.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.c.a.a.a(a.this.hg, a.this.hl, KsLogoView.a(a.this.hm));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    a.this.hg.setText(a.this.hl);
                    a.this.hg.setVisibility(0);
                }
            }
        };
        this.fU = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.draw.view.a.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                a.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                a.C0576a c0576a = new a.C0576a();
                bVar.eY(24);
                bVar.b(c0576a);
                com.kwad.components.core.u.b.tq().a(a.this.mAdTemplate, null, bVar);
                a.this.hk.setVisibility(8);
                a.this.hq.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                if (com.kwad.sdk.core.response.b.a.dg(a.this.mAdInfo)) {
                    com.kwad.sdk.core.adlog.c.n(a.this.mAdTemplate, (int) Math.ceil(a.this.getTimerHelper().getTime() / 1000.0f));
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                if (!a.this.mAdTemplate.mPvReported && a.this.fm != null && a.this.fm.eU != null) {
                    a.this.fm.eU.onAdShow();
                    com.kwad.components.ad.draw.a.c.a(a.this.mAdTemplate, 1, com.kwad.sdk.core.response.b.b.dB(a.this.mAdTemplate) ? 2 : 1);
                    com.kwad.components.ad.draw.a.b.a(a.this.mAdTemplate, SystemClock.elapsedRealtime() - a.this.hr);
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.b(new a.C0576a());
                com.kwad.components.core.u.b.tq().a(a.this.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.f(a.this.mAdTemplate, null);
                com.kwad.components.core.l.a.qD().a(a.this.getCurrentVoiceItem());
                a.this.fp.setAudioEnabled(a.this.isVideoSoundEnable(), false);
                a.this.hk.setVisibility(0);
                a.this.hq.setVisibility(8);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.l.a.qD().a(a.this.getCurrentVoiceItem());
                a.this.fp.setAudioEnabled(a.this.isVideoSoundEnable(), false);
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        this.hc = (com.kwad.components.core.p.a.b.a) d.g(com.kwad.components.core.p.a.b.a.class);
        final WeakReference weakReference = new WeakReference(m.fb(this.mContext));
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.draw.view.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                a.this.bG();
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
        initView();
        bC();
        bB();
        bA();
    }

    private void bA() {
        this.hk.setOnClickListener(this);
        this.hh.setOnClickListener(this);
        this.he.setOnClickListener(this);
        this.hg.setOnClickListener(this);
        this.hf.setOnClickListener(this);
        this.mRootContainer.setOnClickListener(this);
    }

    private void bB() {
        try {
            ViewGroup viewGroup = this.hk;
            if (viewGroup == null) {
                return;
            }
            this.he = (KsLiveAuthorView) viewGroup.findViewById(R.id.ksad_live_author_icon);
            this.hf = (TextView) this.hk.findViewById(R.id.kwad_actionbar_title);
            this.hg = (TextView) this.hk.findViewById(R.id.kwad_actionbar_des_text);
            this.hh = (TextView) this.hk.findViewById(R.id.ksad_live_actionbar_btn);
            this.hi = (KsLogoView) this.hk.findViewById(R.id.ksad_draw_live_kwai_logo);
            if (this.hd) {
                return;
            }
            this.hj = this.hk.findViewById(R.id.ksad_draw_origin_live_relative);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void bC() {
        if (this.mRootContainer == null) {
            return;
        }
        if (8 == com.kwad.sdk.core.response.b.a.bm(this.mAdInfo)) {
            this.hk = (ViewGroup) ((ViewStub) this.mRootContainer.findViewById(R.id.ksad_draw_live_shop_stub)).inflate();
            this.hd = true;
        } else {
            this.hk = (ViewGroup) ((ViewStub) this.mRootContainer.findViewById(R.id.ksad_draw_live_base_stub)).inflate();
            this.hd = false;
        }
        this.hk.setVisibility(4);
    }

    private void initView() {
        m.a(this.mContext, R.layout.ksad_draw_ad_live_layout, this, true);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_live_container);
        this.mRootContainer = adBaseFrameLayout;
        this.hn = (KSFrameLayout) adBaseFrameLayout.findViewById(R.id.ksad_draw_video_container);
        this.hq = this.mRootContainer.findViewById(R.id.ksad_draw_live_frame_bg);
    }

    public final void bD() {
        this.gR = new com.kwad.components.ad.draw.b(this);
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        bE();
    }

    private void bE() {
        this.hf.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        f fVar = new f();
        this.he.setVisibility(0);
        this.he.k(this.mAdTemplate);
        this.he.a(fVar);
        this.hh.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        if (com.kwad.sdk.core.response.b.a.bm(this.mAdInfo) == 8) {
            this.hi.setVisibility(0);
            this.hi.aQ(this.mAdTemplate);
            this.hg.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        } else {
            this.hl = com.kwad.sdk.core.response.b.a.aw(this.mAdInfo);
            KsLogoView ksLogoView = new KsLogoView(this.hk.getContext(), false);
            this.hm = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.draw.view.a.3
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bJ() {
                    a.this.hg.post(a.this.ht);
                }
            });
            this.hm.aQ(this.mAdTemplate);
            this.hi.setVisibility(8);
        }
        com.kwad.components.ad.draw.a.b.h(this.mAdTemplate);
        this.hr = SystemClock.elapsedRealtime();
        this.fm = bH();
        Presenter presenterBI = bI();
        this.mPresenter = presenterBI;
        presenterBI.ak(this.mRootContainer);
        this.mPresenter.K(this.fm);
        this.gR.a(this.fa);
        this.gR.a(this.gZ);
        this.gR.wK();
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.fa = bVar;
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.eU = adInteractionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bF() {
        IAdLivePlayModule iAdLivePlayModule;
        try {
            iAdLivePlayModule = this.fp;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (iAdLivePlayModule != null) {
            return iAdLivePlayModule;
        }
        com.kwad.components.core.p.a.b.a aVar = this.hc;
        if (aVar != null && aVar.qI() && com.kwad.sdk.core.response.b.a.df(e.eP(this.mAdTemplate))) {
            IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.hc, this.mContext, com.kwad.sdk.core.response.b.a.bm(this.mAdInfo) == 8 ? 1 : 0);
            this.hb = iAdLiveOfflineViewA;
            if (iAdLiveOfflineViewA == null) {
                return null;
            }
            IAdLivePlayModule adLivePlayModule = this.hc.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cE(this.mAdInfo), com.kwad.sdk.core.response.b.a.cF(this.mAdInfo));
            adLivePlayModule.setAudioEnabled(isVideoSoundEnable(), false);
            adLivePlayModule.registerAdLivePlayStateListener(this.fU);
            View view = this.hb.getView();
            if (this.hn.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.hn;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.hn.setTag(null);
            }
            this.hn.addView(view);
            this.hn.setTag(view);
            return adLivePlayModule;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.hh)) {
            this.fm.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.he)) {
            this.fm.a(1, view.getContext(), 30, 2);
            return;
        }
        if (view.equals(this.hg)) {
            this.fm.a(1, view.getContext(), 32, 2);
            return;
        }
        if (view.equals(this.hf)) {
            this.fm.a(1, view.getContext(), 31, 2);
            return;
        }
        if (view.equals(this.hk)) {
            this.fm.a(1, view.getContext(), 53, 2);
        } else if (view.equals(this.mRootContainer) || view.equals(this.hn)) {
            this.fm.a(1, view.getContext(), 85, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.draw.view.a.6
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                    if (a.this.fp == null) {
                        a aVar = a.this;
                        aVar.fp = aVar.bF();
                    }
                    if (a.this.fp != null) {
                        a.this.fp.setAudioEnabled(a.this.isVideoSoundEnable(), false);
                    }
                }
            });
        }
        return this.ho;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVideoSoundEnable() {
        return this.hp == 1 ? !this.gU : !com.kwad.sdk.core.response.b.a.ck(e.eP(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG() {
        com.kwad.components.core.widget.a.c cVar = this.gR;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.draw.b.b bVar = this.fm;
        if (bVar != null) {
            bVar.release();
        }
        if (this.fp != null) {
            this.fp = null;
        }
        if (this.hb != null) {
            this.hb = null;
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        com.kwad.components.core.l.a.qD().c(this.ho);
    }

    private com.kwad.components.ad.draw.b.b bH() {
        com.kwad.components.ad.draw.b.b bVar = new com.kwad.components.ad.draw.b.b();
        bVar.eU = this.eU;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo) && bVar.mApkDownloadHelper == null) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (this.fp == null) {
            this.fp = bF();
        }
        bVar.fp = this.fp;
        bVar.fq = this.hb;
        bVar.fr = new com.kwad.components.ad.draw.presenter.b.a(this.mAdTemplate);
        return bVar;
    }

    public final void setVideoSound(boolean z) {
        IAdLivePlayModule iAdLivePlayModule = this.fp;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(z, false);
        }
        this.gU = !z;
        this.hp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bw getTimerHelper() {
        if (this.mTimerHelper == null) {
            bw bwVar = new bw();
            this.mTimerHelper = bwVar;
            bwVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private static Presenter bI() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ad.draw.presenter.b());
        presenter.d(new com.kwad.components.ad.draw.presenter.livecard.b());
        presenter.d(new com.kwad.components.ad.draw.presenter.livecard.a());
        return presenter;
    }
}
