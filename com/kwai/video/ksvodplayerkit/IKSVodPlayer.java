package com.kwai.video.ksvodplayerkit;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IKSVodPlayer {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnErrorListener {
        void onError(int i, int i2);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnEventListener {
        void onEvent(int i, int i2);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2, int i3, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnVodPlayerReleaseListener {
        void onPlayerRelease();
    }

    void enableAegon(boolean z);

    String getCurrentPlayUrl();

    long getCurrentPosition();

    long getDuration();

    IKwaiMediaPlayer getKwaiMediaPlayer();

    boolean isPlaying();

    boolean isPrepared();

    void pause();

    int prepareAsync();

    void releaseAsync(OnVodPlayerReleaseListener onVodPlayerReleaseListener);

    void releaseAsync(boolean z, OnVodPlayerReleaseListener onVodPlayerReleaseListener);

    void removeVodDebugView();

    boolean retryPlayback();

    void seekTo(long j);

    void setBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setCacheSessionListener(CacheListener cacheListener);

    void setDataSource(String str, Map<String, String> map);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnEventListener(OnEventListener onEventListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setVodDebugView(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView);

    void setVolume(float f, float f2);

    void start();

    void stop();

    void updateVideoContext(KSVodVideoContext kSVodVideoContext);
}
