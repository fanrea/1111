package com.bytedance.sdk.djx.core.vod.player;

import android.content.res.AssetFileDescriptor;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.djx.core.vod.IVideoListener;
import com.bytedance.sdk.djx.model.ThumbM;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.utils.WeakHandler;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class AbstractPlayer implements WeakHandler.IHandler {
    public static final int ERROR_LOAD = -50;
    public static final int ERROR_PLAYBACK = -51;
    public static final int INFO_LOAD_STATE_ERROR = -33;
    public static final int INFO_LOAD_STATE_PLAYABLE = -31;
    public static final int INFO_LOAD_STATE_STALLED = -32;
    public static final int INFO_LOAD_STATE_UNKNOWN = -30;
    public static final int INFO_PLAYBACK_STATE_ERROR = -43;
    public static final int INFO_PLAYBACK_STATE_PAUSED = -42;
    public static final int INFO_PLAYBACK_STATE_PLAYING = -41;
    public static final int INFO_PLAYBACK_STATE_STOPPED = -40;
    public static final int PROGRESS_TIMES = 60;
    public static final int WHAT_MSG_DURATION = 1001;
    protected WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    protected IVideoListener mVideoListener;

    public abstract int getBufferedPercentage();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract int getPlayerState();

    public abstract String getSRErrorMsg();

    public abstract float getSpeed();

    public abstract List<ThumbM> getThumbList();

    public abstract long getWatchedDuration();

    public abstract boolean hasVideoModel();

    public abstract void initPlayer();

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract boolean isSRMode();

    public abstract void pause();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(long j);

    public abstract void setDataSource(AssetFileDescriptor assetFileDescriptor);

    public abstract void setDataSource(VideoM videoM);

    public abstract void setDataSource(String str, Map<String, String> map);

    public abstract void setLooping(boolean z);

    public abstract void setMute(boolean z);

    public abstract void setOptions();

    public abstract void setSRResolution(boolean z, int i);

    public abstract void setSpeed(float f);

    public abstract void setStartTime(int i);

    public abstract void setSurface(Surface surface);

    public abstract void setSurfaceHolder(SurfaceHolder surfaceHolder);

    public abstract void setVolume(float f, float f2);

    public abstract void start();

    public abstract void stop();

    public void setPlayerEventListener(IVideoListener iVideoListener) {
        this.mVideoListener = iVideoListener;
    }

    public IVideoListener getVideoListener() {
        return this.mVideoListener;
    }
}
