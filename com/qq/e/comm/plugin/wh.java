package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wh {
    private final String a;
    private final int b;

    wh(int i) {
        this.a = null;
        this.b = i;
    }

    public String a() {
        return this.a;
    }

    wh(String str) {
        this.a = str;
        this.b = -1;
    }

    Object a(Object obj) {
        int i;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) && (i = this.b) >= 0) {
            return ((JSONArray) obj).opt(i);
        }
        if (!(obj instanceof JSONObject) || TextUtils.isEmpty(this.a)) {
            return null;
        }
        return ((JSONObject) obj).opt(this.a);
    }
}
