package com.ss.texturerender.producer;

import android.os.Handler;
import com.ss.texturerender.IFrameAvailableListener;
import com.ss.texturerender.effect.EffectTexture;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IFrameProducer {
    EffectTexture getEffectTexture();

    int getProducerType();

    long getTimestamp();

    void getTransformMatrix(float[] fArr);

    void release();

    void releaseOffScreenSurface();

    void setOnFrameAvailableListener(IFrameAvailableListener iFrameAvailableListener, Handler handler);

    void updateImage();

    void updateTexDimension(int i, int i2);
}
