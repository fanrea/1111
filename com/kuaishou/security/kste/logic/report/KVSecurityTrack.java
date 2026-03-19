package com.kuaishou.security.kste.logic.report;

import androidx.exifinterface.media.ExifInterface;
import ms.bz.bd.c.Pgl.pblu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVSecurityTrack {
    public static final String KGUARD_TRACKER_KEY = "kguard_tracker_key";
    private static boolean bEnableTrack = false;
    private static IKSecurityTrackCallback delegateCb;

    public interface IKSecurityTrackCallback {
        long getAppStartTime();

        long getHomeStartTime();

        int getLaunchSource();

        String getSessionId();

        boolean isAppOnForeground();

        boolean isColdStart();

        void log(LEVEL level, String str, String str2, Throwable th);

        void logsdkReport(String str, String str2);
    }

    public enum LEVEL {
        VERBOSE(2, ExifInterface.GPS_MEASUREMENT_INTERRUPTED),
        DEBUG(3, "D"),
        INFO(4, "I"),
        WARN(5, ExifInterface.LONGITUDE_WEST),
        ERROR(6, ExifInterface.LONGITUDE_EAST),
        ASSERT(7, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);

        final int level;
        final String levelString;

        LEVEL(int i, String str) {
            this.level = i;
            this.levelString = str;
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getLevelString() {
            return this.levelString;
        }
    }

    public static void d(String str, String str2) {
        log(LEVEL.DEBUG, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        log(LEVEL.DEBUG, str, str2, th);
    }

    public static void e(String str, String str2) {
        log(LEVEL.ERROR, str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        log(LEVEL.ERROR, str, str2, th);
    }

    public static IKSecurityTrackCallback getDelegateCb() {
        IKSecurityTrackCallback iKSecurityTrackCallback = delegateCb;
        return iKSecurityTrackCallback == null ? new IKSecurityTrackCallback() { // from class: com.kuaishou.security.kste.logic.report.KVSecurityTrack.1
            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final long getAppStartTime() {
                return 99999L;
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final long getHomeStartTime() {
                return 99999L;
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final int getLaunchSource() {
                return pblu.COLLECT_MODE_DEFAULT;
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final String getSessionId() {
                return "default_sessionid";
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final boolean isAppOnForeground() {
                return false;
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final boolean isColdStart() {
                return false;
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final void log(LEVEL level, String str, String str2, Throwable th) {
            }

            @Override // com.kuaishou.security.kste.logic.report.KVSecurityTrack.IKSecurityTrackCallback
            public final void logsdkReport(String str, String str2) {
            }
        } : iKSecurityTrackCallback;
    }

    public static void i(String str, String str2) {
        log(LEVEL.INFO, str, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        log(LEVEL.INFO, str, str2, th);
    }

    public static boolean isbEnableTrack() {
        return bEnableTrack;
    }

    private static void log(LEVEL level, String str, String str2, Throwable th) {
        if (getDelegateCb() != null) {
            getDelegateCb().log(level, str, str2, th);
        }
    }

    public static void setDelegate(IKSecurityTrackCallback iKSecurityTrackCallback) {
        delegateCb = iKSecurityTrackCallback;
    }

    public static void setbEnableTrack(boolean z) {
        bEnableTrack = z;
    }

    public static void v(String str, String str2) {
        log(LEVEL.VERBOSE, str, str2, null);
    }

    public static void v(String str, String str2, Throwable th) {
        log(LEVEL.VERBOSE, str, str2, th);
    }

    public static void w(String str, String str2) {
        log(LEVEL.WARN, str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        log(LEVEL.WARN, str, str2, th);
    }

    public static void w(String str, Throwable th) {
        log(LEVEL.WARN, null, str, th);
    }
}
