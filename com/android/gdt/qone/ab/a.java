package com.android.gdt.qone.ab;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static String a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
