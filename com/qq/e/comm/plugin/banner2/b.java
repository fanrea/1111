package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.plugin.b50;
import com.qq.e.comm.plugin.d50;
import com.qq.e.comm.plugin.e2;
import com.qq.e.comm.plugin.s4;
import com.qq.e.comm.plugin.tr;
import com.qq.e.comm.plugin.xo;
import com.qq.e.comm.plugin.yv;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yq.ch.ri;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b extends s4<BaseBannerAd> implements UBVI {
    private final List<Integer> A;
    private volatile boolean B;
    private String C;
    private final Runnable D;
    private final UnifiedBannerView t;
    private final ADListener u;
    private final Activity v;
    private BaseBannerAd w;
    private LoadAdParams x;
    private int y;
    private final List<BaseBannerAd> z;

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.fetchAd();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.banner2.b$b, reason: collision with other inner class name */
    class C0702b implements ADListener {
        final /* synthetic */ BaseBannerAd a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        C0702b(BaseBannerAd baseBannerAd, int i, long j) {
            this.a = baseBannerAd;
            this.b = i;
            this.c = j;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                if (this.a.getAdView() != null) {
                    b50.a(this.a.getAdView());
                }
                b.this.a(e2.UNIFIED_BANNER, this.b, this.c, (long) this.a);
                b.this.f(this.a);
            }
            if (type == 101) {
                if (((Integer) aDEvent.getParam(Integer.class)) != null) {
                    if (this.a.getAdView() != null) {
                        b50.a(this.a.getAdView());
                    }
                    b.this.a(e2.UNIFIED_BANNER, this.b, this.c, (long) this.a);
                    b.this.a((b) this.a, aDEvent);
                    return;
                }
                return;
            }
            if (type == 103) {
                if (b.this.B) {
                    b.this.A.add(Integer.valueOf(this.a.hashCode()));
                    return;
                } else {
                    b.this.e2(this.a);
                    return;
                }
            }
            if (type == 105) {
                b.this.c(this.a, 70642);
                if (b.this.u != null) {
                    b.this.u.onADEvent(aDEvent);
                    return;
                }
                return;
            }
            switch (type) {
                case 401:
                case 402:
                case 403:
                case 404:
                case 405:
                case 406:
                    yv.a(aDEvent, b.this.C, e2.UNIFIED_BANNER, this.a);
                    break;
                case 407:
                    yv.a(this.a, 1143007);
                    break;
                default:
                    if (b.this.u != null) {
                        b.this.u.onADEvent(aDEvent);
                        break;
                    }
                    break;
            }
        }
    }

    public b(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, ADListener aDListener) {
        super(activity, str2);
        this.y = 20;
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = false;
        this.D = new a();
        this.t = unifiedBannerView;
        this.u = aDListener;
        this.v = activity;
        this.C = str2;
    }

    private void n() {
        ADListener aDListener = this.u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    private void o() {
        View adView = this.w.getAdView();
        if (adView == null) {
            n();
            return;
        }
        ADListener aDListener = this.u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(100, new Object[0]));
        }
        this.t.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.addView(adView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseBannerAd baseBannerAd, int i, String str) {
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        this.t.removeAllViews();
        BaseBannerAd baseBannerAd = this.w;
        if (baseBannerAd != null) {
            baseBannerAd.destroy();
        }
        xo.e(this.D);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        if (d50.a(this.d, this.t, 1)) {
            this.B = true;
            k();
        } else {
            GDTLogger.w("UnifiedBannerView is invisible, fetchAd delay");
        }
        if (this.y > 0) {
            xo.e(this.D);
            xo.a(this.D, this.y * 1000);
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public String getAdNetWorkName() {
        return i();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseBannerAd baseBannerAd = this.w;
        if (baseBannerAd != null) {
            return baseBannerAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseBannerAd baseBannerAd = this.w;
        return baseBannerAd != null ? c((b) baseBannerAd) : new HashMap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseBannerAd baseBannerAd = this.w;
        if (baseBannerAd == null) {
            return false;
        }
        baseBannerAd.isValid();
        return false;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z) {
        BaseBannerAd baseBannerAd = this.w;
        if (baseBannerAd instanceof ANUnifiedBannerAdapter) {
            ((ANUnifiedBannerAdapter) baseBannerAd).onWindowFocusChanged(z);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i) {
        if ((i > 0 && i < 10) || i < 0) {
            this.y = 10;
        } else if (i > 150) {
            this.y = 150;
        } else {
            this.y = i;
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseBannerAd baseBannerAd = this.w;
        if (baseBannerAd != null) {
            baseBannerAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: avoid collision after fix types in other method */
    public void e2(BaseBannerAd baseBannerAd) {
        d(baseBannerAd, 70632);
        ADListener aDListener = this.u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(103, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void e(BaseBannerAd baseBannerAd) {
        a(e2.UNIFIED_BANNER);
        this.B = false;
        a2(baseBannerAd);
        BaseBannerAd baseBannerAd2 = this.w;
        if (baseBannerAd2 != null) {
            b50.a(baseBannerAd2.getAdView());
            this.w.destroy();
        }
        this.w = baseBannerAd;
        if (baseBannerAd != null) {
            o();
            if (this.A.contains(Integer.valueOf(this.w.hashCode()))) {
                e2(this.w);
            }
            this.A.clear();
            return;
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BaseBannerAd baseBannerAd, int i) {
        LoadAdParams loadAdParams;
        if ((baseBannerAd instanceof ANUnifiedBannerAdapter) && (loadAdParams = this.x) != null) {
            ((ANUnifiedBannerAdapter) baseBannerAd).setLoadAdParams(loadAdParams);
        }
        baseBannerAd.setAdSize(this.t.getWidth(), this.t.getHeight());
        baseBannerAd.setAdListener(new C0702b(baseBannerAd, i, System.currentTimeMillis()));
        if (baseBannerAd.getAdView() != null) {
            this.t.addView(baseBannerAd.getAdView());
        }
        ri.a(baseBannerAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int a(BaseBannerAd baseBannerAd) {
        return baseBannerAd.getECPM();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(BaseBannerAd baseBannerAd) {
        for (BaseBannerAd baseBannerAd2 : this.z) {
            if (baseBannerAd2 != baseBannerAd) {
                baseBannerAd2.destroy();
            }
        }
        this.z.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseBannerAd b(tr trVar) {
        if (trVar == null) {
            return null;
        }
        try {
            BaseBannerAd baseBannerAdA = com.qq.e.comm.plugin.banner2.a.a(trVar.e(), this.v, trVar.b(), trVar.p(), trVar.j());
            this.z.add(baseBannerAdA);
            return baseBannerAdA;
        } catch (Exception unused) {
            a(70652, trVar);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.s4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String d(BaseBannerAd baseBannerAd) {
        if (c()) {
            return baseBannerAd.getReqId();
        }
        return null;
    }
}
