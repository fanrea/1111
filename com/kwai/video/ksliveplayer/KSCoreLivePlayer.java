package com.kwai.video.ksliveplayer;

import android.view.Surface;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSCoreLivePlayer {

    public interface OnTickQosListener {
        void onTick(KwaiQosInfo kwaiQosInfo);
    }

    public interface OnUrlSwitchListener {
        void onRunOutOfUrls();

        void onUrlSwitch(UrlSwitchInfo urlSwitchInfo);
    }

    public static class UrlSwitchInfo {
        public long mEmptyDataDurationMs;
        public long mLastBufferEmptyDurationMs;
        public int mSwitchReason;
    }

    int getCurrentLiveAdaptiveIndex();

    IKwaiMediaPlayer getKwaiMediaPlayer();

    KSLiveManifest getLiveManifestDetail();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void prepareAsync();

    void refreshDataManifest(String str, boolean z);

    void refreshDataSource(String str, boolean z);

    void refreshMultiPlayUrls(List<String> list, boolean z);

    void release();

    void releaseAsync();

    void restart();

    void setLiveAdaptiveSwitchIndex(int i);

    void setOnCompletedListener(IMediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void setOnLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener);

    void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener);

    void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener);

    void setOnLogEventListener(IMediaPlayer.OnLogEventListener onLogEventListener);

    void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void setOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener);

    void setOnTickQosListener(OnTickQosListener onTickQosListener);

    void setOnUrlSwitchListener(OnUrlSwitchListener onUrlSwitchListener);

    void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();
}
