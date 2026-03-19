package com.yxcorp.livestream.longconnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveStreamLogger {
    private static ILogClient sILogClient;

    public interface ILogClient {
        void debugLog(String str, String str2, Object... objArr);

        boolean isDebug();

        void log(String str, String str2, Object... objArr);
    }

    public static void inject(ILogClient iLogClient) {
        sILogClient = iLogClient;
    }

    public static void log(String str, String str2, Object... objArr) {
        ILogClient iLogClient = sILogClient;
        if (iLogClient != null) {
            iLogClient.log(str, str2, objArr);
        }
    }

    public static void debugLog(String str, String str2, Object... objArr) {
        ILogClient iLogClient = sILogClient;
        if (iLogClient != null) {
            iLogClient.debugLog(str, str2, objArr);
        }
    }

    public static boolean isDebug() {
        ILogClient iLogClient = sILogClient;
        if (iLogClient != null) {
            return iLogClient.isDebug();
        }
        return true;
    }
}
