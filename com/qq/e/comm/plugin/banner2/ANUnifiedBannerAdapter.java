package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.h30;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANUnifiedBannerAdapter extends BaseBannerAd implements op, uk {
    private ADListener mADListener;
    private h30 mDelegate;
    private final UnifiedBannerView mUnifiedBannerView;

    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANUnifiedBannerAdapter.this.mADListener != null) {
                ANUnifiedBannerAdapter.this.mADListener.onADEvent(aDEvent);
            }
        }
    }

    public ANUnifiedBannerAdapter(Activity activity, String str, String str2, String str3) {
        super(activity, str, str2, str3);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, str2, null);
        this.mUnifiedBannerView = unifiedBannerView;
        h30 h30Var = new h30(unifiedBannerView, activity, r1.d().b().a(), str2, "", new a(), mb.UNION_ADAPTER);
        this.mDelegate = h30Var;
        h30Var.setRefresh(0);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void destroy() {
        this.mDelegate.destroy();
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public View getAdView() {
        return this.mUnifiedBannerView;
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.mDelegate.a();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.mDelegate.c();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.mDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.mDelegate.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        return this.mDelegate.d();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.mDelegate.getExtraInfo().get("request_id");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public boolean isContractAd() {
        return false;
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public boolean isValid() {
        return this.mDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void loadAD() {
        this.mDelegate.fetchAd();
    }

    void onWindowFocusChanged(boolean z) {
        this.mDelegate.onWindowFocusChanged(z);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setAdListener(ADListener aDListener) {
        this.mADListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setAdSize(int i, int i2) {
    }

    void setLoadAdParams(LoadAdParams loadAdParams) {
        this.mDelegate.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.mDelegate.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
