package com.ss.ttm.player;

import android.media.AudioTrack;

/* compiled from: AudioTrackPool.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class AudioTrackBuffer {
    AudioTrack AudioTrack;
    int audioFormat;
    int channelsLayout;
    int contentType;
    int sampleRate;
    int sessionId;
    int streamType;
    int trackBufferSize;

    public AudioTrackBuffer(AudioTrack audioTrack, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.AudioTrack = audioTrack;
        this.streamType = i;
        this.sampleRate = i2;
        this.channelsLayout = i3;
        this.audioFormat = i4;
        this.trackBufferSize = i5;
        this.sessionId = i6;
        this.contentType = i7;
    }
}
