package com.kwad.sdk.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f<Data> implements n<File, Data> {
    private final d<Data> bWi;

    public interface d<Data> {
        Data S(File file);

        Class<Data> afT();

        void w(Data data);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(File file) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a b(File file, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return Q(file);
    }

    public f(d<Data> dVar) {
        this.bWi = dVar;
    }

    private n.a<Data> Q(File file) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(file), new c(file, this.bWi));
    }

    static final class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {
        private final d<Data> bWj;
        private Data data;
        private final File file;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        c(File file, d<Data> dVar) {
            this.file = file;
            this.bWj = dVar;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super Data> aVar) {
            try {
                Data dataS = this.bWj.S(this.file);
                this.data = dataS;
                aVar.x(dataS);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.g(e);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
            Data data = this.data;
            if (data != null) {
                try {
                    this.bWj.w(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<Data> afT() {
            return this.bWj.afT();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }

    public static class a<Data> implements o<File, Data> {
        private final d<Data> bWj;

        public a(d<Data> dVar) {
            this.bWj = dVar;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<File, Data> a(r rVar) {
            return new f(this.bWj);
        }
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() { // from class: com.kwad.sdk.glide.load.c.f.e.1
                @Override // com.kwad.sdk.glide.load.c.f.d
                public final /* synthetic */ InputStream S(File file) {
                    return T(file);
                }

                @Override // com.kwad.sdk.glide.load.c.f.d
                public final /* synthetic */ void w(InputStream inputStream) throws IOException {
                    i(inputStream);
                }

                private static InputStream T(File file) {
                    return new FileInputStream(file);
                }

                private static void i(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                @Override // com.kwad.sdk.glide.load.c.f.d
                public final Class<InputStream> afT() {
                    return InputStream.class;
                }
            });
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() { // from class: com.kwad.sdk.glide.load.c.f.b.1
                @Override // com.kwad.sdk.glide.load.c.f.d
                public final /* synthetic */ ParcelFileDescriptor S(File file) {
                    return R(file);
                }

                @Override // com.kwad.sdk.glide.load.c.f.d
                public final /* synthetic */ void w(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    a(parcelFileDescriptor);
                }

                private static ParcelFileDescriptor R(File file) {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                private static void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                @Override // com.kwad.sdk.glide.load.c.f.d
                public final Class<ParcelFileDescriptor> afT() {
                    return ParcelFileDescriptor.class;
                }
            });
        }
    }
}
