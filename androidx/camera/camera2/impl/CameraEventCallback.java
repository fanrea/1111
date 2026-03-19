package androidx.camera.camera2.impl;

import androidx.camera.core.impl.CaptureConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class CameraEventCallback {
    public void onDeInitSession() {
    }

    public CaptureConfig onDisableSession() {
        return null;
    }

    public CaptureConfig onEnableSession() {
        return null;
    }

    public CaptureConfig onInitSession() {
        return null;
    }

    public CaptureConfig onRepeating() {
        return null;
    }
}
