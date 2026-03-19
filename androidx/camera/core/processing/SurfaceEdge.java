package androidx.camera.core.processing;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class SurfaceEdge {
    public abstract List<SettableSurface> getSurfaces();

    public static SurfaceEdge create(List<SettableSurface> list) {
        return new AutoValue_SurfaceEdge(list);
    }
}
