package com.android.gdt.qone.z;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public String e;
    public String g;
    public final long h;
    public int f = 0;
    public boolean i = false;

    public d(String str) throws JSONException {
        this.b = -1;
        this.h = 0L;
        this.a = -1;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error");
            if (i == 0) {
                String string = jSONObject.getString("body");
                this.d = string;
                if (!TextUtils.isEmpty(string)) {
                    this.h = jSONObject.getLong("nct");
                    this.a = 0;
                }
            } else {
                this.c = jSONObject.getString("type");
                a(jSONObject.getString("msg"));
                this.a = 0;
            }
            this.b = i;
        } catch (JSONException unused) {
        }
    }

    public final boolean a() {
        return this.a == 0 && this.b == 0;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.i = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.e = jSONObject.getString("ic");
            this.f = jSONObject.getInt("rc");
            this.g = jSONObject.getString("em");
            this.i = true;
        } catch (JSONException unused) {
            this.i = false;
        }
    }
}
