package com.qq.e.comm.plugin;

import android.view.View;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g4 {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        int iB = yu.b(view.getContext(), view.getWidth());
        int iB2 = yu.b(view.getContext(), view.getHeight());
        int i = 1;
        boolean z = iB2 < 48;
        boolean z2 = iB == 0 || ((float) iB2) / ((float) iB) > 0.32f;
        if (z || z2) {
            if (z && z2) {
                i = 3;
            } else if (!z) {
                i = z2 ? 2 : 0;
            }
            GDTLogger.e("您传入的Banner广告容器尺寸不符合要求，可能影响广告展示样式，请按Demo中规范调整！");
            b10.a(1050020, null, Integer.valueOf(i));
        }
    }
}
