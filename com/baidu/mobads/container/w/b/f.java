package com.baidu.mobads.container.w.b;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    private com.baidu.mobads.container.w.g.a a;
    private JSONObject b;
    private com.baidu.mobads.container.w.h.g c;
    private String d;

    public com.baidu.mobads.container.w.g.a a() {
        return this.a;
    }

    public void a(com.baidu.mobads.container.w.g.a aVar) {
        this.a = aVar;
    }

    public JSONObject b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public String toString() {
        String string;
        if (this.b == null) {
            string = "";
        } else {
            string = this.b.toString();
        }
        return String.format("tag[%s];content[%s]", this.a.c(), string);
    }

    public String c() {
        return this.d;
    }

    public void a(String str) {
        if (this.a != null) {
            this.d = this.a.c() + Config.replace + str;
        } else {
            this.d = str;
        }
    }

    public com.baidu.mobads.container.w.h.g d() {
        return this.c;
    }

    public void a(com.baidu.mobads.container.w.h.g gVar) {
        this.c = gVar;
    }
}
