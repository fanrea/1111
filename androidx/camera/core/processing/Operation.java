package androidx.camera.core.processing;

import androidx.camera.core.ImageCaptureException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface Operation<I, O> {
    O apply(I i) throws ImageCaptureException;
}
