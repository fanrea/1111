package com.bytedance.msdk.core.tt;

import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.component.utils.mq;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    private static volatile hc c;
    protected final Map<String, String> b;

    private hc() {
        super("label_v_v_s_3");
        this.b = new ConcurrentHashMap();
        hc();
    }

    public static hc c() {
        if (c == null) {
            synchronized (hc.class) {
                if (c == null) {
                    c = new hc();
                }
            }
        }
        return c;
    }

    protected void d(String str, int i, double d) {
        if (!com.bytedance.msdk.core.hc.hc().ru() || TextUtils.isEmpty(str)) {
            return;
        }
        d(3, str, i, d);
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.msdk.d.u.b.hc("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.b.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected Map<String, String> d() {
        return this.b;
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected void d(String str, int i, String str2) {
        if (i == 3) {
            this.b.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected boolean hc(String str, JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", d(obj != null ? (com.bytedance.msdk.core.tc.b) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hc.hc().yn()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(SplashAd.KEY_BIDFAIL_ECPM, map.get(SplashAd.KEY_BIDFAIL_ECPM));
            jSONObject3.putOpt(a.k, String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException e) {
            mq.d(e);
            return false;
        }
    }

    protected void b(String str, JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        if (!com.bytedance.msdk.core.hc.hc().ru() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected JSONObject d(com.bytedance.msdk.core.tc.b bVar) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", bVar != null ? bVar.d() : "-1");
            jSONObject.putOpt("label_id", bVar != null ? Integer.valueOf(bVar.b()) : "-1");
            jSONObject.putOpt("label_version", bVar != null ? bVar.c() : "-1");
            return jSONObject;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }
}
