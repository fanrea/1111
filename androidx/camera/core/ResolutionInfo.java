package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ResolutionInfo {
    public abstract Rect getCropRect();

    public abstract Size getResolution();

    public abstract int getRotationDegrees();

    static ResolutionInfo create(Size size, Rect rect, int i) {
        return new AutoValue_ResolutionInfo(size, rect, i);
    }

    ResolutionInfo() {
    }
}
