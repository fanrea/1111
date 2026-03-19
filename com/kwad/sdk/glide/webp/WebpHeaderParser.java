package com.kwad.sdk.glide.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import androidx.core.internal.view.SupportMenu;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class WebpHeaderParser {
    public static final boolean caA = ajL();

    private static boolean ajL() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (Build.VERSION.SDK_INT == 17) {
            byte[] bArrDecode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_SIMPLE || webpImageType == WebpImageType.WEBP_LOSSLESS || webpImageType == WebpImageType.WEBP_LOSSLESS_WITH_ALPHA || webpImageType == WebpImageType.WEBP_EXTENDED || webpImageType == WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
    }

    public static boolean b(WebpImageType webpImageType) {
        return (webpImageType == WebpImageType.NONE_WEBP || webpImageType == WebpImageType.WEBP_SIMPLE) ? false : true;
    }

    public static boolean c(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }

    public static WebpImageType b(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return WebpImageType.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(21);
        try {
            return c(new com.kwad.sdk.glide.load.b.d((InputStream) ax.checkNotNull(inputStream)));
        } finally {
            inputStream.reset();
        }
    }

    public static WebpImageType j(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return WebpImageType.NONE_WEBP;
        }
        return c(new com.kwad.sdk.glide.load.b.b((ByteBuffer) ax.checkNotNull(byteBuffer)));
    }

    public static WebpImageType a(byte[] bArr, int i, int i2) {
        return c(new com.kwad.sdk.glide.load.b.a(bArr, i, i2));
    }

    private static WebpImageType c(com.kwad.sdk.glide.load.b.c cVar) {
        if ((((cVar.ahu() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535)) != 1380533830) {
            return WebpImageType.NONE_WEBP;
        }
        cVar.skip(4L);
        if ((((cVar.ahu() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535)) != 1464156752) {
            return WebpImageType.NONE_WEBP;
        }
        int iAhu = ((cVar.ahu() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535);
        if (iAhu == 1448097824) {
            return WebpImageType.WEBP_SIMPLE;
        }
        if (iAhu == 1448097868) {
            cVar.skip(4L);
            return (cVar.ahw() & 8) != 0 ? WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpImageType.WEBP_LOSSLESS;
        }
        if (iAhu == 1448097880) {
            cVar.skip(4L);
            int iAhw = cVar.ahw();
            if ((iAhw & 2) != 0) {
                return WebpImageType.WEBP_EXTENDED_ANIMATED;
            }
            if ((iAhw & 16) != 0) {
                return WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
            }
            return WebpImageType.WEBP_EXTENDED;
        }
        return WebpImageType.NONE_WEBP;
    }

    public enum WebpImageType {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);

        private final boolean hasAlpha;
        private final boolean hasAnimation;

        WebpImageType(boolean z, boolean z2) {
            this.hasAlpha = z;
            this.hasAnimation = z2;
        }

        public final boolean hasAlpha() {
            return this.hasAlpha;
        }

        public final boolean hasAnimation() {
            return this.hasAnimation;
        }
    }
}
