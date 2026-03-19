package com.ss.texturerender.producer;

import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import com.ss.texturerender.IFrameAvailableListener;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ImageReaderProducer implements IFrameProducer, ImageReader.OnImageAvailableListener {
    public static final int IMAGEREADER_STATUS = 1;
    public static final int IMAGEREADER_STATUS_CLOSE = 1;
    public static final int IMAGEREADER_STATUS_OPEN = 2;
    public static final int IMAGEREADER_STATUS_UNKNOWN = 0;
    private static final float[] MatrixFlipV = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private static final String TAG = "TR_ImageReaderProducer";
    private IFrameAvailableListener mFrameAvailableListener;
    private ImageReader mImageReader;
    private int mTexType;
    private volatile Image mCurImage = null;
    private EffectTexture mEffectTexture = null;
    private volatile boolean mIsRelease = false;
    private volatile int mStatus = 0;

    @Override // com.ss.texturerender.producer.IFrameProducer
    public int getProducerType() {
        return 2;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void updateImage() {
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void updateTexDimension(int i, int i2) {
    }

    public ImageReaderProducer(int i) {
        this.mTexType = i;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void setOnFrameAvailableListener(IFrameAvailableListener iFrameAvailableListener, Handler handler) {
        this.mFrameAvailableListener = iFrameAvailableListener;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        if (this.mStatus == 1) {
            return;
        }
        this.mImageReader = imageReader;
        _updateImage();
        IFrameAvailableListener iFrameAvailableListener = this.mFrameAvailableListener;
        if (iFrameAvailableListener != null) {
            iFrameAvailableListener.onFrameAvailable();
        }
    }

    private void _updateImage() {
        Exception e;
        Image imageAcquireNextImage;
        ImageReader imageReader = this.mImageReader;
        if (imageReader == null) {
            return;
        }
        try {
            imageAcquireNextImage = imageReader.acquireNextImage();
            if (imageAcquireNextImage != null) {
                try {
                    if (this.mCurImage != null) {
                        this.mCurImage.close();
                        this.mCurImage = null;
                    }
                    if (!this.mIsRelease && this.mStatus != 1) {
                        this.mCurImage = imageAcquireNextImage;
                        return;
                    }
                    imageAcquireNextImage.close();
                } catch (Exception e2) {
                    e = e2;
                    TextureRenderLog.e(this.mTexType, TAG, e.toString());
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            imageAcquireNextImage = null;
        }
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void getTransformMatrix(float[] fArr) {
        for (int i = 0; i < 16; i++) {
            fArr[i] = MatrixFlipV[i];
        }
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public long getTimestamp() {
        if (this.mCurImage == null) {
            return 0L;
        }
        try {
            return this.mCurImage.getTimestamp();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void releaseOffScreenSurface() {
        release();
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void release() {
        this.mIsRelease = true;
        this.mImageReader = null;
        this.mFrameAvailableListener = null;
        this.mEffectTexture = null;
        if (this.mCurImage != null) {
            try {
                this.mCurImage.close();
                this.mCurImage = null;
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public EffectTexture getEffectTexture() {
        if (this.mImageReader == null || this.mIsRelease) {
            return null;
        }
        if (this.mCurImage == null) {
            _updateImage();
        }
        if (this.mCurImage != null) {
            try {
                HardwareBuffer hardwareBuffer = this.mCurImage.getHardwareBuffer();
                if (hardwareBuffer != null) {
                    this.mEffectTexture = new EffectTexture((EffectTextureManager) null, hardwareBuffer, this.mCurImage.getWidth(), this.mCurImage.getHeight(), hardwareBuffer.getFormat());
                }
            } catch (Exception e) {
                TextureRenderLog.e(this.mTexType, TAG, "getEffectTexture,e:" + e.toString());
            }
        }
        return this.mEffectTexture;
    }

    public void setIntOption(int i, int i2) {
        if (i == 1) {
            this.mStatus = i2;
            TextureRenderLog.d(this.mTexType, TAG, "set status:" + this.mStatus + "image:" + this.mCurImage + ",this:" + this);
            if (i2 != 1 || this.mCurImage == null) {
                return;
            }
            this.mCurImage.close();
            this.mCurImage = null;
        }
    }
}
