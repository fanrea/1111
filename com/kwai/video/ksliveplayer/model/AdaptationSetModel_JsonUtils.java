package com.kwai.video.ksliveplayer.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AdaptationSetModel_JsonUtils {
    public static AdaptationSetModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        AdaptationSetModel adaptationSetModel = new AdaptationSetModel();
        adaptationSetModel.mGopDuration = jSONObject.optLong("gopDuration", adaptationSetModel.mGopDuration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(LiveAdaptionModel_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            adaptationSetModel.mRepresentation = arrayList;
        }
        return adaptationSetModel;
    }

    public static AdaptationSetModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdaptationSetModel adaptationSetModel = new AdaptationSetModel();
        adaptationSetModel.mGopDuration = jSONObject.optLong("gopDuration", adaptationSetModel.mGopDuration);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(LiveAdaptionModel_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            adaptationSetModel.mRepresentation = arrayList;
        }
        return adaptationSetModel;
    }

    public static String toJson(AdaptationSetModel adaptationSetModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gopDuration", adaptationSetModel.mGopDuration);
        } catch (Exception unused) {
        }
        try {
            if (adaptationSetModel.mRepresentation != null && !adaptationSetModel.mRepresentation.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<LiveAdaptionModel> it = adaptationSetModel.mRepresentation.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(LiveAdaptionModel_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused2) {
        }
        return jSONObject.toString();
    }
}
