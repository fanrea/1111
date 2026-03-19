package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.j30;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANInterstitialAdAdapter extends BaseInterstitialAd implements op, uk {
    private ADListener mListener;
    private j30 unifiedInterstitialADDelegate;

    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANInterstitialAdAdapter.this.mListener != null) {
                ANInterstitialAdAdapter.this.mListener.onADEvent(aDEvent);
            }
        }
    }

    public ANInterstitialAdAdapter(Activity activity, String str, String str2, String str3) {
        super(activity, str, str2, str3);
        this.unifiedInterstitialADDelegate = new j30(activity, r1.d().b().a(), str2, "", mb.UNION_ADAPTER, new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void close() {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.close();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void destory() {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.destroy();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdPatternType() {
        return this.unifiedInterstitialADDelegate.getAdPatternType();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdapterPriority() {
        return this.unifiedInterstitialADDelegate.c();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.unifiedInterstitialADDelegate.d();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.unifiedInterstitialADDelegate.e();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.unifiedInterstitialADDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public String getECPMLevel() {
        return this.unifiedInterstitialADDelegate.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.unifiedInterstitialADDelegate.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        return this.unifiedInterstitialADDelegate.f();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.unifiedInterstitialADDelegate.getExtraInfo().get("request_id");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getVideoDuration() {
        return this.unifiedInterstitialADDelegate.getVideoDuration();
    }

    public boolean isContractAd() {
        return this.unifiedInterstitialADDelegate.g();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public boolean isValid() {
        return this.unifiedInterstitialADDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void loadAd() {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.loadAd();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void loadFullScreenAD() {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.loadFullScreenAD();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMaxVideoDuration(int i) {
        this.unifiedInterstitialADDelegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.unifiedInterstitialADDelegate.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMinVideoDuration(int i) {
        this.unifiedInterstitialADDelegate.setMinVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.unifiedInterstitialADDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setVideoOption(VideoOption videoOption) {
        this.unifiedInterstitialADDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show() {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.show();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void showFullScreenAD(Activity activity) {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.showFullScreenAD(activity);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show(Activity activity) {
        j30 j30Var = this.unifiedInterstitialADDelegate;
        if (j30Var != null) {
            j30Var.show(activity);
        }
    }
}
