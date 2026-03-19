package com.component.a.f;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public enum b {
    NORMAL("normal"),
    CLICK("click"),
    LONG_CLICK("long_click"),
    DOUBLE_CLICK("double_click"),
    SHAKE("shake"),
    SLIDE(ILogConst.DRAW_ENTER_TYPE_SLIDE),
    UNKNOWN("unknown");

    private final String h;

    b(String str) {
        this.h = str;
    }

    public String b() {
        return this.h;
    }

    public static b b(String str) {
        for (b bVar : values()) {
            if (TextUtils.equals(bVar.b(), str)) {
                return bVar;
            }
        }
        return UNKNOWN;
    }
}
