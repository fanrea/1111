package com.alipay.sdk.m.c0;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.a);
        stringBuffer.append("," + this.b);
        stringBuffer.append("," + this.c);
        stringBuffer.append("," + this.d);
        if (com.alipay.sdk.m.z.a.a(this.e) || this.e.length() < 20) {
            sb = new StringBuilder(",");
            strSubstring = this.e;
        } else {
            sb = new StringBuilder(",");
            strSubstring = this.e.substring(0, 20);
        }
        stringBuffer.append(sb.append(strSubstring).toString());
        if (com.alipay.sdk.m.z.a.a(this.f) || this.f.length() < 20) {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f;
        } else {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f.substring(0, 20);
        }
        stringBuffer.append(sb2.append(strSubstring2).toString());
        if (com.alipay.sdk.m.z.a.a(this.g) || this.g.length() < 20) {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.g;
        } else {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.g.substring(0, 20);
        }
        stringBuffer.append(sb3.append(strSubstring3).toString());
        return stringBuffer.toString();
    }
}
