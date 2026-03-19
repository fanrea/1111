package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g<DataType, ResourceType, Transcode> {
    private final List<? extends com.kwad.sdk.glide.load.g<DataType, ResourceType>> bTl;
    private final com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> bTm;
    private final Pools.Pool<List<Throwable>> bTn;
    private final String bTo;
    private final Class<DataType> dataClass;

    interface a<ResourceType> {
        s<ResourceType> c(s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.kwad.sdk.glide.load.g<DataType, ResourceType>> list, com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.bTl = list;
        this.bTm = eVar;
        this.bTn = pool;
        this.bTo = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + com.alipay.sdk.m.u.i.d;
    }

    public final s<Transcode> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, com.kwad.sdk.glide.load.f fVar, a<ResourceType> aVar) {
        return this.bTm.a(aVar.c(a(eVar, i, i2, fVar)), fVar);
    }

    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        List<Throwable> list = (List) ax.checkNotNull(this.bTn.acquire());
        try {
            return a(eVar, i, i2, fVar, list);
        } finally {
            this.bTn.release(list);
        }
    }

    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, com.kwad.sdk.glide.load.f fVar, List<Throwable> list) throws GlideException {
        int size = this.bTl.size();
        s<ResourceType> sVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.kwad.sdk.glide.load.g<DataType, ResourceType> gVar = this.bTl.get(i3);
            try {
                if (gVar.a(eVar.afX(), fVar)) {
                    sVarA = gVar.a(eVar.afX(), i, i2, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + gVar, e);
                }
                list.add(e);
            }
            if (sVarA != null) {
                break;
            }
        }
        if (sVarA != null) {
            return sVarA;
        }
        throw new GlideException(this.bTo, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.bTl + ", transcoder=" + this.bTm + '}';
    }
}
