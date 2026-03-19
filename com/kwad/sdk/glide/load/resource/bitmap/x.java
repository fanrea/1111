package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.kwad.sdk.glide.load.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class x<T> implements com.kwad.sdk.glide.load.g<T, Bitmap> {
    public static final com.kwad.sdk.glide.load.e<Long> bXN = com.kwad.sdk.glide.load.e.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new e.a<Long>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.x.1
        private final ByteBuffer bXS = ByteBuffer.allocate(8);

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.e.a
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.bXS) {
                this.bXS.position(0);
                messageDigest.update(this.bXS.putLong(l.longValue()).array());
            }
        }
    });
    public static final com.kwad.sdk.glide.load.e<Integer> bXO = com.kwad.sdk.glide.load.e.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new e.a<Integer>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.x.2
        private final ByteBuffer bXS = ByteBuffer.allocate(4);

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.e.a
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.bXS) {
                this.bXS.position(0);
                messageDigest.update(this.bXS.putInt(num.intValue()).array());
            }
        }
    });
    private static final b bXP = new b();
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final c<T> bXQ;
    private final b bXR;

    interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @Override // com.kwad.sdk.glide.load.g
    public final boolean a(T t, com.kwad.sdk.glide.load.f fVar) {
        return true;
    }

    public static com.kwad.sdk.glide.load.g<AssetFileDescriptor, Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new x(eVar, new a((byte) 0));
    }

    public static com.kwad.sdk.glide.load.g<ParcelFileDescriptor, Bitmap> b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new x(eVar, new d());
    }

    private x(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar) {
        this(eVar, cVar, bXP);
    }

    private x(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar, b bVar) {
        this.bPy = eVar;
        this.bXQ = cVar;
        this.bXR = bVar;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final com.kwad.sdk.glide.load.engine.s<Bitmap> a(T t, int i, int i2, com.kwad.sdk.glide.load.f fVar) throws IOException {
        long jLongValue = ((Long) fVar.a(bXN)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) fVar.a(bXO);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.bXq);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.bXp;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverAhV = b.ahV();
        try {
            try {
                this.bXQ.a(mediaMetadataRetrieverAhV, t);
                Bitmap bitmapA = a(mediaMetadataRetrieverAhV, jLongValue, num.intValue(), i, i2, downsampleStrategy2);
                mediaMetadataRetrieverAhV.release();
                return com.kwad.sdk.glide.load.resource.bitmap.d.a(bitmapA, this.bPy);
            } catch (RuntimeException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverAhV.release();
            throw th;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapB = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.bXo) ? null : b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return bitmapB == null ? a(mediaMetadataRetriever, j, i) : bitmapB;
    }

    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fC = downsampleStrategy.c(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fC), Math.round(fC * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    static class b {
        b() {
        }

        public static MediaMetadataRetriever ahV() {
            return new MediaMetadataRetriever();
        }
    }

    static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.x.c
        public final /* bridge */ /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            a2(mediaMetadataRetriever, assetFileDescriptor);
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static void a2(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.x.c
        public final /* bridge */ /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            a2(mediaMetadataRetriever, parcelFileDescriptor);
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static void a2(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }
}
