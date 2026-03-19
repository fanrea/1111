package com.bytedance.bdtracker;

import android.app.Application;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h {
    public SharedPreferences a;

    public h(Application application, String str) {
        Intrinsics.checkParameterIsNotNull(application, "applicationContext");
        Intrinsics.checkParameterIsNotNull(str, "spName");
        this.a = f4.a(application, str, 0);
    }

    public final <T extends p> T a(String str, Class<T> cls) {
        String string;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            long jOptLong = jSONObject.optLong("expire_ts");
            if (jOptLong == -1 || (jOptLong > 0 && System.currentTimeMillis() < jOptLong)) {
                return (T) p.a.a(jSONObject, cls);
            }
            SharedPreferences sharedPreferences2 = this.a;
            if (sharedPreferences2 == null || (editorEdit = sharedPreferences2.edit()) == null || (editorRemove = editorEdit.remove(str)) == null) {
                return null;
            }
            editorRemove.apply();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String a(String str) {
        String string;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        Intrinsics.checkParameterIsNotNull(str, "key");
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            long jOptLong = jSONObject.optLong("expire_ts");
            if (jOptLong == -1 || (jOptLong > 0 && System.currentTimeMillis() < jOptLong)) {
                return jSONObject.optString("data");
            }
            SharedPreferences sharedPreferences2 = this.a;
            if (sharedPreferences2 == null || (editorEdit = sharedPreferences2.edit()) == null || (editorRemove = editorEdit.remove(str)) == null) {
                return null;
            }
            editorRemove.apply();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(String str, p pVar, long j) throws JSONException {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(pVar, "data");
        JSONObject jSONObjectA = pVar.a();
        jSONObjectA.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(str, jSONObjectA.toString())) == null) {
            return;
        }
        editorPutString.apply();
    }

    public final void a(String str, String str2, long j) throws JSONException {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkParameterIsNotNull(str, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str2);
        jSONObject.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(str, jSONObject.toString())) == null) {
            return;
        }
        editorPutString.apply();
    }
}
