package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class x4 {
    protected volatile JSONObject a;

    x4() {
        this(null);
    }

    x4(String str) {
        getClass().getSimpleName();
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        if (this.a == null) {
            this.a = new JSONObject();
        }
    }

    JSONObject a() {
        return this.a;
    }
}
