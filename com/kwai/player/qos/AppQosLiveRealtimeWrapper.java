package com.kwai.player.qos;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwai.video.player.IMediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppQosLiveRealtimeWrapper {
    private static final int DEFAULT_MONITOR_INTERVAL = 1000;
    private static final int DEFAULT_QOS_TICK_DURATION_SEC = 10;
    private AppQosLiveRealtime mAppQosLiveRealtime;
    private final boolean mEnable;
    private IMediaPlayer.OnQosStatListener mOnQosStatListener;
    private final AppLiveReatimeInfoProvider mProvider;
    private long mTickDurMs = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    public AppQosLiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
        this.mProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    public void setTickDurationMs(long j) {
        if (j <= 0) {
            return;
        }
        this.mTickDurMs = j;
    }

    public void setOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mOnQosStatListener = onQosStatListener;
    }

    public void start(String str) {
        if (this.mEnable) {
            startQosStatTimer();
        }
    }

    public void stop() {
        if (this.mEnable) {
            stopQosStatTimer();
        }
    }

    private synchronized void startQosStatTimer() {
        if (this.mAppQosLiveRealtime != null) {
            return;
        }
        AppQosLiveRealtime appQosLiveRealtime = new AppQosLiveRealtime(1000L, this.mTickDurMs, this.mProvider, new Object());
        this.mAppQosLiveRealtime = appQosLiveRealtime;
        appQosLiveRealtime.startReport(this.mOnQosStatListener);
    }

    private synchronized void stopQosStatTimer() {
        AppQosLiveRealtime appQosLiveRealtime = this.mAppQosLiveRealtime;
        if (appQosLiveRealtime == null) {
            return;
        }
        appQosLiveRealtime.stopReport();
        this.mAppQosLiveRealtime = null;
    }
}
