package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aq {
    public static boolean dY(Context context) {
        Activity activityFb = com.kwad.sdk.p.m.fb(context);
        if (activityFb != null) {
            Window window = activityFb.getWindow();
            z = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void dZ(Context context) {
        Activity activityFb = com.kwad.sdk.p.m.fb(context);
        if (activityFb != null) {
            activityFb.getWindow().clearFlags(1024);
        }
    }

    public static void ea(Context context) {
        Activity activityFb = com.kwad.sdk.p.m.fb(context);
        if (activityFb != null) {
            activityFb.setRequestedOrientation(0);
        }
    }

    public static void eb(Context context) {
        Activity activityFb = com.kwad.sdk.p.m.fb(context);
        if (activityFb != null) {
            activityFb.setRequestedOrientation(1);
        }
    }

    public static boolean apb() {
        return isOrientationPortrait();
    }

    public static boolean isOrientationPortrait() {
        return ServiceProvider.anu().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static void d(Context context, boolean z) {
        try {
            Activity activityFb = com.kwad.sdk.p.m.fb(context);
            if (activityFb == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    activityFb.getWindow().getDecorView().setSystemUiVisibility(8);
                    return;
                } else {
                    activityFb.getWindow().getDecorView().setSystemUiVisibility(1792);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 19) {
                activityFb.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                activityFb.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
