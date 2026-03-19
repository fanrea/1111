package com.bytedance.sdk.djx.core.vod.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoImmersedUtils {
    public static void enterFullScreenHideNavigation(Activity activity) {
        if (activity == null) {
            return;
        }
        enterFullScreenHideNavigation(activity.getWindow());
    }

    public static void enterFullScreenHideNavigation(Window window) {
        if (window == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 16) {
            if (hasWindowFullscreenFlag(window)) {
                return;
            }
            window.addFlags(1024);
        } else if (i < 19) {
            enterFullScreenForJellyBean(window, window.getDecorView(), 0);
        } else {
            enterFullScreenForJellyBean(window, window.getDecorView(), 2);
        }
    }

    private static void enterFullScreenForJellyBean(Window window, View view, int i) {
        if (window == null || view == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (hasWindowFullscreenFlag(window)) {
            window.clearFlags(1024);
        }
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = Build.VERSION.SDK_INT >= 19 ? FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN : 4;
        if (i != 0) {
            i2 |= i;
        }
        if (systemUiVisibility != i2) {
            view.setSystemUiVisibility(i2);
        }
    }

    private static boolean hasWindowFullscreenFlag(Window window) {
        return (window == null || window.getAttributes() == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
    }
}
