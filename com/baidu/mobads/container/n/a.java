package com.baidu.mobads.container.n;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.container.nativecpu.be;
import com.baidu.mobads.container.nativecpu.j;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.az;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.t;
import com.baidu.mobads.container.util.x;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "DETAIL_NEWS_NOVELBOTTOM";
    public static final String b = "DETAIL_NEWS_NOVELINNER";
    public static final String c = "DETAIL_NEWS_NOVEL_BOOK_MALL";
    public static final String d = "DETAIL_NEWS_NOVEL_BOOK_SHELF";
    public static final String e = "STIMULATE_DEEPLINK";
    public static final String j = "https://cpu-openapi.baidu.com/api/v2/data/ads";
    private static final String l = "http://cpu-openapi.baidu.com/api/v2/data/novel/detail/ads";
    protected final j f;
    private final LinkedBlockingQueue<com.baidu.mobads.container.nativecpu.a> k;
    private String m;
    public int i = 10000;
    protected Runnable h = new b(this);
    protected Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.mobads.container.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0129a {
        void a(com.baidu.mobads.container.nativecpu.a aVar);

        void a(String str);
    }

    public a(j jVar, int i) {
        this.f = jVar;
        this.k = new LinkedBlockingQueue<>(i);
        if (this.f.z == null) {
            this.f.z = new be(this.f);
        }
    }

    public void a(String str, g gVar, Map<String, Object> map, InterfaceC0129a interfaceC0129a) {
        com.baidu.mobads.container.components.g.f fVar;
        com.baidu.mobads.container.nativecpu.a aVarPoll;
        boolean z = true;
        if (d.equals(str) || c.equals(str)) {
            fVar = new com.baidu.mobads.container.components.g.f(1, j, "POST");
        } else {
            fVar = new com.baidu.mobads.container.components.g.f(1, l, "POST");
        }
        fVar.a(this.i);
        fVar.a("application/json");
        if (!b.equals(str)) {
            aVarPoll = null;
        } else {
            aVarPoll = this.k.poll();
        }
        if (interfaceC0129a != null && aVarPoll != null) {
            interfaceC0129a.a(aVarPoll);
            z = false;
        }
        String strA = a(str, gVar, map);
        fVar.a(new c(this, str, interfaceC0129a, z));
        if (!TextUtils.isEmpty(strA)) {
            Uri.Builder builder = new Uri.Builder();
            builder.encodedQuery(strA);
            fVar.a(builder);
            fVar.a();
            b();
        }
    }

    protected String a(String str, g gVar, Map<String, Object> map) throws JSONException {
        JSONObject jSONObjectH;
        try {
            JSONObject jSONObject = new JSONObject();
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("appsid", this.f.z());
            jSONObject.put(com.alipay.sdk.m.t.a.k, jCurrentTimeMillis);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "sdk");
            jSONObject2.put("osType", 1);
            jSONObject2.put("sdkVersion", "android_" + com.baidu.mobads.container.j.b());
            jSONObject2.put("pack", this.f.b.getPackageName());
            jSONObject2.put("sdkProxyVersion", com.baidu.mobads.container.config.b.a().j());
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.aq, DeviceUtils.getInstance().r(this.f.b));
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.X, "sdk_9.40");
            JSONObject jSONObjectB = b(str, gVar, map);
            String strK = this.f.K();
            String strC = this.f.c(String.valueOf(jCurrentTimeMillis), jSONObjectB.toString());
            if (j.C == -1) {
                SPUtils sPUtils = new SPUtils(this.f.b, "cpu_sp_file");
                if (sPUtils.b("fisrtCCTime", -1L) == -1) {
                    j.C = System.currentTimeMillis();
                    sPUtils.a("fisrtCCTime", j.C);
                    jSONObject.put("fisrtCCTime", j.C);
                }
            }
            jSONObject.put("from", jSONObject2);
            jSONObject.put("accessType", 1);
            if (gVar != null && (jSONObjectH = gVar.h()) != null) {
                Iterator<String> itKeys = jSONObjectH.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectH.put(next, String.valueOf(jSONObjectH.get(next)));
                }
                jSONObject.put("extParams", jSONObjectH);
            }
            jSONObject.put("data", jSONObjectB);
            jSONObject.put("sdata", strK);
            jSONObject.put("signature", strC);
            jSONObject.put("subChannelId", this.m);
            return jSONObject.toString();
        } catch (Exception e2) {
            bq.a().c(e2.getMessage());
            return null;
        }
    }

    private JSONObject b(String str, g gVar, Map<String, Object> map) throws JSONException {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map == null) {
            iIntValue = 0;
        } else {
            Object obj = map.get("entry");
            Object obj2 = map.get("channelId");
            Object obj3 = map.get("novel_id");
            if (obj == null) {
                iIntValue = 0;
            } else {
                iIntValue = ((Integer) obj).intValue();
                jSONObject2.put("entry", iIntValue);
            }
            if (obj2 != null) {
                jSONObject2.put("channelId", ((Integer) obj2).intValue());
            }
            if (obj3 != null) {
                jSONObject2.put("novelId", (String) obj3);
            }
        }
        if (gVar != null) {
            jSONObject2.put("title", gVar.c());
            jSONObject2.put("outerId", gVar.b());
            jSONObject2.put("novelName", gVar.c());
            jSONObject2.put("chapterName", gVar.d());
            jSONObject2.put("userSex", gVar.e());
            jSONObject2.put("novelCategory", gVar.f());
            jSONObject2.put("readDuration", gVar.g());
        }
        jSONObject2.put("showVideoAd", 1);
        jSONObject2.put(com.baidu.mobads.container.adrequest.g.l, 3);
        jSONObject2.put("pageContentLabel", (Object) null);
        jSONObject2.put("scenePositionCodes", str);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("connectionType", com.baidu.mobads.container.util.e.a.d(this.f.b));
        jSONObject3.put("operatorType", com.baidu.mobads.container.util.e.a.b(this.f.b));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.v, DeviceUtils.getInstance().n(this.f.b));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.s, DeviceUtils.getInstance().g(this.f.b));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.w, "");
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.ad, com.baidu.mobads.container.util.e.a.a(this.f.b));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.u, DeviceUtils.getInstance().h(this.f.b));
        jSONObject3.put("gps", DeviceUtils.getInstance().d(this.f.b));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("deviceType", 1);
        jSONObject4.put("osType", 1);
        jSONObject4.put("osVersion", x.a(this.f.t()).c());
        jSONObject4.put("vendor", DeviceUtils.getInstance().b());
        jSONObject4.put("model", x.a(this.f.t()).d());
        JSONObject jSONObject5 = new JSONObject();
        Pair<Integer, Integer> pairE = com.baidu.mobads.container.util.e.a.e(this.f.b);
        jSONObject5.put("width", pairE != null ? ((Integer) pairE.first).intValue() : 0);
        jSONObject5.put("height", pairE != null ? ((Integer) pairE.second).intValue() : 0);
        jSONObject4.put("screenSize", jSONObject5);
        jSONObject4.put("density", "" + bv.e(this.f.b));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.ak, DeviceUtils.getInstance().e());
        jSONObject4.put("imsi", DeviceUtils.getInstance().k(this.f.b));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.aj, DeviceUtils.getInstance().d());
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.V, bw.a(this.f.b) + "," + bw.b(this.f.b));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.x, "");
        jSONObject4.put("sn", DeviceUtils.getInstance().b(this.f.b));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.B, DeviceUtils.getInstance().j(this.f.b));
        if (c.equals(str) || d.equals(str)) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("scenePositionCodes", str);
            jSONObject6.put("entry", iIntValue);
            jSONObject6.put(com.baidu.mobads.container.adrequest.g.l, 3);
            jSONObject.put("adsParams", jSONObject6);
        } else {
            jSONObject.put("novelAdsParams", jSONObject2);
        }
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("adReqId", "");
        jSONObject7.put("act", "");
        jSONObject7.put("fet", "");
        jSONObject7.put("apid", "");
        if ("harmony".equals(DeviceUtils.getInstance().d())) {
            jSONObject7.put(com.baidu.mobads.container.adrequest.g.al, String.valueOf(DeviceUtils.getInstance().q(this.f.b)));
        }
        jSONObject7.put(com.baidu.mobads.container.adrequest.g.ai, az.a(this.f.b) ? "1" : "0");
        jSONObject7.put("at", "10");
        jSONObject7.put("prod", "");
        jSONObject7.put("adHeight", "");
        jSONObject7.put("adWidth", "");
        jSONObject7.put(com.baidu.mobads.container.adrequest.g.ae, "");
        jSONObject7.put("adNum", 1);
        jSONObject7.put(com.baidu.mobads.container.adrequest.g.q, DeviceUtils.getInstance().l(this.f.b) + "_cpr");
        jSONObject7.put("mimeType", "");
        jSONObject7.put("lh", "");
        jSONObject7.put("lw", "");
        jSONObject.put("adParams", jSONObject7);
        jSONObject.put(PointCategory.NETWORK, jSONObject3);
        jSONObject.put("device", jSONObject4);
        jSONObject.put("GPS", new JSONObject());
        jSONObject.put("supportHttps", "");
        String strA = com.baidu.mobads.container.nativecpu.a.a.a();
        if (!TextUtils.isEmpty(strA) && strA.length() > 32) {
            strA = strA.substring(0, 32);
        }
        jSONObject.put("baiduid", strA);
        return jSONObject;
    }

    private String a() {
        if (t.b(this.f.b)) {
            return "NA,LP,DL,APO";
        }
        return "NA,LP,APO";
    }

    private void b() {
        if (this.h != null) {
            this.g.postDelayed(this.h, this.i);
        }
    }

    protected void a(InterfaceC0129a interfaceC0129a, String str) {
        c();
        if (interfaceC0129a != null) {
            interfaceC0129a.a(str);
        }
    }

    private void c() {
        if (this.h != null) {
            this.g.removeCallbacks(this.h);
        }
        this.h = null;
    }

    protected void a(String str, String str2, InterfaceC0129a interfaceC0129a, boolean z) {
        c();
        try {
            com.baidu.mobads.container.nativecpu.f fVar = new com.baidu.mobads.container.nativecpu.f(this.f, str2);
            this.f.a(fVar);
            List<com.baidu.mobads.container.nativecpu.a> listC = fVar.c();
            if (b.equals(str)) {
                Iterator<com.baidu.mobads.container.nativecpu.a> it = listC.iterator();
                while (it.hasNext()) {
                    this.k.offer(it.next());
                }
            }
            if (z && interfaceC0129a != null) {
                if (b.equals(str)) {
                    interfaceC0129a.a(this.k.poll());
                } else {
                    interfaceC0129a.a(listC.isEmpty() ? null : listC.get(0));
                }
            }
        } catch (JSONException e2) {
            bq.a().c(e2.getMessage());
        }
    }

    public void a(String str) {
        this.m = str;
    }
}
