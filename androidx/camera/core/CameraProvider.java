package androidx.camera.core;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface CameraProvider {
    List<CameraInfo> getAvailableCameraInfos();

    boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException;
}
