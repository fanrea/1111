package com.bytedance.msdk.core.b;

import android.text.TextUtils;
import com.baidu.mobads.container.components.h.b.e;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private String an;
    private int b;
    private String c;
    public List<Integer> d;
    private int h;
    private JSONObject hc;
    private String u;

    public hc(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("behavior_state");
        if (jSONArrayOptJSONArray != null) {
            this.d = new LinkedList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    this.d.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rule_excs");
        if (jSONObjectOptJSONObject != null) {
            this.h = jSONObjectOptJSONObject.optInt("condition");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("perform");
            this.hc = jSONObjectOptJSONObject2;
            if (jSONObjectOptJSONObject2 != null) {
                this.b = jSONObjectOptJSONObject2.optInt("condition");
                this.c = this.hc.optString(e.f);
                this.u = this.hc.optString("rule_id");
                this.an = this.hc.optString("rule_timestamp");
            }
        }
    }

    public int d() {
        return this.b;
    }

    public int hc() {
        return this.h;
    }

    public String b() {
        return this.u;
    }

    public String c() {
        return this.an;
    }

    public JSONObject u() {
        return this.hc;
    }

    public boolean d(int i) {
        List<Integer> list = this.d;
        if (list != null) {
            return list.contains(Integer.valueOf(i));
        }
        return false;
    }

    public String an() {
        return this.c;
    }

    public boolean h() {
        return "1".equals(this.c) || "2".equals(this.c) || "3".equals(this.c) || "4".equals(this.c) || "5".equals(this.c);
    }

    public boolean d(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.hc.optJSONObject("prime_rits");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (jSONObjectOptJSONObject.optJSONObject("ssr") == null && jSONObjectOptJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double d(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.hc) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }

    public double hc(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.hc) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }
}
