package com.tachikoma.lottie.a.b;

import android.graphics.Path;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l extends a<com.tachikoma.lottie.model.content.h, Path> {
    private final com.tachikoma.lottie.model.content.h JX;
    private final Path JY;

    public l(List<com.tachikoma.lottie.e.a<com.tachikoma.lottie.model.content.h>> list) {
        super(list);
        this.JX = new com.tachikoma.lottie.model.content.h();
        this.JY = new Path();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Path a(com.tachikoma.lottie.e.a<com.tachikoma.lottie.model.content.h> aVar, float f) {
        this.JX.a(aVar.NG, aVar.NH, f);
        com.tachikoma.lottie.d.e.a(this.JX, this.JY);
        return this.JY;
    }
}
