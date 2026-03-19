package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class ImageWriterCompat {
    public static ImageWriter newInstance(Surface surface, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i, i2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i, i2);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + Build.VERSION.SDK_INT + ". Version 26 or higher required.");
    }

    public static ImageWriter newInstance(Surface surface, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ImageWriterCompatApi23Impl.newInstance(surface, i);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + Build.VERSION.SDK_INT + ". Version 23 or higher required.");
    }

    public static Image dequeueInputImage(ImageWriter imageWriter) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
        }
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + Build.VERSION.SDK_INT + ". Version 23 or higher required.");
    }

    public static void queueInputImage(ImageWriter imageWriter, Image image) {
        if (Build.VERSION.SDK_INT >= 23) {
            ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
            return;
        }
        throw new RuntimeException("Unable to call queueInputImage() on API " + Build.VERSION.SDK_INT + ". Version 23 or higher required.");
    }

    public static void close(ImageWriter imageWriter) {
        if (Build.VERSION.SDK_INT >= 23) {
            ImageWriterCompatApi23Impl.close(imageWriter);
            return;
        }
        throw new RuntimeException("Unable to call close() on API " + Build.VERSION.SDK_INT + ". Version 23 or higher required.");
    }

    private ImageWriterCompat() {
    }
}
