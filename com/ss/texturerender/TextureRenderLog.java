package com.ss.texturerender;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextureRenderLog {
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    private static OnLogListener mLogListener;
    private static ConcurrentHashMap<Integer, OnLogListenerExt> mLogListenerExts = new ConcurrentHashMap<>();

    public interface OnLogListener {
        int log(String str, String str2);
    }

    public interface OnLogListenerExt {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void k(String str, String str2);

        void t(String str, String str2);

        void w(String str, String str2);
    }

    public static synchronized void setOnLogListener(OnLogListener onLogListener) {
        mLogListener = onLogListener;
    }

    public static synchronized void setOnLogListenerExt(int i, OnLogListenerExt onLogListenerExt) {
        ConcurrentHashMap<Integer, OnLogListenerExt> concurrentHashMap = mLogListenerExts;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(Integer.valueOf(i), onLogListenerExt);
        }
    }

    private static void notifyListener(int i, OnLogListenerExt onLogListenerExt, String str, String str2) {
        switch (i) {
            case 1:
                onLogListenerExt.d(str, str2);
                break;
            case 2:
                onLogListenerExt.i(str, str2);
                break;
            case 3:
                onLogListenerExt.t(str, str2);
                break;
            case 4:
                onLogListenerExt.k(str, str2);
                break;
            case 5:
                onLogListenerExt.w(str, str2);
                break;
            case 6:
                onLogListenerExt.e(str, str2);
                break;
        }
    }

    private static synchronized void log(int i, int i2, String str, String str2) {
        ConcurrentHashMap<Integer, OnLogListenerExt> concurrentHashMap = mLogListenerExts;
        if (concurrentHashMap != null) {
            if (i2 == -1) {
                Iterator<OnLogListenerExt> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    notifyListener(i, it.next(), str, str2);
                }
            } else {
                OnLogListenerExt onLogListenerExt = concurrentHashMap.get(Integer.valueOf(i2));
                if (onLogListenerExt != null) {
                    notifyListener(i, onLogListenerExt, str, str2);
                }
                OnLogListenerExt onLogListenerExt2 = mLogListenerExts.get(-1);
                if (onLogListenerExt2 != null) {
                    notifyListener(i, onLogListenerExt2, str, str2);
                }
            }
        }
        OnLogListener onLogListener = mLogListener;
        if (onLogListener != null) {
            onLogListener.log(str, str2);
        }
    }

    public static void d(int i, String str, String str2) {
        log(1, i, str, str2);
    }

    public static void i(int i, String str, String str2) {
        log(2, i, str, str2);
    }

    public static void t(int i, String str, String str2) {
        log(3, i, str, str2);
    }

    public static void k(int i, String str, String str2) {
        log(4, i, str, str2);
    }

    public static void w(int i, String str, String str2) {
        log(5, i, str, str2);
    }

    public static void e(int i, String str, String str2) {
        log(6, i, str, str2);
    }
}
