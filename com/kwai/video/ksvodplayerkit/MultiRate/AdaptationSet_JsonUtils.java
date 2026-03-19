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
public final class AdaptationSet_JsonUtils {
    public static AdaptationSet fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        AdaptationSet adaptationSet = new AdaptationSet();
        adaptationSet.mAdaptationId = jSONObject.optLong("adaptationId", adaptationSet.mAdaptationId);
        adaptationSet.mDuration = jSONObject.optString("duration", adaptationSet.mDuration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(Representation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            adaptationSet.mRepresentation = arrayList;
        }
        return adaptationSet;
    }

    public static AdaptationSet fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdaptationSet adaptationSet = new AdaptationSet();
        adaptationSet.mAdaptationId = jSONObject.optLong("adaptationId", adaptationSet.mAdaptationId);
        adaptationSet.mDuration = jSONObject.optString("duration", adaptationSet.mDuration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(Representation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            adaptationSet.mRepresentation = arrayList;
        }
        return adaptationSet;
    }

    public static String toJson(AdaptationSet adaptationSet) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adaptationId", adaptationSet.mAdaptationId);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("duration", adaptationSet.mDuration);
        } catch (Exception unused2) {
        }
        try {
            if (adaptationSet.mRepresentation != null && !adaptationSet.mRepresentation.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Representation> it = adaptationSet.mRepresentation.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(Representation_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
