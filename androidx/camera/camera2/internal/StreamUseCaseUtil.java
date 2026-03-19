package androidx.camera.camera2.internal;

import android.os.Build;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.VideoCaptureConfig;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class StreamUseCaseUtil {
    private StreamUseCaseUtil() {
    }

    public static long getStreamUseCaseFromUseCaseConfigs(Collection<UseCaseConfig<?>> collection, Collection<SessionConfig> collection2) {
        if (Build.VERSION.SDK_INT < 33) {
            return -1L;
        }
        if (collection.isEmpty()) {
            return 0L;
        }
        Iterator<SessionConfig> it = collection2.iterator();
        while (it.hasNext()) {
            if (it.next().getTemplateType() == 5) {
                return 0L;
            }
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (UseCaseConfig<?> useCaseConfig : collection) {
            if (useCaseConfig instanceof ImageAnalysisConfig) {
                return 0L;
            }
            if (useCaseConfig instanceof PreviewConfig) {
                z3 = true;
            } else if (useCaseConfig instanceof ImageCaptureConfig) {
                if (z2) {
                    return 4L;
                }
                z = true;
            } else if (!(useCaseConfig instanceof VideoCaptureConfig)) {
                continue;
            } else {
                if (z) {
                    return 4L;
                }
                z2 = true;
            }
        }
        if (z) {
            return 2L;
        }
        if (z2) {
            return 3L;
        }
        return !z3 ? 0L : 1L;
    }
}
