package com.baidu.mobads.container.v.a;

import android.app.KeyguardManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.bridge.b;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.az;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.f;
import com.baidu.mobads.container.util.f.z;
import com.baidu.mobads.container.v.d;
import com.sigmob.sdk.base.models.ClickCommon;
import com.ss.texturerender.TextureRenderKeys;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends d {
    private static final String e = "https://cpu.baidu.com/";
    private static final String f = "dvlst";
    private String g;

    public a(t tVar) {
        super(tVar);
        a(false);
        b(true);
        a(false);
        e();
    }

    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = "XCpuMouldAdContainer";
    }

    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        if (this.mAdState != 2) {
            displayVersion4DebugMode();
        }
        super.doStartOnUIThread();
    }

    @Override // com.baidu.mobads.container.v.d
    public void b() {
        this.c = new b(this.mAppContext, this.mWebView, this.mAdContainerCxt.q(), this.mAdContainerCxt.k(), this.mAdContainerCxt.z());
        String str = "[" + com.baidu.mobads.container.util.b.a().b(this.mAppContext) + "]";
        Uri.Builder builderBuildUpon = Uri.parse(this.mAdContainerCxt.r().b().getHtmlSnippet()).buildUpon();
        builderBuildUpon.appendQueryParameter(f, str);
        try {
            String str2 = "1";
            builderBuildUpon.appendQueryParameter("lock_screen", ((KeyguardManager) this.mAppContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode() ? "1" : "0");
            builderBuildUpon.appendQueryParameter(g.aq, DeviceUtils.getInstance().r(this.mAppContext));
            if (!az.a(this.mAppContext)) {
                str2 = "0";
            }
            builderBuildUpon.appendQueryParameter(g.ai, str2);
            builderBuildUpon.appendQueryParameter(com.baidu.mobads.container.config.a.B, com.baidu.mobads.container.config.a.a().m());
            builderBuildUpon.appendQueryParameter("oaid", z.a(this.mAppContext));
            builderBuildUpon.appendQueryParameter("isAllowOaid", String.valueOf(com.baidu.mobads.container.h.a.a().i()));
            SPUtils sPUtils = new SPUtils(this.mAppContext, "cpu_sp_file");
            if (sPUtils.b("fisrtCCTime", -1L) == -1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                sPUtils.a("fisrtCCTime", jCurrentTimeMillis);
                builderBuildUpon.appendQueryParameter("fisrtCCTime", String.valueOf(jCurrentTimeMillis));
            }
            builderBuildUpon.appendQueryParameter(g.J, f.a().a(this.mAppContext));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ((ax) getAdView()).loadUrl(builderBuildUpon.build().toString());
    }

    @Override // com.baidu.mobads.container.v.d
    public Boolean a(String str) {
        try {
            Uri uri = Uri.parse(str);
            if (uri != null && uri.getHost().equals("cpu.baidu.com") && uri.getQueryParameter("chk") != null && uri.getQueryParameter("chk").equals("1")) {
                return true;
            }
        } catch (Exception e2) {
        }
        return false;
    }

    private void e() {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            a(cookieManager, "oaid", z.a(this.mAppContext));
        } catch (Throwable th) {
        }
    }

    private void a(CookieManager cookieManager, String str, String str2) {
        if (!a(cookieManager, str)) {
            a(cookieManager, str, (Object) str2);
        }
    }

    private boolean a(CookieManager cookieManager, String str) {
        String cookie = cookieManager.getCookie(e);
        if (TextUtils.isEmpty(cookie) || TextUtils.isEmpty(str)) {
            return false;
        }
        return cookie.contains(new StringBuilder().append("; ").append(str).append("=").toString()) || cookie.contains(new StringBuilder().append(i.b).append(str).append("=").toString()) || cookie.startsWith(new StringBuilder().append(str).append("=").toString());
    }

    private void a(CookieManager cookieManager, String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(i.b);
        try {
            cookieManager.setCookie(e, stringBuffer.toString());
        } catch (Throwable th) {
        }
    }

    private JSONObject b(String str) {
        try {
            String strA = b.a(str, "params");
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(strA);
            }
            return null;
        } catch (Throwable th) {
            bq.a().b(d.a, th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.container.v.d
    public void a(Uri uri) {
        String str;
        HashMap map;
        Boolean bool;
        JSONObject jSONObjectB;
        String str2;
        int iOptInt;
        int i;
        HashMap map2 = new HashMap();
        String string = uri.toString();
        if (!string.startsWith(b.j) || (jSONObjectB = b(string)) == null) {
            str = "channelId";
            map = map2;
            bool = false;
        } else {
            String strOptString = jSONObjectB.optString("type");
            String strOptString2 = jSONObjectB.optString("act");
            int iOptInt2 = jSONObjectB.optInt("webContentH");
            bool = false;
            int iOptInt3 = jSONObjectB.optInt("webScroolY");
            map = map2;
            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("args");
            if (jSONObjectOptJSONObject == null) {
                str2 = "";
                iOptInt = 0;
                i = 0;
            } else {
                String strOptString3 = jSONObjectOptJSONObject.optString("contentId");
                int iOptInt4 = jSONObjectOptJSONObject.optInt("v_duration");
                iOptInt = jSONObjectOptJSONObject.optInt("v_playprogress");
                str2 = strOptString3;
                i = iOptInt4;
            }
            str = "channelId";
            HashMap map3 = new HashMap();
            map3.put("type", strOptString);
            map3.put("act", strOptString2);
            map3.put("contentId", str2);
            map3.put("vduration", Integer.valueOf(i));
            map3.put("vprogress", Integer.valueOf(iOptInt));
            map3.put("webContentH", Integer.valueOf(iOptInt2));
            map3.put("webScroolY", Integer.valueOf(iOptInt3));
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.U, (HashMap<String, Object>) map3));
        }
        if ("cactus".equals(uri.getScheme())) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("param"));
                jSONObject.optString("type");
                String strOptString4 = jSONObject.optString("novelrouter");
                int iOptInt5 = jSONObject.optInt("intervalpages");
                int iOptInt6 = jSONObject.optInt("bannerseconds");
                String strA = IDManager.getInstance().a(this.mAppContext);
                int iOptInt7 = jSONObject.optInt("entry");
                String str3 = str;
                int iOptInt8 = jSONObject.optInt(str3, 1022);
                String strOptString5 = jSONObject.optString("contentId");
                this.g = jSONObject.optString(TextureRenderKeys.KEY_IS_CALLBACK);
                Integer numValueOf = Integer.valueOf(iOptInt5);
                HashMap map4 = map;
                map4.put("intervalpages", numValueOf);
                map4.put("bannerseconds", Integer.valueOf(iOptInt6));
                map4.put("novelrouter", strOptString4);
                map4.put("TryGetCuidForNovel", strA);
                map4.put("entry", Integer.valueOf(iOptInt7));
                map4.put(str3, Integer.valueOf(iOptInt8));
                map4.put("contentId", strOptString5);
                this.mAdContainerCxt.s().dispatchEvent(new cm("feOpenFbReader", (HashMap<String, Object>) map4));
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        HashMap map5 = map;
        String queryParameter = uri.getQueryParameter(ClickCommon.CLICK_AREA_MATERIAL);
        String queryParameter2 = uri.getQueryParameter("act");
        String queryParameter3 = uri.getQueryParameter("num");
        if (!"ad".equals(queryParameter) || !"userclick".equals(queryParameter2)) {
            if ("ad".equals(queryParameter) && "exposed".equals(queryParameter2)) {
                map5.put("isImpressionFeAd", true);
                map5.put("nums", queryParameter3);
                this.mAdContainerCxt.s().dispatchEvent(new cm("AdImpression", (HashMap<String, Object>) map5));
                return;
            } else {
                if (!"content".equals(queryParameter) || !"userclick".equals(queryParameter2)) {
                    Boolean bool2 = bool;
                    if ("content".equals(queryParameter) && "exposed".equals(queryParameter2)) {
                        map5.put("isImpressionFeAd", bool2);
                        map5.put("nums", queryParameter3);
                        this.mAdContainerCxt.s().dispatchEvent(new cm("AdImpression", (HashMap<String, Object>) map5));
                        return;
                    }
                    return;
                }
                map5.put("isClickFeAd", bool);
                this.mAdContainerCxt.s().dispatchEvent(new cm("AdUserClick", (HashMap<String, Object>) map5));
                return;
            }
        }
        map5.put("isClickFeAd", true);
        this.mAdContainerCxt.s().dispatchEvent(new cm("AdUserClick", (HashMap<String, Object>) map5));
    }

    @Override // com.baidu.mobads.container.k
    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        if (this.mWebView != null && jSONObject != null && !TextUtils.isEmpty(this.g)) {
            this.mWebView.loadUrl("javascript:" + this.g + "(\"" + jSONObject.toString().replace("\"", "\\\"") + "\")");
        }
    }
}
