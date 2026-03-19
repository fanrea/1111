package com.kwad.sdk.glide;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.p;
import com.kwad.sdk.glide.load.engine.q;
import com.kwad.sdk.glide.load.engine.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Registry {
    private final p bPV;
    private final com.kwad.sdk.glide.c.a bPW;
    private final com.kwad.sdk.glide.c.e bPX;
    private final com.kwad.sdk.glide.c.f bPY;
    private final com.kwad.sdk.glide.load.a.f bPZ;
    private final com.kwad.sdk.glide.load.resource.e.f bQa;
    private final com.kwad.sdk.glide.c.b bQb;
    private final com.kwad.sdk.glide.c.d bQc = new com.kwad.sdk.glide.c.d();
    private final com.kwad.sdk.glide.c.c bQd = new com.kwad.sdk.glide.c.c();
    private final Pools.Pool<List<Throwable>> bQe;

    public Registry() {
        Pools.Pool<List<Throwable>> poolAjF = com.kwad.sdk.glide.e.a.a.ajF();
        this.bQe = poolAjF;
        this.bPV = new p(poolAjF);
        this.bPW = new com.kwad.sdk.glide.c.a();
        this.bPX = new com.kwad.sdk.glide.c.e();
        this.bPY = new com.kwad.sdk.glide.c.f();
        this.bPZ = new com.kwad.sdk.glide.load.a.f();
        this.bQa = new com.kwad.sdk.glide.load.resource.e.f();
        this.bQb = new com.kwad.sdk.glide.c.b();
        at(Arrays.asList("Gif", com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    public final <Data> Registry a(Class<Data> cls, com.kwad.sdk.glide.load.a<Data> aVar) {
        this.bPW.b(cls, aVar);
        return this;
    }

    public final <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, com.kwad.sdk.glide.load.g<Data, TResource> gVar) {
        a("legacy_append", cls, cls2, gVar);
        return this;
    }

    public final <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, com.kwad.sdk.glide.load.g<Data, TResource> gVar) {
        this.bPX.a(str, gVar, cls, cls2);
        return this;
    }

    public final <Data, TResource> Registry b(Class<Data> cls, Class<TResource> cls2, com.kwad.sdk.glide.load.g<Data, TResource> gVar) {
        b("legacy_prepend_all", cls, cls2, gVar);
        return this;
    }

    public final <Data, TResource> Registry b(String str, Class<Data> cls, Class<TResource> cls2, com.kwad.sdk.glide.load.g<Data, TResource> gVar) {
        this.bPX.b(str, gVar, cls, cls2);
        return this;
    }

    private Registry at(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.bPX.aw(arrayList);
        return this;
    }

    public final <TResource> Registry a(Class<TResource> cls, com.kwad.sdk.glide.load.h<TResource> hVar) {
        this.bPY.c(cls, hVar);
        return this;
    }

    public final <TResource> Registry b(Class<TResource> cls, com.kwad.sdk.glide.load.h<TResource> hVar) {
        this.bPY.d(cls, hVar);
        return this;
    }

    public final Registry a(e.a<?> aVar) {
        this.bPZ.b(aVar);
        return this;
    }

    public final <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, com.kwad.sdk.glide.load.resource.e.e<TResource, Transcode> eVar) {
        this.bQa.b(cls, cls2, eVar);
        return this;
    }

    public final Registry a(ImageHeaderParser imageHeaderParser) {
        this.bQb.b(imageHeaderParser);
        return this;
    }

    public final <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.bPV.b(cls, cls2, oVar);
        return this;
    }

    public final <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVarD = this.bQd.d(cls, cls2, cls3);
        if (com.kwad.sdk.glide.c.c.a(qVarD)) {
            return null;
        }
        if (qVarD == null) {
            List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> listB = b(cls, cls2, cls3);
            qVarD = listB.isEmpty() ? null : new q<>(cls, cls2, cls3, listB, this.bQe);
            this.bQd.a(cls, cls2, cls3, qVarD);
        }
        return qVarD;
    }

    private <Data, TResource, Transcode> List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.bPX.f(cls, cls2)) {
            for (Class cls5 : this.bQa.d(cls4, cls3)) {
                arrayList.add(new com.kwad.sdk.glide.load.engine.g(cls, cls4, cls5, this.bPX.e(cls, cls4), this.bQa.c(cls4, cls5), this.bQe));
            }
        }
        return arrayList;
    }

    public final <Model, TResource, Transcode> List<Class<?>> c(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listF = this.bQc.f(cls, cls2, cls3);
        if (listF == null) {
            listF = new ArrayList<>();
            Iterator<Class<?>> it = this.bPV.o(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.bPX.f(it.next(), cls2)) {
                    if (!this.bQa.d(cls4, cls3).isEmpty() && !listF.contains(cls4)) {
                        listF.add(cls4);
                    }
                }
            }
            this.bQc.a(cls, cls2, cls3, Collections.unmodifiableList(listF));
        }
        return listF;
    }

    public final boolean a(s<?> sVar) {
        return this.bPY.u(sVar.afv()) != null;
    }

    public final <X> com.kwad.sdk.glide.load.h<X> b(s<X> sVar) {
        com.kwad.sdk.glide.load.h<X> hVarU = this.bPY.u(sVar.afv());
        if (hVarU != null) {
            return hVarU;
        }
        throw new NoResultEncoderAvailableException(sVar.afv());
    }

    public final <X> com.kwad.sdk.glide.load.a<X> r(X x) {
        com.kwad.sdk.glide.load.a<X> aVarT = this.bPW.t(x.getClass());
        if (aVarT != null) {
            return aVarT;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public final <X> com.kwad.sdk.glide.load.a.e<X> s(X x) {
        return this.bPZ.y(x);
    }

    public final <Model> List<n<Model, ?>> t(Model model) {
        List<n<Model, ?>> listT = this.bPV.t(model);
        if (listT.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return listT;
    }

    public final List<ImageHeaderParser> afj() {
        List<ImageHeaderParser> listAiw = this.bQb.aiw();
        if (listAiw.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listAiw;
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
