package com.luck.picture.lib.config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SelectMimeType {
    public static final String SYSTEM_ALL = "image/*,video/*";
    public static final String SYSTEM_AUDIO = "audio/*";
    public static final String SYSTEM_IMAGE = "image/*";
    public static final String SYSTEM_VIDEO = "video/*";
    public static final int TYPE_ALL = 0;
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;

    public static int ofAll() {
        return 0;
    }

    public static int ofAudio() {
        return 3;
    }

    public static int ofImage() {
        return 1;
    }

    public static int ofVideo() {
        return 2;
    }
}
