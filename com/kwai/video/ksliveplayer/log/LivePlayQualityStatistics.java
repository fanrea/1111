package com.kwai.video.ksliveplayer.log;

import android.text.TextUtils;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.ksliveplayer.KSLivePlayerLogUploader;
import com.kwai.video.ksliveplayer.KSLiveVideoContext;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LivePlayQualityStatistics {
    private static final String TAG = "LivePlayQualityStat";
    private int mBlockCount;
    private long mBufferTime;
    private long mDropPackageTotalDuration;
    private long mFirstScreenTotalDuration;
    private long mFirstScreenTotalDurationStartTime;
    private String mHost;
    private long mLogStartTime;
    private String mPlayerQosJson;
    private int mRetryCount;
    private int mRetryReason;
    private long mStartBufferTime;
    private String mStateExtra;
    private long mTotalDuration;
    private long mTraffic;
    private long mFirstScreenDropPackageDuration = -1;
    private String mLiveStreamId = "";

    public String getHost() {
        return this.mHost;
    }

    public LivePlayQualityStatistics setHost(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(this.mHost)) {
            this.mHost = str;
        }
        return this;
    }

    public void setLiveStreamId(String str) {
        if (TextUtils.isEmpty(this.mLiveStreamId)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mLiveStreamId = str;
        }
    }

    public void logStart(KSLiveVideoContext kSLiveVideoContext) {
        this.mLogStartTime = System.currentTimeMillis();
        this.mFirstScreenTotalDurationStartTime = kSLiveVideoContext.clickTimeMs;
        if (kSLiveVideoContext == null || kSLiveVideoContext.extra == null) {
            return;
        }
        this.mStateExtra = kSLiveVideoContext.extra.toString();
    }

    public void logEnd() {
        this.mTotalDuration = System.currentTimeMillis() - this.mLogStartTime;
    }

    public void logRenderEndTimeIfNeed() {
        if (this.mFirstScreenTotalDuration > 0) {
            return;
        }
        this.mFirstScreenTotalDuration = System.currentTimeMillis() - this.mFirstScreenTotalDurationStartTime;
    }

    public LivePlayQualityStatistics setRetryCount(int i) {
        this.mRetryCount = i;
        return this;
    }

    public LivePlayQualityStatistics addRetryCount() {
        this.mRetryCount++;
        return this;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public LivePlayQualityStatistics addTraffic(long j) {
        this.mTraffic += j;
        return this;
    }

    public LivePlayQualityStatistics addBufferTime(long j) {
        this.mBufferTime += j;
        return this;
    }

    public LivePlayQualityStatistics logStartBufferTime() {
        this.mStartBufferTime = System.currentTimeMillis();
        return this;
    }

    public LivePlayQualityStatistics logEndBufferTimeThenAddIfNeed() {
        if (this.mStartBufferTime > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartBufferTime;
            this.mStartBufferTime = 0L;
            addBufferTime(jCurrentTimeMillis);
        }
        return this;
    }

    public LivePlayQualityStatistics addBlockCount(int i) {
        this.mBlockCount += i;
        return this;
    }

    public LivePlayQualityStatistics setPlayerQosJson(String str) {
        this.mPlayerQosJson = str;
        return this;
    }

    public LivePlayQualityStatistics setRetryReason(int i) {
        this.mRetryReason = i;
        return this;
    }

    public int getRetryReason() {
        return this.mRetryReason;
    }

    public LivePlayQualityStatistics fillDroppedFieldsWithStreamQosInfo(KwaiQosInfo kwaiQosInfo) {
        if (kwaiQosInfo != null) {
            if (this.mFirstScreenDropPackageDuration == -1) {
                this.mFirstScreenDropPackageDuration = kwaiQosInfo.firstScreenTimeDroppedDuration;
            }
            this.mDropPackageTotalDuration += kwaiQosInfo.totalDroppedDuration;
        }
        return this;
    }

    public void upload() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("live_stream_id", this.mLiveStreamId);
            jSONObject.put("live_stream_host", this.mHost);
            jSONObject.put("total_duration", this.mTotalDuration);
            jSONObject.put("first_screen_total_duration", this.mFirstScreenTotalDuration);
            jSONObject.put("retry_cnt", this.mRetryCount);
            jSONObject.put("traffic", this.mTraffic);
            jSONObject.put("first_screen_drop_package_duration", this.mFirstScreenDropPackageDuration);
            jSONObject.put("drop_package_total_duration", this.mDropPackageTotalDuration);
            jSONObject.put("buffer_time", this.mBufferTime);
            jSONObject.put("block_cnt", this.mBlockCount);
            jSONObject.put("player_qos_json", this.mPlayerQosJson);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("qos", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(this.mStateExtra)) {
                jSONObject3.put("stats_extra", this.mStateExtra);
            }
            jSONObject2.put("stats", jSONObject3);
            KSLivePlayerLogUploader.logEvent("VP_LIVE_PLAYER_FINISH", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
