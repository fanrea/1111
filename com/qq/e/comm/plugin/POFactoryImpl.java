package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.IAFD;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import java.util.Map;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class POFactoryImpl extends wm {
    private static volatile POFactory a;

    private POFactoryImpl(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    public static synchronized POFactory getInstance(Context context, JSONObject jSONObject) {
        return (POFactory) pro.getobjresult(271, 1, context, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service) {
        return (SVSD) pro.getobjresult(272, 0, this, service);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ ACTD getActivityDelegate(String str, Activity activity) {
        return (ACTD) pro.getobjresult(273, 0, this, str, activity);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getBuyerId() {
        return (String) pro.getobjresult(274, 0, this);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getBuyerId(Map map) {
        return (String) pro.getobjresult(275, 0, this, map);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener) {
        return (DFA) pro.getobjresult(276, 0, this, iGDTApkListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        return (HADI) pro.getobjresult(277, 0, this, hybridADSetting, hybridADListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ IAFD getImmersiveADFlowDelegate(Context context, String str, String str2, String str3, ADListener aDListener, Map map) {
        return (IAFD) pro.getobjresult(278, 0, this, context, str, str2, str3, aDListener, map);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (NUADI) pro.getobjresult(279, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        return (NEADI) pro.getobjresult(280, 0, this, context, aDSize, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3) {
        return (NSPVI) pro.getobjresult(281, 0, this, context, str, str2, str3);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (RVADI) pro.getobjresult(282, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getSDKInfo(String str) {
        return (String) pro.getobjresult(283, 0, this, str);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UBVI) pro.getobjresult(284, 0, this, unifiedBannerView, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UIADI) pro.getobjresult(285, 0, this, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        return pro.getIresult(286, 0, this, gDTAppDialogClickListener);
    }

    @Override // com.qq.e.comm.plugin.wm, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ void start(JSONObject jSONObject) {
        pro.getVresult(287, 0, this, jSONObject);
    }
}
