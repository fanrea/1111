package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.i;
import com.baidu.mobstat.forbes.Config;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.final, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cfinal {
    public final String a;
    public final int b;
    public final Fig c;

    public Cfinal(String str, int i, Fig fig) {
        this.a = str;
        this.b = i;
        this.c = fig;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str == null) {
            str = "";
        }
        sb.append(a(a.n, "%0A", a(",", "%54", a(Config.replace, "%5F", a(i.b, "%3B", a(":", "%3A", str))))));
        sb.append(Config.replace);
        sb.append(this.b);
        sb.append(Config.replace);
        Fig fig = this.c;
        if (fig == null) {
            return sb.toString();
        }
        sb.append(fig.a);
        sb.append(":");
        sb.append(this.c.b);
        sb.append(":");
        Iterator<Filbert> it = this.c.c.iterator();
        while (it.hasNext()) {
            Filbert next = it.next();
            sb.append(next.a);
            sb.append(",,,");
            Locale locale = Locale.SIMPLIFIED_CHINESE;
            String strReplaceAll = String.format(locale, "%.5f", Float.valueOf(next.d));
            if (strReplaceAll.indexOf(".") > 0) {
                strReplaceAll = strReplaceAll.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(strReplaceAll);
            sb.append(",");
            String strReplaceAll2 = String.format(locale, "%.5f", Float.valueOf(next.e));
            if (strReplaceAll2.indexOf(".") > 0) {
                strReplaceAll2 = strReplaceAll2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(strReplaceAll2);
            if (it.hasNext()) {
                sb.append(i.b);
            }
        }
        sb.append(":");
        sb.append(this.c.d);
        return sb.toString();
    }
}
