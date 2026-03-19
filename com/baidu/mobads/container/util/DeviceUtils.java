package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class DeviceUtils {
    private static final String a = "__x_adsdk_agent_header__";
    private static final String b = "BaiduMobAd_APP_ID";
    private static final DeviceUtils m = new DeviceUtils();
    private static AtomicBoolean o = new AtomicBoolean(false);
    private static String p = "";
    private static AtomicBoolean q = new AtomicBoolean(false);
    private static String r = "";
    private static int s = 0;
    private static String t = "";
    private static AtomicInteger u = new AtomicInteger(0);
    private String c;
    private String d;
    private String e;
    private String f = "";
    private String g = "";
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private SPUtils n;

    private DeviceUtils() {
    }

    public static DeviceUtils getInstance() {
        return m;
    }

    public boolean a(Context context) {
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public String b(Context context) {
        try {
            if (TextUtils.isEmpty(this.d)) {
                this.d = com.baidu.mobads.container.util.f.z.a(context);
            }
            return this.d;
        } catch (Exception e) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            if (TextUtils.isEmpty(this.c)) {
                this.c = u.a(IDManager.getInstance().a(context));
            }
            return this.c;
        } catch (Exception e) {
            return this.c;
        }
    }

    public String d(Context context) {
        return "";
    }

    public String e(Context context) {
        return "";
    }

    public String a() {
        return x.a(null).b();
    }

    public String f(Context context) {
        try {
            if (TextUtils.isEmpty(this.h)) {
                this.h = u.a(b(context));
            }
            return this.h;
        } catch (Exception e) {
            return this.h;
        }
    }

    public String b() {
        return x.a(null).e();
    }

    public String g(Context context) {
        if (TextUtils.isEmpty(this.e)) {
            if (!s(context)) {
                this.e = "";
                return this.e;
            }
            try {
                com.baidu.mobads.container.d.b.a().a(new al(this, ((TelephonyManager) context.getSystemService("phone")).getCellLocation()));
            } catch (Throwable th) {
                th.printStackTrace();
                this.e = "null_null_null";
            }
        }
        return this.e;
    }

    private boolean s(Context context) {
        if (!com.baidu.mobads.container.h.a.a().f()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return bl.a(context, "android.permission.ACCESS_FINE_LOCATION");
        }
        return Build.VERSION.SDK_INT < 23 || bl.a(context, com.kuaishou.weapon.p0.g.h) || bl.a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public String h(Context context) {
        return "";
    }

    public JSONArray i(Context context) {
        return new JSONArray();
    }

    public String j(Context context) {
        return this.f + this.g;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6 || str.length() > 256) {
            return true;
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (str.charAt(length) == '0');
        return false;
    }

    public String k(Context context) {
        return "";
    }

    public String l(Context context) {
        try {
            this.i = com.baidu.mobads.container.config.b.a().g();
            if (TextUtils.isEmpty(this.i)) {
                this.i = this.j;
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = b(context, b);
            }
            return this.i;
        } catch (Exception e) {
            return "";
        }
    }

    public void b(String str) {
        this.j = str;
    }

    private String b(Context context, String str) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            if (obj == null) {
                return "";
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            return "";
        }
    }

    public String m(Context context) {
        c(l(context));
        return this.k;
    }

    public void c(String str) {
        this.k = str + "_cpr";
    }

    public String c() {
        return "";
    }

    public String n(Context context) {
        if (!s(context)) {
            return this.l;
        }
        String strF = t.f(context);
        if (TextUtils.isEmpty(this.l)) {
            com.baidu.mobads.container.d.b.a().a(new am(this, context, strF));
        }
        return this.l;
    }

    public String o(Context context) {
        return n(context);
    }

    public String a(Context context, String str) {
        return ap.a(IDManager.getInstance().c(context) + l(context) + str + System.currentTimeMillis());
    }

    public boolean p(Context context) {
        return 17 <= x.a(context).a() ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0);
    }

    private SPUtils t(Context context) {
        if (this.n == null) {
            this.n = new SPUtils(context, a);
        }
        return this.n;
    }

    private boolean u(Context context) {
        return com.baidu.mobads.container.h.a.a().g() && bl.a(context, "android.permission.READ_PHONE_STATE");
    }

    public String d() {
        try {
            if (o.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    p = str;
                }
            }
            return p;
        } catch (Throwable th) {
            bq.a().a(Config.ROM, th.getMessage());
            return p;
        }
    }

    public String e() {
        try {
            if (q.get()) {
                return r;
            }
            if (!o.get()) {
                d();
            }
            if (p.equalsIgnoreCase("")) {
                q.set(true);
                return "";
            }
            if (q.compareAndSet(false, true)) {
                String strA = a(com.alipay.sdk.m.c.a.b, "");
                if (!TextUtils.isEmpty(strA)) {
                    r = strA;
                }
            }
            return r;
        } catch (Throwable th) {
            bq.a().a(Config.ROM, th.getMessage());
            return r;
        }
    }

    public int q(Context context) {
        try {
        } catch (Throwable th) {
            bq.a().a(Config.ROM, th.getMessage());
        }
        if (s != 0) {
            return s;
        }
        if (context != null) {
            if (Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", -1) == 0) {
                s = 1;
            } else {
                s = 2;
            }
        }
        return s;
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            if (TextUtils.isEmpty(str3)) {
                return str2;
            }
            return str3;
        } catch (Throwable th) {
            bq.a().a(Config.ROM, th.getMessage());
            return str2;
        }
    }

    public String r(Context context) {
        try {
            if (TextUtils.isEmpty(t) && u.get() < 3) {
                if (context == null) {
                    return "";
                }
                u.getAndIncrement();
                PackageInfo packageInfoA = bk.a(context, context.getPackageName(), 64);
                byte[] byteArray = new byte[0];
                if (packageInfoA != null) {
                    byteArray = packageInfoA.signatures[0].toByteArray();
                }
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                if (sb.length() > 1) {
                    t = sb.substring(0, sb.length() - 1);
                }
                return t;
            }
            return t;
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.f(th.getMessage());
            return "";
        }
    }
}
