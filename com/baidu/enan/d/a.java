package com.baidu.enan.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static a a;
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    private a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wm_leroadcfg", 4);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public static synchronized a a(Context context) {
        if (context == null) {
            return a;
        }
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public String b() {
        return this.b.getString("xytk_m", "");
    }

    public void b(String str) {
        this.c.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.c.apply();
        } else {
            this.c.commit();
        }
    }

    public String c() {
        return this.b.getString("xyusec", "");
    }

    public void c(String str) {
        this.c.putString("xyusec", str);
        this.c.commit();
    }

    public long d() {
        return this.b.getLong("la_se_up_t", 0L);
    }

    public String a() {
        return this.b.getString("xyus", "");
    }

    public void a(String str) {
        this.c.putString("xyus", str);
        this.c.commit();
    }

    public void a(long j) {
        this.c.putLong("la_se_up_t", j);
        this.c.commit();
    }
}
