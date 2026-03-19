package com.kwai.player.qos;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MetricMonitor {
    private static final String TAG = "MetricMonitor";
    private static final boolean VERBOSE = false;
    private AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public static String[] AUDIO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] AUDIO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    public static String[] VIDEO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] VIDEO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    private long[] audioBufferLenMetric = new long[AUDIO_BUFFER_LEN_FIELDS.length];
    private long[] videoBufferLenMetric = new long[VIDEO_BUFFER_LEN_FIELDS.length];

    public MetricMonitor(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider) {
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
    }

    public void recordVideoBufferLenStat(long j) {
        long videoCachedDuration = this.mRealtimeInfoProvider.getVideoCachedDuration();
        int i = 0;
        while (true) {
            if (i >= VIDEO_BUFFER_LEN_SCALE.length) {
                return;
            }
            if (videoCachedDuration >= r3[i]) {
                if (i == r3.length - 1) {
                    long[] jArr = this.videoBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (videoCachedDuration < r3[i + 1]) {
                    long[] jArr2 = this.videoBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
            i++;
        }
    }

    public void recordAudioBufferLenStat(long j) {
        long audioCachedDuration = this.mRealtimeInfoProvider.getAudioCachedDuration();
        int i = 0;
        while (true) {
            if (i >= AUDIO_BUFFER_LEN_SCALE.length) {
                return;
            }
            if (audioCachedDuration >= r3[i]) {
                if (i == r3.length - 1) {
                    long[] jArr = this.audioBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (audioCachedDuration < r3[i + 1]) {
                    long[] jArr2 = this.audioBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
            i++;
        }
    }

    public void sample(long j) {
        recordAudioBufferLenStat(j);
        recordVideoBufferLenStat(j);
    }

    public void clear() {
        for (int i = 0; i < VIDEO_BUFFER_LEN_SCALE.length; i++) {
            this.videoBufferLenMetric[i] = 0;
        }
        for (int i2 = 0; i2 < AUDIO_BUFFER_LEN_SCALE.length; i2++) {
            this.audioBufferLenMetric[i2] = 0;
        }
    }

    public JSONObject getAudioBufferLenMetric() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (true) {
            try {
                long[] jArr = this.audioBufferLenMetric;
                if (i >= jArr.length) {
                    break;
                }
                jSONObject.put(AUDIO_BUFFER_LEN_FIELDS[i], (int) jArr[i]);
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject getVideoBufferLenMetric() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (true) {
            try {
                long[] jArr = this.videoBufferLenMetric;
                if (i >= jArr.length) {
                    break;
                }
                jSONObject.put(VIDEO_BUFFER_LEN_FIELDS[i], (int) jArr[i]);
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
