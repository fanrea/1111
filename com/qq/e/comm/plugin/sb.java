package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sb {
    private final Context a = r1.d().a();
    private final rb b;

    public sb(rb rbVar) {
        this.b = rbVar;
    }

    public JSONArray c(String str) {
        return qb.a(this.a).b(str);
    }

    public int a(String str, String str2) {
        return qb.a(this.a).a(str, str2);
    }

    public JSONObject b(String str) {
        return this.b.a(str, null, false);
    }

    public int a(String str) {
        return qb.a(this.a).a(str);
    }

    public int b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return qb.a(this.a).a(str, new JSONArray(str2));
            } catch (JSONException e) {
                e.getMessage();
            }
        }
        return -1;
    }

    public String a(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            yb.a(str);
        }
        int iOptInt = new jn(jSONObject).a().optInt("std", 3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectA = new jn(str2).a(com.baidu.mobads.container.components.command.j.s, jCurrentTimeMillis).a();
        String string = jSONObjectA.toString();
        if ((iOptInt & 4) > 0) {
            this.b.a(str, jSONObjectA);
        }
        if ((iOptInt & 2) > 0) {
            yb.b(str, string);
        }
        if ((iOptInt & 1) > 0) {
            String strOptString = jSONObjectA.optString("ph");
            jSONObjectA.remove("ph");
            jSONObjectA.remove(com.baidu.mobads.container.components.command.j.s);
            qb.a(this.a).a(str, jSONObjectA.toString(), strOptString, jCurrentTimeMillis);
        }
        return string;
    }
}
