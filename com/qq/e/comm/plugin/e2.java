package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum e2 {
    SPLASH(4, 1, 3, 3),
    NATIVEEXPRESSAD(9, 1, 4, 4),
    REWARDVIDEOAD(11, 1, 5, 5),
    NATIVEUNIFIEDAD(12, 1, 6, 6),
    UNIFIED_BANNER(13, 1, 7, 7),
    UNIFIED_INTERSTITIAL(14, 2, 8, 8),
    UNIFIED_INTERSTITIAL_FULLSCREEN(22, 2, 9, 9);

    private final int a;
    private final int b;
    public final int c;
    private final int d;

    e2(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int e() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String c() {
        return String.valueOf(this.d);
    }

    public static e2 a(String str) {
        if ("splash".equals(str)) {
            return SPLASH;
        }
        if ("nativeexpressad".equals(str)) {
            return NATIVEEXPRESSAD;
        }
        if ("rewardvideoad".equals(str)) {
            return REWARDVIDEOAD;
        }
        if ("nativeunifiedad".equals(str)) {
            return NATIVEUNIFIEDAD;
        }
        if ("banner2".equals(str)) {
            return UNIFIED_BANNER;
        }
        if ("inter2".equals(str)) {
            return UNIFIED_INTERSTITIAL;
        }
        if ("inter2fs".equals(str)) {
            return UNIFIED_INTERSTITIAL_FULLSCREEN;
        }
        return null;
    }

    public boolean l() {
        return this == SPLASH;
    }

    public boolean g() {
        return this == NATIVEEXPRESSAD;
    }

    public boolean k() {
        return this == REWARDVIDEOAD;
    }

    public boolean i() {
        return this == UNIFIED_INTERSTITIAL;
    }

    public boolean h() {
        return this == UNIFIED_INTERSTITIAL_FULLSCREEN;
    }

    public boolean f() {
        return this == UNIFIED_BANNER;
    }

    public boolean j() {
        return this == NATIVEUNIFIEDAD;
    }

    public static e2 a(int i) {
        switch (i) {
            case 3:
                return SPLASH;
            case 4:
                return NATIVEEXPRESSAD;
            case 5:
                return REWARDVIDEOAD;
            case 6:
                return NATIVEUNIFIEDAD;
            case 7:
                return UNIFIED_BANNER;
            case 8:
                return UNIFIED_INTERSTITIAL;
            case 9:
                return UNIFIED_INTERSTITIAL_FULLSCREEN;
            default:
                return null;
        }
    }
}
