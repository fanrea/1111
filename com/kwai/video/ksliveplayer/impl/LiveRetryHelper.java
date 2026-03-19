package com.kwai.video.ksliveplayer.impl;

import android.os.SystemClock;
import android.util.Log;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;
import com.kwai.video.ksliveplayer.model.LiveRetryConfigModel;
import com.kwai.video.ksliveplayer.util.AccurateTimer;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveRetryHelper {
    public static final int RETRY_END = 2;
    public static final int RETRY_START = 1;
    private static final String TAG = "LiveRetryHelper";
    private static final long TIMER_INTERVAL = 1000;
    private long mEmptyDataDurationMs;
    private boolean mEnableAutoSwitchHost;
    private IKwaiMediaPlayer mKwaiMediaPlayer;
    private long mLastBufferEmptyDurationSeconds;
    private long mLastCollectTime;
    private long mLastTickTime;
    private long mLastTotalDataSize;
    private KSCoreLivePlayer.OnTickQosListener mOnTickQosListener;
    private RetryCallback mRetryCallback;
    private LiveRetryConfigModel mRetryConfig;
    private AtomicInteger mRetryState = new AtomicInteger(0);
    private QosFetchTimer mQosFetchTimer = new QosFetchTimer(1000);

    public interface RetryCallback {
        void onRetry(KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo);
    }

    public LiveRetryHelper(IKwaiMediaPlayer iKwaiMediaPlayer) {
        this.mKwaiMediaPlayer = iKwaiMediaPlayer;
    }

    public void setEnable(boolean z) {
        IKwaiMediaPlayer iKwaiMediaPlayer;
        KwaiQosInfo streamQosInfo;
        Log.d(TAG, "setEnable: " + z);
        this.mEnableAutoSwitchHost = z;
        if (!this.mEnableAutoSwitchHost || (iKwaiMediaPlayer = this.mKwaiMediaPlayer) == null || (streamQosInfo = iKwaiMediaPlayer.getStreamQosInfo()) == null) {
            return;
        }
        this.mLastTotalDataSize = streamQosInfo.totalDataSize;
        this.mEmptyDataDurationMs = 0L;
        this.mLastBufferEmptyDurationSeconds = (long) (getBufferEmptyDuration() * 1000.0f);
    }

    public void setLiveRetryConfig(LiveRetryConfigModel liveRetryConfigModel) {
        this.mRetryConfig = liveRetryConfigModel;
    }

    public void setRetryCallback(RetryCallback retryCallback) {
        this.mRetryCallback = retryCallback;
    }

    public void setOnTickQosListener(KSCoreLivePlayer.OnTickQosListener onTickQosListener) {
        this.mOnTickQosListener = onTickQosListener;
    }

    public void handleCriticalPlayerError(int i, int i2) {
        Log.d(TAG, "handleCriticalPlayerError: what: " + i + " extra: " + i2);
        if (this.mRetryCallback != null) {
            KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo = new KSCoreLivePlayer.UrlSwitchInfo();
            urlSwitchInfo.mSwitchReason = i;
            this.mRetryCallback.onRetry(urlSwitchInfo);
        }
    }

    public void onTick(KwaiQosInfo kwaiQosInfo) {
        if (this.mLastTickTime == 0) {
            this.mLastTickTime = SystemClock.elapsedRealtime();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mLastTickTime;
        this.mLastTickTime = SystemClock.elapsedRealtime();
        KSCoreLivePlayer.OnTickQosListener onTickQosListener = this.mOnTickQosListener;
        if (onTickQosListener != null) {
            onTickQosListener.onTick(kwaiQosInfo);
        }
        if (kwaiQosInfo == null || !this.mEnableAutoSwitchHost || !this.mRetryConfig.autoSwitchCDNEnabled) {
            Log.d(TAG, "onTick enable = false");
            return;
        }
        if (this.mLastTotalDataSize == kwaiQosInfo.totalDataSize) {
            this.mEmptyDataDurationMs += jElapsedRealtime;
        } else {
            this.mEmptyDataDurationMs = 0L;
        }
        int i = 0;
        boolean z = true;
        if (this.mEmptyDataDurationMs >= this.mRetryConfig.emptyReadSizeDuration * 1000) {
            Log.d(TAG, "onTick over 10s no data");
            i = 1;
        } else if (getBufferEmptyDuration() - this.mLastBufferEmptyDurationSeconds > this.mRetryConfig.stalledDurationInOneMinute) {
            i = 2;
            Log.d(TAG, "onTick over 1 min buffer time: " + getBufferEmptyDuration());
        } else {
            z = false;
        }
        if (z && this.mRetryCallback != null) {
            Log.d(TAG, "trigger Retry");
            KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo = new KSCoreLivePlayer.UrlSwitchInfo();
            urlSwitchInfo.mSwitchReason = i;
            urlSwitchInfo.mEmptyDataDurationMs = this.mEmptyDataDurationMs;
            urlSwitchInfo.mLastBufferEmptyDurationMs = (long) ((getBufferEmptyDuration() - this.mLastBufferEmptyDurationSeconds) * 1000.0f);
            this.mRetryCallback.onRetry(urlSwitchInfo);
        }
        if (SystemClock.elapsedRealtime() - this.mLastCollectTime >= 60000) {
            this.mLastBufferEmptyDurationSeconds = (long) getBufferEmptyDuration();
            this.mLastCollectTime = SystemClock.elapsedRealtime();
        }
        this.mLastTotalDataSize = kwaiQosInfo.totalDataSize;
    }

    public void updatePlayer(IKwaiMediaPlayer iKwaiMediaPlayer) {
        this.mKwaiMediaPlayer = iKwaiMediaPlayer;
        setEnable(false);
    }

    public void start() {
        this.mQosFetchTimer.start();
    }

    public void stop() {
        this.mQosFetchTimer.stop();
    }

    public int getRetryState() {
        return this.mRetryState.get();
    }

    public void setRetryState(int i) {
        this.mRetryState.set(i);
    }

    private float getBufferEmptyDuration() {
        if (this.mKwaiMediaPlayer == null) {
            return 0.0f;
        }
        return r0.bufferEmptyDuration() / 1000.0f;
    }

    class QosFetchTimer extends AccurateTimer<KwaiQosInfo> {
        public QosFetchTimer(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.video.ksliveplayer.util.AccurateTimer
        public KwaiQosInfo prepareData(long j) {
            if (LiveRetryHelper.this.mKwaiMediaPlayer == null) {
                return null;
            }
            return LiveRetryHelper.this.mKwaiMediaPlayer.getStreamQosInfo();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.kwai.video.ksliveplayer.util.AccurateTimer
        public void run(long j, KwaiQosInfo kwaiQosInfo) {
            if (kwaiQosInfo != null) {
                LiveRetryHelper.this.onTick(kwaiQosInfo);
            }
        }
    }
}
