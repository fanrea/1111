package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ao {
    private static final String a = "PluginLoader";
    private static ClassLoader b;

    public interface a {
        void a();
    }

    public static void a(double d, an.b bVar, a aVar) {
        u uVar = (u) c.a().a(c.a.a).a();
        if (uVar != null) {
            uVar.startLoadRemotePhp(d, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static boolean a() {
        return cn.d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        u uVar;
        if (!a()) {
            return classLoader;
        }
        if (b == null && (uVar = (u) c.a().a(c.a.a).a()) != null) {
            b = uVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return b;
    }

    public static void a(Context context, String str, String str2) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(context, str, str2);
        }
    }

    public static void a(w wVar) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(wVar);
        }
    }

    public static void a(int i) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(i);
        }
    }

    public static void b(int i) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.b(i);
        }
    }

    public static void a(int i, boolean z) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(i, z);
        }
    }

    public static void b() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.b();
        }
    }

    public static View a(Context context) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            return vVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(context, str);
        }
    }

    public static Activity c() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            return vVar.c();
        }
        return null;
    }

    public static boolean d() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            return vVar.d();
        }
        return false;
    }

    public static boolean e() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            return vVar.e();
        }
        return false;
    }

    public static boolean f() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            return vVar.f();
        }
        az.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.g();
        }
    }

    public static void a(boolean z) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(z);
        }
    }

    public static void a(int i, int i2) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.b(i, i2);
        }
    }

    public static void b(int i, int i2) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(i, i2);
        }
    }

    public static void h() {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a();
        }
    }

    public static void a(boolean z, int i, int i2, int i3) {
        v vVar = (v) c.a().a(c.a.b).a();
        if (vVar != null) {
            vVar.a(z, i, i2, i3);
        }
    }
}
