package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.by;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bp {
    public static final String a = "alreadyinstalled_call_openapp";
    public static final String b = "alreadydownloaded_call_installapp";
    private static final String c = "4.1.30";
    private static final String d = "BaiduMobAd_APP_ID";
    private static bp e = null;
    private String f;

    public static bp a() {
        if (e == null) {
            e = new bp();
        }
        return e;
    }

    private bp() {
    }

    public void a(Context context, int i, String str, com.baidu.mobads.container.components.command.j jVar) {
        String strSubstring;
        try {
            by.a aVarA = by.a.a(context);
            aVarA.a(i);
            aVarA.b("");
            aVarA.a("msg", str);
            if (jVar == null) {
                strSubstring = "";
            } else {
                aVarA.a("prod", jVar.k());
                aVarA.a(jVar.l());
                aVarA.a(com.baidu.mobads.container.components.command.j.c, jVar.ac);
                aVarA.a("adid", jVar.h());
                aVarA.a("pk", jVar.d());
                aVarA.a("qk", jVar.i());
                aVarA.a(com.baidu.mobads.container.components.command.j.r, jVar.an);
                aVarA.a(com.baidu.mobads.container.components.command.j.f, jVar.j());
                aVarA.a("dl_type", jVar.ay);
                aVarA.a(com.baidu.mobads.container.components.command.j.F, jVar.az);
                if (jVar.am != null) {
                    aVarA.a(jVar.am);
                }
                strSubstring = jVar.aa;
                if (!TextUtils.isEmpty(strSubstring)) {
                    int iIndexOf = strSubstring.indexOf("?");
                    if (iIndexOf <= 0) {
                        iIndexOf = strSubstring.length();
                    }
                    strSubstring = strSubstring.substring(0, iIndexOf);
                }
            }
            aVarA.a("net", ab.g(context));
            aVarA.a("bdr", x.a(context).a());
            aVarA.a(com.baidu.mobads.container.adrequest.g.w, "");
            aVarA.a("url", strSubstring);
            aVarA.g();
        } catch (Exception e2) {
            bq.a().a(e2);
        }
    }

    public void a(Context context, int i, String str, com.baidu.mobads.container.components.command.o oVar) {
        String strD;
        try {
            by.a aVarA = by.a.a(context);
            aVarA.a(i);
            aVarA.a("msg", str);
            if (oVar == null) {
                strD = "";
            } else {
                aVarA.a(oVar.s());
                aVarA.b(oVar.r());
                aVarA.a("prod", oVar.q());
                aVarA.a(com.baidu.mobads.container.components.command.j.c, oVar.t());
                aVarA.a("adid", oVar.a());
                aVarA.a("pk", oVar.j());
                aVarA.a("qk", oVar.g());
                aVarA.a("act", oVar.b());
                aVarA.a(com.baidu.mobads.container.components.command.j.f, oVar.h);
                aVarA.a("dl_type", oVar.x);
                aVarA.a(com.baidu.mobads.container.components.command.j.F, oVar.w);
                if (oVar.x() != null) {
                    aVarA.a(oVar.x());
                }
                strD = oVar.d();
                if (!TextUtils.isEmpty(strD)) {
                    int iIndexOf = strD.indexOf("?");
                    if (iIndexOf <= 0) {
                        iIndexOf = strD.length();
                    }
                    strD = strD.substring(0, iIndexOf);
                }
            }
            aVarA.a("net", ab.g(context));
            aVarA.a("bdr", x.a(context).a());
            aVarA.a(com.baidu.mobads.container.adrequest.g.w, "");
            aVarA.a("url", strD);
            aVarA.g();
        } catch (Exception e2) {
            bq.a().a(e2);
        }
    }

    public void a(Context context, long j) {
        if (context == null) {
            return;
        }
        try {
            Map<String, ?> all = context.getSharedPreferences(j.a, 0).getAll();
            new StringBuilder();
            by.a aVarA = by.a.a(context);
            aVarA.a(408);
            aVarA.a("msg", "dl_info");
            for (String str : all.keySet()) {
                if (str.contains(com.baidu.mobads.container.components.command.j.b)) {
                    JSONObject jSONObject = new JSONObject(String.valueOf(all.get(str)));
                    long jOptLong = jSONObject.optLong(com.baidu.mobads.container.components.command.j.t);
                    int iOptInt = jSONObject.optInt("dl");
                    if (iOptInt >= 4 && iOptInt <= 6) {
                        if (jOptLong < j) {
                            aVarA.a("dlname", o.k(str));
                            aVarA.a("qk", jSONObject.optString("qk"));
                            aVarA.a("adid", jSONObject.optString("adid"));
                            aVarA.a("dl", iOptInt);
                            aVarA.a(com.baidu.mobads.container.components.command.j.f, jSONObject.optString(com.baidu.mobads.container.components.command.j.f));
                            aVarA.a("filename", jSONObject.optString("filename"));
                            aVarA.a(com.baidu.mobads.container.components.command.j.r, jSONObject.optString(com.baidu.mobads.container.components.command.j.r));
                            aVarA.a(com.baidu.mobads.container.components.command.j.q, jSONObject.optString(com.baidu.mobads.container.components.command.j.q));
                            aVarA.a(com.baidu.mobads.container.components.command.j.t, jSONObject.optString(com.baidu.mobads.container.components.command.j.t));
                            if (jSONObject.getJSONObject(com.baidu.mobads.container.components.command.j.g) != null) {
                                aVarA.a("dl_type", jSONObject.optString("dl_type"));
                            }
                        }
                    }
                }
            }
            aVarA.a("bdr", x.a(context).a());
            aVarA.f();
        } catch (Exception e2) {
            bq.a().a(e2);
        }
    }

    public String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(com.baidu.mobads.container.components.command.j.f, "");
            if (TextUtils.isEmpty(strOptString)) {
                return jSONObject.optString("buyer_id", "");
            }
            return strOptString;
        }
        return "";
    }

    public String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("exps");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    String string = jSONArrayOptJSONArray.toString();
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    public String a(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return "";
        }
        return jSONObject.optString(str, "");
    }

    public void a(int i, String str, String str2) {
        bq.a().c(a().a(String.valueOf(i), str, str2));
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    public static boolean c(JSONObject jSONObject) {
        try {
            File file = new File(jSONObject.optString(com.baidu.mobads.container.components.command.j.m) + jSONObject.optString("filename"));
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public void a(Context context, int i, String str, com.baidu.mobads.container.components.command.j jVar, String str2) {
        String strSubstring = "";
        try {
            by.a aVarA = by.a.a(context);
            aVarA.a(i);
            aVarA.b("");
            aVarA.a("msg", str);
            if (jVar != null) {
                aVarA.a("prod", jVar.k());
                aVarA.a(com.baidu.mobads.container.components.command.j.c, jVar.ac);
                aVarA.a("adid", jVar.h());
                aVarA.a("pk", jVar.d());
                aVarA.a("qk", jVar.i());
                aVarA.a(com.baidu.mobads.container.components.command.j.r, jVar.an);
                aVarA.a(com.baidu.mobads.container.components.command.j.f, jVar.j());
                aVarA.a(com.baidu.mobads.container.components.command.j.i, jVar.U);
                aVarA.a(com.baidu.mobads.container.components.command.j.F, jVar.az);
                aVarA.a("dl_type", jVar.ay);
                if (jVar.am != null) {
                    aVarA.a(jVar.am);
                }
                strSubstring = jVar.aa;
                if (!TextUtils.isEmpty(strSubstring)) {
                    int iIndexOf = strSubstring.indexOf("?");
                    if (iIndexOf <= 0) {
                        iIndexOf = strSubstring.length();
                    }
                    strSubstring = strSubstring.substring(0, iIndexOf);
                }
            }
            aVarA.a("net", ab.g(context));
            aVarA.a("bdr", x.a(context).a());
            aVarA.a("url", strSubstring);
            aVarA.a("errorMsg", str2);
            aVarA.g();
        } catch (Exception e2) {
            bq.a().a(e2);
        }
    }
}
