package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ch implements NEADI {
    private final NEADI a;

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    public ch(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        this.a = i1.a(context, aDSize, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        this.a.loadAd(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.a.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i) {
        this.a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i) {
        this.a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        this.a.loadAd(i, loadAdParams);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.a.sendLossNotification(map);
    }
}
