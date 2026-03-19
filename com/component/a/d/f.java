package com.component.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.x;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    public static int a = 15;
    public static final int b = 0;

    public static void a(Context context) {
        a = x.a(context.getApplicationContext()).a();
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (a >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (a >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (a >= 17) {
            marginLayoutParams.setMarginStart(i);
        } else {
            marginLayoutParams.leftMargin = i;
        }
    }

    public static void b(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (a >= 17) {
            marginLayoutParams.setMarginEnd(i);
        } else {
            marginLayoutParams.rightMargin = i;
        }
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (a >= 17) {
            marginLayoutParams.resolveLayoutDirection(i);
        }
    }

    public static int a(View view) {
        if (x.a(null).a() >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }
}
