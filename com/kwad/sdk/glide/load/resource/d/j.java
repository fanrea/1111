package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements com.kwad.sdk.glide.load.g<InputStream, c> {
    private final List<ImageHeaderParser> bQG;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;
    private final com.kwad.sdk.glide.load.g<ByteBuffer, c> bYv;

    public j(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.g<ByteBuffer, c> gVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bQG = list;
        this.bYv = gVar;
        this.bQO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) {
        return !((Boolean) fVar.a(i.bQE)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.bQG, inputStream, this.bQO) == ImageHeaderParser.ImageType.GIF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public s<c> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) throws IOException {
        byte[] bArrK = k(inputStream);
        if (bArrK == null) {
            return null;
        }
        return this.bYv.a(ByteBuffer.wrap(bArrK), i, i2, fVar);
    }

    private static byte[] k(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }
}
