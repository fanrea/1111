package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.dh;
import com.qq.e.comm.plugin.ff;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANNativeExpressAdAdapter extends BaseNativeExpressAd implements op, uk {
    private List<NativeExpressADView> mAdViews;
    private dh mDelegate;
    private NativeExpressADView mExpressADView;
    private ADListener mListener;

    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent != null && aDEvent.getType() == 100) {
                try {
                    ANNativeExpressAdAdapter.this.mAdViews = (List) aDEvent.getParam(List.class);
                    if (ANNativeExpressAdAdapter.this.mAdViews != null && ANNativeExpressAdAdapter.this.mAdViews.size() > 0) {
                        ANNativeExpressAdAdapter aNNativeExpressAdAdapter = ANNativeExpressAdAdapter.this;
                        aNNativeExpressAdAdapter.mExpressADView = (NativeExpressADView) aNNativeExpressAdAdapter.mAdViews.get(0);
                    }
                } catch (Exception unused) {
                }
            }
            if (ANNativeExpressAdAdapter.this.mListener == null || aDEvent == null) {
                return;
            }
            ANNativeExpressAdAdapter.this.mListener.onADEvent(aDEvent);
        }
    }

    public ANNativeExpressAdAdapter(Context context, ADSize aDSize, String str, String str2, String str3) {
        super(context, aDSize, str, str2, str3);
        this.mDelegate = new dh(context, aDSize, r1.d().b().a(), str2, mb.UNION_ADAPTER, "", new a());
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.mDelegate.c();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.mDelegate.d();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || nativeExpressADView.getBoundData() == null) {
            return -1;
        }
        return this.mExpressADView.getBoundData().getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        return (nativeExpressADView == null || nativeExpressADView.getBoundData() == null) ? new HashMap() : this.mExpressADView.getBoundData().getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || !(nativeExpressADView.getBoundData() instanceof ff)) {
            return -1;
        }
        return ((ff) this.mExpressADView.getBoundData()).a();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj;
        Map<String, Object> extraInfo = getExtraInfo();
        if (extraInfo == null || (obj = extraInfo.get("request_id")) == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean isContractAd() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || !(nativeExpressADView.getBoundData() instanceof ff)) {
            return false;
        }
        return ((ff) this.mExpressADView.getBoundData()).b();
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i) {
        this.mDelegate.loadAd(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setECPMLevel(String str) {
        List<NativeExpressADView> list = this.mAdViews;
        if (list != null) {
            Iterator<NativeExpressADView> it = list.iterator();
            while (it.hasNext()) {
                ((ff) it.next().getBoundData()).setECPMLevel(str);
            }
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMaxVideoDuration(int i) {
        this.mDelegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.mDelegate.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMinVideoDuration(int i) {
        this.mDelegate.setMinVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setVideoOption(VideoOption videoOption) {
        this.mDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i, LoadAdParams loadAdParams) {
        this.mDelegate.loadAd(i, loadAdParams);
    }
}
