package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ay;
import com.baidu.mobads.container.util.bq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "theme";
    public static final String b = "EXTRA_DATA_STRING_AD";
    public static final String c = "EXTRA_DATA_STRING_COM";
    public static final String d = "EXTRA_DATA_STRING";
    public static final String e = "EXTRA_DATA";
    public String f = "";
    public String g = "";
    private String h;
    private XAdInstanceInfoExt i;
    private Context j;
    private Activity k;
    private String l;
    private String m;
    private String n;

    public a(t tVar, String str, XAdInstanceInfoExt xAdInstanceInfoExt, String str2) {
        this.h = null;
        this.h = str2;
        if (tVar != null) {
            this.j = tVar.t();
            this.k = tVar.u();
            this.m = tVar.z();
            this.n = tVar.A();
        }
        this.l = str;
        this.i = xAdInstanceInfoExt;
    }

    public a(Context context, XAdInstanceInfoExt xAdInstanceInfoExt, String str, String str2, String str3) {
        this.h = null;
        this.h = str3;
        this.l = str;
        this.m = str2;
        this.j = context;
        this.i = xAdInstanceInfoExt;
    }

    public void a(String str) throws JSONException {
        try {
            Context context = this.j;
            if (this.k != null && ("rvideo".equals(this.l) || "fvideo".equals(this.l))) {
                context = this.k;
            }
            Intent intent = new Intent(context, com.baidu.mobads.container.util.t.d());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("prod", this.l);
            jSONObject.put("adElementInfo", this.i.getSimplifiedJsonString());
            jSONObject.put("sn", DeviceUtils.getInstance().b(this.j));
            jSONObject.put("url", this.h);
            jSONObject.put("adid", this.i.getAdId());
            jSONObject.put("qk", this.i.getQueryKey());
            jSONObject.put(com.baidu.mobads.container.landingpage.a.g, this.j.getPackageName());
            jSONObject.put("appsid", this.m);
            jSONObject.put(com.baidu.mobads.container.landingpage.a.j, this.n);
            jSONObject.put("title", this.i.getTitle());
            jSONObject.put(com.baidu.mobads.container.landingpage.a.l, this.f);
            jSONObject.put(com.baidu.mobads.container.landingpage.a.m, this.g);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("apid", str);
            }
            jSONObject.put(com.baidu.mobads.container.landingpage.a.p, System.currentTimeMillis());
            jSONObject.put("lpMultiProcess", "" + com.baidu.mobads.container.config.b.a().b());
            if (this.k != null) {
                jSONObject.put(com.baidu.mobads.container.landingpage.a.o, com.baidu.mobads.container.util.h.c(this.k));
            }
            intent.putExtra("EXTRA_DATA", jSONObject.toString());
            intent.putExtra("activityImplName", ay.g);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }
}
