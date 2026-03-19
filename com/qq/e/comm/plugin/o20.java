package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.an;
import com.qq.e.comm.plugin.aw;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o20 implements an {
    private SharedPreferences a;

    private String a(aw awVar, String str) throws Exception {
        if (awVar.o() == aw.a.GET) {
            return Uri.parse(str).getQueryParameter("posid");
        }
        String strSubstring = null;
        for (String str2 : new String(awVar.c(), d6.a).split(com.alipay.sdk.m.s.a.n)) {
            if (str2.startsWith("posid")) {
                strSubstring = str2.substring(6);
            }
        }
        return strSubstring;
    }

    @Override // com.qq.e.comm.plugin.an
    public hw a(an.a aVar) throws Exception {
        Context contextA = r1.d().a();
        aw awVarA = aVar.a();
        SharedPreferences sharedPreferences = contextA.getSharedPreferences("gdt_mock", 0);
        this.a = sharedPreferences;
        int i = sharedPreferences.getInt("cs", -1);
        int i2 = this.a.getInt(Config.PLATFORM_TYPE, -1);
        int i3 = this.a.getInt("ifs", 0);
        int i4 = this.a.getInt("scenes", -1);
        if (k.a(awVarA.h()) && i != -1 && i2 != -1) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.PLATFORM_TYPE, i2);
            jSONObject.put("cs", i);
            jSONObject.put("scenes", i4);
            jSONObject.put("ifs", i3);
            jSONObject.put("c_os", "android");
            jSONObject.put("c_pkgname", contextA.getPackageName());
            jSONObject.put("appid", r1.d().b().a());
            jSONObject.put("posid", a(awVarA, awVarA.h()));
            jSONObject.put("postype", b(awVarA, awVarA.h()));
            b(awVarA, awVarA.h());
            cu cuVar = new cu("https://union.eff.qq.com/v2/query/gdtmview", aw.a.POST, jSONObject.toString().getBytes("UTF-8"));
            cuVar.b("Content-Type", "application/json");
            cuVar.e(awVarA.a());
            cuVar.a(awVarA.m());
            return aVar.a(cuVar);
        }
        return aVar.a(awVarA);
    }

    private int b(aw awVar, String str) throws Exception {
        JSONObject jSONObject;
        if (awVar.o() == aw.a.GET) {
            jSONObject = new JSONObject(Uri.parse(str).getQueryParameter("ext"));
        } else {
            JSONObject jSONObject2 = null;
            for (String str2 : new String(awVar.c(), d6.a).split(com.alipay.sdk.m.s.a.n)) {
                if (str2.startsWith("ext")) {
                    jSONObject2 = new JSONObject(URLDecoder.decode(str2).substring(4));
                }
            }
            jSONObject = jSONObject2;
        }
        return jSONObject.optJSONObject("req").optInt("postype");
    }
}
