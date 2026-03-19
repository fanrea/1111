package com.ss.texturerender.effect.vr.director.picodirector;

import android.os.Bundle;
import android.view.Display;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.math.Matrix3x3d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PicoDirector implements IDirector {
    private Display mDisplay;

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle bundle) {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
    }

    public PicoDirector(Display display) {
        this.mDisplay = display;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] fArr, int i) {
        if (PicoQuaternion.getVRQuaternion() != null) {
            Matrix3x3d.matrixToColumnArray(Matrix3x3d.rotationMatrix3x3(PicoQuaternion.getVRQuaternion()), fArr);
        }
    }
}
