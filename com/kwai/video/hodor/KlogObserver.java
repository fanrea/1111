package com.kwai.video.hodor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KlogObserver {
    public static final int kLevelAll = 0;
    public static final int kLevelDebug = 0;
    public static final int kLevelError = 3;
    public static final int kLevelInfo = 1;
    public static final int kLevelNone = 4;
    public static final int kLevelWarn = 2;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class KlogParam {
        public String filePath;
        public int logLevel = 0;
        public boolean isConsoleEnable = true;
        public boolean isFileEnable = false;
        public int maxFileSize = 5242880;
        public int maxFileNum = 3;
        public KlogObserver logCb = null;
        public long nativeLogFunctionPtr = 0;
    }

    void onLog(int i, byte[] bArr);
}
