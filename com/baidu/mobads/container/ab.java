package com.baidu.mobads.container;

import android.text.TextUtils;
import com.component.a.f.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab extends com.baidu.mobads.container.d.a {
    final /* synthetic */ k a;

    ab(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            if (this.a.mAdCloudConfigs.a("bubble_enable", 0) == 1) {
                ArrayList arrayList = new ArrayList(this.a.q);
                JSONArray jSONArrayB = this.a.mAdCloudConfigs.b("bubble_json");
                if (jSONArrayB != null) {
                    for (int i = 0; i < jSONArrayB.length() && i < 5; i++) {
                        JSONObject jSONObject = new JSONObject((String) this.a.q.get(i));
                        JSONArray jSONArray = jSONObject.getJSONArray("lottie");
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        jSONObject2.put("json", jSONArrayB.get(i));
                        jSONArray.put(0, jSONObject2);
                        jSONObject.put("lottie", jSONArray);
                        this.a.q.set(i, jSONObject.toString());
                    }
                }
                JSONArray jSONArrayB2 = this.a.mAdCloudConfigs.b("bubble_images");
                if (jSONArrayB2 != null && jSONArrayB2.length() > 0) {
                    this.a.a(jSONArrayB2, (ArrayList<String>) this.a.q, "image_1");
                }
                for (int i2 = 0; i2 < this.a.q.size(); i2++) {
                    for (e.h hVar : e.h.a(new JSONObject((String) this.a.q.get(i2)).optJSONArray("lottie"))) {
                        if (TextUtils.isEmpty(hVar.b(""))) {
                            com.component.lottie.k.a(this.a.mAppContext, hVar, new ac(this, i2, arrayList));
                        }
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
