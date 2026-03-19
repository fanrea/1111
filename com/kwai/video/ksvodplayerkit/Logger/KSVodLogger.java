package com.kwai.video.ksvodplayerkit.Logger;

import android.util.Log;
import com.kwai.video.player.KlogObserver;
import com.kwai.video.player.KsMediaPlayer;
import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodLogger {
    private static final String IJKTAG = "KwaiMediaPlayer";
    private static final String TAG = "ksvodplayer";
    private static KSVodDebugLogger sDebugLogger = null;
    private static boolean sIsOpen = true;

    public static void setDebugLogger(KSVodDebugLogger kSVodDebugLogger) {
        sDebugLogger = kSVodDebugLogger;
        initKwaiPlayerLog();
    }

    private static void initKwaiPlayerLog() {
        KlogObserver.KlogParam klogParam = new KlogObserver.KlogParam();
        klogParam.logCb = new KlogObserver() { // from class: com.kwai.video.ksvodplayerkit.Logger.KSVodLogger.1
            @Override // com.kwai.video.player.KlogObserver
            public final void onLog(int i, byte[] bArr) {
                try {
                    String str = new String(bArr, "UTF-8");
                    if (KSVodLogger.sDebugLogger != null) {
                        if (i == 0) {
                            KSVodLogger.sDebugLogger.d(KSVodLogger.IJKTAG, str, null);
                            return;
                        }
                        if (i == 1) {
                            KSVodLogger.sDebugLogger.i(KSVodLogger.IJKTAG, str, null);
                        } else if (i != 2) {
                            KSVodLogger.sDebugLogger.e(KSVodLogger.IJKTAG, str, null);
                        } else {
                            KSVodLogger.sDebugLogger.w(KSVodLogger.IJKTAG, str, null);
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };
        klogParam.logLevel = 1;
        klogParam.isConsoleEnable = true;
        KsMediaPlayer.setKlogParam(klogParam);
    }

    public static void setOpen(boolean z) {
        sIsOpen = z;
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void v(String str, Throwable th) {
        v(TAG, str, th);
    }

    public static void v(String str, String str2, Throwable th) {
        KSVodDebugLogger kSVodDebugLogger;
        if (sIsOpen && (kSVodDebugLogger = sDebugLogger) != null) {
            try {
                kSVodDebugLogger.v(str, str2, th);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, Throwable th) {
        d(TAG, str, th);
    }

    public static void d(String str, String str2, Throwable th) {
        KSVodDebugLogger kSVodDebugLogger;
        if (sIsOpen && (kSVodDebugLogger = sDebugLogger) != null) {
            try {
                kSVodDebugLogger.d(str, str2, th);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void i(String str, Throwable th) {
        i(TAG, str, th);
    }

    public static void i(String str, String str2, Throwable th) {
        KSVodDebugLogger kSVodDebugLogger;
        if (sIsOpen && (kSVodDebugLogger = sDebugLogger) != null) {
            try {
                kSVodDebugLogger.i(str, str2, th);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void w(String str) {
        w(TAG, str, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, Throwable th) {
        w(TAG, str, th);
    }

    public static void w(String str, String str2, Throwable th) {
        KSVodDebugLogger kSVodDebugLogger;
        if (sIsOpen && (kSVodDebugLogger = sDebugLogger) != null) {
            try {
                kSVodDebugLogger.w(str, str2, th);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void e(String str) {
        e(TAG, str, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, Throwable th) {
        e(TAG, str, th);
    }

    public static void e(String str, String str2, Throwable th) {
        KSVodDebugLogger kSVodDebugLogger;
        if (sIsOpen && (kSVodDebugLogger = sDebugLogger) != null) {
            try {
                kSVodDebugLogger.e(str, str2, th);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }
}
