package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static List<WeakReference<k.b>> QH;

    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.az(false);
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.components.ct.api.a aVar = (com.kwad.components.ct.api.a) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.a.class);
        if (aVar != null) {
            aVar.wT().bj(true);
        }
        C0469a c0469aAt = new C0469a(context).aC(adTemplate).a(bVar).b(cVar).aq(z).ar(z2).an(z4).at(false);
        int iAp = com.kwad.sdk.core.response.b.a.ap(adInfoEP);
        if (!(z3 || c0469aAt.pG() == 2 || c0469aAt.pG() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aW(adInfoEP)) && !c0469aAt.pC()) {
            if (iAp == 1) {
                if (com.kwad.sdk.core.response.b.a.bo(adInfoEP)) {
                    return k(c0469aAt);
                }
                return l(c0469aAt);
            }
            if (iAp == 2) {
                int iH = h(c0469aAt);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bo(adInfoEP)) {
                    return k(c0469aAt);
                }
                return l(c0469aAt);
            }
        }
        int iH2 = h(c0469aAt);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            if (j(c0469aAt)) {
                return 11;
            }
            return l(c0469aAt);
        }
        int iM = m(c0469aAt);
        if (adInfoEP.status != 2 && adInfoEP.status != 3) {
            e(c0469aAt);
        }
        return iM;
    }

    public static int a(C0469a c0469a) {
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        d.az(false);
        if (c0469a.pu()) {
            return b(c0469a);
        }
        if (c0469a.pD()) {
            return a(context, adTemplate, c0469a.pq(), c0469a.in(), c0469a.QR, c0469a.px(), false, c0469a.pt());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0469a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.components.ct.api.a aVar = (com.kwad.components.ct.api.a) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.a.class);
        if (aVar != null) {
            aVar.wT().bj(true);
        }
        int iAp = com.kwad.sdk.core.response.b.a.ap(adInfoEP);
        if (!(c0469a.pG() == 2 || c0469a.pG() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aW(adInfoEP)) && !c0469a.pC()) {
            if (iAp == 1) {
                if (com.kwad.sdk.core.response.b.a.bo(adInfoEP)) {
                    return k(c0469a);
                }
                return l(c0469a);
            }
            if (iAp == 2) {
                int iH = h(c0469a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bo(adInfoEP)) {
                    return k(c0469a);
                }
                return l(c0469a);
            }
        }
        int iH2 = h(c0469a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c0469a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0469a.pB() && !com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            return n(c0469a);
        }
        if (!com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c0469a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c0469a)) {
                return 11;
            }
            return l(c0469a);
        }
        if (c0469a.pG() == 2 || c0469a.pG() == 1) {
            c0469a.at(false);
            e(c0469a);
            return m(c0469a);
        }
        if (c0469a.pB() && com.kwad.sdk.core.response.b.a.b(adInfoEP, com.kwad.sdk.core.config.e.XZ()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aW(adInfoEP)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            int iQ = c0469a.in().q(c0469a);
            if (iQ == 0) {
                return k(c0469a);
            }
            e(c0469a);
            d(adTemplate, iQ);
            return iQ;
        }
        e(c0469a);
        c0469a.at(true);
        return m(c0469a);
    }

    private static int b(C0469a c0469a) {
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        Activity activityFb = m.fb(context);
        if (activityFb != null && com.kwad.sdk.core.response.b.a.W(adInfoEP) && !c0469a.po() && !c0469a.pt()) {
            c0469a.aD(2);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0479a().aF(com.kwad.sdk.core.response.b.b.dk(adTemplate)).aE(adTemplate).aH(true).rk());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0469a c0469a) {
        return com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate())) ? !c0469a.pE() && c.A(c0469a) == 3 : d(c0469a) == 1;
    }

    private static int d(C0469a c0469a) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate());
        if (adInfoEP.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iEb = c0469a.eb();
        if (iEb == 2) {
            return adInfoEP.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (iEb == 3) {
            return adInfoEP.unDownloadConf.unDownloadRegionConf.materialJumpType;
        }
        return adInfoEP.unDownloadConf.unDownloadRegionConf.actionBarType;
    }

    private static void e(C0469a c0469a) {
        if (c0469a.po()) {
            return;
        }
        g(c0469a);
        f(c0469a);
        if (c0469a.pq() != null) {
            try {
                c0469a.pq().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bD(c0469a.getAdTemplate());
    }

    private static void f(C0469a c0469a) {
        if (c0469a.py()) {
            com.kwad.sdk.core.adlog.c.a(c0469a.adTemplate, c0469a.pz(), c0469a.iB());
        }
    }

    public static void a(k.b bVar) {
        if (QH == null) {
            QH = new CopyOnWriteArrayList();
        }
        QH.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (QH == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= QH.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = QH.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            QH.remove(i);
        }
    }

    private static void g(C0469a c0469a) {
        k.b bVar;
        List<WeakReference<k.b>> list = QH;
        if (list == null || list.isEmpty() || c0469a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : QH) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.eV(c0469a.adTemplate));
            }
        }
    }

    private static int h(C0469a c0469a) {
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        int iA = d.a(c0469a, 1);
        if (iA == 1) {
            d.az(true);
            e(c0469a);
            if ((com.kwad.sdk.core.response.b.a.de(adInfoEP) || com.kwad.sdk.core.response.b.a.df(adInfoEP)) && !c0469a.pH()) {
                com.kwad.sdk.core.adlog.c.n(c0469a.getAdTemplate(), (int) Math.ceil(c0469a.pw() / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (iA == 2) {
            e(c0469a);
            d(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C0469a c0469a) {
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate());
        Activity activityFb = m.fb(c0469a.getContext());
        if (activityFb != null && com.kwad.sdk.core.response.b.a.U(adInfoEP) && !c0469a.po() && e.E(adInfoEP) && !c0469a.pt()) {
            c0469a.aD(1);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            e(c0469a);
            d(adTemplate, 17);
            return 2;
        }
        int iE = e.e(context, adTemplate);
        if (iE == 1) {
            e(c0469a);
            d(adTemplate, 12);
        }
        return iE;
    }

    private static boolean j(C0469a c0469a) {
        AdTemplate adTemplate = c0469a.getAdTemplate();
        boolean zI = com.kwad.sdk.utils.e.i(c0469a.getContext(), adTemplate);
        if (zI) {
            e(c0469a);
            com.kwad.sdk.core.adlog.c.l(adTemplate, 0);
            d(adTemplate, 11);
        }
        return zI;
    }

    private static int k(C0469a c0469a) {
        e(c0469a);
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(c0469a.getAdTemplate());
        Activity activityFb = m.fb(c0469a.getContext());
        if (activityFb != null && com.kwad.sdk.core.response.b.a.W(adInfoEP) && !c0469a.po() && !c0469a.pt()) {
            c0469a.aD(2);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0469a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0469a c0469a) {
        e(c0469a);
        Context context = c0469a.getContext();
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        Activity activityFb = m.fb(context);
        if (activityFb != null && com.kwad.sdk.core.response.b.a.W(adInfoEP) && !c0469a.po() && !c0469a.pt()) {
            c0469a.aD(2);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0479a().aF(com.kwad.sdk.core.response.b.b.dk(adTemplate)).aE(adTemplate).aI(c0469a.pr()).aU(1).rk());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0469a c0469a) {
        c cVarIn = c0469a.in();
        if (cVarIn == null) {
            cVarIn = new c(c0469a.adTemplate);
            c0469a.b(cVarIn);
        }
        int iR = cVarIn.r(c0469a);
        d(c0469a.getAdTemplate(), iR);
        return iR;
    }

    private static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bT(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bS(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.bK(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bQ(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bR(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bL(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bM(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.bN(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bP(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bO(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bV(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bY(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bU(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bW(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bX(adTemplate);
                break;
        }
    }

    private static int n(C0469a c0469a) {
        AdTemplate adTemplate = c0469a.getAdTemplate();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (j(c0469a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(adInfoEP, com.kwad.sdk.core.config.e.XZ()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0469a);
        }
        return l(c0469a);
    }

    /* renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0469a {
        public long AM;
        private boolean QI;
        private boolean QJ;
        private boolean QK;
        private boolean QL;
        private boolean QM;
        private boolean QN;
        private boolean QO;
        private b QP;
        private c QQ;
        private boolean QR;
        private boolean QS;
        private long QT;
        private boolean QU;
        private boolean QV;
        public String QX;
        public a.C0576a QY;
        private JSONObject Rb;
        private boolean Rd;
        private int Re;
        private int Rf;
        private int Rg;
        private int Rh;
        private Callable<String> Ri;
        private String Rj;
        private AdTemplate adTemplate;
        private final Context dR;
        public aj.a oB;
        private int ox;
        private int oz;
        public int QW = -1;
        public int QZ = 0;
        public int Ra = -1;
        private boolean Rc = false;

        public C0469a(Context context) {
            this.dR = context;
        }

        public final String pm() {
            return this.Rj;
        }

        public final C0469a aq(String str) {
            this.Rj = str;
            return this;
        }

        public final C0469a a(Callable<String> callable) {
            this.Ri = callable;
            return this;
        }

        public final Callable<String> pn() {
            return this.Ri;
        }

        public final Context getContext() {
            return this.dR;
        }

        public final void am(boolean z) {
            this.QS = true;
        }

        public final boolean po() {
            return this.QS;
        }

        public final void aD(int i) {
            this.Rf = i;
        }

        public final int pp() {
            return this.Rf;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final C0469a aC(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final b pq() {
            return this.QP;
        }

        public final boolean pr() {
            return this.QM;
        }

        public final C0469a a(b bVar) {
            this.QP = bVar;
            return this;
        }

        public final int ps() {
            return this.Rh;
        }

        public final C0469a aE(int i) {
            this.Rh = i;
            return this;
        }

        public final C0469a aF(int i) {
            this.oz = i;
            return this;
        }

        public final int ee() {
            return this.oz;
        }

        public final C0469a an(boolean z) {
            this.QN = z;
            return this;
        }

        public final boolean pt() {
            return this.QN;
        }

        public final c in() {
            return this.QQ;
        }

        public final C0469a b(c cVar) {
            this.QQ = cVar;
            return this;
        }

        public final C0469a ao(boolean z) {
            this.QO = true;
            return this;
        }

        public final boolean pu() {
            return this.QO;
        }

        public final C0469a ap(boolean z) {
            this.QM = true;
            return this;
        }

        public final boolean pv() {
            return this.QR;
        }

        public final C0469a aq(boolean z) {
            this.QR = z;
            return this;
        }

        public final long pw() {
            return this.QT;
        }

        public final C0469a A(long j) {
            this.QT = j;
            return this;
        }

        public final boolean px() {
            return this.QU;
        }

        public final C0469a ar(boolean z) {
            this.QU = z;
            return this;
        }

        public final int eb() {
            return this.ox;
        }

        public final C0469a aG(int i) {
            this.ox = i;
            return this;
        }

        public final boolean py() {
            return this.QV;
        }

        public final C0469a as(boolean z) {
            this.QV = z;
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pz() {
            return com.kwad.sdk.core.adlog.c.a.Xs().eJ(this.oz).eG(this.QX).e(this.oB).eK(this.QZ).eL(this.Ra).aT(this.AM).a(this.QY).eM(this.QW);
        }

        public final C0469a ar(String str) {
            this.QX = str;
            return this;
        }

        public final C0469a aH(int i) {
            this.QW = i;
            return this;
        }

        public final C0469a aI(int i) {
            this.QZ = i;
            return this;
        }

        public final C0469a aJ(int i) {
            this.Ra = i;
            return this;
        }

        public final C0469a B(long j) {
            this.AM = j;
            return this;
        }

        public final C0469a d(aj.a aVar) {
            this.oB = aVar;
            return this;
        }

        public final C0469a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.QY == null) {
                this.QY = new a.C0576a();
            }
            this.QY.a(this.adTemplate, null, null, null);
            return this;
        }

        public final boolean pA() {
            return this.Rc;
        }

        public final C0469a at(boolean z) {
            this.Rc = z;
            return this;
        }

        public final JSONObject iB() {
            return this.Rb;
        }

        public final C0469a c(JSONObject jSONObject) {
            this.Rb = jSONObject;
            return this;
        }

        public final boolean pB() {
            return this.QJ;
        }

        public final C0469a au(boolean z) {
            this.QJ = z;
            return this;
        }

        public final boolean pC() {
            return this.QL;
        }

        public final C0469a av(boolean z) {
            this.QL = true;
            return this;
        }

        public final boolean pD() {
            return this.QI;
        }

        public final C0469a aw(boolean z) {
            this.QI = z;
            return this;
        }

        public final boolean pE() {
            return this.Rd;
        }

        public final C0469a ax(boolean z) {
            this.Rd = z;
            return this;
        }

        public final int pF() {
            return this.Re;
        }

        public final C0469a aK(int i) {
            this.Re = i;
            return this;
        }

        public final int pG() {
            return this.Rg;
        }

        public final C0469a aL(int i) {
            this.Rg = i;
            return this;
        }

        public final boolean pH() {
            return this.QK;
        }

        public final C0469a ay(boolean z) {
            this.QK = true;
            return this;
        }
    }
}
