package com.tk.core.e.b;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j extends com.tk.core.e.a.c {
    public String ahT;

    public final void cy(String str) {
        this.ahT = str;
    }

    @Override // com.tk.core.e.a.c, com.tk.core.e.a.b
    public final void n(HashMap<String, Object> map) {
        super.n(map);
        float fJ = J(map.get("beginX"));
        float fJ2 = J(map.get("beginY"));
        float fJ3 = J(map.get("endX"));
        float fJ4 = J(map.get("endY"));
        float fJ5 = J(map.get("velocityX"));
        float fJ6 = J(map.get("velocityY"));
        if (fJ - fJ3 > 120.0f && Math.abs(fJ5) > 0.0f) {
            this.ahT = com.baidu.mobads.container.util.animation.j.d;
            return;
        }
        if (fJ3 - fJ > 120.0f && Math.abs(fJ5) > 0.0f) {
            this.ahT = com.baidu.mobads.container.util.animation.j.e;
            return;
        }
        if (fJ2 - fJ4 > 120.0f && Math.abs(fJ6) > 0.0f) {
            this.ahT = "up";
        } else {
            if (fJ4 - fJ2 <= 120.0f || Math.abs(fJ6) <= 0.0f) {
                return;
            }
            this.ahT = "down";
        }
    }

    private static float J(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return 0.0f;
    }
}
