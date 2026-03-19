package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class AttachedSurfaceInfo {
    public abstract int getImageFormat();

    public abstract Size getSize();

    public abstract SurfaceConfig getSurfaceConfig();

    public abstract Range<Integer> getTargetFrameRate();

    AttachedSurfaceInfo() {
    }

    public static AttachedSurfaceInfo create(SurfaceConfig surfaceConfig, int i, Size size, Range<Integer> range) {
        return new AutoValue_AttachedSurfaceInfo(surfaceConfig, i, size, range);
    }
}
