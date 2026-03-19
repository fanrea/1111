package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class u implements com.kwad.sdk.glide.load.g<InputStream, Bitmap> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;
    private final k bXf;

    private boolean j(InputStream inputStream) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) {
        return j(inputStream);
    }

    public u(k kVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bXf = kVar;
        this.bQO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.bQO);
        }
        com.kwad.sdk.glide.e.d dVarL = com.kwad.sdk.glide.e.d.l(recyclableBufferedInputStream);
        try {
            return this.bXf.a(new com.kwad.sdk.glide.e.h(dVarL), i, i2, fVar, new a(recyclableBufferedInputStream, dVarL));
        } finally {
            dVarL.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    static class a implements k.a {
        private final RecyclableBufferedInputStream bRT;
        private final com.kwad.sdk.glide.e.d bXM;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.kwad.sdk.glide.e.d dVar) {
            this.bRT = recyclableBufferedInputStream;
            this.bXM = dVar;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public final void ahN() {
            this.bRT.ahT();
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public final void b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionAjx = this.bXM.ajx();
            if (iOExceptionAjx != null) {
                if (bitmap != null) {
                    eVar.e(bitmap);
                    throw iOExceptionAjx;
                }
                throw iOExceptionAjx;
            }
        }
    }
}
