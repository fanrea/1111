package com.bytedance.bdtracker;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdtracker.l0;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j4 {
    public static boolean a = false;
    public static Class b;
    public static Method c;
    public static boolean d = a("com.tencent.smtt.sdk.WebView");
    public static boolean e = a("android.support.v7.widget.RecyclerView");
    public static boolean f = a("android.support.v4.view.ViewPager");
    public static boolean g = a("android.support.v4.widget.SwipeRefreshLayout");
    public static boolean h;
    public static boolean i;
    public static boolean j;

    static {
        a("android.support.v4.app.Fragment");
        a("android.support.v4.app.FragmentActivity");
        a("android.support.v7.app.AlertDialog");
        a("android.support.v7.view.menu.ListMenuItemView");
        h = a("androidx.recyclerview.widget.RecyclerView");
        i = a("androidx.viewpager.widget.ViewPager");
        j = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        a("androidx.fragment.app.Fragment");
        a("androidx.fragment.app.FragmentActivity");
        a("androidx.appcompat.app.AlertDialog");
        a("androidx.appcompat.view.menu.ListMenuItemView");
    }

    public static Class<?> a(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                c = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException unused) {
            }
            if (c == null) {
                try {
                    c = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (c != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean a(View view) {
        return (view instanceof WebView) || b(view);
    }

    public static boolean a(Object obj) {
        return h && (obj instanceof RecyclerView);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(View view) {
        return d && (view instanceof com.tencent.smtt.sdk.WebView);
    }

    public static boolean b(Object obj) {
        return e && l0.b.a(obj, "android.support.v7.widget.RecyclerView");
    }

    public static boolean c(Object obj) {
        return f && l0.b.a(obj, "android.support.v4.view.ViewPager");
    }
}
