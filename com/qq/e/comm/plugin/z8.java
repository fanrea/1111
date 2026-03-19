package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z8 {
    public final int a;
    public final String b;
    public final JSONObject c;
    public final String d;
    public final JSONObject e;
    public final JSONObject f;
    private final Map<String, ob> g;
    private boolean h = false;

    public z8(e10 e10Var) {
        JSONObject jSONObject;
        this.a = e10Var.a;
        this.b = e10Var.b;
        if (!TextUtils.isEmpty(e10Var.c)) {
            try {
                jSONObject = new JSONObject(e10Var.c);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        this.c = jSONObject;
        this.d = e10Var.e;
        this.e = e10Var.f;
        this.f = e10Var.g;
        this.g = e10Var.d;
    }

    public void a(im imVar, w40<?, ?> w40Var) {
        Map<String, ob> map = this.g;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ob> entry : this.g.entrySet()) {
            imVar.i().a(w40Var, entry.getValue(), this, entry.getKey());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || this.g == null || jSONObject.length() <= 0 || this.g.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ob> entry : this.g.entrySet()) {
            Object objE = (this.h ? entry.getValue() : entry.getValue().a()).e(jSONObject);
            if (objE != null) {
                a(entry.getKey(), objE);
            }
        }
        this.h = true;
    }

    public void a(String str, Object obj) throws JSONException {
        try {
            this.c.putOpt(str, obj);
        } catch (JSONException e) {
            e.getMessage();
        }
    }
}
