package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bx implements RVADI {
    private final RVADI a;
    private String b;

    public bx(Context context, String str, String str2, ADListener aDListener, String str3) {
        this.a = i1.a(context, str, str2, aDListener, str3);
        this.b = str2;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        this.a.loadAD();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        kp.b().b(this.b, e2.REWARDVIDEOAD);
        this.a.showAD();
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        return this.a.getExpireTimestamp();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.a.isValid();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        return this.a.hasShown();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.a.getECPM();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        kp.b().b(this.b, e2.REWARDVIDEOAD);
        this.a.showAD(activity);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z) {
        this.a.setVolumeOn(z);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        return this.a.getRewardAdType();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.a.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.a.sendLossNotification(map);
    }
}
