package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.je;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANRewardVideoAdAdapter extends BaseRewardAd implements op, uk {
    private je mDelegate;
    private ADListener mListener;

    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANRewardVideoAdAdapter.this.mListener != null) {
                ANRewardVideoAdAdapter.this.mListener.onADEvent(aDEvent);
            }
        }
    }

    public ANRewardVideoAdAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.mDelegate = new je(context, r1.d().b().a(), str2, mb.UNION_ADAPTER, "", new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getAdapterPriority() {
        return this.mDelegate.q();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.mDelegate.h();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.mDelegate.m();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.mDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public String getECPMLevel() {
        return this.mDelegate.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public long getExpireTimestamp() {
        return this.mDelegate.getExpireTimestamp();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.mDelegate.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        return this.mDelegate.o();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.mDelegate.getExtraInfo().get("request_id");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getVideoDuration() {
        return this.mDelegate.getVideoDuration();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public boolean hasShown() {
        return this.mDelegate.hasShown();
    }

    public boolean isContractAd() {
        return this.mDelegate.s();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public boolean isValid() {
        return this.mDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void loadAD() {
        this.mDelegate.loadAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.mDelegate.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setVolumeOn(boolean z) {
        this.mDelegate.setVolumeOn(z);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD() {
        this.mDelegate.showAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD(Activity activity) {
        this.mDelegate.showAD(activity);
    }
}
