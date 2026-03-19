package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c2 {
    public static Pair<Integer, Integer> a(ADSize aDSize, Context context) {
        if (aDSize.getWidth() <= 0 && aDSize.getWidth() != -1) {
            GDTLogger.w("宽度必须大于0或者为ADSize.FULL_WIDTH，已将广告宽度调整为ADSize.FULL_WIDTH", null);
        }
        if (aDSize.getHeight() <= 0 && aDSize.getHeight() != -2) {
            GDTLogger.w("高度必须大于0或者为ADSize.AUTO_HEIGHT，已经广告高度调整为ADSize.AUTO_HEIGHT", null);
        }
        int iB = yu.b(context, yu.c(context));
        int iB2 = yu.b(context, yu.a(context));
        int width = aDSize.getWidth() <= 0 ? iB : aDSize.getWidth();
        int iMax = Math.max(aDSize.getHeight(), 0);
        if (width <= iB) {
            iB = width;
        }
        if (iMax <= iB2) {
            iB2 = iMax;
        }
        return new Pair<>(Integer.valueOf(iB), Integer.valueOf(iB2));
    }
}
