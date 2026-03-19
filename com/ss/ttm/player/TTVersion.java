package com.ss.ttm.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTVersion {
    public static final boolean ENABLE_AUDIO_EFFECT = false;
    public static final boolean ENABLE_BORINGSSL = true;
    public static final boolean ENABLE_EXT_LIBYUV = false;
    public static final boolean ENABLE_EXT_SSL = false;
    public static final boolean ENABLE_SHARED_FFMPEG = true;
    public static final int VERSION = 1;
    public static final String VERSION_INFO = "2024-06-24 03:52:49";
    public static final String VERSION_NAME = "2.10.172.201-tob";

    public static void saveVersionInfo() {
        TTPlayerConfiger.setValue(15, "2024-06-24 03:52:49");
        TTPlayerConfiger.setValue(13, 1);
        TTPlayerConfiger.setValue(14, "2.10.172.201-tob");
    }
}
