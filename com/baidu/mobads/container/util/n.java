package com.baidu.mobads.container.util;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class n {
    public static String a = "";
    public static String b = "";

    public static Bitmap a() {
        if (!TextUtils.isEmpty(a)) {
            return ah.a(a);
        }
        return com.component.b.a.a().b("ic_white_logo_gray_bg");
    }

    public static Bitmap b() {
        if (!TextUtils.isEmpty(b)) {
            return ah.a(b);
        }
        return com.component.b.a.a().b("ic_white_ad_gray_bg");
    }

    public static Bitmap c() {
        return com.component.b.a.a().b("ic_white_bqt_gray_bg");
    }
}
