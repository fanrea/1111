package com.kwad.lottie.a.a;

import android.graphics.Path;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p implements l, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private boolean blE;
    private final Path blk = new Path();
    private r blx;
    private final com.kwad.lottie.a.b.a<?, Path> bmf;
    private final String name;

    public p(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.bjz = fVar;
        com.kwad.lottie.a.b.a<com.kwad.lottie.model.content.h, Path> aVarRj = kVar.RW().Rj();
        this.bmf = aVarRj;
        aVar.a(aVarRj);
        aVarRj.b(this);
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        invalidate();
    }

    private void invalidate() {
        this.blE = false;
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.QI() == ShapeTrimPath.Type.Simultaneously) {
                    this.blx = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        if (this.blE) {
            return this.blk;
        }
        this.blk.reset();
        this.blk.set(this.bmf.getValue());
        this.blk.setFillType(Path.FillType.EVEN_ODD);
        com.kwad.lottie.d.f.a(this.blk, this.blx);
        this.blE = true;
        return this.blk;
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }
}
