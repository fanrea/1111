package com.bytedance.bdtracker;

import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b8\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\b\u0010q\u001a\u00020pH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001c\u0010=\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001c\u0010@\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001c\u0010C\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001c\u0010F\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001c\u0010I\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001c\u0010U\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001c\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\u001c\u0010d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR\u001c\u0010g\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR\u001c\u0010j\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\b¨\u0006s"}, d2 = {"Lcom/bytedance/applog/alink/model/AttributionData;", "Lcom/bytedance/applog/alink/model/BaseData;", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "accountName", "getAccountName", "setAccountName", "activationTimestamp", "getActivationTimestamp", "setActivationTimestamp", "activationType", "Lcom/bytedance/applog/alink/model/AttributionData$ActivationType;", "getActivationType", "()Lcom/bytedance/applog/alink/model/AttributionData$ActivationType;", "setActivationType", "(Lcom/bytedance/applog/alink/model/AttributionData$ActivationType;)V", "adId", "getAdId", "setAdId", "adName", "getAdName", "setAdName", "campaignId", "getCampaignId", "setCampaignId", "campaignName", "getCampaignName", "setCampaignName", "creativeId", "getCreativeId", "setCreativeId", "creativeName", "getCreativeName", "setCreativeName", "deeplinkValue", "getDeeplinkValue", "setDeeplinkValue", "isFirstLaunch", "", "()Z", "setFirstLaunch", "(Z)V", "isRetargeting", "setRetargeting", "name", "getName", "setName", "reengagementWindow", "", "getReengagementWindow", "()I", "setReengagementWindow", "(I)V", "touchTimestamp", "getTouchTimestamp", "setTouchTimestamp", "touchType", "getTouchType", "setTouchType", "trAdmaster", "getTrAdmaster", "setTrAdmaster", "trDp", "getTrDp", "setTrDp", "trInstallType", "getTrInstallType", "setTrInstallType", "trParam1", "getTrParam1", "setTrParam1", "trParam2", "getTrParam2", "setTrParam2", "trParam3", "getTrParam3", "setTrParam3", "trParam4", "getTrParam4", "setTrParam4", "trShareuser", "getTrShareuser", "setTrShareuser", "trSiteId", "getTrSiteId", "setTrSiteId", "trSiteName", "getTrSiteName", "setTrSiteName", "utmCampaign", "getUtmCampaign", "setUtmCampaign", "utmContent", "getUtmContent", "setUtmContent", "utmMedium", "getUtmMedium", "setUtmMedium", "utmSource", "getUtmSource", "setUtmSource", "utmTerm", "getUtmTerm", "setUtmTerm", "initWithJson", "", "json", "Lorg/json/JSONObject;", "toJson", "ActivationType", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class n extends p {
    public String A;
    public String B;
    public String C;
    public String D;
    public a E = a.PROMOTION;
    public String F;
    public boolean G;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public enum a {
        PROMOTION,
        ORGANIC
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    @Override // com.bytedance.bdtracker.p
    public JSONObject a() throws JSONException, TypeCastException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.b);
        jSONObject.put("utm_campaign", this.c);
        jSONObject.put("utm_source", this.d);
        jSONObject.put("utm_medium", this.e);
        jSONObject.put("utm_content", this.f);
        jSONObject.put("utm_term", this.g);
        jSONObject.put("tr_shareuser", this.h);
        jSONObject.put("tr_admaster", this.i);
        jSONObject.put("tr_param1", this.j);
        jSONObject.put("tr_param2", this.k);
        jSONObject.put("tr_param3", this.l);
        jSONObject.put("tr_param4", this.m);
        jSONObject.put("is_retargeting", this.n);
        jSONObject.put("reengagement_window", this.o);
        jSONObject.put("tr_dp", this.p);
        jSONObject.put("deeplink_value", this.q);
        jSONObject.put("tr_site_id", this.r);
        jSONObject.put("tr_site_name", this.s);
        jSONObject.put("account_id", this.t);
        jSONObject.put("account_name", this.u);
        jSONObject.put("campaign_id", this.v);
        jSONObject.put("campaign_name", this.w);
        jSONObject.put(IDJXAd.AD_CODE_ID, this.x);
        jSONObject.put("ad_name", this.y);
        jSONObject.put("creative_id", this.z);
        jSONObject.put("creative_name", this.A);
        jSONObject.put("tr_install_type", this.B);
        jSONObject.put("touch_type", this.C);
        jSONObject.put("touch_timestamp", this.D);
        String strName = this.E.name();
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        if (strName == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        jSONObject.put("activation_type", lowerCase);
        jSONObject.put("activation_timestamp", this.F);
        jSONObject.put("is_first_launch", this.G);
        return jSONObject;
    }

    @Override // com.bytedance.bdtracker.p
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString("name", null);
            this.c = jSONObject.optString("utm_campaign", null);
            this.d = jSONObject.optString("utm_source", null);
            this.e = jSONObject.optString("utm_medium", null);
            this.f = jSONObject.optString("utm_content", null);
            this.g = jSONObject.optString("utm_term", null);
            this.h = jSONObject.optString("tr_shareuser", null);
            this.i = jSONObject.optString("tr_admaster", null);
            this.j = jSONObject.optString("tr_param1", null);
            this.k = jSONObject.optString("tr_param2", null);
            this.l = jSONObject.optString("tr_param3", null);
            this.m = jSONObject.optString("tr_param4", null);
            this.n = jSONObject.optBoolean("is_retargeting");
            this.o = jSONObject.optInt("reengagement_window");
            this.p = jSONObject.optString("tr_dp", null);
            this.q = jSONObject.optString("deeplink_value", null);
            this.r = jSONObject.optString("tr_site_id", null);
            this.s = jSONObject.optString("tr_site_name", null);
            this.t = jSONObject.optString("account_id", null);
            this.u = jSONObject.optString("account_name", null);
            this.v = jSONObject.optString("campaign_id", null);
            this.w = jSONObject.optString("campaign_name", null);
            this.x = jSONObject.optString(IDJXAd.AD_CODE_ID, null);
            this.y = jSONObject.optString("ad_name", null);
            this.z = jSONObject.optString("creative_id", null);
            this.A = jSONObject.optString("creative_name", null);
            this.B = jSONObject.optString("tr_install_type", null);
            this.C = jSONObject.optString("touch_type", null);
            this.D = jSONObject.optString("touch_timestamp", null);
            this.E = Intrinsics.areEqual(jSONObject.optString("activation_type"), "promotion") ? a.PROMOTION : a.ORGANIC;
            this.F = jSONObject.optString("activation_timestamp", null);
            this.G = jSONObject.optBoolean("is_first_launch");
        }
    }
}
