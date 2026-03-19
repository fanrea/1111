package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k cgO;
    List<PngChunk> ciH = new ArrayList();
    boolean ciI = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.cgO = kVar;
    }

    public final List<PngChunk> amV() {
        return this.ciH;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.c
                public final boolean a(PngChunk pngChunk) {
                    return pngChunk.id.equals(str);
                }
            });
        }
        return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.id.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).ane().equals(str2);
                }
                return false;
            }
        });
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.he(i);
        this.ciH.add(pngChunk);
        if (pngChunk.id.equals("PLTE")) {
            this.ciI = true;
        }
    }

    public final List<? extends PngChunk> at(String str, String str2) {
        return a(this.ciH, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.ciH.size();
    }
}
