package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class d<DataType> implements a.b {
    private final com.kwad.sdk.glide.load.a<DataType> bSw;
    private final com.kwad.sdk.glide.load.f bSx;
    private final DataType data;

    d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.f fVar) {
        this.bSw = aVar;
        this.data = datatype;
        this.bSx = fVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public final boolean O(File file) {
        return this.bSw.a(this.data, file, this.bSx);
    }
}
