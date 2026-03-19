package com.kwai.video.ksvodplayerkit.MultiRate;

import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KwaiMediaManifest_JsonUtils {
    public static KwaiMediaManifest fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KwaiMediaManifest kwaiMediaManifest = new KwaiMediaManifest();
        kwaiMediaManifest.mVersion = jSONObject.optString(Config.INPUT_DEF_VERSION, kwaiMediaManifest.mVersion);
        kwaiMediaManifest.mBusinessType = jSONObject.optInt("businessType", kwaiMediaManifest.mBusinessType);
        kwaiMediaManifest.mMediaType = jSONObject.optInt("mediaType", kwaiMediaManifest.mMediaType);
        kwaiMediaManifest.mStereoType = jSONObject.optInt("stereoType", kwaiMediaManifest.mStereoType);
        kwaiMediaManifest.mHideAuto = jSONObject.optBoolean("hideAuto", kwaiMediaManifest.mHideAuto);
        kwaiMediaManifest.mAutoDefaultSelect = jSONObject.optBoolean("manualDefaultSelect", kwaiMediaManifest.mAutoDefaultSelect);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adaptationSet");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(KwaiAdaptationSet_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kwaiMediaManifest.adaptationSet = arrayList;
        }
        return kwaiMediaManifest;
    }

    public static KwaiMediaManifest fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KwaiMediaManifest kwaiMediaManifest = new KwaiMediaManifest();
        kwaiMediaManifest.mVersion = jSONObject.optString(Config.INPUT_DEF_VERSION, kwaiMediaManifest.mVersion);
        kwaiMediaManifest.mBusinessType = jSONObject.optInt("businessType", kwaiMediaManifest.mBusinessType);
        kwaiMediaManifest.mMediaType = jSONObject.optInt("mediaType", kwaiMediaManifest.mMediaType);
        kwaiMediaManifest.mStereoType = jSONObject.optInt("stereoType", kwaiMediaManifest.mStereoType);
        kwaiMediaManifest.mHideAuto = jSONObject.optBoolean("hideAuto", kwaiMediaManifest.mHideAuto);
        kwaiMediaManifest.mAutoDefaultSelect = jSONObject.optBoolean("manualDefaultSelect", kwaiMediaManifest.mAutoDefaultSelect);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adaptationSet");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(KwaiAdaptationSet_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            kwaiMediaManifest.adaptationSet = arrayList;
        }
        return kwaiMediaManifest;
    }

    public static String toJson(KwaiMediaManifest kwaiMediaManifest) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.INPUT_DEF_VERSION, kwaiMediaManifest.mVersion);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("businessType", kwaiMediaManifest.mBusinessType);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("mediaType", kwaiMediaManifest.mMediaType);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("stereoType", kwaiMediaManifest.mStereoType);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("hideAuto", kwaiMediaManifest.mHideAuto);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("manualDefaultSelect", kwaiMediaManifest.mAutoDefaultSelect);
        } catch (Exception unused6) {
        }
        try {
            if (kwaiMediaManifest.adaptationSet != null && !kwaiMediaManifest.adaptationSet.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<KwaiAdaptationSet> it = kwaiMediaManifest.adaptationSet.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(KwaiAdaptationSet_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception unused7) {
        }
        return jSONObject.toString();
    }
}
