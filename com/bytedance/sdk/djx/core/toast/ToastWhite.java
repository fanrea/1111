package com.bytedance.sdk.djx.core.toast;

import android.os.Build;
import com.bytedance.sdk.djx.core.util.RomUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ToastWhite {
    ToastWhite() {
    }

    static boolean isWhiteList() {
        return RomUtils.isMiui() || is1707A01();
    }

    private static boolean is1707A01() {
        return RomUtils.is360OS() && "1707-A01".equals(Build.MODEL.toUpperCase());
    }
}
