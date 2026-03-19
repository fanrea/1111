package com.bytedance.msdk.u;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.zw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends d {
    private static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public h(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static h d(Context context, c cVar, JSONObject jSONObject) {
        return new h(UUID.randomUUID().toString(), hc(context, cVar, jSONObject));
    }

    private static JSONObject hc(Context context, c cVar, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, cVar.d);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(np.u()));
            jSONObject2.putOpt("datetime", c.format(new Date()));
        } catch (Exception e) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject3 = new JSONObject(strOptString);
                        jSONObject3.putOpt("v3_err_msg", e.toString());
                        jSONObjectOptJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (cVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", cVar.de.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e.toString());
                    zw.d(jSONObject4);
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    @Override // com.bytedance.msdk.u.d
    public String toString() {
        return "AdEventV3{localId='" + this.d + "', event=" + this.hc + '}';
    }
}
