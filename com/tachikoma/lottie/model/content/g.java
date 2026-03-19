package com.tachikoma.lottie.model.content;

import com.tachikoma.lottie.a.a.p;
import com.tachikoma.lottie.model.a.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g implements b {
    private final boolean IO;
    private final com.tachikoma.lottie.model.a.b LP;
    private final com.tachikoma.lottie.model.a.b LQ;
    private final l LR;
    private final String name;

    public g(String str, com.tachikoma.lottie.model.a.b bVar, com.tachikoma.lottie.model.a.b bVar2, l lVar, boolean z) {
        this.name = str;
        this.LP = bVar;
        this.LQ = bVar2;
        this.LR = lVar;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final com.tachikoma.lottie.model.a.b ln() {
        return this.LP;
    }

    public final com.tachikoma.lottie.model.a.b lo() {
        return this.LQ;
    }

    public final l lp() {
        return this.LR;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new p(gVar, aVar, this);
    }
}
