package com.qq.e.comm.plugin.dysi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IGDTAudioPlayer {
    int currentTime();

    int duration();

    void free();

    int isPlaying();

    void pause();

    void play();

    void prepare(String str);

    @Deprecated
    void prepareAudioPlayer(String str, String str2);

    void setNumberOfLoops(int i);

    void setVolume(double d);

    void stop();
}
