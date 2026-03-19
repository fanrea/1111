package com.kwad.components.offline.api.core.video;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IKsMediaPlayerView {

    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i, int i2);

    void fixWidth(boolean z);

    int getTextureViewGravity();

    void setAd(boolean z);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z);

    void setHorizontalVideo(boolean z);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f);

    void updateTextureViewGravity(int i);
}
