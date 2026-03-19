package com.badlogic.gdx.math;

import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public static Random bx = new Random();

    public static float a(float f, float f2, float f3) {
        if (f < -1.0f) {
            return -1.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static float a(float f, float f2) {
        if (f2 == 0.0f) {
            if (f > 0.0f) {
                return 1.5707964f;
            }
            return f == 0.0f ? 0.0f : -1.5707964f;
        }
        float f3 = f / f2;
        if (Math.abs(f3) >= 1.0f) {
            float f4 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            return f < 0.0f ? f4 - 3.1415927f : f4;
        }
        float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
        if (f2 < 0.0f) {
            return f5 + (f < 0.0f ? -3.1415927f : 3.1415927f);
        }
        return f5;
    }

    public static boolean b(float f, float f2) {
        return Math.abs(f - 1.0f) <= 1.0E-6f;
    }
}
