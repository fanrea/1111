package com.kwai.kanas.b;

import android.content.SharedPreferences;
import com.kwai.kanas.Kanas;
import com.kwai.kanas.a.c;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    public static final String a = "KanasSharedPreference";
    public static final String b = "last_date_upload_installed_app";
    public static final String c = "KanasCrid";
    public static final String d = "app_usage_snapshot_duration";
    public static final String e = "app_usage_snapshot";
    public static final String f = "log_control_config";
    public static final String g = "debug_logger_host";
    private SharedPreferences h;
    private SharedPreferences.Editor i;

    /* renamed from: com.kwai.kanas.b.a$a, reason: collision with other inner class name */
    static class C0649a {
        private static final a a = new a();

        private C0649a() {
        }
    }

    public static a a() {
        return C0649a.a;
    }

    public final SharedPreferences b() {
        if (this.h == null) {
            this.h = Azeroth.get().getContext().getSharedPreferences(a, 0);
        }
        return this.h;
    }

    public final SharedPreferences.Editor c() {
        if (this.i == null) {
            this.i = b().edit();
        }
        return this.i;
    }

    public final String d() {
        return b().getString(g, "");
    }

    public final void a(String str) {
        c().putString(g, str);
    }

    public final void e() {
        c().remove(g);
    }

    public final void b(String str) {
        c().putString(f, str);
    }

    public final String f() {
        return b().getString(f, "");
    }

    public final boolean g() {
        String string = b().getString(b, "");
        String str = new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(Calendar.getInstance().getTime());
        c().putString(b, str).apply();
        return !TextUtils.equals(str, string);
    }

    public final void a(long j, c.b bVar) {
        c().putLong(d, j).putString(e, JsonUtils.toJson(bVar).toString()).commit();
    }

    public final void h() {
        c().remove(d).remove(e).commit();
    }

    public final long i() {
        return b().getLong(d, 0L);
    }

    public final c.b j() {
        if (i() <= 0) {
            return null;
        }
        String string = b().getString(e, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (c.b) JsonUtils.fromJson(string, c.b.class);
        } catch (Exception e2) {
            Kanas.get().getConfig().logger().logErrors(e2);
            return null;
        } finally {
            h();
        }
    }
}
