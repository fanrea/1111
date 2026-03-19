package com.kwad.sdk.glide.load.a;

import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k implements e<InputStream> {
    private final RecyclableBufferedInputStream bRT;

    k(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.bRT = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.a.e
    /* renamed from: afY, reason: merged with bridge method [inline-methods] */
    public InputStream afX() {
        this.bRT.reset();
        return this.bRT;
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public final void afU() {
        this.bRT.release();
    }

    public static final class a implements e.a<InputStream> {
        private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
            this.bQO = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.a.e.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public e<InputStream> y(InputStream inputStream) {
            return new k(inputStream, this.bQO);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        public final Class<InputStream> afT() {
            return InputStream.class;
        }
    }
}
