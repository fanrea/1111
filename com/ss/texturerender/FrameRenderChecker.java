package com.ss.texturerender;

import com.ss.texturerender.VideoSurface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FrameRenderChecker {
    public static final int NO_RENDER_REASON_CALLBACK = 0;
    public static final int NO_RENDER_REASON_DRAW = 1;
    private static final String TAG = "FrameRenderChecker";
    private static final int THRESHOLD_NO_RENDER_FRAME = 30;
    private static final int THRESHOLD_NO_RENDER_TIME = 1000;
    private RenderCheckDispatcher checkDispatcher;
    private long continuousNoCallbackCount;
    private long continuousNoDrawCount;
    private volatile boolean failedCallback;
    private volatile boolean failedRender;
    private boolean isStarted;
    private long lastCallbackTime;
    private VideoSurface.OnNoRenderListener listener;
    private VideoSurfaceTexture videoSurfaceTexture;

    public FrameRenderChecker(RenderCheckDispatcher renderCheckDispatcher, VideoSurfaceTexture videoSurfaceTexture) {
        this.checkDispatcher = renderCheckDispatcher;
        this.videoSurfaceTexture = videoSurfaceTexture;
    }

    public void setCheckDispatcher(RenderCheckDispatcher renderCheckDispatcher) {
        this.checkDispatcher = renderCheckDispatcher;
        if (!this.isStarted || renderCheckDispatcher == null) {
            return;
        }
        renderCheckDispatcher.increase(this.videoSurfaceTexture, this);
    }

    public void setListener(VideoSurface.OnNoRenderListener onNoRenderListener) {
        this.listener = onNoRenderListener;
    }

    public void start() {
        VideoSurfaceTexture videoSurfaceTexture = this.videoSurfaceTexture;
        if (videoSurfaceTexture != null) {
            TextureRenderLog.i(videoSurfaceTexture.texType(), TAG, "start, isStarted: " + this.isStarted);
        }
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        reset();
        RenderCheckDispatcher renderCheckDispatcher = this.checkDispatcher;
        if (renderCheckDispatcher != null) {
            renderCheckDispatcher.increase(this.videoSurfaceTexture, this);
        }
    }

    public void stop() {
        VideoSurfaceTexture videoSurfaceTexture = this.videoSurfaceTexture;
        if (videoSurfaceTexture != null) {
            TextureRenderLog.i(videoSurfaceTexture.texType(), TAG, "stop, isStarted: " + this.isStarted);
        }
        if (this.isStarted) {
            this.isStarted = false;
            reset();
            RenderCheckDispatcher renderCheckDispatcher = this.checkDispatcher;
            if (renderCheckDispatcher != null) {
                renderCheckDispatcher.decrease(this.videoSurfaceTexture, this);
            }
        }
    }

    public void onFrameCome() {
        this.continuousNoDrawCount++;
        if (this.failedRender || this.continuousNoDrawCount <= 30) {
            return;
        }
        this.failedRender = true;
        VideoSurface.OnNoRenderListener onNoRenderListener = this.listener;
        if (onNoRenderListener != null) {
            onNoRenderListener.onNoRenderStart(1);
        }
    }

    public void onDrawSucceed() {
        this.continuousNoDrawCount = 0L;
        if (this.failedRender) {
            this.failedRender = false;
            if (this.listener == null || this.failedCallback) {
                return;
            }
            this.listener.onNoRenderEnd(1);
        }
    }

    public void checkSurfaceTextureCallbackTime() {
        if (this.isStarted && !this.failedCallback) {
            if (System.currentTimeMillis() - this.lastCallbackTime >= 1000) {
                this.continuousNoCallbackCount++;
            } else {
                this.continuousNoCallbackCount = 0L;
            }
            if (this.continuousNoCallbackCount >= 2) {
                this.failedCallback = true;
                VideoSurface.OnNoRenderListener onNoRenderListener = this.listener;
                if (onNoRenderListener != null) {
                    onNoRenderListener.onNoRenderStart(0);
                }
            }
        }
    }

    public void onSurfaceTextureCallbackCalled() {
        if (this.isStarted) {
            this.lastCallbackTime = System.currentTimeMillis();
            if (this.failedCallback) {
                this.failedCallback = false;
                this.continuousNoCallbackCount = 0L;
                if (this.listener == null || this.failedRender) {
                    return;
                }
                this.listener.onNoRenderEnd(0);
            }
        }
    }

    private void reset() {
        this.failedCallback = false;
        this.failedRender = false;
        this.continuousNoCallbackCount = 0L;
        this.continuousNoDrawCount = 0L;
    }
}
