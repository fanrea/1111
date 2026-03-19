package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.qz;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.Map;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANSplashAdViewAdapter extends BaseSplashAd implements op, uk {
    private qz mANSplash;

    public ANSplashAdViewAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.mANSplash = new qz(context, r1.d().b().a(), str2, "", mb.UNION_ADAPTER);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchAdOnly() {
        this.mANSplash.fetchAdOnly();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchFullScreenAdOnly() {
        this.mANSplash.fetchFullScreenAdOnly();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public int getAdapterPriority() {
        return this.mANSplash.z();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.mANSplash.w();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.mANSplash.x();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.mANSplash.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public String getECPMLevel() {
        return this.mANSplash.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.mANSplash.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        return this.mANSplash.y();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.mANSplash.getExtraInfo().get("request_id");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public Bitmap getZoomOutBitmap() {
        return this.mANSplash.getZoomOutBitmap();
    }

    public boolean isContractAd() {
        return this.mANSplash.B();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public boolean isValid() {
        return this.mANSplash.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setADListener(ADListener aDListener) {
        this.mANSplash.setAdListener(aDListener);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setDeveloperLogo(int i) {
        this.mANSplash.setDeveloperLogo(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setFetchDelay(int i) {
        this.mANSplash.setFetchDelay(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.mANSplash.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.mANSplash.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mANSplash.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setSkipView(View view) {
        this.mANSplash.setSkipView(view);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setSupportZoomOut(boolean z) {
        this.mANSplash.setSupportZoomOut(z);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void showAd(ViewGroup viewGroup) throws JSONException {
        this.mANSplash.showAd(viewGroup);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void showFullScreenAd(ViewGroup viewGroup) throws JSONException {
        this.mANSplash.showFullScreenAd(viewGroup);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void zoomOutAnimationFinish() {
        this.mANSplash.zoomOutAnimationFinish();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setDeveloperLogo(byte[] bArr) {
        this.mANSplash.setDeveloperLogo(bArr);
    }
}
