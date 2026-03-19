package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.vg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d30 extends x0 {
    public d30(jm jmVar) {
        super(jmVar);
    }

    @Override // com.qq.e.comm.plugin.bm
    public void b(String str) throws JSONException {
        ug ugVarA;
        Uri uri = Uri.parse(str);
        if (a30.b(uri)) {
            try {
                ugVarA = a(uri);
            } catch (Throwable unused) {
                String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str);
                ugVarA = null;
            }
            c(ugVarA);
            b(ugVarA);
        }
    }

    private ih<String> b(ug ugVar) throws JSONException {
        if (ugVar == null) {
            return new ih<>(null);
        }
        if ("template".equals(ugVar.e())) {
            if ("multiAction".equals(ugVar.a())) {
                a(TextUtils.isEmpty(ugVar.c()) ? ugVar.d().toString() : ugVar.c(), ugVar.f());
            } else {
                a(ugVar);
            }
            return new ih<>(null);
        }
        e30 e30VarA = this.b.a(ugVar.e());
        if (e30VarA != null) {
            return e30VarA.a(this.a, ugVar);
        }
        a(new vg(ugVar, vg.a.HANDLER_NOT_FOUND_EXCEPTION, "Unsupported service!", 0));
        return new ih<>(1000, "Unsupported service");
    }

    private void c(ug ugVar) throws JSONException {
        if (ugVar != null && !TextUtils.isEmpty(ugVar.a())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", ugVar.a());
                a(jSONObject.toString());
                return;
            } catch (JSONException e) {
                a(new String[0]);
                e.getMessage();
                return;
            }
        }
        a(new String[0]);
    }

    private void a(ug ugVar) {
        c30 c30VarA = this.c.a(ugVar.a());
        if (c30VarA != null) {
            c30VarA.a(this.a, ugVar);
        } else {
            a(new vg(ugVar, vg.a.HANDLER_NOT_FOUND_EXCEPTION, "Unsupported action!", 0));
        }
    }

    @Override // com.qq.e.comm.plugin.bm
    public ih<String> a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            b10.b(100292, null, 3, new ja().a("msg", str));
            return new ih<>(-1, "Invalid message");
        }
        if (!"GDTJsBridge".equals(jSONObject.optString("gdtJB"))) {
            b10.b(100292, null, 4, new ja().a("msg", str));
            return new ih<>(-1, "Unsupported protocol");
        }
        String strOptString = jSONObject.optString("service");
        String strOptString2 = jSONObject.optString("action");
        String strOptString3 = jSONObject.optString("params");
        String strOptString4 = jSONObject.optString("callbackId");
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(strOptString3)) {
                jSONObject2 = new JSONObject(strOptString3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return b(new ug(strOptString, strOptString2, strOptString4, jSONObject2));
    }

    private void a(String str, long j) throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a(new ug("", jSONObject.optString("action"), jSONObject.optString("callbackId"), jSONObject.optJSONObject("params"), j));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
