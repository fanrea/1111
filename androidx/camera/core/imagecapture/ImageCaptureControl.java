package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.CaptureConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface ImageCaptureControl {
    void lockFlashMode();

    ListenableFuture<Void> submitStillCaptureRequests(List<CaptureConfig> list);

    void unlockFlashMode();
}
