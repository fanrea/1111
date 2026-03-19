package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobstat.forbes.Config;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w {
    private static final String a = "https://cpu.baidu.com/";
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 99;
    private Set<String> g;
    private Set<String> h;
    private Set<String> i;
    private CookieManager j;
    private Context k;
    private int l;
    private String m;
    private String n;
    private String o;
    private boolean p;

    public w(Context context, int i, String str) {
        this.k = context;
        this.l = i;
        this.m = str;
        this.n = null;
        b();
        c();
    }

    public w(Context context, String str, String str2) {
        this.k = context;
        this.n = str;
        this.m = str2;
        this.l = -1;
        b();
        c();
    }

    public void a(String str) {
        this.o = str;
    }

    private void b() {
        try {
            CookieSyncManager.createInstance(this.k);
        } catch (Throwable th) {
        }
        try {
            this.j = CookieManager.getInstance();
            this.j.setAcceptCookie(true);
        } catch (Throwable th2) {
        }
    }

    public String a() {
        try {
            d();
        } catch (Throwable th) {
        }
        if (this.n != null) {
            return "https://cpu.baidu.com/block/app/" + this.m + "/" + this.n;
        }
        return a + this.l + "/" + this.m;
    }

    private void c() {
        this.g = new HashSet();
        this.g.add("46000");
        this.g.add("46002");
        this.g.add("46007");
        this.h = new HashSet();
        this.h.add("46001");
        this.h.add("46006");
        this.i = new HashSet();
        this.i.add("46003");
        this.i.add("46005");
    }

    private void d() {
        Rect rectA = bv.a(this.k);
        int iHeight = rectA.height();
        int iWidth = rectA.width();
        boolean zBooleanValue = com.baidu.mobads.container.util.e.a.i(this.k).booleanValue();
        String strB = zBooleanValue ? b(g()) : null;
        String strF = zBooleanValue ? f() : null;
        a("v", (Object) h());
        a("m", "");
        a(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(com.baidu.mobads.container.util.e.a.h(this.k)));
        a("oi", Integer.valueOf(i()));
        a("src", (Object) 1);
        a("h", Integer.valueOf(iHeight));
        a("w", Integer.valueOf(iWidth));
        a("apm", (Object) strB);
        a("apn", (Object) strF);
        a("isc", Integer.valueOf(zBooleanValue ? 1 : 0));
        a("sdk_version", (Object) ("android_" + com.baidu.mobads.container.j.b()));
        String strE = e();
        a(strE, "im", IDManager.getInstance().c(this.k));
        a(strE, "cuid", IDManager.getInstance().a(this.k));
        if (!TextUtils.isEmpty(this.o)) {
            a(strE, "outerId", this.o);
        }
        a("sdknewfunc", "monitor_cpuadview_internal_status");
        if (this.p) {
            a("sdkhasnovel", (Object) 1);
        } else {
            a("sdkhasnovel", (Object) 0);
        }
        if (com.baidu.mobads.container.util.x.a(this.k).a() >= 21) {
            this.j.flush();
        }
    }

    private void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
        try {
            this.j.setCookie(a, stringBuffer.toString());
        } catch (Throwable th) {
        }
    }

    private void a(String str, String str2, String str3) {
        if (!a(str, str2)) {
            a(str2, (Object) com.baidu.mobads.container.nativecpu.a.b.a(com.baidu.mobads.container.nativecpu.a.b.a, str3));
        }
    }

    private String e() {
        try {
            return this.j.getCookie(a);
        } catch (Throwable th) {
            return null;
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.contains(new StringBuilder().append("; ").append(str2).append("=").toString()) || str.contains(new StringBuilder().append(com.alipay.sdk.m.u.i.b).append(str2).append("=").toString()) || str.startsWith(new StringBuilder().append(str2).append("=").toString());
    }

    private String f() {
        return "";
    }

    private String g() {
        return "";
    }

    private String h() {
        PackageInfo packageInfoA = bk.a(this.k, this.k.getPackageName(), 0);
        String str = packageInfoA == null ? null : packageInfoA.versionName;
        if (str == null) {
            return null;
        }
        return str.replace(".", "-");
    }

    private int i() {
        String strA = com.baidu.mobads.container.util.e.a.a(this.k);
        if (strA == null) {
            return 0;
        }
        if (this.g.contains(strA)) {
            return 1;
        }
        if (this.i.contains(strA)) {
            return 2;
        }
        if (this.h.contains(strA)) {
            return 3;
        }
        return 99;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "-");
    }

    public void a(boolean z) {
        this.p = z;
    }
}
