package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tencent.gatherer.core.internal.util.b;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qa {
    private String a;
    private int b;
    private int c;
    private int d;
    private String e;
    private volatile String f;
    private boolean g;
    private long h;
    private AtomicInteger i;
    private final Context k;
    private int l;
    private volatile String m;
    private volatile String n;
    private volatile String o;
    private volatile String p;
    private volatile String q;
    private volatile String r;
    private DisplayMetrics s;
    private volatile String t;
    public final String j = Build.MODEL;
    private final Object u = new Object();

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[zr.values().length];
            a = iArr;
            try {
                iArr[zr.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[zr.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void a() {
        pro.getVresult(94, 0, this);
    }

    private String o() {
        return (String) pro.getobjresult(95, 0, this);
    }

    private int x() {
        if (su.h() < 460) {
            return 0;
        }
        try {
            int identifier = this.k.getResources().getIdentifier("min_screen_width_bucket", TypedValues.Custom.S_INT, this.k.getPackageName());
            if (identifier == 0) {
                return 0;
            }
            return this.k.getResources().getInteger(identifier);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean z() {
        return !pa.b(com.baidu.mobads.upgrade.remote.gray.c.l) && GlobalSetting.isAgreeReadDeviceId();
    }

    public String c() {
        return (String) pro.getobjresult(96, 0, this);
    }

    public String g() {
        zr zrVarF = as.f();
        if (zrVarF == null) {
            return null;
        }
        int i = a.a[zrVarF.ordinal()];
        return i != 1 ? i != 2 ? Config.EVENT_PATH_MAPPING : "unknow" : com.baidu.mobads.container.adrequest.g.u;
    }

    public String j() {
        return (String) pro.getobjresult(97, 0, this);
    }

    public zr p() {
        return as.f();
    }

    public String q() {
        return (String) pro.getobjresult(98, 0, this);
    }

    public int t() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }

    public boolean v() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.h < 60000) {
            return this.g;
        }
        this.h = jCurrentTimeMillis;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            this.g = true;
            return true;
        }
        if (this.i == null) {
            this.i = new AtomicInteger(r1.d().f().a("rpspc", Integer.MAX_VALUE));
        }
        if (this.i.getAndDecrement() > 0) {
            try {
                if (this.k.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                    z = false;
                }
                this.g = z;
            } catch (Throwable unused) {
            }
        }
        return this.g;
    }

    public qa(Context context) {
        this.k = context.getApplicationContext();
        w();
    }

    private void w() {
        y();
        this.l = x();
    }

    public void y() {
        DisplayMetrics displayMetricsA = a(this.k);
        this.s = displayMetricsA;
        this.d = a(displayMetricsA);
        this.b = c(this.s);
        this.c = b(this.s);
    }

    public String m() {
        if (this.a == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.a = lowerCase;
            if (lowerCase.length() == 0) {
                this.a = "en";
            }
        }
        return this.a;
    }

    public int k() {
        return this.b;
    }

    public int i() {
        return this.c;
    }

    public int h() {
        return this.d;
    }

    public String s() {
        if (this.k.getResources().getConfiguration().orientation == 2) {
            this.e = "l";
        } else {
            this.e = "p";
        }
        return this.e;
    }

    public boolean A() {
        return "l".equals(s());
    }

    public boolean B() {
        ApplicationInfo applicationInfo = this.k.getApplicationInfo();
        return applicationInfo != null && (applicationInfo.flags & 8192) == 0;
    }

    public boolean C() {
        return "p".equals(s());
    }

    public z5 d() {
        String strQ = q();
        if (strQ != null) {
            if (!strQ.equals("46000") && !strQ.equals("46002") && !strQ.equals("46007") && !strQ.equals("46020")) {
                if (!strQ.equals("46001") && !strQ.equals("46006")) {
                    if (strQ.equals("46003") || strQ.equals("46005")) {
                        return z5.TELECOM;
                    }
                } else {
                    return z5.UNICOM;
                }
            } else {
                return z5.CMCC;
            }
        }
        return z5.UNKNOWN;
    }

    public int n() {
        return this.l;
    }

    public String r() {
        String str;
        if (this.n != null) {
            return this.n;
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                str = Build.VERSION.RELEASE_OR_CODENAME;
            } else {
                str = Build.VERSION.RELEASE;
            }
            this.n = str;
        } catch (Throwable unused) {
            this.n = Build.VERSION.RELEASE;
        }
        return this.n;
    }

    public String b() {
        if (this.m == null) {
            this.m = Build.ID;
        }
        return this.m;
    }

    public String f() {
        if (this.o == null) {
            this.o = Build.VERSION.CODENAME;
        }
        return this.o;
    }

    public String u() {
        return this.p;
    }

    public String e() {
        if (this.q != null) {
            return this.q;
        }
        synchronized (this.u) {
            if (this.q == null) {
                this.q = com.tencent.gatherer.core.internal.util.c.a(this.k, new b.C0800b().b(true).a(true).a());
                a();
            }
        }
        return this.q;
    }

    public DisplayMetrics l() {
        return this.s;
    }

    private int b(DisplayMetrics displayMetrics) {
        if (t() > 3) {
            return a(displayMetrics.density, displayMetrics.heightPixels);
        }
        return displayMetrics.heightPixels;
    }

    private int c(DisplayMetrics displayMetrics) {
        if (t() > 3) {
            return a(displayMetrics.density, displayMetrics.widthPixels);
        }
        return displayMetrics.widthPixels;
    }

    private int a(DisplayMetrics displayMetrics) {
        if (t() > 3) {
            return displayMetrics.densityDpi;
        }
        return 120;
    }

    private DisplayMetrics a(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    private int a(float f, int i) {
        return (this.k.getApplicationInfo().flags & 8192) != 0 ? (int) (i / f) : i;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.p)) {
            return;
        }
        int iIndexOf = str.indexOf("GDTMobSDK");
        if (iIndexOf > 0) {
            this.p = str.substring(0, iIndexOf - 1);
        } else {
            this.p = str;
        }
    }
}
