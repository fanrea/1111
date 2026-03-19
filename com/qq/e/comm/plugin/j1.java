package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.aw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j1 {
    private JSONArray a = new JSONArray();
    private String b;

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.b)) {
            int iIndexOf = str.indexOf(63);
            if (iIndexOf == -1) {
                return;
            } else {
                this.b = str.substring(0, iIndexOf);
            }
        }
        String queryParameter = Uri.parse(str).getQueryParameter(com.baidu.mobads.container.adrequest.g.ah);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("view_id", queryParameter);
            jSONObject.put("filter_code", i);
            this.a.put(jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.b) || this.a.length() <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.a);
            cu cuVar = new cu(this.b, aw.a.POST, jSONObject.toString().getBytes(d6.a));
            cuVar.b("Content-Type", "application/json");
            sr.a().a(cuVar);
        } catch (JSONException unused) {
        }
        this.a = new JSONArray();
    }
}
