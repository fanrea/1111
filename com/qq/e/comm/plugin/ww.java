package com.qq.e.comm.plugin;

import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ww extends e30 {
    private static final String a = uw.Z;

    @Override // com.qq.e.comm.plugin.e30
    public ih<String> a(jm jmVar, ug ugVar) {
        ugVar.a();
        if ("isViewable".equals(ugVar.a())) {
            return a(jmVar.a());
        }
        return new ih<>(1000, "Unsupported action");
    }

    protected ih<String> a(View view) {
        if (view == null) {
            return new ih<>(null);
        }
        return a(d50.a(view.getContext(), view, 100));
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
