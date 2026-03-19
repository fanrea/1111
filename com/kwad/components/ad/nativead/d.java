package com.kwad.components.ad.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.ad.nativead.b;
import com.kwad.components.ad.nativead.monitor.NativeAdMonitor;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.d;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator iS;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private volatile bw mTimerHelper;
    private boolean qD;
    private KsNativeAd.AdInteractionListener qE;
    private f qF;
    private e qG;
    private KsNativeAd.VideoPlayListener qH;
    private com.kwad.components.ad.nativead.d.a qL;
    private b.c qy;
    private b.e qz;
    private boolean qI = false;
    private com.kwad.components.core.internal.api.c dl = new com.kwad.components.core.internal.api.c();
    private int qJ = 0;
    private int qK = 0;
    private KsNativeAd.VideoPlayListener qM = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.nativead.d.10
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.qH != null) {
                d.this.qH.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.qH != null) {
                d.this.qH.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (d.this.qH != null) {
                d.this.qH.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.qH != null) {
                try {
                    d.this.qH.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.qH != null) {
                try {
                    d.this.qH.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.qH != null) {
                try {
                    d.this.qH.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };
    private a qN = new a() { // from class: com.kwad.components.ad.nativead.d.2
        @Override // com.kwad.components.ad.nativead.d.a
        public final void m(View view) {
            if (d.this.qE != null) {
                d.this.qE.onAdClicked(new FrameLayout(m.fd(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void fw() {
            if (d.this.qE != null) {
                d.this.qE.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.qE == null) {
                return false;
            }
            try {
                return d.this.qE.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.qE != null) {
                try {
                    d.this.qE.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.qE != null) {
                try {
                    d.this.qE.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }
    };

    public interface a {
        void fw();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void m(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    static /* synthetic */ boolean b(d dVar, aj.a aVar) {
        return c(aVar);
    }

    public d(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.nativead.d.1
                @Override // com.kwad.components.core.e.d.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.qN.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.P(this.mAdInfo), this.mAdTemplate);
    }

    public final synchronized bw getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bw();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        return BitmapFactory.decodeResource(ServiceProvider.getContext().getResources(), R.drawable.ksad_sdk_logo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.aw(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSource() {
        return com.kwad.sdk.core.response.b.a.aG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        if (i == 1) {
            return adInfo.adBaseInfo.adGrayMarkIcon;
        }
        return adInfo.adBaseInfo.adMarkIcon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    /* renamed from: ft, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo);
        if (TextUtils.isEmpty(materialFeatureAZ.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(materialFeatureAZ.width, materialFeatureAZ.height, materialFeatureAZ.coverUrl);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo).videoWidth;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        return com.kwad.sdk.core.response.b.a.df(this.mAdInfo) ? SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE : com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.b.a.M(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        int iBk = com.kwad.sdk.core.response.b.a.bk(this.mAdInfo);
        if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfoEP.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.cC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.b.a.ay(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.aC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.bL(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.bM(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bN(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getIntroductionInfo() {
        return com.kwad.sdk.core.response.b.a.bO(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getIntroductionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bP(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.bQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.bR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.aB(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.bS(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.aH(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bk(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aU(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final KsLiveInfo getLiveInfo() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzK)) {
            return com.kwad.sdk.core.response.b.e.fc(this.mAdTemplate);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Yf()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.adlog.c.cm(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.adlog.c.cn(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.b(viewGroup, 1);
        this.qE = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.b(viewGroup, 1);
        this.qE = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    private void a(Activity activity, ViewGroup viewGroup, List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            a(activity, viewGroup, 0, it.next(), false);
        }
    }

    private void a(Activity activity, ViewGroup viewGroup, Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    private void a(final Activity activity, final ViewGroup viewGroup, int i, final View view, final boolean z) {
        final aj.a aVar = new aj.a();
        if (view == null) {
            return;
        }
        final int[] iArrS = S(i);
        if (view instanceof f) {
            ((f) view).h(iArrS[1], iArrS[2]);
        } else {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.nativead.d.3
                private int[] qP = new int[2];

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.ac(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.qP);
                        aVar.p(Math.abs(motionEvent.getRawX() - this.qP[0]), Math.abs(motionEvent.getRawY() - this.qP[1]));
                    } else if (action == 1) {
                        aVar.q(Math.abs(motionEvent.getRawX() - this.qP[0]), Math.abs(motionEvent.getRawY() - this.qP[1]));
                        if (com.kwad.sdk.utils.b.g(aVar)) {
                            if (iArrS[2] != 1 && d.this.b(aVar)) {
                                view.setPressed(false);
                                d.this.a(activity, view2, aVar, iArrS[0], z, 153);
                            }
                            return true;
                        }
                        if (iArrS[1] != 1 && com.kwad.sdk.core.config.e.XB()) {
                            if (d.b(d.this, aVar)) {
                                d.this.a(activity, view2, aVar, iArrS[0], z, 0);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.nativead.d.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int[] iArr = iArrS;
                    if (iArr[1] != 0) {
                        return;
                    }
                    d.this.a(activity, view2, aVar, iArr[0], z, 0);
                }
            });
        }
    }

    private static int[] S(int i) {
        int i2;
        int i3;
        if (i == 3 || i == 4) {
            i2 = 0;
            i3 = 1;
        } else if (i == 5 || i == 6) {
            i3 = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i3 = 0;
        }
        return new int[]{i % 2 == 0 ? 2 : 1, i2, i3};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(aj.a aVar) {
        return com.kwad.sdk.utils.b.a(aVar, com.kwad.sdk.core.response.b.a.V(this.mAdInfo));
    }

    private static boolean c(aj.a aVar) {
        return (Math.abs(aVar.aoT() - aVar.aoV()) < 20) && (Math.abs(aVar.aoU() - aVar.aoW()) < 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, final View view, final aj.a aVar, int i, boolean z, final int i2) {
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        long playDuration = 0;
        e eVar = this.qG;
        if (eVar != null && eVar.jK != null) {
            playDuration = this.qG.jK.getPlayDuration();
        } else {
            f fVar = this.qF;
            if (fVar != null && fVar.rh != null) {
                playDuration = this.qF.rh.getPlayDuration();
            }
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(contextWrapContextIfNeed).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aK(i).aq(true).A(playDuration).ax(z).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.5
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(aVar).eP(i2), (JSONObject) null);
                d.this.qN.m(view);
            }
        }));
    }

    private void a(final ViewGroup viewGroup) {
        if (!this.qD) {
            this.qD = true;
            com.kwad.sdk.commercial.d.c.bZ(this.mAdTemplate);
        }
        if (!com.kwad.sdk.core.config.e.Yx() && com.kwad.sdk.core.config.e.Yw() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            NativeAdMonitor.b(viewGroup, 2);
            aVar.setViewCallback(new a.InterfaceC0500a() { // from class: com.kwad.components.ad.nativead.d.6
                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void onWindowFocusChanged(boolean z) {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void ae() {
                    com.kwad.components.ad.i.b.fW().a(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void af() {
                    try {
                        long jAqq = d.this.getTimerHelper().aqq();
                        if (d.this.mAdTemplate.mPvReported && d.this.qI) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, jAqq, (JSONObject) null);
                            d.this.qI = false;
                        }
                        if (com.kwad.sdk.core.response.b.a.dg(d.this.mAdInfo)) {
                            com.kwad.sdk.core.adlog.c.n(d.this.mAdTemplate, ((int) jAqq) / 1000);
                        }
                        d.this.dl.i(d.this);
                        b.fr().a(d.this.qz);
                        b.fr().a(d.this.qy);
                        com.kwad.components.ad.i.b.fW().b(d.this);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void c(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.qN.fw();
                        d.this.fu();
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.G(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.b.a.df(d.this.mAdInfo)) {
                            a.C0576a c0576a = new a.C0576a();
                            c0576a.showLiveStyle = d.this.qK;
                            c0576a.showLiveStatus = d.this.qJ;
                            bVar.b(c0576a);
                        }
                        com.kwad.components.core.u.b.tq().a(d.this.mAdTemplate, null, bVar);
                        if (d.this.enableRotate()) {
                            com.kwad.sdk.core.adlog.c.b(d.this.mAdTemplate, 184, (JSONObject) null);
                        }
                        NativeAdMonitor.b(viewGroup, 4);
                    }
                    if (!d.this.qI) {
                        d.this.k(view);
                        d.this.l(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.dl.h(d.this);
                    }
                    b.fr().N(viewGroup.getContext());
                    d.this.qI = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void aD() {
                    try {
                        if (d.this.mAdTemplate.mPvReported && d.this.qI) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, d.this.getTimerHelper().aqq(), (JSONObject) null);
                            d.this.qI = false;
                            b.fr().a(d.this.qz);
                            b.fr().a(d.this.qy);
                            b.fr().D(viewGroup.getContext());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
            aVar.ww();
            return;
        }
        com.kwad.components.core.widget.d dVarB = b(viewGroup);
        if (dVarB == null) {
            dVarB = new com.kwad.components.core.widget.d(viewGroup.getContext(), viewGroup);
            viewGroup.addView(dVarB);
        }
        dVarB.setViewCallback(new d.a() { // from class: com.kwad.components.ad.nativead.d.7
            @Override // com.kwad.components.core.widget.d.a
            public final void fx() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.qN.fw();
                }
                d.this.fu();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.G(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.b.a.df(d.this.mAdInfo)) {
                    a.C0576a c0576a = new a.C0576a();
                    c0576a.showLiveStyle = d.this.qK;
                    c0576a.showLiveStatus = d.this.qJ;
                    bVar.b(c0576a);
                }
                com.kwad.components.core.u.b.tq().a(d.this.mAdTemplate, null, bVar);
                com.kwad.sdk.commercial.d.c.ca(d.this.mAdTemplate);
            }
        });
        dVarB.setNeedCheckingShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu() {
        try {
            this.qJ = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.qK = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final View view) {
        if (com.kwad.sdk.core.response.b.a.ak(this.mAdInfo) || com.kwad.sdk.core.response.b.b.dw(this.mAdTemplate)) {
            float fDx = com.kwad.sdk.core.response.b.b.dx(this.mAdTemplate);
            if (fDx <= 0.0f) {
                fDx = com.kwad.sdk.core.response.b.a.al(this.mAdInfo);
            }
            this.qz = new b.e() { // from class: com.kwad.components.ad.nativead.d.8
                @Override // com.kwad.components.ad.nativead.b.e
                public final void i(final double d) {
                    if (d.this.fv() && b.cd()) {
                        com.kwad.components.core.e.d.a.a(new a.C0469a(m.wrapContextIfNeed(view.getContext())).aC(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).ax(false).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.8.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eP(157).o(d), (JSONObject) null);
                                d.this.qN.m(view);
                            }
                        }));
                        bx.a(view.getContext(), d.this.F(view.getContext()));
                    }
                }
            };
            b.fr().a(fDx, view, this.qz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final View view) {
        AdMatrixInfo.RotateInfo rotateInfoDL = com.kwad.sdk.core.response.b.b.dL(this.mAdTemplate);
        if (rotateInfoDL == null || !rotateInfoDL.enable) {
            return;
        }
        this.qy = new b.c() { // from class: com.kwad.components.ad.nativead.d.9
            @Override // com.kwad.components.ad.nativead.b.c
            public final void D(final String str) {
                if (ca.v(view, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) && d.this.fv() && b.cd()) {
                    com.kwad.components.core.e.d.a.a(new a.C0469a(m.wrapContextIfNeed(view.getContext())).aC(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).ax(false).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.9.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eP(161).eK(str), (JSONObject) null);
                            d.this.qN.m(view);
                        }
                    }));
                    bx.a(view.getContext(), d.this.F(view.getContext()));
                }
            }
        };
        b.fr().a(rotateInfoDL, view.getContext(), this.qy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (this.iS == null) {
            this.iS = (Vibrator) context.getSystemService("vibrator");
        }
        return this.iS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fv() {
        return (this.mAdInfo.status == 2 || this.mAdInfo.status == 3) ? false : true;
    }

    private static com.kwad.components.core.widget.d b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.d) {
                return (com.kwad.components.core.widget.d) childAt;
            }
        }
        return null;
    }

    private static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.dl.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.dl.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.qH = videoPlayListener;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void startVideo() {
        f fVar = this.qF;
        if (fVar != null) {
            fVar.setPlayState(1);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void pauseVideo() {
        f fVar = this.qF;
        if (fVar != null) {
            fVar.setPlayState(2);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void stopVideo() {
        f fVar = this.qF;
        if (fVar != null) {
            fVar.setPlayState(3);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final boolean enableRotate() {
        AdMatrixInfo.RotateInfo rotateInfoDL = com.kwad.sdk.core.response.b.b.dL(this.mAdTemplate);
        return rotateInfoDL != null && rotateInfoDL.enable;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final View getRotateView(Context context) {
        if (this.qL == null) {
            com.kwad.components.ad.nativead.d.a aVar = new com.kwad.components.ad.nativead.d.a(context);
            this.qL = aVar;
            aVar.fR();
            NativeAdMonitor.fC();
            NativeAdMonitor.fB();
        }
        return this.qL;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !l.UL().TT()) {
            return null;
        }
        return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        if (context == null || !l.UL().TT()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
                return a(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
            }
            return b(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (l.UL().TQ()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    runtimeException.addSuppressed(th);
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
                return null;
            }
            throw th;
        }
    }

    private View a(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
        if (aVar == null || !aVar.qI()) {
            return null;
        }
        if (this.qG == null) {
            e eVar = new e(context);
            this.qG = eVar;
            eVar.setInnerAdInteractionListener(this.qN);
            this.qG.setVideoPlayListener(this.qM);
            this.qG.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.qG;
    }

    private View b(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.c.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.qF == null) {
            f fVar = new f(context);
            this.qF = fVar;
            fVar.setInnerAdInteractionListener(this.qN);
            this.qF.setVideoPlayListener(this.qM);
            this.qF.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.qF;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.qN.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.qN;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }
}
