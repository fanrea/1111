package com.baidu.mobads.container.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ah;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final String a = "appsid";
    public static final String b = "channelId";
    public static final String c = "videoCacheSize";
    public static final String d = "p_ver";
    public static final String e = "https";
    public static final String f = "lpMultiProcess";
    public static final String g = "useActivityDialog";
    public static final String h = "dialog_params";
    private static volatile b t;
    private JSONObject i;
    private String k;
    private String l;
    private Context m;
    private int n;
    private String o;
    private boolean p;
    private ICommonModuleObj q;
    private JSONObject s;
    private boolean j = true;
    private boolean r = true;
    private String u = "";

    private b() {
    }

    public static b a() {
        if (t == null) {
            synchronized (b.class) {
                if (t == null) {
                    t = new b();
                }
            }
        }
        return t;
    }

    public boolean b() {
        return this.p;
    }

    public void a(Context context) {
        this.m = context.getApplicationContext();
    }

    public Context c() {
        return this.m;
    }

    public boolean d() {
        return this.j;
    }

    public boolean e() {
        return this.r;
    }

    public JSONObject f() {
        return this.s;
    }

    public String g() {
        return this.k;
    }

    public String h() {
        return this.o;
    }

    public void a(String str) {
        this.k = str;
    }

    public void b(String str) {
        this.u = str;
    }

    public String i() {
        return this.u;
    }

    public String j() {
        return this.l;
    }

    public void a(ICommonModuleObj iCommonModuleObj) {
        this.q = iCommonModuleObj;
    }

    public ICommonModuleObj k() {
        return this.q;
    }

    public void a(JSONObject jSONObject) {
        this.i = jSONObject;
        String str = (String) ah.a(this.i, g);
        if (!TextUtils.isEmpty(str)) {
            this.r = Boolean.parseBoolean(str);
        }
        this.s = this.i.optJSONObject(h);
        String str2 = (String) ah.a(this.i, "p_ver");
        if (!TextUtils.isEmpty(str2)) {
            this.l = str2;
        } else if (TextUtils.isEmpty(this.l)) {
            this.l = "8.88";
        }
        String str3 = (String) ah.a(this.i, "https");
        if (!TextUtils.isEmpty(str3)) {
            this.j = Boolean.parseBoolean(str3);
        }
        String str4 = (String) ah.a(this.i, c);
        if (!TextUtils.isEmpty(str4)) {
            this.n = Integer.parseInt(str4);
            com.baidu.mobads.container.util.b.a.a(this.n * 1000 * 1000);
        }
        String str5 = (String) ah.a(this.i, "appsid");
        if (!TextUtils.isEmpty(str5)) {
            this.k = str5;
            DeviceUtils.getInstance().b(this.k);
        }
        String str6 = (String) ah.a(this.i, "channelId");
        if (!TextUtils.isEmpty(str6)) {
            this.o = str6;
        }
        String str7 = (String) ah.a(this.i, "lpMultiProcess");
        if (!TextUtils.isEmpty(str7)) {
            this.p = Boolean.parseBoolean(str7);
        }
    }
}
