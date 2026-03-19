package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.AdData;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jq extends NativeExpressADView {
    private final AdData d;
    private NativeExpressADView.ViewBindStatusListener e;
    private final dd f;
    private DownloadConfirmListener g;
    private NegativeFeedbackListener h;
    private NativeExpressAD.ADListenerAdapter i;
    private n1 j;

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
    }

    public jq(ADListener aDListener, dd ddVar, Context context, ff ffVar) {
        super(context);
        this.f = ddVar;
        this.d = ffVar;
        this.i = new NativeExpressAD.ADListenerAdapter((NativeExpressMediaListener) null);
        if (aDListener == null || !(ddVar instanceof oe)) {
            return;
        }
        n1 n1Var = new n1(aDListener, this, ffVar, ddVar);
        this.j = n1Var;
        ddVar.setAdListener(n1Var);
        this.j.a(this.i);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        this.f.q();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        this.f.s();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    @Deprecated
    public void setAdSize(ADSize aDSize) {
        this.f.a(aDSize);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        this.f.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        ed edVarD = this.f.d();
        if (edVarD != null) {
            kp.b().a(edVarD.y0(), edVarD.k());
        }
        return this.d;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        if (nativeExpressMediaListener == null) {
            return;
        }
        if (su.h() >= 450) {
            this.i.setMediaListener(nativeExpressMediaListener);
            return;
        }
        NativeExpressAD.ADListenerAdapter aDListenerAdapter = new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener);
        this.i = aDListenerAdapter;
        NegativeFeedbackListener negativeFeedbackListener = this.h;
        if (negativeFeedbackListener != null) {
            aDListenerAdapter.setNegativeFeedbackListener(negativeFeedbackListener);
        }
        n1 n1Var = this.j;
        if (n1Var != null) {
            n1Var.a(this.i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.e;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.e;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.e;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.e;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        this.e = viewBindStatusListener;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        ed edVarD = this.f.d();
        if (edVarD != null) {
            kp.b().a(edVarD.y0(), edVarD.k());
        }
        return this.f.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        AdData adData = this.d;
        if (adData != null) {
            return adData.getExtraInfo();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        ed edVarD = this.f.d();
        if (edVarD != null) {
            kp.b().a(edVarD.y0(), edVarD.k());
        }
        return this.f.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f.isValid();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.f.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.f.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.g;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.g = downloadConfirmListener;
        this.f.setDownloadConfirmListener(this);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        if (negativeFeedbackListener != null) {
            this.h = negativeFeedbackListener;
            this.i.setNegativeFeedbackListener(negativeFeedbackListener);
        }
    }

    public void a(JSONObject jSONObject) {
        dd ddVar = this.f;
        if (ddVar != null) {
            ddVar.a(jSONObject);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f.sendLossNotification(map);
    }
}
