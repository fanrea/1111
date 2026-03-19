package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private static long xt;

    private static void o(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.ce(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.tK) {
            r(gVar);
            return;
        }
        gVar.tN = true;
        com.kwad.components.ad.reward.g.a(gVar.tB, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jZ();
            }
        });
        gVar.tt.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        if (gVar.tu != null) {
            gVar.tu.release();
        }
        gVar.gO();
        u(gVar);
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (!gVar.tI) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z2 = !gVar.ha() && W(gVar.mAdTemplate);
        if (O(adTemplate) || P(adTemplate) || gVar.uh < com.kwad.sdk.core.response.b.a.ai(adInfoEP)) {
            if (z2) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                    public final void G(boolean z3) {
                        super.G(z3);
                        if (com.kwad.components.ad.reward.a.b.k(adInfoEP)) {
                            gVar.iE();
                        } else if (com.kwad.sdk.core.response.b.a.cf(adInfoEP)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.b.a.cf(adInfoEP)) {
                p(gVar);
                return;
            } else {
                r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
                return;
            }
        }
        if (gVar.ub) {
            gVar.iE();
            return;
        }
        if (!gVar.ui && gVar.uh < com.kwad.sdk.core.response.b.a.ai(adInfoEP)) {
            if (z) {
                gVar.iE();
                return;
            }
            return;
        }
        if (gVar.ui) {
            gVar.Z(2);
        } else {
            gVar.Z(1);
        }
        y(gVar);
        if (com.kwad.sdk.core.response.b.a.cf(adInfoEP)) {
            p(gVar);
        } else {
            r(gVar);
            com.kwad.components.ad.reward.l.j(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final com.kwad.components.ad.reward.g gVar) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                gVar.hb();
                gVar.tt.onVideoSkipToEnd(gVar.uh);
                gVar.release();
                gVar.iE();
            }
        });
    }

    private static boolean W(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.am(com.kwad.sdk.core.response.b.e.eP(adTemplate));
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().eR(69).eU(gVar.ug != 0 ? (int) (gVar.ug / 1000) : 0).eV(gVar.uh != 0 ? (int) (gVar.uh / 1000) : 0));
    }

    public static void r(final com.kwad.components.ad.reward.g gVar) {
        gVar.tN = true;
        gVar.hb();
        if (i.z(gVar)) {
            bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(gVar);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.tB, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jZ();
            }
        });
        if (gVar.tu != null) {
            gVar.tu.skipToEnd();
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.iE();
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - xt < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        xt = jElapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (a(adInfoEP, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, adInfoEP)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b bVarFb = new com.kwad.sdk.core.adlog.c.b().eP(182).fb(8);
        boolean z = com.kwad.sdk.core.download.a.b.Q(context, com.kwad.sdk.core.response.b.a.dh(adInfoEP)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarFb, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.J(context);
            return;
        }
        String strDk = com.kwad.sdk.core.response.b.a.dk(adInfoEP);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + strDk);
        if (com.kwad.sdk.utils.e.a(context, strDk, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarFb, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        } else {
            if (com.kwad.sdk.utils.e.i(context, adTemplate)) {
                com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarFb, (JSONObject) null);
                com.kwad.sdk.core.adlog.c.h(adTemplate, 0, 8);
                com.kwad.components.ad.reward.h.a.J(context);
                return;
            }
            com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
        }
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bT(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.hP()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.dk(adInfo))) {
            return true;
        }
        int iHO = com.kwad.components.ad.reward.a.b.hO();
        com.kwad.sdk.core.d.c.d(str, "JumpDirectMaxCount " + iHO);
        return iHO <= 0 || com.kwad.components.ad.reward.h.a.dT() >= iHO;
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (!gVar.tI) {
            x(gVar);
            gVar.iE();
            return;
        }
        if (O(adTemplate) || P(adTemplate)) {
            q(gVar);
            if ((gVar.ha() || !W(gVar.mAdTemplate) || gVar.tN) ? false : true) {
                w(gVar);
                return;
            } else {
                x(gVar);
                gVar.iE();
                return;
            }
        }
        long jAi = com.kwad.sdk.core.response.b.a.ai(adInfoEP);
        if (!gVar.ui && gVar.uh < jAi) {
            z = false;
        }
        if (z) {
            y(gVar);
        }
        x(gVar);
        gVar.iE();
    }

    private static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
    }

    private static boolean P(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.P(adTemplate);
    }

    private static void w(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void he() {
                gVar.E(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, 149, gVar.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z) {
                gVar.E(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.r(adTemplate, 151);
                }
                f.x(gVar);
                gVar.iE();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hn() {
                gVar.E(false);
                com.kwad.sdk.core.adlog.c.r(adTemplate, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.tt.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.tt.onRewardVerify();
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, final h.b bVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long jAf = com.kwad.sdk.core.response.b.a.af(adInfoEP);
        final h.c cVarA = com.kwad.components.ad.reward.h.a(gVar, (jAf <= 0 || ((long) com.kwad.sdk.core.response.b.a.M(adInfoEP)) <= jAf) ? "观看完整视频即可获取奖励" : "观看视频" + jAf + "s即可获取奖励");
        com.kwad.components.ad.reward.g.a(gVar, cVarA, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void he() {
                if (gVar.tu != null) {
                    gVar.tu.pause();
                }
                gVar.E(true);
                if (cVarA.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hm() {
                super.hm();
                gVar.E(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z) {
                gVar.E(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.r(adTemplate, 151);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.G(z);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hn() {
                gVar.E(false);
                if (gVar.tu != null) {
                    gVar.tu.resume();
                }
                if (cVarA.getStyle() == 1 || cVarA.getStyle() == 2 || cVarA.getStyle() == 5 || cVarA.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.r(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void hl() {
                super.hl();
                com.kwad.sdk.core.adlog.c.r(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void i(int i, int i2) {
                super.i(i, i2);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, i, i2);
            }
        });
    }
}
