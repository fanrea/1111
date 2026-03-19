package com.kwad.sdk.crash;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    public static native void init(boolean z, int i);

    public static void upload(int i, int i2, String str) {
        com.kwad.sdk.core.d.c.e(TAG, "upload: signal=" + i + ", code=" + i2 + ", nativeBacktraceStr=" + str);
    }
}
