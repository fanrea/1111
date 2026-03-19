package com.bytedance.embedapplog;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class jm {
    final Integer an;
    final Boolean b;
    final Long c;
    final String d;
    final Long h;
    final String hc;
    final Long u;

    jm(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.d = str;
        this.hc = str2;
        this.b = bool;
        this.c = l;
        this.u = l2;
        this.an = num;
        this.h = l3;
    }

    public String toString() {
        return hc().toString();
    }

    Map<String, String> d() {
        HashMap map = new HashMap();
        ho.d(map, "id", this.d);
        ho.d(map, g.o, this.hc);
        ho.d(map, "is_track_limited", String.valueOf(this.b));
        ho.d(map, "take_ms", String.valueOf(this.c));
        ho.d(map, "time", String.valueOf(this.u));
        ho.d(map, "query_times", String.valueOf(this.an));
        ho.d(map, "hw_id_version_code", String.valueOf(this.h));
        return map;
    }

    JSONObject hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ho.d(jSONObject, "id", this.d);
        ho.d(jSONObject, g.o, this.hc);
        ho.d(jSONObject, "is_track_limited", this.b);
        ho.d(jSONObject, "take_ms", this.c);
        ho.d(jSONObject, "time", this.u);
        ho.d(jSONObject, "query_times", this.an);
        ho.d(jSONObject, "hw_id_version_code", this.h);
        return jSONObject;
    }

    static jm d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new jm(jSONObject.optString("id", null), jSONObject.optString(g.o, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            um.d(e);
            return null;
        }
    }
}
