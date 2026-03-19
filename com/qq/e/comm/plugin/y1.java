package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y1 {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private JSONArray e;

    private y1(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int a() {
        return this.b;
    }

    public boolean a(int i) {
        JSONArray jSONArray = this.e;
        return jSONArray == null || (jSONArray.length() >= 2 && i >= this.e.optInt(0) && i <= this.e.optInt(1));
    }

    public static y1 a(JSONObject jSONObject) {
        return a(jSONObject, 0);
    }

    public static y1 a(JSONObject jSONObject, int i) {
        int iOptInt;
        if (jSONObject == null || (iOptInt = jSONObject.optInt("ac")) == 0) {
            return null;
        }
        if (i != 0 && i != iOptInt) {
            return null;
        }
        String strOptString = jSONObject.optString("id");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        y1 y1Var = new y1(strOptString, iOptInt);
        y1Var.e = jSONObject.optJSONArray("tr");
        y1Var.c = jSONObject.optInt("p", 0);
        y1Var.d = jSONObject.optInt(Config.EVENT_H5_PAGE, 0);
        return y1Var;
    }
}
