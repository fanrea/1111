package com.android.gdt.qone.ak;

import android.text.TextUtils;
import com.android.gdt.qone.foundation.net.protocol.CMD;
import com.android.gdt.qone.uin.U;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class q {
    public static final ConcurrentHashMap f = new ConcurrentHashMap();
    public final String a;
    public String b;
    public final Object c = new Object();
    public final Object d = new Object();
    public String e = "0";

    public q(String str) {
        this.a = str;
    }

    public static synchronized q b(String str) {
        q qVar;
        ConcurrentHashMap concurrentHashMap = f;
        qVar = (q) concurrentHashMap.get(str);
        if (qVar == null) {
            qVar = new q(str);
            concurrentHashMap.put(str, qVar);
        }
        return qVar;
    }

    public final String c() throws JSONException {
        String strC;
        synchronized (this.d) {
            strC = com.android.gdt.qone.ad.h.a(this.a).c("tn");
        }
        String str = "2";
        if (strC.length() > 8192) {
            a();
            strC = "";
        }
        if (com.android.gdt.qone.am.a.a(this.a).a()) {
            d();
            String strA = e.a(this.a);
            String strA2 = a(strC);
            String str2 = this.a;
            CMD cmd = CMD.REGISTER;
            strC = U.a(str2, cmd.b(), strA, cmd.a(), strA2);
            str = "4";
        } else if (strC.isEmpty()) {
            strC = d();
            str = "3";
        } else if (com.android.gdt.qone.ae.d.a(com.android.gdt.qone.ad.h.a(this.a).b("t_s_t"), 24L)) {
            strC = d();
            str = "5";
        }
        if (TextUtils.isEmpty(strC)) {
            String str3 = this.a;
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", "1010");
            cVarA.a.put("7", str);
            fVarA.a(cVarA, com.alipay.sdk.m.x.c.d, str3);
        }
        return strC;
    }

    public final String d() throws JSONException {
        String strA = e.a(this.a);
        String strA2 = a(null);
        String str = this.a;
        CMD cmd = CMD.REGISTER;
        String strA3 = U.a(str, cmd.b(), strA, cmd.a(), strA2);
        com.android.gdt.qone.v.a.a().a(new p(this, strA3));
        return strA3;
    }

    public final String a(String str) throws JSONException {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("appKey", this.a);
            jSONObject.put("crypt", "1");
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String b() throws JSONException {
        synchronized (this.c) {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            String strC = c();
            synchronized (this.c) {
                if (TextUtils.isEmpty(this.b)) {
                    this.b = strC;
                }
            }
            return strC;
        }
    }

    public final void a() {
        synchronized (this.d) {
            com.android.gdt.qone.ad.h hVarA = com.android.gdt.qone.ad.h.a(this.a);
            if (hVarA.a() != null) {
                com.android.gdt.qone.w.a.a(hVarA.b, hVarA.d, new com.android.gdt.qone.ad.e(hVarA, "tn"));
            }
        }
    }
}
