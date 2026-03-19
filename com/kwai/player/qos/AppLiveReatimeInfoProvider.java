package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface AppLiveReatimeInfoProvider extends IMediaPlayer {
    AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo();

    long getAudioCachedDuration();

    String getCurPlayingUrl();

    @Deprecated
    String getKflvVideoPlayingUrl();

    String getKwaiSign();

    String getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3);

    String getServerAddress();

    String getStreamId();

    KwaiQosInfo getStreamQosInfo();

    long getVideoCachedDuration();

    String getXksCache();

    boolean isLiveManifest();

    boolean isMediaPlayerValid();
}
