package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.alipay.sdk.m.l.a;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerWrapper implements IKSVodPlayer {
    private CacheListener mCacheSessionListener;
    private Context mContext;
    private KwaiPlayerDebugInfoView mDebugView;
    private IKSVodPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IKSVodPlayer.OnErrorListener mOnErrorListener;
    private IKSVodPlayer.OnEventListener mOnEventListener;
    private IKSVodPlayer.OnPreparedListener mOnPreparedListener;
    private KSVodPlayer mPlayer;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private KSVodVideoContext mVideoContext;
    private IKSVodPlayer.OnVideoSizeChangedListener mVideoSizeChangedListener;
    private boolean mLooping = true;
    private float mLeftVolume = -1.0f;
    private float mRightVolume = -1.0f;
    private float mSpeed = -1.0f;

    public KSVodPlayerWrapper(Context context) {
        this.mContext = context;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setDataSource(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.mContext);
        kSVodPlayerBuilder.setExtraHeaders(map);
        kSVodPlayerBuilder.setStartOnPrepared(false);
        if (str.contains("adaptationSet") && !str.startsWith(a.r)) {
            kSVodPlayerBuilder.setKwaiManifestV2(str);
        } else {
            kSVodPlayerBuilder.setDataSource(str);
        }
        KSVodPlayer kSVodPlayerBuild = kSVodPlayerBuilder.build();
        this.mPlayer = kSVodPlayerBuild;
        kSVodPlayerBuild.enableAegon(true);
        Surface surface = this.mSurface;
        if (surface != null) {
            this.mPlayer.setSurface(surface);
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            this.mPlayer.setDisplay(surfaceHolder);
        }
        float f = this.mLeftVolume;
        if (f != -1.0f) {
            float f2 = this.mRightVolume;
            if (f2 != -1.0f) {
                this.mPlayer.setVolume(f, f2);
            }
        }
        this.mPlayer.setLooping(this.mLooping);
        KSVodVideoContext kSVodVideoContext = this.mVideoContext;
        if (kSVodVideoContext != null) {
            this.mPlayer.updateVideoContext(kSVodVideoContext);
        }
        float f3 = this.mSpeed;
        if (f3 != -1.0f) {
            this.mPlayer.setSpeed(f3);
        }
        this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
        this.mPlayer.setOnEventListener(this.mOnEventListener);
        this.mPlayer.setOnErrorListener(this.mOnErrorListener);
        this.mPlayer.setVideoSizeChangedListener(this.mVideoSizeChangedListener);
        this.mPlayer.setCacheSessionListener(this.mCacheSessionListener);
        this.mPlayer.setBufferingUpdateListener(this.mOnBufferingUpdateListener);
        KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView = this.mDebugView;
        if (kwaiPlayerDebugInfoView != null) {
            this.mPlayer.setVodDebugView(kwaiPlayerDebugInfoView);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public int prepareAsync() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.prepareAsync();
        }
        return -1;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setSurface(Surface surface) {
        this.mSurface = surface;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setSurface(surface);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean isPlaying() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean isPrepared() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.isPrepared();
        }
        return false;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public long getCurrentPosition() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public long getDuration() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public String getCurrentPlayUrl() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.getCurrentPlayUrl();
        }
        return null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void start() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.start();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void seekTo(long j) {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.seekTo(j);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setLooping(boolean z) {
        this.mLooping = z;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setLooping(z);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVolume(float f, float f2) {
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setVolume(f, f2);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void enableAegon(boolean z) {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.enableAegon(z);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void updateVideoContext(KSVodVideoContext kSVodVideoContext) {
        this.mVideoContext = kSVodVideoContext;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.updateVideoContext(kSVodVideoContext);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public IKwaiMediaPlayer getKwaiMediaPlayer() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.getKwaiMediaPlayer();
        }
        return null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void pause() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.pause();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void stop() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.stop();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean retryPlayback() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            return kSVodPlayer.retryPlayback();
        }
        return false;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void releaseAsync(IKSVodPlayer.OnVodPlayerReleaseListener onVodPlayerReleaseListener) {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.releaseAsync(onVodPlayerReleaseListener);
        }
        this.mPlayer = null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void releaseAsync(boolean z, IKSVodPlayer.OnVodPlayerReleaseListener onVodPlayerReleaseListener) {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.releaseAsync(z, onVodPlayerReleaseListener);
        }
        this.mPlayer = null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnPreparedListener(IKSVodPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setOnPreparedListener(onPreparedListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnEventListener(IKSVodPlayer.OnEventListener onEventListener) {
        this.mOnEventListener = onEventListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setOnEventListener(onEventListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnErrorListener(IKSVodPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setOnErrorListener(onErrorListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVideoSizeChangedListener(IKSVodPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mVideoSizeChangedListener = onVideoSizeChangedListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setCacheSessionListener(CacheListener cacheListener) {
        this.mCacheSessionListener = cacheListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setCacheSessionListener(cacheListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setBufferingUpdateListener(IKSVodPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVodDebugView(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        this.mDebugView = kwaiPlayerDebugInfoView;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setVodDebugView(kwaiPlayerDebugInfoView);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void removeVodDebugView() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.removeVodDebugView();
        }
        this.mDebugView = null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setSpeed(float f) {
        this.mSpeed = f;
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer != null) {
            kSVodPlayer.setSpeed(f);
        }
    }

    public void reset() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer == null) {
            KSVodLogger.w("Player is null");
            return;
        }
        IKwaiMediaPlayer kwaiMediaPlayer = kSVodPlayer.getKwaiMediaPlayer();
        if (kwaiMediaPlayer == null) {
            KSVodLogger.w("kwaiMediaPlayer is null");
        } else {
            kwaiMediaPlayer.reset();
        }
    }

    public int getAudioSessionId() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer == null) {
            KSVodLogger.w("Player is null");
            return 0;
        }
        IKwaiMediaPlayer kwaiMediaPlayer = kSVodPlayer.getKwaiMediaPlayer();
        if (kwaiMediaPlayer == null) {
            KSVodLogger.w("kwaiMediaPlayer is null");
            return 0;
        }
        return kwaiMediaPlayer.getAudioSessionId();
    }

    public void setWakeMode(Context context, int i) {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer == null) {
            KSVodLogger.w("Player is null");
            return;
        }
        IKwaiMediaPlayer kwaiMediaPlayer = kSVodPlayer.getKwaiMediaPlayer();
        if (kwaiMediaPlayer == null) {
            KSVodLogger.w("kwaiMediaPlayer is null");
        } else {
            kwaiMediaPlayer.setWakeMode(context, i);
        }
    }

    public int getVideoWidth() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer == null) {
            KSVodLogger.w("Player is null");
            return 0;
        }
        IKwaiMediaPlayer kwaiMediaPlayer = kSVodPlayer.getKwaiMediaPlayer();
        if (kwaiMediaPlayer == null) {
            KSVodLogger.w("kwaiMediaPlayer is null");
            return 0;
        }
        return kwaiMediaPlayer.getVideoWidth();
    }

    public int getVideoHeight() {
        KSVodPlayer kSVodPlayer = this.mPlayer;
        if (kSVodPlayer == null) {
            KSVodLogger.w("Player is null");
            return 0;
        }
        IKwaiMediaPlayer kwaiMediaPlayer = kSVodPlayer.getKwaiMediaPlayer();
        if (kwaiMediaPlayer == null) {
            KSVodLogger.w("kwaiMediaPlayer is null");
            return 0;
        }
        return kwaiMediaPlayer.getVideoHeight();
    }
}
