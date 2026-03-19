package com.qq.e.comm.plugin;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k30 extends s4<BaseInterstitialAd> implements UIADI {
    private static String D;
    private Set<BaseInterstitialAd> A;
    private gt B;
    private e2 C;
    private ADListener t;
    private BaseInterstitialAd u;
    private Activity v;
    private boolean w;
    private VideoOption x;
    private int y;
    private int z;

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
    }

    public k30(Activity activity, String str, String str2, ADListener aDListener) {
        super(activity, str2);
        this.x = null;
        this.y = -1;
        this.z = -1;
        this.A = new HashSet();
        this.B = new gt();
        this.t = aDListener;
        this.v = activity;
        D = str2;
    }

    /* compiled from: A */
    class a implements ADListener {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ BaseInterstitialAd c;

        a(int i, long j, BaseInterstitialAd baseInterstitialAd) {
            this.a = i;
            this.b = j;
            this.c = baseInterstitialAd;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent == null) {
            }
            int type = aDEvent.getType();
            if (type == 201) {
                if (k30.this.u == this.c) {
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                }
                k30.this.A.add(this.c);
                return;
            }
            switch (type) {
                case 100:
                    k30 k30Var = k30.this;
                    k30Var.a(k30Var.C, this.a, this.b, (long) this.c);
                    k30.this.f(this.c);
                    break;
                case 101:
                    k30 k30Var2 = k30.this;
                    k30Var2.a(k30Var2.C, this.a, this.b, (long) this.c);
                    k30.this.a((k30) this.c, aDEvent);
                    break;
                case 102:
                    k30.this.f(this.c, 70462);
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        break;
                    }
                    break;
                case 103:
                    k30.this.d(this.c, 70432);
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        break;
                    }
                    break;
                case 104:
                    k30.this.e(this.c, 70472);
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        break;
                    }
                    break;
                case 105:
                    k30.this.c(this.c, 70442);
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        break;
                    }
                    break;
                case 106:
                    k30.this.B.b();
                    if (k30.this.t != null) {
                        k30.this.t.onADEvent(aDEvent);
                        break;
                    }
                    break;
                default:
                    switch (type) {
                        case 401:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                            yv.a(aDEvent, k30.D, e2.UNIFIED_INTERSTITIAL, this.c);
                            break;
                        case 407:
                            yv.a(this.c, 1143007);
                            break;
                        default:
                            if (k30.this.t != null) {
                                k30.this.t.onADEvent(aDEvent);
                                break;
                            }
                            break;
                    }
            }
        }
    }

    private void q() {
        ADListener aDListener = this.t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(100, new Object[0]));
        }
    }

    private void o() {
        ADListener aDListener = this.t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        if (this.w) {
            return;
        }
        this.B.a(this.v);
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            yq.ch.ri.b(baseInterstitialAd, null);
        }
        this.w = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        this.B.a(activity);
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            yq.ch.ri.a(baseInterstitialAd, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseInterstitialAd b(tr trVar) {
        if (trVar == null) {
            return null;
        }
        try {
            return v7.a(trVar.e(), this.v, trVar.b(), trVar.p(), trVar.j());
        } catch (Exception unused) {
            a(70452, trVar);
            return null;
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        this.B.b();
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.close();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        this.C = e2.UNIFIED_INTERSTITIAL;
        k();
        this.w = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        this.C = e2.UNIFIED_INTERSTITIAL_FULLSCREEN;
        k();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destroy() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.destory();
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            return c((k30) baseInterstitialAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.x = videoOption;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i) {
        this.y = i;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i) {
        this.z = i;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd == null) {
            return 0;
        }
        baseInterstitialAd.getAdPatternType();
        return 0;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getVideoDuration() {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.getVideoDuration();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String d(BaseInterstitialAd baseInterstitialAd) {
        if (c()) {
            return baseInterstitialAd.getReqId();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    public int a(BaseInterstitialAd baseInterstitialAd) {
        return baseInterstitialAd.getECPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(BaseInterstitialAd baseInterstitialAd) {
        ADListener aDListener;
        a(this.C);
        this.u = baseInterstitialAd;
        if (baseInterstitialAd != null) {
            q();
            if (!this.A.contains(this.u) || (aDListener = this.t) == null) {
                return;
            }
            aDListener.onADEvent(new ADEvent(201, new Object[0]));
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseInterstitialAd baseInterstitialAd, int i) {
        baseInterstitialAd.setAdListener(new a(i, System.currentTimeMillis(), baseInterstitialAd));
        int i2 = this.y;
        if (i2 > 0) {
            baseInterstitialAd.setMinVideoDuration(i2);
        }
        int i3 = this.z;
        if (i3 > 0) {
            baseInterstitialAd.setMaxVideoDuration(i3);
        }
        VideoOption videoOption = this.x;
        if (videoOption != null) {
            baseInterstitialAd.setVideoOption(videoOption);
        }
        if (this.C == e2.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            yq.ch.ri.a(baseInterstitialAd);
        } else {
            yq.ch.ri.b(baseInterstitialAd);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        if (this.w) {
            return;
        }
        this.B.a(activity);
        BaseInterstitialAd baseInterstitialAd = this.u;
        if (baseInterstitialAd != null) {
            yq.ch.ri.b(baseInterstitialAd, activity);
        }
        this.w = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseInterstitialAd baseInterstitialAd, int i, String str) {
        baseInterstitialAd.setPayload(str);
        b(baseInterstitialAd, i);
    }
}
