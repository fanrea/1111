package com.kwad.components.core.u;

import android.app.Activity;
import android.os.Build;
import android.view.Window;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q {
    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(1024);
            window.setStatusBarColor(0);
        }
    }
}
