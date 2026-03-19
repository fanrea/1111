package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.Size;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FitCenterStrategy extends PreviewScalingStrategy {
    private static final String TAG = "FitCenterStrategy";

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float getScore(Size size, Size size2) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        Size sizeScaleFit = size.scaleFit(size2);
        float fPow = (sizeScaleFit.width * 1.0f) / size.width;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((size2.width * 1.0f) / sizeScaleFit.width) * ((size2.height * 1.0f) / sizeScaleFit.height);
        return fPow * (((1.0f / f) / f) / f);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect scalePreview(Size size, Size size2) {
        Size sizeScaleFit = size.scaleFit(size2);
        Log.i(TAG, "Preview: " + size + "; Scaled: " + sizeScaleFit + "; Want: " + size2);
        int i = (sizeScaleFit.width - size2.width) / 2;
        int i2 = (sizeScaleFit.height - size2.height) / 2;
        return new Rect(-i, -i2, sizeScaleFit.width - i, sizeScaleFit.height - i2);
    }
}
