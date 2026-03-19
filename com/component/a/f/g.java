package com.component.a.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public enum g {
    VISIBLE("visible"),
    INVISIBLE("invisible"),
    REMOVE("remove"),
    UNKNOWN("unknown");

    private final String e;

    g(String str) {
        this.e = str;
    }

    public String b() {
        return this.e;
    }

    public static g b(String str) {
        for (g gVar : values()) {
            if (TextUtils.equals(gVar.b(), str)) {
                return gVar;
            }
        }
        return UNKNOWN;
    }

    public void a(View view) {
        if (view == null || this == UNKNOWN) {
            return;
        }
        switch (this) {
            case VISIBLE:
                view.setVisibility(0);
                break;
            case INVISIBLE:
                view.setVisibility(4);
                break;
            case REMOVE:
                cf.b(view);
                break;
        }
    }
}
