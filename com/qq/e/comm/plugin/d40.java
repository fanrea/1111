package com.qq.e.comm.plugin;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d40 {
    public static int a(int i) {
        if (i == 0) {
            return r1.d().f().a("serverRequestMaxVideoDuration", 301);
        }
        int iA = r1.d().f().a("video_duration_setting_min", 5);
        int iA2 = r1.d().f().a("video_duration_setting_max", 61);
        if (i < iA) {
            GDTLogger.e("setMaxVideoDuration 参数非法，maxDuration 必须在 " + iA + " 和 " + iA2 + "之间");
            return iA;
        }
        if (i <= iA2) {
            return i;
        }
        GDTLogger.e("setMaxVideoDuration 参数非法，maxDuration 必须在 " + iA + " 和 " + iA2 + "之间");
        return iA2;
    }
}
