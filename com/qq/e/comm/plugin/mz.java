package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mz implements NSPVI {
    private final NSPVI a;
    private String b;

    public mz(Context context, String str, String str2, String str3) {
        this.a = i1.a(context, str, str2, str3);
        this.b = str2;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.a.setAdListener(aDListener);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        this.a.fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        this.a.fetchFullScreenAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        this.a.setFetchDelay(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    @Deprecated
    public void setSkipView(View view) {
        this.a.setSkipView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        this.a.preload();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        this.a.fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        kp.b().b(this.b, e2.SPLASH);
        this.a.showAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        this.a.fetchFullScreenAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) {
        kp.b().b(this.b, e2.SPLASH);
        this.a.showFullScreenAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.a.isValid();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.a.getECPMLevel();
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

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z) {
        this.a.setSupportZoomOut(z);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        this.a.zoomOutAnimationFinish();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        return this.a.getZoomOutBitmap();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i) {
        this.a.setDeveloperLogo(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
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

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        this.a.setDeveloperLogo(bArr);
    }
}
