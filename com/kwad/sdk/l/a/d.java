package com.kwad.sdk.l.a;

import android.content.Context;
import android.provider.Settings;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int cjy = 0;
    public int cjz = 0;
    public int cjA = 0;
    public int cjB = 0;
    public int cjC = 0;
    public int cjD = 0;
    public int cjE = 0;

    private static int dw(boolean z) {
        return z ? 1 : 2;
    }

    public d(Context context) {
        if (context != null) {
            try {
                dt(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
            } catch (Throwable unused) {
            }
        }
    }

    public final void dq(boolean z) {
        this.cjy = dw(z);
    }

    public final void dr(boolean z) {
        this.cjz = dw(z);
    }

    public final void ds(boolean z) {
        this.cjA = dw(z);
    }

    private void dt(boolean z) {
        this.cjC = dw(z);
    }

    public final void du(boolean z) {
        this.cjD = dw(z);
    }

    public final void dv(boolean z) {
        this.cjE = dw(z);
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.cjy = jSONObject.optInt("isRoot");
        dVar.cjz = jSONObject.optInt("isXPosed");
        dVar.cjA = jSONObject.optInt("isFrameworkHooked");
        dVar.cjB = jSONObject.optInt("isVirtual");
        dVar.cjC = jSONObject.optInt("isAdbEnabled");
        dVar.cjD = jSONObject.optInt("isEmulator");
        dVar.cjE = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "isRoot", dVar.cjy);
        aa.putValue(jSONObject, "isXPosed", dVar.cjz);
        aa.putValue(jSONObject, "isFrameworkHooked", dVar.cjA);
        aa.putValue(jSONObject, "isVirtual", dVar.cjB);
        aa.putValue(jSONObject, "isAdbEnabled", dVar.cjC);
        aa.putValue(jSONObject, "isEmulator", dVar.cjD);
        aa.putValue(jSONObject, "isGroupControl", dVar.cjE);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
