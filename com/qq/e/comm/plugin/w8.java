package com.qq.e.comm.plugin;

import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class w8 implements ol {
    w8() {
    }

    @Override // com.qq.e.comm.plugin.ol
    public void a(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                i2 = 8;
                if (i != 4) {
                    if (i == 8) {
                        i2 = 4;
                    } else if (i != 10) {
                        return;
                    } else {
                        i2 = 0;
                    }
                }
            } else {
                i2 = 1;
            }
        }
        ua.a(view, i2);
    }
}
