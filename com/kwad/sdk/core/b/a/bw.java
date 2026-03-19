package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bw implements com.kwad.sdk.core.d<BackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BackTraceElement) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BackTraceElement) bVar, jSONObject);
    }

    private static void a(BackTraceElement backTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backTraceElement.mLine = jSONObject.optString("mLine");
        if (JSONObject.NULL.toString().equals(backTraceElement.mLine)) {
            backTraceElement.mLine = "";
        }
        backTraceElement.mMethodName = jSONObject.optString("mMethodName");
        if (JSONObject.NULL.toString().equals(backTraceElement.mMethodName)) {
            backTraceElement.mMethodName = "";
        }
        backTraceElement.mFileName = jSONObject.optString("mFileName");
        if (JSONObject.NULL.toString().equals(backTraceElement.mFileName)) {
            backTraceElement.mFileName = "";
        }
        backTraceElement.mLineNumber = jSONObject.optLong("mLineNumber");
        backTraceElement.mIndex = jSONObject.optInt("mIndex");
        backTraceElement.mNeedClustering = jSONObject.optBoolean("mNeedClustering");
    }

    private static JSONObject b(BackTraceElement backTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (backTraceElement.mLine != null && !backTraceElement.mLine.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mLine", backTraceElement.mLine);
        }
        if (backTraceElement.mMethodName != null && !backTraceElement.mMethodName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mMethodName", backTraceElement.mMethodName);
        }
        if (backTraceElement.mFileName != null && !backTraceElement.mFileName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFileName", backTraceElement.mFileName);
        }
        if (backTraceElement.mLineNumber != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mLineNumber", backTraceElement.mLineNumber);
        }
        if (backTraceElement.mIndex != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIndex", backTraceElement.mIndex);
        }
        if (backTraceElement.mNeedClustering) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mNeedClustering", backTraceElement.mNeedClustering);
        }
        return jSONObject;
    }
}
