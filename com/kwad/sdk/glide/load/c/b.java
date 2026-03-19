package com.kwad.sdk.glide.load.c;

import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<Data> implements n<byte[], Data> {
    private final InterfaceC0606b<Data> bVZ;

    /* renamed from: com.kwad.sdk.glide.load.c.b$b, reason: collision with other inner class name */
    public interface InterfaceC0606b<Data> {
        Class<Data> afT();

        Data l(byte[] bArr);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(byte[] bArr) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a b(byte[] bArr, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return j(bArr);
    }

    public b(InterfaceC0606b<Data> interfaceC0606b) {
        this.bVZ = interfaceC0606b;
    }

    private n.a<Data> j(byte[] bArr) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(bArr), new c(bArr, this.bVZ));
    }

    static class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {
        private final InterfaceC0606b<Data> bVZ;
        private final byte[] bWb;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        c(byte[] bArr, InterfaceC0606b<Data> interfaceC0606b) {
            this.bWb = bArr;
            this.bVZ = interfaceC0606b;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super Data> aVar) {
            aVar.x(this.bVZ.l(this.bWb));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<Data> afT() {
            return this.bVZ.afT();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }

    public static class a implements o<byte[], ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<byte[], ByteBuffer> a(r rVar) {
            return new b(new InterfaceC0606b<ByteBuffer>() { // from class: com.kwad.sdk.glide.load.c.b.a.1
                @Override // com.kwad.sdk.glide.load.c.b.InterfaceC0606b
                public final /* synthetic */ ByteBuffer l(byte[] bArr) {
                    return k(bArr);
                }

                private static ByteBuffer k(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                @Override // com.kwad.sdk.glide.load.c.b.InterfaceC0606b
                public final Class<ByteBuffer> afT() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    public static class d implements o<byte[], InputStream> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<byte[], InputStream> a(r rVar) {
            return new b(new InterfaceC0606b<InputStream>() { // from class: com.kwad.sdk.glide.load.c.b.d.1
                @Override // com.kwad.sdk.glide.load.c.b.InterfaceC0606b
                public final /* synthetic */ InputStream l(byte[] bArr) {
                    return m(bArr);
                }

                private static InputStream m(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.kwad.sdk.glide.load.c.b.InterfaceC0606b
                public final Class<InputStream> afT() {
                    return InputStream.class;
                }
            });
        }
    }
}
