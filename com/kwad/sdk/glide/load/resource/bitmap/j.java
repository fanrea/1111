package com.kwad.sdk.glide.load.resource.bitmap;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.utils.ax;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements ImageHeaderParser {
    static final byte[] bXg = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] bXh = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static int R(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean gk(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType g(InputStream inputStream) {
        return a(new com.kwad.sdk.glide.load.b.d((InputStream) ax.checkNotNull(inputStream)));
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) {
        return a(new com.kwad.sdk.glide.load.b.b((ByteBuffer) ax.checkNotNull(byteBuffer)));
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public final int a(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        return a(new com.kwad.sdk.glide.load.b.d((InputStream) ax.checkNotNull(inputStream)), (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) ax.checkNotNull(bVar));
    }

    private static ImageHeaderParser.ImageType a(com.kwad.sdk.glide.load.b.c cVar) {
        int iAhu = cVar.ahu();
        if (iAhu == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int iAhu2 = ((iAhu << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535);
        if (iAhu2 == -1991225785) {
            cVar.skip(21L);
            return cVar.ahw() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((iAhu2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (iAhu2 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        cVar.skip(4L);
        if ((((cVar.ahu() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iAhu3 = ((cVar.ahu() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.ahu() & 65535);
        if ((iAhu3 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i = iAhu3 & 255;
        if (i == 88) {
            cVar.skip(4L);
            return (cVar.ahw() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i == 76) {
            cVar.skip(4L);
            return (cVar.ahw() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        return ImageHeaderParser.ImageType.WEBP;
    }

    private int a(com.kwad.sdk.glide.load.b.c cVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        int iAhu = cVar.ahu();
        if (!gk(iAhu)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iAhu);
            }
            return -1;
        }
        int iB = b(cVar);
        if (iB == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(iB, byte[].class);
        try {
            return a(cVar, bArr, iB);
        } finally {
            bVar.put(bArr);
        }
    }

    private int a(com.kwad.sdk.glide.load.b.c cVar, byte[] bArr, int i) {
        int iE = cVar.e(bArr, i);
        if (iE != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iE);
            }
            return -1;
        }
        if (f(bArr, i)) {
            return a(new a(bArr, i));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    private static boolean f(byte[] bArr, int i) {
        boolean z = bArr != null && i > bXg.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = bXg;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private static int b(com.kwad.sdk.glide.load.b.c cVar) {
        short sAhv;
        int iAhu;
        long j;
        long jSkip;
        do {
            short sAhv2 = cVar.ahv();
            if (sAhv2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sAhv2));
                }
                return -1;
            }
            sAhv = cVar.ahv();
            if (sAhv == 218) {
                return -1;
            }
            if (sAhv == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iAhu = cVar.ahu() - 2;
            if (sAhv == 225) {
                return iAhu;
            }
            j = iAhu;
            jSkip = cVar.skip(j);
        } while (jSkip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sAhv) + ", wanted to skip: " + iAhu + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int a(a aVar) {
        ByteOrder byteOrder;
        short sGm = aVar.gm(6);
        if (sGm == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (sGm != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sGm));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.a(byteOrder);
        int iGl = aVar.gl(10) + 6;
        short sGm2 = aVar.gm(iGl);
        for (int i = 0; i < sGm2; i++) {
            int iR = R(iGl, i);
            short sGm3 = aVar.gm(iR);
            if (sGm3 == 274) {
                short sGm4 = aVar.gm(iR + 2);
                if (sGm4 <= 0 || sGm4 > 12) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sGm4));
                    }
                } else {
                    int iGl2 = aVar.gl(iR + 4);
                    if (iGl2 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sGm3) + " formatCode=" + ((int) sGm4) + " componentCount=" + iGl2);
                        }
                        int i2 = iGl2 + bXh[sGm4];
                        if (i2 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sGm4));
                            }
                        } else {
                            int i3 = iR + 8;
                            if (i3 < 0 || i3 > aVar.length()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sGm3));
                                }
                            } else if (i2 < 0 || i2 + i3 > aVar.length()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sGm3));
                                }
                            } else {
                                return aVar.gm(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    static final class a {
        private final ByteBuffer bXi;

        a(byte[] bArr, int i) {
            this.bXi = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        final void a(ByteOrder byteOrder) {
            this.bXi.order(byteOrder);
        }

        final int length() {
            return this.bXi.remaining();
        }

        final int gl(int i) {
            if (S(i, 4)) {
                return this.bXi.getInt(i);
            }
            return -1;
        }

        final short gm(int i) {
            if (S(i, 2)) {
                return this.bXi.getShort(i);
            }
            return (short) -1;
        }

        private boolean S(int i, int i2) {
            return this.bXi.remaining() - i >= i2;
        }
    }
}
