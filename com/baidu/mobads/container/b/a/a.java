package com.baidu.mobads.container.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private Context a;
    private String b;

    public a(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    private SharedPreferences a() {
        return this.a.getSharedPreferences(this.b, 0);
    }

    private SharedPreferences.Editor b() {
        return a().edit();
    }

    public String a(String str) {
        try {
            return a().getString(str, "");
        } catch (Exception e) {
            return "";
        }
    }

    public Long b(String str) {
        try {
            return Long.valueOf(a().getLong(str, 0L));
        } catch (Exception e) {
            return 0L;
        }
    }

    public int c(String str) {
        try {
            return a().getInt(str, 0);
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0;
        }
    }

    public void a(String str, String str2) {
        try {
            SharedPreferences.Editor editorB = b();
            editorB.putString(str, str2);
            editorB.apply();
        } catch (Exception e) {
        }
    }

    public void a(String str, Long l) {
        try {
            SharedPreferences.Editor editorB = b();
            editorB.putLong(str, l.longValue());
            editorB.apply();
        } catch (Exception e) {
        }
    }

    public void a(String str, int i) {
        try {
            SharedPreferences.Editor editorB = b();
            editorB.putInt(str, i);
            editorB.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public void d(String str) {
        try {
            SharedPreferences.Editor editorB = b();
            editorB.remove(str);
            editorB.apply();
        } catch (Exception e) {
        }
    }
}
