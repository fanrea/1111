package com.kwad.lottie.a.b;

import android.graphics.Path;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends a<com.kwad.lottie.model.content.h, Path> {
    private final com.kwad.lottie.model.content.h bmx;
    private final Path bmy;

    public l(List<com.kwad.lottie.e.a<com.kwad.lottie.model.content.h>> list) {
        super(list);
        this.bmx = new com.kwad.lottie.model.content.h();
        this.bmy = new Path();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Path a(com.kwad.lottie.e.a<com.kwad.lottie.model.content.h> aVar, float f) {
        this.bmx.a(aVar.bpN, aVar.bpO, f);
        com.kwad.lottie.d.e.a(this.bmx, this.bmy);
        return this.bmy;
    }
}
