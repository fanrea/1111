package com.bytedance.sdk.djx.core.vod.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.sdk.djx.core.vod.IVideoRender;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXSurfaceRender extends SurfaceView implements SurfaceHolder.Callback, IVideoRender {
    private static final String TAG = "DJXSurfaceRender";
    private MeasureHelper mMeasureHelper;
    private AbstractPlayer mPlayer;

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public Bitmap doScreenShot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void release() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void setScaleType(int i) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void setVideoRotation(int i) {
    }

    public DJXSurfaceRender(Context context) {
        super(context);
        init();
    }

    public DJXSurfaceRender(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DJXSurfaceRender(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMeasureHelper = new MeasureHelper();
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(1);
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoRender
    public void attachPlayer(AbstractPlayer abstractPlayer) {
        this.mPlayer = abstractPlayer;
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

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] iArrDoMeasure = this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(iArrDoMeasure[0], iArrDoMeasure[1]);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LG.d(TAG, "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LG.d(TAG, "surfaceChanged: " + i2 + ", " + i3);
        AbstractPlayer abstractPlayer = this.mPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSurfaceHolder(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LG.d(TAG, "surfaceDestroyed");
    }
}
