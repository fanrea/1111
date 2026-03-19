package com.kwad.components.core.u;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.z;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static boolean tv() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean e(Activity activity) {
        return tv() && (activity.getWindow().getDecorView().getSystemUiVisibility() & SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE) == 1280 && !com.kwad.sdk.c.a.a.i(activity);
    }

    public static void a(Activity activity, int i, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a(activity, i, z, true);
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (tv()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static void b(Activity activity, int i, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Window window = activity.getWindow();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE;
        if (i2 >= 21) {
            if (z && Build.VERSION.SDK_INT >= 23) {
                i3 = 9472;
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                if (bc.apq()) {
                    a(activity, true);
                } else if (bc.apr()) {
                    n.b(activity, true);
                }
            }
            window.getDecorView().setSystemUiVisibility(i3);
            window.setStatusBarColor(i);
            window.setNavigationBarColor(window.getNavigationBarColor());
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
        }
    }

    private static boolean a(Activity activity, boolean z) {
        try {
            int iIntValue = ((Integer) z.ax("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            z.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
