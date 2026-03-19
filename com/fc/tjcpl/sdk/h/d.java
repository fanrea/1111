package com.fc.tjcpl.sdk.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    public int a;
    public String b;

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.equals("ok")) {
                this.a = 0;
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optInt("code", 1);
            this.b = jSONObject.optString("msg", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
