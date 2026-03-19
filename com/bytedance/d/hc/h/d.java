package com.bytedance.d.hc.h;

import android.content.Context;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.cb;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private volatile Context hc;

    public static d d() {
        if (d == null) {
            d = new d(gb.c());
        }
        return d;
    }

    private d(Context context) {
        this.hc = context;
    }

    public String d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return com.bytedance.d.hc.gb.c.d(com.bytedance.d.hc.gb.gb.d(this.hc), com.bytedance.d.hc.gb.gb.d(), hc.d(gb.d().d()), jSONObject, hc.d());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void hc(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strD = hc.d(gb.d().d());
            String strD2 = com.bytedance.d.hc.gb.c.d(com.bytedance.d.hc.gb.gb.d(this.hc), com.bytedance.d.hc.gb.gb.hc(), strD, jSONObject, hc.hc());
            jSONObject.put("upload_scene", "direct");
            if (hc.d(strD, jSONObject.toString()).d()) {
                com.bytedance.d.hc.gb.c.d(strD2);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        cb.d(new Runnable() { // from class: com.bytedance.d.hc.h.d.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                String strD = hc.d(gb.d().d());
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException e) {
                    mq.d(e);
                }
                hc.d(strD, jSONObject.toString());
            }
        });
    }
}
