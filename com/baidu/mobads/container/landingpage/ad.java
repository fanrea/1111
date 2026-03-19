package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ad extends cn {
    private static ad c;
    private Context a;
    private ae b;

    private ad(Context context) {
        this.a = context.getApplicationContext();
    }

    public static ad a(Context context) {
        if (c == null) {
            synchronized (ad.class) {
                if (c == null) {
                    c = new ad(context);
                }
            }
        }
        return c;
    }

    public void a() {
        try {
            if (this.b == null) {
                this.b = new ae(this);
            }
            if (this.a != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                intentFilter.addAction(ae.b);
                new com.component.c.b(this.a).a(this.b, intentFilter);
            }
        } catch (Exception e) {
        }
    }

    public void b() {
        if (this.a != null && this.b != null) {
            try {
                new com.component.c.b(this.a).a(this.b);
                this.b = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.F));
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.G));
        a(this.a).removeEventListeners(com.baidu.mobads.container.components.k.b.F);
        a(this.a).removeEventListeners(com.baidu.mobads.container.components.k.b.G);
        a(this.a).removeEventListeners(com.baidu.mobads.container.components.k.b.U);
        a(this.a).b();
    }

    public void a(Intent intent) {
        int iOptInt;
        int iOptInt2;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("cpu_fe_args");
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
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
                    dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.U, (HashMap<String, Object>) map));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
