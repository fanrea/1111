package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.adrequest.b;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.hybrid.XHybridAdRenderer;
import com.baidu.mobads.container.rewardvideo.dp;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cc;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import com.baidu.mobads.container.util.d.d;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.sigmob.sdk.base.models.ClickCommon;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o extends cn implements t {
    public static final String a = "XAbstractAdProdTemplate";
    public static final String n = "local_creative_url";
    public static final String o = "caching_result";
    private boolean C;
    private String E;
    private String G;
    private com.baidu.mobads.container.components.g.f H;
    private boolean I;

    /* renamed from: K, reason: collision with root package name */
    private String f720K;
    private String L;
    public Context b;
    public Context c;
    public ProdAdRequestInfo d;
    public l f;
    public com.baidu.mobads.container.k h;
    public Activity i;
    public JSONObject j;
    public boolean k;
    public boolean l;
    protected String m;
    protected final com.baidu.mobads.container.components.h.c.f p;
    protected final com.baidu.mobads.container.o.e q;
    private bq y = bq.a();
    private Handler z = new Handler(Looper.getMainLooper());
    private Runnable A = null;
    private a B = null;
    public int e = 10000;
    public j g = null;
    private boolean D = false;
    private String F = "";
    private boolean J = false;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public long v = 0;
    public long w = 0;
    public long x = 0;

    public o(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        this.c = context;
        this.b = context.getApplicationContext();
        this.d = prodAdRequestInfo;
        this.p = com.baidu.mobads.container.components.h.c.f.a(this.b);
        this.q = com.baidu.mobads.container.o.e.a(this.b);
    }

    public void b() {
        if (this.d == null) {
            return;
        }
        this.j = this.d.getAllAdParam();
        if (this.j == null) {
            return;
        }
        this.m = this.j.optString("appid");
        com.baidu.mobads.container.config.b.a().a(this.m);
        this.F = this.j.optString("prod");
        this.G = this.j.optString("apid");
        this.E = this.j.optString("Display_Down_Info");
        this.e = this.j.optInt("timeout", 10000);
        this.k = this.j.optBoolean("cacheVideoOnlyWifi", false);
        this.l = this.j.optBoolean("isCacheVideo", true);
        this.C = this.j.optBoolean("needCache", false);
        this.I = this.j.optBoolean("onlyLoadAd", false);
        this.D = this.j.optBoolean(SplashAd.KEY_LOAD_AFTER_CACHE_END, false);
        com.baidu.mobads.container.components.command.k.a().a(this.b);
        this.q.a(this.F, this.e + "");
    }

    public void a() {
        b();
        a(this.d != null ? this.d.toFullURL() : "");
    }

    public void a(String str) {
        if (!a(DeviceUtils.getInstance().l(this.c), this.G)) {
            b(com.baidu.mobads.container.c.a.REQUEST_NO_IDS.b(), com.baidu.mobads.container.c.a.REQUEST_NO_IDS.c() + ",当前appsid为" + DeviceUtils.getInstance().l(this.c) + ",当前AdPlaceId为" + this.G);
            return;
        }
        this.f720K = this.G + "" + System.currentTimeMillis();
        this.p.a(this.f720K, this.d);
        this.p.a(this.f720K, com.baidu.mobads.container.components.h.b.e.g, String.valueOf(str.length()));
        this.v = System.currentTimeMillis() - this.j.optLong("load_time", 0L);
        this.w = System.currentTimeMillis();
        if (cc.a()) {
            this.p.a(this.f720K, com.baidu.mobads.container.components.h.b.e.h, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + cc.a.REQUEST + str);
        }
        if (cc.a(this.b)) {
            String strH = H();
            if (!TextUtils.isEmpty(strH) && this.L != null && this.L.equals(this.F)) {
                b(strH, "");
                return;
            }
        }
        this.H = new com.baidu.mobads.container.components.g.f(1, str, "GET");
        this.H.a(this.e);
        this.H.a(new p(this));
        f();
        this.H.a();
        this.r = System.currentTimeMillis();
    }

    private String H() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(cc.b(this.b));
            String strOptString = jSONObject.optString("prod_type", "");
            this.L = strOptString;
            String strOptString2 = jSONObject.optString("prod_template", "");
            String strOptString3 = jSONObject.optString("prod_style", "");
            String strOptString4 = jSONObject.optString("interact_type", "lp");
            String strOptString5 = jSONObject.optString("material_type", "");
            String strOptString6 = jSONObject.optString("orientation_type", "");
            JSONObject jSONObject2 = new JSONObject(d(strOptString4));
            JSONObject jSONObject3 = jSONObject2.getJSONArray("ad").getJSONObject(0);
            jSONObject3.put("type", strOptString5);
            if ("hor".equals(strOptString6)) {
                jSONObject3.put("w_picurl", "https://mobads-pre-config.cdn.bcebos.com/tools/lp_hor.jpg");
                jSONObject3.put("vurl", "https://mobads-pre-config.bj.bcebos.com/tools/toolsvideohor.mp4");
            }
            JSONObject jSONObject4 = jSONObject3.getJSONObject("cloud_control");
            if ("rsplash".equals(strOptString)) {
                jSONObject3.put("closetype", 5);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject5 = new JSONObject();
                if ("ad_slide".equals(strOptString3)) {
                    jSONObject5.put("ad_slide", 1);
                    jSONArray.put(jSONObject5);
                    jSONObject4.put("slide_config", jSONArray);
                } else if ("ad_atmosphere".equals(strOptString3)) {
                    jSONObject5.put("ad_atmosphere", 1);
                    jSONArray.put(jSONObject5);
                    jSONObject4.put("atmosphere", jSONArray);
                } else {
                    jSONObject4.put(strOptString3, 1);
                }
            } else {
                JSONObject jSONObject6 = jSONObject3.getJSONObject("st_op");
                if (!TextUtils.isEmpty(strOptString2)) {
                    jSONObject6.put(n.D, strOptString2);
                }
                JSONObject jSONObject7 = new JSONObject(jSONObject6.getString("amend"));
                JSONArray jSONArray2 = jSONObject7.getJSONArray("increment");
                if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(d("component/" + strOptString3))) {
                    JSONArray jSONArray3 = new JSONArray(ap.b(new JSONObject(d("component/" + strOptString3)).getString(strOptString2)));
                    if (jSONArray3.length() > 0) {
                        jSONArray2.put(jSONArray3.getJSONObject(0));
                    }
                    if (jSONArray3.length() > 1) {
                        jSONArray2.put(jSONArray3.getJSONObject(1));
                    }
                }
                jSONObject7.put("increment", jSONArray2);
                jSONObject6.put("amend", jSONObject7.toString());
            }
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String d(String str) throws IOException {
        try {
            InputStream inputStreamOpen = this.c.getAssets().open(str + ".json");
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean a(String str, String str2) {
        return f(str) && e(str2);
    }

    private boolean e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches("^[0-9]+$");
        } catch (Throwable th) {
            return true;
        }
    }

    private boolean f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches("^[0-9a-f]+$");
        } catch (Throwable th) {
            return true;
        }
    }

    public void a(int i, String str) {
        e();
        b(i, str);
        if ("rvideo".equals(this.F) || "rsplash".equals(this.F) || c()) {
            a(null, i, str);
        } else if (new Random().nextInt(100) == 10) {
            a(null, i, str);
        }
    }

    protected boolean c() {
        return "feed".equals(this.F) && new Random().nextInt(100) < 5;
    }

    protected long d() {
        if (this.s < this.r) {
            return 0L;
        }
        return this.s - this.r;
    }

    public void b(int i, String str) {
        HashMap map = new HashMap();
        map.put("error_message", str);
        map.put("error_code", Integer.valueOf(i));
        dispatchEvent(new cm("AdError", (HashMap<String, Object>) map));
    }

    public void e() {
        a(this.A);
        this.A = null;
    }

    public void f() {
        if (this.A == null) {
            this.A = new q(this);
        }
        a(this.A, this.e);
    }

    public void a(Runnable runnable, int i) {
        if (runnable != null && i > 0) {
            this.z.postDelayed(runnable, i);
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            this.z.removeCallbacks(runnable);
        }
    }

    public void a(l lVar) {
        this.f = lVar;
    }

    public void b(String str, String str2) {
        e();
        try {
            if (cc.a()) {
                this.p.a(this.f720K, com.baidu.mobads.container.components.h.b.e.l, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + cc.a.RESPONSE + str);
            }
            this.p.a(this.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_START);
            a(new v(str));
            if (this.f != null && this.f.o() != null) {
                this.p.a(this.f720K, com.baidu.mobads.container.components.h.b.e.i, String.valueOf(this.f.o().size()));
                if (this.f.o().size() > 0) {
                    this.g = this.f.b();
                    this.p.a(this.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_SUCCESS);
                    this.p.a(this.f720K, this.f);
                    this.q.a(this.F, 0, this.x);
                    x();
                } else {
                    this.p.a(this.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_NO_AD);
                    String strM = this.f.m();
                    int i = TextUtils.isEmpty(strM) ? 0 : Integer.parseInt(strM);
                    String strN = this.f.n();
                    if (("0".equals(strM) && TextUtils.isEmpty(strN)) || ("200000".equals(strM) && TextUtils.isEmpty(strN))) {
                        strN = "无广告返回";
                    }
                    if (i != 0 && i != 200000) {
                        this.q.a(this.F, i, this.x);
                    }
                    a(strN, i);
                }
                return;
            }
            a(com.baidu.mobads.container.c.a.ADELEMENT_PARSE_ERROR.b(), com.baidu.mobads.container.c.a.ADELEMENT_PARSE_ERROR.c());
            this.p.a(this.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_FAILED);
            this.q.a(this.F, 404, this.x);
        } catch (Exception e) {
            this.p.a(this.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_FAILED);
            this.q.a(this.F, 404, this.x);
            a(com.baidu.mobads.container.c.a.ADELEMENT_PARSE_ERROR.b(), com.baidu.mobads.container.c.a.ADELEMENT_PARSE_ERROR.c());
        }
    }

    protected void a(String str, int i) {
        HashMap map = new HashMap();
        map.put("error_message", str);
        map.put("error_code", Integer.valueOf(i));
        if (this.f != null && this.f.c() != null) {
            map.put("error_uniqueid", this.f.c().a());
        }
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.t, (HashMap<String, Object>) map));
        if ("rsplash".equals(this.F) || "rvideo".equals(this.F) || c()) {
            a(null, i, str);
        }
    }

    public void g() {
        if (this.f != null) {
            n.a(this.f.b(), n.c);
        }
        com.baidu.mobads.container.util.h.a(new r(this));
    }

    public void b(String str) {
        this.f720K = str;
    }

    public boolean h() {
        try {
            if (i()) {
                return false;
            }
            return j();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean i() {
        if (this.g == null) {
            return true;
        }
        long expiration = this.g.getExpiration() * 1000;
        if (expiration == 0) {
            expiration = 1740000;
        }
        boolean z = System.currentTimeMillis() - this.g.getCreateTime() >= expiration;
        if (z && "int".equals(k())) {
            dp.f(this.g, this);
        }
        return z;
    }

    public boolean j() {
        String strD = d(this.g);
        if (TextUtils.isEmpty(strD)) {
            return true;
        }
        return com.baidu.mobads.container.util.d.d.a(this.b).g(strD);
    }

    public String k() {
        return this.F;
    }

    public String l() {
        return this.G;
    }

    public int m() {
        return Integer.valueOf(this.j.optString("w", "0")).intValue();
    }

    public int n() {
        return Integer.valueOf(this.j.optString("h", "0")).intValue();
    }

    public void o() {
        if ("rsplash".equals(k())) {
            if (this.g != null) {
                if ("html".equals(this.g.getCreativeType().b())) {
                    this.h = new com.baidu.mobads.container.v.c.a(this);
                    return;
                }
                if ("static_image".equals(this.g.getCreativeType().b())) {
                    if (G()) {
                        this.h = new com.baidu.mobads.container.u.p(this);
                        return;
                    } else {
                        this.h = new com.baidu.mobads.container.u.v(this);
                        return;
                    }
                }
                if ("gif".equals(this.g.getCreativeType().b())) {
                    this.h = new com.baidu.mobads.container.g.i(this);
                    return;
                } else {
                    if ("video".equals(this.g.getCreativeType().b())) {
                        this.h = new com.baidu.mobads.container.x.a.a(this);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("int".equals(k())) {
            this.h = new com.baidu.mobads.container.e.l(this);
            return;
        }
        if ("jssdk".equals(k())) {
            this.h = new XHybridAdRenderer(this);
            return;
        }
        if (b.e.c.equals(k())) {
            this.h = new com.baidu.mobads.container.v.a.a(this);
            return;
        }
        if ("feed".equals(k()) || "pvideo".equals(k()) || "insite".equals(k()) || "sug".equals(k()) || "content".equals(k()) || "video".equals(k()) || "sones".equals(k())) {
            if (q().getCreativeType() == j.a.HTML) {
                this.h = new com.baidu.mobads.container.v.b.a(this);
            } else {
                this.h = new com.baidu.mobads.container.f.b(this);
            }
        }
    }

    private void I() {
        com.baidu.mobads.container.util.h.a(new s(this));
    }

    public void p() {
        if (this.h != null) {
            n.a(q(), n.G);
            this.h.load();
            if (cc.a(this.b) && this.L != null && this.L.equals(this.F)) {
                Toast.makeText(this.b, "测试广告生效中", 1).show();
            }
        }
    }

    public j q() {
        return this.g;
    }

    public l r() {
        return this.f;
    }

    public cn s() {
        return this;
    }

    public Context t() {
        return this.b;
    }

    public Activity u() {
        if (this.i != null) {
            return this.i;
        }
        if (this.c instanceof Activity) {
            this.i = (Activity) this.c;
        } else if (v() != null && (v().getContext() instanceof Activity)) {
            this.i = (Activity) v().getContext();
        }
        return this.i;
    }

    public void a(Activity activity) {
        this.i = activity;
        if ("rsplash".equals(k())) {
            if (this.c instanceof Activity) {
                this.c = this.i;
            }
            if (this.d != null && (this.d.mCxt instanceof Activity)) {
                this.d.mCxt = activity;
            }
        }
    }

    public RelativeLayout v() {
        if (this.d != null) {
            return this.d.getAdContainer();
        }
        return null;
    }

    public JSONObject w() {
        return this.j;
    }

    public void x() {
        j jVarB = this.f.b();
        if (!this.C) {
            g();
            a(this.f.o());
            g(jVarB);
            return;
        }
        String strD = d(jVarB);
        if (TextUtils.isEmpty(strD)) {
            g();
            return;
        }
        boolean zG = com.baidu.mobads.container.util.d.d.a(this.b).g(strD);
        n.a(jVarB, n.d, this.v);
        n.a(jVarB, "load_time", this.w);
        n.a(jVarB, n.e, this.x);
        n.c(jVarB, n.A, b(jVarB));
        if (zG) {
            n.a(jVarB, n.g, 0L);
            a(jVarB, strD);
            jVarB.setLocalCreativeURL(com.baidu.mobads.container.util.d.d.a(this.b).c(strD));
            g();
            dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.J));
            return;
        }
        c(jVarB);
        if (!l(jVarB)) {
            g();
        }
    }

    protected void y() {
        j jVarB;
        if (this.f != null && (jVarB = this.f.b()) != null) {
            if ("static_image".equals(jVarB.getCreativeType().b()) || c()) {
                a(jVarB, -1, null);
            }
        }
    }

    protected void a(j jVar, int i, String str) {
        try {
            if (com.baidu.mobads.container.h.a.a().s() == -1) {
                return;
            }
            by.a aVarB = by.a.a(this.b).a(386).a("m_start_request", this.r).a("m_receive_data", this.s).a("m_dvalue", d()).a("m_load_timeout", this.t).a("m_load_neterror", this.u).c(this.F).b(this.G);
            if (!TextUtils.isEmpty(str)) {
                aVarB.a("errmsg", str);
                aVarB.a("code", i);
            }
            if (jVar != null) {
                aVarB.a(jVar);
            }
            aVarB.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(j jVar) {
        return "rsplash".equals(k()) && f(jVar);
    }

    private boolean h(j jVar) {
        try {
            if (f(jVar) && this.k) {
                return com.baidu.mobads.container.util.e.a.i(this.b).booleanValue();
            }
            return true;
        } catch (Throwable th) {
            this.y.a(a, th.getMessage());
            return true;
        }
    }

    private boolean i(j jVar) {
        if (jVar.getCreativeType().b().equals("video")) {
            if ("feed".equals(k()) || "pvideo".equals(k())) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean j(j jVar) {
        if (jVar.getCreativeType().b().equals("video")) {
            if ("feed".equals(k()) || "pvideo".equals(k())) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected String b(j jVar) {
        if (!TextUtils.isEmpty(jVar.getMainPictureUrl())) {
            return jVar.getMainPictureUrl();
        }
        if (jVar instanceof XAdInstanceInfoExt) {
            XAdInstanceInfoExt xAdInstanceInfoExt = (XAdInstanceInfoExt) jVar;
            if (xAdInstanceInfoExt.getMultiPics() != null && !xAdInstanceInfoExt.getMultiPics().isEmpty()) {
                return xAdInstanceInfoExt.getMultiPics().get(0);
            }
        }
        return jVar.getIconUrl();
    }

    private void a(ArrayList<j> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                n.a(next, n.d, this.v);
                n.a(next, "load_time", this.w);
                n.a(next, n.e, this.x);
                n.a(next, n.c);
                n.c(next, n.A, b(next));
                if (i(next) && this.l && h(next)) {
                    c(next);
                }
                if (j(next)) {
                    com.baidu.mobads.container.util.d.d.a(this.b).e(next.getMainPictureUrl());
                }
            }
        }
    }

    public void c(j jVar) {
        a(jVar, false);
    }

    public void a(j jVar, boolean z) {
        this.y.a(a, "cacheCreativeAsset");
        String strD = d(jVar);
        if (TextUtils.isEmpty(strD)) {
            J();
            return;
        }
        jVar.setLocalCreativeURL(null);
        boolean zG = com.baidu.mobads.container.util.d.d.a(this.b).g(strD);
        String uniqueId = jVar.getUniqueId();
        if (zG) {
            this.p.a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_EXIST);
            this.p.a(uniqueId, com.baidu.mobads.container.components.h.b.a.h, String.valueOf(com.baidu.mobads.container.util.d.d.a(this.b).h(strD)));
        } else {
            this.p.a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_START);
        }
        boolean zF = f(jVar);
        this.p.a(uniqueId, "ty", zF ? "im" : "vd");
        n.a(jVar, n.f);
        n.a(jVar, n.g, -2L);
        if (zF) {
            if (!zG) {
                this.B = new a(this, jVar);
                com.baidu.mobads.container.util.d.d.a(this.b, strD).c.a(1000, 2000).a((d.InterfaceC0136d) this.B);
                return;
            }
            a(jVar, strD);
            n.a(jVar, n.g, 0L);
            dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.J));
            if ("int".equals(k())) {
                dp.d(this.g, this);
                return;
            }
            return;
        }
        if (zG) {
            n.a(jVar, n.g, 0L);
        }
        this.B = new a(this, jVar);
        com.baidu.mobads.container.util.d.d.a(this.b, strD).c.a(1000, 2000).a((d.InterfaceC0136d) this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.f728K));
        if ("int".equals(k())) {
            dp.e(this.g, this);
        }
    }

    private boolean k(j jVar) {
        return "rsplash".equals(k()) && e(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(j jVar) {
        return this.D && k(jVar);
    }

    public String d(j jVar) {
        if (jVar == null) {
            return "";
        }
        if ("video".equals(jVar.getCreativeType().b())) {
            return jVar.getVideoUrl();
        }
        if ("rich_media".equals(jVar.getCreativeType().b())) {
            return jVar.getMainPictureUrl();
        }
        if (k(jVar)) {
            return jVar.getMainPictureUrl();
        }
        if (!"int".equals(k())) {
            return "";
        }
        return jVar.getMainPictureUrl();
    }

    public boolean e(j jVar) {
        return "static_image".equals(jVar.getCreativeType().b()) || "gif".equals(jVar.getCreativeType().b());
    }

    public boolean f(j jVar) {
        if (jVar == null) {
            return false;
        }
        return "video".equals(jVar.getCreativeType().b());
    }

    public void a(View view, JSONObject jSONObject) {
        if (this.h instanceof com.baidu.mobads.container.f.b) {
            ((com.baidu.mobads.container.f.b) this.h).a(view, jSONObject);
        }
        if (this.h instanceof com.baidu.mobads.container.v.b.a) {
            ((com.baidu.mobads.container.v.b.a) this.h).a(view, jSONObject);
        }
    }

    public void b(View view, JSONObject jSONObject) {
        if (this.h instanceof com.baidu.mobads.container.f.b) {
            ((com.baidu.mobads.container.f.b) this.h).b(view, jSONObject);
        }
        if (this.h instanceof com.baidu.mobads.container.v.b.a) {
            ((com.baidu.mobads.container.v.b.a) this.h).d();
        }
    }

    public void b(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null && "sendSplashLog".equals(jSONObject.optString("msg"))) {
            b(map);
        }
        if (jSONObject != null && "sendSplashFailedLog".equals(jSONObject.optString("msg"))) {
            c(map);
        }
        if (this.h instanceof com.baidu.mobads.container.f.b) {
            ((com.baidu.mobads.container.f.b) this.h).handleEvent(jSONObject, map);
            return;
        }
        if (this.h != null) {
            this.h.handleEvent(jSONObject, map);
            return;
        }
        if (jSONObject != null && "splash_focus_start_activity".equals(jSONObject.optString(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE))) {
            try {
                Intent intent = (Intent) map.get("splash_focus_user_intent");
                if (this.c != null) {
                    this.c.startActivity(intent);
                }
                dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.H));
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }
    }

    public void c(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("uniqueId");
            if (!TextUtils.isEmpty(strOptString)) {
                j jVarG = g(strOptString);
                if (jVarG != null || this.f.c() != null) {
                    boolean zOptBoolean = jSONObject.optBoolean("result");
                    String str = "";
                    String strOptString2 = jSONObject.optString(SplashAd.KEY_BIDFAIL_ECPM, "");
                    String strOptString3 = jSONObject.optString(SplashAd.KEY_BIDFAIL_ADN, "");
                    String strOptString4 = jSONObject.optString("ad_t", "");
                    String strOptString5 = jSONObject.optString("ad_n", "");
                    String strOptString6 = jSONObject.optString("ad_time", "");
                    String strOptString7 = jSONObject.optString("bid_t", "");
                    String strOptString8 = jSONObject.optString("ad_ti", "");
                    String strOptString9 = jSONObject.optString("reason", "");
                    String str2 = zOptBoolean ? strOptString2 + "%23" + strOptString3 + "%23" + strOptString4 + "%23" + strOptString5 + "%23" + strOptString6 + "%23" + strOptString7 + "%23" + strOptString8 : strOptString2 + "%23" + strOptString3 + "%23" + strOptString4 + "%23" + strOptString5 + "%23" + strOptString6 + "%23" + strOptString7 + "%23" + strOptString9 + "%23" + jSONObject.optString("is_s", "") + "%23" + jSONObject.optString("is_c", "") + "%23" + strOptString8;
                    if ("%23%23%23%23%23%23".equals(str2) || "%23%23%23%23%23%23%23%23%23".equals(str2)) {
                        str2 = "";
                    }
                    JSONArray jSONArray = new JSONArray();
                    if (jVarG != null) {
                        JSONObject originJsonObject = jVarG.getOriginJsonObject();
                        if (originJsonObject == null) {
                            strOptString2 = "";
                        } else if (zOptBoolean) {
                            str = "${AUCTION_PRICE}";
                            jSONArray = originJsonObject.optJSONArray("nurl");
                        } else {
                            jSONArray = originJsonObject.optJSONArray("lurl");
                            str = "${AUCTION_LOSS}";
                            strOptString2 = strOptString9;
                        }
                    } else if (this.f.c() == null) {
                        strOptString2 = "";
                    } else {
                        jSONArray = this.f.c().b();
                        str = "${AUCTION_LOSS}";
                        strOptString2 = strOptString9;
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                String strReplace = jSONArray.getString(i).replace(str, strOptString2);
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strReplace)) {
                                    strReplace = strReplace.replace("${AUCTION_WININFO}", str2);
                                }
                                new com.baidu.mobads.container.components.g.f(1, strReplace).a();
                                cc.a(this.b, strReplace, cc.a.BIDDING);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void c(String str) {
        this.m = str;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        return DeviceUtils.getInstance().l(this.b);
    }

    public String A() {
        return this.m + "_cpr";
    }

    public View B() {
        if (this.h != null) {
            return this.h.getAdView();
        }
        return null;
    }

    public void C() {
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
        if (this.h instanceof com.baidu.mobads.container.e.l) {
            this.h.destroy();
        }
    }

    public void D() {
        if (this.h != null) {
            this.h.onAttachedToWindow();
        }
    }

    public void E() {
        if (this.h != null) {
            this.h.onDetachedFromWindow();
        }
    }

    public void a(int i) {
        if (this.h != null) {
            this.h.onWindowVisibilityChanged(i);
        }
    }

    public void a(boolean z) {
        if (this.h != null) {
            this.h.onWindowFocusChanged(z);
        }
    }

    private static class a extends com.baidu.mobads.container.util.d.a {
        private volatile int a = 1;
        private volatile com.baidu.mobads.container.util.d.a b = null;
        private volatile o c;
        private Context d;
        private final String e;
        private final j f;

        a(o oVar, j jVar) {
            this.c = null;
            this.d = null;
            this.c = oVar;
            this.e = jVar.getUniqueId();
            this.f = jVar;
            if (oVar != null) {
                this.d = oVar.t();
            }
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, int i) {
            if (this.b != null) {
                this.b.a(str, str2, view, i);
            }
            com.baidu.mobads.container.components.h.c.f.a(this.d).a(this.e, com.baidu.mobads.container.components.h.b.a.h, String.valueOf(i));
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
            a(false, str2);
            com.baidu.mobads.container.components.h.c.f.a(this.d).a(this.e, com.baidu.mobads.container.components.h.b.a.i, str2);
            com.baidu.mobads.container.components.h.c.f.a(this.d).a(this.e, com.baidu.mobads.container.components.h.b.a.j, String.valueOf(cVar.a()));
            com.baidu.mobads.container.components.h.c.f.a(this.d).a(this.e, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_FAILED);
            b(str, str2, view, cVar);
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Bitmap bitmap) {
            a(true, str2);
            b(str, str2, view, bitmap);
            com.baidu.mobads.container.components.h.c.f.a(this.d).a(this.e, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_SUCCESS);
        }

        public void a() {
            this.b = null;
            this.c = null;
        }

        public synchronized int a(com.baidu.mobads.container.util.d.a aVar) {
            if (this.a == 1) {
                this.b = aVar;
            }
            return this.a;
        }

        private synchronized void b(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
            this.a = 0;
            if (this.b != null) {
                this.b.a(str, str2, view, cVar);
                this.b = null;
            }
            a(str2, cVar);
        }

        private synchronized void b(String str, String str2, View view, Bitmap bitmap) {
            this.a = 2;
            if (this.b != null) {
                this.b.a(str, str2, view, bitmap);
                this.b = null;
            }
        }

        private void a(boolean z, String str) {
            try {
                o oVar = this.c;
                if (oVar != null) {
                    if (z) {
                        if (oVar.l(oVar.g)) {
                            oVar.g();
                        }
                        oVar.dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.J));
                        if (n.b(this.f, n.g, -2L) != 0) {
                            n.a(this.f, n.g, n.f);
                        }
                        this.c.a(this.f, str);
                        return;
                    }
                    if (oVar.l(oVar.g)) {
                        oVar.a(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED.b(), com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED.c());
                    }
                    oVar.J();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void a(String str, com.baidu.mobads.container.util.d.c cVar) {
            try {
                o oVar = this.c;
                if (cVar != null) {
                    String strC = cVar.c();
                    if (cVar.a() == -1 && !TextUtils.isEmpty(strC)) {
                        by.a.a(this.d).a(432).a("msg", "intercept").a(oVar.z()).c(oVar.k()).b(oVar.l()).a(this.f).a(ClickCommon.CLICK_AREA_MATERIAL, a(str)).a("url", a(strC)).f();
                    }
                }
            } catch (Throwable th) {
                bq.a().a(th);
            }
        }

        private String a(String str) {
            if (!TextUtils.isEmpty(str) && str.length() > 128) {
                return str.substring(0, 125) + "...";
            }
            return str;
        }
    }

    public com.baidu.mobads.container.k F() {
        return this.h;
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
    }

    public int a(com.baidu.mobads.container.util.d.a aVar) {
        if (this.B != null) {
            return this.B.a(aVar);
        }
        return 0;
    }

    private j g(String str) {
        ArrayList<j> arrayListO;
        if (this.f != null && !TextUtils.isEmpty(str) && (arrayListO = this.f.o()) != null) {
            Iterator<j> it = arrayListO.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && str.equals(next.getUniqueId())) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    public void g(j jVar) {
        if ("int".equals(k())) {
            c(jVar);
            if (!TextUtils.isEmpty(jVar.getMainPictureUrl()) && !TextUtils.equals(jVar.getMainPictureUrl(), d(jVar))) {
                com.baidu.mobads.container.util.d.d.a(this.b).e(jVar.getMainPictureUrl());
            }
            if (!TextUtils.isEmpty(jVar.getIconUrl()) && !TextUtils.equals(jVar.getMainPictureUrl(), jVar.getIconUrl())) {
                com.baidu.mobads.container.util.d.d.a(this.b).e(jVar.getIconUrl());
            }
        }
    }

    public void a(Map<String, Object> map) {
        Object obj = map.get("setActivity");
        if ((obj instanceof Activity) && this.h != null && (this.h instanceof com.baidu.mobads.container.e.l)) {
            ((com.baidu.mobads.container.e.l) this.h).a((Activity) obj);
        }
    }

    public boolean G() {
        if (this.g != null) {
            try {
                JSONObject originJsonObject = this.g.getOriginJsonObject();
                if (originJsonObject != null) {
                    boolean zOptBoolean = originJsonObject.optBoolean("native_rsplash", false);
                    if (!TextUtils.isEmpty(originJsonObject.optString("bg_pic", "")) && zOptBoolean) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void b(Map<String, Object> map) {
        try {
            if (!com.baidu.mobads.container.config.a.a().b()) {
                return;
            }
            String simpleName = ILogConst.CACHE_PLAY_REASON_NULL;
            if (this.h != null) {
                simpleName = this.h.getClass().getSimpleName();
            }
            by.a.a(this.b).a(820).a("adContainer", map.get("adContainer") + "").a("isAdaptive", map.get("isAdaptive") + "").a("mFetchNotShow", map.get("mFetchNotShow") + "").a("containerType", simpleName).a(q()).f();
        } catch (Throwable th) {
        }
    }

    public void c(Map<String, Object> map) {
        try {
            if (!com.baidu.mobads.container.config.a.a().b()) {
                return;
            }
            String simpleName = ILogConst.CACHE_PLAY_REASON_NULL;
            if (this.h != null) {
                simpleName = this.h.getClass().getSimpleName();
            }
            by.a.a(this.b).a(822).a("msg", map.get("msg") + "").a("containerType", simpleName).a(q()).f();
        } catch (Throwable th) {
        }
    }

    public void a(j jVar, String str) {
        try {
            if (!com.baidu.mobads.container.util.d.d.a(this.b).g(str)) {
                n.a(jVar, n.i, -1L);
            } else {
                File file = new File(com.baidu.mobads.container.util.d.d.a(this.b).c(str));
                n.a(jVar, n.i, file.length());
                n.a(jVar, n.h, (System.currentTimeMillis() - file.lastModified()) / 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
