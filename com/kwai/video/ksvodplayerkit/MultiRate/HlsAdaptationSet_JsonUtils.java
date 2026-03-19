package com.kwai.video.ksvodplayerkit.MultiRate;

import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class HlsAdaptationSet_JsonUtils {
    public static HlsAdaptationModel.HlsAdaptationSet fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        HlsAdaptationModel.HlsAdaptationSet hlsAdaptationSet = new HlsAdaptationModel.HlsAdaptationSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(HlsRepresentation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            hlsAdaptationSet.representation = arrayList;
        }
        return hlsAdaptationSet;
    }

    public static HlsAdaptationModel.HlsAdaptationSet fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HlsAdaptationModel.HlsAdaptationSet hlsAdaptationSet = new HlsAdaptationModel.HlsAdaptationSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("representation");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(HlsRepresentation_JsonUtils.fromJson(jSONObjectOptJSONObject));
                }
            }
            hlsAdaptationSet.representation = arrayList;
        }
        return hlsAdaptationSet;
    }

    public static String toJson(HlsAdaptationModel.HlsAdaptationSet hlsAdaptationSet) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (hlsAdaptationSet.representation != null && !hlsAdaptationSet.representation.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<HlsRepresentation> it = hlsAdaptationSet.representation.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(HlsRepresentation_JsonUtils.toJson(it.next())));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
