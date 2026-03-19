package com.kwai.video.ksvodplayerkit.MultiRate;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KwaiAdaptationSet_JsonUtils {
    public static KwaiAdaptationSet fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KwaiAdaptationSet kwaiAdaptationSet = new KwaiAdaptationSet();
        kwaiAdaptationSet.id = jSONObject.optInt("id", kwaiAdaptationSet.id);
        kwaiAdaptationSet.duration = jSONObject.optInt("duration", kwaiAdaptationSet.duration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(KwaiRepresentation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kwaiAdaptationSet.representation = arrayList;
        }
        return kwaiAdaptationSet;
    }

    public static KwaiAdaptationSet fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KwaiAdaptationSet kwaiAdaptationSet = new KwaiAdaptationSet();
        kwaiAdaptationSet.id = jSONObject.optInt("id", kwaiAdaptationSet.id);
        kwaiAdaptationSet.duration = jSONObject.optInt("duration", kwaiAdaptationSet.duration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(KwaiRepresentation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kwaiAdaptationSet.representation = arrayList;
        }
        return kwaiAdaptationSet;
    }

    public static String toJson(KwaiAdaptationSet kwaiAdaptationSet) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", kwaiAdaptationSet.id);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("duration", kwaiAdaptationSet.duration);
        } catch (Exception unused2) {
        }
        try {
            if (kwaiAdaptationSet.representation != null && !kwaiAdaptationSet.representation.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<KwaiRepresentation> it = kwaiAdaptationSet.representation.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(KwaiRepresentation_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
