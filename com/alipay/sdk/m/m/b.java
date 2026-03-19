package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.n;
import java.io.IOException;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    public b() {
        String strA = com.alipay.sdk.m.j.a.a();
        if (com.alipay.sdk.m.j.a.b()) {
            return;
        }
        this.b += '_' + strA;
    }

    public static synchronized b b() {
        if (g == null) {
            g = new b();
        }
        return g;
    }

    public static String c() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strC = TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(contextB).d()) ? c() : c.b(contextB).b();
        sharedPreferences.edit().putString(e, strC).apply();
        return strC;
    }

    public static String g() {
        String strC;
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(contextB).d())) {
            String strC2 = com.alipay.sdk.m.s.b.d().c();
            strC = (TextUtils.isEmpty(strC2) || strC2.length() < 18) ? c() : strC2.substring(3, 18);
        } else {
            strC = c.b(contextB).c();
        }
        String str = strC;
        sharedPreferences.edit().putString(f, str).apply();
        return str;
    }

    public static String h() {
        return "00";
    }

    public static String i() {
        return "-1";
    }

    public String a() {
        return this.c;
    }

    public static synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.i, str).apply();
        com.alipay.sdk.m.l.a.f = str;
    }

    public static String b(Context context) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(i.b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) throws IOException {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        c cVarB = c.b(contextB);
        if (TextUtils.isEmpty(this.a)) {
            this.a = "Msp/15.8.17 (" + n.f() + i.b + n.e() + i.b + n.c(contextB) + i.b + n.e(contextB) + i.b + n.f(contextB) + i.b + a(contextB);
        }
        String strB = c.d(contextB).b();
        String strB2 = n.b(contextB);
        String strE = e();
        String strC = cVarB.c();
        String strB3 = cVarB.b();
        String strG = g();
        String strF = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        String strReplace = Build.MANUFACTURER.replace(i.b, " ");
        String strReplace2 = Build.MODEL.replace(i.b, " ");
        boolean zE = com.alipay.sdk.m.s.b.e();
        String strD = cVarB.d();
        String strI = i();
        String strH = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.a).append(i.b).append(strB).append(i.b).append(strB2).append(i.b).append(strE).append(i.b).append(strC).append(i.b).append(strB3).append(i.b).append(this.c).append(i.b).append(strReplace).append(i.b).append(strReplace2).append(i.b).append(zE).append(i.b).append(strD).append(i.b).append(d()).append(i.b).append(this.b).append(i.b).append(strG).append(i.b).append(strF).append(i.b).append(strI).append(i.b).append(strH);
        if (aVar2 != null) {
            String strA = com.alipay.sdk.m.w.b.a(aVar, contextB, com.alipay.sdk.m.t.a.a(contextB).d(), com.alipay.sdk.m.w.b.c(aVar, contextB));
            if (!TextUtils.isEmpty(strA)) {
                sb.append(";;;").append(strA);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
