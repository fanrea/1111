package com.bykv.vk.openvk.component.video.d;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.an.b;
import com.bykv.vk.openvk.component.video.api.d.hc;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static int b = 10;
    public static int c = 10;
    public static int d = 10;
    public static int hc = 10;
    private static hc u;

    public static void d(Context context) {
        com.bykv.vk.openvk.component.video.api.an.d.d(context);
        if (Build.VERSION.SDK_INT < 23) {
            com.bykv.vk.openvk.component.video.d.hc.an.d.d();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            d = jSONObject.optInt("splash", 10);
            hc = jSONObject.optInt("reward", 10);
            b = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            c = iOptInt;
            if (d < 0) {
                d = 10;
            }
            if (hc < 0) {
                hc = 10;
            }
            if (b < 0) {
                b = 10;
            }
            if (iOptInt < 0) {
                c = 10;
            }
            b.d("MediaConfig", "splash=", Integer.valueOf(d), ",reward=", Integer.valueOf(hc), ",brand=", Integer.valueOf(b), ",other=", Integer.valueOf(c));
        } catch (Throwable th) {
            b.b("MediaConfig", th.getMessage());
        }
    }

    public static void d(hc hcVar) {
        u = hcVar;
    }

    public static void d() {
        hc hcVar = u;
        if (hcVar != null) {
            hcVar.u();
        }
    }

    public static int hc() {
        return d;
    }

    public static int b() {
        return hc;
    }

    public static int c() {
        return b;
    }

    public static int u() {
        return c;
    }
}
