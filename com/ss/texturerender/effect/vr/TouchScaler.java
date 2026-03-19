package com.ss.texturerender.effect.vr;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TouchScaler implements ScaleGestureDetector.OnScaleGestureListener {
    private static final String LOG_TAG = "TR_TouchScaler";
    public static final float MAX_SCALE = 4.0f;
    public static final float MIN_SCALE = 0.2f;
    private int mTexType;
    private float curMaxScale = 4.0f;
    private float curMinScale = 0.2f;
    private Matrix matrix = new Matrix();
    private float[] values = new float[9];

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public void start() {
    }

    TouchScaler(int i) {
        this.mTexType = i;
    }

    public void stop() {
        this.matrix = new Matrix();
    }

    public float getScale() {
        this.matrix.getValues(this.values);
        return this.values[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onScale(android.view.ScaleGestureDetector r7) {
        /*
            r6 = this;
            float r0 = r7.getScaleFactor()
            float r1 = r6.getScale()
            float r2 = r6.curMaxScale
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L14
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 < 0) goto L26
        L14:
            float r3 = r6.curMinScale
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L1e
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 > 0) goto L26
        L1e:
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L33
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 <= 0) goto L33
        L26:
            android.graphics.Matrix r2 = r6.matrix
            float r3 = r7.getFocusX()
            float r7 = r7.getFocusY()
            r2.postScale(r0, r0, r3, r7)
        L33:
            int r7 = r6.mTexType
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "scaleFactor:"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = ",curScale:"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TR_TouchScaler"
            com.ss.texturerender.TextureRenderLog.i(r7, r1, r0)
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.effect.vr.TouchScaler.onScale(android.view.ScaleGestureDetector):boolean");
    }

    public void setMaxScale(float f) {
        this.curMaxScale = Math.min(4.0f, Math.max(1.0f, f));
    }

    public void setMinScale(float f) {
        this.curMinScale = Math.max(0.2f, Math.min(1.0f, f));
    }
}
