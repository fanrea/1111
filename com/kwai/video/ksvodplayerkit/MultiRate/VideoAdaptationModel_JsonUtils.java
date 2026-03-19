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
public final class VideoAdaptationModel_JsonUtils {
    public static VideoAdaptationModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VideoAdaptationModel videoAdaptationModel = new VideoAdaptationModel();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adaptationSet");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(AdaptationSet_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            videoAdaptationModel.mAdaptationSet = arrayList;
        }
        return videoAdaptationModel;
    }

    public static VideoAdaptationModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoAdaptationModel videoAdaptationModel = new VideoAdaptationModel();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adaptationSet");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(AdaptationSet_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            videoAdaptationModel.mAdaptationSet = arrayList;
        }
        return videoAdaptationModel;
    }

    public static String toJson(VideoAdaptationModel videoAdaptationModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (videoAdaptationModel.mAdaptationSet != null && !videoAdaptationModel.mAdaptationSet.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<AdaptationSet> it = videoAdaptationModel.mAdaptationSet.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(AdaptationSet_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
