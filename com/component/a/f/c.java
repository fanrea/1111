package com.component.a.f;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = "/";
    private final String b;
    private final JSONObject c;
    private final a d = new a();

    public static class a {
        public int a = 10000;
        public int b = 10000;
    }

    public c(String str, JSONObject jSONObject) {
        this.b = "@" + str + a;
        this.c = jSONObject;
    }

    public a a() {
        return this.d;
    }

    public boolean a(String str) {
        return str != null && str.startsWith(this.b);
    }

    public String a(String str, String str2) {
        if (this.c != null && a(str)) {
            try {
                String[] strArrSplit = b(str).split(a);
                if (strArrSplit != null) {
                    if (strArrSplit.length >= 2) {
                        String str3 = strArrSplit[0];
                        int i = Integer.parseInt(strArrSplit[1]);
                        JSONArray jSONArrayOptJSONArray = this.c.optJSONArray(str3);
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() >= i + 1) {
                            return jSONArrayOptJSONArray.optString(i, str2);
                        }
                    } else if (strArrSplit.length == 1) {
                        return this.c.optString(strArrSplit[0], str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }

    public String b(String str, String str2) {
        if (this.c != null) {
            return this.c.optString(b(str), str2);
        }
        return str2;
    }

    public int a(String str, int i) {
        if (this.c != null) {
            return this.c.optInt(b(str), i);
        }
        return i;
    }

    public double a(String str, double d) {
        if (this.c != null) {
            return this.c.optDouble(b(str), d);
        }
        return d;
    }

    public String[] a(String str, String[] strArr) {
        JSONArray jSONArrayOptJSONArray;
        if (this.c != null && a(str) && (jSONArrayOptJSONArray = this.c.optJSONArray(b(str))) != null) {
            try {
                String[] strArr2 = new String[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    strArr2[i] = jSONArrayOptJSONArray.optString(i);
                }
                return strArr2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    private String b(String str) {
        if (a(str)) {
            return str.substring(this.b.length());
        }
        return str;
    }
}
