package com.kwad.sdk.commercial;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import com.sigmob.sdk.base.n;
import com.sigmob.windad.WindAds;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static float btI = -1.0f;
    private static double btJ = -1.0d;
    private static final AtomicBoolean btK = new AtomicBoolean();
    private static final AtomicBoolean btL = new AtomicBoolean();
    private static boolean btM;
    private static volatile boolean btN;
    private static List<c> btO;
    private static a btP;
    private static Map<String, com.kwad.sdk.commercial.c.c> btQ;

    public interface a {
        boolean Vq();

        boolean Vr();

        JSONObject Vs();

        String Vt();

        void l(String str, String str2, boolean z);
    }

    public static synchronized void a(final a aVar, final boolean z) {
        if (btM) {
            return;
        }
        btM = true;
        btP = aVar;
        h.execute(new bh() { // from class: com.kwad.sdk.commercial.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    b.b(aVar, z);
                    b.Wx();
                    b.btK.set(true);
                    b.oE();
                } catch (Throwable th) {
                    b.btL.set(true);
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Wx() {
        try {
            btQ = new HashMap();
            JSONObject jSONObjectVs = btP.Vs();
            if (jSONObjectVs == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectVs.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectVs.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    a(next, jSONObjectOptJSONObject.optJSONArray(n.C));
                    b(next, jSONObjectOptJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = btQ.get(strA);
                        if (cVar2 != null) {
                            cVar2.buq = true;
                            cVar2.bun = Double.parseDouble(str);
                        } else {
                            cVar.buq = true;
                            cVar.bun = Double.parseDouble(str);
                            btQ.put(strA, cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = btQ.get(strA);
                        if (cVar2 != null) {
                            cVar2.bur = true;
                            cVar2.buo = Double.parseDouble(str);
                        } else {
                            cVar.bur = true;
                            cVar.buo = Double.parseDouble(str);
                            btQ.put(strA, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && iLastIndexOf != -1) {
                bVar.bup = str.substring(iLastIndexOf + 1);
                return str.substring(0, iLastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d;
        double d2;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            if (com.kwad.framework.a.a.qr.booleanValue()) {
                bVar.bun = cVar.btW;
            } else {
                bVar.bun = cVar.btV;
            }
            bVar.buo = cVar.btX;
            if (!btQ.containsKey(cVar.eventId) || (cVar3 = btQ.get(cVar.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = cVar3.buq ? cVar3.bun : -1.0d;
                d2 = cVar3.bur ? cVar3.buo : -1.0d;
                if (!TextUtils.isEmpty(cVar3.bup)) {
                    bVar.bup = cVar3.bup;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && com.kwad.framework.a.a.qr.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + Config.replace + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + Config.replace + cVar.primaryKey;
                }
                if (btQ.containsKey(str) && (cVar2 = btQ.get(str)) != null) {
                    if (cVar2.buq) {
                        d = cVar2.bun;
                    }
                    if (cVar2.bur) {
                        d2 = cVar2.buo;
                    }
                    if (!TextUtils.isEmpty(cVar2.bup)) {
                        bVar.bup = cVar2.bup;
                    }
                }
            }
            if (d != -1.0d) {
                bVar.bun = d;
            }
            if (d2 != -1.0d) {
                bVar.buo = d2;
            } else {
                bVar.buo = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Uq();
            }
            cVar.btV = bVar.bun;
            cVar.btX = bVar.buo;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static void b(c cVar) {
        c.a aVarArz;
        if (btN) {
            com.kwad.sdk.commercial.c.b bVarA = a(cVar);
            if (btI == -1.0f) {
                btI = new Random().nextFloat();
            }
            if (btJ == -1.0d) {
                btJ = new Random().nextFloat();
            }
            if ((btP.Vr() || btI <= bVarA.bun) && by.aH(BuildConfig.VERSION_NAME, bVarA.bup)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        aVarArz = c.a.ary();
                    } else {
                        aVarArz = c.a.arz();
                    }
                    com.kwai.adclient.kscommerciallogger.a.arp().a(aVarArz.c(cVar.btY).b(cVar.btZ).ji(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.bua).jj(cVar.eventId).t(a(cVar.msg, bVarA)).arA());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private static void c(c cVar) {
        if (btO == null) {
            btO = new CopyOnWriteArrayList();
        }
        btO.add(cVar);
    }

    public static synchronized void d(c cVar) {
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + cVar);
            } else {
                com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + cVar);
            }
        }
        if (!btK.get()) {
            if (!btL.get()) {
                c(cVar);
            }
        } else {
            b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z) {
        boolean zVq = aVar.Vq();
        btN = zVq;
        if (zVq) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "publish_type", 0);
            aa.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a.arp().a(new com.kwad.sdk.commercial.a(), new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.3
                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void T(String str, String str2) {
                    U(str, str2);
                }

                private void U(String str, String str2) {
                    aVar.l(str, str2, false);
                }
            }, jSONObject, com.kwad.framework.a.a.qr.booleanValue(), com.kwad.framework.a.a.qr.booleanValue());
            com.kwad.sdk.commercial.h.a.WH().bJ(aVar.Vt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void oE() {
        List<c> list = btO;
        if (list == null) {
            return;
        }
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        btO.clear();
        btO = null;
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || btJ >= cVar.btX) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(str).l(0.001d).V(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").b(BusinessType.AD_SDK_INIT).w(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_reward_check_result", "check_type").b(BusinessType.AD_REWARD).w(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V(z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V(z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crt));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V(z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.cqW));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V(z ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V(z ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.5d).V("ad_sdk_webview_track", WindAds.AD_SCENE_ID).b(BusinessType.AD_WEBVIEW).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V(z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", WindAds.REWARD_TYPE).b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crz));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V(str, WindAds.REWARD_TYPE).b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crz));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(0.01d).V("ad_sdk_reward_performance", WindAds.REWARD_TYPE).b(BusinessType.AD_REWARD).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_reward_performance", "page_status").b(BusinessType.AD_REWARD).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Wz().dW(str).l(1.0E-4d).V("union_web_cache_download_event", "state").b(BusinessType.WEB_CACHE).w(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Wz().dW(str).l(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).V("union_web_cache_load_event", "state").b(BusinessType.WEB_CACHE).w(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.Wz().dW(str).l(1.0d).V("union_webview_load_event", "state").w(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            if (webViewCommercialMsg.rate >= 0.0d) {
                aa.putValue(webViewCommercialMsg.msg, n.C, webViewCommercialMsg.rate);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.Wz().dW(str).l(webViewCommercialMsg.rate).V(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).b(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).l(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(1.0E-5d).V("ad_perf_monitor_net_success", "network_monitor").w(jVar).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.1d).V("ad_perf_monitor_net_error", "network_monitor").w(iVar).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_union_kv_fail_rate", "kv").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.4
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.1d).V("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.1d).V("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.5
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.1d).V("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.1d).V("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(final boolean z, final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.6
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crf));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crf));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.7
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crf));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crf));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.8
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.9
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.10
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UF()) {
            h.schedule(new bh() { // from class: com.kwad.sdk.commercial.b.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).V("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("load_status");
            d(c.Wz().dW((iOptInt == 3 || iOptInt == 4 || iOptInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(1.0d).m(0.1d).n(0.001d).V("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.crg).l(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(str).l(0.001d).V("ad_sdk_resource_warmup", "warm_up").b(BusinessType.OTHER).w(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(str).l(0.001d).V("ad_sdk_local_warmup", "warm_up").b(BusinessType.OTHER).w(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_image_load_perf", "image_perf").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.001d).V("ad_video_load_perf", "video_load_perf").dX("ad_video_load_perf").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.001d).V("ad_video_load_failed", "video_load_failed").dX("ad_video_load_failed").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_wayne_player_vse_monitor", "status").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void u(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_installer_info", "status").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.crI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void v(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_uaid_data_performance", "status").w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            aa.putValue(jSONObject, n.C, bVar.bun);
            if (bVar.bun > 0.0d) {
                aa.putValue(jSONObject, "ratio_count", a(1.0d, bVar.bun, 0));
            }
            aa.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.qr.booleanValue() ? 1 : 0);
            aa.putValue(jSONObject, "convert_ratio", bVar.buo);
            if (bVar.buo > 0.0d) {
                aa.putValue(jSONObject, "convert_ratio_count", a(1.0d, bVar.buo, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return jSONObject;
        }
    }

    private static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
