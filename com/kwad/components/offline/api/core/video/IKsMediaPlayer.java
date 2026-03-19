package com.kwad.components.offline.api.core.video;

import android.view.Surface;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IKsMediaPlayer {
    void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void clear();

    boolean getAlphaVideoValid();

    int getBufferPercentage();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    long getDuration();

    int getMaxVolume();

    IMediaPlayer getMediaPlayer();

    int getMediaPlayerType();

    long getPlayDuration();

    String getStateString(int i);

    int getVideoHeight();

    int getVideoWidth();

    int getVolume();

    void initMediaPlayer(PlayVideoInfo playVideoInfo, IKsMediaPlayerView iKsMediaPlayerView);

    void initMediaPlayer(PlayVideoInfo playVideoInfo, boolean z, boolean z2, IKsMediaPlayerView iKsMediaPlayerView);

    boolean isPlaying();

    boolean isPrepared();

    boolean isPreparing();

    void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i, int i2);

    void onPlayStateChanged(int i);

    boolean pause();

    void prepareAsync();

    void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener);

    void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void release();

    void release(ReleaseCallback releaseCallback);

    void release(ReleaseCallback releaseCallback, boolean z);

    void releaseAsync();

    void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void resetAndPlay(PlayVideoInfo playVideoInfo);

    void restart();

    void resume();

    void seekTo(long j);

    void setAudioEnabled(boolean z);

    void setDataSource(PlayVideoInfo playVideoInfo);

    void setForceGetAudioFocus(boolean z);

    void setIsAlphaVideoPlayer(boolean z);

    void setRadius(float f, float f2, float f3, float f4);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setTKPlayer();

    void setVideoAdaptStrategy(int i);

    void setVolume(float f, float f2);

    void start();

    void start(long j);

    void stopAndPrepareAsync();

    void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams);
}
