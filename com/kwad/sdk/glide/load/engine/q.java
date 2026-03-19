package com.kwad.sdk.glide.load.engine;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class q<Data, ResourceType, Transcode> {
    private final Pools.Pool<List<Throwable>> bTn;
    private final String bTo;
    private final List<? extends g<Data, ResourceType, Transcode>> bUj;
    private final Class<Data> dataClass;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.bTn = pool;
        this.bUj = (List) ax.d(list);
        this.bTo = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + com.alipay.sdk.m.u.i.d;
    }

    public final s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, com.kwad.sdk.glide.load.f fVar, int i, int i2, g.a<ResourceType> aVar) {
        List<Throwable> list = (List) ax.checkNotNull(this.bTn.acquire());
        try {
            return a(eVar, fVar, i, i2, aVar, list);
        } finally {
            this.bTn.release(list);
        }
    }

    private s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, com.kwad.sdk.glide.load.f fVar, int i, int i2, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.bUj.size();
        s<Transcode> sVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                sVarA = this.bUj.get(i3).a(eVar, i, i2, fVar, aVar);
            } catch (GlideException e) {
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
        return "LoadPath{decodePaths=" + Arrays.toString(this.bUj.toArray()) + '}';
    }
}
