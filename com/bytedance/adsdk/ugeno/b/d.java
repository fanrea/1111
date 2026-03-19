package com.bytedance.adsdk.ugeno.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.n.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private String an;
    private List<C0172d> b;
    private long c;
    private String d;
    private float hc;
    private long u;

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public void d(float f) {
        this.hc = f;
    }

    public float hc() {
        return this.hc;
    }

    public List<C0172d> b() {
        return this.b;
    }

    public void d(List<C0172d> list) {
        this.b = list;
    }

    public long c() {
        return this.c;
    }

    public void d(long j) {
        this.c = j;
    }

    public long u() {
        return this.u;
    }

    public void hc(long j) {
        this.u = j;
    }

    public String an() {
        return this.an;
    }

    public void hc(String str) {
        this.an = str;
    }

    public static d d(String str, com.bytedance.adsdk.ugeno.hc.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return d(new JSONObject(str), bVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    public static d d(JSONObject jSONObject, com.bytedance.adsdk.ugeno.hc.b bVar) {
        return d(jSONObject, null, bVar);
    }

    public static d d(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.hc.b bVar) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.d(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            dVar.d(-1.0f);
        } else {
            try {
                dVar.d(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                dVar.d(0.0f);
            }
        }
        dVar.d(jSONObject.optLong("duration", 0L));
        dVar.hc(com.bytedance.adsdk.ugeno.an.b.d(com.bytedance.adsdk.ugeno.c.hc.d(jSONObject.optString("startDelay"), bVar.tc()), 0L));
        dVar.hc(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.an.hc.d(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0172d.d(jSONObjectOptJSONObject, bVar));
            }
            dVar.d(arrayList);
        }
        return dVar;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.b.d$d, reason: collision with other inner class name */
    public static class C0172d {
        private float an;
        private String b;
        private long c;
        private long d;
        private float[] gb;
        private float h;
        private float hc;
        private String tc;
        private String tt;
        private String u;

        public long d() {
            return this.d;
        }

        public void d(long j) {
            this.d = j;
        }

        public float hc() {
            return this.hc;
        }

        public void d(float f) {
            this.hc = f;
        }

        public String b() {
            return this.b;
        }

        public void d(String str) {
            this.b = str;
        }

        public long c() {
            return this.c;
        }

        public void hc(long j) {
            this.c = j;
        }

        public String getType() {
            return this.u;
        }

        public void hc(String str) {
            this.u = str;
        }

        public float u() {
            return this.an;
        }

        public void hc(float f) {
            this.an = f;
        }

        public float an() {
            return this.h;
        }

        public void b(float f) {
            this.h = f;
        }

        public float[] h() {
            return this.gb;
        }

        public void d(float[] fArr) {
            this.gb = fArr;
        }

        public String gb() {
            return this.tt;
        }

        public String tt() {
            return this.tc;
        }

        public void b(String str) {
            this.tc = str;
        }

        public void c(String str) {
            this.tt = str;
        }

        public static C0172d d(JSONObject jSONObject, com.bytedance.adsdk.ugeno.hc.b bVar) {
            if (jSONObject == null) {
                return null;
            }
            C0172d c0172d = new C0172d();
            c0172d.d(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0172d.d(-1.0f);
            } else {
                try {
                    c0172d.d(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0172d.d(0.0f);
                }
            }
            c0172d.d(jSONObject.optString("loopMode"));
            c0172d.hc(jSONObject.optString("type"));
            if (TextUtils.equals(c0172d.getType(), "ripple")) {
                c0172d.b(jSONObject.optString("rippleColor"));
            }
            View viewTt = bVar.tt();
            Context context = viewTt != null ? viewTt.getContext() : null;
            if (TextUtils.equals(c0172d.getType(), f.T)) {
                String strD = com.bytedance.adsdk.ugeno.c.hc.d(jSONObject.optString("valueTo"), bVar.tc());
                int iD = com.bytedance.adsdk.ugeno.an.d.d(jSONObject.optString("valueFrom"));
                int iD2 = com.bytedance.adsdk.ugeno.an.d.d(strD);
                c0172d.hc(iD);
                c0172d.b(iD2);
            } else if ((TextUtils.equals(c0172d.getType(), "translateX") || TextUtils.equals(c0172d.getType(), "translateY")) && context != null) {
                try {
                    float fD = com.bytedance.adsdk.ugeno.an.gb.d(context, (float) jSONObject.optDouble("valueFrom"));
                    float fD2 = com.bytedance.adsdk.ugeno.an.gb.d(context, (float) jSONObject.optDouble("valueTo"));
                    c0172d.hc(fD);
                    c0172d.b(fD2);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.mq.c("animation", "animation ");
                }
            } else {
                c0172d.hc((float) jSONObject.optDouble("valueFrom"));
                c0172d.b((float) jSONObject.optDouble("valueTo"));
            }
            c0172d.c(jSONObject.optString("interpolator"));
            c0172d.hc(com.bytedance.adsdk.ugeno.an.b.d(com.bytedance.adsdk.ugeno.c.hc.d(jSONObject.optString("startDelay"), bVar.tc()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0172d.getType(), "translateX") || TextUtils.equals(c0172d.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.an.gb.d(context, (float) d.d(jSONArrayOptJSONArray.optString(i), bVar.tc()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) d.d(jSONArrayOptJSONArray.optString(i), bVar.tc());
                        i++;
                    }
                }
                c0172d.d(fArr);
            }
            return c0172d;
        }
    }

    public static double d(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.an.b.d(com.bytedance.adsdk.ugeno.c.hc.d((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
