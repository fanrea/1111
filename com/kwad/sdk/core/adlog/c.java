package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bh;
import com.sigmob.sdk.base.mta.PointType;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static ExecutorService bvA = GlobalThreadPools.acg();
    public static JSONObject bvB;
    public static boolean bvC;

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cA(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, aj.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.oz = i;
        if (adTemplate.swipeAngle != 0) {
            aVar2.bwJ = adTemplate.swipeAngle;
        }
        if (aVar != null) {
            aVar2.oB = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.Xu() : null, jSONObject);
    }

    public static boolean b(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo adInfoEP = e.eP(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.fd(Xg());
        com.kwad.sdk.core.adlog.c.a aVarXu = bVar.Xu();
        if (adTemplate.fromCache) {
            aVarXu.a(h.cA(adTemplate));
        }
        aVarXu.bwA = H(adInfoEP) ? 1 : 0;
        return a(adTemplate, 1, aVarXu, jSONObject);
    }

    private static int Xg() {
        return aq.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean H(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String strAB = com.kwad.sdk.core.response.b.a.aB(adInfo);
        if (TextUtils.isEmpty(strAB)) {
            return false;
        }
        return as.aE(fVar.getContext(), strAB);
    }

    public static void a(AdTemplate adTemplate, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0576a c0576a = new a.C0576a();
        if (j != -1) {
            c0576a.duration = j;
            aVar.QY = c0576a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvZ = i;
        a.C0576a c0576a = new a.C0576a();
        c0576a.duration = j;
        aVar.QY = c0576a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.Xu() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.AM = j;
        aVar.bwC = i2;
        aVar.bvZ = i;
        a.C0576a c0576a = new a.C0576a();
        c0576a.duration = j2;
        aVar.QY = c0576a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvZ = 14;
        aVar.QX = str;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void cg(AdTemplate adTemplate) {
        s(adTemplate, 4);
    }

    public static void ch(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0576a());
        aVar.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0576a());
        aVar.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0576a());
        aVar.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo adInfoEP = e.eP(adTemplate);
        String str = adInfoEP.downloadFilePath;
        if (str == null) {
            return;
        }
        String strAB = com.kwad.sdk.core.response.b.a.aB(adInfoEP);
        String strIy = as.iy(str);
        if (strIy == null || TextUtils.isEmpty(strIy) || strIy.equals(strAB)) {
            return;
        }
        bVar.eJ(strIy);
        bVar.eI(strAB);
        adInfoEP.adBaseInfo.appPackageName = strIy;
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        bvA.submit(new bh() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.C0576a c0576a = new a.C0576a();
                c0576a.bvn = adTemplate.downLoadType;
                com.kwad.sdk.core.adlog.c.b bVarES = new com.kwad.sdk.core.adlog.c.b().b(c0576a).eS(adTemplate.downloadSource);
                c.a(adTemplate, bVarES);
                c.a(adTemplate, 31, bVarES.Xu(), jSONObject);
                AdInfo adInfoEP = e.eP(adTemplate);
                as.aB(adInfoEP.downloadFilePath, adInfoEP.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0576a());
        aVar.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        bvA.submit(new bh() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                int iAC = as.aC(adInfoEP.downloadId, com.kwad.sdk.core.response.b.a.aB(adInfoEP));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                aVar.downloadSource = adTemplate.downloadSource;
                aVar.bwo = iAC;
                aVar.bwp = adTemplate.installFrom;
                aVar.a(new a.C0576a());
                aVar.QY.bvn = adTemplate.downLoadType;
                c.a(adTemplate, 32, aVar, jSONObject);
            }
        });
    }

    public static void ci(AdTemplate adTemplate) {
        s(adTemplate, 36);
    }

    public static void cj(AdTemplate adTemplate) {
        s(adTemplate, 38);
    }

    public static void ck(AdTemplate adTemplate) {
        s(adTemplate, 41);
    }

    public static void cl(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwt = com.kwad.sdk.core.response.b.a.aB(e.eP(adTemplate));
        a(adTemplate, SocketMessages.PayloadType.SC_LIVE_PK_KO_MODE, aVar, new JSONObject());
    }

    public static void i(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwF = i;
        aVar.a(new a.C0576a());
        aVar.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.QZ = i;
        a(adTemplate, 923, aVar, (JSONObject) null);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.bwq = aVar.toJson().toString();
        aVar2.a(new a.C0576a());
        aVar2.QY.bvn = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 399, jSONObject);
    }

    public static void cm(AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void cn(AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvZ = 1;
        aVar.QY = new a.C0576a();
        aVar.QY.templateId = PointType.ANTI_SPAM;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.bwl = i;
        if (!str.equals("")) {
            aVar.bwm = str;
        }
        a(adTemplate, 320, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.bwl = i;
        if (!str.equals("")) {
            aVar.bwm = str;
        }
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, String str, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwl = i;
        if (!str.equals("")) {
            aVar.bwm = str;
        }
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwn = i;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void l(AdTemplate adTemplate, int i) {
        h(adTemplate, i, 0);
    }

    public static void h(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwz = i;
        aVar.Ra = i2;
        a(adTemplate, 323, aVar, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0576a c0576a = new a.C0576a();
        if (z) {
            c0576a.bvr = 1;
        } else {
            c0576a.bvr = 2;
        }
        aVar.a(c0576a);
        a(adTemplate, 323, aVar, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0576a c0576a = new a.C0576a();
        if (z) {
            c0576a.bvr = 1;
        } else {
            c0576a.bvr = 2;
        }
        aVar.a(c0576a);
        a(adTemplate, 652, aVar, (JSONObject) null);
    }

    public static void co(AdTemplate adTemplate) {
        s(adTemplate, 58);
    }

    public static void cp(AdTemplate adTemplate) {
        s(adTemplate, 243);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.bwx = j;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, long j) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Xs().aU(j), (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 501, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwa = 69;
        aVar.bwv = i;
        aVar.bww = i2;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 450, jSONObject);
    }

    public static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 451, jSONObject);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, 451, bVar != null ? bVar.Xu() : null, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvY = i;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvX = i;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bvX = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void cq(AdTemplate adTemplate) {
        s(adTemplate, SocketMessages.PayloadType.SC_LIVE_INTERACTIVE_WIDGET);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().eR(i));
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarXu = bVar.Xu();
        aVarXu.e(adTemplate, null, null);
        a(adTemplate, 140, aVarXu, jSONObject);
    }

    @Deprecated
    public static void c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.b bVarER = new com.kwad.sdk.core.adlog.c.b().eR(i);
        a(adTemplate, bVarER);
        d(adTemplate, (JSONObject) null, bVarER);
    }

    public static void o(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a(adTemplate, bVar);
        a(adTemplate, i, bVar.Xu(), new JSONObject());
    }

    public static void p(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwt = com.kwad.sdk.core.response.b.a.aB(e.eP(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwt = com.kwad.sdk.core.response.b.a.aB(e.eP(adTemplate));
        aVar.bwa = 93;
        a(adTemplate, 140, aVar, (JSONObject) null);
    }

    public static void q(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void r(AdTemplate adTemplate, int i) {
        e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(i));
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarXu = bVar.Xu();
        aVarXu.e(adTemplate, null, null);
        a(adTemplate, 141, aVarXu, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwc = j;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == -9999 || i == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.bwd = i;
            if (adExposureFailedReason != null) {
                aVar.bwe = adExposureFailedReason.winEcpm;
                try {
                    aVar.adnType = adExposureFailedReason.adnType;
                    if (adExposureFailedReason.adnType == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.bwf = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.bwg = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.bwh = adExposureFailedReason.adRequestId;
                    }
                    aVar.bwi = adExposureFailedReason.isShow;
                    aVar.bwj = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, 809, aVar, (JSONObject) null);
        }
    }

    public static void cr(AdTemplate adTemplate) {
        a(adTemplate, 242, (com.kwad.sdk.core.adlog.c.a) null, (JSONObject) null);
    }

    public static void cs(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bJ(e.eP(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, 713, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.QX = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void ct(AdTemplate adTemplate) {
        s(adTemplate, 722);
    }

    public static void cu(AdTemplate adTemplate) {
        s(adTemplate, 721);
    }

    public static void n(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.bwy = j;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0576a c0576a = new a.C0576a();
        c0576a.bvo = 1;
        bVar.b(c0576a);
        if (z) {
            bVar.eY(33);
        }
        a(adTemplate, 804, bVar.Xu(), (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0576a c0576a = new a.C0576a();
        c0576a.bvo = 2;
        bVar.b(c0576a);
        if (z) {
            bVar.eY(33);
        }
        a(adTemplate, 804, bVar.Xu(), (JSONObject) null);
    }

    private static void s(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    private static void e(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static boolean a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (adTemplate == null || !cv(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.bwB = com.kwad.sdk.core.response.b.a.aX(e.eP(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i == 2 && bvC) {
            if (aVar.QY == null) {
                aVar.QY = new a.C0576a();
            }
            aVar.QY.bvu = bvB;
        }
        if (i == 1 && e.eJ(adTemplate) == 4 && com.kwad.sdk.core.response.b.a.dI(e.eP(adTemplate))) {
            if (aVar.QY == null) {
                aVar.QY = new a.C0576a();
            }
            aVar.QY.bvt = com.kwad.sdk.core.response.b.a.dJ(e.eP(adTemplate));
        }
        aVar.adTemplate = adTemplate;
        aVar.buM = i;
        aVar.bvW = jSONObject;
        com.kwad.sdk.core.d.c.d("AdReportManager", new StringBuilder().append(i).toString());
        b.a(aVar);
        return true;
    }

    private static boolean cv(AdTemplate adTemplate) {
        if (e.eH(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aR(adTemplate);
    }
}
