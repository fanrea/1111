package com.qq.e.comm.plugin;

import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class o4 extends e30 {
    protected final h4 a;

    protected abstract ih<String> a();

    protected abstract void a(View view, String str, long j);

    protected abstract JSONObject c(View view) throws JSONException;

    public o4(h4 h4Var) {
        this.a = h4Var;
    }

    @Override // com.qq.e.comm.plugin.e30
    public final ih<String> a(jm jmVar, ug ugVar) {
        String strA = ugVar.a();
        View viewA = jmVar.a();
        if ("getVideoAdInfo".equals(strA)) {
            return a(viewA);
        }
        if ("onClick".equals(strA)) {
            return a(viewA, ugVar.d());
        }
        if ("isViewable".equals(strA)) {
            return b(viewA);
        }
        if ("replayVideo".equals(strA)) {
            return a();
        }
        return new ih<>(1000, "Unsupported action");
    }

    protected ih<String> b(View view) {
        if (view == null) {
            return new ih<>(null);
        }
        return a(d50.a(view.getContext(), view, 100));
    }

    protected ih<String> a(View view) throws JSONException {
        if (view == null) {
            return new ih<>(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ku kuVarX0 = this.a.x0();
            JSONObject jSONObjectC = c(view);
            jSONObject.put("code", 0);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectA = kuVarX0.a();
            jSONObject2.put("adInfo", jSONObjectC);
            jSONObject2.put("cfg", jSONObjectA);
            jSONObject.put("data", jSONObject2);
            return new ih<>(jSONObject.toString());
        } catch (JSONException unused) {
            return new ih<>(null);
        }
    }

    protected ih<String> a(View view, JSONObject jSONObject) {
        long jOptLong;
        String strOptString;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("antiSpam");
            jOptLong = jSONObject.optLong("supportMarket");
        } else {
            jOptLong = 0;
            strOptString = null;
        }
        a(view, strOptString, jOptLong);
        return new ih<>(null);
    }

    public ih<String> a(boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z);
            return new ih<>(jSONObject.toString());
        } catch (Exception e) {
            e.getMessage();
            return new ih<>(null);
        }
    }
}
