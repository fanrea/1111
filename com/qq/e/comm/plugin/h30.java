package com.qq.e.comm.plugin;

import android.app.Activity;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h30 implements UBVI {
    private final f30 a;

    @Override // com.qq.e.comm.pi.UBVI
    public String getAdNetWorkName() {
        return "";
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
    }

    public h30(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        this(unifiedBannerView, activity, str, str2, str3, aDListener, mb.DEFAULT);
    }

    private NativeExpressADView e() {
        return this.a.r();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        this.a.fetchAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            return nativeExpressADViewE.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.destroy();
        }
        this.a.m();
    }

    public h30(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener, mb mbVar) {
        this.a = new f30(activity, unifiedBannerView, new ADSize(-1, -2), str, str2, str3, aDListener, mbVar);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z) {
        try {
            this.a.onWindowFocusChanged(z);
        } catch (Throwable th) {
            o7.b(th);
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i) {
        this.a.setRefresh(i);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            return nativeExpressADViewE.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        NativeExpressADView nativeExpressADViewE = e();
        return nativeExpressADViewE != null ? nativeExpressADViewE.getECPMLevel() : "";
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.sendWinNotification(i);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.sendLossNotification(i, i2, str);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.setBidECPM(i);
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            return nativeExpressADViewE.getBoundData().getExtraInfo();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            return nativeExpressADViewE.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public String[] c() {
        return this.a.d();
    }

    public String[] a() {
        return this.a.c();
    }

    public int d() {
        return this.a.q();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.sendWinNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        NativeExpressADView nativeExpressADViewE = e();
        if (nativeExpressADViewE != null) {
            nativeExpressADViewE.sendLossNotification(map);
        } else {
            this.a.sendLossNotification(map);
        }
    }

    public void a(String str) {
        this.a.a(str);
    }
}
