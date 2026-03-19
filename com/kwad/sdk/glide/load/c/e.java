package com.kwad.sdk.glide.load.c;

import android.util.Base64;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> bWd;

    public interface a<Data> {
        Class<Data> afT();

        Data hm(String str);

        void w(Data data);
    }

    public e(a<Data> aVar) {
        this.bWd = aVar;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final n.a<Data> b(Model model, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(model), new b(model.toString(), this.bWd));
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final boolean E(Model model) {
        return model.toString().startsWith(UriUtils.BASE64_PREFIX);
    }

    static final class b<Data> implements com.kwad.sdk.glide.load.a.d<Data> {
        private final String bWe;
        private final a<Data> bWf;
        private Data data;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        b(String str, a<Data> aVar) {
            this.bWe = str;
            this.bWf = aVar;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super Data> aVar) {
            try {
                Data dataHm = this.bWf.hm(this.bWe);
                this.data = dataHm;
                aVar.x(dataHm);
            } catch (IllegalArgumentException e) {
                aVar.g(e);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
            try {
                this.bWf.w(this.data);
            } catch (IOException unused) {
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<Data> afT() {
            return this.bWf.afT();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> bWg = new a<InputStream>() { // from class: com.kwad.sdk.glide.load.c.e.c.1
            @Override // com.kwad.sdk.glide.load.c.e.a
            public final /* synthetic */ InputStream hm(String str) {
                return hn(str);
            }

            @Override // com.kwad.sdk.glide.load.c.e.a
            public final /* synthetic */ void w(InputStream inputStream) throws IOException {
                i(inputStream);
            }

            private static InputStream hn(String str) {
                if (!str.startsWith(UriUtils.BASE64_PREFIX)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (!str.substring(0, iIndexOf).endsWith(";base64")) {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
                return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
            }

            private static void i(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.kwad.sdk.glide.load.c.e.a
            public final Class<InputStream> afT() {
                return InputStream.class;
            }
        };

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Model, InputStream> a(r rVar) {
            return new e(this.bWg);
        }
    }
}
