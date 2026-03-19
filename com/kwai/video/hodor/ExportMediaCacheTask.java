package com.kwai.video.hodor;

import android.text.TextUtils;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ExportMediaCacheTask extends AbstractHodorTask {
    private final String mCacheKey;
    private final String mExportFilePath;
    private ExportMediaCacheTaskCallback mExportMediaCacheTaskCallback;
    private final String mHttpHeaders;
    private final String mUrl;
    private AwesomeCacheCallback mAwesomeCacheCallback = new AwesomeCacheCallback() { // from class: com.kwai.video.hodor.ExportMediaCacheTask.1
        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            ExportMediaCacheTask.this.mTaskInfo.copyInfoInProgress(acCallBackInfo);
            ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = ExportMediaCacheTask.this.mExportMediaCacheTaskCallback;
            if (exportMediaCacheTaskCallback != null) {
                exportMediaCacheTaskCallback.onTaskStatusChanged(ExportMediaCacheTask.this.mTaskInfo);
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            ExportMediaCacheTask.this.mTaskInfo.copyInfoAfterDownload(acCallBackInfo);
            ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = ExportMediaCacheTask.this.mExportMediaCacheTaskCallback;
            if (exportMediaCacheTaskCallback != null) {
                exportMediaCacheTaskCallback.onCdnReport(ExportMediaCacheTask.this.mTaskInfo);
            }
        }
    };
    private TaskInfo mTaskInfo = new TaskInfo();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface ExportMediaCacheTaskCallback {
        void onCdnReport(TaskInfo taskInfo);

        void onTaskStatusChanged(TaskInfo taskInfo);
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class TaskInfo extends BaseTaskInfo {
        private String cacheFilePath = "";
        private boolean loadFromCache;

        public void debugPrintTaskStatus(int i, String str) {
            Timber.log(i, "%s loadFromCache:%b, complete:%b,cacheFilePath:%s", str, Boolean.valueOf(this.loadFromCache), Boolean.valueOf(isComplete()), this.cacheFilePath);
        }

        public String getCacheFilePath() {
            return this.cacheFilePath;
        }

        public boolean isLoadFromCache() {
            return this.loadFromCache;
        }
    }

    public static ExportMediaCacheTask newTaskWithHttpDns(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            map.put("Host", str2);
        }
        return new ExportMediaCacheTask(str, map, str3, str4);
    }

    public ExportMediaCacheTask(String str, Map<String, String> map, String str2, String str3) {
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
        this.mExportFilePath = str3;
        setTaskQosClass(2);
        this.mTaskInfo.cacheFilePath = str3;
        this.mTaskInfo.loadFromCache = Hodor.instance().isFullyCached(str2, 0);
    }

    public void setExportMediaCacheTaskCallback(ExportMediaCacheTaskCallback exportMediaCacheTaskCallback) {
        this.mExportMediaCacheTaskCallback = exportMediaCacheTaskCallback;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        throw new UnsupportedOperationException("not support operation, use setExportMediaCacheTaskCallback instead");
    }
}
