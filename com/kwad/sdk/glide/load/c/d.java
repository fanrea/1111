package com.kwad.sdk.glide.load.c;

import android.util.Log;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements n<File, ByteBuffer> {
    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(File file) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a<ByteBuffer> b(File file, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return Q(file);
    }

    private static n.a<ByteBuffer> Q(File file) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(file), new a(file));
    }

    public static class b implements o<File, ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<File, ByteBuffer> a(r rVar) {
            return new d();
        }
    }

    static final class a implements com.kwad.sdk.glide.load.a.d<ByteBuffer> {
        private final File file;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        a(File file) {
            this.file = file;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.x(com.kwad.sdk.glide.e.a.V(this.file));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.g(e);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<ByteBuffer> afT() {
            return ByteBuffer.class;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }
}
