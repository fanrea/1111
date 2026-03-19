package com.baidu.mobads.container.components.k;

import android.app.Activity;
import com.baidu.mobads.container.util.cm;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements com.baidu.mobads.container.activity.c {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.mobads.container.activity.c
    public void a(Activity activity, String str) {
        int iOptInt;
        int iOptInt2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("type");
            String strOptString2 = jSONObject.optString("act");
            int iOptInt3 = jSONObject.optInt("webContentH");
            int iOptInt4 = jSONObject.optInt("webScroolY");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
            String strOptString3 = "";
            if (jSONObjectOptJSONObject == null) {
                iOptInt = 0;
                iOptInt2 = 0;
            } else {
                strOptString3 = jSONObjectOptJSONObject.optString("contentId");
                iOptInt = jSONObjectOptJSONObject.optInt("v_duration");
                iOptInt2 = jSONObjectOptJSONObject.optInt("v_playprogress");
            }
            HashMap map = new HashMap();
            map.put("type", strOptString);
            map.put("act", strOptString2);
            map.put("contentId", strOptString3);
            map.put("vduration", Integer.valueOf(iOptInt));
            map.put("vprogress", Integer.valueOf(iOptInt2));
            map.put("webContentH", Integer.valueOf(iOptInt3));
            map.put("webScroolY", Integer.valueOf(iOptInt4));
            map.put("args", jSONObjectOptJSONObject);
            map.put("activity", activity);
            try {
                this.a.C.dispatchEvent(new cm(b.U, (HashMap<String, Object>) map));
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
