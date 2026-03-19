package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.d, com.kwad.sdk.core.webview.a {
    private AdTemplate Rk;
    private boolean Rl;
    private a Rm;
    private DialogInterface.OnShowListener Rn;
    private List<KsAppDownloadListener> Ro;
    private boolean downloadPauseEnable;
    private AdInfo mAdInfo;
    private Handler mHandler;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Ro = new ArrayList();
        this.Rk = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        pJ();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.b.e.eP(this.Rk));
        pI();
        com.kwad.sdk.a.a.c.VC().bo(this.Rk);
    }

    public final void pI() {
        com.kwad.sdk.core.download.c.ZJ().a(this, this.Rk);
        if (com.kwad.sdk.core.config.e.Yt()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this, this.Rk);
        }
    }

    private void pJ() {
        com.kwad.sdk.core.download.c.ZJ();
        int iFd = com.kwad.sdk.core.download.c.fd(pL());
        if (iFd != 0) {
            this.mAdInfo.status = iFd;
        }
        pP();
        pO();
    }

    public final void aM(int i) {
        this.Rk.downloadSource = i;
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    public final int pK() {
        pP();
        if (this.mAdInfo.status == 3) {
            return 2;
        }
        return this.mAdInfo.status;
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        this.mAdInfo.adConversionInfo.appDownloadUrl = str;
        this.mAdInfo.adBaseInfo.appPackageName = str2;
        this.mAdInfo.downloadId = al.md5(str);
    }

    @Override // com.kwad.sdk.core.download.d
    public final String pL() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String pM() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            pO();
            if (fVar.ZN()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.ch(this.Rk);
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.y(this.Rk);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 3;
            this.mAdInfo.progress = i;
            this.mAdInfo.soFarBytes = i2;
            this.mAdInfo.totalBytes = i3;
            pO();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.downloadFilePath = str2;
            this.mAdInfo.progress = 100;
            this.mAdInfo.status = 8;
            pO();
            if (fVar.ZN()) {
                fVar.ZM();
                com.kwad.sdk.core.adlog.c.c(this.Rk, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.k(this.Rk, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.WS().e(str, this.Rk);
                h.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.ct.api.a aVar = (com.kwad.components.ct.api.a) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.a.class);
                        if (aVar != null) {
                            aVar.wT().aS(c.this.Rk);
                        }
                    }
                });
                com.kwad.sdk.a.a.c.VC().bq(this.Rk);
                com.kwad.sdk.a.a.c.VC().bo(this.Rk);
                com.kwad.sdk.a.a.b.Vz().aS(this.Rk);
                ApkCacheManager.getInstance().Zx();
            }
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            pO();
            if (fVar.ZN()) {
                c.a aVar = new c.a(i, str2);
                com.kwad.sdk.core.adlog.c.a(this.Rk, aVar);
                com.kwad.components.core.q.a.ss().a(this.Rk, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.h(this.Rk, i, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Rl || SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime >= this.mAdInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aW(this.mAdInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.Rk);
            this.Rl = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && fVar.ZN()) {
                com.kwad.sdk.core.adlog.c.a(this.Rk, this.mReportExtData);
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.bv(this.Rk);
            }
            this.mAdInfo.status = 4;
            pO();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void c(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            Integer num = com.kwad.sdk.core.download.c.bBv.get(str);
            if (num != null && num.intValue() == 2) {
                this.Rk.downLoadType = 2;
                com.kwad.sdk.core.download.c.bBv.remove(str);
            }
            if (this.mAdInfo.status != 2 && fVar.ZN()) {
                com.kwad.sdk.core.adlog.c.b(this.Rk, this.mReportExtData);
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.bw(this.Rk);
            }
            this.mAdInfo.status = 2;
            pO();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void d(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && fVar.ZN()) {
                com.kwad.sdk.core.adlog.c.d(this.Rk, this.mReportExtData);
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.bx(this.Rk);
            }
            com.kwad.sdk.a.a.c.VC().bp(this.Rk);
            com.kwad.sdk.a.a.b.Vz().aT(this.Rk);
            this.mAdInfo.status = 5;
            pO();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void e(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            pO();
            if (fVar.ZN()) {
                com.kwad.sdk.core.adlog.c.i(this.Rk, 2);
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.bz(this.Rk);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, String str2, f fVar) {
        final boolean zPN;
        this.mAdInfo.status = 12;
        pO();
        if (fVar.ZN()) {
            com.kwad.sdk.core.adlog.c.e(this.Rk, this.mReportExtData);
            fVar.ZM();
            com.kwad.sdk.commercial.a.a.bA(this.Rk);
            zPN = pN();
            com.kwad.sdk.a.a.c.VC().br(this.Rk);
            com.kwad.sdk.a.a.c.VC().bp(this.Rk);
            com.kwad.sdk.a.a.b.Vz().aT(this.Rk);
            com.kwad.components.core.e.a.e.oS().ay(this.Rk);
            com.kwad.sdk.core.a.WS().bR(pL());
        } else {
            zPN = false;
        }
        h.execute(new bh() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.ct.api.a aVar = (com.kwad.components.ct.api.a) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.a.class);
                if (aVar != null) {
                    com.kwad.components.ct.api.a.b bVarWT = aVar.wT();
                    bVarWT.aT(c.this.Rk);
                    if (zPN) {
                        return;
                    }
                    bVarWT.aU(c.this.Rk);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.download.d
    public final void f(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            pP();
            if (fVar.ZN()) {
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.bB(this.Rk);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, Throwable th, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            pO();
            if (fVar.ZN()) {
                fVar.ZM();
                com.kwad.sdk.commercial.a.a.i(this.Rk, 100003, Log.getStackTraceString(th));
            }
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void g(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str) && fVar.ZN()) {
            fVar.ZM();
            com.kwad.sdk.core.adlog.c.ci(this.Rk);
            com.kwad.sdk.commercial.a.a.by(this.Rk);
        }
    }

    private boolean pN() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Rk.mIsFromContent && com.kwad.sdk.core.config.e.Xy()) {
                zPT = pT();
                if (zPT) {
                    com.kwad.sdk.core.adlog.c.ck(this.Rk);
                }
            } else if (!this.Rk.mIsFromContent && com.kwad.sdk.core.config.e.Yg()) {
                boolean zAv = com.kwad.components.core.m.b.av(ServiceProvider.getContext());
                com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + zAv);
                zPT = zAv ? pT() : false;
                if (zPT) {
                    com.kwad.sdk.core.adlog.c.cl(this.Rk);
                }
            }
        }
        return zPT;
    }

    private void pO() {
        this.mHandler.post(new bh() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.Ro.size());
                arrayList.addAll(c.this.Ro);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        int iUE = com.kwad.sdk.core.config.e.UE();
        boolean zUD = com.kwad.sdk.core.config.e.UD();
        com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "DownloadProgressTransformUtil  go in updateDownloadProgress");
        int iA = t.a(this.mAdInfo.soFarBytes, this.mAdInfo.totalBytes, zUD, iUE);
        switch (this.mAdInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                break;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    break;
                } else {
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                        break;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(iA);
                break;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(iA);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(iA);
                        break;
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                break;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                break;
            case 12:
                ksAppDownloadListener.onInstalled();
                break;
        }
    }

    public final void pP() {
        if (as.aF(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        if (this.mAdInfo.status == 12) {
            this.mAdInfo.status = 0;
            this.mAdInfo.progress = 0;
        }
        if (this.mAdInfo.status == 8 || this.mAdInfo.status == 9) {
            String str = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                this.mAdInfo.status = 0;
                this.mAdInfo.progress = 0;
            }
        }
        if (this.mAdInfo.status == 0) {
            String strI = com.kwad.sdk.core.download.a.I(this.mAdInfo);
            if (TextUtils.isEmpty(strI) || !new File(strI).exists()) {
                return;
            }
            this.mAdInfo.downloadFilePath = strI;
            this.mAdInfo.status = 8;
        }
    }

    public final int q(a.C0469a c0469a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return pU();
                case 12:
                    return z(c0469a);
                default:
                    return 0;
            }
        }
        return t(c0469a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0469a c0469a) {
        this.Rl = false;
        pP();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0469a);
            case 2:
            case 3:
                if (c0469a.pv() && this.downloadPauseEnable) {
                    return pW();
                }
                return 0;
            case 4:
                return pX();
            case 8:
            case 9:
            case 11:
                return pU();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0469a);
        }
    }

    public final AdTemplate pQ() {
        return this.Rk;
    }

    public final boolean s(a.C0469a c0469a) {
        return this.mAdInfo.status == 0 && t(c0469a);
    }

    private boolean t(a.C0469a c0469a) {
        boolean zI = com.kwad.sdk.utils.e.i(c0469a.getContext(), this.Rk);
        if (zI) {
            com.kwad.sdk.core.adlog.c.l(this.Rk, 0);
        }
        return zI;
    }

    private int u(a.C0469a c0469a) {
        Context context = c0469a.getContext();
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.dk(this.mAdInfo), this.Rk)) {
            com.kwad.sdk.core.adlog.c.l(this.Rk, 1);
            return 11;
        }
        if (t(c0469a)) {
            return 11;
        }
        if (pR()) {
            return 10;
        }
        if (!ao.isNetworkConnected(context)) {
            ac.ae(context, ae.dv(context));
            return 2;
        }
        if (c0469a.pE() && com.kwad.sdk.core.config.e.XS()) {
            return v(c0469a);
        }
        if (com.kwad.sdk.core.response.b.e.fa(this.Rk) && c0469a.pG() != 2) {
            return d(c0469a.getContext(), c0469a.getAdTemplate());
        }
        if (c0469a.pA()) {
            return w(c0469a);
        }
        if (x(c0469a)) {
            return 8;
        }
        return pV();
    }

    private int v(a.C0469a c0469a) {
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        int iPF = c0469a.pF();
        if (iPF == 1) {
            return pV();
        }
        if (iPF != 2) {
            return 1;
        }
        if (!com.kwad.sdk.core.response.b.b.dO(adTemplate)) {
            return 8;
        }
        com.kwad.components.core.e.c.b.a(context, new b.a().aB(adTemplate).ap(com.kwad.sdk.core.response.b.b.dN(adTemplate)).a(this.Rn).c(this.mOnDismissListener).pi());
        return 8;
    }

    private int w(a.C0469a c0469a) {
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        int iA = A(c0469a);
        if (iA == 1) {
            if (com.kwad.sdk.core.response.b.b.dO(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().aB(adTemplate).ap(com.kwad.sdk.core.response.b.b.dN(adTemplate)).a(this.Rn).c(this.mOnDismissListener).pi());
            }
            return 8;
        }
        if (iA == 2) {
            return d(c0469a.getContext(), c0469a.getAdTemplate());
        }
        if (iA == 3) {
            return 1;
        }
        if (x(c0469a)) {
            return 8;
        }
        return pV();
    }

    private boolean x(a.C0469a c0469a) {
        if (c0469a.px() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.b.b.dR(this.Rk) || !y(c0469a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0469a.getContext(), new b.a().aB(this.Rk).ap(com.kwad.sdk.core.response.b.b.dQ(this.Rk)).a(this.Rn).c(this.mOnDismissListener).pi());
    }

    private static boolean y(a.C0469a c0469a) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bF(adInfoEP) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0469a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bG(adInfoEP) && !ao.isWifiConnected(c0469a.getContext());
    }

    private boolean pR() {
        a aVar = this.Rm;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 5:
                            case 6:
                            case 7:
                                c.this.pV();
                                break;
                            case 4:
                                c.this.pX();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                c.this.pU();
                                break;
                            case 12:
                                c.this.pS();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private int z(a.C0469a c0469a) {
        Activity activityFb = m.fb(c0469a.getContext());
        if (activityFb != null && com.kwad.sdk.core.response.b.a.U(this.mAdInfo) && !c0469a.po() && !c0469a.pt()) {
            c0469a.aD(1);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            return 18;
        }
        return pS();
    }

    public final int pS() {
        h.execute(new bh() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.ct.api.a aVar = (com.kwad.components.ct.api.a) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.a.class);
                if (aVar != null) {
                    aVar.wT().aV(c.this.Rk);
                }
            }
        });
        if (!as.aH(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.aB(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.cj(this.Rk);
        return 6;
    }

    private boolean pT() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0469a(context).aC(this.Rk), 1) == 1) {
            return true;
        }
        boolean zAH = as.aH(context, com.kwad.sdk.core.response.b.a.aB(this.mAdInfo));
        if (zAH) {
            com.kwad.sdk.core.adlog.c.cj(this.Rk);
        }
        return zAH;
    }

    public final int pU() {
        as.a(this.mAdInfo.downloadFilePath, new as.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.as.a
            public final void qa() {
                com.kwad.sdk.core.adlog.c.i(c.this.Rk, 1);
                com.kwad.sdk.commercial.a.a.bz(c.this.Rk);
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void g(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.Rk, 100003, Log.getStackTraceString(th));
            }
        });
        return 7;
    }

    public final int pV() {
        com.kwad.sdk.core.download.a.J(this.mAdInfo);
        return 3;
    }

    public final int pW() {
        com.kwad.sdk.core.download.a.fa(this.mAdInfo.downloadId);
        return 4;
    }

    public final int pX() {
        this.Rk.downLoadType = 2;
        pV();
        return 5;
    }

    private int pY() {
        this.Rk.downLoadType = 1;
        pV();
        return 5;
    }

    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.Ro.contains(ksAppDownloadListener)) {
                this.Ro.add(0, ksAppDownloadListener);
            }
        } else {
            this.mHandler.post(new bh() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (c.this.Ro.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.Ro.add(0, ksAppDownloadListener);
                }
            });
        }
        pP();
        a(ksAppDownloadListener);
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.Ro.remove(ksAppDownloadListener);
        } else {
            this.mHandler.post(new bh() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    c.this.Ro.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        pP();
        a(ksAppDownloadListener);
    }

    public static int A(a.C0469a c0469a) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate());
        if (adInfoEP.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int iEb = c0469a.eb();
        if (iEb == 2) {
            return adInfoEP.downloadSafeInfo.complianceInfo.describeBarType;
        }
        if (iEb == 3) {
            return adInfoEP.downloadSafeInfo.complianceInfo.materialJumpType;
        }
        return adInfoEP.downloadSafeInfo.complianceInfo.actionBarType;
    }

    private static int d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void clear() {
        pZ();
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void pZ() {
        List<KsAppDownloadListener> list = this.Ro;
        if (list != null) {
            list.clear();
        }
    }

    public final void a(a aVar) {
        this.Rm = aVar;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Rn = onShowListener;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            pY();
        }
    }
}
