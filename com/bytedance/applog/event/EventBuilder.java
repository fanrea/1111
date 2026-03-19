package com.bytedance.applog.event;

import com.bytedance.bdtracker.a;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EventBuilder {
    public final d a;
    public String b;
    public String c;
    public JSONObject d;

    public EventBuilder(d dVar) {
        this.a = dVar;
    }

    public EventBuilder addParam(String str, Object obj) throws JSONException {
        if (this.d == null) {
            this.d = new JSONObject();
        }
        try {
            this.d.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public a4 build() {
        String str = this.a.m;
        String str2 = this.b;
        JSONObject jSONObject = this.d;
        a4 a4Var = new a4(str, str2, false, jSONObject != null ? jSONObject.toString() : null, 0);
        a4Var.j = this.c;
        this.a.D.debug(4, "EventBuilder build: {}", a4Var);
        return a4Var;
    }

    public EventBuilder setAbSdkVersion(String str) {
        this.c = str;
        return this;
    }

    public EventBuilder setEvent(String str) {
        this.b = str;
        return this;
    }

    public void track() {
        a4 a4VarBuild = build();
        this.a.D.debug(4, a.a("EventBuilder track: ").append(this.b).toString(), new Object[0]);
        this.a.receive(a4VarBuild);
    }
}
