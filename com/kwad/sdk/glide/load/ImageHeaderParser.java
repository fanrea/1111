package com.kwad.sdk.glide.load;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ImageHeaderParser {
    int a(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar);

    ImageType c(ByteBuffer byteBuffer);

    ImageType g(InputStream inputStream);

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public final boolean hasAlpha() {
            return this.hasAlpha;
        }
    }
}
