package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoPlayerStatus extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -9021213312245598171L;
    public int mVideoPlayerBehavior = 1;
    public int mVideoPlayerType;

    public void setVideoPlayerType(int i) {
        this.mVideoPlayerType = i;
    }

    public void setVideoPlayerBehavior(int i) {
        this.mVideoPlayerBehavior = i;
    }
}
