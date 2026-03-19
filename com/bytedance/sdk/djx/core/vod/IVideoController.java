package com.bytedance.sdk.djx.core.vod;

import android.graphics.Bitmap;
import com.bytedance.sdk.djx.model.ThumbM;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IVideoController {
    public static final int PLAYER_STATE_ERROR = 3;
    public static final int PLAYER_STATE_PAUSED = 2;
    public static final int PLAYER_STATE_PLAYING = 1;
    public static final int PLAYER_STATE_STOPPED = 0;

    Bitmap doScreenShot();

    int getBufferedPercentage();

    long getCurrentPosition();

    long getDuration();

    int getPlayerState();

    String getSRErrorMsg();

    float getSpeed();

    List<ThumbM> getThumbList();

    int[] getVideoSize();

    long getWatchedDuration();

    boolean isMute();

    boolean isPlaying();

    boolean isSRMode();

    void pause();

    void replay(boolean z);

    void seekTo(long j);

    void setMute(boolean z);

    void setRotation(float f);

    void setScreenScaleType(int i);

    void setSpeed(float f);

    void setStartTime(int i);

    void start();
}
