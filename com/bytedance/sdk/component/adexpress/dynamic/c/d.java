package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(".") > 0) {
            return sb.append(str).toString();
        }
        return sb.append(str).append(PictureMimeType.PNG).toString();
    }
}
