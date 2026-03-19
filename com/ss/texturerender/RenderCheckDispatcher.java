package com.ss.texturerender;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RenderCheckDispatcher {
    private static final String TAG = "RenderCheckDispatcher";
    private ConcurrentHashMap<VideoSurfaceTexture, FrameRenderChecker> checkerMap = new ConcurrentHashMap<>();
    private volatile boolean isEnabled;
    private int mTexType;
    private final Handler msgHandler;
    private volatile int startCount;

    public RenderCheckDispatcher(Handler handler, int i) {
        this.mTexType = -1;
        this.msgHandler = handler;
        this.mTexType = i;
    }

    public void onFrameCome(VideoSurfaceTexture videoSurfaceTexture) {
        FrameRenderChecker frameRenderChecker;
        if (this.isEnabled && (frameRenderChecker = this.checkerMap.get(videoSurfaceTexture)) != null) {
            frameRenderChecker.onFrameCome();
        }
    }

    public void onDrawSucceed(VideoSurfaceTexture videoSurfaceTexture) {
        FrameRenderChecker frameRenderChecker;
        if (this.isEnabled && (frameRenderChecker = this.checkerMap.get(videoSurfaceTexture)) != null) {
            frameRenderChecker.onDrawSucceed();
        }
    }

    public void checkSurfaceTextureCallbackTime() {
        if (this.isEnabled) {
            for (Map.Entry<VideoSurfaceTexture, FrameRenderChecker> entry : this.checkerMap.entrySet()) {
                if (entry != null && entry.getValue() != null) {
                    entry.getValue().checkSurfaceTextureCallbackTime();
                }
            }
        }
    }

    public void onSurfaceTextureCallbackCalled(VideoSurfaceTexture videoSurfaceTexture) {
        FrameRenderChecker frameRenderChecker;
        if (this.isEnabled && (frameRenderChecker = this.checkerMap.get(videoSurfaceTexture)) != null) {
            frameRenderChecker.onSurfaceTextureCallbackCalled();
        }
    }

    public void setEnabled(boolean z) {
        TextureRenderLog.i(this.mTexType, TAG, "setEnabled, " + z);
        this.isEnabled = z;
    }

    public void increase(VideoSurfaceTexture videoSurfaceTexture, FrameRenderChecker frameRenderChecker) {
        if (videoSurfaceTexture != null) {
            TextureRenderLog.i(videoSurfaceTexture.texType(), TAG, "increase, VideoSurfaceTexture " + videoSurfaceTexture);
        }
        if (videoSurfaceTexture == null || frameRenderChecker == null) {
            return;
        }
        this.checkerMap.put(videoSurfaceTexture, frameRenderChecker);
        if (this.startCount == 0) {
            doStart();
        }
        this.startCount++;
    }

    private void doStart() {
        TextureRenderLog.i(this.mTexType, TAG, "doStart");
        Handler handler = this.msgHandler;
        if (handler != null) {
            handler.sendEmptyMessage(38);
        }
    }

    public void decrease(VideoSurfaceTexture videoSurfaceTexture, FrameRenderChecker frameRenderChecker) {
        if (videoSurfaceTexture != null) {
            TextureRenderLog.i(videoSurfaceTexture.texType(), TAG, "decrease, VideoSurfaceTexture " + videoSurfaceTexture);
        }
        if (videoSurfaceTexture == null || frameRenderChecker == null) {
            return;
        }
        this.checkerMap.remove(videoSurfaceTexture);
        if (this.startCount <= 0) {
            return;
        }
        this.startCount--;
        if (this.startCount == 0) {
            doStop();
        }
    }

    private void doStop() {
        TextureRenderLog.i(this.mTexType, TAG, "doStop");
        Handler handler = this.msgHandler;
        if (handler != null) {
            handler.sendEmptyMessage(39);
        }
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isStarted() {
        return this.startCount > 0;
    }
}
