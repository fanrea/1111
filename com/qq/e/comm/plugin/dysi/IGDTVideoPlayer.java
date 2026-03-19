package com.qq.e.comm.plugin.dysi;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IGDTVideoPlayer {
    public static final String EVENT_ON_VIDEO_VIEW_INIT = "event_onVideoViewInit";
    public static final String KEY_VIDEO_PLAYER = "GDTVideoPlayer";

    int currentTime();

    int duration();

    boolean isPlaying();

    void pause();

    void pauseAndLock();

    void play();

    void speed(double d);

    void stop();

    void unlockAndPlay();
}
