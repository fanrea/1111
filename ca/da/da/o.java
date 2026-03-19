package ca.da.da;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OaidModel.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class o {
    public final String a;
    public final String b;
    public final Boolean c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;

    public o(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.a = str;
        this.b = str2;
        this.c = bool;
        this.d = l;
        this.e = l2;
        this.f = num;
        this.g = l3;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        m.a(map, "id", this.a);
        m.a(map, com.baidu.mobads.container.adrequest.g.o, this.b);
        m.a(map, "is_track_limited", String.valueOf(this.c));
        m.a(map, "take_ms", String.valueOf(this.d));
        m.a(map, "time", String.valueOf(this.e));
        m.a(map, "query_times", String.valueOf(this.f));
        m.a(map, "hw_id_version_code", String.valueOf(this.g));
        return map;
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "id", this.a);
        m.a(jSONObject, com.baidu.mobads.container.adrequest.g.o, this.b);
        m.a(jSONObject, "is_track_limited", this.c);
        m.a(jSONObject, "take_ms", this.d);
        m.a(jSONObject, "time", this.e);
        m.a(jSONObject, "query_times", this.f);
        m.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
