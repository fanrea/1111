package com.bytedance.adsdk.ugeno.d.d;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    private String b;
    protected JSONObject d;
    protected com.bytedance.adsdk.ugeno.hc.b hc;

    public abstract List<PropertyValuesHolder> b();

    public abstract void d(int i, int i2);

    public abstract void d(Canvas canvas);

    public abstract void hc();

    public d(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
        this.d = jSONObject;
        this.hc = bVar;
        d();
    }

    public void d() {
        this.b = this.d.optString("type");
        hc();
    }

    public String c() {
        return this.b;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.d.d.d$d, reason: collision with other inner class name */
    public static class C0175d {
        public static d d(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
            if (bVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new u(bVar, jSONObject);
                case "ripple":
                    return new hc(bVar, jSONObject);
                case "rub_in":
                    return new b(bVar, jSONObject);
                case "shine":
                    return new c(bVar, jSONObject);
                default:
                    return null;
            }
        }
    }
}
