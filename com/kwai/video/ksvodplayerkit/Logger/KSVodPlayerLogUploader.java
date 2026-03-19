package com.kwai.video.ksvodplayerkit.Logger;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerLogUploader {
    private static final String TAG = "LogUploader";
    private static final String VP_CDN_RESOURCE = "VP_CDN_RESOURCE";
    private static final String VP_PLAYERFINISHED = "VP_PLAYFINISHED";
    private static ILogger sLogger;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface ILogger {
        void logTaskEvent(String str, String str2);
    }

    private KSVodPlayerLogUploader() {
    }

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    public static void logQosFinished(String str) {
        logEvent(VP_PLAYERFINISHED, str);
    }

    public static void logCdnStatJson(String str) {
        logEvent(VP_CDN_RESOURCE, str);
    }

    public static void logEvent(String str, String str2) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logTaskEvent(str, str2);
        } else {
            KSVodLogger.w(TAG, "upload logger is null");
        }
    }
}
