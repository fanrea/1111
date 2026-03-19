package com.bytedance.sdk.djx.core.vod.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.bytedance.sdk.djx.core.vod.IVideoRender;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXTextureRender extends TextureView implements TextureView.SurfaceTextureListener, IVideoRender {
    private static final String TAG = "DJXTextureRender";
    private MeasureHelper mMeasureHelper;
    private AbstractPlayer mPlayer;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public Bitmap doScreenShot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void setScaleType(int i) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void setVideoRotation(int i) {
    }

    public DJXTextureRender(Context context) {
        super(context);
        init();
    }

    public DJXTextureRender(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DJXTextureRender(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMeasureHelper = new MeasureHelper();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int[] iArrDoMeasure = this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(iArrDoMeasure[0], iArrDoMeasure[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LG.d(TAG, "onSurfaceTextureAvailable: " + i + ", " + i2);
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        AbstractPlayer abstractPlayer = this.mPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        LG.d(TAG, "onSurfaceTextureSizeChanged: " + i + ", " + i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        LG.d(TAG, "onSurfaceTextureDestroyed");
        return false;
    }

    private void releaseSurface() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void attachPlayer(AbstractPlayer abstractPlayer) {
        this.mPlayer = abstractPlayer;
        Surface surface = this.mSurface;
        if (surface == null || abstractPlayer == null) {
            return;
        }
        abstractPlayer.setSurface(surface);
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i, i2);
        setLayoutParams(this.mMeasureHelper.doLayoutParams(getLayoutParams()));
        requestLayout();
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void release() {
        releaseSurface();
    }
}
