package com.component.a.h;

import com.baidu.mobads.container.l.g;
import com.component.a.f.e;
import com.component.a.i.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements c {
    private static final float g = 0.5625f;
    private static final float h = 0.85f;
    private final JSONObject a;
    private String d;
    private JSONArray b = null;
    private float c = -2.0f;
    private String e = "";
    private float f = g;

    public a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.component.a.h.c
    public String a() {
        return "bookmark_9_16";
    }

    @Override // com.component.a.h.c
    public JSONObject b() {
        return this.a;
    }

    @Override // com.component.a.h.c
    public void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("background");
            if (jSONObjectOptJSONObject != null) {
                this.b = jSONObjectOptJSONObject.optJSONArray("radius");
                this.c = (float) jSONObjectOptJSONObject.optDouble("radius_rate", -2.0d);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.baidu.mobads.container.adrequest.a.a);
            if (jSONObjectOptJSONObject2 != null) {
                this.e = jSONObjectOptJSONObject2.optString("tack_url", "");
                this.d = jSONObjectOptJSONObject2.optString("bg_card_color", "");
                this.a.put("click", jSONObjectOptJSONObject2.optString("click", "ad_click"));
            }
            a(jSONObject, this.a, "w");
            a(jSONObject, this.a, "h");
            a(jSONObject, this.a, "w_rate");
            a(jSONObject, this.a, "h_rate");
            a(jSONObject, this.a, "aspect_rate");
            a(jSONObject, this.a, "gravity");
            this.f = (float) this.a.optDouble("aspect_rate", -2.0d);
        } catch (Throwable th) {
            g.b(th);
        }
    }

    @Override // com.component.a.h.c
    public void b(JSONObject jSONObject) {
        try {
            if (this.a != null) {
                JSONObject jSONObject2 = new JSONObject(this.a.toString());
                n.a(jSONObject2, new b(this, jSONObject));
                n.b(jSONObject, jSONObject2);
            }
        } catch (Throwable th) {
            g.b(th);
        }
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, jSONObject.opt(str));
            }
        } catch (Throwable th) {
            g.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, float f, float f2) {
        try {
            JSONObject jSONObjectF = eVar.f();
            if (jSONObjectF != null) {
                if (this.f > g) {
                    jSONObjectF.put("h_rate", f2);
                    jSONObjectF.remove("w_rate");
                } else {
                    jSONObjectF.put("w_rate", f);
                    jSONObjectF.remove("h_rate");
                }
            }
        } catch (Throwable th) {
            g.b(th);
        }
    }
}
