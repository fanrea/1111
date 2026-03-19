package com.kwad.sdk.liteapi.report;

import android.os.Build;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class b {
    public String NF;
    public String NG;
    public String NH;
    public int afa;
    public int afc;
    public String bAy;
    public String bGq;
    public String language;

    b() {
    }

    public static b aln() {
        b bVar = new b();
        try {
            bVar.bAy = LiteOAIDHelper.obtainCurrent();
            bVar.afc = Build.VERSION.SDK_INT;
            bVar.NH = Build.VERSION.RELEASE;
            bVar.afa = 1;
            bVar.language = Locale.getDefault().getLanguage();
            bVar.bGq = Build.MANUFACTURER;
            bVar.NF = Build.MODEL;
            bVar.NG = Build.BRAND;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", this.bAy);
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
        }
        return jSONObject;
    }
}
