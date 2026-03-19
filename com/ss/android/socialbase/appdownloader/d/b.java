package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends d {
    private final JSONObject c;

    public b(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str, JSONObject jSONObject) {
        super(context, dVar, str);
        this.c = jSONObject;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        String strOptString = this.c.optString("action");
        String strOptString2 = this.c.optString("category");
        int iOptInt = this.c.optInt("flags", 1342210048);
        String strOptString3 = this.c.optString("path_extra_key");
        String strOptString4 = this.c.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.c.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.c.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.b)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.b);
        }
        d(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void d(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                d(jSONObject, next, strOptString, intent);
            }
        }
    }

    private static void d(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
