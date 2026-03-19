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
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class wm implements POFactory {
    public static final String BLOCK_CLICK_ACTIVITY = "blockClickActivity";
    public static final String DIALOG_ACTIVITY = "dialogActivity";
    public static final String DOWNLOAD_MANAGE = "downloadManage";
    public static final String FULLSCREEN_ACTIVITY = "fullscreenActivity";
    public static final String HYBRID_AD_PAGE = "hybridADPage";
    public static final String IMMERSIVE_AD_FLOW_ACTIVITY = "immersiveADFlowActivity";
    public static final String INNER_BROWSER = "innerBrowser";
    public static final String MIIT_INFO_DISPLAY = "miitInfoDisplay";
    public static final String REWARD_PAGE = "rewardPage";

    protected wm(Context context, JSONObject jSONObject) throws JSONException {
        iu.a(context, jSONObject);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public SVSD getAPKDownloadServiceDelegate(Service service) {
        return (SVSD) pro.getobjresult(323, 0, this, service);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public ACTD getActivityDelegate(String str, Activity activity) {
        return (ACTD) pro.getobjresult(324, 0, this, str, activity);
    }

    @Override // com.qq.e.comm.pi.InnerPOFactory
    public String getBuyerId() {
        return (String) pro.getobjresult(325, 0, this);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public String getBuyerId(Map<String, Object> map) {
        return (String) pro.getobjresult(326, 0, this, map);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener) {
        return (DFA) pro.getobjresult(327, 0, this, iGDTApkListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        return (HADI) pro.getobjresult(328, 0, this, hybridADSetting, hybridADListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public IAFD getImmersiveADFlowDelegate(Context context, String str, String str2, String str3, ADListener aDListener, Map<String, String> map) {
        return (IAFD) pro.getobjresult(329, 0, this, context, str, str2, str3, aDListener, map);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (NUADI) pro.getobjresult(330, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        return (NEADI) pro.getobjresult(331, 0, this, context, aDSize, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public synchronized NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3) {
        return (NSPVI) pro.getobjresult(332, 0, this, context, str, str2, str3);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (RVADI) pro.getobjresult(333, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public String getSDKInfo(String str) {
        return (String) pro.getobjresult(334, 0, this, str);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UBVI) pro.getobjresult(335, 0, this, unifiedBannerView, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UIADI) pro.getobjresult(336, 0, this, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        return pro.getIresult(337, 0, this, gDTAppDialogClickListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public void start(JSONObject jSONObject) {
        pro.getVresult(338, 0, this, jSONObject);
    }
}
