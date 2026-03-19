package com.component.a.h;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.component.a.f.e;
import com.component.a.i.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements n.a {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    b(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.a = jSONObject;
    }

    @Override // com.component.a.i.n.a
    public void a(String str, e eVar) throws JSONException {
        if ("bookmark_background_card".equals(str)) {
            JSONObject jSONObjectA = eVar.h().a();
            if (jSONObjectA != null) {
                jSONObjectA.put("radius", this.b.b);
                jSONObjectA.put("radius_rate", this.b.c);
                if (!TextUtils.isEmpty(this.b.d)) {
                    jSONObjectA.put(TypedValues.Custom.S_COLOR, this.b.d);
                }
            }
            this.b.a(eVar, 0.85f, 0.85f);
            return;
        }
        if ("bookmark_foreground_card".equals(str)) {
            this.b.a(eVar, 0.85f, 0.85f);
            return;
        }
        if ("tack_icon".equals(str)) {
            eVar.f().put("src", this.b.e);
            this.b.a(eVar, 0.17f, 0.13f);
            return;
        }
        if ("content_view".equals(str)) {
            JSONArray jSONArray = (JSONArray) this.a.remove("child_view");
            JSONObject jSONObject = new JSONObject(this.a.toString());
            jSONObject.remove("w");
            jSONObject.remove("h");
            jSONObject.remove("aspect_rate");
            jSONObject.remove("gravity");
            jSONObject.put("w_rate", 1);
            jSONObject.put("h_rate", 1);
            n.b(eVar.f(), jSONObject);
            eVar.f().put("child_view", jSONArray);
        }
    }
}
