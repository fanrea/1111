package com.bytedance.msdk.api;

import android.content.Context;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    private static Toast d;

    public static void d(Context context, String str) {
        d(context, str, 0);
    }

    public static void d(Context context, String str, int i) {
        Toast toastD = d(context);
        if (toastD != null) {
            toastD.setDuration(i);
            toastD.setText(String.valueOf(str));
            toastD.show();
            return;
        }
        com.bytedance.msdk.d.u.b.hc("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static Toast d(Context context) {
        if (context == null) {
            return d;
        }
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), "", 0);
        d = toastMakeText;
        return toastMakeText;
    }
}
