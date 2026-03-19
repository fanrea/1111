package com.kwad.sdk.glide.load.c;

import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class v<Model> implements n<Model, Model> {
    private static final v<?> bWT = new v<>();

    @Override // com.kwad.sdk.glide.load.c.n
    public final boolean E(Model model) {
        return true;
    }

    public static <T> v<T> ahH() {
        return (v<T>) bWT;
    }

    @Deprecated
    public v() {
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final n.a<Model> b(Model model, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(model), new b(model));
    }

    static class b<Model> implements com.kwad.sdk.glide.load.a.d<Model> {
        private final Model bWV;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        b(Model model) {
            this.bWV = model;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super Model> aVar) {
            aVar.x(this.bWV);
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<Model> afT() {
            return (Class<Model>) this.bWV.getClass();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }

    public static class a<Model> implements o<Model, Model> {
        private static final a<?> bWU = new a<>();

        public static <T> a<T> ahI() {
            return (a<T>) bWU;
        }

        @Deprecated
        public a() {
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Model, Model> a(r rVar) {
            return v.ahH();
        }
    }
}
