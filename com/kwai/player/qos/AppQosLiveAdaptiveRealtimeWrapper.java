package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppQosLiveAdaptiveRealtimeWrapper {
    private static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION_SEC = 2;
    private static final int DEFAULT_MONITOR_INTERVAL = 1000;
    private final AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    private AppQosLiveAdaptiveRealtime mAppQosLiveAdaptiveRealtime;
    private final boolean mEnable;
    private boolean mEnableAdditinalQosFlag;
    private Object mLiveAdaptiveQosObject = new Object();
    private long mLiveAdaptiveQosTickDuration = 2000;
    private IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    private long mStartTsMs;

    public AppQosLiveAdaptiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    public void start() {
        if (this.mEnable) {
            this.mStartTsMs = System.currentTimeMillis();
            startLiveAdaptiveQosStatTimer();
        }
    }

    public void stop() {
        if (this.mEnable) {
            stopLiveAdaptiveQosStatTimer();
        }
    }

    public void setEnableLiveAdaptiveAdditionalQosStat(boolean z) {
        this.mEnableAdditinalQosFlag = z;
    }

    public void setTickDurationMs(long j) {
        if (j <= 0) {
            return;
        }
        this.mLiveAdaptiveQosTickDuration = j;
    }

    public void setOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
    }

    private synchronized void startLiveAdaptiveQosStatTimer() {
        if (this.mAppQosLiveAdaptiveRealtime != null) {
            return;
        }
        AppQosLiveAdaptiveRealtime appQosLiveAdaptiveRealtime = new AppQosLiveAdaptiveRealtime(1000L, this.mLiveAdaptiveQosTickDuration, this.mAppLiveReatimeInfoProvider, this.mLiveAdaptiveQosObject);
        this.mAppQosLiveAdaptiveRealtime = appQosLiveAdaptiveRealtime;
        appQosLiveAdaptiveRealtime.setPlayStartTime(this.mStartTsMs);
        this.mAppQosLiveAdaptiveRealtime.setEnableLiveAdaptiveAdditionalQosStat(this.mEnableAdditinalQosFlag);
        this.mAppQosLiveAdaptiveRealtime.startReport(this.mOnLiveAdaptiveQosStatListener);
    }

    private synchronized void stopLiveAdaptiveQosStatTimer() {
        AppQosLiveAdaptiveRealtime appQosLiveAdaptiveRealtime = this.mAppQosLiveAdaptiveRealtime;
        if (appQosLiveAdaptiveRealtime == null) {
            return;
        }
        appQosLiveAdaptiveRealtime.stopReport();
        this.mAppQosLiveAdaptiveRealtime = null;
    }
}
