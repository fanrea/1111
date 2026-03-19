package com.kwad.sdk.live.audience.player;

import android.view.Surface;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSLivePlayerController {

    public interface BufferListener {
        void onBufferEnd();

        void onBufferStart();
    }

    public interface ErrorListener {
        void onError(int i, int i2);
    }

    public interface PreparedListener {
        void onPrepared();
    }

    public interface RenderListener {
        void onAudioRenderStart();

        void onVideoRenderStart();
    }

    public interface StateChangeListener {
        void onPlayerStateChangedListener(KSLivePlayerState kSLivePlayerState);
    }

    public interface UrlSwitchListener {
        void onRunOutOfUrls();
    }

    public interface VideoSizeListener {
        void onVideoSizeChanged(int i, int i2);
    }

    void addBufferListener(BufferListener bufferListener);

    void addErrorListener(ErrorListener errorListener);

    void addPreparedListener(PreparedListener preparedListener);

    void addRenderListener(RenderListener renderListener);

    void addUrlSwitchListener(UrlSwitchListener urlSwitchListener);

    void addVideoSizeListener(VideoSizeListener videoSizeListener);

    KSCoreLivePlayer getKSCoreLivePlayer();

    KSLivePlayerState getLivePlayerState();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void prepare();

    void release();

    void removeBufferListener(BufferListener bufferListener);

    void removeErrorListener(ErrorListener errorListener);

    void removePreparedListener(PreparedListener preparedListener);

    void removeRenderListener(RenderListener renderListener);

    void removeUrlSwitchListener(UrlSwitchListener urlSwitchListener);

    void removeVideoSizeListener(VideoSizeListener videoSizeListener);

    void resume();

    void setSurface(Surface surface);

    void setVolume(float f, float f2);
}
