package com.baidu.mobads.container.nativecpu;

import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.adrequest.ProdAdRequestInfo;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.style.widget.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends com.baidu.mobads.container.adrequest.o implements IOAdEventListener {
    public static long C;
    private static final String G = j.class.getSimpleName();
    private static final String H;
    protected com.baidu.mobads.container.components.k.c A;
    protected HashMap<String, Object> B;
    protected JSONObject D;
    protected t E;
    public int F;
    private int I;
    private String J;

    /* renamed from: K, reason: collision with root package name */
    private JSONArray f736K;
    private int L;
    private int M;
    private int[] N;
    private boolean O;
    private Boolean P;
    private String Q;
    private boolean R;
    private boolean S;
    protected f y;
    public be z;

    static {
        String str;
        if (com.baidu.mobads.container.h.a.a().e()) {
            str = "https://cpu-openapi.baidu.com/api/v2/data/list";
        } else {
            str = "http://cpu-openapi.baidu.com/api/v2/data/list";
        }
        H = str;
        C = -1L;
    }

    public j(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        super(context, prodAdRequestInfo);
        this.I = 3;
        this.B = new HashMap<>();
        this.P = Boolean.FALSE;
        this.R = false;
        this.S = false;
    }

    public void H() {
        if (this.E == null) {
            this.E = new t(this);
            if (!TextUtils.isEmpty(this.Q)) {
                this.E.a(this.Q);
            }
            this.E.a(new k(this));
        }
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void b(JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        if (jSONObject != null && "cpu_channelIds".equals(jSONObject.optString(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE))) {
            new g(this.b, new l(this)).a(jSONObject);
        } else {
            super.b(jSONObject, map);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.D = jSONObject;
            if (this.D != null) {
                Object objRemove = this.D.remove("isInitNovelSDK");
                if (objRemove instanceof Boolean) {
                    this.P = (Boolean) objRemove;
                }
                Object objRemove2 = this.D.remove("outerUid");
                if (objRemove2 instanceof String) {
                    this.J = (String) objRemove2;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean I() {
        return this.P.booleanValue();
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a() throws JSONException {
        b();
        c(this.j.optString("appsid"));
        this.L = this.j.optInt("pageSize");
        this.M = this.j.optInt("pageIndex");
        this.N = (int[]) this.j.opt("channels");
        this.O = this.j.optBoolean("showAd");
        String strOptString = this.j.optString("openActivitylink");
        if (TextUtils.isEmpty(strOptString)) {
            a(this.M, this.L, this.N, this.O);
        } else {
            h(strOptString);
        }
    }

    private void h(String str) {
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(new JSONObject());
        if (!TextUtils.isEmpty(str) && str.contains("cpu.baidu.com")) {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter(com.baidu.mobads.container.config.a.B, com.baidu.mobads.container.config.a.a().m());
            str = builderBuildUpon.build().toString();
        }
        xAdInstanceInfoExt.setClickThroughUrl(str);
        xAdInstanceInfoExt.setActionType(1);
        new com.baidu.mobads.container.components.k.c().a((com.baidu.mobads.container.k) new be(this), (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, (HashMap<String, Object>) null);
    }

    public void a(int i, int i2, int[] iArr, boolean z) throws JSONException {
        String strB = b(i, i2, iArr, z);
        if (!TextUtils.isEmpty(strB)) {
            Uri.Builder builder = new Uri.Builder();
            builder.encodedQuery(strB);
            a(H, builder);
        }
    }

    public void a(String str, Uri.Builder builder) {
        com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, str, "POST");
        fVar.a(this.e);
        fVar.a(builder);
        fVar.a("application/json");
        fVar.a(new m(this));
        f();
        fVar.a();
    }

    public f J() {
        return this.y;
    }

    private String b(int i, int i2, int[] iArr, boolean z) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("appsid", z());
            jSONObject.put(com.alipay.sdk.m.t.a.k, jCurrentTimeMillis);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "sdk");
            jSONObject2.put("osType", 1);
            jSONObject2.put("sdkVersion", "android_" + com.baidu.mobads.container.j.b());
            jSONObject2.put("pack", this.b.getPackageName());
            jSONObject2.put("sdkProxyVersion", com.baidu.mobads.container.config.b.a().j());
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.X, "sdk_9.40");
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.aq, DeviceUtils.getInstance().r(this.c));
            JSONObject jSONObjectA = a(i, i2, z, iArr);
            String strK = K();
            String strC = c(String.valueOf(jCurrentTimeMillis), jSONObjectA.toString());
            if (C == -1) {
                SPUtils sPUtils = new SPUtils(this.b, "cpu_sp_file");
                if (sPUtils.b("fisrtCCTime", -1L) == -1) {
                    C = System.currentTimeMillis();
                    sPUtils.a("fisrtCCTime", C);
                    jSONObject.put("fisrtCCTime", C);
                }
            }
            jSONObject.put("from", jSONObject2);
            jSONObject.put("data", jSONObjectA);
            jSONObject.put("sdata", strK);
            jSONObject.put("signature", strC);
            jSONObject.put("subChannelId", com.baidu.mobads.container.util.ah.a(this.D, "subChannelId", ""));
            if (this.D == null) {
                this.D = new JSONObject();
            }
            this.D.put(com.baidu.mobads.container.adrequest.g.ai, com.baidu.mobads.container.util.az.a(this.c) ? "1" : "0");
            jSONObject.put("extParams", this.D);
            return jSONObject.toString();
        } catch (Exception e) {
            a(com.baidu.mobads.container.c.a.REQUEST_PARAM_ERROR.b(), "request param error.");
            return null;
        }
    }

    private JSONObject a(int i, int i2, boolean z, int[] iArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.I = com.baidu.mobads.container.util.ah.a(this.D, "downloadAppConfirmPolicy", 3);
        jSONObject.put("accessType", com.baidu.mobads.container.util.ah.a(this.D, "accessType", 1));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pageSize", i2);
        jSONObject2.put("pageIndex", i);
        JSONArray jSONArray = new JSONArray();
        for (int i3 : iArr) {
            jSONArray.put(i3);
        }
        jSONObject2.put("channelIds", jSONArray);
        jSONObject2.put("showAd", z ? 1 : 0);
        jSONObject2.put("showVideoAd", 1);
        jSONObject2.put(com.baidu.mobads.container.adrequest.g.l, 3);
        jSONObject2.put("listScene", com.baidu.mobads.container.util.ah.a(this.D, "listScene", 0));
        jSONObject2.put("contentType", com.baidu.mobads.container.util.ah.a(this.D, "contentType", 0));
        jSONObject2.put("city", com.baidu.mobads.container.util.ah.a(this.D, "city", ""));
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(com.baidu.mobads.container.util.ah.a(this.D, "keywords", ""));
        jSONObject2.put("keywords", jSONArray2);
        jSONObject2.put("lock_screen", ((KeyguardManager) this.b.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode() ? "1" : "0");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("connectionType", com.baidu.mobads.container.util.e.a.d(this.b));
        jSONObject3.put("operatorType", com.baidu.mobads.container.util.e.a.b(this.b));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.v, DeviceUtils.getInstance().n(this.c));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.s, DeviceUtils.getInstance().g(this.c));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.w, "");
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.ad, com.baidu.mobads.container.util.e.a.a(this.c));
        jSONObject3.put(com.baidu.mobads.container.adrequest.g.u, DeviceUtils.getInstance().h(this.c));
        jSONObject3.put("gps", DeviceUtils.getInstance().d(this.c));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("deviceType", 1);
        jSONObject4.put("osType", 1);
        jSONObject4.put("osVersion", com.baidu.mobads.container.util.x.a(this.b).c());
        jSONObject4.put("vendor", DeviceUtils.getInstance().b());
        jSONObject4.put("model", com.baidu.mobads.container.util.x.a(this.b).d());
        JSONObject jSONObject5 = new JSONObject();
        Pair<Integer, Integer> pairE = com.baidu.mobads.container.util.e.a.e(this.b);
        jSONObject5.put("width", pairE != null ? ((Integer) pairE.first).intValue() : 0);
        jSONObject5.put("height", pairE != null ? ((Integer) pairE.second).intValue() : 0);
        jSONObject4.put("screenSize", jSONObject5);
        jSONObject4.put("density", "" + bv.e(this.c));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.ak, DeviceUtils.getInstance().e());
        jSONObject4.put("imsi", DeviceUtils.getInstance().k(this.c));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.aj, DeviceUtils.getInstance().d());
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.V, bw.a(this.c) + "," + bw.b(this.c));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.x, "");
        jSONObject4.put("sn", DeviceUtils.getInstance().b(this.c));
        jSONObject4.put(com.baidu.mobads.container.adrequest.g.B, DeviceUtils.getInstance().j(this.c));
        String strA = com.baidu.mobads.container.nativecpu.a.a.a();
        if (!TextUtils.isEmpty(strA) && strA.length() > 32) {
            strA = strA.substring(0, 32);
        }
        jSONObject.put("baiduid", strA);
        jSONObject.put("supportHttps", "");
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("adReqId", "");
        jSONObject6.put("act", "");
        jSONObject6.put("fet", "");
        jSONObject6.put("apid", "");
        if ("harmony".equals(DeviceUtils.getInstance().d())) {
            jSONObject6.put(com.baidu.mobads.container.adrequest.g.al, String.valueOf(DeviceUtils.getInstance().q(this.c)));
        }
        jSONObject6.put(com.baidu.mobads.container.adrequest.g.ai, com.baidu.mobads.container.util.az.a(this.c) ? "1" : "0");
        jSONObject6.put("at", "10");
        jSONObject6.put("prod", "");
        jSONObject6.put("adHeight", "");
        jSONObject6.put("adWidth", "");
        jSONObject6.put(com.baidu.mobads.container.adrequest.g.ae, "");
        jSONObject6.put("adNum", 1);
        jSONObject6.put(com.baidu.mobads.container.adrequest.g.q, DeviceUtils.getInstance().l(this.c) + "_cpr");
        jSONObject6.put("mimeType", "");
        jSONObject6.put("lh", "");
        jSONObject6.put("lw", "");
        jSONObject.put("adParams", jSONObject6);
        jSONObject.put("contentParams", jSONObject2);
        jSONObject.put(PointCategory.NETWORK, jSONObject3);
        jSONObject.put("device", jSONObject4);
        jSONObject.put("supportHttps", "" + (com.baidu.mobads.container.h.a.a().e() ? 2 : 1));
        jSONObject.put("GPS", new JSONObject());
        jSONObject.put(com.baidu.mobads.container.adrequest.g.I, O());
        jSONObject.put(com.baidu.mobads.container.adrequest.g.J, com.baidu.mobads.container.util.f.a().a(this.c));
        return jSONObject;
    }

    private String M() {
        if (com.baidu.mobads.container.util.t.b(this.c)) {
            return "NA,LP,DL,APO";
        }
        return "NA,LP,APO";
    }

    public String K() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", IDManager.getInstance().a(this.b));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.z, IDManager.getInstance().c(this.b));
            jSONObject2.put(com.baidu.mobads.container.adrequest.g.A, IDManager.getInstance().d(this.b));
            jSONObject2.put("oaid", com.baidu.mobads.container.util.f.z.a(this.b));
            if (!TextUtils.isEmpty(this.J)) {
                jSONObject2.put("outerUid", this.J);
            }
            jSONObject.put("device.udid", jSONObject2);
            jSONObject.put(com.baidu.mobads.container.adrequest.g.E, IDManager.getInstance().b(this.c));
            return com.baidu.mobads.container.nativecpu.a.b.a(com.baidu.mobads.container.nativecpu.a.b.a, jSONObject.toString());
        } catch (Throwable th) {
            bq.a().a(th);
            return "";
        }
    }

    public String c(String str, String str2) {
        return com.baidu.mobads.container.util.ap.a(str + this.b.getPackageName() + str2);
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void b(String str, String str2) {
        e();
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("baseResponse");
            int iOptInt = jSONObjectOptJSONObject.optInt("code", 0);
            String strOptString = jSONObjectOptJSONObject.optString("msg", "");
            if (iOptInt == 200) {
                a(new f(this, str));
                if (this.y != null && this.y.c().size() > 0) {
                    N();
                } else {
                    a(d(str2), iOptInt);
                }
            } else {
                a(iOptInt, strOptString);
            }
        } catch (Exception e) {
            a(com.baidu.mobads.container.c.a.ADELEMENT_PARSE_ERROR.b(), "response json parsing error");
        }
    }

    protected String d(String str) {
        return "response ad list empty: " + str;
    }

    public void a(f fVar) {
        this.y = fVar;
    }

    private void N() {
        e("CPUAdProd request success.");
    }

    protected void e(String str) {
        f(str);
    }

    protected void b(f fVar) {
        if (this.z == null) {
            this.z = new be(this);
        }
        HashMap map = new HashMap();
        map.put("cpuAdList", L());
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.s, (HashMap<String, Object>) map));
        this.z.a(fVar);
        this.R = fVar != null && fVar.a().c();
        this.S = fVar != null && fVar.a().g();
        com.baidu.mobads.container.y.k.a().a(this.R);
        com.baidu.mobads.container.y.k.a().b(this.R);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.List<java.lang.Object> L() {
        /*
            r8 = this;
            com.baidu.mobads.container.nativecpu.f r0 = r8.y
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r0 == 0) goto L7e
            java.util.List r0 = r0.c()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            if (r0 == 0) goto L7d
            r3 = 1
            r4 = 0
            int r5 = r0.size()     // Catch: java.lang.Exception -> L69
            if (r5 <= 0) goto L7d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L69
        L20:
            boolean r5 = r0.hasNext()     // Catch: java.lang.Exception -> L69
            if (r5 == 0) goto L7d
            java.lang.Object r5 = r0.next()     // Catch: java.lang.Exception -> L69
            com.baidu.mobads.container.nativecpu.a r5 = (com.baidu.mobads.container.nativecpu.a) r5     // Catch: java.lang.Exception -> L69
            if (r5 != 0) goto L2f
            goto L20
        L2f:
            java.lang.String r6 = r5.getPackageName()     // Catch: java.lang.Exception -> L69
            boolean r7 = r5.isDownloadApp()     // Catch: java.lang.Exception -> L69
            if (r7 == 0) goto L62
            if (r6 == 0) goto L60
            java.lang.String r7 = ""
            boolean r7 = r6.equals(r7)     // Catch: java.lang.Exception -> L69
            if (r7 != 0) goto L60
            java.lang.String r7 = "null"
            boolean r7 = r6.equals(r7)     // Catch: java.lang.Exception -> L69
            if (r7 != 0) goto L60
            boolean r7 = r2.contains(r6)     // Catch: java.lang.Exception -> L69
            if (r7 == 0) goto L53
            goto L60
        L53:
            r2.add(r6)     // Catch: java.lang.Exception -> L69
            android.content.Context r7 = r8.b     // Catch: java.lang.Exception -> L69
            boolean r6 = com.baidu.mobads.container.util.j.b(r7, r6)     // Catch: java.lang.Exception -> L69
            r5.a(r6)     // Catch: java.lang.Exception -> L69
            goto L62
        L60:
            r6 = 1
            goto L63
        L62:
            r6 = 0
        L63:
            if (r6 != 0) goto L68
            r1.add(r5)     // Catch: java.lang.Exception -> L69
        L68:
            goto L20
        L69:
            r0 = move-exception
            com.baidu.mobads.container.util.bq r0 = com.baidu.mobads.container.util.bq.a()
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = "RCPUAdProd"
            r2[r4] = r5
            java.lang.String r4 = "Get all Ad list error."
            r2[r3] = r4
            r0.b(r2)
            goto L7e
        L7d:
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.nativecpu.j.L():java.util.List");
    }

    protected synchronized void f(String str) {
        try {
            if (this.y != null) {
                b(this.y);
            } else {
                dispatchEvent(new cm("AdError", "no response"));
                bq.a().a(G, "doubleCheck IXAdResponseInfo is null, but isBFP4APPRequestSuccess is true");
            }
        } catch (Exception e) {
            dispatchEvent(new cm("AdError", "response error"));
        }
    }

    public void a(HashMap<String, Object> map) {
        this.B = map;
    }

    public void a(View view, a aVar) {
        if (this.A == null) {
            this.A = new com.baidu.mobads.container.components.k.c(this.z);
        }
        if (aVar == null) {
            return;
        }
        if (aVar.i != null) {
            aVar.i.onNotifyPerformance("CLICK");
        }
        XAdInstanceInfoExt xAdInstanceInfoExtD = aVar.d();
        if (xAdInstanceInfoExtD == null) {
            xAdInstanceInfoExtD = new XAdInstanceInfoExt(aVar.b());
        }
        if (aVar.isDownloadApp()) {
            Context context = view.getContext();
            if (aVar.g()) {
                xAdInstanceInfoExtD.setActionOnlyWifi(false);
                i((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExtD);
                return;
            }
            if (this.I == 3) {
                xAdInstanceInfoExtD.setActionOnlyWifi(false);
                i((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExtD);
                return;
            }
            if (this.I == 4) {
                a(context, xAdInstanceInfoExtD);
                i((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExtD);
                return;
            } else {
                if (this.I == 2) {
                    a(view, xAdInstanceInfoExtD);
                    return;
                }
                if (this.I == 1) {
                    if (!com.baidu.mobads.container.util.e.a.i(context).booleanValue()) {
                        a(view, xAdInstanceInfoExtD);
                        return;
                    } else {
                        a(context, xAdInstanceInfoExtD);
                        i((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExtD);
                        return;
                    }
                }
                return;
            }
        }
        JSONObject originJsonObject = xAdInstanceInfoExtD.getOriginJsonObject();
        if (originJsonObject != null) {
            String strOptString = originJsonObject.optString("novel_id");
            if (!TextUtils.isEmpty(strOptString)) {
                this.Q = strOptString;
            }
            String strOptString2 = originJsonObject.optString("novel_scheme");
            if (this.P.booleanValue() && !TextUtils.isEmpty(strOptString2)) {
                H();
                if (aVar.i != null) {
                    aVar.i.startRouter(this.c, strOptString2);
                    return;
                }
                return;
            }
            i((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExtD);
            return;
        }
        com.baidu.mobads.container.l.g.b().c("点击无响应跳转信息");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.mobads.container.adrequest.j jVar) {
        h(jVar);
        JSONObject originJsonObject = jVar.getOriginJsonObject();
        if (originJsonObject == null || this.B == null) {
            return;
        }
        boolean z = false;
        int iOptInt = originJsonObject.optInt("video_lp_type", 0);
        this.B.remove("lpMurlStyle");
        this.B.remove("lpShoubaiStyle");
        if (!TextUtils.isEmpty(jVar.getAdId()) && !TextUtils.isEmpty(jVar.getVideoUrl()) && (iOptInt == 1 || iOptInt == 2)) {
            App2Activity.MURL_SECOND_CONFIRM.set(true);
            this.B.put("lpMurlStyle", App2Activity.MURL_SECOND_CONFIRM_NEW);
            this.B.put("lpShoubaiStyle", iOptInt == 1 ? App2Activity.LP_STYLE_VIDEO : App2Activity.LP_STYLE_FLOATING_VIDEO);
        }
        if (jVar.getActionType() == 512 && TextUtils.equals(jVar.getAppPackageName(), "com.baidu.searchbox")) {
            z = true;
        }
        if (z) {
            new com.baidu.mobads.container.p.a(this.b, this.m, null, k()).a(jVar, new n(this));
        } else {
            this.A.a((com.baidu.mobads.container.k) this.z, jVar, (Boolean) true, this.B);
        }
    }

    protected void h(com.baidu.mobads.container.adrequest.j jVar) {
        try {
            String clickThroughUrl = jVar.getClickThroughUrl();
            if (!TextUtils.isEmpty(clickThroughUrl) && clickThroughUrl.contains("cpu.baidu.com")) {
                Uri.Builder builderBuildUpon = Uri.parse(clickThroughUrl).buildUpon();
                if (this.B != null && this.B.size() != 0) {
                    for (String str : this.B.keySet()) {
                        Object obj = this.B.get(str);
                        if (obj instanceof String) {
                            builderBuildUpon.appendQueryParameter(str, (String) obj);
                        }
                    }
                    builderBuildUpon.appendQueryParameter(com.baidu.mobads.container.config.a.B, com.baidu.mobads.container.config.a.a().m());
                    if (this.R) {
                        builderBuildUpon.appendQueryParameter("npr", "1");
                    }
                    if (this.S) {
                        builderBuildUpon.appendQueryParameter("shareRender", "1");
                    }
                    jVar.setClickThroughUrl(builderBuildUpon.build().toString());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(View view, int i, a aVar) {
        b(view, i, aVar);
    }

    private void b(View view, int i, a aVar) {
        try {
            com.style.widget.a aVarA = com.style.widget.a.a(view.getContext(), a.EnumC0796a.WITH_CLOSE_ICON);
            aVarA.a(new o(this, i, aVar));
            aVarA.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        if (!com.baidu.mobads.container.util.e.a.i(context).booleanValue()) {
            jVar.setActionOnlyWifi(false);
        } else {
            jVar.setActionOnlyWifi(true);
        }
    }

    private void a(View view, com.baidu.mobads.container.adrequest.j jVar) {
        try {
            Context context = view.getContext();
            if (context == null) {
                bq.a().a(j.class.getSimpleName(), "showConfirmDialog context is null");
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            String appName = jVar.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = jVar.getTitle();
            }
            builder.setMessage("确认下载\"" + appName + "\"?");
            builder.setTitle("提示");
            builder.setPositiveButton("确认", new p(this, context, jVar));
            builder.setNegativeButton("取消", new q(this, context));
            builder.create().show();
        } catch (Exception e) {
            bq.a().a(e.getMessage());
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
        }
    }

    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.u.equals(iOAdEvent.getType()) && !TextUtils.isEmpty(iOAdEvent.getMessage())) {
            dispatchEvent(iOAdEvent);
        }
    }

    private JSONArray O() {
        if (this.f736K == null) {
            String strB = com.baidu.mobads.container.util.b.a().b(this.b);
            this.f736K = new JSONArray();
            if (!TextUtils.isEmpty(strB)) {
                try {
                    for (String str : strB.split(",")) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f736K.put(Long.parseLong(str));
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
        return this.f736K;
    }

    public void b(View view, a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.i != null) {
            aVar.i.onNotifyPerformance("IMPRESSION");
        }
        try {
            cn cnVarS = this.z.getAdContainerContext().s();
            if (cnVarS != null) {
                cnVarS.dispatchEvent(new cm("AdImpression"));
            }
        } catch (Exception e) {
            com.baidu.mobads.container.l.g.e(e);
        }
    }

    public void a(a aVar) {
        if (this.R && !"ad".equals(aVar.getType())) {
            try {
                XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(aVar.b());
                h((com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt);
                com.baidu.mobads.container.y.k.a().a(this.b, this.m, k(), xAdInstanceInfoExt);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a(JSONObject jSONObject, Map<String, Object> map) {
        try {
            if (this.E != null) {
                this.E.a(jSONObject, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("curl", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(jSONObject);
        xAdInstanceInfoExt.setClickThroughUrl(str);
        xAdInstanceInfoExt.setActionType(1);
        new com.baidu.mobads.container.components.k.c().a((com.baidu.mobads.container.k) this.z, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, (HashMap<String, Object>) null);
    }
}
