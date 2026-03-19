package androidx.camera.core.impl;

import androidx.camera.core.ImageProxy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface ImageProxyBundle {
    List<Integer> getCaptureIds();

    ListenableFuture<ImageProxy> getImageProxy(int i);
}
