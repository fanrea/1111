package com.kwad.sdk.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements c {
    private final ArrayMap<e<?>, Object> bRE = new com.kwad.sdk.glide.e.b();

    public final void a(f fVar) {
        this.bRE.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.bRE);
    }

    public final <T> f a(e<T> eVar, T t) {
        this.bRE.put(eVar, t);
        return this;
    }

    public final <T> T a(e<T> eVar) {
        return this.bRE.containsKey(eVar) ? (T) this.bRE.get(eVar) : eVar.getDefaultValue();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.bRE.equals(((f) obj).bRE);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return this.bRE.hashCode();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.bRE.size(); i++) {
            a(this.bRE.keyAt(i), this.bRE.valueAt(i), messageDigest);
        }
    }

    public final String toString() {
        return "Options{values=" + this.bRE + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(e<T> eVar, Object obj, MessageDigest messageDigest) {
        eVar.a(obj, messageDigest);
    }
}
