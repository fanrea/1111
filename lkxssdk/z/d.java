package lkxssdk.z;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d {
    public String a;
    public long b;
    public int c;
    public int d;

    public d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("fileName");
            this.b = jSONObject.optLong("fileSize");
            this.c = jSONObject.optInt("threadCount");
            this.d = jSONObject.optInt("acceptRange");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
