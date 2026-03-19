package lkxssdk.z;

import android.text.TextUtils;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public List<String> e;
    public boolean f;
    public boolean g;

    public a(String str) {
        this.b = str;
    }

    public String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", !TextUtils.isEmpty(this.a) ? this.a : "");
            jSONObject.put("appUrl", !TextUtils.isEmpty(this.b) ? this.b : "");
            jSONObject.put("channelId", !TextUtils.isEmpty(this.c) ? this.c : "");
            jSONObject.put("appPackage", TextUtils.isEmpty(this.d) ? "" : this.d);
            List<String> list = this.e;
            if (list != null && list.size() > 0) {
                jSONObject.put("verifyKey", new JSONArray((Collection) this.e));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a a(List<String> list) {
        this.e = list;
        return this;
    }

    public a b(String str) {
        this.d = str;
        return this;
    }

    public a c(String str) {
        this.c = str;
        return this;
    }
}
