package com.kwad.components.ct.a.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b<List<com.kwad.sdk.core.response.model.a>> {
    public a() {
        super("posContentInfoList", new ArrayList());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("posContentInfoList")) != null && jSONArrayOptJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.kwad.sdk.core.response.model.a aVar = new com.kwad.sdk.core.response.model.a();
                    aVar.parseJson(jSONObjectOptJSONObject);
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                setValue(arrayList);
                return;
            }
        }
        setValue(Zh());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        List<com.kwad.sdk.core.response.model.a> value = getValue();
        if (ap.aM(value)) {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.kwad.sdk.core.response.model.a> it = value.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            editor.putString("posContentInfoList", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("posContentInfoList", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        com.kwad.sdk.core.response.model.a aVar = new com.kwad.sdk.core.response.model.a();
                        aVar.parseJson(jSONObjectOptJSONObject);
                        arrayList.add(aVar);
                    }
                    if (arrayList.size() > 0) {
                        setValue(arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        setValue(Zh());
    }
}
