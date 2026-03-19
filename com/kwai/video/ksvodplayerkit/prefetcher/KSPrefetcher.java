package com.kwai.video.ksvodplayerkit.prefetcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.Hodor;
import com.kwai.video.hodor.HodorConfig;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.hodor_debug_tools.debuginfo.HodorDebugInfoView;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCommonInitConfig;
import com.kwai.video.ksvodplayerkit.KSVodPlayerConfig;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSPrefetcher {
    private static final int MAX_CACHE_PREFETCH_INFO_SIZE = 200;
    private static final String SDK_NAME = "KSDownloaderKit";
    private static final String TAG = "KSVodPrefetcher";
    private Context mContext;
    private HodorDebugInfoView mHodorDebugInfoView;
    private PrefetcherNetworkChangeReceiver mPrefetcherNetworkChangeReceiver;
    private Thread mSecondPreloadCheckThread;
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private final Object mReportLock = new Object();
    private final Semaphore mSecondPreloadSemaphore = new Semaphore(0);
    private AtomicBoolean mSecondCheckThreadExit = new AtomicBoolean(false);
    private KSPrefetcherConfig mConfig = KSVodPlayerConfig.get().getPrefetcherConfig();
    private Map<String, PrefetchReportInfo> mPrefetchReportMap = new LinkedHashMap(200);
    private List<BasePrefetchModel> mRunningPrefetchQueue = new ArrayList();
    private List<BasePrefetchModel> mSecondPrefetchQueue = new ArrayList();
    private HashMap<String, Integer> mRunningPrefetchMap = new HashMap<>();

    private void initNetworkChangeReceiver(Context context) {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Holder {
        private static KSPrefetcher sKsVodPrefecther = new KSPrefetcher();

        private Holder() {
        }
    }

    public static KSPrefetcher getInstance() {
        return Holder.sKsVodPrefecther;
    }

    protected KSPrefetcher() {
    }

    public void init(Context context) {
        AtomicBoolean atomicBoolean = this.mInited;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            this.mContext = context;
            HodorConfig.setPreloadV3VodBufferLowRatio(this.mConfig.vodBufferLowRatio);
            HodorConfig.setPreloadV3VodCacheKbThresholdWhenPrepare(this.mConfig.vodCacheKbThresholdKb);
            HodorConfig.setPreloadV3VodPausePreloadMaxCountDueToBufferLow(this.mConfig.vodPausePreloadMaxCount);
            initNetworkChangeReceiver(this.mContext);
            this.mInited.set(true);
        }
    }

    public int addTask(BasePrefetchModel basePrefetchModel) {
        if (basePrefetchModel == null) {
            return -1;
        }
        if (!KSVodPlayerCommonInitConfig.isSoLoadCompleted()) {
            KSVodLogger.e(TAG, "mediaPlayer so not had load " + basePrefetchModel.getVideoId());
            return -1;
        }
        if (basePrefetchModel instanceof AdaptivePrefetchModel) {
            ((AdaptivePrefetchModel) basePrefetchModel).setContext(this.mContext);
        }
        if (this.mHodorDebugInfoView != null && KSVodPlayerConfig.get().isEnableDebugInfo()) {
            this.mHodorDebugInfoView.setVisibility(0);
            this.mHodorDebugInfoView.startTimer();
        }
        int iSubmit = submit(basePrefetchModel.getTask(), basePrefetchModel);
        synchronized (this.mReportLock) {
            String str = basePrefetchModel.mCacheKey;
            if (iSubmit == 0 && str != null && !str.isEmpty()) {
                if (this.mRunningPrefetchMap.get(str) != null) {
                    KSVodLogger.d(TAG, "had same task  task, videoID = " + basePrefetchModel.getVideoId());
                    return -1;
                }
                checkRunningTaskLimit();
                KSVodLogger.d(TAG, "add hodor task, videoID = " + basePrefetchModel.getVideoId() + ", isSecondRoundPreload：" + basePrefetchModel.mIsSecondPreload);
                this.mRunningPrefetchQueue.add(basePrefetchModel);
                this.mRunningPrefetchMap.put(str, 1);
            } else {
                KSVodLogger.e(TAG, "add hodor task error, videoID = " + basePrefetchModel.getVideoId() + ", isSecondRoundPreload：" + basePrefetchModel.mIsSecondPreload);
            }
            return iSubmit;
        }
    }

    public void pauseAllTasks() {
        KSVodLogger.d(TAG, "pause all tasks");
        Hodor.instance().pauseAllTasksOfGroupName(SDK_NAME);
    }

    public void resumeAllTasks() {
        KSVodLogger.d(TAG, "resume all tasks");
        Hodor.instance().resumeAllTasksOfGroupName(SDK_NAME);
    }

    private KSPrefetcherConfig getPrefetchConfig() {
        return KSVodPlayerConfig.get().getPrefetcherConfig();
    }

    void checkRunningTaskLimit() {
        this.mConfig = getPrefetchConfig();
        List<BasePrefetchModel> list = this.mRunningPrefetchQueue;
        if (list == null || list.size() <= this.mConfig.queueLimit - 1) {
            return;
        }
        KSVodLogger.d(TAG, "out of running task limit, prepare remove some task,max limit = " + this.mConfig.queueLimit + " current running queue length：" + this.mRunningPrefetchQueue.size());
        Collections.sort(this.mRunningPrefetchQueue, KSPrefetcher$$Lambda$1.instance);
        int size = this.mRunningPrefetchQueue.size() - 1;
        if (size >= 0) {
            BasePrefetchModel basePrefetchModel = this.mRunningPrefetchQueue.get(size);
            basePrefetchModel.getTask().cancel();
            removeTaskFromQueue(basePrefetchModel);
            KSVodLogger.d(TAG, "out of running task limit, remove task, videoId = " + basePrefetchModel.getVideoId());
        }
        KSVodLogger.d(TAG, "out of running task limit, end remove some task,max limit = " + this.mConfig.getQueueLimit() + " current running queue length：" + this.mRunningPrefetchQueue.size());
    }

    static /* synthetic */ int lambda$checkRunningTaskLimit$0(BasePrefetchModel basePrefetchModel, BasePrefetchModel basePrefetchModel2) {
        return basePrefetchModel2.getPriority() - basePrefetchModel.getPriority();
    }

    public void removePrefetchModel(BasePrefetchModel basePrefetchModel) {
        if (basePrefetchModel == null || basePrefetchModel.getTask() == null) {
            return;
        }
        KSVodLogger.d(TAG, "remove task" + basePrefetchModel.mVideoId);
        basePrefetchModel.getTask().cancel();
        synchronized (this.mReportLock) {
            if (this.mRunningPrefetchQueue != null) {
                removeTaskFromQueue(basePrefetchModel);
            }
        }
    }

    public void removeAll() {
        KSVodLogger.d(TAG, "prepare remove all task");
        Hodor.instance().cancelAllTasksOfGroupName(SDK_NAME);
        HodorDebugInfoView hodorDebugInfoView = this.mHodorDebugInfoView;
        if (hodorDebugInfoView != null) {
            hodorDebugInfoView.stopTimer();
        }
        synchronized (this.mReportLock) {
            if (this.mRunningPrefetchQueue != null) {
                for (int i = 0; i < this.mRunningPrefetchQueue.size(); i++) {
                    KSVodLogger.d(TAG, "remove task videoId = " + this.mRunningPrefetchQueue.get(i).getVideoId());
                }
                this.mRunningPrefetchQueue.clear();
            }
            HashMap<String, Integer> map = this.mRunningPrefetchMap;
            if (map != null) {
                map.clear();
            }
            List<BasePrefetchModel> list = this.mSecondPrefetchQueue;
            if (list != null) {
                list.clear();
            }
        }
        KSVodLogger.d(TAG, "end remove all task");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int submit(AbstractHodorPreloadTask abstractHodorPreloadTask, BasePrefetchModel basePrefetchModel) {
        String cacheKey;
        this.mConfig = getPrefetchConfig();
        if (abstractHodorPreloadTask == null) {
            return -1;
        }
        boolean z = abstractHodorPreloadTask instanceof VodAdaptivePreloadPriorityTask;
        if (z) {
            long preloadDurationMs = getPreloadDurationMs(basePrefetchModel.mIsSecondPreload);
            if (preloadDurationMs <= 0) {
                KSVodLogger.d(TAG, "Invalid preload durationMs, not submit task");
                return -1;
            }
            KSVodLogger.d(TAG, "submit - set preloadDurationMs = " + preloadDurationMs + " is sencond round preload = " + basePrefetchModel.mIsSecondPreload);
            ((VodAdaptivePreloadPriorityTask) abstractHodorPreloadTask).setPreloadDurationMs(preloadDurationMs);
        } else if (abstractHodorPreloadTask instanceof MediaPreloadPriorityTask) {
            long preloadBytes = getPreloadBytes(basePrefetchModel.mIsSecondPreload);
            KSVodLogger.d(TAG, "submit - set preloadBytes = " + preloadBytes + " is sencond round preload = " + basePrefetchModel.mIsSecondPreload);
            if (preloadBytes <= 0) {
                KSVodLogger.d(TAG, "Invalid preload size, not submit task");
                return -1;
            }
            ((MediaPreloadPriorityTask) abstractHodorPreloadTask).setPreloadBytes(preloadBytes);
        }
        KSVodLogger.d(TAG, "submit task：" + basePrefetchModel.mVideoId + ", priority：" + basePrefetchModel.getPriority() + ", isSecondRoundPreload：" + basePrefetchModel.mIsSecondPreload);
        abstractHodorPreloadTask.setAwesomeCacheCallback(new DownloadCallback(basePrefetchModel));
        abstractHodorPreloadTask.setPriority(basePrefetchModel.getPriority());
        abstractHodorPreloadTask.setMaxSpeedKbps(this.mConfig.maxSpeedKbps);
        abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.mConfig.speedKbpsThreshold);
        abstractHodorPreloadTask.setBizType(TAG);
        abstractHodorPreloadTask.setGroupName(SDK_NAME);
        abstractHodorPreloadTask.submit();
        if (z) {
            cacheKey = ((VodAdaptivePreloadPriorityTask) abstractHodorPreloadTask).getCacheKey();
        } else {
            cacheKey = abstractHodorPreloadTask instanceof MediaPreloadPriorityTask ? ((MediaPreloadPriorityTask) abstractHodorPreloadTask).mCacheKey : "";
        }
        basePrefetchModel.mCacheKey = cacheKey;
        return 0;
    }

    private long getPreloadBytes(boolean z) {
        this.mConfig = getPrefetchConfig();
        int adaptiveNetType = NetworkUtils.getAdaptiveNetType(this.mContext);
        KSVodLogger.d(TAG, "getPreloadBytes - current network type = " + adaptiveNetType);
        if (adaptiveNetType == 1) {
            if (!z) {
                return this.mConfig.preloadBytesWifi;
            }
            if (this.mConfig.secondPreloadBytesWifi <= 0 || this.mConfig.secondPreloadBytesWifi <= this.mConfig.preloadBytesWifi) {
                return -1L;
            }
            return this.mConfig.secondPreloadBytesWifi;
        }
        if (!z) {
            return this.mConfig.preloadBytes4G;
        }
        if (this.mConfig.secondPreloadBytes4G <= 0 || this.mConfig.secondPreloadBytes4G <= this.mConfig.preloadBytes4G) {
            return -1L;
        }
        return this.mConfig.secondPreloadBytes4G;
    }

    private long getPreloadDurationMs(boolean z) {
        int i;
        this.mConfig = getPrefetchConfig();
        int adaptiveNetType = NetworkUtils.getAdaptiveNetType(this.mContext);
        KSVodLogger.d(TAG, "getPreloadDurationMs - current network type = " + adaptiveNetType);
        if (adaptiveNetType == 1) {
            if (z) {
                if (this.mConfig.secondPreloadMsWifi <= 0 || this.mConfig.secondPreloadMsWifi <= this.mConfig.preloadMsWifi) {
                    return -1L;
                }
                i = this.mConfig.secondPreloadMsWifi;
            } else {
                i = this.mConfig.preloadMsWifi;
            }
        } else if (z) {
            if (this.mConfig.secondPreloadMs4G <= 0 || this.mConfig.secondPreloadMs4G <= this.mConfig.preloadMs4G) {
                return -1L;
            }
            i = this.mConfig.secondPreloadMs4G;
        } else {
            i = this.mConfig.preloadMs4G;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTaskNeedSecondRoundPreloadWhenProgress(BasePrefetchModel basePrefetchModel, AcCallBackInfo acCallBackInfo) {
        synchronized (this.mReportLock) {
            if (basePrefetchModel != null || acCallBackInfo != null) {
                if (acCallBackInfo.taskState == 1 && !basePrefetchModel.mIsSecondPreload && basePrefetchModel.mPreloadType == 0) {
                    basePrefetchModel.mIsSecondPreload = true;
                    this.mSecondPrefetchQueue.add(basePrefetchModel);
                    createSecondCheckThread();
                }
            }
        }
        checkNeedStartSecondRoundPreload();
    }

    private void createSecondCheckThread() {
        if (this.mSecondPreloadCheckThread == null) {
            SecondPreloadRoundThread secondPreloadRoundThread = new SecondPreloadRoundThread();
            this.mSecondPreloadCheckThread = secondPreloadRoundThread;
            secondPreloadRoundThread.setName("KSVodPlayerSecondPreloadThread");
            this.mSecondPreloadCheckThread.start();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class SecondPreloadRoundThread extends Thread {
        private SecondPreloadRoundThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            super.run();
            while (KSPrefetcher.this.mSecondCheckThreadExit != null && !KSPrefetcher.this.mSecondCheckThreadExit.get()) {
                try {
                    if (KSPrefetcher.this.mSecondPreloadSemaphore != null) {
                        try {
                            KSPrefetcher.this.mSecondPreloadSemaphore.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            KSPrefetcher.this.mSecondCheckThreadExit.set(true);
                        }
                    }
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    synchronized (KSPrefetcher.this.mReportLock) {
                        if (KSPrefetcher.this.mRunningPrefetchQueue != null && KSPrefetcher.this.mRunningPrefetchQueue.size() == 0 && KSPrefetcher.this.mSecondPrefetchQueue != null && KSPrefetcher.this.mSecondPrefetchQueue.size() > 0) {
                            Iterator it = KSPrefetcher.this.mSecondPrefetchQueue.iterator();
                            while (it.hasNext()) {
                                KSPrefetcher.this.addTask((BasePrefetchModel) it.next());
                            }
                            KSPrefetcher.this.mSecondPrefetchQueue.clear();
                        }
                    }
                } catch (NullPointerException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    private void checkTaskNeedSecondRoundPreloadWhenDownloadFinish(BasePrefetchModel basePrefetchModel, AcCallBackInfo acCallBackInfo) {
        synchronized (this.mReportLock) {
            if (basePrefetchModel != null && acCallBackInfo != null) {
                if ((acCallBackInfo.stopReason == 3 || acCallBackInfo.stopReason == 4 || acCallBackInfo.stopReason == 1 || acCallBackInfo.stopReason == 8) && !basePrefetchModel.mIsSecondPreload && basePrefetchModel.mPreloadType == 0) {
                    basePrefetchModel.mIsSecondPreload = true;
                    this.mSecondPrefetchQueue.add(basePrefetchModel);
                    createSecondCheckThread();
                }
            }
        }
        checkNeedStartSecondRoundPreload();
    }

    private void checkNeedStartSecondRoundPreload() {
        List<BasePrefetchModel> list;
        Semaphore semaphore;
        synchronized (this.mReportLock) {
            List<BasePrefetchModel> list2 = this.mRunningPrefetchQueue;
            if (list2 != null && list2.size() == 0 && (list = this.mSecondPrefetchQueue) != null && list.size() > 0 && (semaphore = this.mSecondPreloadSemaphore) != null) {
                semaphore.release();
            }
        }
    }

    public PrefetchReportInfo getReportInfoByVideoId(String str) {
        PrefetchReportInfo prefetchReportInfo = new PrefetchReportInfo();
        if (str != null) {
            synchronized (this.mReportLock) {
                if (this.mPrefetchReportMap.containsKey(str)) {
                    prefetchReportInfo = this.mPrefetchReportMap.get(str);
                }
            }
        }
        return prefetchReportInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTaskFromQueue(BasePrefetchModel basePrefetchModel) {
        if (basePrefetchModel == null) {
            return;
        }
        this.mRunningPrefetchQueue.remove(basePrefetchModel);
        String cacheKey = basePrefetchModel.getCacheKey();
        if (cacheKey == null || cacheKey.isEmpty()) {
            return;
        }
        this.mRunningPrefetchMap.remove(cacheKey);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class DownloadCallback extends AwesomeCacheCallback {
        private BasePrefetchModel mPrefetchModel;

        DownloadCallback(BasePrefetchModel basePrefetchModel) {
            this.mPrefetchModel = basePrefetchModel;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            if (acCallBackInfo == null || this.mPrefetchModel == null) {
                return;
            }
            KSVodLogger.d(KSPrefetcher.TAG, this.mPrefetchModel.mVideoId + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString() + ", isSecondRoundPreload：" + this.mPrefetchModel.mIsSecondPreload);
            if (acCallBackInfo.taskState == 1) {
                synchronized (KSPrefetcher.this.mReportLock) {
                    KSPrefetcher.this.removeTaskFromQueue(this.mPrefetchModel);
                }
            }
            KSPrefetcher.this.checkTaskNeedSecondRoundPreloadWhenProgress(this.mPrefetchModel, acCallBackInfo);
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) throws JSONException {
            if (this.mPrefetchModel == null) {
                return;
            }
            int i = acCallBackInfo.stopReason;
            if (i == 1 || i == 2) {
                KSVodLogger.d(KSPrefetcher.TAG, this.mPrefetchModel.mVideoId + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                KSPrefetcher.this.logPrefetchEvent(acCallBackInfo, this.mPrefetchModel);
                return;
            }
            if (acCallBackInfo.stopReason == 3) {
                if (!NetworkUtils.isNetworkConnected(KSPrefetcher.this.mContext)) {
                    KSVodLogger.d(KSPrefetcher.TAG, this.mPrefetchModel.mVideoId + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                    KSPrefetcher.this.logPrefetchEvent(acCallBackInfo, this.mPrefetchModel);
                    return;
                }
                if (KSPrefetcher.this.submit(this.mPrefetchModel.switchNextAndGetTask(), this.mPrefetchModel) < 0) {
                    KSVodLogger.d(KSPrefetcher.TAG, this.mPrefetchModel.mVideoId + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                    KSPrefetcher.this.logPrefetchEvent(acCallBackInfo, this.mPrefetchModel);
                    KSVodLogger.e(KSPrefetcher.TAG, "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url failed!");
                    return;
                }
                KSVodLogger.e(KSPrefetcher.TAG, "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url success!");
            }
        }
    }

    public void setPrefetchDebugInfoView(HodorDebugInfoView hodorDebugInfoView) {
        this.mHodorDebugInfoView = hodorDebugInfoView;
        if (hodorDebugInfoView == null || !KSVodPlayerConfig.get().isEnableDebugInfo()) {
            return;
        }
        this.mHodorDebugInfoView.setVisibility(0);
        this.mHodorDebugInfoView.startTimer();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class PrefetcherNetworkChangeReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }

        private PrefetcherNetworkChangeReceiver() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPrefetchEvent(AcCallBackInfo acCallBackInfo, BasePrefetchModel basePrefetchModel) throws JSONException {
        if (acCallBackInfo == null || acCallBackInfo.cdnStatJson == null || basePrefetchModel == null) {
            return;
        }
        addPrefetchReport(acCallBackInfo, basePrefetchModel);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qos", acCallBackInfo.cdnStatJson);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rank", basePrefetchModel.getRetryCount());
            jSONObject2.put("video_id", basePrefetchModel.getVideoId());
            jSONObject2.put("resource_type", "prefetch_video");
            jSONObject.put("stats", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        KSVodPlayerLogUploader.logCdnStatJson(jSONObject.toString());
    }

    private void addPrefetchReport(AcCallBackInfo acCallBackInfo, BasePrefetchModel basePrefetchModel) {
        this.mConfig = getPrefetchConfig();
        if (acCallBackInfo == null || basePrefetchModel == null || basePrefetchModel.getVideoId() == null) {
            return;
        }
        int i = 0;
        PrefetchReportInfo prefetchReportInfo = new PrefetchReportInfo(acCallBackInfo.stopReason == 1, acCallBackInfo.currentUri, acCallBackInfo.contentLength, acCallBackInfo.downloadBytes);
        synchronized (this.mReportLock) {
            removeTaskFromQueue(basePrefetchModel);
            KSVodLogger.d(TAG, "task had complete, remove from running queue, videoId = " + basePrefetchModel.getVideoId() + "max running queue limit " + this.mConfig.getQueueLimit() + "current length = " + this.mRunningPrefetchQueue.size());
            if (this.mPrefetchReportMap.size() >= this.mConfig.getTaskLimit()) {
                KSVodLogger.d(TAG, "out of completed task limit, prepare remove some task,max limit = " + this.mConfig.getTaskLimit() + "current queue length：" + this.mPrefetchReportMap.size());
                Iterator<Map.Entry<String, PrefetchReportInfo>> it = this.mPrefetchReportMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
                KSVodLogger.d(TAG, "out of completed task limit, end remove some task,max limit = " + this.mConfig.getTaskLimit() + "current queue length：" + this.mPrefetchReportMap.size());
            }
            this.mPrefetchReportMap.put(basePrefetchModel.getVideoId(), prefetchReportInfo);
        }
        checkTaskNeedSecondRoundPreloadWhenDownloadFinish(basePrefetchModel, acCallBackInfo);
    }
}
