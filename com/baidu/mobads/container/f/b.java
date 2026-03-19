package com.baidu.mobads.container.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.activity.PermissionDialogActivity;
import com.baidu.mobads.container.activity.v;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bh;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cc;
import com.baidu.mobads.container.util.ce;
import com.baidu.mobads.container.util.ci;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.u;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.component.a.g.a;
import com.component.a.g.c.bm;
import com.component.a.g.g;
import com.component.a.i.s;
import com.component.feed.ad;
import com.component.feed.ah;
import com.component.feed.an;
import com.component.interfaces.RemoteReflectInterface;
import com.sigmob.sdk.base.mta.PointType;
import com.style.widget.e.f;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends com.baidu.mobads.container.k {
    public static final String a = "XDummyFeedsAdContainer";
    public static final String b = "00";
    private static final int c = 10000;
    private static final int d = 100;
    private static final int e = 2;
    private static final int f = 4;
    private static final int g = 8;
    private static final int h = 16;
    private static final int i = 32;
    private static final int j = 64;
    private static final int k = 128;
    private final ConcurrentHashMap<String, Integer> l;
    private v m;
    private Map<String, ci.b> n;
    private Map<String, com.component.a.f.e> o;
    private Map<String, Map<String, String>> p;
    private HashMap<String, a> q;

    protected boolean a(String str) {
        try {
            return a(16, str);
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
            return false;
        }
    }

    static class a {
        public final com.baidu.mobads.container.adrequest.j a;
        public bh e;
        protected String c = "";
        protected int d = 1;
        public int f = 0;
        public boolean g = true;
        public String i = "-1";
        private long k = 0;
        private long l = 0;
        public final HashMap<String, String> b = new HashMap<>();
        public final long j = System.currentTimeMillis();
        public AtomicBoolean h = new AtomicBoolean(false);

        a(com.baidu.mobads.container.adrequest.j jVar) {
            this.a = jVar;
        }

        public void a() {
            if (this.e != null) {
                this.f += this.e.e();
                this.e.b();
                this.e = null;
            }
        }
    }

    public b(t tVar) {
        super(tVar);
        this.l = new ConcurrentHashMap<>();
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = new HashMap<>();
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = a;
    }

    @Override // com.baidu.mobads.container.k
    public void doLoadOnUIThread() {
        this.mAdLogger.a(a, "doLoadInUiThread");
        start();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        this.mAdLogger.a(a, "doStartInUiThread");
        if (this.mAppContext != null && this.mAdContainerCxt != null) {
            com.baidu.mobads.container.adrequest.l lVarR = this.mAdContainerCxt.r();
            if (lVarR != null) {
                this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.v, lVarR.p()));
            } else {
                this.mAdLogger.b(a, "null response while do start");
            }
            com.baidu.mobads.container.c.a().a(this.mAppContext);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void stop() {
    }

    private void b(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("activity");
            if (obj instanceof Activity) {
                this.mActivity = (Activity) obj;
                if (this.mAdContainerCxt != null) {
                    this.mAdContainerCxt.a(this.mActivity);
                }
            }
        }
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, Map<String, Object> map) {
        if (jVar != null && map != null) {
            map.put("container", b(jVar, true));
        }
    }

    private ad b(com.baidu.mobads.container.adrequest.j jVar, boolean z) {
        ad adVar = new ad(this.mAppContext);
        setAdContainerView(jVar.getUniqueId(), adVar);
        adVar.a(new com.baidu.mobads.container.f.c(this, adVar, z, jVar));
        return adVar;
    }

    private JSONObject a(com.component.a.g.d dVar, g.a aVar, JSONObject jSONObject, com.baidu.mobads.container.adrequest.j jVar, float f2) {
        return dVar.a(jSONObject, aVar, new h(this, jVar, f2));
    }

    private com.component.a.g.d a(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, com.style.widget.e.f fVar, boolean z, boolean z2) {
        com.component.a.g.d dVar = new com.component.a.g.d(kVar, jVar);
        String uniqueId = jVar.getUniqueId();
        JSONObject originJsonObject = jVar.getOriginJsonObject();
        dVar.a(new a.C0317a().a(fVar != null ? fVar.a() : null).a(com.component.a.g.b.c.b, new j(this)).d(z2).b((TextUtils.isEmpty(jVar.getMarketingIconUrl()) || TextUtils.isEmpty(jVar.getMarketingDesc())) ? false : true).a(new i(this, this, jVar, fVar, uniqueId, z, originJsonObject.optString("privacy_link"), originJsonObject.optString(com.baidu.mobads.container.components.command.j.M), originJsonObject.optString(com.baidu.mobads.container.components.command.j.L), z2)));
        return dVar;
    }

    private JSONObject b(String str, com.baidu.mobads.container.adrequest.j jVar) {
        if (TextUtils.equals(str, "bookmark")) {
            try {
                return new JSONObject(new com.component.a.e.e.b().a(41, 1));
            } catch (Throwable th) {
                this.mAdLogger.a(a, th);
                return null;
            }
        }
        return null;
    }

    private void b(JSONObject jSONObject, Map<String, Object> map) {
        JSONObject originJsonObject;
        int iB;
        String str;
        if (jSONObject != null && map != null) {
            try {
                com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
                int iOptInt = jSONObject.optInt("w", 0);
                int iOptInt2 = jSONObject.optInt("h", 0);
                boolean z = jSONObject.optInt("isContainer", 0) == 1;
                if (iOptInt >= 80 && iOptInt2 >= 80) {
                    if (adInstanceInfoByJson != null && (originJsonObject = adInstanceInfoByJson.getOriginJsonObject()) != null) {
                        String uniqueId = adInstanceInfoByJson.getUniqueId();
                        com.component.a.f.e eVarA = a(adInstanceInfoByJson, "native_shake_view");
                        if (eVarA != null && eVarA.e(-1) == 1) {
                            an anVar = new an(this.mAppContext, new com.component.a.f.e(eVarA.f()), z);
                            if (z) {
                                if (!anVar.a()) {
                                    return;
                                }
                                String strC = j.a.BLANK_SHAKE_VIEW.c();
                                int iB2 = j.a.BLANK_SHAKE_VIEW.b();
                                map.put("shake_controller", anVar.c());
                                iB = iB2;
                                str = strC;
                            } else {
                                iB = j.a.SHAKE_VIEW.b();
                                str = "native_shake_view";
                            }
                            anVar.setLayoutParams(new RelativeLayout.LayoutParams(bv.a(this.mAppContext, iOptInt), bv.a(this.mAppContext, iOptInt2)));
                            jSONObject.put("use_dialog_frame", originJsonObject.optInt("dl_dialog", -1) != 0);
                            anVar.a(new k(this, anVar, str, uniqueId, jSONObject, adInstanceInfoByJson));
                            JSONObject jSONObjectC = eVarA.c();
                            String[] strArr = new String[2];
                            if (jSONObjectC != null) {
                                strArr[0] = String.valueOf(jSONObjectC.optInt("velocity", 7));
                                strArr[1] = jSONObjectC.optString("shake_angle", "");
                            }
                            com.baidu.mobads.container.adrequest.n.a(adInstanceInfoByJson, iB, strArr);
                            map.put("shake_view", anVar);
                        }
                        return;
                    }
                    return;
                }
                this.mAdLogger.b(a, "RenderShakeView failed: 组件宽高不能小于80!");
            } catch (Throwable th) {
                this.mAdLogger.a(a, th);
            }
        }
    }

    private void b(com.baidu.mobads.container.adrequest.j jVar, JSONObject jSONObject, Map<String, Object> map) {
        if (jVar != null && jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("viewId");
                JSONObject originJsonObject = jVar.getOriginJsonObject();
                String uniqueId = jVar.getUniqueId();
                boolean z = originJsonObject.optInt("dl_dialog", 1) == 1;
                com.component.a.f.e eVarA = a(jVar, strOptString);
                if (eVarA != null && eVarA.e(-1) == 1) {
                    JSONObject jSONObjectA = a(strOptString, eVarA, jSONObject);
                    boolean zOptBoolean = jSONObject.optBoolean("isDownloadApp", false);
                    ad adVarB = b(jVar, false);
                    adVarB.a("-1");
                    if (a(this, jVar, (com.style.widget.e.f) null, zOptBoolean, z).a(adVarB, jSONObjectA, new ah(this.mAdContainerCxt, jVar)) != null) {
                        map.put(strOptString, adVarB);
                        if (!TextUtils.isEmpty(uniqueId) && !a(uniqueId, strOptString)) {
                            a(uniqueId, strOptString, "1");
                            by.a.a(this.mAppContext).a(809).a(jVar).a("viewId", strOptString).a("expire", "" + (System.currentTimeMillis() - this.mAdContainerCxt.r().a())).a("forecurl", h(jVar.getClickThroughUrl())).b(this.mAdContainerCxt.l()).c(this.mAdContainerCxt.k()).a(this.mAdContainerCxt.z()).a("uniqueid", uniqueId).a("bidl", c(jVar)).a("ebidl", d(jVar)).f();
                        }
                    }
                    return;
                }
                this.mAdLogger.c(a, "renderNativeView failed: nativeViewInfo is null");
            } catch (Throwable th) {
                this.mAdLogger.a(a, th);
            }
        }
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar, JSONObject jSONObject, Map<String, Object> map) {
        if (jVar != null && jSONObject != null) {
            try {
                ad adVarB = b(jVar, false);
                adVarB.a("feed_native_template");
                String strOptString = jSONObject.optString("viewId");
                String uniqueId = jVar.getUniqueId();
                JSONObject originJsonObject = jVar.getOriginJsonObject();
                boolean zOptBoolean = jSONObject.optBoolean("isDownloadApp", false);
                boolean z = originJsonObject.optInt("dl_dialog", 1) == 1;
                com.style.widget.e.f fVar = new com.style.widget.e.f(this, jVar, new C0127b(this, uniqueId, zOptBoolean, z));
                com.component.a.g.d dVarA = a(this, jVar, fVar, zOptBoolean, z);
                JSONObject jSONObjectA = a(strOptString, jVar, jSONObject);
                if (jSONObjectA == null) {
                    this.mAdLogger.c(a, "renderNativeView failed: input params is invalid.");
                    return;
                }
                JSONObject jSONObjectA2 = a(dVarA, new com.component.a.e.a.a(), jSONObjectA, jVar, -1.0f);
                if (!com.component.a.i.n.a(jSONObjectA2)) {
                    this.mAdLogger.c(a, "renderNativeView failed: viewInfo is invalid.");
                } else if (dVarA.a(adVarB, jSONObjectA2, fVar) != null && map != null) {
                    map.put(strOptString, adVarB);
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.e(a, th);
            }
        }
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, ViewGroup viewGroup, int i2, int i3) {
        if (jVar == null) {
            return;
        }
        try {
            if (viewGroup == null) {
                b(jVar, "Container cannot be null.");
                return;
            }
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
            viewGroup.removeAllViews();
            String uniqueId = jVar.getUniqueId();
            JSONObject originJsonObject = jVar.getOriginJsonObject();
            boolean zEquals = ab.a.APP_DOWNLOAD.equals(ab.a(this.mAppContext, jVar));
            boolean z = originJsonObject.optInt("dl_dialog", 1) == 1;
            com.style.widget.e.f fVar = new com.style.widget.e.f(this, jVar, new C0127b(this, uniqueId, zEquals, z));
            com.component.a.g.d dVarA = a(this, jVar, fVar, zEquals, z);
            JSONObject jSONObjectA = a(dVarA, jVar, i2, i3);
            if (jSONObjectA == null) {
                b(jVar, "Layout data parse fail.");
                return;
            }
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(uniqueId, com.baidu.mobads.container.components.h.b.a.l, jSONObjectA.optString("id", ""));
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_START);
            View viewA = dVarA.a(viewGroup, jSONObjectA, fVar);
            fVar.a(viewA);
            if (viewA != null && this.mAdContainerCxt != null) {
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_SUCCESS);
                HashMap map = new HashMap();
                int[] iArr = {0, 0};
                if (viewGroup instanceof ad) {
                    ((ad) viewGroup).a(i2, 0, iArr);
                    ((ad) viewGroup).a(fVar);
                }
                map.put("uniqueId", uniqueId);
                map.put("expressView", viewGroup);
                map.put("viewWidth", Integer.valueOf(iArr[0]));
                map.put("viewHeight", Integer.valueOf(iArr[1]));
                this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.O, 1, (HashMap<String, Object>) map));
                if (viewGroup instanceof ad) {
                    ((ad) viewGroup).a(com.component.a.i.n.a(viewA, "0"));
                    if (((ad) viewGroup).b()) {
                        a(viewGroup, jVar);
                    }
                }
                return;
            }
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_FAILED);
            b(jVar, "Error attaching view.");
        } catch (Throwable th) {
            b(jVar, th.getMessage());
        }
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup instanceof ad) {
            try {
                ((ad) viewGroup).c();
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.e(a, "releaseExpressView error: %s", th.getMessage());
            }
        }
    }

    private float a(int i2, int i3) {
        if (i2 > 240 && i3 > 240) {
            float f2 = i2 / i3;
            double d2 = f2;
            if (0.33d < d2 && d2 < 0.76d) {
                return f2;
            }
            return -1.0f;
        }
        return -1.0f;
    }

    private JSONObject a(String str, com.baidu.mobads.container.adrequest.j jVar, JSONObject jSONObject) {
        if (jVar != null && jSONObject != null) {
            try {
                if ("bookmark".equals(str)) {
                    int iOptInt = jSONObject.optInt("w", 0);
                    int iOptInt2 = jSONObject.optInt("h", 0);
                    if (iOptInt2 < 120 || iOptInt < 180) {
                        return null;
                    }
                    if (TextUtils.isEmpty(jVar.getMainPictureUrl()) && TextUtils.isEmpty(jVar.getVideoUrl())) {
                        return null;
                    }
                    String str2 = jSONObject.optBoolean(com.baidu.mobads.container.k.CC_REGION_CLICK, false) ? com.component.a.g.b.t : "ad_click";
                    int i2 = jSONObject.optBoolean("hide_mute", false) ? 0 : 1;
                    JSONObject jSONObject2 = new JSONObject(String.format(Locale.getDefault(), "{\"tp_id\":\"opt_style_41_1\",\"amend\":{\"increment\":[{\"id\":\"opt_style_41_1\",\"w\":\"%d\",\"aspect_rate\":\"%.2f\",\"theme\":{\"bg_card_color\":\"%s\",\"click\": \"%s\"}},{\"id\":\"41_1_video_view#1\", \"click\":\"%s\"},{\"id\":\"41_1_dislike_view#3\",\"visibility\":\"%d\"},{\"id\":\"41_1_bd_ad_logo#8\",\"visibility\":\"%d\"},{\"id\":\"41_1_video_mute_view#3\",\"visibility\":\"%d\"}]}}", Integer.valueOf(iOptInt), Float.valueOf(iOptInt / iOptInt2), jSONObject.optString("bottom_card_color", "#C2C5CC"), str2, str2, Integer.valueOf(jSONObject.optBoolean("hide_dislike", false) ? 0 : 1), Integer.valueOf(jSONObject.optBoolean("hide_ad_logo", false) ? 0 : 1), Integer.valueOf(i2)));
                    String strOptString = jSONObject.optString(com.sigmob.sdk.base.common.a.D, "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        jVar.setMute(strOptString);
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("amend");
                    if (jSONObjectOptJSONObject != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("increment");
                        if (jSONArrayOptJSONArray != null) {
                            try {
                                a(jVar, jSONArrayOptJSONArray);
                            } catch (Throwable th) {
                                th = th;
                                com.baidu.mobads.container.l.g.b(th);
                                return null;
                            }
                        }
                    }
                    return jSONObject2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectB;
        JSONObject originJsonObject = jVar.getOriginJsonObject();
        if (originJsonObject != null && (jSONObjectOptJSONObject = originJsonObject.optJSONObject("st_op")) != null && (jSONArrayOptJSONArray = com.component.a.i.n.c(jSONObjectOptJSONObject.optString("amend")).optJSONArray("increment")) != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                        String strOptString = jSONObjectOptJSONObject2.optString("id");
                        if ("native_coupon_float_icon".equals(strOptString)) {
                            JSONObject jSONObjectB2 = com.component.a.i.n.b(jSONObjectOptJSONObject2.optString("json_view"));
                            if (jSONObjectB2 != null) {
                                jSONObjectB2.put("above", "41_1_front_card#2");
                                jSONObjectB2.put("gravity", "4");
                                jSONObjectB2.put("margin", "[11,0,0,20]");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("id", strOptString);
                                jSONObject.put("json_view", jSONObjectB2);
                                jSONArray.put(jSONObject);
                            }
                        } else if ("native_coupon_flip_page".equals(strOptString) && (jSONObjectB = com.component.a.i.n.b(jSONObjectOptJSONObject2.optString("json_view"))) != null) {
                            jSONObjectB.put("gravity", PointType.SIGMOB_APP);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("id", strOptString);
                            jSONObject2.put("json_view", jSONObjectB);
                            jSONArray.put(jSONObject2);
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.mobads.container.l.g.b(th);
                    return;
                }
            }
        }
    }

    private JSONObject a(com.component.a.g.d dVar, com.baidu.mobads.container.adrequest.j jVar, int i2, int i3) {
        float fA = a(i2, i3);
        JSONObject optimizedJson = jVar.getOptimizedJson();
        JSONObject originJsonObject = jVar.getOriginJsonObject();
        if (optimizedJson == null || optimizedJson.length() == 0) {
            JSONObject jSONObjectOptJSONObject = originJsonObject.optJSONObject("st_op");
            com.component.a.e.e.b bVar = new com.component.a.e.e.b();
            bVar.a(jVar.getFeedAdStyleType());
            optimizedJson = a(dVar, bVar, jSONObjectOptJSONObject, jVar, fA);
            jVar.setOptimizedJson(optimizedJson);
        }
        if (!com.component.a.i.n.a(optimizedJson)) {
            optimizedJson = com.component.a.i.n.b(new com.component.a.e.e.b().b(fA > 0.0f ? 41 : 29));
            if (fA > 0.0f) {
                a(optimizedJson, fA);
            }
        }
        return optimizedJson;
    }

    /* renamed from: com.baidu.mobads.container.f.b$b, reason: collision with other inner class name */
    static class C0127b implements f.a {
        private final String a;
        private final boolean b;
        private final boolean c;
        private final b d;

        public C0127b(b bVar, String str, boolean z, boolean z2) {
            this.d = bVar;
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        @Override // com.style.widget.e.f.a
        public boolean a(com.component.a.f.d dVar) {
            this.d.a(dVar.e(), dVar, this.a, this.b, this.c);
            return true;
        }

        @Override // com.style.widget.e.f.a
        public void a(String str, com.component.a.f.d dVar) {
            if (bm.h.equals(str)) {
                this.d.a(dVar.e(), dVar, this.a, this.b, this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str) {
        return "opt_style_41".equals(str) || "opt_style_41_1".equals(str) || "opt_style_41_2".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, float f2) {
        if (jSONObject != null && jSONObject.has("aspect_rate")) {
            com.component.a.i.n.b(jSONObject, "aspect_rate", Float.valueOf(f2));
        }
    }

    private void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("view");
            Object obj2 = map.get("code");
            boolean zA = false;
            if ((obj instanceof View) && (obj2 instanceof Integer)) {
                View childAt = (View) obj;
                if (obj instanceof ad) {
                    childAt = ((ad) obj).getChildAt(0);
                }
                zA = s.a(childAt, ((Integer) obj2).intValue());
            }
            map.put("result", Boolean.valueOf(zA));
        }
    }

    public com.component.a.f.e a(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null) {
            String uniqueId = jVar.getUniqueId();
            com.component.a.f.e eVar = this.o.get(uniqueId);
            if (eVar != null) {
                return eVar;
            }
            JSONObject jSONObjectA = new com.component.a.g.d(this, jVar).a(new com.component.a.e.a.a());
            if (jSONObjectA != null) {
                com.component.a.f.e eVar2 = new com.component.a.f.e(jSONObjectA);
                this.o.put(uniqueId, eVar2);
                return eVar2;
            }
            return null;
        }
        return null;
    }

    public com.component.a.f.e a(com.baidu.mobads.container.adrequest.j jVar, String str) {
        List<com.component.a.f.e> listO;
        com.component.a.f.e eVarA = a(jVar);
        if (eVarA != null && !TextUtils.isEmpty(str) && (listO = eVarA.o()) != null && listO.size() > 0) {
            for (com.component.a.f.e eVar : listO) {
                if (eVar != null && str.equals(eVar.l(""))) {
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    private JSONObject a(String str, com.component.a.f.e eVar, JSONObject jSONObject) {
        if ("native_slide_view".equals(str)) {
            return a(eVar, jSONObject);
        }
        if ("native_bullet_view".equals(str)) {
            int iOptInt = jSONObject.optInt("w", 0);
            int iOptInt2 = jSONObject.optInt("h", 0);
            if (iOptInt != -1 && iOptInt < 120) {
                return null;
            }
            JSONObject jSONObjectF = eVar.f();
            a(jSONObjectF, "w", iOptInt);
            a(jSONObjectF, "h", iOptInt2);
            return jSONObjectF;
        }
        return eVar.f();
    }

    private JSONObject a(com.component.a.f.e eVar, JSONObject jSONObject) {
        if (jSONObject != null && eVar != null) {
            int iOptInt = jSONObject.optInt("w", 0);
            int iOptInt2 = jSONObject.optInt("h", 0);
            int iOptInt3 = jSONObject.optInt("repeat", -1);
            Map<String, com.component.a.f.e> mapA = com.component.a.i.n.a(eVar);
            com.component.a.f.e eVar2 = mapA.get("native_gesture_container");
            if (eVar2 != null) {
                JSONObject jSONObjectF = eVar2.f();
                a(jSONObjectF, "w", iOptInt);
                a(jSONObjectF, "h", iOptInt2);
            }
            com.component.a.f.e eVar3 = mapA.get("native_gesture_lottie");
            if (eVar3 != null) {
                a(eVar3.f(), "lottie", "repeat", iOptInt3);
            }
            return eVar.f();
        }
        return null;
    }

    private void a(JSONObject jSONObject, String str, String str2, int i2) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArrayB = com.component.a.i.n.b(jSONObject, str);
                if (jSONArrayB != null && jSONArrayB.length() > 0) {
                    a(jSONArrayB.optJSONObject(0), str2, i2);
                    jSONObject.put(str, jSONArrayB);
                }
            } catch (Throwable th) {
                this.mAdLogger.a(a, th);
            }
        }
    }

    private void a(JSONObject jSONObject, String str, int i2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i2);
            } catch (Throwable th) {
                this.mAdLogger.a(a, th);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
            if (adInstanceInfoByJson != null) {
                com.component.a.f.e eVarA = a(adInstanceInfoByJson, "native_dl_pause_view");
                int iOptInt = 0;
                if (eVarA != null && eVarA.c() != null) {
                    iOptInt = eVarA.c().optInt("rvideo_dl_pause_dialog", 0);
                }
                if (iOptInt != 1) {
                    RemoteReflectInterface.pauseDlByPk(jSONObject.optString("pk", ""), 1);
                } else {
                    new com.baidu.mobads.container.b.a().a(this, adInstanceInfoByJson);
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(th);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handleDislikeClick(com.baidu.mobads.container.adrequest.j jVar, View view, com.component.a.f.d dVar) {
        if (e(jVar.getUniqueId())) {
            boolean z = jVar.getOriginJsonObject().optInt("dl_dialog", 1) == 1;
            boolean zEquals = ab.a.APP_DOWNLOAD.equals(ab.a(this.mAppContext, jVar));
            dVar.a(4);
            a(view, dVar, jVar.getUniqueId(), zEquals, z);
            return;
        }
        super.handleDislikeClick(jVar, view, dVar);
    }

    private void d(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("native_view");
            if (obj instanceof an) {
                ((an) obj).f();
            }
        }
    }

    private void b(com.baidu.mobads.container.adrequest.j jVar, String str) {
        if (jVar != null && this.mAdContainerCxt != null) {
            HashMap map = new HashMap();
            map.put("uniqueId", jVar.getUniqueId());
            map.put("expressView", null);
            map.put("error_code", Integer.valueOf(com.baidu.mobads.container.c.a.RENDER_PROCESS_FAILED.b()));
            map.put("error_message", com.baidu.mobads.container.c.a.RENDER_PROCESS_FAILED.c() + "," + str);
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.P, (HashMap<String, Object>) map));
        }
    }

    public void a(View view, com.component.a.f.d dVar, String str, boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("isDownloadApp", z);
            jSONObject.put("use_dialog_frame", z2);
            this.mClickTracker.a(dVar.a());
            JSONObject adStatus = this.mAdContainerCxt.q().getAdStatus();
            long jOptLong = adStatus != null ? adStatus.optLong(com.baidu.mobads.container.adrequest.n.H, 0L) : 0L;
            this.mClickTracker.a(view);
            setClickInfoForCK(this.mClickTracker, jOptLong);
            a(view, jSONObject, dVar.a().a());
            Integer num = this.l.get(str);
            if (num != null && e(str)) {
                this.l.put(str, Integer.valueOf(num.intValue() + com.alipay.sdk.m.n.a.g));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", str);
            jSONObject.put("uniqueId", str2);
            jSONObject.put(str3, str4);
            handleEvent(jSONObject, null);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onDislikeEvent(com.baidu.mobads.container.adrequest.j jVar, HashMap<String, Object> map) {
        if (this.mAdContainerCxt != null && map != null && jVar != null) {
            map.put("uniqueId", jVar.getUniqueId());
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.N, map));
        }
    }

    public void b(String str) {
        if (this.mAdContainerCxt != null && !TextUtils.isEmpty(str)) {
            HashMap map = new HashMap();
            map.put("uniqueId", str);
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map));
        }
    }

    private class c implements IOAdEventListener {
        private final Context b;
        private final com.baidu.mobads.container.adrequest.j c;

        c(Context context, com.baidu.mobads.container.adrequest.j jVar) {
            this.b = context;
            this.c = jVar;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
                b.this.onPrivacyLpClose(this.c);
                com.baidu.mobads.container.landingpage.ad.a(this.b).b();
            }
        }
    }

    private void a(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        if (context != null) {
            com.baidu.mobads.container.landingpage.ad.a(context).a();
            com.baidu.mobads.container.landingpage.ad.a(context).addEventListener(com.baidu.mobads.container.components.k.b.F, new c(context, jVar));
        }
    }

    @Override // com.baidu.mobads.container.k
    public View getAdView() {
        return super.getAdView();
    }

    public void a(View view, JSONObject jSONObject) {
        com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
        if (adInstanceInfoByJson != null) {
            a(view, adInstanceInfoByJson);
            setAdContainerView(adInstanceInfoByJson.getUniqueId(), view);
        }
        if (view != null) {
            view.setOnTouchListener(new l(this));
        }
    }

    public void a(View view, com.baidu.mobads.container.adrequest.j jVar, Map<String, Object> map, String str) {
        a aVarB = b(jVar);
        SoftReference softReference = new SoftReference(view);
        if (a(jVar.getUniqueId()) || aVarB.h.get()) {
            return;
        }
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_START);
        com.baidu.mobads.container.components.h.d.a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_IMPRESSION);
        aVarB.h.set(true);
        if (view instanceof ad) {
            aVarB.i = ((ad) view).a();
        }
        map.put("apid", this.mAdContainerCxt.l());
        aVarB.e = new bh(10000);
        if (aVarB.b != null) {
            aVarB.b.put("impressionFrom", str);
        }
        aVarB.e.a(new m(this, aVarB, softReference, map, jVar));
        aVarB.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        String uniqueId;
        try {
            if (this.mAdContainerCxt != null && aVar != null) {
                if (aVar.a == null) {
                    uniqueId = null;
                } else {
                    uniqueId = aVar.a.getUniqueId();
                }
                if (!a(32, uniqueId)) {
                    b(32, uniqueId);
                    HashMap map = new HashMap();
                    map.put(cm.Z, uniqueId);
                    map.put("showState", String.valueOf(aVar.d));
                    this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.x, (HashMap<String, Object>) map));
                    a(aVar, 362);
                    com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_FAILED);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected a b(com.baidu.mobads.container.adrequest.j jVar) {
        return a(jVar, (JSONObject) null);
    }

    protected a a(com.baidu.mobads.container.adrequest.j jVar, JSONObject jSONObject) {
        String uniqueId = jVar.getUniqueId();
        a aVar = this.q.get(uniqueId);
        if (aVar == null) {
            a aVar2 = new a(jVar);
            this.q.put(uniqueId, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public void b(View view, JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null && jSONObject.has("click_type")) {
            iOptInt = jSONObject.optInt("click_type", 0);
        }
        this.mClickTracker.a(iOptInt);
        this.mClickTracker.a(view);
        JSONObject adStatus = this.mAdContainerCxt.q().getAdStatus();
        setClickInfoForCK(this.mClickTracker, adStatus != null ? adStatus.optLong(com.baidu.mobads.container.adrequest.n.H, 0L) : 0L);
        a(view, jSONObject, iOptInt);
    }

    public void a(View view, JSONObject jSONObject, int i2) throws JSONException {
        boolean z;
        boolean z2;
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.T));
        com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
        if (adInstanceInfoByJson == null || jSONObject == null) {
            return;
        }
        boolean zOptBoolean = jSONObject.optBoolean("use_dialog_frame", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("isDownloadApp", false);
        recordAdClickStatus(adInstanceInfoByJson);
        this.mClickTracker.a(new com.baidu.mobads.container.o.b());
        if (zOptBoolean2) {
            Context context = view.getContext();
            try {
                z = adInstanceInfoByJson.getOriginJsonObject().optInt("notice_dl_non_wifi", 0) == 1;
            } catch (Throwable th) {
                z = false;
            }
            try {
                if (!com.baidu.mobads.container.util.j.b(context, adInstanceInfoByJson.getAppPackageName())) {
                    if (!bk.b(context, adInstanceInfoByJson.getAppStoreLink())) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
            } catch (Throwable th2) {
                this.mAdLogger.a(a, th2.getMessage());
                z2 = false;
            }
            int iOptInt = this.mAdContainerCxt.w().optInt("appConfirmPolicy", 1);
            if (iOptInt == 3) {
                adInstanceInfoByJson.setActionOnlyWifi(false);
                a(view, adInstanceInfoByJson, i2, zOptBoolean);
                return;
            }
            if (iOptInt == 4) {
                this.mAdInstanceInfo.setActionOnlyWifi(false);
                a(view, adInstanceInfoByJson, i2, zOptBoolean);
                return;
            }
            if (iOptInt == 2) {
                if (z2) {
                    this.mAdInstanceInfo.setActionOnlyWifi(false);
                    a(view, adInstanceInfoByJson, i2, zOptBoolean);
                    return;
                } else {
                    a(view, adInstanceInfoByJson, i2);
                    return;
                }
            }
            if (iOptInt == 1) {
                if (!com.baidu.mobads.container.util.e.a.i(context).booleanValue() && z && !z2) {
                    a(view, adInstanceInfoByJson, i2);
                    return;
                } else {
                    this.mAdInstanceInfo.setActionOnlyWifi(false);
                    a(view, adInstanceInfoByJson, i2, zOptBoolean);
                    return;
                }
            }
            return;
        }
        a(view, adInstanceInfoByJson, i2, zOptBoolean);
    }

    public void a(View view, com.baidu.mobads.container.adrequest.j jVar, int i2, boolean z) throws JSONException {
        boolean z2;
        if (jVar == null) {
            return;
        }
        registerState(jVar.getCreateTime(), "feed", jVar);
        com.baidu.mobads.container.components.h.d.a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_CLICK);
        com.baidu.mobads.container.components.h.d.b(jVar.getUniqueId(), com.baidu.mobads.container.components.h.b.g);
        if (jVar.getActionType() == 512 && TextUtils.equals(jVar.getAppPackageName(), "com.baidu.searchbox")) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z3 = i2 == 2;
        HashMap<String, Object> shouBaiLpFlag = getShouBaiLpFlag(this.mAdContainerCxt, jVar);
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        shouBaiLpFlag.put("use_dialog_frame", Boolean.valueOf(z));
        shouBaiLpFlag.put("adView", view);
        shouBaiLpFlag.put("shake", Boolean.valueOf(z3));
        shouBaiLpFlag.put(com.baidu.mobads.container.components.k.c.b, parseDlToast(jVar.getOriginJsonObject()));
        if (!z2) {
            new com.baidu.mobads.container.components.k.c(this).a((com.baidu.mobads.container.k) this, jVar, (Boolean) true, shouBaiLpFlag);
            if (jVar.getActionType() != 2) {
                beforeSendLog(jVar, view, z3);
                onAdClick(jVar, view);
                return;
            } else {
                if (App2Activity.LP_STYLE_VIDEO.equals(shouBaiLpFlag.get("lpShoubaiStyle"))) {
                    beforeSendLog(jVar, view, z3);
                    return;
                }
                return;
            }
        }
        new com.baidu.mobads.container.p.a(this.mAppContext, this.mAdContainerCxt.z(), this.mAdContainerCxt.l(), this.mAdContainerCxt.k()).a(jVar, new n(this, shouBaiLpFlag));
        com.baidu.mobads.container.components.h.d.a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_CLICK_PULL_SHOUBAI);
        beforeSendLog(jVar, view, z3);
        onAdClick(jVar, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Map<String, Object> map, com.baidu.mobads.container.adrequest.j jVar) throws JSONException {
        if (map.get("progress") == null) {
            return;
        }
        a(com.baidu.mobads.container.o.c.a((List<String>) map.get("trackerUrl"), view, false), ((Integer) map.get("progress")).intValue(), jVar);
    }

    @Override // com.baidu.mobads.container.k
    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iIntValue;
        int iIntValue2;
        if (jSONObject != null && this.mAdContainerCxt != null) {
            String strOptString = jSONObject.optString("msg", "");
            String strOptString2 = jSONObject.optString("uniqueId", "");
            if (TextUtils.equals(strOptString, "registerViewForInteraction")) {
                a(jSONObject, map);
                return;
            }
            if (TextUtils.equals(strOptString, "pauseDownload")) {
                a(jSONObject);
                return;
            }
            if (TextUtils.equals(strOptString, "cancelDownload")) {
                b(jSONObject);
                return;
            }
            if (TextUtils.equals(strOptString, "resumeDownload")) {
                RemoteReflectInterface.resumeDownload(this.mAppContext, getAdInstanceInfoByJson(jSONObject).getOriginJsonObject(), "feed", "ac_feed");
                return;
            }
            if (TextUtils.equals(strOptString, "permissionClick")) {
                if (!com.baidu.mobads.container.config.b.a().e()) {
                    com.style.widget.b.i iVarA = com.style.widget.b.i.a(this.mActivity, jSONObject.optString(PermissionDialogActivity.PERMISSION_URL));
                    iVarA.a(new o(this, strOptString2));
                    iVarA.a();
                    return;
                } else {
                    this.m = new d(this, strOptString2);
                    com.baidu.mobads.container.activity.e.a().a(this.m);
                    Intent intent = new Intent();
                    intent.putExtra(PermissionDialogActivity.PERMISSION_URL, jSONObject.optString(PermissionDialogActivity.PERMISSION_URL));
                    com.baidu.mobads.container.util.h.f(this.mAppContext.getApplicationContext(), intent);
                    return;
                }
            }
            if (TextUtils.equals(strOptString, "privacyClick")) {
                Intent intent2 = new Intent();
                intent2.putExtra("privacy_link", jSONObject.optString("privacy_link"));
                a(this.mAppContext, getAdInstanceInfoByJson(jSONObject));
                com.baidu.mobads.container.util.h.a(this.mAppContext, intent2);
                this.mAdContainerCxt.s().dispatchEvent(new cm("adPrivacyClick", strOptString2));
                return;
            }
            if (TextUtils.equals(strOptString, "functionClick")) {
                Intent intent3 = new Intent();
                intent3.putExtra("privacy_link", jSONObject.optString(com.baidu.mobads.container.components.command.j.M));
                a(this.mAppContext, getAdInstanceInfoByJson(jSONObject));
                com.baidu.mobads.container.util.h.a(this.mAppContext, intent3);
                this.mAdContainerCxt.s().dispatchEvent(new cm("adFunctionClick", strOptString2));
                return;
            }
            if (TextUtils.equals(strOptString, "unionLogoClick")) {
                Intent intent4 = new Intent();
                intent4.putExtra("privacy_link", jSONObject.optString("unionUrl"));
                com.baidu.mobads.container.util.h.a(this.mAppContext, intent4);
                this.mAdContainerCxt.s().dispatchEvent(new cm("unionLogoClick", strOptString2));
                return;
            }
            if (TextUtils.equals(strOptString, "preloadVideoMaterial")) {
                if (this.mAdContainerCxt instanceof com.baidu.mobads.container.adrequest.o) {
                    ((com.baidu.mobads.container.adrequest.o) this.mAdContainerCxt).a(getAdInstanceInfoByJson(jSONObject), true);
                    return;
                }
                return;
            }
            if (TextUtils.equals(strOptString, "bindExpressActivity")) {
                b(map);
                return;
            }
            if (TextUtils.equals(strOptString, "initExpressContainer")) {
                a(getAdInstanceInfoByJson(jSONObject), map);
                return;
            }
            if (TextUtils.equals(strOptString, "renderExpressView")) {
                com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
                int i2 = 0;
                if (map == null) {
                    iIntValue = 0;
                } else {
                    Object obj = map.get("container");
                    viewGroup = obj instanceof ViewGroup ? (ViewGroup) obj : null;
                    Object obj2 = map.get("w");
                    if (!(obj2 instanceof Integer)) {
                        iIntValue2 = 0;
                    } else {
                        iIntValue2 = ((Integer) obj2).intValue();
                    }
                    Object obj3 = map.get("h");
                    if (!(obj3 instanceof Integer)) {
                        i2 = iIntValue2;
                        iIntValue = 0;
                    } else {
                        iIntValue = ((Integer) obj3).intValue();
                        i2 = iIntValue2;
                    }
                }
                a(adInstanceInfoByJson, viewGroup, i2, iIntValue);
                return;
            }
            if (TextUtils.equals(strOptString, "destroyExpressView")) {
                if (map != null) {
                    Object obj4 = map.get("container");
                    if (obj4 instanceof ViewGroup) {
                        a((ViewGroup) obj4);
                        return;
                    }
                    return;
                }
                return;
            }
            if (TextUtils.equals(strOptString, "switchTheme")) {
                c(map);
                return;
            }
            if (TextUtils.equals(strOptString, "dislike_click")) {
                sendDislikeClickLog(jSONObject.optInt("dislike_type"), getAdInstanceInfoByJson(jSONObject));
                return;
            }
            if (TextUtils.equals(strOptString, "dislike_mapping")) {
                a(map);
                return;
            }
            if (TextUtils.equals(strOptString, "creative_call")) {
                a(jSONObject.optString("creative_type"), getAdInstanceInfoByJson(jSONObject));
                return;
            }
            if (TextUtils.equals(strOptString, "renderShakeView")) {
                b(jSONObject, map);
                return;
            }
            if (!TextUtils.equals(strOptString, "renderNativeView")) {
                if (TextUtils.equals(strOptString, "sendVideoThirdLog")) {
                    c(jSONObject);
                    return;
                } else {
                    if (TextUtils.equals(strOptString, "stopNativeView")) {
                        d(map);
                        return;
                    }
                    return;
                }
            }
            com.baidu.mobads.container.adrequest.j adInstanceInfoByJson2 = getAdInstanceInfoByJson(jSONObject);
            if (map != null && adInstanceInfoByJson2 != null) {
                String strOptString3 = jSONObject.optString("type", "component");
                if ("template".equals(strOptString3)) {
                    a(adInstanceInfoByJson2, jSONObject, map);
                } else if ("component".equals(strOptString3)) {
                    b(adInstanceInfoByJson2, jSONObject, map);
                }
            }
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (getAdInstanceInfoByJson(jSONObject) != null) {
                RemoteReflectInterface.cancelDlByPk(jSONObject.optString("pk", ""));
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(th);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        if (map != null && jSONObject != null) {
            try {
                com.baidu.mobads.container.adrequest.j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
                if (adInstanceInfoByJson != null) {
                    a((View) map.get("adView"), adInstanceInfoByJson);
                    a(adInstanceInfoByJson, jSONObject.optBoolean("isDownloadApp", false), map);
                }
            } catch (Throwable th) {
                this.mAdLogger.c(a, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.mobads.container.adrequest.j jVar) {
        com.baidu.mobads.container.adrequest.n.a(jVar, com.baidu.mobads.container.adrequest.n.G);
        if (com.baidu.mobads.container.h.a.a().l()) {
            b(view, jVar);
        } else {
            a(view, jVar, a(-1, jVar.getThirdImpressionTrackingUrls()), "0");
        }
    }

    private void b(View view, com.baidu.mobads.container.adrequest.j jVar) {
        if (view == null || jVar == null) {
            this.mAdLogger.b(a, "monitorImpression failed input null!");
            return;
        }
        String uniqueId = jVar.getUniqueId();
        if (a(uniqueId)) {
            this.mAdLogger.a(a, "monitorImpression impression has been send!");
            return;
        }
        Map<String, Object> mapA = a(-1, jVar.getThirdImpressionTrackingUrls());
        ci.b eVar = this.n.get(uniqueId);
        if (eVar == null) {
            eVar = new e(this, jVar, mapA);
            this.n.put(uniqueId, eVar);
        }
        ci.a().a(view, eVar);
    }

    private boolean a(int i2, String str) {
        Integer num;
        try {
            if (!TextUtils.isEmpty(str) && (num = this.l.get(str)) != null) {
                return (num.intValue() & i2) == i2;
            }
        } catch (Throwable th) {
            this.mAdLogger.c(a, th);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        try {
            Map<String, String> map = this.p.get(str);
            if (map != null) {
                return map.containsKey(str2);
            }
            return false;
        } catch (Throwable th) {
            this.mAdLogger.c(a, th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            Map<String, String> map = this.p.get(str);
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(str2, str3);
            this.p.put(str, map);
        } catch (Throwable th) {
            this.mAdLogger.c(a, th);
        }
    }

    private void b(int i2, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.l.get(str);
                if (num != null) {
                    this.l.put(str, Integer.valueOf(i2 | num.intValue()));
                } else {
                    this.l.put(str, Integer.valueOf(i2));
                }
            }
        } catch (Throwable th) {
            this.mAdLogger.c(a, th);
        }
    }

    public void a(String str, com.baidu.mobads.container.adrequest.j jVar) {
        if (TextUtils.equals("cta_get", str) && jVar != null) {
            String uniqueId = jVar.getUniqueId();
            if (!a(4, uniqueId)) {
                b(4, uniqueId);
            }
        }
    }

    @Override // com.baidu.mobads.container.k
    public void sendDislikeClickLog(int i2, com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar == null) {
            return;
        }
        String uniqueId = jVar.getUniqueId();
        if (!d(uniqueId)) {
            c(uniqueId);
            new com.baidu.mobads.container.util.an().a(i2, jVar.getDislikeTrackers());
        }
    }

    public void a(Map<String, Object> map) {
        if (map != null) {
            try {
                map.put("dislike_data", new com.baidu.mobads.container.util.an().a());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    protected void c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !a(2, str)) {
                b(2, str);
            }
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
        }
    }

    protected boolean d(String str) {
        try {
            return a(2, str);
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
            return false;
        }
    }

    protected boolean e(String str) {
        try {
            return a(128, str);
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
            return false;
        }
    }

    protected void f(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !a(128, str)) {
                b(128, str);
            }
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
        }
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, boolean z, Map<String, Object> map) {
        boolean z2;
        View view = (View) map.get("adView");
        List<?> list = (List) map.get("clickViews");
        List<?> list2 = (List) map.get("creativeViews");
        a(list, (p) null);
        a(list2, (p) null);
        int iOptInt = jVar.getOriginJsonObject().optInt("dl_dialog", -1);
        boolean z3 = false;
        if (iOptInt == 0) {
            z2 = false;
        } else {
            z2 = true;
            if (iOptInt != 1) {
                z3 = true;
                z2 = false;
            } else {
                z3 = true;
            }
        }
        p pVarA = a(jVar.getUniqueId(), z, z3);
        p pVarA2 = a(jVar.getUniqueId(), z, z2);
        a(list, pVarA);
        a(list2, pVarA2);
        setAdContainerView(jVar.getUniqueId(), view);
        f fVar = new f(this);
        a(list, fVar);
        a(list2, fVar);
    }

    private void a(List<?> list, p pVar) {
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj instanceof View) {
                    View view = (View) obj;
                    view.setOnClickListener(pVar);
                    view.setOnClickListener(pVar);
                }
            }
        }
    }

    private void a(List<?> list, View.OnTouchListener onTouchListener) {
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj instanceof View) {
                    ((View) obj).setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    private p a(String str, boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("isDownloadApp", z);
            jSONObject.put("use_dialog_frame", z2);
            return new p(this, jSONObject);
        } catch (Throwable th) {
            this.mAdLogger.a(a, th);
            return null;
        }
    }

    private void a(List<String> list, int i2, com.baidu.mobads.container.adrequest.j jVar) throws JSONException {
        int i3 = 0;
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && this.mAdContainerCxt != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(com.baidu.mobads.container.f.a.a, jVar.getAdId());
                        jSONObject.put("appsid", this.mAdContainerCxt.z());
                    } catch (JSONException e2) {
                        this.mAdLogger.a(e2);
                    }
                    String strA = com.baidu.mobads.container.f.a.a().a(this.mAdContainerCxt.t(), str, jSONObject);
                    int i4 = i3 + 1;
                    try {
                        sendUrlWithFailedLog(strA.replaceAll(com.baidu.mobads.container.h.j, String.valueOf(i2)), c.d.c, "", "", "", i3, jVar);
                        cc.a(this.mAppContext, strA, cc.a.THIRDSHOW);
                        i3 = i4;
                    } catch (Exception e3) {
                        e = e3;
                        i3 = i4;
                        this.mAdLogger.a("sendShow exception: ", e);
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean b(a aVar) {
        String uniqueId = aVar.a.getUniqueId();
        if (!a(uniqueId)) {
            sendImpressionLog(aVar.a);
            b(16, uniqueId);
            b(32, uniqueId);
            if (!TextUtils.isEmpty(aVar.a.getActRefinedText()) && a(4, uniqueId)) {
                by.a(getAdContainerContext(), (AbstractData) null, aVar.a, 2);
            }
            return true;
        }
        return false;
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, View view) {
        if (jVar != null) {
            if (this.n.remove(jVar.getUniqueId()) != null) {
                ci.a().b(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    by.a(str3.replaceAll("%25%25start_time%25%25", String.valueOf(str)).replaceAll("%25%25end_time%25%25", String.valueOf(str2)), null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.container.adrequest.j jVar, String str, String str2) {
        if (jVar != null) {
            try {
                JSONObject extraParams = jVar.getExtraParams();
                if (extraParams != null) {
                    extraParams.put(str, str2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.mobads.container.adrequest.j jVar, String str, String str2) {
        if (jVar != null) {
            try {
                JSONObject extraParams = jVar.getExtraParams();
                if (extraParams != null) {
                    return extraParams.optString(str, str2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, int i2) {
        a(aVar, i2, false);
    }

    private void a(a aVar, int i2, boolean z) {
        String strA;
        try {
            by.a aVarA = by.a.a(this.mAppContext);
            aVarA.a(i2).a(aVar.a).a("showsended", a(aVar.a.getUniqueId()) + "").a("showstate", "" + aVar.d).a("time", "" + System.currentTimeMillis()).a(com.baidu.mobads.container.adrequest.n.D, aVar.i);
            aVarA.a(com.baidu.mobads.container.components.command.j.C, bk.a(aVar.a));
            aVarA.a("adSrc", this.mAdSource);
            if (i2 == 364) {
                aVarA.b(aVar.a);
            } else if (i2 == 362) {
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(aVar.a.getUniqueId(), com.baidu.mobads.container.components.h.b.a.m, com.baidu.mobads.container.components.h.c.c.a(aVar.c));
                aVarA.a(aVar.a, this.mAdContainerCxt.k());
            }
            if (this.mAdContainerCxt instanceof com.baidu.mobads.container.adrequest.o) {
                aVarA.b(((com.baidu.mobads.container.adrequest.o) this.mAdContainerCxt).c);
            } else {
                aVarA.b(this.mAppContext);
            }
            if (z) {
                aVarA.a("shake", 1L);
            }
            aVarA.a("trysum", "" + aVar.f);
            if (aVar.b != null) {
                String str = aVar.b.get("impressionFrom");
                if (!TextUtils.isEmpty(str)) {
                    aVarA.a("impressionFrom", str);
                }
            }
            if (aVar.c.length() > 150) {
                aVar.c = aVar.c.substring(0, 150);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - aVar.j;
            long jCurrentTimeMillis2 = System.currentTimeMillis() - this.mAdContainerCxt.r().a();
            String clickThroughUrl = aVar.a.getClickThroughUrl();
            if (aVar.a.getAntiTag() == 0 && (strA = a(this.mAppContext, clickThroughUrl)) != null) {
                clickThroughUrl = strA;
            }
            aVarA.a("showrecord", aVar.c).a("timeprd", "" + jCurrentTimeMillis).a("expire", "" + jCurrentTimeMillis2).a("forecurl", h(clickThroughUrl)).a("isusenewshowlog", "true").b(this.mAdContainerCxt.l()).c(this.mAdContainerCxt.k()).a(this.mAdContainerCxt.z()).a("uniqueid", aVar.a.getUniqueId()).a("bidl", c(aVar.a)).a("ebidl", d(aVar.a));
            sendUrlWithFailedLog(aVarA.d(), c.d.e, "" + i2, "", "", 0, aVar.a);
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(com.baidu.mobads.container.adrequest.j jVar) {
        JSONObject originJsonObject;
        return (jVar == null || (originJsonObject = jVar.getOriginJsonObject()) == null) ? "" : originJsonObject.optString(com.baidu.mobads.container.components.command.j.G, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(com.baidu.mobads.container.adrequest.j jVar) {
        JSONObject originJsonObject;
        return (jVar == null || (originJsonObject = jVar.getOriginJsonObject()) == null) ? "" : originJsonObject.optString(com.baidu.mobads.container.components.command.j.H, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(String str) {
        try {
            if (str.length() > 70) {
                return URLEncoder.encode(str.substring(0, 70), "UTF-8");
            }
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
            return "";
        }
    }

    public String a(Context context, String str) {
        try {
            String strC = IDManager.getInstance().c(context);
            if (str != null && !str.equals("")) {
                return String.format(com.baidu.mobads.container.v.b.a.m, URLEncoder.encode(str, "UTF-8"), u.a(strC), Double.valueOf(com.baidu.mobads.container.h.a));
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public Map<String, Object> a(int i2, List<String> list) {
        HashMap map = new HashMap();
        map.put("progress", Integer.valueOf(i2));
        map.put("trackerUrl", list);
        return map;
    }

    private void a(View view, com.baidu.mobads.container.adrequest.j jVar, int i2) {
        if (this.mAdContainerCxt == null) {
            return;
        }
        ab.a(this.mActivity, new g(this, jVar, view, i2));
    }

    @Override // com.baidu.mobads.container.k
    public void handlePause(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 1, jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handleResume(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 0, jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onPermissionShow(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 1, jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onPermissionClose(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 0, jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onPrivacyClick(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPrivacyClick", jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onPrivacyLpClose(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.F, jVar.getUniqueId()));
        }
    }

    @Override // com.baidu.mobads.container.k
    public void beforeSendLog(com.baidu.mobads.container.adrequest.j jVar, View view) throws JSONException {
        beforeSendLog(jVar, view, false);
    }

    @Override // com.baidu.mobads.container.k
    public void beforeSendLog(com.baidu.mobads.container.adrequest.j jVar, View view, boolean z) throws JSONException {
        a(jVar, z);
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar, boolean z) throws JSONException {
        if (jVar == null) {
            return;
        }
        a aVarB = b(jVar);
        if (b(aVarB).booleanValue()) {
            a(getAdContainerView(jVar.getUniqueId()), a(-1, jVar.getThirdImpressionTrackingUrls()), aVarB.a);
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(aVarB.a.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
            recordAdShowStatus(jVar, getAdContainerView(jVar.getUniqueId()));
            if (aVarB.b != null) {
                aVarB.b.put("impressionFrom", "2");
            }
            aVarB.c = "00";
            aVarB.d = 0;
            a(aVarB, 362, z);
        }
        a(aVarB, 364, z);
    }

    @Override // com.baidu.mobads.container.k
    public void onAdClick(com.baidu.mobads.container.adrequest.j jVar, View view) {
        if (jVar == null) {
            return;
        }
        checkAPO(bk.D);
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        if (this.q == null) {
            return;
        }
        try {
            Iterator<Map.Entry<String, a>> it = this.q.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    value.a();
                }
            }
        } catch (Exception e2) {
            this.mAdLogger.a(e2);
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            List<String> listC = c(getAdInstanceInfoByJson(jSONObject), jSONObject.optString("trackType"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trackInfo");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            ce.b(jSONObjectOptJSONObject.optInt("curTimeSec", 0), jSONObjectOptJSONObject.optInt("startTimeSec", 0), listC, jSONObjectOptJSONObject.optBoolean("autoPlay", false) ? 0 : 1, jSONObjectOptJSONObject.optInt("reasonValue", 7));
        } catch (Throwable th) {
            this.mAdLogger.d(th);
        }
    }

    private List<String> c(com.baidu.mobads.container.adrequest.j jVar, String str) {
        JSONArray jSONArrayOptJSONArray;
        if (jVar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObjectOptJSONObject = jVar.getOriginJsonObject().optJSONObject("monitors");
                    ArrayList arrayList = new ArrayList();
                    if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(str)) != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (Throwable th) {
                this.mAdLogger.d(th);
                return null;
            }
        }
        return null;
    }
}
