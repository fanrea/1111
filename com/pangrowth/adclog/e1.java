package com.pangrowth.adclog;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ f1 b;

    public e1(f1 f1Var, String str) {
        this.b = f1Var;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        f1 f1Var = this.b;
        String str = this.a;
        p1 p1Var = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                p1 p1Var2 = new p1();
                JSONObject jSONObject = new JSONObject(str);
                p1Var2.c = jSONObject.optString("command_id");
                p1Var2.b = jSONObject.optString("type");
                String strOptString = jSONObject.optString("params");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                p1Var2.a = strOptString;
                p1Var2.d = jSONObject2;
                p1Var = p1Var2;
            } catch (Exception e) {
                if (v.a()) {
                    String strA = a0.a(new String[]{"Parse CloudMessage Error."});
                    if (strA == null) {
                        strA = "";
                    }
                    Log.e("cloudmessage", strA + "  " + Log.getStackTraceString(e));
                }
            }
        }
        f1Var.getClass();
        if (v.a()) {
            Log.d("cloudmessage", a0.a(new String[]{"handleCloudMessageInternal cloudMessage=" + p1Var}));
        }
        if (p1Var == null) {
            return;
        }
        Iterator<s1> it = f1Var.b.iterator();
        while (it.hasNext() && !it.next().a(p1Var)) {
        }
    }
}
