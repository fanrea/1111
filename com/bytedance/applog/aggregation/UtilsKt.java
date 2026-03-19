package com.bytedance.applog.aggregation;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0006¨\u0006\b"}, d2 = {"copy", "Lorg/json/JSONObject;", "copyFrom", "from", "toJSONArray", "Lorg/json/JSONArray;", "", "toJSONObject", "aggregation_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UtilsKt {
    public static final JSONObject copy(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$copy");
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject2;
    }

    public static final JSONObject copyFrom(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$copyFrom");
        if (jSONObject2 != null) {
            try {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static final JSONObject toJSONObject(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toJSONObject");
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final JSONArray toJSONArray(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toJSONArray");
        try {
            return new JSONArray(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
