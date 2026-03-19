package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppQosLiveRealtime {
    private static final String TAG = "AppQosLiveRealtime";
    private static final boolean VERBOSE = false;
    private MetricMonitor mMetricMonitor;
    private long mMoniterintervalMs;
    IMediaPlayer.OnQosStatListener mOnQosStatListener;
    private Object mQosObject;
    private AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    private final long mReportIntervalMs;
    private Timer timer;
    private TimerTask timerTask;
    private long lastSampleTime = 0;
    private long lastLiveRecordTime = 0;
    private long mTickStartTime = 0;
    private boolean mStarted = false;
    private volatile boolean mIsFirstQosStatReport = true;
    private volatile boolean mIsLastQosStatReport = false;

    public AppQosLiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        this.mMoniterintervalMs = j;
        this.mReportIntervalMs = j2;
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
        this.mQosObject = obj;
        this.mMetricMonitor = new MetricMonitor(appLiveReatimeInfoProvider);
    }

    public void startReport(IMediaPlayer.OnQosStatListener onQosStatListener) {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnQosStatListener = onQosStatListener;
        this.mTickStartTime = System.currentTimeMillis();
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.kwai.player.qos.AppQosLiveRealtime.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - AppQosLiveRealtime.this.lastSampleTime;
                AppQosLiveRealtime.this.lastSampleTime = jCurrentTimeMillis;
                AppQosLiveRealtime.this.mMetricMonitor.sample(j);
                long j2 = jCurrentTimeMillis - AppQosLiveRealtime.this.lastLiveRecordTime;
                if (j2 >= AppQosLiveRealtime.this.mReportIntervalMs) {
                    AppQosLiveRealtime.this.uploadReport(j2);
                    AppQosLiveRealtime.this.lastLiveRecordTime = jCurrentTimeMillis;
                    AppQosLiveRealtime.this.mMetricMonitor.clear();
                }
            }
        };
        this.timerTask = timerTask;
        Timer timer = this.timer;
        long j = this.mMoniterintervalMs;
        timer.schedule(timerTask, j, j);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lastSampleTime = jCurrentTimeMillis;
        this.lastLiveRecordTime = jCurrentTimeMillis;
    }

    public void stopReport() {
        if (this.mStarted) {
            this.mStarted = false;
            TimerTask timerTask = this.timerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.timerTask = null;
            }
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
            this.mIsLastQosStatReport = true;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastSampleTime;
            this.lastSampleTime = jCurrentTimeMillis;
            this.mMetricMonitor.sample(j);
            uploadReport(jCurrentTimeMillis - this.lastLiveRecordTime);
            this.lastLiveRecordTime = jCurrentTimeMillis;
            this.mMetricMonitor.clear();
        }
    }

    public void uploadReport(long j) {
        if (this.mRealtimeInfoProvider.isMediaPlayerValid()) {
            JSONObject qosStatistics = getQosStatistics(j);
            IMediaPlayer.OnQosStatListener onQosStatListener = this.mOnQosStatListener;
            if (onQosStatListener != null && qosStatistics != null) {
                onQosStatListener.onQosStat(this.mRealtimeInfoProvider, qosStatistics);
            }
            this.mTickStartTime = System.currentTimeMillis();
        }
    }

    public JSONObject getQosStatistics(long j) {
        synchronized (this.mQosObject) {
            int i = this.mIsFirstQosStatReport ? 1 : 0;
            int i2 = this.mIsLastQosStatReport ? 1 : 0;
            if (this.mIsFirstQosStatReport) {
                this.mIsFirstQosStatReport = false;
            }
            String liveRealTimeQosJson = this.mRealtimeInfoProvider.getLiveRealTimeQosJson(i, i2, this.mTickStartTime, j, this.mReportIntervalMs);
            if (liveRealTimeQosJson != null) {
                try {
                    return new JSONObject(liveRealTimeQosJson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
