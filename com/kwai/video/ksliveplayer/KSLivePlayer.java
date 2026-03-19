package com.kwai.video.ksliveplayer;

import android.view.Surface;
import com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSLivePlayer extends KwaiPlayerDebugInfoProvider {

    public interface OnErrorListener {
        void onError(int i, int i2);
    }

    public interface OnEventListener {
        void onEvent(int i, int i2);
    }

    public interface OnLiveDataListener {
        void onLiveData(byte[] bArr);
    }

    public interface OnLiveVoiceCommentListener {
        void onLiveVoiceComment(String str);
    }

    public interface OnPreparedListener {
        void onPrepared();
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    int getCurrentLiveAdaptiveIndex();

    KSLiveManifest getLiveManifestDetail();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void prepareAsync();

    void refreshDataManifest(String str);

    void refreshDataSource(String str);

    void release();

    void releaseAsync();

    void setLiveAdaptiveSwitchIndex(int i);

    void setLiveTextureView(LiveTextureView liveTextureView);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnEventListener(OnEventListener onEventListener);

    void setOnLiveDataListener(OnLiveDataListener onLiveDataListener);

    void setOnLiveVoiceCommentListener(OnLiveVoiceCommentListener onLiveVoiceCommentListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void setVideoScaleMode(int i);

    void setVolume(float f, float f2);

    void start();
}
