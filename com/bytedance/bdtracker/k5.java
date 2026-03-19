package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k5 {
    public final String a;
    public final String b;
    public final Boolean c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;

    public k5(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
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
        j5.a(map, "id", this.a);
        j5.a(map, com.baidu.mobads.container.adrequest.g.o, this.b);
        j5.a(map, "is_track_limited", String.valueOf(this.c));
        j5.a(map, "take_ms", String.valueOf(this.d));
        j5.a(map, "time", String.valueOf(this.e));
        j5.a(map, "query_times", String.valueOf(this.f));
        j5.a(map, "hw_id_version_code", String.valueOf(this.g));
        return map;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        j5.a(jSONObject, "id", this.a);
        j5.a(jSONObject, com.baidu.mobads.container.adrequest.g.o, this.b);
        j5.a(jSONObject, "is_track_limited", this.c);
        j5.a(jSONObject, "take_ms", this.d);
        j5.a(jSONObject, "time", this.e);
        j5.a(jSONObject, "query_times", this.f);
        j5.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
