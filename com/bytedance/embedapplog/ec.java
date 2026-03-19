package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class ec {
    static ic d(Context context) {
        if (tt.an()) {
            return new ed(new mk());
        }
        if (tt.h() && mk.d()) {
            return new mk();
        }
        if (lv.d()) {
            return new lv(context);
        }
        if (tt.b() && tt.c()) {
            return new rs();
        }
        if (tt.b() && !tt.c()) {
            return new p();
        }
        if (tt.d(context) || tt.b()) {
            return new rs();
        }
        if (tt.tt()) {
            return new ed();
        }
        if (tt.gb()) {
            return new hg();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (tt.tc()) {
                return new el();
            }
            if (tt.mq()) {
                return new gu();
            }
            if (tt.mk()) {
                return new hr();
            }
            if (tt.uo()) {
                return new r();
            }
            o oVar = new o(context);
            return oVar.d(context) ? oVar : new mb();
        }
        if (tt.u() || !rs.b(context)) {
            return null;
        }
        return new rs();
    }
}
