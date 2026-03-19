package com.kwad.sdk.glide.load.resource.a;

import com.kwad.sdk.glide.load.a.e;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements e<ByteBuffer> {
    private final ByteBuffer bXS;

    @Override // com.kwad.sdk.glide.load.a.e
    public final void afU() {
    }

    public a(ByteBuffer byteBuffer) {
        this.bXS = byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.a.e
    /* renamed from: ahW, reason: merged with bridge method [inline-methods] */
    public ByteBuffer afX() {
        this.bXS.position(0);
        return this.bXS;
    }

    /* renamed from: com.kwad.sdk.glide.load.resource.a.a$a, reason: collision with other inner class name */
    public static class C0612a implements e.a<ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.a.e.a
        public final /* synthetic */ e<ByteBuffer> y(ByteBuffer byteBuffer) {
            return e(byteBuffer);
        }

        private static e<ByteBuffer> e(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        public final Class<ByteBuffer> afT() {
            return ByteBuffer.class;
        }
    }
}
