package com.baidu.enan.e.b;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.enan.a.c;
import com.baidu.enan.e.b.a.b;
import com.baidu.enan.e.b.a.d;
import com.baidu.enan.e.b.a.e;
import com.baidu.enan.e.b.a.f;
import com.baidu.enan.e.b.a.g;
import com.baidu.enan.e.b.a.h;
import com.baidu.enan.e.b.a.i;
import com.baidu.enan.e.b.a.j;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("02002", Build.MANUFACTURER);
            jSONObject.put("02003", Build.MODEL);
            jSONObject.put("02004", Build.BRAND);
            jSONObject.put("02005", Build.BOARD);
            jSONObject.put("02006", Build.DEVICE);
            jSONObject.put("02007", Build.HARDWARE);
            jSONObject.put("02008", Build.PRODUCT);
            jSONObject.put("02010", d.c(context));
            jSONObject.put("02015", Build.VERSION.RELEASE);
            jSONObject.put("02019", Build.ID);
            jSONObject.put("02020", Build.FINGERPRINT);
            String str = "1";
            jSONObject.put("02037", d.a(context) ? "1" : "0");
            jSONObject.put("06005", com.baidu.enan.e.b.a.a.a(context));
            jSONObject.put("06009", com.baidu.enan.e.b.a.a.b(context));
            jSONObject.put("06011", String.valueOf(d.b(context)));
            if (!((Boolean) d.d(context).first).booleanValue()) {
                str = "0";
            }
            jSONObject.put("06012", str);
            jSONObject.put("07001", h.a(context));
            jSONObject.put("10001", b.a());
            String strA = g.a();
            if (!TextUtils.isEmpty(strA)) {
                strA = !strA.contains("64") ? "32 " + strA : "64 " + strA;
            }
            jSONObject.put("11003", strA);
            jSONObject.put("12005", e.a(context));
            jSONObject.put("15018", c.c());
            jSONObject.put("15029", i.a(context));
            jSONObject.put("15049", com.baidu.enan.e.b.a.c.a(context));
            jSONObject.put("15095", com.baidu.enan.f.b.c(context));
            jSONObject.put("17001", j.a());
            try {
                f fVar = new f();
                fVar.a(10, 10);
                String strGlGetString = fVar.a.glGetString(7937);
                jSONObject.put("20081", fVar.a.glGetString(7936));
                jSONObject.put("20082", strGlGetString);
                fVar.b();
            } catch (Throwable th) {
                com.baidu.enan.f.a.a(th);
            }
            jSONObject.put("02029", Build.TYPE);
            jSONObject.put("02043", Build.HOST);
            jSONObject.put("02056", com.baidu.enan.e.b.b.a.a());
            jSONObject.put("02059", com.baidu.enan.e.b.c.a.a());
            jSONObject.put("07001", com.baidu.enan.e.b.d.a.a(context));
            Pair<String, String> pairA = com.baidu.enan.e.b.e.a.a();
            jSONObject.put("11001", pairA.first);
            jSONObject.put("11002", pairA.second);
            jSONObject.put("14001", com.baidu.enan.e.b.f.a.a());
            jSONObject.put("15048", com.baidu.enan.e.b.g.b.a(context));
            jSONObject.put("16022", com.baidu.enan.e.b.h.a.a());
            jSONObject.put("17001", com.baidu.enan.e.b.i.a.a());
            jSONObject.put("15067", String.valueOf(d.e(context)));
            jSONObject.put("16013", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            jSONObject.put("19034", c.b());
            jSONObject.put("19035", com.baidu.enan.e.b.a.c.b(context));
            return jSONObject;
        } catch (Throwable th2) {
            com.baidu.enan.f.a.a(th2);
            return new JSONObject();
        }
    }
}
