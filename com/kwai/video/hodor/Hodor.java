package com.kwai.video.hodor;

import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.debuginfo.model.HodorDebugInfo;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Hodor extends HodorDeprecatedApi {
    private static final int GET_DEBUG_INFO_INTERVAL_MIN_MS = 500;
    public static final int TaskType_Media = 0;
    public static final int TaskType_Resource = 1;
    private HodorDebugInfo mHodorDebugInfo = new HodorDebugInfo();
    private long mLastGetDebugInfoTsMs = 0;

    private native void getDebugInfo(HodorDebugInfo hodorDebugInfo);

    public static native int loadJavaClass();

    public native void cancelAllTasksOfGroupName(String str);

    public native void clearCacheDirectory(int i);

    public native void deleteCacheByKey(String str, int i);

    public native long getCacheBytesLimitOfDirectory(int i);

    public native long getCachedBytesOfDirectory(int i);

    public native int getRemainTaskCount();

    public native boolean isFullyCached(String str, int i);

    public native void pauseAllTasksOfGroupName(String str);

    public native void pruneStrategyNeverCacheContent(boolean z);

    public native void resumeAllTasksOfGroupName(String str);

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public void submitTask(IHodorTask iHodorTask) {
        iHodorTask.submit();
    }

    public HodorDebugInfo getDebugInfo() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastGetDebugInfoTsMs > 500) {
            getDebugInfo(this.mHodorDebugInfo);
            this.mLastGetDebugInfoTsMs = jCurrentTimeMillis;
        }
        return this.mHodorDebugInfo;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class INSTANCE_HOLDER {
        static Hodor INSTANCE = new Hodor();

        private INSTANCE_HOLDER() {
        }
    }

    public static Hodor instance() {
        return INSTANCE_HOLDER.INSTANCE;
    }
}
