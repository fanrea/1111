package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.u.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;

@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.n.b<g> implements g.b, n.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bw mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.ix() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).tS != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void db() {
            super.db();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).kz = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).gR();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).tS == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                com.kwad.sdk.a.a.c.VC().VE();
                super.i(z);
            }
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void gu() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    private bw getTimerHelper() {
        if (this.mTimerHelper == null) {
            bw bwVar = new bw();
            this.mTimerHelper = bwVar;
            bwVar.startTiming();
        }
        return this.mTimerHelper;
    }

    public static void launch(Activity activity, AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar, int i) {
        Intent intent;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, adTemplateS);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.n.fl(adTemplateS);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.g(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.g(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplateS.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ot().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = adTemplateS.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.Q(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.VC().cs(true);
            com.kwad.components.ad.reward.monitor.c.c(true, adTemplateS, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, adTemplateS, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception_error_start_activity", th));
            throw th;
        }
    }

    public static void register() {
        com.kwad.sdk.service.c.g(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        com.kwad.components.ad.reward.model.c cVarA = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = cVarA;
        return cVarA != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.b.b(true, cVar != null ? cVar.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null && cVar.lb) {
            return R.layout.ksad_activity_reward_neo;
        }
        return R.layout.ksad_activity_reward_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.T(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.iC());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.u.c.tr().a(this);
        b.gp().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        if (this.mCallerContext != 0) {
            ((g) this.mCallerContext).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.ca(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.d.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.local.a.aah();
                com.kwad.sdk.core.local.a.cy(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.hZ().R(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        if (this.mModel == null) {
            return null;
        }
        n nVar = new n(this, this.mContext, this.mRootContainer, this.mModel, (g) this.mCallerContext);
        this.mRewardPresenter = nVar;
        nVar.a(this);
        return this.mRewardPresenter;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.n.b
    public g onCreateCallerContext() {
        long jAo;
        AdResultData adResultDataIy = this.mModel.iy();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo adInfoCZ = this.mModel.cZ();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.ts = this.mModel.iA() == 2;
        gVar.tt = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.iz();
        gVar.mReportExtData = this.mModel.iB();
        gVar.mRootContainer = this.mRootContainer;
        gVar.a(adResultDataIy);
        gVar.un = com.kwad.sdk.core.response.b.b.eA(adInfoCZ) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aJ(adInfoCZ)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.iB());
        }
        gVar.tw = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.di(adTemplate)) {
            gVar.tx = new j(gVar, this.mModel.iB(), null);
            gVar.tx.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.au(adInfoCZ)) {
            gVar.ty = new com.kwad.components.ad.l.a().ah(true);
        }
        gVar.tI = true;
        if (com.kwad.sdk.core.response.b.a.bT(adInfoCZ)) {
            gVar.tv = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.ug = 0L;
        if (this.mModel.cZ() != null) {
            if (com.kwad.sdk.core.response.b.a.bT(this.mModel.cZ())) {
                jAo = com.kwad.sdk.core.response.b.a.at(this.mModel.cZ());
            } else {
                jAo = com.kwad.sdk.core.response.b.a.ao(this.mModel.cZ());
            }
            gVar.ug = jAo;
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.tu = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.lb = this.mModel.lb;
        return gVar;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        n nVar = this.mRewardPresenter;
        if (nVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult backPressHandleResultHB = nVar.hB();
        if (backPressHandleResultHB.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (backPressHandleResultHB.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.i(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.i(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.e.c.wq().wr();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.gp().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            if (this.mCallerContext != 0) {
                i.hw().J(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.S(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String strL = com.kwad.sdk.core.response.b.a.L(cVar.cZ());
                if (!TextUtils.isEmpty(strL)) {
                    com.kwad.sdk.core.videocache.c.a.ch(this.mContext.getApplicationContext()).gd(strL);
                }
                com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.bt(this.mModel.getAdTemplate()));
            }
            com.kwad.components.core.u.c.tr().b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.iw()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (this.mModel.ix()) {
            boolean z = ((g) this.mCallerContext).ud != null && ((g) this.mCallerContext).ud.isCompleted();
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
                return;
            }
            return;
        }
        if (this.mIsFinishVideoLookStep) {
            return;
        }
        this.mIsFinishVideoLookStep = true;
        notifyRewardStep(0, 0);
    }

    private void notifyRewardStep(final int i, final int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.eW(cVar.getAdTemplate()) || ((g) this.mCallerContext).tP.contains(Integer.valueOf(i2))) {
            return;
        }
        ((g) this.mCallerContext).tP.add(Integer.valueOf(i2));
        o.a(i, i2, (g) this.mCallerContext, this.mModel);
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.j(i, i2)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        return ((g) this.mCallerContext).uc != null && ((g) this.mCallerContext).uc.isCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        if (((g) this.mCallerContext).ud != null) {
            ((g) this.mCallerContext).ud.markOpenNsCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        if (this.mModel == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.eW(this.mModel.getAdTemplate()) || ((g) this.mCallerContext).ha()) {
            return;
        }
        boolean z = false;
        if (this.mModel.iw()) {
            if (((g) this.mCallerContext).uc != null && ((g) this.mCallerContext).uc.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        if (this.mModel.ix()) {
            if (((g) this.mCallerContext).ud != null && ((g) this.mCallerContext).ud.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        handleNotifyVerify(false);
    }

    private void handleNotifyVerify(boolean z) {
        this.mAdOpenInteractionListener.setCallerContext((g) this.mCallerContext);
        ((g) this.mCallerContext).F(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((g) this.mCallerContext).tS == 0) {
            e.gD().M(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.i(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.hZ().ia().aa(com.kwad.components.ad.reward.c.b.wa);
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.m453if()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (!com.kwad.sdk.core.response.b.a.dm(this.mModel.cZ()) || ((g) this.mCallerContext).mAdTemplate.converted || ((g) this.mCallerContext).tJ || ((g) this.mCallerContext).gY()) {
            return;
        }
        g.a(getActivity(), (g) this.mCallerContext);
    }

    private boolean isNeoScan() {
        return this.mModel.iC() != null && this.mModel.iC().neoPageType == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.dg(cVar.cZ()) || !((g) this.mCallerContext).gX()) {
            com.kwad.sdk.core.adlog.c.n(this.mModel.getAdTemplate(), (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
        }
        if (z) {
            if (this.mModel.iC() == null || this.mModel.iC().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.iC() == null || this.mModel.iC().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.iB());
        }
        return true;
    }

    @Override // com.kwad.components.core.u.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).F(false);
        ((g) this.mCallerContext).tN = false;
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).gZ();
    }
}
