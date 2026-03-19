package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.Size;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CenterCropStrategy extends PreviewScalingStrategy {
    private static final String TAG = "CenterCropStrategy";

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float getScore(Size size, Size size2) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        Size sizeScaleCrop = size.scaleCrop(size2);
        float fPow = (sizeScaleCrop.width * 1.0f) / size.width;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((sizeScaleCrop.width * 1.0f) / size2.width) + ((sizeScaleCrop.height * 1.0f) / size2.height);
        return fPow * ((1.0f / f) / f);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect scalePreview(Size size, Size size2) {
        Size sizeScaleCrop = size.scaleCrop(size2);
        Log.i(TAG, "Preview: " + size + "; Scaled: " + sizeScaleCrop + "; Want: " + size2);
        int i = (sizeScaleCrop.width - size2.width) / 2;
        int i2 = (sizeScaleCrop.height - size2.height) / 2;
        return new Rect(-i, -i2, sizeScaleCrop.width - i, sizeScaleCrop.height - i2);
    }
}
