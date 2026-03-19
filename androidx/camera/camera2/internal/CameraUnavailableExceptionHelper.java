package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    public static CameraUnavailableException createFrom(CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i = 5;
        if (reason == 1) {
            i = 1;
        } else if (reason == 2) {
            i = 2;
        } else if (reason == 3) {
            i = 3;
        } else if (reason == 4) {
            i = 4;
        } else if (reason != 5) {
            i = reason != 10001 ? 0 : 6;
        }
        return new CameraUnavailableException(i, cameraAccessExceptionCompat);
    }
}
