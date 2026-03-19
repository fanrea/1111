package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static int hD() {
        return a.vg.getValue().intValue();
    }

    public static String hE() {
        return a.vk.getValue();
    }

    public static int hF() {
        return a.vh.getValue().intValue();
    }

    public static boolean hG() {
        return a.vj.getValue().booleanValue();
    }

    public static int hH() {
        return a.vi.getValue().intValue();
    }

    private static boolean hI() {
        return a.vm.getValue().intValue() == 1;
    }

    public static boolean i(AdInfo adInfo) {
        return !j(adInfo) && com.kwad.sdk.core.response.b.a.dd(adInfo) && hI();
    }

    public static boolean j(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.dd(adInfo) && a.vo.getValue().intValue() == 1;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }

    public static float hJ() {
        return a.vr.getValue().floatValue();
    }

    public static boolean hK() {
        return a.vr.getValue().floatValue() > 0.0f && a.vr.getValue().floatValue() < 1.0f;
    }

    public static boolean hL() {
        return a.vs.getValue().booleanValue();
    }

    public static long hM() {
        return a.vp.getValue().intValue();
    }

    public static int hN() {
        return a.vq.getValue().intValue();
    }

    public static int hO() {
        return a.vt.getValue().intValue();
    }

    public static boolean hP() {
        return a.vu.getValue().booleanValue();
    }

    public static boolean hQ() {
        return a.vv.getValue().intValue() == 1 || a.vv.getValue().intValue() == 3;
    }

    public static boolean hR() {
        return a.vw.getValue().booleanValue();
    }

    public static boolean hS() {
        return a.vx.getValue().booleanValue();
    }
}
