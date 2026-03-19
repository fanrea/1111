package com.kwai.middleware.azeroth.utils;

import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SampleUtils {
    private static final Random sRandom = new Random(System.currentTimeMillis());

    private SampleUtils() {
    }

    public static boolean sample(float f) {
        return f >= 1.0f || sRandom.nextFloat() < f;
    }
}
