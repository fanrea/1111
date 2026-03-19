package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.MultiRate.VodAdaptationAzerothModel;
import com.kwai.video.ksvodplayerkit.MultiRate.VodAdaptationAzerothModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcherConfig;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcherConfig_JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerConfig {
    public static final int MAX_CACHE_BYTES = 157286400;
    private static final String TAG = "KSVodPlayerConfig";
    private Config mCurrentConfig;
    private Config mLastConfig;
    private volatile boolean mParseSuccess;

    public boolean isEnableDebugInfo() {
        return true;
    }

    private KSVodPlayerConfig() {
        this.mLastConfig = new Config();
        this.mParseSuccess = false;
    }

    public static KSVodPlayerConfig get() {
        return Holder.INSTANCE;
    }

    public void setConfigJsonStr(String str) {
        String str2;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
            str2 = "vodLowDevice";
        } catch (JSONException e) {
            str2 = "vodLowDevice";
            KSVodLogger.e(TAG, "ERROR!  Config JSONException:" + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null) {
            KSVodLogger.e(TAG, "ERROR!  Config is null");
            return;
        }
        this.mParseSuccess = false;
        this.mCurrentConfig = new Config();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.mCurrentConfig.maxCacheBytes = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.mCurrentConfig.recordHistory = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.mCurrentConfig.maxBufferCostMs = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.mCurrentConfig.startPlayBlockBufferMs = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.mCurrentConfig.socketBufferSizeKB = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.mCurrentConfig.maxRetryCount = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.mCurrentConfig.enableAsync = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.mCurrentConfig.preloadDuration = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.mCurrentConfig.enableHostSort = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.mCurrentConfig.enableH264HW = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.mCurrentConfig.enableH265HW = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.mCurrentConfig.lowDevice = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.mCurrentConfig.vodAdaptationAzerothModel = VodAdaptationAzerothModel_JsonUtils.fromJson(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.mCurrentConfig.enableDebugInfo = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.mCurrentConfig.cacheDownloadConnectTimeoutMs = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.mCurrentConfig.cacheDownloadReadTimeoutMs = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.mCurrentConfig.prefetcherConfig = KSPrefetcherConfig_JsonUtils.fromJson(jSONObject.getString("prefetcherConfig"));
            }
            if (jSONObject.has("useKS265Decoder")) {
                this.mCurrentConfig.useKS265Decoder = jSONObject.getBoolean("useKS265Decoder");
            }
            this.mParseSuccess = true;
            this.mLastConfig = this.mCurrentConfig;
        } catch (JSONException e2) {
            this.mCurrentConfig = null;
            this.mParseSuccess = false;
            KSVodLogger.e(TAG, "setConfigJsonStr exception:" + e2.getMessage());
        }
    }

    private Config getConfig() {
        Config config;
        if (this.mParseSuccess && (config = this.mCurrentConfig) != null) {
            return config;
        }
        if (this.mLastConfig == null) {
            this.mLastConfig = new Config();
        }
        return this.mLastConfig;
    }

    int getMaxCacheBytes() {
        int i = getConfig().maxCacheBytes;
        return i <= 0 ? MAX_CACHE_BYTES : i;
    }

    boolean isRecordHistory() {
        return getConfig().recordHistory;
    }

    int getStartPlayBlockBufferMs() {
        return getConfig().startPlayBlockBufferMs;
    }

    int getMaxBufferCostMs() {
        return getConfig().maxBufferCostMs;
    }

    public int getMaxRetryCount() {
        return getConfig().maxRetryCount;
    }

    int getPreloadDuration() {
        return getConfig().preloadDuration;
    }

    boolean isEnableH264HW() {
        return getConfig().enableH264HW;
    }

    boolean isEnableH265HW() {
        return getConfig().enableH265HW;
    }

    boolean isEnableAsync() {
        return getConfig().enableAsync;
    }

    public boolean isEnableHostSort() {
        return getConfig().enableHostSort;
    }

    public String getVodAdaptive() {
        VodAdaptationAzerothModel vodAdaptationAzerothModel = getConfig().vodAdaptationAzerothModel;
        if (vodAdaptationAzerothModel == null) {
            vodAdaptationAzerothModel = new VodAdaptationAzerothModel();
        }
        return vodAdaptationAzerothModel.getVodAdaptiveJson();
    }

    public int isLowDevice() {
        return getConfig().lowDevice;
    }

    int getSocketBufferSizeKB() {
        return getConfig().socketBufferSizeKB;
    }

    int getCacheDownloadConnectTimeoutMs() {
        return getConfig().cacheDownloadConnectTimeoutMs;
    }

    int getCacheDownloadReadTimeoutMs() {
        return getConfig().cacheDownloadReadTimeoutMs;
    }

    int getBufferedDataSourceSizeKB() {
        return getConfig().bufferedDataSourceSizeKB;
    }

    int getMaxBufferTimeBspMs() {
        return getConfig().maxBufferTimeBspMs;
    }

    long getPreloadThreshold() {
        return getConfig().prefetcherConfig.playerLoadThreshold;
    }

    public boolean isUseKS265Decoder() {
        return getConfig().useKS265Decoder;
    }

    public KSPrefetcherConfig getPrefetcherConfig() {
        return getConfig().prefetcherConfig;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class Holder {
        private static final KSVodPlayerConfig INSTANCE = new KSVodPlayerConfig();

        private Holder() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Config {
        private int bufferedDataSourceSizeKB;
        private int cacheDownloadConnectTimeoutMs;
        private int cacheDownloadReadTimeoutMs;
        private boolean enableAsync;
        private boolean enableDebugInfo;
        private boolean enableH264HW;
        private boolean enableH265HW;
        private boolean enableHostSort;
        private int lowDevice;
        private int maxBufferCostMs;
        private int maxBufferTimeBspMs;
        private int maxCacheBytes;
        private int maxRetryCount;
        private KSPrefetcherConfig prefetcherConfig;
        private int preloadDuration;
        private boolean recordHistory;
        private int socketBufferSizeKB;
        private int startPlayBlockBufferMs;
        private boolean useKS265Decoder;
        private VodAdaptationAzerothModel vodAdaptationAzerothModel;

        private Config() {
            this.maxCacheBytes = KSVodPlayerConfig.MAX_CACHE_BYTES;
            this.recordHistory = false;
            this.startPlayBlockBufferMs = 300;
            this.maxBufferCostMs = 500;
            this.maxRetryCount = 5;
            this.socketBufferSizeKB = 256;
            this.preloadDuration = 3000;
            this.enableAsync = false;
            this.enableH264HW = false;
            this.enableH265HW = false;
            this.enableHostSort = false;
            this.lowDevice = 0;
            this.vodAdaptationAzerothModel = new VodAdaptationAzerothModel();
            this.enableDebugInfo = false;
            this.cacheDownloadConnectTimeoutMs = 3000;
            this.cacheDownloadReadTimeoutMs = 15000;
            this.bufferedDataSourceSizeKB = 32;
            this.maxBufferTimeBspMs = 3000;
            this.useKS265Decoder = false;
            this.prefetcherConfig = new KSPrefetcherConfig();
        }
    }
}
