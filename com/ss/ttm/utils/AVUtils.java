package com.ss.ttm.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVUtils {

    public static class ScaleInfo {
        public int h;
        public int w;
        public int x;
        public int y;
    }

    public static final ScaleInfo getScaleInfoFromSize(float f, float f2, float f3, float f4) {
        ScaleInfo scaleInfo = new ScaleInfo();
        float f5 = f / f2;
        scaleInfo.w = (int) f3;
        scaleInfo.h = (int) (f3 / f5);
        if (scaleInfo.h < f4) {
            scaleInfo.h = (int) f4;
            scaleInfo.w = (int) (f5 * f4);
        }
        scaleInfo.y = ((int) (scaleInfo.h - f4)) >> 1;
        scaleInfo.x = ((int) (scaleInfo.w - f3)) >> 1;
        if (scaleInfo.h > f4) {
            scaleInfo.y = 0 - scaleInfo.y;
        }
        if (scaleInfo.w > f3) {
            scaleInfo.x = 0 - scaleInfo.x;
        }
        return scaleInfo;
    }
}
