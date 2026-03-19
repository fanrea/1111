package com.ss.ttffmpeg;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class FFmpegLibLoaderWrapper {
    private static final String TAG = "FFmpegLibLoaderWrapper";
    private static boolean isVcnverifyload = false;
    private static volatile boolean sHasLoadFFmpeg = false;
    private static volatile IFFmpegLoader sIFFmpegLoader;
    private static volatile IVerifyLoader sIFFmpegVerifyLoader;

    public static synchronized boolean loadFFmpeg() {
        if (sIFFmpegLoader != null) {
            sHasLoadFFmpeg = sIFFmpegLoader.loadFFmpeg();
        } else {
            if (sHasLoadFFmpeg) {
                return true;
            }
            try {
                System.loadLibrary("ttcrypto");
                System.loadLibrary("ttboringssl");
                System.loadLibrary(BuildConfig.FFMPEG_LIBNAME);
                sHasLoadFFmpeg = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "load ffmpeg lib failed " + e.getMessage());
            }
        }
        return true;
    }

    public static synchronized void setFFmpegLoader(IFFmpegLoader iFFmpegLoader) {
        sIFFmpegLoader = iFFmpegLoader;
    }

    public static synchronized void setFFmpegVerifyLoader(IVerifyLoader iVerifyLoader) {
        sIFFmpegVerifyLoader = iVerifyLoader;
    }

    public static synchronized String getFFmpegVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static List<String> getFFmpegLibs() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add("ttcrypto");
            arrayList.add("ttboringssl");
            arrayList.add(BuildConfig.FFMPEG_LIBNAME);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static synchronized boolean tryLoadVcnverifylib() {
        boolean z = true;
        if (isVcnverifyload) {
            return true;
        }
        if (sIFFmpegVerifyLoader != null) {
            boolean zLoadVerifyLib = sIFFmpegVerifyLoader.loadVerifyLib();
            isVcnverifyload = zLoadVerifyLib;
            return zLoadVerifyLib;
        }
        try {
            System.loadLibrary("ttmverify");
        } catch (UnsatisfiedLinkError e) {
            Log.e("ttmverify", "Can't load ttmverify library: " + e);
            try {
                System.loadLibrary("ttmverifylite");
                Log.e("ttmverifylite", "load ttmverifylite library suc");
                CustomVerify.init();
            } catch (UnsatisfiedLinkError e2) {
                Log.e("ttmverifylite", "Can't load ttmverifylite library: " + e2);
                z = false;
            }
        }
        isVcnverifyload = z;
        return z;
    }
}
