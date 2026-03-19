package androidx.camera.core.internal.utils;

import android.util.Size;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_VGA = new Size(640, 480);
    public static final Size RESOLUTION_480P = new Size(720, 480);
    public static final Size RESOLUTION_1080P = new Size(1920, 1080);

    private SizeUtil() {
    }

    public static int getArea(Size size) {
        return size.getWidth() * size.getHeight();
    }
}
