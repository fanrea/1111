package com.tk.core.e.a;

import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static int m(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return 1;
        }
        if (action == 1) {
            return 3;
        }
        if (action != 2) {
            return action != 3 ? 0 : 4;
        }
        return 2;
    }
}
