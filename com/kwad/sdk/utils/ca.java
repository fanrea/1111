package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ca {
    public static boolean v(View view, int i) {
        return view != null && b(view, i, true) && view.hasWindowFocus() && ed(view.getContext());
    }

    public static boolean a(View view, int i, boolean z) {
        return view != null && b(view, i, z) && ed(view.getContext());
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity activityFb = com.kwad.sdk.p.m.fb(view.getContext());
        if ((activityFb != null && activityFb.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long jHeight = r9.height() * r9.width();
            long height = view.getHeight() * view.getWidth();
            if (height > 0 && jHeight * 100 >= i * height) {
                return true;
            }
        }
        return false;
    }

    public static double m(View view, boolean z) {
        if (view == null) {
            return -1.0d;
        }
        if (!ed(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity activityFb = com.kwad.sdk.p.m.fb(view.getContext());
        if (activityFb != null && activityFb.isFinishing()) {
            return -4.0d;
        }
        if (!view.isShown() || view.getVisibility() != 0) {
            return -5.0d;
        }
        if (!view.hasWindowFocus()) {
            return -6.0d;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return -8.0d;
        }
        long jHeight = r5.height() * r5.width();
        long height = view.getHeight() * view.getWidth();
        if (height <= 0) {
            return -7.0d;
        }
        return (jHeight * 100.0d) / height;
    }

    private static boolean ed(Context context) {
        return aw.apm().ed(context);
    }
}
