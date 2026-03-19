package com.kwai.video.ksliveplayer.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLivePlayerSourceModel_JsonUtils {
    public static KSLivePlayerSourceModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KSLivePlayerSourceModel kSLivePlayerSourceModel = new KSLivePlayerSourceModel();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("liveAdaptiveManifest");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(LiveAdaptiveManifestModel_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kSLivePlayerSourceModel.mAdaptiveManifestList = arrayList;
        }
        kSLivePlayerSourceModel.mLiveAdaptiveConfig = jSONObject.optString("liveAdaptiveConfig", kSLivePlayerSourceModel.mLiveAdaptiveConfig);
        kSLivePlayerSourceModel.mLiveStreamId = jSONObject.optString("streamName", kSLivePlayerSourceModel.mLiveStreamId);
        return kSLivePlayerSourceModel;
    }

    public static KSLivePlayerSourceModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KSLivePlayerSourceModel kSLivePlayerSourceModel = new KSLivePlayerSourceModel();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("liveAdaptiveManifest");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(LiveAdaptiveManifestModel_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kSLivePlayerSourceModel.mAdaptiveManifestList = arrayList;
        }
        kSLivePlayerSourceModel.mLiveAdaptiveConfig = jSONObject.optString("liveAdaptiveConfig", kSLivePlayerSourceModel.mLiveAdaptiveConfig);
        kSLivePlayerSourceModel.mLiveStreamId = jSONObject.optString("streamName", kSLivePlayerSourceModel.mLiveStreamId);
        return kSLivePlayerSourceModel;
    }

    public static String toJson(KSLivePlayerSourceModel kSLivePlayerSourceModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (kSLivePlayerSourceModel.mAdaptiveManifestList != null && !kSLivePlayerSourceModel.mAdaptiveManifestList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<LiveAdaptiveManifestModel> it = kSLivePlayerSourceModel.mAdaptiveManifestList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(LiveAdaptiveManifestModel_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("liveAdaptiveManifest", jSONArray);
            }
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("liveAdaptiveConfig", kSLivePlayerSourceModel.mLiveAdaptiveConfig);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("streamName", kSLivePlayerSourceModel.mLiveStreamId);
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
