package com.bytedance.sdk.djx.core.vod.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.djx.model.ThumbM;
import com.bytedance.sdk.djx.model.VideoM;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AndroidPlayer extends AbstractPlayer {
    private final Context mContext;

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public int getBufferedPercentage() {
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public long getDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public int getPlayerState() {
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public String getSRErrorMsg() {
        return "";
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public float getSpeed() {
        return 0.0f;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public List<ThumbM> getThumbList() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public long getWatchedDuration() {
        return 0L;
    }

    public void handleMsg(Message message) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public boolean hasVideoModel() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void initPlayer() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public boolean isMute() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public boolean isSRMode() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void pause() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void prepareAsync() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void release() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void reset() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void seekTo(long j) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setDataSource(VideoM videoM) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setDataSource(String str, Map<String, String> map) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setLooping(boolean z) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setMute(boolean z) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setOptions() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setSRResolution(boolean z, int i) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setSpeed(float f) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setStartTime(int i) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setSurface(Surface surface) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void setVolume(float f, float f2) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void start() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.player.AbstractPlayer
    public void stop() {
    }

    public AndroidPlayer(Context context) {
        this.mContext = context;
    }
}
