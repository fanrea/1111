package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bx;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private static boolean Rs = false;
    private static final b Rt = new b() { // from class: com.kwad.components.core.e.d.d.3
        long Rz;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Rz != 0) {
                com.kwad.sdk.core.adlog.c.n(getAdTemplate(), System.currentTimeMillis() - this.Rz);
            }
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.Rt);
            setAdTemplate(null);
            this.Rz = 0L;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Rz = System.currentTimeMillis();
        }
    };

    public static void az(boolean z) {
        com.kwad.sdk.core.adlog.c.bvC = z;
    }

    public static int a(final a.C0469a c0469a, int i) {
        Context context = c0469a.getContext();
        final AdTemplate adTemplate = c0469a.getAdTemplate();
        String strA = a(c0469a, adTemplate);
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        final AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        Activity activityFb = m.fb(context);
        if (activityFb != null && com.kwad.sdk.core.response.b.a.U(adInfoEP) && !c0469a.po()) {
            c0469a.aD(1);
            com.kwad.components.core.e.e.e.a(activityFb, c0469a);
            return 2;
        }
        final String strA2 = a(strA, c0469a, adInfoEP);
        final int i2 = 1;
        return com.kwad.sdk.core.download.a.b.a(context, strA2, new b.a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.f.a.f(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                com.kwad.components.core.proxy.launchdialog.e.sq().aG(adTemplate);
                d.Rt.setAdTemplate(adTemplate);
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.a(d.Rt);
                com.kwad.sdk.core.adlog.c.bvB = d.as(strA2);
                com.kwad.sdk.commercial.f.a.h(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.core.adlog.c.a aVarPz = c0469a.pz();
                if (qe()) {
                    if (aVarPz.QY == null) {
                        aVarPz.QY = new a.C0576a();
                    }
                    aVarPz.QY.bvs = true;
                }
                com.kwad.sdk.commercial.f.a.i(adTemplate, strA2);
                com.kwad.sdk.core.adlog.c.a(adTemplate, "", i2, aVarPz);
                d.a(adTemplate, strA2, i2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void qd() {
                com.kwad.sdk.commercial.f.a.g(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                if (qe()) {
                    aVar.QY = new a.C0576a();
                    aVar.QY.bvs = true;
                }
                com.kwad.sdk.core.adlog.c.b(adTemplate, "", i2, aVar);
                com.kwad.sdk.commercial.f.a.d(adTemplate, strA2, bx.A(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final boolean qe() {
                return com.kwad.sdk.core.response.b.a.cx(adInfoEP);
            }
        });
    }

    private static String a(String str, a.C0469a c0469a, AdInfo adInfo) throws Exception {
        AdTemplate adTemplate = c0469a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bs(adInfo)) {
            str = b(c0469a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.df(adInfo)) {
            str = a(c0469a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cX(adInfo) || com.kwad.sdk.core.response.b.a.dd(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0469a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0469a c0469a, AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : adInfoEP.adConversionInfo.deeplinkConf) {
            boolean zContains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0469a.ee()));
            boolean zContains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0469a.ps()));
            if ((zContains && zContains2) || ((zContains && deeplinkItemInfo.sceneConf.size() == 0) || (zContains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + adInfoEP.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.dh(adInfoEP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject as(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i) {
        if (qb()) {
            return;
        }
        aA(true);
        int iYa = com.kwad.sdk.core.config.e.Ya();
        com.kwad.sdk.core.config.e.Yb();
        int iAbs = Math.abs(iYa);
        if (iAbs > 0) {
            bx.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.aA(false);
                    com.kwad.sdk.core.c.b.aaf();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(adTemplate, "", i);
                    com.kwad.sdk.commercial.f.a.j(adTemplate, str);
                }
            }, null, iAbs * 1000);
        } else {
            aA(false);
        }
    }

    private static String a(a.C0469a c0469a, AdInfo adInfo, String str) throws Exception {
        String strValueOf;
        if (!com.kwad.sdk.core.response.b.a.bp(adInfo)) {
            return str;
        }
        String strCall = null;
        Callable<String> callablePn = c0469a.pn();
        if (callablePn != null) {
            try {
                strCall = callablePn.call();
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(strCall)) {
            strCall = c0469a.pm();
        }
        if (TextUtils.isEmpty(strCall)) {
            return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.b.a.dh(adInfo) : str;
        }
        try {
            strValueOf = String.valueOf(com.kwad.components.core.e.b.a.an(strCall));
        } catch (Throwable unused2) {
            strValueOf = strCall;
        }
        return str.replaceAll("__itemId__", strCall).replaceAll("__simpleItemId__", strValueOf);
    }

    private static boolean qb() {
        return Rs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aA(boolean z) {
        Rs = z;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!as.aE(context, "com.smile.gifmaker") && as.aE(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? l(str, str2) : str;
    }

    private static String b(a.C0469a c0469a, AdInfo adInfo, String str) {
        long jMax = c0469a.getAdTemplate().getmCurPlayTime();
        if (jMax > 0) {
            jMax = Math.max(jMax - com.kwad.sdk.core.response.b.a.bt(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(jMax)).toString();
    }

    private static String l(String str, String str2) {
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return builderAppendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }
}
