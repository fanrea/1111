package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.JavaBackTraceElement;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hp implements com.kwad.sdk.core.d<JavaBackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((JavaBackTraceElement) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((JavaBackTraceElement) bVar, jSONObject);
    }

    private static void a(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        javaBackTraceElement.mDeclaringClass = jSONObject.optString("mDeclaringClass");
        if (JSONObject.NULL.toString().equals(javaBackTraceElement.mDeclaringClass)) {
            javaBackTraceElement.mDeclaringClass = "";
        }
        javaBackTraceElement.mIsTitle = jSONObject.optBoolean("mIsTitle");
        javaBackTraceElement.mIsCausedBy = jSONObject.optBoolean("mIsCausedBy");
        javaBackTraceElement.mIsNative = jSONObject.optBoolean("mIsNative");
    }

    private static JSONObject b(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (javaBackTraceElement.mDeclaringClass != null && !javaBackTraceElement.mDeclaringClass.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDeclaringClass", javaBackTraceElement.mDeclaringClass);
        }
        if (javaBackTraceElement.mIsTitle) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsTitle", javaBackTraceElement.mIsTitle);
        }
        if (javaBackTraceElement.mIsCausedBy) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsCausedBy", javaBackTraceElement.mIsCausedBy);
        }
        if (javaBackTraceElement.mIsNative) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsNative", javaBackTraceElement.mIsNative);
        }
        return jSONObject;
    }
}
