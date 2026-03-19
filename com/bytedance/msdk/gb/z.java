package com.bytedance.msdk.gb;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z {
    private static String d;

    public static boolean d() {
        return com.bytedance.msdk.d.u.b.hc() && com.bytedance.msdk.core.d.mk().yi() && com.bytedance.msdk.core.d.mk().he();
    }

    public static String d(String str) {
        try {
            if (!d()) {
                return str;
            }
            String strNp = com.bytedance.msdk.core.d.mk().np();
            if (TextUtils.isEmpty(strNp)) {
                return str;
            }
            com.bytedance.msdk.d.u.b.d("TestHelperUtils", "AnyDoorId=" + strNp);
            return Uri.parse(str).buildUpon().appendQueryParameter(hc(), strNp).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String hc() {
        if (TextUtils.isEmpty(d)) {
            d = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return d;
    }
}
