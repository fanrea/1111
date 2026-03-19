package com.luck.lib.camerax.listener;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CameraXOrientationEventListener extends OrientationEventListener {
    private OnOrientationChangedListener changedListener;
    private int mRotation;

    public interface OnOrientationChangedListener {
        void onOrientationChanged(int i);
    }

    public CameraXOrientationEventListener(Context context, OnOrientationChangedListener onOrientationChangedListener) {
        super(context);
        this.mRotation = 0;
        this.changedListener = onOrientationChangedListener;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i == -1) {
            return;
        }
        int i2 = (i <= 80 || i >= 100) ? (i <= 170 || i >= 190) ? (i <= 260 || i >= 280) ? 0 : 1 : 2 : 3;
        if (this.mRotation != i2) {
            this.mRotation = i2;
            OnOrientationChangedListener onOrientationChangedListener = this.changedListener;
            if (onOrientationChangedListener != null) {
                onOrientationChangedListener.onOrientationChanged(i2);
            }
        }
    }

    public void star() {
        enable();
    }

    public void stop() {
        disable();
    }
}
